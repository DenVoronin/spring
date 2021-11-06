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
  public static Boolean powerUp(String s){
      for (type c : type.values()) {
          if (c.name().equals(s)) {
              return true;
          }
      }

      return false;
  }
}
