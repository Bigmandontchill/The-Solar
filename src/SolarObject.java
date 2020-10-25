import java.awt.*;
import java.awt.event.WindowEvent;

public abstract class SolarObject {

    private double angle;
    private double r;
    private int diameter;
    private String col;
    /**
     * y position of the origin point
     */
    private double CenterX;
    /**
     * x position of the origin point
     */
    private double CenterY;
    /**
     * speed of the object
     */
    private double velocity;

    /***
     *
     * @param angle  polar angle is the counterclockwise angle from the x-axis
     * @param r  polar coordinate r is the distance from the origin
     * @param diameter size of the object
     * @param col Color of the object
     * @param velocity speed of the object
     */
    public SolarObject(double angle, double r, int diameter, String col,double velocity) {
        this.angle = angle;
        this.r = r;
        this.diameter = diameter;
        this.col = col;
        this.velocity=velocity;
    }

    public abstract void move(SolarSystem system);

    /**
     * return polar angle
     */
    public double getAngle() {
        return angle;
    }

    /***
     *  polar angle is the counterclockwise angle from the x-axis
     * @param angle increase polar angle
     */
    public void IncreaseAngle(double angle) {
        this.angle += angle;
    }

    /***
     * return distance from the origin
     */
    public double getR() {
        return r;
    }

    /**
     * return diameter of the object
     */
    public int getDiameter() {
        return diameter;
    }

    /***
     *return colour of the object
     */
    public String getCol() {
        return col;
    }

    /**
     * return x position  of the origin
     */
    public double getCenterX() {
        return CenterX;
    }

    /**
     * set x position  of the origin
     *
     * @param centerX x position  of the origin
     */
    public void setCenterX(double centerX) {
        CenterX = centerX;
    }

    /**
     * return y position  of the origin
     */
    public double getCenterY() {
        return CenterY;
    }

    /**
     * set y position  of the origin
     *
     * @param centerY x position  of the origin
     */
    public void setCenterY(double centerY) {
        CenterY = centerY;
    }

    /**
     * return velocity
     */
    public double getVelocity() {
        return velocity;
    }

}

