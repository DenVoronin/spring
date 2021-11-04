package cars;

//import cars.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


import javax.annotation.PostConstruct;

@RestController
public class Controller {


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello() {
     Car car = new Car("Lada","niva", new Engine(Engine.type.Petrol));
    return car.toString();
    }
}
