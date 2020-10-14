import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.util.*;

/**
 * This class provides a graphical user interface to a model of the solar system
 * @author Joe Finney
 */
public class SolarSystem extends JFrame {
	private int width = 300;
	private int height = 300;
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
		double centreOfRotationX = ((double) width) / 2.0;
		double centreOfRotationY = ((double) height) / 2.0;
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
					double x = (t.getCenterX() + t.getR() * Math.sin(rads)) - t.getDiameter() / 2;
					double y = (t.getCenterY() + t.getR() * Math.cos(rads)) - t.getDiameter() / 2;
					g.fillOval((int) x, (int) y, t.getDiameter(), t.getDiameter());
					try{ Thread.sleep(0); } catch (Exception e) {}
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

	public void update() {
		Planet planets[]=new Planet[8];
		Sun sun = new Sun(0, 0, 100, "YELLOW", getWidth() / 2, getHeight() / 2);
		Moon moon = new Moon(0, 50, 10, "BLUE");
		planets[0]=new Planet(-40,70,10,"GRAY",sun,this,1.5 );//Mercury
		planets[1]=new Planet(-400,140,20,"ORANGE",sun,this,1.3);//Venus
		planets[2]=new Planet(180,210,25,"GREEN",sun,this,1.1);//Earth
		planets[3]=new Planet(300,280,15,"RED",sun,this,0.9);//Mars
		planets[4]=new Planet(0,350,45,"WHITE",sun,this,0.7);//Jupiter
		planets[5]=new Planet(-70,420,40,"GRAY",sun,this,0.5);//Saturn
		planets[6]=new Planet(90,490,35,"BLUE",sun,this,0.3);//Uranus
		planets[7]=new Planet(50,520,30,"PINK",sun,this,0.2);//Neptune
		while (true) {
			Draw(sun);
			for(Planet planet:planets){
				Draw(planet);
				planet.move();
			}
			finishedDrawing();
		}
	}
}
