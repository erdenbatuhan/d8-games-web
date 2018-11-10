package com.d8games.web.services.service;

import com.d8games.web.services.model.dto.ContactCardDto;
import com.d8games.web.services.model.dto.DashboardCardDto;
import com.d8games.web.services.model.dto.EmployeeCardDto;
import com.d8games.web.services.model.entity.Employee;
import com.d8games.web.services.repository.EmployeeRepository;
import com.d8games.web.services.config.ConfigManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@SuppressWarnings("unused")
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public Employee getById(String id) {
        return employeeRepository.getEmployeeById(id);
    }

    public Employee getByMobilePhoneId(String mobilePhoneId) {
        return employeeRepository.getEmployeeByMobilePhoneId(mobilePhoneId);
    }

    public String getEmployeeIdByMobilePhoneId(String mobilePhoneId) {
        return employeeRepository.getEmployeeIdByMobilePhoneId(mobilePhoneId);
    }

    public List<DashboardCardDto> getDashboardCardDtoList() {
        return employeeRepository.getDashboardCardDtoList();
    }

    public List<ContactCardDto> getContactCardDtoList() {
        return employeeRepository.getContactCardDtoList(ConfigManager.getContactDepartmentName());
    }

    public EmployeeCardDto getEmployeeCardDto(String employeeId) {
        return employeeRepository.getEmployeeCardDto(employeeId);
    }

    public void save(Employee employee) {
        employeeRepository.save(employee);
    }
}
