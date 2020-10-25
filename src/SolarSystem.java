import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.util.*;

/**
 * This class provides a graphical user interface to a model of the solar system
 *
 * @author Joe Finney
 */
public class SolarSystem extends JFrame {
    private int width = 0;
    private int height = 0;
    private boolean exiting = false;
    private Map<RenderingHints.Key, Object> renderingHints;

    private ArrayList<SolarObject> things = new ArrayList<SolarObject>();

    /**
     * Create a view of the Solar System.
     * Once an instance of the SolarSystem class is created,
     * a window of the appropriate size is displayed, and
     * objects can be displayed in the solar system
     *
     * @param width  the width of the window in pixels.
     * @param height the height of the window in pixels.
     */
    public SolarSystem(int width, int height) {
        this.width = width;
        this.height = height;

        this.setTitle("The Solar System");
        this.setSize(width, height);
        this.setBackground(Color.BLACK);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        renderingHints = new HashMap<>();
        renderingHints.put(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        renderingHints.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        renderingHints.put(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        renderingHints.put(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
        renderingHints.put(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        renderingHints.put(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        renderingHints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        renderingHints.put(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
        renderingHints.put(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
    }

    /**
     * A method called by the operating system to draw onto the screen - <p><B>YOU DO NOT (AND SHOULD NOT) NEED TO CALL THIS METHOD.</b></p>
     */
    public void paint(Graphics gr) {
        BufferedImage i = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = i.createGraphics();
        Graphics2D window = (Graphics2D) gr;
        g.setRenderingHints(renderingHints);
        window.setRenderingHints(renderingHints);

        synchronized (this) {
            if (!this.exiting) {
                g.clearRect(0, 0, width, height);
                for (SolarObject t : things) {
                    g.setColor(this.getColourFromString(t.getCol()));
                    double rads = Math.toRadians(t.getAngle());
                    double x = (int) (t.getCenterX() + t.getR() * Math.sin(rads)) - t.getDiameter() / 2;
                    double y = (int) (t.getCenterY() + t.getR() * Math.cos(rads)) - t.getDiameter() / 2;
                    g.fillOval((int) x, (int) y, t.getDiameter(), t.getDiameter());
                    try {
                        Thread.sleep(0);
                    } catch (Exception e) {
                    }
                }
            }

            window.drawImage(i, 0, 0, this);
        }
    }

    //
    // Shouldn't really handle colour this way, but the student's haven't been introduced
    // to constants properly yet, and Color.getColor() doesn't seem to work... hmmm....
    //
    public Color getColourFromString(String col) {
        Color color;

        if (col.charAt(0) == '#') {
            color = new Color(
                    Integer.valueOf(col.substring(1, 3), 16),
                    Integer.valueOf(col.substring(3, 5), 16),
                    Integer.valueOf(col.substring(5, 7), 16));
        } else {
            try {
                java.lang.reflect.Field field = Color.class.getField(col);
                color = (Color) field.get(null);
            } catch (Exception e) {
                color = Color.WHITE;
            }
        }
        return color;
    }


    public void AddSolarObject(SolarObject object) {
        things.add(object);
    }


    /**
     * Updates the window to show all objects that have recently been drawn using
     * drawSolarObject() or drawSolarObjectAbout().
     * <p>
     * The method also waits for 20 milliseconds (1/50th of one second) and then
     * clears the screen.
     */
    public void finishedDrawing() {
        try {
            this.repaint();
            Thread.sleep(20);
            synchronized (this) {
                things.clear();
            }
        } catch (Exception e) {
        }
    }

    /**
     * Draw a SolarObject
     *
     * @param t SolarObject
     */
    public void Draw(SolarObject t) {
        synchronized (this) {
            if (things.size() > 1000) {
                System.out.println("\n\n");
                System.out.println(" ********************************************************* ");
                System.out.println(" ***** Only 1000 Entities Supported per Solar System ***** ");
                System.out.println(" ********************************************************* ");
                System.out.println("\n\n");
                System.out.println("If you are't trying to add this many things");
                System.out.println("to your SolarSystem, then you have probably");
                System.out.println("forgotten to call the finishedDrawing() method");
                System.out.println("See the JavaDOC documentation for more information");
                System.out.println("\n-- Joe");
                System.out.println("\n\n");

                dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
            } else {
                AddSolarObject(t);
            }

        }
    }

    /**
     * create all objects ,draw all objects and update movement of all objects
     */
    public void update() {
        Planet planets[] = new Planet[8];
        Moon moons[] = new Moon[13];
        Sun sun = new Sun(0, 0, 100, "YELLOW", getWidth() / 2, getHeight() / 2, 0);
        planets[0] = new Planet(0, 70, 10, "GRAY", sun, 1.5);//Mercury
        planets[1] = new Planet(0, 140, 20, "ORANGE", sun, 1.22);//Venus
        planets[2] = new Planet(0, 210, 25, "GREEN", sun, 1.1);//Earth
        planets[3] = new Planet(0, 300, 15, "RED", sun, 0.9);//Mars
        planets[4] = new Planet(0, 380, 39, "WHITE", sun, 0.6);//Jupiter
        planets[5] = new Planet(0, 450, 37, "GRAY", sun, 0.42);//Saturn
        planets[6] = new Planet(0, 530, 35, "BLUE", sun, 0.3);//Uranus
        planets[7] = new Planet(0, 600, 30, "PINK", sun, 0.2);//Neptune
        moons[0] = new Moon(0, 20, 10, "WHITE", planets[2], 0.7);//Mearth
        moons[1] = new Moon(0, 14, 7, "WHITE", planets[3], 2.5);//Mmars
        moons[2] = new Moon(0, 26, 7, "WHITE", planets[3], 1.5);//Mmars
        moons[3] = new Moon(0, 27, 6, "WHITE", planets[4], 0.5);//MJupiter
        moons[4] = new Moon(0, 37, 9, "WHITE", planets[4], 0.7);//Mjupiter
        moons[5] = new Moon(0, 42, 6, "WHITE", planets[4], 1.1);//Mjupiter
        moons[6] = new Moon(0, 50, 6, "WHITE", planets[4], 1.4);//Mjuipter
        moons[7] = new Moon(0, 30, 14, "YELLOW", planets[5], 0.7);//Msaturn
        moons[8] = new Moon(0, 45, 8, "WHITE", planets[5], 1.6);//Msaturn
        moons[9] = new Moon(0, 30, 8, "GRAY", planets[6], 1.3);//Muranus
        moons[10] = new Moon(0, 45, 10, "WHITE", planets[6], 1.6);//Muranus
        moons[11] = new Moon(0, 30, 8, "BLUE", planets[7], 1.5);//Muranus
        moons[12] = new Moon(0, 45, 10, "RED", planets[7], 1.6);//Muranus

        while (true) {
            sun.move(this);
            for (Planet planet : planets) {
                planet.move(this);
            }
            for (Moon moon : moons) {
                moon.move(this);
            }
            finishedDrawing();
        }
    }

    public void update(SolarObject object, SolarObject orbit) {
        object.IncreaseAngle(object.getVelocity());
        Draw(object);
        double centreOfRotationX = orbit.getCenterX() + orbit.getR() * Math.sin(Math.toRadians(orbit.getAngle()));
        double centreOfRotationY = orbit.getCenterY() + orbit.getR() * Math.cos(Math.toRadians(orbit.getAngle()));
        object.setCenterX(centreOfRotationX);
        object.setCenterY(centreOfRotationY);
    }
}
