import java.util.*;
import javax.swing.table.*;
import java.io.*;

public class InsertFileDataToJTable extends AbstractTableModel {
    Vector data;
    Vector columns;

    public InsertFileDataToJTable() {
        String line;
        // Тут храним инфу из файла
        data = new Vector();
        // Тут определяем количество колонок в таблице
        columns = new Vector();
        try {
            // Читаем инфу из файла
            FileInputStream fis = new FileInputStream("D:\\lab4_1\\Temp.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            // Разделителем информации для колонок будет знак тире (-)
            StringTokenizer st1 = new StringTokenizer(br.readLine(), "-");
            while (st1.hasMoreTokens())
                columns.addElement(st1.nextToken());
            while ((line = br.readLine()) != null) {
                StringTokenizer st2 = new StringTokenizer(line, "-");
                while (st2.hasMoreTokens())
                    data.addElement(st2.nextToken());
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getRowCount() {
        return data.size() / getColumnCount();
    }

    public int getColumnCount() {
        return columns.size();
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        return (String) data.elementAt((rowIndex * getColumnCount())
                + columnIndex);
    }

}
