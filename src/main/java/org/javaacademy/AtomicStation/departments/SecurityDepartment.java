package org.javaacademy.AtomicStation.departments;

import org.javaacademy.AtomicStation.NuclearStation;
import org.springframework.stereotype.Component;

/**
 Этот отдел будет фиксировать ошибки из реакторного цеха
 */
@Component
public class SecurityDepartment {
    private final NuclearStation nuclearStation;
    private Integer accidentCountPeriod = 0;

    public SecurityDepartment(NuclearStation nuclearStation) {
        this.nuclearStation = nuclearStation;
    }

    public void addAccident() {
        this.accidentCountPeriod++;
    }

    public Integer getCountAccidents() {
        return accidentCountPeriod;
    }

    public void reset() {
        nuclearStation.incrementAccident(accidentCountPeriod);
        this.accidentCountPeriod = 0;
    }
}
