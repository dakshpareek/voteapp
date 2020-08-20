package com.app.voteapp.repository;

import com.app.voteapp.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface voteRepo extends JpaRepository<Vote,Long> {

    Optional<Vote> findByVoteKey(String key_id);
}
