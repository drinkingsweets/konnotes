package app.controller;

import app.config.JteConfig;
import app.repository.TaskRepository;
import app.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@EnableWebSecurity
@RequestMapping("/tasks")
public class TaskController {

    private final UserUtils userUtils;
    private final JteConfig jteConfig;

    @Autowired
    private TaskRepository taskRepository;

    public TaskController(UserUtils userUtils, JteConfig jteConfig) {
        this.userUtils = userUtils;
        this.jteConfig = jteConfig;
    }


}
