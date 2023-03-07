import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = new ArrayList<>();

        while (true) {
            System.out.println("""
                    Введите номер операции.\s
                    Возможные операции для ввода:\s
                    1. добавить
                    2. показать
                    3. удалить""");
            String input = scanner.nextLine();
            if (input.equals("end")) {
                System.out.println("Программа завершена");
                break;
            }
            //Пользователь вводит номер операции
            int number = Integer.parseInt(input);
            switch (number) {
                case (1):
                    //Программа запрашивает дополнительные данные для совершения операции,
                    productInputting(scanner, list);
                    break;
                case (2):
                    productList(list);
                    //выводит все покупки с их нумерацией
                    break;
                case (3):
                    productList(list);
                    removingIndex(scanner, list);
                    break;
                default:
                    System.out.println("Такой операции нет");
            }
            // переходит обратно к пункту вывода меню
        }
    }

    public static void productInputting(Scanner scanner, List<String> list) {
        System.out.println("Какую покупку хотите добавить?");
        String product = scanner.nextLine();// эти данные вводятся одной строкой
        list.add(product);
        productList(list);
    }

    public static void productList(List<String> list) {
        System.out.println("Ваши покупки: ");
        for (String pr : list) {
            System.out.println(list.indexOf(pr) + 1 + " " + pr);
            //выводит все покупки с их нумерацией
            //Программа выполняет операцию, выводит информацию на экран
        }
        System.out.println("Итого в списке покупок: " + list.size());
    }

    public static void removingIndex(Scanner scanner, List<String> list) {
        System.out.println("Какую позицию хотите удалить? Введите номер или название:");
        productList(list);
        String input = scanner.nextLine();
        try {
            int index = Integer.parseInt(input) - 1;
            list.remove(index);
        } catch (Exception e) {
            list.remove(input);
            System.out.println("Покупка " + "<" + input + ">" + " удалена");
        }
        productList(list);
    }
}


