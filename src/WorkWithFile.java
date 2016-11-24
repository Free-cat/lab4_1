import java.io.*;
import java.util.Scanner;

public class WorkWithFile {
    private File file;


    // Конструктор класса
    public WorkWithFile(String pathname) {
        this.file = new File(pathname);
    }

    // Поиск по файлу
    public void parseFile(String searchStr) throws FileNotFoundException {
        Scanner scan = new Scanner(this.file);
        while(scan.hasNext()){
            String line = scan.nextLine().toLowerCase().toString();
            if(line.contains(searchStr)){
                System.out.println(line);
            }
        }
    }

    public void deleteFile(String searchStr) throws FileNotFoundException {
        File outputFile = new File("Temp.txt");

        Scanner scan = new Scanner(this.file);
        String data = "";
        while(scan.hasNext()){
            String line = scan.nextLine().toString();
            if(!line.contains(searchStr)){
                data += line+"\n";
            }
        }
        
        try{

            //Если файла нет, создаем его
            if(!this.file.exists()){
                this.file.createNewFile();
            }

            FileWriter fileWritter = new FileWriter(this.file.getAbsoluteFile(),true);
            BufferedReader reader = new BufferedReader(new FileReader(this.file));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
            writer.write(data);
            reader.close();
            writer.close();
            this.file.delete();
            outputFile.renameTo(this.file);

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    // Метод для записи в файл
    public void writeFile(String data)
    {
        try{

            //Если файла нет, создаем его
            if(!this.file.exists()){
                this.file.createNewFile();
            }

            FileWriter fileWritter = new FileWriter(this.file.getAbsoluteFile(),true);
            BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
            bufferWritter.write("\n"+data);
            bufferWritter.close();



        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
