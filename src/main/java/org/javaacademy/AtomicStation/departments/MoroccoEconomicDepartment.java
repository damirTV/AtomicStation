package org.javaacademy.AtomicStation.departments;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;

@Profile("morocco")
@Component
public class MoroccoEconomicDepartment extends EconomicDepartment {
    @Value("${country.baseRate}")
    private double baseRate;
    @Value("${country.limit}")
    private double step;

    @Override
    public BigDecimal computeYearIncomes(long countElectricity) {
        BigDecimal rate = new BigDecimal(baseRate);
        if (countElectricity <= step) {
            return rate.multiply(BigDecimal.valueOf(countElectricity));
        }
        return rate.multiply(BigDecimal.valueOf(step))
                .add(BigDecimal.valueOf(countElectricity - step)
                        .multiply(BigDecimal.valueOf(6)));
    }
}
