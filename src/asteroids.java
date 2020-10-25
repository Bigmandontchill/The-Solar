import java.util.ArrayList;

public class asteroids {
    private int size;
    private double upper;
    private double lower;
    private double speed;
    private ArrayList<Planet> rocks = new ArrayList<>();

    /**
     *
     * @param size how many asteroids between mars and jupiter
     * @param speed speed of an asteroids
     * @param upperdistance upper range of asteroids
     * @param lowerdistance lower range of asteroids
     */
    public asteroids(int size ,double speed,double upperdistance,double lowerdistance){
        this.size=size;
        upper=upperdistance;
        lower=lowerdistance;
        this.speed=speed;
    }

    /**
     * Generate asteroids
     */
    public void generate(Sun sun){
        for(int i=0;i<300;i++){
            double angle =Math.random() * (360 +0 + 1) -0;
            double distance =Math.random() * (upper -lower+1) +upper;
            rocks.add(new Planet(angle, distance, 2, "RED", sun, speed));
        }
    }

    /**
     * move asteroids
     */
    public void updateAsteroids(SolarSystem system){
        for(Planet planet:rocks){
            planet.move(system);
        }
    }

}
