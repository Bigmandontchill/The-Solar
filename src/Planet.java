import java.awt.*;

public class Planet extends  SolarObject {
    private Sun sun;
    private SolarSystem system;
    private double velocity;
    public Planet(double angle , double r, int diameter, String col,Sun sun ,SolarSystem system,double velocity) {
        super(angle, r, diameter, col);
        this.sun=sun;
        this.system=system;
        this.velocity=velocity;
    }

    public void move(){
        IncreaseAngle(velocity);
        double centrerads = Math.toRadians(sun.getAngle());
        double Rsun=sun.getR();
        double centreOfRotationX = (system.getWidth()/2) + Rsun * Math.sin(centrerads);
        double centreOfRotationY = (system.getHeight()/2) +Rsun * Math.cos(centrerads);
        setCenterX(centreOfRotationX);
        setCenterY(centreOfRotationY);
    }

}
