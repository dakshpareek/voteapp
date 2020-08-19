package com.app.voteapp.repository;

import com.app.voteapp.entity.Site;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface siteRepo extends JpaRepository<Site,Long> {
    Optional<Site> findById(long id);
}
