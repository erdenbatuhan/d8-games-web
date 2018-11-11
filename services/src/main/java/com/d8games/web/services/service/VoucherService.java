package com.d8games.web.services.service;

import com.d8games.web.services.config.ConfigManager;
import com.d8games.web.services.model.dto.VoucherItemDto;
import com.d8games.web.services.model.entity.Voucher;
import com.d8games.web.services.repository.VoucherRepository;
import com.d8games.web.services.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class VoucherService {

    @Autowired
    private VoucherRepository voucherRepository;

    @Autowired
    private EmployeeService employeeService;

    public List<Voucher> getAllByEmployeeId(String employeeId) {
        return voucherRepository.getAllByEmployeeIdOrderByActualDateDesc(employeeId);
    }

    public Voucher getById(String id) {
        return voucherRepository.getVoucherById(id);
    }

    public String add(String type, String ip, String employeeId) {
        final String officeIp = ConfigManager.getOfficeIp();
        final String locationOffice = ConfigManager.getLocationOffice();
        final String locationHome = ConfigManager.getLocationHome();

        Voucher voucher = new Voucher();

        voucher.setType(type);
        voucher.setLocation((officeIp.equals(ip)) ? locationOffice : locationHome);
        voucher.setEmployee(employeeService.getById(employeeId));

        setDates(voucher);

        voucherRepository.save(voucher);
        return voucher.getId();
    }

    private void setDates(Voucher voucher) {
        DateUtil dateUtil = new DateUtil(new Date());

        final Date actualDate = dateUtil.getActualDate();
        final String date = dateUtil.getDate();
        final String day = dateUtil.getDay();
        final String hour = dateUtil.getHour();

        voucher.setActualDate(actualDate);
        voucher.setDate(date);
        voucher.setDay(day);
        voucher.setHour(hour);
    }

    public List<VoucherItemDto> getVoucherItemDtoList(String employeeId) {
        return voucherRepository.getVoucherItemDtoList(employeeId);
    }
}
