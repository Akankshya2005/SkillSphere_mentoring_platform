package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.MenteeResponseDTO;
import com.example.demo.dto.MenteeRegistrationRequest;
import com.example.demo.service.MenteeService;

@RestController
@RequestMapping("/api/mentees")
public class MenteeController {

    private final MenteeService menteeService;

    public MenteeController(MenteeService menteeService) {
        this.menteeService = menteeService;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public MenteeResponseDTO registerMentee(
            @RequestBody MenteeRegistrationRequest request) {

        return menteeService.registerMentee(request);
    }
}