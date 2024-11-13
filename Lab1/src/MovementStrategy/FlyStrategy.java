package MovementStrategy; 

public class FlyStrategy implements Moving { // Класс, реализующий стратегию летания
    @Override // Переопределяем метод move интерфейса Moving
    public void move(String move) {
        System.out.printf("%s Герой летит ! %n", move); // Вывод сообщения о том, что герой летит
    }
}