package cars;

public class Engine {
    enum type{
        Petrol,
        Diesel
    }
    type engineType;
   Engine(type type){
       this.engineType = type;
   }
String powerUp(){

       return this.engineType.toString();
}

}
