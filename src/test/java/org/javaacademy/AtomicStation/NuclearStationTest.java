package org.javaacademy.AtomicStation;

import org.javaacademy.AtomicStation.departments.ReactorDepartment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NuclearStationTest {
    @Autowired
    private NuclearStation nuclearStation;
    @Autowired
    private ReactorDepartment reactorDepartment;

    @Test
    @DisplayName("Тест успешного запуска атомной станции")
    public void startSuccess() {
        Assertions.assertDoesNotThrow(() -> nuclearStation.start(0));
        Assertions.assertDoesNotThrow(() -> nuclearStation.start(3));
    }

    @Test
    @DisplayName("Тест на успешное добавление числа инцидентов")
    public void incrementAccident() {
        Assertions.assertDoesNotThrow(() -> nuclearStation.incrementAccident(10));
    }

    @Test
    @DisplayName("Тест на обработку ошибки запуска запущенного реактора")
    public void startYearFail() {
        reactorDepartment.run();
        Assertions.assertDoesNotThrow(() -> nuclearStation.start(1));
    }
}
