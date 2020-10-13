public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        SolarSystem system = new SolarSystem(800, 800);
        system.update(system);
    }
}
