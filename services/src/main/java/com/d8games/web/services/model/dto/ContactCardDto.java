package com.d8games.web.services.model.dto;

public class ContactCardDto {

    private String employeeFullName;
    private String employeeEmail;
    private String employeePhoneNumber;
    private String titleName;

    public ContactCardDto(String employeeName, String employeeSurname, String employeeEmail,
                          String employeePhoneNumber, String titleName) {
        setEmployeeFullName(employeeName, employeeSurname);

        this.employeeEmail = employeeEmail;
        this.employeePhoneNumber = employeePhoneNumber;
        this.titleName = titleName;
    }

    public String getEmployeeFullName() {
        return employeeFullName;
    }

    public void setEmployeeFullName(String employeeFullName) {
        this.employeeFullName = employeeFullName;
    }

    public void setEmployeeFullName(String employeeName, String employeeSurname) {
        this.employeeFullName = employeeName + " " + employeeSurname;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeePhoneNumber() {
        return employeePhoneNumber;
    }

    public void setEmployeePhoneNumber(String employeePhoneNumber) {
        this.employeePhoneNumber = employeePhoneNumber;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }
}
