package Homework_3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        inputInfo();
    }

    public static Object[] inputInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные в формате <Фамилия Имя Отчество дата_рождения номер_телефона пол>: ");
        String input = scanner.nextLine();
        String[] arr = input.split(" ");

        try {
            if (arr.length > 6){
                System.err.println("Ошибка! Введите меньше данных!");
                throw new InvalidNumberOfDataException();
            }
            if (arr.length < 6){
                System.err.println("Ошибка! Введите больше данных!");
                throw new InvalidNumberOfDataException();
            }



            String surname = arr[0];
            String name = arr[1];
            String patronymic = arr[2];
            LocalDate birth = LocalDate.parse(arr[3]);
            int telephoneNumber = Integer.parseInt(arr[4]);
            Character gender = arr[5].toLowerCase().charAt(0);
            arr[5] = gender.toString();
            if(!gender.equals('m') && !gender.equals('f')){
                throw new RuntimeException("Введены некорректные данные в графе <ПОЛ>!");
            }

            writeInFile(arr, surname);

        } catch (DateTimeParseException e) {
            throw new ItIsNotLocalDateExcepton();
        } catch (NumberFormatException e){
            throw new NumberFormatException("Некорректное значение номера телефона!");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Таких данных не найдено! Введены не все данные!");
    }

        System.out.println("Данные успешно записаны!");

        return arr;
    }

    private static void writeInFile(String[] list, String fileName) {
        String path = "src/Homework_3/" + fileName + ".txt";
        File file = new File(path);

        if (!file.exists()) {
            try {
                FileWriter writer = new FileWriter(file);
                for (String item : list) {
                    writer.write("<" + item + ">");
                }
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                FileWriter writer = new FileWriter(path, true);
                StringBuilder sb = new StringBuilder();

                for (String item : list) {
                    sb.append("<" + item + ">");
                }
                BufferedWriter bufferWriter = new BufferedWriter(writer);
                bufferWriter.write("\n");
                bufferWriter.write(String.valueOf(sb));
                bufferWriter.close();
            } catch (IOException e) {
                System.err.println("Упс! Что-то пошло не так!");
                e.printStackTrace();
            }
        }
    }

}
