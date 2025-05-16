package com.ActuatorImpl.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ActuatorImpl.Entities.User;
import com.ActuatorImpl.Services.UserService;

import jakarta.servlet.http.HttpServletRequest;

@Controller 
@RequestMapping("/users") 
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public Object getStudents(HttpServletRequest request, Model model) {
        List<User> students = service.findAll();

        String acceptHeader = request.getHeader("Accept");
        if (acceptHeader != null && acceptHeader.contains("application/json")) {
            return ResponseEntity.ok(students); // JSON for Postman/API
        } else {
            model.addAttribute("users", students);
            model.addAttribute("user", new User());
            return "users"; 
        }
    }

    @PostMapping
    public Object addStudent(HttpServletRequest request,
                             @RequestBody(required = false) User userFromJson,
                             @ModelAttribute User userFromForm,
                             Model model) {
        String acceptHeader = request.getHeader("Accept");

        if (acceptHeader != null && acceptHeader.contains("application/json")) {
            // JSON request
            User saved = service.save(userFromJson);
            return ResponseEntity.ok(saved);
        } else {
            // HTML form submission
            service.save(userFromForm);
            return "redirect:/users";
        }
    }
}
