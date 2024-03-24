package org.javaacademy.AtomicStation.departments;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FranceEconomicDepartmentTest {
    FranceEconomicDepartment franceEconomicDepartment = new FranceEconomicDepartment();

    @Test
    @DisplayName("Тест на успешный расчет годового дохода")
    public void computeYearIncomesSuccess() {
        System.out.println(franceEconomicDepartment.computeYearIncomes(3_000_000_000L));
    }
}
