package com.d8games.web.services.repository;

import com.d8games.web.services.model.dto.VoucherItemDto;
import com.d8games.web.services.model.entity.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoucherRepository extends JpaRepository<Voucher, String> {

    List<Voucher> getAllByEmployeeIdOrderByActualDateDesc(String employeeId);

    Voucher getVoucherById(String id);

    @Query(
    "SELECT new com.d8games.web.services.model.dto.VoucherItemDto(v.date, v.day, v.hour, v.type, v.location) " +
    "FROM Voucher v " +
    "WHERE v.employee.id = :employeeId " +
    "ORDER BY v.actualDate DESC")
    List<VoucherItemDto> getVoucherItemDtoList(@Param("employeeId") String employeeId);
}
