package hero;

import MovementStrategy.Moving; 

public class Hero {
    private Moving moving; // Переменная для хранения текущей стратегии перемещения

    // Метод для установки стратегии перемещения
    public void setMoving(Moving moving) {
        this.moving = moving; // Устанавливаем переданную стратегию перемещения
    }

    // Метод для выполнения перемещения
    public void move(String move) {
        if (moving != null) { // Проверяем, установлена ли стратегия перемещения
            moving.move(move); // Выполняем перемещение с помощью установленной стратегии
        } else {
            System.out.println("Moving strategy is not set!"); // Сообщение об ошибке, если стратегия не установлена
        }
    }
}