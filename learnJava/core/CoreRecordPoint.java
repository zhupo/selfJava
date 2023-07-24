package core;

public record CoreRecordPoint(int x, int y) {
    public CoreRecordPoint {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException();
        }
    }
    public static CoreRecordPoint of() {
        return new CoreRecordPoint(0, 0);
    }

    public static CoreRecordPoint of(int x, int y) {
        return new CoreRecordPoint(x, y);
    }
}
