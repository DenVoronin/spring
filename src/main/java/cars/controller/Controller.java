package cars.controller;


import cars.Car;
import cars.Engine;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@FuelExceptionHandler
public class Controller {

    private final CarService carService;

    @Autowired
    public Controller(CarService carService) {
        this.carService = carService;
    }

    @PostMapping(value = "/")
    public ResponseEntity<?> create(@RequestBody Car car) throws Exception {
        try {
            carService.create(car);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception ex) {
            throw new Exception("Incorrect data. Use fields manufacturerName(String type),engine(String !Petrol or Diesel!) and modelName(String)");
        }
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<Car>> readAll() {
        final List<Car> cars = carService.readAll();

        return cars != null && !cars.isEmpty()
                ? new ResponseEntity<>(cars, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/fuel/check/")
    public ResponseEntity<List<Car>> checkFuel(@RequestParam String type) throws Exception {
        try {
            if (Engine.powerUp(type) == false) { throw new Exception(); }
        } catch (Exception ex) {
            throw new Exception("This type of engine is incorrect");
        }
        List<Car> cars = carService.readAll();
        System.out.println("get filter values: " + type);
        List<Car> carsF = cars.stream().filter(e -> e.getEngine().equals(type)).toList();
        return new ResponseEntity<>(carsF, HttpStatus.OK);
    }
    }

