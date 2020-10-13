import java.awt.*;

public class Planet extends  SolarObject {
    public Planet(double angle , double r, int diameter, String col,double Centerx,double Centery) {
        super(angle, r, diameter, col,Centerx,Centery);
    }

    public void move(double velocity,Sun sun,SolarSystem system){
        IncreaseAngle(velocity);
        double centrerads = Math.toRadians(sun.getAngle());
        double centreOfRotationX = (system.getWidth()/2) + sun.r * Math.sin(centrerads);
        double centreOfRotationY = (system.getHeight()/2) +sun.r * Math.cos(centrerads);
        CenterX=centreOfRotationX;
        CenterY=centreOfRotationY;
    }

}
