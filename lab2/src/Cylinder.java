//import java.lang.Math;

public class Cylinder {
    private double radius;
    private double height;

    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    public Cylinder() {
    }

    public void setRadius(double newRadius) {
        radius = newRadius;
    }

    public void setHeight(double newHeight) {
        height = newHeight;
    }

    public double getRadius() {
        return radius;
    }

    public double getHeight() {
        return height;
    }

    public double getBaseField() {
        return Math.PI * Math.pow(radius, 2);
    }

    public double getSideField() {
        return 2 * Math.PI * radius * height;
    }

    public double getField() {
        return 2 * getBaseField() + getSideField();
    }

    public double getVolume() {
        return getBaseField() * height;
    }
}
