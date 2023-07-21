package org.sangmins.salesmanagement.domain.visit;

import lombok.Getter;
import org.sangmins.salesmanagement.global.MathUtils;
import org.sangmins.salesmanagement.domain.visit.utils.VisitUtils;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

@Getter
public class DailySales {
    private final List<Visit> dailyVisits;
    private final LocalDate date;
    private final DayOfWeek dayOfWeek;
    private final int totalSales;
    private final int countVisits;
    private final int averageCustomerUnitPrice;

    public DailySales(LocalDate date, List<Visit> dailyVisits) {
        this.dailyVisits = dailyVisits;
        this.date = date;
        this.dayOfWeek = date.getDayOfWeek();
        this.totalSales = VisitUtils.calculateTotalSales(dailyVisits);
        this.countVisits = dailyVisits.size();
        this.averageCustomerUnitPrice = countVisits != 0 ? MathUtils.roundTensPlace(totalSales, countVisits) : 0;
    }
}
