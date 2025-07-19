import java.util.*;

public class Main {
    public static void main(String[] args) {

        CarDealership dealership = new CarDealership();
        //Добавим несколько машин по умолчанию
        dealership.addCar(new Car("1FMCU0GXXKUA12345", "Escape", "Ford", 2021, 15000, 2000000, CarType.SUV));
        dealership.addCar(new Car("5NMS3CADXLH123456", "Santa Fe", "Hyundai", 2020, 20000, 1800000, CarType.SUV));
        dealership.addCar(new Car("1C4RJFBG5JC123456", "Grand Cherokee", "Jeep", 2018, 40000, 2500000, CarType.SUV));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.printf("""
                                Меню:
                                1. Добавить машину
                                2. Найти машины по производителю
                                3. Средняя цена по типу
                                4. Отсортировать по году выпуска
                                5. Статистика
                                6. Показать все машины
                                0. Выход
                                Выберите пункт: """);

            int choice = scanner.nextInt();
            scanner.nextLine(); //Очистка буфера

            switch (choice) {
                case 1:
                    System.out.print("VIN: ");
                    String vin = scanner.nextLine();
                    System.out.print("Модель: ");
                    String model = scanner.nextLine();
                    System.out.print("Производитель: ");
                    String manufacturer = scanner.nextLine();
                    System.out.print("Год выпуска: ");
                    int year = scanner.nextInt();
                    System.out.print("Пробег: ");
                    int mileage = scanner.nextInt();
                    System.out.print("Цена: ");
                    int price = scanner.nextInt();
                    System.out.print("Тип: ");
                    CarType type = CarType.valueOf(scanner.nextLine().toUpperCase());
                    scanner.nextLine();

                    Car newCar = new Car(vin, model, manufacturer, year, mileage, price, type);
                    boolean added = dealership.addCar(newCar);
                    if (added) System.out.println("Машина добавлена");
                    else System.out.println("Ошибка: VIN уже существует");
                    break;

                case 2:
                    System.out.print("Введите производителя: ");
                    String m = scanner.nextLine();
                    List<Car> byMan = dealership.manufacturerFilter(m);
                    byMan.forEach(System.out::println);
                    break;

                case 3:
                    System.out.print("Введите тип машины: ");
                    CarType t = CarType.valueOf(scanner.nextLine().toUpperCase());
                    double avg = dealership.averagePrice(t);
                    System.out.println("Средняя цена: " + avg + "$");
                    break;

                case 4:
                    dealership.sortedByYear().forEach(System.out::println);
                    break;

                case 5:
                    System.out.println("Количество по типам:");
                    dealership.countByType().forEach((k, v) -> System.out.println(k + ": " + v));
                    dealership.getOldestCar().ifPresent(car -> System.out.println("Старая: " + car));
                    dealership.getNewestCar().ifPresent(car -> System.out.println("Новая: " + car));
                    break;

                case 6:
                    dealership.getAllCars().forEach(System.out::println);
                    break;

                case 0:
                    System.out.println("Выход...");
                    return;

                default:
                    System.out.println("Неверный ввод");
            }
        }
    }
}