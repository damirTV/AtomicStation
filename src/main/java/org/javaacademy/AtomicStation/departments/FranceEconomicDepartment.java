package org.javaacademy.AtomicStation.departments;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;

@Profile("france")
@Component
public class FranceEconomicDepartment extends EconomicDepartment{
    @Value("${country.baserate}")
    private double baseRate;
    @Value("${country.discount}")
    private double discount;
    @Value("${country.limit}")
    private long step;

    @Override
    public BigDecimal computeYearIncomes(long countElectricity) {
        BigDecimal realState = new BigDecimal(baseRate); // При каждом вызове методе скидка сбрасывается
        BigDecimal income = BigDecimal.ZERO;
        if (countElectricity < step) {
            return realState.multiply(BigDecimal.valueOf(countElectricity));
        }
        for (long i = step; i <= countElectricity; i += step) {
            income = income.add(realState.multiply(BigDecimal.valueOf(step)));
            if (i % step == 0) {
                realState = realState.multiply(BigDecimal.valueOf(discount));
            }
        }
        return income;
    }

}

