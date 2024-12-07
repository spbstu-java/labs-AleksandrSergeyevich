package Lab4;

import java.util.*;
import java.util.stream.Collectors;

    public class STreamAPIJAVA {

        // Метод для вычисления среднего значения целых чисел в списке
        public static double computeAverage(List<Integer> integers) {
            return integers.stream()
                    .mapToInt(Integer::intValue)
                    .average()
                    .orElseThrow(() -> new IllegalArgumentException("Список не может быть пустым"));
        }

        // Метод для преобразования строк в верхний регистр с добавлением префикса "_new_"
        public static List<String> toUppercaseWithPrefix(List<String> strings) {
            return strings.stream()
                    .map(s -> "_new_" + s.toUpperCase())
                    .collect(Collectors.toList());
        }

        // Метод для получения квадратов уникальных элементов
        public static List<Integer> getUniqueSquares(List<Integer> integers) {
            return integers.stream()
                    .collect(Collectors.groupingBy(n -> n, Collectors.counting()))
                    .entrySet().stream()
                    .filter(entry -> entry.getValue() == 1)
                    .map(entry -> entry.getKey() * entry.getKey())
                    .collect(Collectors.toList());
        }

        // Метод для извлечения последнего элемента из коллекции
        public static <T> T retrieveLastElement(Collection<T> collection) {
            return collection.stream()
                    .reduce((first, second) -> second)
                    .orElseThrow(() -> new NoSuchElementException("Коллекция пустая"));
        }

        // Метод для вычисления суммы четных чисел в массиве
        public static int calculateEvenSum(int[] numbers) {
            return Arrays.stream(numbers)
                    .filter(n -> n % 2 == 0)
                    .sum();
        }

        // Метод для преобразования списка строк в Map
        public static Map<Character, String> mapStringsToFirstChar(List<String> strings) {
            return strings.stream()
                    .filter(s -> !s.isEmpty())
                    .collect(Collectors.toMap(
                            s -> s.charAt(0),
                            s -> s.substring(1),
                            (existing, replacement) -> existing
                    ));
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            boolean isRunning = true;

            while (isRunning) {
                System.out.println("Выберите действие:");
                System.out.println("1. Вычислить среднее значение списка целых чисел");
                System.out.println("2. Преобразовать строки в верхний регистр с префиксом \"_new_\"");
                System.out.println("3. Получить квадрат уникальных элементов списка");
                System.out.println("4. Извлечь последний элемент коллекции");
                System.out.println("5. Вычислить сумму четных чисел в массиве");
                System.out.println("6. Преобразовать строки в Map (первый символ - ключ, остальные - значение)");
                System.out.println("0. Выход");

                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        System.out.println("Введите числа через пробел:");
                        List<Integer> averageNumbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                                .map(Integer::parseInt)
                                .collect(Collectors.toList());
                        System.out.printf("Среднее значение: %.2f%n", computeAverage(averageNumbers));
                        break;

                    case 2:
                        System.out.println("Введите строки через запятую:");
                        List<String> stringsToTransform = Arrays.stream(scanner.nextLine().split(","))
                                .map(String::trim)
                                .collect(Collectors.toList());
                        List<String> transformedStrings = toUppercaseWithPrefix(stringsToTransform);
                        System.out.println("Преобразованные строки: " + transformedStrings);
                        break;

                    case 3:
                        System.out.println("Введите числа через пробел:");
                        List<Integer> uniqueSquaresInput = Arrays.stream(scanner.nextLine().split("\\s+"))
                                .map(Integer::parseInt)
                                .collect(Collectors.toList());
                        List<Integer> uniqueSquares = getUniqueSquares(uniqueSquaresInput);
                        System.out.println("Квадраты уникальных элементов: " + uniqueSquares);
                        break;

                    case 4:
                        System.out.println("Введите элементы коллекции через запятую:");
                        List<String> collectionInput = Arrays.stream(scanner.nextLine().split(","))
                                .map(String::trim)
                                .collect(Collectors.toList());
                        try {
                            System.out.println("Последний элемент: " + retrieveLastElement(collectionInput));
                        } catch (NoSuchElementException e) {
                            System.out.println("Ошибка: " + e.getMessage());
                        }
                        break;

                    case 5:
                        System.out.println("Введите числа через пробел:");
                        int evenSum = Arrays.stream(scanner.nextLine().split("\\s+"))
                                .mapToInt(Integer::parseInt)
                                .filter(n -> n % 2 == 0)
                                .sum();
                        System.out.println("Сумма четных чисел: " + evenSum);
                        break;

                    case 6:
                        System.out.println("Введите строки через запятую:");
                        Map<Character, String> stringMap = Arrays.stream(scanner.nextLine().split(","))
                                .map(String::trim)
                                .collect(Collectors.toMap(
                                        str -> str.charAt(0),
                                        str -> str.length() > 1 ? str.substring(1) : "",
                                        (existing, replacement) -> existing + replacement
                                ));
                        System.out.println("Результирующая Map: " + stringMap);
                        break;

                    case 0:
                        System.out.println("Выход из программы.");
                        isRunning = false;
                        break;

                    default:
                        System.out.println("Неверный выбор. Попробуйте снова.");
                }
                System.out.println();
            }
            scanner.close();
        }
    }





