package cars;



public class Car {


    private Long id;

    private String manufacturerName;
    private Engine engine;
    private String modelName;

    public Car(String manufacturerName, String modelName, Engine engine) {
        this.manufacturerName = manufacturerName;
        this.modelName = modelName;
        this.engine = engine;
    }


    public String toString() {
        return String.join(" ", manufacturerName, modelName, engine.powerUp());
    }
}
