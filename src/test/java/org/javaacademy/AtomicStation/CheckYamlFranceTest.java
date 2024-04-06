package org.javaacademy.AtomicStation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("france")
public class CheckYamlFranceTest {
    @Value("${country.country}")
    private String country;
    @Value("${country.currency}")
    private String currency;
    @Value("${country.baserate}")
    private double baseRate;
    @Value("${country.discount}")
    private double discount;
    @Value("${country.limit}")
    private double limit;


    @Test
    @DisplayName("Проверка значений переменных из файла свойств")
    void countryIsCorrect() {
        Assertions.assertEquals(country, "France");
        Assertions.assertEquals(currency, "euro");
        Assertions.assertEquals(baseRate, 0.5);
        Assertions.assertEquals(discount, 0.99);
        Assertions.assertEquals(limit, 1_000_000_000);
    }
}
