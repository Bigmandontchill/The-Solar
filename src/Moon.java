public class Moon extends SolarObject{

    public Moon(double angle, double r, int diameter, String col, double CenterX, double CenterY) {
        super(angle, r, diameter, col, CenterX, CenterY);
    }
    public void move(double velocity,Planet planet,SolarSystem system,Sun sun ){
        IncreaseAngle(velocity);
        double centrerads = Math.toRadians(planet.getAngle());
        double centrerads2 = Math.toRadians(sun.getAngle());
        double centreOfRotationX = (system.getWidth()/2) +sun.r*Math.sin(centrerads2) + planet.r * Math.sin(centrerads);
        double centreOfRotationY = (system.getHeight()/2)+sun.r*Math.cos(centrerads2) +planet.r* Math.cos(centrerads);
        CenterX=centreOfRotationX;
        CenterY=centreOfRotationY;
    }
}