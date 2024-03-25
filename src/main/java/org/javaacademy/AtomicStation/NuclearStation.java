package org.javaacademy.AtomicStation;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.javaacademy.AtomicStation.departments.EconomicDepartment;
import org.javaacademy.AtomicStation.departments.MaintenanceDepartment;
import org.javaacademy.AtomicStation.departments.ReactorDepartment;
import org.javaacademy.AtomicStation.departments.SecurityDepartment;
import org.javaacademy.AtomicStation.exceptions.NuclearFuelIsEmptyException;
import org.javaacademy.AtomicStation.exceptions.ReactorWorkException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
Атомная станция
 */
@Slf4j
@Component
@ToString
public class NuclearStation {
    private final ReactorDepartment reactorDepartment;
    private final SecurityDepartment securityDepartment;
    private final EconomicDepartment economicDepartment;
    private final MaintenanceDepartment maintenanceDepartment;
    private long generatedEnergyAll;
    private int accidentCountAllTime;
    @Value("${country.country}")
    private String country;
    @Value("${country.currency}")
    private String currency;

    public NuclearStation(ReactorDepartment reactorDepartment, SecurityDepartment securityDepartment,
                          EconomicDepartment economicDepartment, MaintenanceDepartment maintenanceDepartment) {
        this.reactorDepartment = reactorDepartment;
        this.securityDepartment = securityDepartment;
        this.economicDepartment = economicDepartment;
        this.maintenanceDepartment = maintenanceDepartment;
        this.generatedEnergyAll = 0;
    }

    private void startYear() {
        int counter = 1;
        long generatedEnergyOneYear = 0;
        log.info("Атомная станция начала работу");
        while (counter <= 365) {
            try {
                generatedEnergyOneYear += reactorDepartment.run();
            } catch (NuclearFuelIsEmptyException e) {
                log.error("Внимание! Происходят работы на атомной станции! Электричества нет!");
                maintenanceDepartment.repairReactor();
            } catch (ReactorWorkException e) {
                log.warn("Попытка запуска запущенного реактора");
            }
            try {
                reactorDepartment.stop();
            } catch (ReactorWorkException e) {
                log.warn("Попытка остановки остановленного реактора");
            }
            counter++;
        }
       log.info("Атомная станция закончила работу. За год Выработано {} киловатт/часов",
                generatedEnergyOneYear);
        generatedEnergyAll = generatedEnergyOneYear + generatedEnergyAll;
        log.warn("Количество инцидентов за год: {}", securityDepartment.getCountAccidents());
        log.info("Доход за год составил: {} {}",
                economicDepartment.computeYearIncomes(generatedEnergyOneYear), currency);
        securityDepartment.reset();
    }

    public void start(int year) {
        int counter = 1;
        log.info("Действие происходит в стране: {} ", country);
        while (counter <= year) {
            startYear();
            counter++;
        }
        log.warn("Количество инцидентов за всю работу станции: {}", accidentCountAllTime);
    }

    public void incrementAccident(int count) {
        this.accidentCountAllTime += count;
    }
}
