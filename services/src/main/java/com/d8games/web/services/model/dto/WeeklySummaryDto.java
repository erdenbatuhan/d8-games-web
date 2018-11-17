package com.d8games.web.services.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties({
        "officeHoursNeededPerWeek", "homeHoursNeededPerWeek",
        "startDate", "endDate",
        "salaryPerHour", "overtimeSalaryPerHour"
})
public class WeeklySummaryDto {

    private double officeHoursNeededPerWeek;
    private double homeHoursNeededPerWeek;
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

    public WeeklySummaryDto(String startDate, String endDate, double officeHoursCompleted, double homeHoursCompleted,
                            double excusedHoursUsed, final double officeHoursNeededPerMonth,
                            final double homeHoursNeededPerMonth, final double salaryPerHour,
                            final double overtimeSalaryPerHour) {
        officeHoursNeededPerWeek = officeHoursNeededPerMonth / 4;
        homeHoursNeededPerWeek = homeHoursNeededPerMonth / 4;

        this.startDate = startDate;
        this.endDate = endDate;

        interval = startDate + " - " + endDate;

        this.officeHoursCompleted = officeHoursCompleted;
        this.homeHoursCompleted = homeHoursCompleted;
        this.excusedHoursUsed = excusedHoursUsed;

        double officeHoursCompletedWithExcused = officeHoursCompleted + excusedHoursUsed;

        officeHoursLeft = getHoursLeft(officeHoursCompletedWithExcused, officeHoursNeededPerWeek);
        homeHoursLeft = getHoursLeft(homeHoursCompleted, homeHoursNeededPerWeek);
        overtimeHoursCompleted = getHoursExtra(
                officeHoursCompletedWithExcused + homeHoursCompleted,
                officeHoursNeededPerWeek + homeHoursNeededPerWeek
        );

        totalCompleted = officeHoursCompletedWithExcused + homeHoursCompleted;
        totalLeft = officeHoursLeft + homeHoursLeft;

        this.salaryPerHour = salaryPerHour;
        this.overtimeSalaryPerHour = overtimeSalaryPerHour;
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
