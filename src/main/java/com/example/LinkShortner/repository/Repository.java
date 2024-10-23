package com.example.LinkShortner.repository;

import com.example.LinkShortner.entity.Url;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Url,Long> {
    Optional<Url> findByurlCode(String urlCode);
}
