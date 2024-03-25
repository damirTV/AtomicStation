package org.javaacademy.AtomicStation.departments;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MaintenanceDepartment {
    private final ReactorDepartment reactorDepartment;

    public MaintenanceDepartment(ReactorDepartment reactorDepartment) {
        this.reactorDepartment = reactorDepartment;
    }

    public void repairReactor() {
        reactorDepartment.setRunCounter(0);
        log.info("Работа реактора восстановлена");
    }
}
