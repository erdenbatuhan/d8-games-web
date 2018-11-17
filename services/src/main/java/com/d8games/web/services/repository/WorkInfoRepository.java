package com.d8games.web.services.repository;

import com.d8games.web.services.model.dto.WeeklySummaryDto;
import com.d8games.web.services.model.entity.Employee;
import com.d8games.web.services.model.entity.WorkInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface WorkInfoRepository extends JpaRepository<WorkInfo, String> {

    WorkInfo getWorkInfoById(String id);

    @Query(
    "SELECT workInfo.actualEndDate " +
    "FROM WorkInfo workInfo " +
    "ORDER BY workInfo.actualEndDate DESC")
    List<Date> getActualEndDates();

    @Query(
    "SELECT workInfo " +
    "FROM WorkInfo workInfo " +
    "WHERE workInfo.employee = :employee " +
    "AND workInfo.actualStartDate <= :currentDate " +
    "AND :currentDate <= workInfo.actualEndDate")
    WorkInfo getCurrentWorkInfo(@Param("currentDate") Date currentDate, @Param("employee") Employee employee);

    @Query(
    "SELECT new com.d8games.web.services.model.dto.WeeklySummaryDto(" +
            "w.startDate, w.endDate, w.officeHoursCompleted, w.homeHoursCompleted, w.excusedHoursUsed," +
            "j.officeHoursNeededPerMonth, j.homeHoursNeededPerMonth, j.salaryPerHour, j.overtimeSalaryPerHour) " +
    "FROM WorkInfo w " +
    "INNER JOIN Employee e ON w.employee = e " +
    "INNER JOIN Title t ON e.title = t " +
    "INNER JOIN JobInfo j ON t.jobInfo = j " +
    "WHERE e.id = :employeeId " +
    "AND w.actualStartDate <= :currentDate " +
    "AND :currentDate <= w.actualEndDate")
    WeeklySummaryDto getWeeklySummaryDto(@Param("currentDate") Date currentDate, @Param("employeeId") String employeeId);

    @Query(
    "SELECT new com.d8games.web.services.model.dto.WeeklySummaryDto(" +
            "w.startDate, w.endDate, w.officeHoursCompleted, w.homeHoursCompleted, w.excusedHoursUsed," +
            "j.officeHoursNeededPerMonth, j.homeHoursNeededPerMonth, j.salaryPerHour, j.overtimeSalaryPerHour) " +
    "FROM WorkInfo w " +
    "INNER JOIN Employee e ON w.employee = e " +
    "INNER JOIN Title t ON e.title = t " +
    "INNER JOIN JobInfo j ON t.jobInfo = j " +
    "WHERE e.id = :employeeId " +
    "ORDER BY w.actualEndDate DESC")
    List<WeeklySummaryDto> getWeeklySummaryDtoList(@Param("employeeId") String employeeId);
}
