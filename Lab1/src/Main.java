import hero.Hero;
import MovementStrategy.WalkStrategy;
import MovementStrategy.FlyStrategy;
import MovementStrategy.HorseRideStrategy;
import MovementStrategy.SwimStrategy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Создаём экземпляр героя
        Hero hero = new Hero();
        Scanner scanner = new Scanner(System.in);
        String command;

        // Инструкции для пользователя
        System.out.println("1. Идти");
        System.out.println("2. Ехать на лошади");
        System.out.println("3. Лететь");
        System.out.println("4. Плыть");
        System.out.println("0. Выйти из игры");

        // Бесконечный цикл для получения команд от пользователя
        while (true) {
            System.out.print("Введите команду: ");
            command = scanner.nextLine();

            // Проверка на выход из программы
            if (command.equals("0")) {
                System.out.println("Выход из программы.");
                break; // Завершение цикла и выход из программы
            }

            // Обработка введённой команды
            switch (command) {
                case "1":
                    hero.setMoving(new WalkStrategy()); // Выполняем движение
                    hero.move("Идти"); // Выполняем движение
                    break;
                case "2":
                    hero.setMoving(new HorseRideStrategy()); // Устанавливаем способ перемещения Ехать на лошади
                    hero.move("Ехать на лошади"); // Выполняем движение на лошади
                    break;
                case "3":
                    hero.setMoving(new FlyStrategy()); // Устанавливаем способ перемещения Полёт
                    hero.move("Лететь"); // Выполняем движение Полёт
                    break;
                case "4":
                    hero.setMoving(new SwimStrategy()); // Устанавливаем способ перемещения Вплавь
                    hero.move("Плыть"); // Выполняем движение плыть
                    break;
                default:
                    System.out.println("Неверная команда. Попробуйте снова."); // Обработка неверной команды
            }
        }

        scanner.close(); 
    }
}
