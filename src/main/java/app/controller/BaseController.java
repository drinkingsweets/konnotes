package app.controller;

import app.config.JteConfig;
import app.dto.BuildRegisterPage;
import app.model.User;
import app.repository.UserRepository;
import gg.jte.TemplateEngine;
import gg.jte.output.StringOutput;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class BaseController {
    @Autowired
    JteConfig jteConfig;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public void loginShow(HttpServletResponse response) throws IOException {
        StringOutput output = new StringOutput();
        jteConfig.getTemplateEngine().render("layout/login.jte", Map.of("username", "", "errors",
                new ArrayList<>()), output);

        response.setContentType("text/html");
        response.getWriter().write(output.toString());
    }

    @GetMapping("/register")
    public void registerShow(HttpServletResponse response) throws IOException {
        StringOutput output = new StringOutput();

        jteConfig.getTemplateEngine().render("layout/register.jte", Map.of("username", "", "errors",
                new ArrayList<>()), output);

        response.setContentType("text/html");
        response.getWriter().write(output.toString());
    }
    @PostMapping("/perform_register")
    public void registerPerform(HttpServletResponse response, @RequestParam String username,
                                @RequestParam String password, @RequestParam String passwordConfirmation) throws IOException {
        boolean isUnique = userRepository.findByUsername(username).isEmpty();
        if (password.equals(passwordConfirmation) && isUnique) {
            User user = new User();
            user.setUsername(username);
            user.setPasswordDigest(passwordEncoder.encode(password));
            userRepository.save(user);
            response.sendRedirect("/login");
        }
        else {
            List<String> errors = new ArrayList<>();
            if (!isUnique) errors.add("This username is taken");
            if (!password.equals(passwordConfirmation)) errors.add("Passwords don't match");


            StringOutput output = new StringOutput();
            jteConfig.getTemplateEngine().render("layout/register.jte", Map.of("username", username, "errors",
                    errors), output);

            response.setContentType("text/html");
            response.getWriter().write(output.toString());
        }

    }
    @PostMapping("/perform_login")
    public void performLogin(HttpServletResponse response,
                         @RequestParam String username, @RequestParam String password) throws IOException {
        Optional<User> user = userRepository.findByUsername(username);

        // Check if the user exists and if the password matches
        if (user.isPresent() && passwordEncoder.matches(password, user.get().getPassword())) {
            System.out.println("success");
            response.sendRedirect("/notes");
        } else {
            // User not found or invalid password
            List<String> errors = new ArrayList<>();

            if (user.isEmpty()) {
                errors.add("User doesn't exist");
            } else if (!passwordEncoder.matches(password, user.get().getPassword())) {
                errors.add("Invalid password");
            }

            StringOutput output = new StringOutput();
            jteConfig.getTemplateEngine().render("layout/login.jte", Map.of("username", username,
                    "errors", errors), output);

            response.setContentType("text/html");
            response.getWriter().write(output.toString());
        }
    }

}
