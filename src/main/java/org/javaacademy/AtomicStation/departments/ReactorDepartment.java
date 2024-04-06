package org.javaacademy.AtomicStation.departments;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.javaacademy.AtomicStation.exceptions.NuclearFuelIsEmptyException;
import org.javaacademy.AtomicStation.exceptions.ReactorWorkException;
import org.springframework.stereotype.Component;

/**
Реакторный цех, отвечает за производство электроэнергии
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class ReactorDepartment {
    private Boolean isWork = false;
    private static final long KWT_IN_HOUR = 10_000_000;
    @Setter
    private int runCounter = 0;
    private static final long LIMIT_RUN_COUNTER = 100;
    private final SecurityDepartment securityDepartment;

    public long run() {
        if (this.isWork) {
            throw new ReactorWorkException("Реактор уже работает");
        }
        this.isWork = true;
        if (this.runCounter == LIMIT_RUN_COUNTER) {
            securityDepartment.addAccident();
            throw new NuclearFuelIsEmptyException("В реакторе закончилось топливо");
        }
        this.runCounter++;
        return KWT_IN_HOUR;
    }

    public void stop() {
        if (!this.isWork) {
            throw new ReactorWorkException("Реактор уже выключен");
        }
        this.isWork = false;
    }
}

