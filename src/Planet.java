import java.awt.*;

public class Planet extends  SolarObject {
    private Sun sun;
    private SolarSystem system;
    private double velocity;

    /***
     *
     * @param angle polar angle is the counterclockwise angle from the x-axis
     * @param r  polar coordinate r is the distance from the origin
     * @param diameter size of the planet
     * @param col Color of the planet
     * @param sun associate sun that planet orbit
     * @param velocity speed of the planet
     */
    public Planet(double angle , double r, int diameter, String col,Sun sun ,SolarSystem system,double velocity) {
        super(angle, r, diameter, col);
        this.sun=sun;
        this.system=system;
        this.velocity=velocity;
    }

    /***
     * move planet around the sun
     */
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
