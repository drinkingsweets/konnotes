package app.controller;

import app.config.JteConfig;
import app.model.Note;
import app.model.User;
import app.repository.NoteRepository;
import app.utils.UserUtils;
import gg.jte.output.StringOutput;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@EnableWebSecurity
@RequestMapping("/notes")
public class NotesController {

    private final UserUtils userUtils;
    private final JteConfig jteConfig;

    @Autowired
    private NoteRepository noteRepository;


    public NotesController(UserUtils userUtils, JteConfig jteConfig) {
        this.userUtils = userUtils;
        this.jteConfig = jteConfig;
    }

    @GetMapping
    public void index(HttpServletResponse response) throws IOException {
        User user = userUtils.getCurrentUser();
        List<Note> notes = user.getNotes();
        List<String> titles = notes.stream()
                .map(Note::getTitle)
                .collect(Collectors.toList());

        // Extract contents
        List<String> contents = notes.stream()
                .map(Note::getContent)
                .collect(Collectors.toList());

        // Extract ids
        List<Long> ids = notes.stream()
                .map(Note::getId)
                .collect(Collectors.toList());

        List<LocalDate> updatedAt = notes.stream()
                .map(Note::getUpdatedAt)
                .collect(Collectors.toList());

        StringOutput output = new StringOutput();
        jteConfig.getTemplateEngine().render("layout/notes.jte", Map.of("username", user.getUsername(),
                "titles", titles, "ids", ids, "updatedAt", updatedAt), output);

         response.setContentType("text/html");
         response.getWriter().write(output.toString());
    }

    @GetMapping("/create")
    public void create(HttpServletResponse response, HttpServletRequest request) throws IOException {
        StringOutput output = new StringOutput();
        jteConfig.getTemplateEngine().render("layout/note.jte", Map.of("title", "",
                "content", ""), output);

         response.setContentType("text/html");
         response.setCharacterEncoding("UTF-8");
         request.setCharacterEncoding("UTF-8");
         response.getWriter().write(output.toString());
    }

    @PostMapping("/save")
    public void save(HttpServletResponse response,
                     @RequestParam String title, @RequestParam String content) throws IOException {
        Note note = new Note();
        note.setTitle(title);
        System.out.println("Before base:  " + title + " " + content);
        note.setContent(content);
        note.setAuthor(userUtils.getCurrentUser());
        noteRepository.save(note);
        response.sendRedirect("/notes");
    }

    @GetMapping("/{id}")
    public void show(HttpServletResponse response,
                     @PathVariable long id) throws IOException{
        Note note = noteRepository.findById(id).get();
        System.out.println("After base:  " + note.getTitle() + " " + note.getContent());
        StringOutput output = new StringOutput();
        jteConfig.getTemplateEngine().render("layout/edit.jte", Map.of("title", note.getTitle(),
                "content", note.getContent(), "id", id ), output);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.getWriter().write(output.toString());
    }

    @PostMapping("/{id}")
    public void edit(HttpServletResponse response,
                     @PathVariable long id,
                     @RequestParam String title,
                     @RequestParam String content) throws IOException {
        Note note = noteRepository.findById(id).get();
        note.setTitle(title);
        note.setContent(content);
        noteRepository.save(note);
        response.sendRedirect("/notes");
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
        return "redirect:/";
    }

    @GetMapping("/{id}/delete")
    public void showMenu(HttpServletResponse response, @PathVariable long id) throws IOException {
        noteRepository.deleteById(id);
        response.sendRedirect("/notes");
    }
}
