import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        System.out.println("Добро пожаловать в наш магазин! \n" +
                "Наш ассортимент:\n" + "1. Хлеб;\n" + "2. Сыр;\n" + "3. Колбаса.");

        List<String> productsList = new ArrayList<>();

        while (true) {

            List<String> products = new ArrayList<>();
            products.add("Хлеб");
            products.add("Сыр");
            products.add("Колбаса");

            List<String> actions = new ArrayList<>();
            actions.add("1. Добавить покупку в список");
            actions.add("2. Показать список покупок");
            actions.add("3. Удалить покупку из списка");

            System.out.println();
            System.out.println("Введите номер операции: " + actions);

            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            int actionChoice = Integer.parseInt(input) - 1;

            if (actionChoice == 0) {
                addProduct(productsList, scanner);
            }
            if (actionChoice == 1) {
                showProductList(productsList);
            }

            if (actionChoice == 2) {
                deleteProduct(productsList);
            }
        }
    }

    private static void deleteProduct(List<String> productsList) {
        showProductList(productsList);
        System.out.println("Какую позицию хотите удалить? Введите номер или название");
        Scanner scanner2 = new Scanner(System.in);
        String choice = scanner2.next();
        try {
            int index = Integer.parseInt(choice) - 1;
            productsList.remove(index);
        } catch (Exception e) {
            productsList.remove(choice);
        }
    }

    private static void addProduct(List<String> productsList, Scanner scanner) {
        System.out.println("Какую покупку Вы хотите добавить?");
        Scanner s = new Scanner(System.in);
        String newProduct = scanner.nextLine();
        productsList.add(newProduct);
        System.out.println("И того в списке покупок " + productsList);
    }

    private static void showProductList(List<String> productsList) {
        for (int i = 0; i < productsList.size(); i++) {
            System.out.println((i + 1) + ". " + productsList.get(i));
        }
    }
}