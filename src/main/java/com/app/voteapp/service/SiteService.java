package com.app.voteapp.service;

import com.app.voteapp.dto.siteDTO;
import com.app.voteapp.entity.Site;
import com.app.voteapp.repository.siteRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class SiteService {

    private siteRepo siteRepo;

    public SiteService(siteRepo siteRepo) {
        this.siteRepo = siteRepo;
    }

    public Object addSite(siteDTO siteDTO) {
        log.info("In addSite service");

        Site site = new Site();
        site.setTitle(siteDTO.getTitle());
        site.setUrl(siteDTO.getUrl());
        site.setVoteId(siteDTO.getVoteId());

        siteRepo.save(site);
        log.info("Site Added to DB");

        log.info("Exiting addSite service");
        return site;
    }

    public Object updateVisibleStatus(long site_id) {
        log.info("In updateVisibleStatus service");

        Optional<Site> siteOptional = siteRepo.findById(site_id);
        if(siteOptional.isEmpty())
        {
            //THROW ERROR
            log.info("Site id does not exists");
        }

        Site site = siteOptional.get();

        //XOR will reverse the status
        site.setVisible(site.getVisible() ^ 1 );
        siteRepo.save(site);
        log.info("Status Changed Successfully");

        log.info("In updateVisibleStatus service");
        return site;
    }

    public Object updateSite(siteDTO siteDTO) {
        log.info("In updateSite service ");

        //Check if site id exits in DTO
        if(siteDTO.getId() == 0)
        {
            //Throw Exception
            log.info("Site id not found");

        }

        Site site = siteRepo.findById(siteDTO.getId()).get();

        //Save DTO data to site object
        site.setTitle(siteDTO.getTitle());
        site.setVoteId(siteDTO.getVoteId());
        site.setUrl(siteDTO.getUrl());
        siteRepo.save(site);
        log.info("Site updated");

        log.info("In updateSite service");
        return site;
    }
}
