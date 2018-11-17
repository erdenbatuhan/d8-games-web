package com.d8games.web.services.controller;

import com.d8games.web.services.model.entity.Title;
import com.d8games.web.services.service.DepartmentService;
import com.d8games.web.services.service.TitleService;
import com.d8games.web.services.service.JobInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services/controller/title")
public class TitleController {

    @Autowired
    private TitleService titleService;

    @Autowired
    private JobInfoService jobInfoService;

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public List<Title> getAll() {
        return titleService.getAll();
    }

    @GetMapping(value = "/get")
    public Title getById(@RequestParam String id) {
        return titleService.getById(id);
    }

    @PutMapping(value = "/save")
    public String save(@RequestParam String name, @RequestParam String jobInfoId, @RequestParam String departmentId) {
        Title title = new Title();

        title.setName(name);
        title.setJobInfo(jobInfoService.getById(jobInfoId));
        title.setDepartment(departmentService.getById(departmentId));

        titleService.save(title);
        return title.getId();
    }
}
