package com.d8games.web.services.repository;

import com.d8games.web.services.model.entity.Title;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TitleRepository extends JpaRepository<Title, String> {

    Title getTitleById(String id);
}
