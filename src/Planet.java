import java.awt.*;

public class Planet extends  SolarObject {
    private SolarObject sun;
    /***
     *
     * @param angle polar angle is the counterclockwise angle from the x-axis
     * @param r  polar coordinate r is the distance from the origin
     * @param diameter size of the planet
     * @param col Color of the planet
     * @param sun associate sun that planet orbit
     * @param velocity speed of the planet
     */
    public Planet(double angle , double r, int diameter, String col,SolarObject sun,double velocity) {
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
