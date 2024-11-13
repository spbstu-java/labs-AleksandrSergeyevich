package Reflection;

public class Reflection {

    
     //Приватный метод, который выводит сообщение на консоль.
     
    @Repeat(3)
    private void privateMethod1(String message) {
        System.out.println("Приватный метод 1: " + message);
    }

    
     // Приватный метод, который выводит заданное число на консоль.
     
    @Repeat(2) 
    private void privateMethod2(int number) {
        System.out.println("Приватный метод 2: " + number);
    }

  
      //Приватный метод, который выводит массив строк на консоль.
    
    @Repeat(1) 
    private void privateMethod3(String[] messages) {
        System.out.println("Приватный метод 3:");
        for (String msg : messages) {
            System.out.println(" - " + msg);
        }
    }

    
     //Защищённый метод, который просто выводит сообщение на консоль.
     
    @Repeat(2)
    protected void protectedMethod1() {
        System.out.println("Защищённый метод 1");
    }

    
     //Защищённый метод, который выводит заданное значение на консоль.
     
    @Repeat(1) 
    protected void protectedMethod2(double value) {
        System.out.println("Защищённый метод 2: " + value);
    }

    
    //Защищённый метод, который выводит массив чисел с плавающей точкой на консоль.
    
    @Repeat(1) 
    protected void protectedMethod3(double[] values) {
        System.out.println("Защищённый метод 3:");
        for (double val : values) {
            System.out.println(" - " + val);
        }
    }

    
    //Публичный метод, который выводит сообщение на консоль.
     
    @Repeat(1) 
    public void publicMethod1() {
        System.out.println("Публичный метод 1");
    }

    
    // Публичный метод, который выводит состояние флага на консоль. 
    
    @Repeat(1)
    public void publicMethod2(boolean flag) {
        System.out.println("Публичный метод 2: " + flag);
    }
}