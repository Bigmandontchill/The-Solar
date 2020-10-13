import java.awt.*;

public class Planet extends  SolarObject {
    public Planet(double angle , double r, int diameter, String col,double Centerx,double Centery) {
        super(angle, r, diameter, col,Centerx,Centery);
    }

    public void move(double velocity,Sun sun,SolarSystem system){
        IncreaseAngle(velocity);
        double centrerads = Math.toRadians(sun.getAngle());
        double Rsun=sun.getR();
        double centreOfRotationX = (system.getWidth()/2) + Rsun * Math.sin(centrerads);
        double centreOfRotationY = (system.getHeight()/2) +Rsun * Math.cos(centrerads);
        setCenterX(centreOfRotationX);
        setCenterY(centreOfRotationY);
    }

}
