import java.awt.*;
import java.awt.event.WindowEvent;

public  class SolarObject {

    private double angle;
    protected double r;
    protected int diameter;
    protected String col;
    protected double CenterX;
    protected double CenterY;

    public SolarObject(double angle, double r, int diameter, String col,double CenterX,double CenterY) {
        this.angle = angle;
        this.r = r;
        this.diameter = diameter;
        this.col = col;
        this.CenterX=CenterX;
        this.CenterY=CenterY;
    }

    public double getAngle() {
        return angle;
    }

    public void IncreaseAngle(double angle) {
        this.angle += angle;
    }
}

