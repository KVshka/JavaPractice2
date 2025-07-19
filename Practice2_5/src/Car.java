import java.util.Objects;

public class Car {

    private String VIN;

    private String Model;

    private String Manufacturer;

    private int Year;

    private int Mileage;

    private int Price;

    private CarType Type;

    public Car(String vin, String model, String manufacturer, int year, int mileage, int price, CarType type) {
        this.VIN = vin;
        this.Model = model;
        this.Manufacturer = manufacturer;
        this.Year = year;
        this.Mileage = mileage;
        this.Price = price;
        this.Type = type;
    }

    public String getVin() { return VIN; }
    public String getManufacturer() { return Manufacturer; }
    public int getYear() { return Year; }
    public int getPrice() { return Price; }
    public CarType getType() { return Type; }

    @Override
    public boolean equals(Object obj){
        if (!(obj instanceof Car)) return false;
        Car car = (Car) obj;
        return this.VIN.equals(car.VIN);
    }

    @Override
    public int hashCode(){
        return Objects.hash(VIN);
    }

    @Override
    public String toString(){
        return String.format("""
                VIN: %s
                Модель: %s
                Производитель: %s
                Год выпуска: %d
                Пробег: %d км
                Цена: %d руб
                Тип: %s
                """, VIN, Model, Manufacturer, Year, Mileage, Price, Type);
    }
}