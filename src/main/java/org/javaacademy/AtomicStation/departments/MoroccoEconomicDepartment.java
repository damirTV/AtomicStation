package org.javaacademy.AtomicStation.departments;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;

@Configuration
@Profile("morocco")
@Component
public class MoroccoEconomicDepartment extends EconomicDepartment {
    @Value("${country.baseRate}")
    private double baseRate;
    @Value("${country.limit}")
    private double limit;

    @Override
    public BigDecimal computeYearIncomes(long countElectricity) {
        if (countElectricity <= limit) {
            return new BigDecimal(countElectricity * baseRate);
        }
        return new BigDecimal((limit * baseRate) + ((countElectricity - limit) * 6));

    }
}
