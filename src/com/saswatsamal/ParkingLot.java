package com.saswatsamal;

public class ParkingLot {
    private int[] slots;

    public ParkingLot(int big, int medium, int small){
        slots = new int[]{big,medium,small};
    }

    public boolean addCar(int carType){
        if(slots[carType-1]>0){
            slots[carType-1]--;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(1,1, 0);

        System.out.println("Add car on big slot: "+parkingLot.addCar(1));
        System.out.println("Add car on medium slot: "+parkingLot.addCar(2));
        System.out.println("Add car on small slot: "+parkingLot.addCar(3));
    }
}
