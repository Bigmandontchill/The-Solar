import java.util.ArrayList;

public class asteroids {
    private int size;
    private double upper;
    private double lower;
    private double speed;
    private String color;
    private ArrayList<SolarObject> rocks = new ArrayList<>();

    /**
     *
     * @param size how many asteroids between mars and jupiter
     * @param speed speed of an asteroids
     * @param upperdistance upper range of asteroids
     * @param lowerdistance lower range of asteroids
     */
    public asteroids(int size ,double speed,double upperdistance,double lowerdistance,String color ){
        this.size=size;
        upper=upperdistance;
        lower=lowerdistance;
        this.speed=speed;
        this.color=color;
    }

    /**
     * Generate asteroids
     */
    public void generate(SolarObject object){
        for(int i=0;i<size;i++){
            double angle =Math.random() * (360 +0 + 1) -0;
            double distance =Math.random() * (upper -lower+1) +upper;
            rocks.add(new Planet(angle, distance, 2, color , object, speed));
        }
    }

    /**
     * move asteroids
     */
    public void updateAsteroids(SolarSystem system){
        for(SolarObject object:rocks){
            Planet planet=(Planet) object;
            planet.move(system);
        }
    }

}
