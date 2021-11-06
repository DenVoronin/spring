package cars;



public class Car {


    protected int id;
    protected String manufacturerName;
    protected Engine engine;
    protected String modelName;



    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEngine(String engine) {
        if (engine.equals("Petrol")) {
            this.engine= new Engine(Engine.type.Petrol);
        }
        if (engine.equals("Diesel")) {
            this.engine= new Engine(Engine.type.Diesel);
        }
    }

    public String getEngine() {
        return engine.powerUp();
    }

    public int getId() {
        return id;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public String getModelName() {
        return modelName;
    }

    public String toString() {

        return String.join(" ", manufacturerName, modelName, engine.powerUp());
    }
}
