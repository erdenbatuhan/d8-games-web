package com.d8games.web.services.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties({
        "officeHoursNeededPerMonth", "homeHoursNeededPerMonth",
        "startDate", "endDate",
        "salaryPerHour", "overtimeSalaryPerHour"
})
public class MonthlySummaryDto {

    private double officeHoursNeededPerMonth;
    private double homeHoursNeededPerMonth;
    private String startDate;
    private String endDate;
    private double salaryPerHour;
    private double overtimeSalaryPerHour;

    private String interval;
    private double officeHoursCompleted;
    private double homeHoursCompleted;
    private double excusedHoursUsed;
    private double officeHoursLeft;
    private double homeHoursLeft;
    private double overtimeHoursCompleted;
    private double totalCompleted;
    private double totalLeft;
    private double currentSalary;

    public MonthlySummaryDto(List<WeeklySummaryDto> weeklySummaryDtoList) {
        fetchFromWeeklySummaries(weeklySummaryDtoList);

        interval = startDate + " - " + endDate;

        double officeHoursCompletedWithExcused = officeHoursCompleted + excusedHoursUsed;

        officeHoursLeft = getHoursLeft(officeHoursCompletedWithExcused, officeHoursNeededPerMonth);
        homeHoursLeft = getHoursLeft(homeHoursCompleted, homeHoursNeededPerMonth);
        overtimeHoursCompleted = getHoursExtra(
                officeHoursCompletedWithExcused + homeHoursCompleted,
                officeHoursNeededPerMonth + homeHoursNeededPerMonth
        );

        totalCompleted = officeHoursCompletedWithExcused + homeHoursCompleted;
        totalLeft = officeHoursLeft + homeHoursLeft;

        currentSalary = (totalCompleted - overtimeHoursCompleted) * salaryPerHour +
                overtimeHoursCompleted * overtimeSalaryPerHour;
        currentSalary = (currentSalary > 0) ? currentSalary : 0;
    }

    private void fetchFromWeeklySummaries(List<WeeklySummaryDto> weeklySummaryDtoList) {
        for (WeeklySummaryDto weeklySummaryDto : weeklySummaryDtoList) {
            if (endDate == null)
                endDate = weeklySummaryDto.getEndDate();

            officeHoursNeededPerMonth += weeklySummaryDto.getOfficeHoursNeededPerWeek();
            homeHoursNeededPerMonth += weeklySummaryDto.getHomeHoursNeededPerWeek();

            officeHoursCompleted += weeklySummaryDto.getOfficeHoursCompleted();
            homeHoursCompleted += weeklySummaryDto.getHomeHoursCompleted();
            excusedHoursUsed += weeklySummaryDto.getExcusedHoursUsed();

            salaryPerHour = weeklySummaryDto.getSalaryPerHour();
            overtimeSalaryPerHour = weeklySummaryDto.getOvertimeSalaryPerHour();

            startDate = weeklySummaryDto.getStartDate();
        }
    }

    private double getHoursLeft(double hoursCompleted, double hoursNeeded) {
        double hoursLeft = hoursNeeded - hoursCompleted;
        return (hoursLeft > 0) ? hoursLeft : 0;
    }

    private double getHoursExtra(double hoursCompleted, double hoursNeeded) {
        double hoursExtra = hoursCompleted - hoursNeeded;
        return (hoursExtra > 0) ? hoursExtra : 0;
    }
}
