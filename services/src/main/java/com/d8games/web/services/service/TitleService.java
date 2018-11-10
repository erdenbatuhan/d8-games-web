package com.d8games.web.services.service;

import com.d8games.web.services.model.entity.Title;
import com.d8games.web.services.repository.TitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@SuppressWarnings("unused")
public class TitleService {

    @Autowired
    private TitleRepository titleRepository;

    public List<Title> getAll() {
        return titleRepository.findAll();
    }

    public Title getById(String id) {
        return titleRepository.getTitleById(id);
    }

    public void save(Title title) {
        titleRepository.save(title);
    }
}
