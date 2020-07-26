package com.vitaliyyats.sprint13;

import com.vitaliyyats.sprint13.entity.*;
import com.vitaliyyats.sprint13.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Arrays;

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
        addStudents();
        addMentor();
        createMarathonAndSprints();
        createTasksAndProgress();
    }

    private void addStudents() {
        User st1 = new User();
        st1.setFirstName("Vitaliy");
        st1.setLastName("Yatsunskyi");
        st1.setEmail("vitaliyyats@gmail.com");
        st1.setRole(User.Role.TRAINEE);
        st1.setPassword("pass123");
        userService.createOrUpdateUser(st1);
        System.out.println("Student " + st1 + " added");

        User st2 = new User();
        st2.setFirstName("Ivan");
        st2.setLastName("Petriv");
        st2.setEmail("ivapetr@gmail.com");
        st2.setRole(User.Role.TRAINEE);
        st2.setPassword("newpass678");
        userService.createOrUpdateUser(st2);
        System.out.println("Student " + st2 + " added");
    }

    private void addMentor() {
        User mentor = new User();
        mentor.setFirstName("Yaroslav");
        mentor.setLastName("Harasym");
        mentor.setEmail("yarhar@gmail.com");
        mentor.setRole(User.Role.MENTOR);
        mentor.setPassword("strongpass999");
        userService.createOrUpdateUser(mentor);
        System.out.println("Mentor " + mentor + " added");
    }

    private void createMarathonAndSprints() {
        Marathon marathon = new Marathon();
        marathon.setTitle("Java Online Marathon");
        marathon = marathonService.createOrUpdate(marathon);

        Sprint sp1 = new Sprint();
        sp1.setTitle("Introduction To Spring. IoC");
        sp1.setStart(LocalDate.of(2020, 07, 20));
        sp1.setFinish(LocalDate.of(2020, 07, 22));
        sprintService.addSprintToMarathon(sp1, marathon);

        Sprint sp2 = new Sprint();
        sp2.setTitle("ORM. Hibernate with Spring");
        sp2.setStart(LocalDate.of(2020, 07, 23));
        sp2.setFinish(LocalDate.of(2020, 07, 25));
        sp2.setMarathon(marathon);
        sprintService.addSprintToMarathon(sp2, marathon);

        userService.addUserToMarathon(userService.getUserById(1l), marathon);
        userService.addUserToMarathon(userService.getUserById(2l), marathon);
        userService.addUserToMarathon(userService.getUserById(3l), marathon);
    }

    private void createTasksAndProgress() {
        Task task1 = new Task();
        task1.setTitle("task1");
        task1 = taskService.addTaskToSprint(task1, sprintService.getSprintById(1l));

        Task task2 = new Task();
        task2.setTitle("task2");
        task2 = taskService.addTaskToSprint(task2, sprintService.getSprintById(1l));

        Task task3 = new Task();
        task3.setTitle("task3");
        task3 = taskService.addTaskToSprint(task3, sprintService.getSprintById(2l));

        Task task4 = new Task();
        task4.setTitle("task4");
        task4 = taskService.addTaskToSprint(task4, sprintService.getSprintById(2l));

        progressService.addTaskForStudent(task1, userService.getUserById(1l));
        progressService.addTaskForStudent(task2, userService.getUserById(1l));

        progressService.addTaskForStudent(task3, userService.getUserById(2l));
        progressService.addTaskForStudent(task4, userService.getUserById(2l));
    }



}
