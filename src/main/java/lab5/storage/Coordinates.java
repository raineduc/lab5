package lab5.storage;

import org.jetbrains.annotations.NotNull;

import static lab5.utils.StringUtils.repeat;

public class Coordinates {
    private long x;
    private Long y;

    public Coordinates(long x, Long y) {
        this.x = x;
        this.y = y;
    }

    public long getXCoordinate() {
        return this.x;
    }

    @NotNull public Long getYCoordinate() {
        return this.y;
    }

    public String generateStringShape(int indent) {
        return repeat(indent, " ") + "{\n" +
                repeat(indent, " ") + "  x coordinate: " + x + "\n" +
                repeat(indent, " ") + "  y coordinate: " + y + "\n" +
                repeat(indent, " ") + "}";

    }

    public String toString() {
        return this.generateStringShape(0);
    }

    public String toString(int indent) {
        return this.generateStringShape(indent);
    }
}
