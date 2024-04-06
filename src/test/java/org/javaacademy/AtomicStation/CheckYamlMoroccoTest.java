package org.javaacademy.AtomicStation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("morocco")
public class CheckYamlMoroccoTest {
    @Value("${country.country}")
    private String country;
    @Value("${country.currency}")
    private String currency;
    @Value("${country.baserate}")
    private double baseRate;
    @Value("${country.limit}")
    private double limit;


    @Test
    @DisplayName("Проверка значений переменных из файла свойств")
    void countryIsCorrect() {
        Assertions.assertEquals(country, "Morocco");
        Assertions.assertEquals(currency, "dirham");
        Assertions.assertEquals(baseRate, 5);
        Assertions.assertEquals(limit, 5_000_000_000L);
    }
}
