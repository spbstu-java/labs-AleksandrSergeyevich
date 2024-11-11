package MovementStrategy; 

public class HorseRideStrategy implements Moving { // Класс, реализующий стратегию езды на лошади
    @Override // Переопределяем метод move интерфейса Moving
    public void move(String move) {
        System.out.printf("%s Герой едет на лошади ! %n", move); // Вывод сообщения о том, что герой едет на лошади
    }
}