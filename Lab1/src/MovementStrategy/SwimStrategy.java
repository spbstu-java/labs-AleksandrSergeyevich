package MovementStrategy;  

public class SwimStrategy implements Moving { // Класс, реализующий стратегию плавания
    @Override // Переопределяем метод move интерфейса Moving
    public void move(String move) {
        System.out.printf("%s Герой плывёт ! %n", move); // Вывод сообщения о том, что герой плывет
    }
}