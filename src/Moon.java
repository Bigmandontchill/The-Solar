public class Moon extends SolarObject {

    private SolarObject planet;

    /***
     *
     * @param angle polar angle is the counterclockwise angle from the x-axis
     * @param r  polar coordinate r is the distance from the origin
     * @param diameter size of the moon
     * @param col Color of the moon
     *@param planet associate sun that moon orbit
     * @param velocity speed of the moon
     */

    public Moon(double angle, double r, int diameter, String col, SolarObject planet ,Double velocity) {
        super(angle, r, diameter, col,velocity);
        this.planet=planet;
    }



    /**
     * move moon around the planet
     */
    public void move(SolarSystem system) {
      system.update(this,planet);
    }
}
