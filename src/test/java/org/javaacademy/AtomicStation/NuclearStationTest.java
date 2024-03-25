package org.javaacademy.AtomicStation;

import org.javaacademy.AtomicStation.departments.EconomicDepartment;
import org.javaacademy.AtomicStation.departments.MaintenanceDepartment;
import org.javaacademy.AtomicStation.departments.ReactorDepartment;
import org.javaacademy.AtomicStation.departments.SecurityDepartment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class NuclearStationTest {
    ReactorDepartment reactorDepartmentMock = Mockito.mock(ReactorDepartment.class);
    SecurityDepartment securityDepartmentMock = Mockito.mock(SecurityDepartment.class);
    EconomicDepartment economicDepartmentMock = Mockito.mock(EconomicDepartment.class);
    MaintenanceDepartment maintenanceDepartmentMock = Mockito.mock(MaintenanceDepartment.class);
    NuclearStation nuclearStation =
            new NuclearStation(reactorDepartmentMock, securityDepartmentMock, economicDepartmentMock,
                    maintenanceDepartmentMock);

    @Test
    @DisplayName("Тест успешного запуска атомной станции")
    public void startSuccess() {
        Assertions.assertDoesNotThrow(() -> nuclearStation.start(3));
    }

    @Test
    @DisplayName("Тест на успешное добавление числа инцидентов")
    public void incrementAccident() {
        nuclearStation.incrementAccident(10);
        Assertions.assertEquals(nuclearStation.getAccidentCountAllTime(), 10);
    }
}
