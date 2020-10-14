public class Moon extends SolarObject{
private Sun sun;
private Planet planet;
private SolarSystem system;
Double velocity;
    public Moon(double angle, double r, int diameter, String col,Sun sun,Planet planet,SolarSystem system,Double velocity ) {
        super(angle, r, diameter, col);
        this.sun=sun;
        this.planet=planet;
        this.system=system;
        this.velocity=velocity;
    }

    public void move(){
        IncreaseAngle(velocity);
        double centrerads = Math.toRadians(planet.getAngle());
        double centrerads2 = Math.toRadians(sun.getAngle());
        double Rsun=sun.getR();
        double Rplanet=planet.getR();
        double centreOfRotationX = (system.getWidth()/2) +Rsun*Math.sin(centrerads2) + Rplanet * Math.sin(centrerads);
        double centreOfRotationY = (system.getHeight()/2)+Rsun*Math.cos(centrerads2) +Rplanet* Math.cos(centrerads);
        setCenterX(centreOfRotationX);
        setCenterY(centreOfRotationY);
    }
}
