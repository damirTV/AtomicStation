package org.javaacademy.AtomicStation.departments;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("morocco")
public class MoroccoEconomicDepartmentTest {
    MoroccoEconomicDepartment moroccoEconomicDepartment = new MoroccoEconomicDepartment();

    @Test
    @DisplayName("Тест на успешный расчет годового дохода")
    public void computeYearIncomesSuccess() {
        System.out.println(moroccoEconomicDepartment.computeYearIncomes(7_000_000_000L));
    }
}
