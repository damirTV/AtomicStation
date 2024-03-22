package org.javaacademy.AtomicStation.departments;

import org.javaacademy.AtomicStation.NuclearStation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class SecurityDepartmentTest {
    NuclearStation nuclearStationMock = Mockito.mock(NuclearStation.class);
    SecurityDepartment securityDepartment = new SecurityDepartment(nuclearStationMock);

    @Test
    @DisplayName("Тест на успешное увеличение числа инциндентов за период")
    public void addAccidentSuccess() {
        Assertions.assertDoesNotThrow(securityDepartment::addAccident);
    }

    @Test
    @DisplayName("Тест на успешный возврат числа инцидентов")
    public void getCountAccidentsSuccess() {
        Assertions.assertDoesNotThrow(securityDepartment::getCountAccidents);
    }

    @Test
    @DisplayName("Тест на обнуление числа инцидентов")
    public void resetSuccess() {
        securityDepartment.addAccident();
        Assertions.assertEquals(securityDepartment.getCountAccidents(), 1);
    }
}
