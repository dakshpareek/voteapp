package com.app.voteapp.service;

import com.app.voteapp.dto.voteDTO;
import com.app.voteapp.entity.Site;
import com.app.voteapp.entity.Vote;
import com.app.voteapp.repository.siteRepo;
import com.app.voteapp.repository.voteRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;
import java.util.Random;

@Service
@Slf4j
public class VoteService {

    private voteRepo voteRepo;
    private siteRepo siteRepo;

    public VoteService(voteRepo voteRepo,siteRepo siteRepo) {
        this.voteRepo = voteRepo;
        this.siteRepo = siteRepo;
    }

    public String generateVoteKey() {
        log.info("Generating VoteKey");
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();
        //System.out.println(generatedString);
        return generatedString;
    }

    public Object doVote(voteDTO voteDTO) {
        log.info("In doVote service");

        //CHECK SITE ID
        Optional<Site> siteOptional = siteRepo.findById(voteDTO.getSiteId());
        if(siteOptional.isEmpty())
        {
            //THROW ERROR
            log.info("Site id does not exists");
        }

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()) .getRequest();
        String ip = request.getRemoteAddr();

        Vote vote = new Vote();
        vote.setUserName(voteDTO.getUserName());
        vote.setIpAddress(voteDTO.getIpAddress());
        vote.setSite(siteOptional.get());
        //GENERATE VOTE KEY
        vote.setVoteKey(generateVoteKey());
        vote.setIpAddress(ip);

        voteRepo.save(vote);
        log.info("Vote Saved in DB");


        log.info("Exiting doVote service");

        //CALLBACK RELATED STUFF HERE

        return vote;
    }
}
