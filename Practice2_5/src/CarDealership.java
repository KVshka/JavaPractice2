import java.util.*;
import java.util.stream.Collectors;

public class CarDealership {
    private List<Car> inventory = new ArrayList<>();

    //Добавление машины в автоцентр
    public boolean addCar(Car car) {
        boolean exists = inventory.stream().anyMatch(c -> c.getVin().equals(car.getVin()));
        if (exists) {
            return false;
        }
        inventory.add(car);
        return true;
    }

    //Поиск по производителю
    public List<Car> manufacturerFilter(String manufacturer) {
        return inventory.stream()
                .filter(c -> c.getManufacturer().equalsIgnoreCase(manufacturer))
                .collect(Collectors.toList());
    }

    //Средняя цена по типу
    public double averagePrice(CarType type) {
        return inventory.stream()
                .filter(c -> c.getType() == type)
                .mapToDouble(Car::getPrice)
                .average()
                .orElse(0.0);
    }

    //Сортировка по году выпуска
    public List<Car> sortedByYear() {
        return inventory.stream()
                .sorted(Comparator.comparingInt(Car::getYear).reversed())
                .collect(Collectors.toList());
    }

    //Статистика
    public Map<CarType, Long> countByType() {
        return inventory.stream()
                .collect(Collectors.groupingBy(Car::getType, Collectors.counting()));
    }

    public Optional<Car> getOldestCar() {
        return inventory.stream().min(Comparator.comparingInt(Car::getYear));
    }

    public Optional<Car> getNewestCar() {
        return inventory.stream().max(Comparator.comparingInt(Car::getYear));
    }

    public List<Car> getAllCars() {
        return inventory;
    }
}
