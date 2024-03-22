package org.javaacademy.AtomicStation;

import lombok.Getter;
import org.javaacademy.AtomicStation.departments.ReactorDepartment;
import org.javaacademy.AtomicStation.departments.SecurityDepartment;
import org.javaacademy.AtomicStation.exceptions.NuclearFuelIsEmptyException;
import org.javaacademy.AtomicStation.exceptions.ReactorWorkException;
import org.springframework.stereotype.Component;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;

/**
Атомная станция
 */
@Component
@Getter
public class NuclearStation {
    private final ReactorDepartment reactorDepartment;
    private final SecurityDepartment securityDepartment;
    private long generatedEnergyAll;
    private int accidentCountAllTime;


    public NuclearStation(ReactorDepartment reactorDepartment, SecurityDepartment securityDepartment) {
        this.reactorDepartment = reactorDepartment;
        this.securityDepartment = securityDepartment;
        this.generatedEnergyAll = 0;
    }

    private void startYear() {
        AtomicLong generatedEnergyOneYear = new AtomicLong();
        System.out.println("Атомная станция начала работу");
        IntStream.range(0, 365).forEach(i -> {
            try {
                generatedEnergyOneYear.set(reactorDepartment.run() + generatedEnergyOneYear.get());
            } catch (NuclearFuelIsEmptyException | ReactorWorkException e) {
                System.out.println("Внимание! Происходят работы на атомной станции! Электричества нет!");
                throw new RuntimeException(e);
            }
            try {
                reactorDepartment.stop();
            } catch (ReactorWorkException e) {
                throw new RuntimeException(e);
            }
        });
        System.out.printf("Атомная станция закончила работу. За год Выработано %s киловатт/часов\n",
                generatedEnergyOneYear);
        generatedEnergyAll = generatedEnergyOneYear.get() + generatedEnergyAll;
        System.out.println("Количество инцидентов за год: " + securityDepartment.getCountAccidents());
        securityDepartment.reset();
    }

    public void start(int year) {
        IntStream.range(0, year).forEach(i -> startYear());
        System.out.println("Количество инцидентов за всю работу станции: " + accidentCountAllTime);
    }

    public void incrementAccident(int count) {
        this.accidentCountAllTime += count;
    }
}
