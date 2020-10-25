import java.awt.*;

public class Planet extends  SolarObject {
<<<<<<< HEAD
    private SolarObject sun;
=======
    private Sun sun;
>>>>>>> 0d313f27f212bbc741f849fa3d9aad335c24cc1f
    /***
     *
     * @param angle polar angle is the counterclockwise angle from the x-axis
     * @param r  polar coordinate r is the distance from the origin
     * @param diameter size of the planet
     * @param col Color of the planet
     * @param sun associate sun that planet orbit
     * @param velocity speed of the planet
     */
<<<<<<< HEAD
    public Planet(double angle , double r, int diameter, String col,SolarObject sun,double velocity) {
=======
    public Planet(double angle , double r, int diameter, String col,Sun sun,double velocity) {
>>>>>>> 0d313f27f212bbc741f849fa3d9aad335c24cc1f
        super(angle, r, diameter, col,velocity);
        this.sun=sun;
    }

    /***
     * move planet around the sun
     */
    public void move(SolarSystem system){
        system.update(this, sun);
    }

}
