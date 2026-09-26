package com.example.demo.service;



import org.springframework.stereotype.Service;

import com.example.demo.dto.MenteeRegistrationRequest;
import com.example.demo.entity.Mentee;
import com.example.demo.repository.MenteeRepository;
import com.example.demo.dto.MenteeResponseDTO;
import com.example.demo.exception.EmailAlreadyExistsException;

@Service
public class MenteeService {

    private final MenteeRepository menteeRepository;

    public MenteeService(MenteeRepository menteeRepository) {
        this.menteeRepository = menteeRepository;
    }

    public MenteeResponseDTO registerMentee(MenteeRegistrationRequest request) {
    	if (menteeRepository.findByEmail(request.getEmail()).isPresent()) {
    	    throw new EmailAlreadyExistsException(
    	            "An account with this email already exists"
    	    );
    	}

    	 Mentee mentee = new Mentee();

    	    mentee.setFullName(request.getFullName());
    	    mentee.setEmail(request.getEmail());
    	    mentee.setPassword(request.getPassword());

    	    mentee.setRole("STUDENT");

    	    mentee.setDepartment(request.getDepartment());
    	    mentee.setYear(request.getYear());
    	    mentee.setAbout(request.getAbout());
    	    mentee.setProfilePhoto(request.getProfilePhoto());

    	    Mentee savedMentee = menteeRepository.save(mentee);

    	    MenteeResponseDTO response = new MenteeResponseDTO();

    	    response.setMenteeId(savedMentee.getMenteeId());
    	    response.setFullName(savedMentee.getFullName());
    	    response.setEmail(savedMentee.getEmail());
    	    response.setRole(savedMentee.getRole());
    	    response.setDepartment(savedMentee.getDepartment());
    	    response.setYear(savedMentee.getYear());
    	    response.setAbout(savedMentee.getAbout());
    	    response.setProfilePhoto(savedMentee.getProfilePhoto());

    	    return response;
    }
}
