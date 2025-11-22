package com.example.URL.Shortner.Repo;

import com.example.URL.Shortner.Model.UrlModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UrlRepo extends JpaRepository <UrlModel,Long>{
    Optional<UrlModel> findByShortCode(String shortCode);
}
