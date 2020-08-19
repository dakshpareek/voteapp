package com.app.voteapp.controller;

import com.app.voteapp.dto.userDTO;
import com.app.voteapp.service.VoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Slf4j
@RequestMapping("/api")
@Validated
public class VoteController {


    private VoteService voteService;

    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }

    @PostMapping("/user")
    public ResponseEntity createUser(@Valid @RequestBody userDTO userDTO)
    {
        log.info("In createUser controller");

        ResponseEntity responseEntity = new ResponseEntity(voteService.getAllCourses(), HttpStatus.OK);

        log.info("Exiting createUser controller");
        return responseEntity;
    }

}
