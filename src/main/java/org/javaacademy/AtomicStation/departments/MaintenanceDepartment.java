package org.javaacademy.AtomicStation.departments;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
Департамент ремонта и сопровождения, отвечают за ремонт реакторного цеха
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class MaintenanceDepartment {
    private final ReactorDepartment reactorDepartment;

    public void repairReactor() {
        reactorDepartment.setRunCounter(0);
    }
}
