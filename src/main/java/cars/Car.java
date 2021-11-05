package cars;



public class Car {


    private int id;

    protected String manufacturerName;
    protected Engine engine;
    protected String modelName;

    /* public Car(String manufacturerName, String modelName, Engine engine) {
        this.manufacturerName = manufacturerName;
        this.modelName = modelName;
        this.engine = engine;
    } */

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String toString() {

        return String.join(" ", manufacturerName, modelName, engine.powerUp());
    }
}
