import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        HashSet<String> toDoList = new HashSet<>();
        Scanner scanner = new Scanner(System.in);
        String input;
        String code = null;
        String email;
        toDoList.add("apronin@olala.ru");


        do {
            System.out.print("Введите команду и строку: ");
            input = scanner.nextLine().trim();

            String pattern = "^(LIST|DELETE|ADD)( ([\\w\\d._'-']+@[\\w\\d]+\\.[a-z]+))?$";

            Pattern regex = Pattern.compile(pattern);
            Matcher matcher = regex.matcher(input);
            if (matcher.find()) {
                code = matcher.group(1);
                email = matcher.group(2);
            } else {
                System.out.println("Некорректно введена команда или адрес.");
                continue;
            }

            switch (code) {
                case "LIST" -> {
                    // Выводим список адресов
                    System.out.println("Список адресов:");
                    for (String address : toDoList) {
                        System.out.println(address);
                    }
                }
                case "ADD" -> {
                    // Добавляем адрес в список адресов
                    toDoList.add(email.trim());
                    System.out.println("Добавлен адрес " + email);
                }
                case "DELETE" -> {
                    // Удаляем адрес из списка контактов
                    toDoList.remove(email);
                    System.out.println("Из списка адресатов удален " + email);
                }
                case "END" ->
                    // Завершаем программу
                        System.out.println("Программа завершена.");
                default -> System.out.println("Неизвестная команда: " + code);
            }
        } while (!Objects.equals(code, "END"));
    }
}
