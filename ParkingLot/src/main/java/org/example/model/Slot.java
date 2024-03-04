package org.example.model;

public class Slot {
    public Slot(final Integer slotNumber) {
        this.slotNumber = slotNumber;
    }
    private Car parkedCar;
    private Integer slotNumber;

    public Integer getSlotNumber() {
        return slotNumber;
    }

    public Car getParkedCar() {
        return parkedCar;
    }

    public boolean isSlotFree() {
        return parkedCar == null;
    }

    public void assignCar(Car car) {
        this.parkedCar = car;
    }

    public void unassignCar() {
        this.parkedCar = null;
    }
}
