package cars;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class Controller {

    private final CarService carService;

    @Autowired
    public Controller(CarService carService) {
        this.carService = carService;
    }

    @PostMapping(value = "/")
        public ResponseEntity<?> create(@RequestBody String manufacturerName, String modelName, String typeEngine) {

        carService.create(manufacturerName, modelName, typeEngine);

            return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<Car>> read() {
        final List<Car> cars = carService.readAll();

        return cars != null &&  !cars.isEmpty()
                ? new ResponseEntity<>(cars, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
