package MovementStrategy; // Пакет для стратегии перемещения

public class WalkStrategy implements Moving { // Класс, реализующий стратегию ходьбы
    @Override // Переопределяем метод move интерфейса Moving
    public void move(String move) {
        // Форматированный вывод сообщения о том, что герой идет.
        System.out.printf("%s Герой идёт ! %n", move); // Используется аргумент move для указания на героя
    }
}