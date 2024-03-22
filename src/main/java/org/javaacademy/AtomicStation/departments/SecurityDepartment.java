package org.javaacademy.AtomicStation.departments;

import org.javaacademy.AtomicStation.NuclearStation;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 Этот отдел будет фиксировать ошибки из реакторного цеха
 */
@Component
public class SecurityDepartment {
    private final NuclearStation nuclearStation;
    private int accidentCountPeriod;

    public SecurityDepartment(@Lazy NuclearStation nuclearStation) {
        this.nuclearStation = nuclearStation;
        this.accidentCountPeriod = 0;
    }

    public void addAccident() {
        this.accidentCountPeriod++;
    }

    public int getCountAccidents() {
        return accidentCountPeriod;
    }

    public void reset() {
        nuclearStation.incrementAccident(accidentCountPeriod);
        this.accidentCountPeriod = 0;
    }
}
