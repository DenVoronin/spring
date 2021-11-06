package cars;

import cars.controller.CarService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class CarServiceImpl implements CarService {

    private static final Map<Integer, Car> CAR_REPOSITORY_MAP = new HashMap<>();
    private static final AtomicInteger CAR_ID_HOLDER = new AtomicInteger();
    //потом сделать через БД!

    @Override
    public void create(Car car) {
        final int carId = CAR_ID_HOLDER.incrementAndGet();

            car.setId(carId);
            car.setModelName(car.modelName);
            car.setManufacturerName(car.manufacturerName);
            car.setEngine(car.engine.powerUp());
            System.out.println("add: "+car.toString());
        CAR_REPOSITORY_MAP.put(carId, car);
    }

    @Override
    public List<Car> readAll() {
        return new ArrayList<>(CAR_REPOSITORY_MAP.values());
    }

    @Override
    public Car read(int id) {
        return CAR_REPOSITORY_MAP.get(id);
    }

    @Override
    public boolean update(Car car, int id) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
