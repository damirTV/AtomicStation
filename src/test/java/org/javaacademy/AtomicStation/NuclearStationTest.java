package org.javaacademy.AtomicStation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class NuclearStationTest {
    NuclearStation nuclearStationMock = Mockito.mock(NuclearStation.class);

    @Test
    @DisplayName("Тест успешного запуска атомной станции")
    public void startSuccess() {
        Assertions.assertDoesNotThrow(() -> nuclearStationMock.start(3));
    }

    @Test
    @DisplayName("Тест на успешное добавление числа инцидентов")
    public void incrementAccident() {
        nuclearStationMock.incrementAccident(10);
        Mockito.when(nuclearStationMock.getAccidentCountAllTime()).thenReturn(10);
    }
}
