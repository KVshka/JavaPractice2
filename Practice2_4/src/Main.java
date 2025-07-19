import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("Добро пожаловать в программу!");

        List<Car> carsList = new ArrayList<>();

        carsList.add(new Car("1HGCM82633A123456", "Accord", "Honda", 2020, 25000, 1200000));
        carsList.add(new Car("1FMCU0GXXKUA12345", "Escape", "Ford", 2021, 15000, 2000000));
        carsList.add(new Car("5NMS3CADXLH123456", "Santa Fe", "Hyundai", 2020, 20000, 1800000));
        carsList.add(new Car("1C4RJFBG5JC123456", "Grand Cherokee", "Jeep", 2018, 40000, 2500000));
        carsList.add(new Car("1FA6P8TH8J123456", "Mustang", "Ford", 2019, 10000, 3000000));
        carsList.add(new Car("5YJ3E1EA7KF123456", "Model 3", "Tesla", 2021, 50000, 4200000));
        carsList.add(new Car("1FMCU0GXXKUA12346", "Explorer", "Ford", 2022, 58000, 3000000));
        carsList.add(new Car("5NMS3CADXLH123457", "Tucson", "Hyundai", 2021, 12000, 2100000));

        var carsFilter = carsList.stream()
                .filter(x -> x.getMileage() < 50000)
                .sorted()
                .toList();

        System.out.println("Машины с пробегом менее 50000 км:");
        System.out.println(carsFilter);

        System.out.println("3 самые дорогие машины:");
        System.out.println(carsFilter.subList(0, 3));

        OptionalDouble averageMileage = carsList.stream()
                .mapToInt(Car::getMileage)
                .average();

        System.out.println("Средний пробег всех машин: " + averageMileage);

        Map<String, List<Car>> carsMap = carsList.stream()
                .collect(Collectors.groupingBy(Car::getManufacturer));

        System.out.println(carsMap);
    }
}
