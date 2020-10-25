public class Moon extends SolarObject {
<<<<<<< HEAD
    private SolarObject planet;
=======
    private Planet planet;
>>>>>>> 0d313f27f212bbc741f849fa3d9aad335c24cc1f

    /***
     *
     * @param angle polar angle is the counterclockwise angle from the x-axis
     * @param r  polar coordinate r is the distance from the origin
     * @param diameter size of the moon
     * @param col Color of the moon
     *@param planet associate sun that moon orbit
     * @param velocity speed of the moon
     */
<<<<<<< HEAD
    public Moon(double angle, double r, int diameter, String col, SolarObject planet ,Double velocity) {
=======
    public Moon(double angle, double r, int diameter, String col, Planet planet ,Double velocity) {
>>>>>>> 0d313f27f212bbc741f849fa3d9aad335c24cc1f
        super(angle, r, diameter, col,velocity);
        this.planet = planet;
    }

    /**
     * move moon around the planet
     */
    public void move(SolarSystem system) {
      system.update(this,planet);
    }
}
