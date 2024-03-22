package org.javaacademy.AtomicStation;

import lombok.Getter;
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
@Getter
@Setter
public class ReactorDepartment {
    private Boolean isWork = false;
    private static final long KWT_IN_HOUR = 10_000_000;
    private int runCounter = 0;
    private static final long LIMIT_RUN_COUNTER = 100;

    public long run() {
        if (this.isWork) {
            throw new ReactorWorkException("Реактор уже работает");
        }
        if (this.runCounter == LIMIT_RUN_COUNTER) {
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

