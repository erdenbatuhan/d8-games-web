package com.d8games.web.services.controller;

import com.d8games.web.services.model.entity.Title;
import com.d8games.web.services.service.DepartmentService;
import com.d8games.web.services.service.TitleService;
import com.d8games.web.services.service.WorkInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services/controller/title")
public class TitleController {

    @Autowired
    TitleService titleService;

    @Autowired
    WorkInfoService workInfoService;

    @Autowired
    DepartmentService departmentService;

    @GetMapping(value = "/getAll")
    public List<Title> getAll() {
        return titleService.getAll();
    }

    @GetMapping(value = "/getById")
    public Title getById(@RequestParam String id) {
        return titleService.getById(id);
    }

    @PutMapping(value = "/save")
    public HttpStatus save(@RequestParam String titleName, @RequestParam String workInfoId,
                           @RequestParam String titleDepartmentId) {
        Title title = new Title();

        title.setTitleName(titleName);
        title.setTitleWorkInfo(workInfoService.getById(workInfoId));
        title.setTitleDepartment(departmentService.getById(titleDepartmentId));

        titleService.save(title);
        return HttpStatus.OK;
    }
}
