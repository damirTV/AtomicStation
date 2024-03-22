package org.javaacademy.AtomicStation.departments;

import org.javaacademy.AtomicStation.exceptions.NuclearFuelIsEmptyException;
import org.javaacademy.AtomicStation.exceptions.ReactorWorkException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ReactorDepartmentTest {
    SecurityDepartment securityDepartmentMock = Mockito.mock(SecurityDepartment.class);
    private final ReactorDepartment reactorDepartment = new ReactorDepartment(securityDepartmentMock);

    @Test
    @DisplayName("Тест запуска реактора при выключенном реакторе")
    public void runSuccess() {
        reactorDepartment.setIsWork(false);
        reactorDepartment.setRunCounter(10);
        Assertions.assertDoesNotThrow(reactorDepartment::run);
        Assertions.assertTrue(reactorDepartment.getIsWork());
    }

    @Test
    @DisplayName("Тест запуска реактора при включенном реакторе")
    public void runFail() {
        reactorDepartment.setIsWork(true);
        Assertions.assertThrows(ReactorWorkException.class, reactorDepartment::run);
    }

    @Test
    @DisplayName("Тест запуска реактора при отсутствии топлива в реакторе")
    public void fuelIsEmptySuccess() {
        reactorDepartment.setIsWork(false);
        reactorDepartment.setRunCounter(100);
        Assertions.assertThrows(NuclearFuelIsEmptyException.class, reactorDepartment::run);
    }

    @Test
    @DisplayName("Тест остановки реактора при включенном реакторе")
    public void stopSuccess() {
        reactorDepartment.setIsWork(true);
        Assertions.assertDoesNotThrow(reactorDepartment::stop);
        Assertions.assertFalse(reactorDepartment.getIsWork());
    }

    @Test
    @DisplayName("Тест остановки реактора при выключенном реакторе")
    public void stopFail() {
        reactorDepartment.setIsWork(false);
        Assertions.assertThrows(ReactorWorkException.class, reactorDepartment::stop);
    }
}
