package cars;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class CarServiceImpl implements CarService{

    private static final Map<Integer, Car> CAR_REPOSITORY_MAP = new HashMap<>();
    private static final AtomicInteger CAR_ID_HOLDER = new AtomicInteger();
    //потом сделать БД!

    @Override
    public void create(String manufacturerName,String modelName, String typeEngine) {
        final int carId = CAR_ID_HOLDER.incrementAndGet();
        Car car = new Car();

        if (typeEngine.equals("Petrol")) {
            car.setId(carId);
            car.setModelName(modelName);
            car.setManufacturerName(manufacturerName);
            car.setEngine(new Engine(Engine.type.Petrol));
        }
        if (typeEngine.equals("Diesel")) {
            car.setId(carId);
            car.setModelName(modelName);
            car.setManufacturerName(manufacturerName);
            car.setEngine(new Engine(Engine.type.Diesel));
        }
        CAR_REPOSITORY_MAP.put(carId, car);
    }

    @Override
    public List<Car> readAll() {
        return null;
    }

    @Override
    public Car read(Long id) {
        return CAR_REPOSITORY_MAP.get(id);
    }

    @Override
    public boolean update(Car car, Long id) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
