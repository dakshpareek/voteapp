package com.app.voteapp.controller;

import com.app.voteapp.dto.userDTO;
import com.app.voteapp.dto.voteDTO;
import com.app.voteapp.service.VoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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


    @GetMapping("/vote/{vote_id}")
    public ResponseEntity viewVote(@PathVariable long vote_id)
    {
        log.info("In viewVote controller");

        ResponseEntity responseEntity = new ResponseEntity(voteService.viewVote(vote_id), HttpStatus.OK);

        log.info("In viewVote controller");
        return responseEntity;
    }

    @PostMapping("/vote")
    public ResponseEntity doVote(@Valid @RequestBody voteDTO voteDTO)
    {

        log.info("In doVote controller");

        ResponseEntity responseEntity = new ResponseEntity(voteService.doVote(voteDTO), HttpStatus.OK);

        log.info("Exiting doVote controller");
        return responseEntity;
    }

    @GetMapping("/vote/callback")
    public ResponseEntity callback(@RequestParam(required = true) String uri)
    {
        log.info("In callback controller");

        voteService.callback(uri);

        ResponseEntity responseEntity = new ResponseEntity(HttpStatus.OK);

        log.info("In callback controller");
        return responseEntity;
    }

}
