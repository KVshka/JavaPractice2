import java.util.Random;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.Collections;
import java.util.Set;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

        int[] yearsArr = new int[50];
        Random random = new Random();
        int min = 2000;
        int max = 2025;
        int average = 0;

        for (int i = 0; i < 50; i++){
            int year = random.nextInt(max - min + 1) + min;
            yearsArr[i] = year;
            average += 2025-year;
        }

        average = average/50;

        System.out.printf("Средний возраст авто - %d лет\n", average);

        System.out.println("Годы выпуска после 2015:");

        for (int i = 0; i < yearsArr.length; i++) {
            if (yearsArr[i] > 2015) {
                System.out.println(yearsArr[i]);
            }
        }

        ArrayList<String> carNames = new ArrayList<String>();
        carNames.add("BMW 3 Series");
        carNames.add("Honda Accord");
        carNames.add("Tesla Model 3");
        carNames.add("Chevrolet Camaro");
        carNames.add("Toyota Camry");
        carNames.add("Ford Mustang");
        carNames.add("Toyota Camry");
        carNames.add("Tesla Model S");
        carNames.add("Audi A4");
        carNames.add("Toyota Camry");

        carNames = (ArrayList<String>) carNames.stream().distinct().collect(Collectors.toList());

        Collections.sort(carNames, Collections.reverseOrder());

        System.out.println("Список моделей в обратном алфавитном порядке без дубликатов: " + carNames);

        Set<String> hashSet = new HashSet<>(carNames);

        for (int i = 0; i < carNames.size(); i++) {
            if (carNames.get(i).contains("Tesla")) {
                carNames.set(i, "ELECTRO_CAR");
            }
        }

        System.out.println("Список после замены: " + carNames);
    }
}
