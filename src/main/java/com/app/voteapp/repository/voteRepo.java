package com.app.voteapp.repository;

import com.app.voteapp.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface voteRepo extends JpaRepository<Vote,Long> {

}
