public class Moon extends SolarObject {
    private Sun sun;
    private Planet planet;
    private SolarSystem system;
    Double velocity;
    /***
     *
     * @param angle polar angle is the counterclockwise angle from the x-axis
     * @param r  polar coordinate r is the distance from the origin
     * @param diameter size of the moon
     * @param col Color of the moon
     * @param sun associate sun that planet orbit
     *@param planet associate sun that moon orbit
     * @param velocity speed of the moon
     */
    public Moon(double angle, double r, int diameter, String col, Sun sun, Planet planet, SolarSystem system, Double velocity) {
        super(angle, r, diameter, col);
        this.sun = sun;
        this.planet = planet;
        this.system = system;
        this.velocity = velocity;
    }

    /**
     * move moon around the planet
     */
    public void move() {
        IncreaseAngle(velocity);
        double centrerads = Math.toRadians(planet.getAngle());
        double centrerads2 = Math.toRadians(sun.getAngle());
        double Rsun = sun.getR();
        double Rplanet = planet.getR();
        double centreOfRotationX = (system.getWidth() / 2) + Rsun * Math.sin(centrerads2) + Rplanet * Math.sin(centrerads);
        double centreOfRotationY = (system.getHeight() / 2) + Rsun * Math.cos(centrerads2) + Rplanet * Math.cos(centrerads);
        setCenterX(centreOfRotationX);
        setCenterY(centreOfRotationY);
    }
}
