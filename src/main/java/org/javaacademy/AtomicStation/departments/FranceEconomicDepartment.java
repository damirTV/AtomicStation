package org.javaacademy.AtomicStation.departments;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;

@Configuration
@Profile("france")
@Component
public class FranceEconomicDepartment extends EconomicDepartment{
    @Value("${countrySettings.baseRate}")
    double baseRate;
    @Value("${countrySettings.discount}")
    double discount;
    @Value("${countrySettings.limit}")
    int limit;

    @Override
    public BigDecimal computeYearIncomes(long countElectricity) {
        double realState = baseRate; // При каждом вызове методе скидка сбрасывается
        double income = 0;
        for (long i = 1; i <= countElectricity; i++) {
            income += realState;
            if (i % limit == 0) {
                realState = realState * discount;
            }
        }
        return new BigDecimal(income);
    }
}
