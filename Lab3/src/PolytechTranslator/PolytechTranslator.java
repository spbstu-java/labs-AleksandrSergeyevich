package PolytechTranslator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//СЛОВАРЬ ИСПОЛЬЗОВАН С САЙТА https://studynow.ru/dicta/allwords
//СЛОВАРЬ ИСПОЛЬВАН С САЙТА http://wordsteps.com/vocabulary/words/136958/8000+Основных+английских+слов

	public class PolytechTranslator {
	    private static final String FILE = "EnglishRussian.txt";
	    private Map<String, String> dictionary = new HashMap<>();
	    private int longestPhraseLength = 1;
	    private int direction;
	    
    // Загрузка словаря из файла 
	public void loadDictionary() throws InvalidFormatException, IOExceptionInDictionary {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE))) {
        String line;
    while ((line = reader.readLine()) != null) {
        String[] elements = line.split("\\|");
        if (elements.length == 2) {
        String sourceWord = elements[0].trim().toLowerCase();
        String targetWord = elements[1].trim();
        dictionary.put(sourceWord, targetWord);
        dictionary.put(targetWord, sourceWord);
        int countWords = sourceWord.split(" ").length;
        if (countWords > longestPhraseLength) {
        longestPhraseLength = countWords;
        }
     } 
        else {
        throw new InvalidFormatException("Неверный формат строки в словаре: " + line);
        }   
     }   
 } 
        catch (IOException e) {
        throw new IOExceptionInDictionary("Ошибка при чтении файла словаря: " + e.getMessage());
    }
 }

    // Метод для перевода текста      
        public String translateText(String textToTranslate) {
            String[] words = textToTranslate.split(" ");
            StringBuilder result = new StringBuilder();
            int index = 0;
            
                        while (index < words.length) {
                            boolean matchFound = false;
                            int maxMatchSize = Math.min(longestPhraseLength, words.length - index);

                            for (int length = maxMatchSize; length > 0; length--) {
                                StringBuilder phraseBuilder = new StringBuilder();
                                for (int j = 0; j < length; j++) {
                                    if (j > 0) {
                                        phraseBuilder.append(" ");      
                        
                    }
                    phraseBuilder.append(words[index + j].toLowerCase());
                }
              
            String phrase = phraseBuilder.toString();
            if (dictionary.containsKey(phrase)) {
                result.append(dictionary.get(phrase)).append(" ");
                index += length;
                matchFound = true;
                break;
            }
        }
            
            if (!matchFound) {
                result.append(words[index]).append(" "); // Если перевод не найден, слово остается на изначальном языке.
                index++;
            }
        }

        return result.toString().trim(); // Возвращаем переведённый текст
    }

    // Метод для проверки, соответствует ли текст выбранному направлению перевода  
    private boolean isValidInput(String userInput) {
        if (direction == 1) { // Английский на русский
            return userInput.matches("[a-zA-Z0-9\\s]+");
        } else { // Русский на английский
            return userInput.matches("[а-яА-ЯёЁ0-9\\s]+");
        }
    }
    
        public static void main(String[] args) {
        	PolytechTranslator translator = new PolytechTranslator();
        try {
            translator.loadDictionary(); // Загружаем словарь
        } catch (InvalidFormatException e) {
            System.err.println("Ошибка формата файла словаря: " + e.getMessage());
            return;
        } catch (IOExceptionInDictionary e) {
            System.err.println("Ошибка чтения файла словаря: " + e.getMessage());
            return;
        }
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите направление перевода (1 - с английского на русский, 2 - с русского на английский):");
        translator.direction = scanner.nextInt();
        scanner.nextLine(); // Считываем остаток строки

        	while (true) {
        		System.out.println("Введите текст для перевода (или введите 'exit' для выхода):");
            	String input = scanner.nextLine(); // Считываем текст вход
            
            
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Выход из программы.");
                break;
            }

            // Проверка на соответствие символов
            
            if (!translator.isValidInput(input)) {
                System.out.println("Ошибка: введите текст только на " + (translator.direction == 1 ? "английском" : "русском") + "");
                continue;
            }

            String translatedOutput = translator.translateText(input);
            System.out.println("Translation: " + translatedOutput); // Вывод результата
        }

        scanner.close(); // Закрываем конце работы
    }

    public static class InvalidFormatException extends Exception {
        public InvalidFormatException(String message) {
            super(message);
        }
    }

    public static class IOExceptionInDictionary extends Exception {
        public IOExceptionInDictionary(String message) {
            super(message);
        }
    }
}
