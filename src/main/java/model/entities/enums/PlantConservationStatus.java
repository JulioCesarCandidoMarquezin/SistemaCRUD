package model.entities.enums;

public enum PlantConservationStatus {
    CRITICAL(1),
    ENDANGERED(2),
    VULNERABLE(3),
    NEAR_THREATENED(4),
    LEAST_CONCERN(5),
    DATA_DEFICIENT(6);

    private final int value;

    PlantConservationStatus(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}
