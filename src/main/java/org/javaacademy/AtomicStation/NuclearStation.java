package org.javaacademy.AtomicStation;

import org.javaacademy.AtomicStation.exceptions.NuclearFuelIsEmptyException;
import org.javaacademy.AtomicStation.exceptions.ReactorWorkException;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class NuclearStation {
    private final ReactorDepartment reactorDepartment;
    private int generatedEnergyAll;

    public NuclearStation(ReactorDepartment reactorDepartment) {
        this.reactorDepartment = reactorDepartment;
        this.generatedEnergyAll = 0;
    }

    public void startYear() {
        AtomicInteger generatedEnergyOneYear = new AtomicInteger();
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
    }

    public void start(int year) {
        IntStream.range(0, year).forEach(i -> startYear());
    }
}