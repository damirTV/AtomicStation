package org.javaacademy.AtomicStation.departments;

import org.javaacademy.AtomicStation.exceptions.ReactorWorkException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ReactorDepartmentTest {
    @Autowired
    private ReactorDepartment reactorDepartment;

    @Test
    @DisplayName("Проверка на ошибку при остановке остановленного реактора")
    public void stopFail() {
        ReactorWorkException thrown = Assertions.assertThrows(ReactorWorkException.class,
                () -> reactorDepartment.stop());
        Assertions.assertEquals("Реактор уже выключен", thrown.getMessage());
    }

    @Test
    @DisplayName("Проверка на успешную остановку работающего реактора")
    public void stopSuccess() {
        Assertions.assertDoesNotThrow(() -> reactorDepartment.run());
        Assertions.assertDoesNotThrow(() -> reactorDepartment.stop());
    }
}
