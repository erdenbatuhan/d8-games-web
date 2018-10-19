package com.d8games.web.services.service;

import com.d8games.web.services.model.entity.Title;
import com.d8games.web.services.repository.TitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TitleService {

    @Autowired
    TitleRepository titleRepository;

    public List<Title> getAllTitles() {
        return titleRepository.findAll();
    }

    public Title getTitleByTitleId(String titleId) {
        return titleRepository.getTitleByTitleId(titleId);
    }

    public void saveTitle(Title title) {
        titleRepository.save(title);
    }
}
