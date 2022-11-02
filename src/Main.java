import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    private static void showList(List list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int operation;
        List<String> list = new ArrayList<>();


        while (true) {
            System.out.println();
            System.out.println("Выберите операцию и введите номер: ");
            System.out.println("1. Добавить. ");
            System.out.println("2. Показать. ");
            System.out.println("3. Удалить. ");
            System.out.println("4. Найти. ");
            System.out.println("Для выхода введите end. ");
            System.out.println();
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }
            try {
                operation = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод! Повторите попытку! ");
                continue;
            }
            switch (operation) {
                case 1:
                    System.out.println("Какую покупку хотите добавить? ");
                    String item = scanner.nextLine();
                    list.add(item);
                    System.out.println("Итого в списке покупок " + list.size());
                    break;
                case 2:
                    System.out.println("Список покупок: ");
                    showList(list);
                    break;
                case 3:
                    System.out.println("Список покупок: ");
                    showList(list);
                    System.out.println("Какую хотите удалить? Введите номер или название. ");
                    item = scanner.nextLine();
                    try {
                        int number = Integer.parseInt(item);
                        System.out.println("Покупка \"" + list.get(number - 1) + "\" удалена, список покупок: ");
                        list.remove(number - 1);
                    } catch (NumberFormatException e) {
                        System.out.println("Покупка \"" + item + "\" удалена");
                        list.remove(item);
                    }
                    showList(list);
                    break;
                case 4:
                    System.out.println("Введите текст для поиска: ");
                    item = scanner.nextLine();
                    System.out.println("Найдено: ");
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).toLowerCase().indexOf(item.toLowerCase()) != -1) {
                            System.out.println(i + 1 + " " + list.get(i));
                        }
                    }
            }
        }
        System.out.println();
    }
}