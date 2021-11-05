package cars;

import java.util.List;

public interface CarService {

    void create(String manufacturerName,String modelName, String typeEngine);

    List<Car> readAll();

    Car read(Long id);

    boolean update(Car car, Long id);

    boolean delete(Long id);
}
