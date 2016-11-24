import javax.swing.*;
import java.io.*;


public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        // Указываем в конструкторе нашего класса для работы с файлом путь к нашему файлу
        WorkWithFile fl = new WorkWithFile("D:\\lab4_1\\Temp.txt");

        // Добавим новое определение в файл
        fl.writeFile("Телефон - средство для коммуникацией между абонентами сети");


        // Поиск определения в файле и вывод любых совпадений по определению
        fl.parseFile("Телефон");

        // Удаление из файла
        fl.deleteFile("Browser");


        // Создаем таблицу для вывода информации из файла
        InsertFileDataToJTable model = new InsertFileDataToJTable();
        JTable table = new JTable();
        table.setModel(model);
        JScrollPane scrollpane = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(scrollpane);
        JFrame frame = new JFrame();
        frame.add(panel, "Center");
        frame.pack();
        frame.setVisible(true);
    }
}
