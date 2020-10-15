import java.awt.*;
import java.awt.event.WindowEvent;

public class Sun extends SolarObject{

    /***
     *
     * @param angle  polar angle is the counterclockwise angle from the x-axis
     * @param r  polar coordinate r is the distance from the origin
     * @param diameter size of the object
     * @param col Color of the object
     * @param CenterX x position of the origin point
     * @param CenterY x position of the origin point
     */
     public Sun(double angle, double r, int diameter, String col,double CenterX,double CenterY) {
        super(angle, r, diameter, col);
        setCenterX(CenterX);
        setCenterY(CenterY);
    }


    }





