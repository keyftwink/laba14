package com.company;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Functions functions = new Functions();
        System.out.println("Введите число: ");
        Scanner in = new Scanner(System.in);
        double x = in.nextDouble();

        System.out.printf("Результат: " + "%.2f", functions.function(x));
        System.out.println("\nМожно ввести команды: save - для сохранения, upload - для загрузки данных, stop - прекращение работы");

        Scanner in1 = new Scanner(System.in);

        while (true) {
            String command = in1.nextLine();
            if (command.equalsIgnoreCase("save")) {
                try {
                    FileWriter writer = new FileWriter("saveFile.txt");
                    writer.write("Исходное значение: " + x + " Результат: " + functions.function(x));
                    System.out.println("Успешно сохранено!");
                    writer.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (command.equalsIgnoreCase("upload")) {
                try {
                    BufferedReader reader = new BufferedReader(new FileReader("saveFile.txt"));
                    System.out.println(String.valueOf(reader.readLine()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if(command.equalsIgnoreCase("stop")){
                System.out.println("Выключение...");
                break;
            } else {
                System.out.println("Можно ввести команды: save - для сохранения, upload - для загрузки данных, stop - прекращение работы");
            }
        }
    }
}
    class Functions implements Serializable{
    public  double function(double x) {
        return x - Math.sin(x);
    }
}