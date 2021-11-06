package cars;

import java.util.List;

public interface CarService {

    void create(Car car);

    List<Car> readAll();

    Car read(int id);

    boolean update(Car car, int id);

    boolean delete(int id);
}
