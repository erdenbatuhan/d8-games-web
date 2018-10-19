package com.d8games.web.services.controller;

import com.d8games.web.services.model.entity.Title;
import com.d8games.web.services.service.DepartmentService;
import com.d8games.web.services.service.TitleService;
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
    DepartmentService departmentService;

    @GetMapping(value = "/getAll")
    public List<Title> getAllTitles() {
        return titleService.getAllTitles();
    }

    @PutMapping(value = "/save")
    public HttpStatus saveTitle(@RequestParam String titleName, @RequestParam Double officeHoursNeededPerMonth,
                                @RequestParam Double homeHoursNeededPerMonth, @RequestParam Double salaryPerHour,
                                @RequestParam Double overtimeSalaryPerHour, @RequestParam String titleDepartmentId) {
        Title title = new Title();

        title.setTitleName(titleName);
        title.setOfficeHoursNeededPerMonth(officeHoursNeededPerMonth);
        title.setHomeHoursNeededPerMonth(homeHoursNeededPerMonth);
        title.setSalaryPerHour(salaryPerHour);
        title.setOvertimeSalaryPerHour(overtimeSalaryPerHour);
        title.setTitleDepartment(departmentService.getDepartmentByDepartmentId(titleDepartmentId));

        titleService.saveTitle(title);
        return HttpStatus.OK;
    }
}
