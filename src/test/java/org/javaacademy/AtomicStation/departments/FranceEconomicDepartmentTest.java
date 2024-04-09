package org.javaacademy.AtomicStation.departments;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import java.math.BigDecimal;

@SpringBootTest
@ActiveProfiles("france")
public class FranceEconomicDepartmentTest {
    @Autowired
    private FranceEconomicDepartment franceEconomicDepartment;

    @Test
    @DisplayName("Тест на успешный расчет дохода за год до 1 млрд киловатт/часов")
    public void computeYearIncomesLower1BSuccess() {
        BigDecimal result = new BigDecimal("450000000.0");
        Assertions.assertEquals(result,
                franceEconomicDepartment.computeYearIncomes(900_000_000L));
    }

    @Test
    @DisplayName("Тест на успешный расчет дохода за год свыше 1 млрд киловатт/часов")
    public void computeYearIncomesHigher1BSuccess() {
        BigDecimal result = new BigDecimal("995000000.000");
        Assertions.assertEquals(result,
                franceEconomicDepartment.computeYearIncomes(2_000_000_000L));
    }
}

