import java.util.Objects;

public class Car implements Comparable<Car>{

    private String VIN;

    private String Model;

    private String Manufacturer;

    private int Year;

    private int Mileage;

    private int Price;

    Car(String VIN, String Model, String Manufacturer, int Year, int Mileage, int Price){
        this.VIN = VIN;
        this.Model = Model;
        this.Manufacturer = Manufacturer;
        this.Year = Year;
        this.Mileage = Mileage;
        this.Price = Price;
    }

    public int getPrice() { return Price; }
    public int getMileage() {
        return Mileage;
    }
    public String getManufacturer() {
        return Manufacturer;
    }

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
                Цена : %d руб
                """, VIN, Model, Manufacturer, Year, Mileage, Price);
    }

    @Override
    public int compareTo(Car other) {
        return Integer.compare(other.getPrice(), this.getPrice());
    }

}
