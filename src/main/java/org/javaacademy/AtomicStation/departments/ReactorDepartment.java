package org.javaacademy.AtomicStation.departments;

import lombok.Getter;
import lombok.Setter;
import org.javaacademy.AtomicStation.exceptions.NuclearFuelIsEmptyException;
import org.javaacademy.AtomicStation.exceptions.ReactorWorkException;
import org.springframework.stereotype.Component;

/**
Реакторный цех, отвечает за производство электроэнергии
 */
@Component
@Getter
@Setter
public class ReactorDepartment {
    private Boolean isWork = false;
    private static final long KWT_IN_HOUR = 10_000_000;
    private int runCounter = 0;
    private static final long LIMIT_RUN_COUNTER = 100;
    private SecurityDepartment securityDepartment;

    public ReactorDepartment(SecurityDepartment securityDepartment) {
        this.securityDepartment = securityDepartment;
    }

    public long run() {
        if (this.isWork) {
            throw new ReactorWorkException("Реактор уже работает");
        }
        if (this.runCounter == LIMIT_RUN_COUNTER) {
            securityDepartment.addAccident();
            throw new NuclearFuelIsEmptyException("В реакторе закончилось топливо");
        }
        this.runCounter++;
        this.isWork = true;
        return KWT_IN_HOUR;
    }

    public void stop() {
        if (!this.isWork) {
            throw new ReactorWorkException("Реактор уже выключен");
        }
        this.isWork = false;
    }
}

