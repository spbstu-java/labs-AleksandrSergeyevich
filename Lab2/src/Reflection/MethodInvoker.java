package Reflection;

import java.lang.reflect.Method;

public class MethodInvoker {

    public static void main(String[] args) {
        Reflection myObject = new Reflection();
        Class<?> clazz = myObject.getClass();

        // Получаем все методы класса
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            // Проверяем, что метод защищённый или приватный
            int modifiers = method.getModifiers();
            if (!(java.lang.reflect.Modifier.isPrivate(modifiers) || java.lang.reflect.Modifier.isProtected(modifiers))) {
                continue; // Пропускаем, если метод не приватный и не защищённый
            }

            // Проверяем, есть ли аннотация @Repeat
            if (method.isAnnotationPresent(Repeat.class)) {
                Repeat repeat = method.getAnnotation(Repeat.class);
                int times = repeat.value();

                method.setAccessible(true); // Делаем метод доступным

                for (int i = 0; i < times; i++) {
                    try {
                        // Генерируем массив параметров с нужной длиной и значениями по умолчанию
                        Object[] params = getDefaultParameters(method.getParameterTypes());

                        // Вызываем метод с параметрами
                        method.invoke(myObject, params);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    // Метод для генерации параметров по умолчанию
    private static Object[] getDefaultParameters(Class<?>[] parameterTypes) {
        Object[] params = new Object[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            Class<?> paramType = parameterTypes[i];

            if (paramType == int.class) {
                params[i] = 42; 
            } else if (paramType == double.class) {
                params[i] = 3.14; 
            } else if (paramType == boolean.class) {
                params[i] = true; 
            } else if (paramType == String.class) {
                params[i] = "default"; 
            } else if (paramType == String[].class) {
                params[i] = new String[]{"Hello", "World"}; // Массив строк
            } else if (paramType == double[].class) {
                params[i] = new double[]{1.1, 2.2}; // Массив чисел с плавающей точкой
            } else {
                params[i] = null; 
            }
        }

        return params;
    }
}