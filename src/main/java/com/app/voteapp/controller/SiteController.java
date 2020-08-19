package com.app.voteapp.controller;

import com.app.voteapp.dto.siteDTO;
import com.app.voteapp.repository.siteRepo;
import com.app.voteapp.service.SiteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@Slf4j
@RequestMapping("/api")
@Validated
public class SiteController {

    private SiteService siteService;

    public SiteController(SiteService siteService) {
        this.siteService = siteService;
    }

    @PostMapping("/site")
    public ResponseEntity addSite(@Valid @RequestBody siteDTO siteDTO)
    {
        log.info("In addSite controller");

        ResponseEntity responseEntity = new ResponseEntity(siteService.addSite(siteDTO), HttpStatus.OK);

        log.info("In addSite controller");
        return responseEntity;
    }

    @PatchMapping("/site/{site_id}")
    public ResponseEntity updateVisibleStatus(@PathVariable long site_id)
    {
        log.info("In updateVisibleStatus controller");

        ResponseEntity responseEntity = new ResponseEntity(siteService.updateVisibleStatus(site_id), HttpStatus.OK);

        log.info("Exiting updateVisibleStatus controller");
        return responseEntity;
    }

    @PutMapping("/site")
    public ResponseEntity updateSite(@Valid @RequestBody siteDTO siteDTO)
    {
        log.info("In updateSite controller");

        ResponseEntity responseEntity = new ResponseEntity(siteService.updateSite(siteDTO), HttpStatus.OK);

        log.info("In updateSite controller");
        return responseEntity;
    }

}
