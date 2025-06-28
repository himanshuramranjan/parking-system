package enums;

public enum ParkingSpotEnum {
    COMPACT(20),
    MINI(10),
    LARGE(50);

    private final int value;

    ParkingSpotEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
