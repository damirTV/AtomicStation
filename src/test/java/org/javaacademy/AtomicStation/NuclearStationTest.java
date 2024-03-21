package org.javaacademy.AtomicStation;

import org.mockito.Mockito;

public class NuclearStationTest {
    ReactorDepartment reactorDepartmentMock = Mockito.mock(ReactorDepartment.class);
    private final NuclearStation nuclearStation = new NuclearStation(reactorDepartmentMock);
}
