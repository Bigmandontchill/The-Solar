import java.awt.*;
import java.awt.event.WindowEvent;

public  class SolarObject {

    private double angle;
    private  double r;
    private int diameter;
    private String col;
    private double CenterX;
    private double CenterY;

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

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public String getCol() {
        return col;
    }

    public void setCol(String col) {
        this.col = col;
    }

    public double getCenterX() {
        return CenterX;
    }

    public void setCenterX(double centerX) {
        CenterX = centerX;
    }

    public double getCenterY() {
        return CenterY;
    }

    public void setCenterY(double centerY) {
        CenterY = centerY;
    }
}

