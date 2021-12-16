package ru.vsu.cs.shevchenko_daniil;

import ru.vsu.cs.shevchenko_daniil.utils.ArrayUtils;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleVersion {

    public static void runInCommandLineMode(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        ArgsParser argsParser = new ArgsParser(args);
        String inputFilePath = argsParser.getArgumentValue("-i", "--input-file");
        String outputFilePath = argsParser.getArgumentValue("-o", "--output-file");

        List<Integer> list = new ArrayList<>();
        System.out.println("Прочитать из консоли или из файла? ('Yes' если из консоли и 'No' если из файла)");
        String temp = sc.nextLine();
        if (temp.equals("Yes") || temp.equals("yes")) {
            System.out.println("Введите данные");
            ListProcessing.readList(list);
            System.out.println("Подстрока с наибольшей суммой:");
            ListProcessing.printCollection(ListProcessing.createNewList(list));
        } else if (temp.equals("No") || temp.equals("no")) {
            System.out.println("Данные из файла:");
            ListProcessing.printCollection(ListProcessing.readLineFromFile(inputFilePath));
            System.out.println("Подстрока с наибольшей суммой:");
            ListProcessing.printCollection(ListProcessing.createNewList(ListProcessing.readLineFromFile(inputFilePath)));
            ArrayUtils.writeArrayToFile(outputFilePath, ListProcessing.fromListToIntArray(ListProcessing.createNewList(ListProcessing.readLineFromFile(inputFilePath))));
        } else {
            System.out.println("Некорректный ввод");
        }


    }
}
