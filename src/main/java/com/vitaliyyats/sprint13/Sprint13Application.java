package com.vitaliyyats.sprint13;

import com.vitaliyyats.sprint13.entity.*;
import com.vitaliyyats.sprint13.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;
import java.time.LocalDate;

@SpringBootApplication
public class Sprint13Application implements CommandLineRunner {
    private UserService userService;
    private MarathonService marathonService;
    private SprintService sprintService;
    private TaskService taskService;
    private ProgressService progressService;

    @Autowired
    public Sprint13Application(UserService userService, MarathonService marathonService,
                               SprintService sprintService, TaskService taskService, ProgressService progressService) {
        this.userService = userService;
        this.marathonService = marathonService;
        this.sprintService = sprintService;
        this.taskService = taskService;
        this.progressService = progressService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Sprint13Application.class, args);
    }

    @Transactional
    public void run(String... arg) throws Exception {

    }

    

}
