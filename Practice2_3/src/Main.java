import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Добро пожаловать в программу!");

        Set<Car> carsSet = new HashSet<Car>();

        carsSet.add(new Car("1HGCM82633A123456", "Accord", "Honda", 2020, 25000, 1200000));
        carsSet.add(new Car("1HGCM82633A123456", "Accord", "Honda", 2019, 30000, 1150000));
        carsSet.add(new Car("1FMCU0GXXKUA12345", "Escape", "Ford", 2021, 15000, 2000000));
        carsSet.add(new Car("5NMS3CADXLH123456", "Santa Fe", "Hyundai", 2020, 20000, 1800000));
        carsSet.add(new Car("1C4RJFBG5JC123456", "Grand Cherokee", "Jeep", 2018, 40000, 2500000));
        carsSet.add(new Car("1FA6P8TH8J123456", "Mustang", "Ford", 2019, 10000, 3000000));
        carsSet.add(new Car("5YJ3E1EA7KF123456", "Model 3", "Tesla", 2021, 5000, 4500000));
        carsSet.add(new Car("1FMCU0GXXKUA12346", "Explorer", "Ford", 2022, 8000, 3200000));
        carsSet.add(new Car("5NMS3CADXLH123457", "Tucson", "Hyundai", 2021, 12000, 2100000));

        System.out.println("Set с автомобилями без дубликатов:");
        System.out.println(carsSet);

        List<Car> carsList = new ArrayList<Car>(carsSet);
        Collections.sort(carsList);

        System.out.println("Сортировка по году выпуска:");
        System.out.println(carsList);

    }
}