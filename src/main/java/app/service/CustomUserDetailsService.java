package app.service;

import exercise.exception.ResourceNotFoundException;
import app.mapper.UserMapper;
import app.model.User;
import app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

// BEGIN
@Service
public class CustomUserDetailsService implements UserDetailsManager {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Нужно добавить в репозиторий findByUsername
        var user = userRepository.findByUsername(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return user;
    }

    @Override
    public void createUser(UserDetails userData) {
        User user = new User();
        user.setUsername(userData.getUsername());
        user.setPasswordDigest(passwordEncoder.encode(userData.getPassword()));
        userRepository.save(user);
    }

    @Override
    public void updateUser(UserDetails user) {
        User found = userRepository.findByUsername(user.getUsername())
                .orElseThrow(() -> new ResourceNotFoundException("User with email " +
                        user.getUsername() + " not found"));

        found.setUsername(user.getUsername());
        found.setPasswordDigest(passwordEncoder.encode(user.getPassword()));
        userRepository.save(found);
    }

    @Override
    public void deleteUser(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User with email " +
                        username + " not found"));

        userRepository.delete(user);
    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {
        var currentUser = userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        if (!passwordEncoder.matches(oldPassword, currentUser.getPassword())) {
            throw new IllegalArgumentException("Old password is incorrect");
        }
        currentUser.setPasswordDigest(passwordEncoder.encode(newPassword));
        userRepository.save(currentUser);
    }

    @Override
    public boolean userExists(String username) {
        return userRepository.findByUsername(username).isPresent();
    }
}
// END
