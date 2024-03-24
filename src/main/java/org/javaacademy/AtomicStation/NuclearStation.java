package org.javaacademy.AtomicStation;

import lombok.ToString;
import org.javaacademy.AtomicStation.departments.EconomicDepartment;
import org.javaacademy.AtomicStation.departments.ReactorDepartment;
import org.javaacademy.AtomicStation.departments.SecurityDepartment;
import org.javaacademy.AtomicStation.exceptions.NuclearFuelIsEmptyException;
import org.javaacademy.AtomicStation.exceptions.ReactorWorkException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
Атомная станция
 */
@Component
@ToString
public class NuclearStation {
    private final ReactorDepartment reactorDepartment;
    private final SecurityDepartment securityDepartment;
    private final EconomicDepartment economicDepartment;
    private long generatedEnergyAll;
    private int accidentCountAllTime;
    @Value("${countrySettings.country}")
    String country;
    @Value("${countrySettings.currency}")
    String currency;

    public NuclearStation(ReactorDepartment reactorDepartment, SecurityDepartment securityDepartment,
                          EconomicDepartment economicDepartment) {
        this.reactorDepartment = reactorDepartment;
        this.securityDepartment = securityDepartment;
        this.economicDepartment = economicDepartment;
        this.generatedEnergyAll = 0;
    }

    private void startYear() {
        int counter = 1;
        long generatedEnergyOneYear = 0;
        System.out.println("Атомная станция начала работу");
        while (counter <= 365) {
            try {
                generatedEnergyOneYear += reactorDepartment.run();
            } catch (NuclearFuelIsEmptyException | ReactorWorkException e) {
                System.out.println("Внимание! Происходят работы на атомной станции! Электричества нет!");
                throw new RuntimeException(e);
            }
            reactorDepartment.stop();
            counter++;
        }
        System.out.printf("Атомная станция закончила работу. За год Выработано %s киловатт/часов\n",
                generatedEnergyOneYear);
        generatedEnergyAll = generatedEnergyOneYear + generatedEnergyAll;
        System.out.println("Количество инцидентов за год: " + securityDepartment.getCountAccidents());
        System.out.println("Доход за год составил: " +
                economicDepartment.computeYearIncomes(generatedEnergyOneYear) +
                " " + currency);
        securityDepartment.reset();
    }

    public void start(int year) {
        int counter = 1;
        System.out.println("Действие происходит в стране: " + country);
        while (counter <= year) {
            startYear();
            counter++;
        }
        System.out.println("Количество инцидентов за всю работу станции: " + accidentCountAllTime);
    }

    public void incrementAccident(int count) {
        this.accidentCountAllTime += count;
    }
}
