package org.javaacademy.AtomicStation.departments;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;

@SpringBootTest
@ActiveProfiles("morocco")
public class MoroccoEconomicDepartmentTest {
    @Autowired
    private MoroccoEconomicDepartment moroccoEconomicDepartment;

    @Test
    @DisplayName("Тест на успешный расчет дохода за год до 5 млрд. киловатт/часов")
    public void computeYearIncomesLower5BSuccess() {
        BigDecimal result = new BigDecimal("20000000000");
        Assertions.assertEquals(result,
                moroccoEconomicDepartment.computeYearIncomes(4_000_000_000L));
    }
    @Test
    @DisplayName("Тест на успешный расчет дохода за год свыше 5 млрд. киловатт/часов")
    public void computeYearIncomesHigher5BSuccess() {
        BigDecimal result = new BigDecimal("55000000000");
        Assertions.assertEquals(result,
                moroccoEconomicDepartment.computeYearIncomes(10_000_000_000L));
    }
}
