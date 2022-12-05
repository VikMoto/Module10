import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckValidPhone {
    static int size = 100;
    static String mask1 = "\\({1}\\d{3}\\){1}\\s\\d{3}-{1}\\d{4}";

    static String mask2 = "\\d{3}-{1}\\d{3}-{1}\\d{4}";
    public static ArrayList<String> readedFile = new ArrayList<>();
    public static ArrayList<String> validedPhone;
    public static void FileRead() {
        String absPath = "E:\\Business\\Code\\Module10\\src\\main\\resources\\fileTask1.txt";
        File file = new File(absPath);
        if(!file.exists()) {
            throw new RuntimeException("File with name  " + file.getPath() + " not exist");
        }

        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            int index = 0;
            String line = bufferedReader.readLine();

            while (line != null) {
                readedFile.add(line);
                index++;
                System.out.println(line);
                line = bufferedReader.readLine();
            }
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void FileWrite() {
        String absPath = "E:\\Business\\Code\\Module10\\src\\main\\resources\\fileTask1Out.txt";
        File fileOut = new File(absPath);
        if(!fileOut.exists()) {
            fileOut.getParentFile().mkdirs();
            try {
                fileOut.createNewFile();
            } catch (IOException e) {
                System.out.println("e.getMessage() = " + e.getMessage());
            }
        }
        try (FileWriter fileWriter = new FileWriter(fileOut)
             ;
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            for (int i = 0; i < validedPhone.size(); i++) {
                bufferedWriter.write(validedPhone.get(i) + "\n");
            }

        }catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }
    private static void ValidedPhone() {
        int count = 0;

        Pattern ptrnMask1;
        Pattern ptrnMask2;
        Matcher matcherMask1;
        Matcher matcherMask2;


        for (int i = 0; i < readedFile.size(); i++) {
                ptrnMask1 = Pattern.compile(mask1);
                matcherMask1 = ptrnMask1.matcher(readedFile.get(i));
                ptrnMask2 = Pattern.compile(mask2);
                matcherMask2 = ptrnMask2.matcher(readedFile.get(i));
            if (matcherMask1.find() || matcherMask2.find()) {
                count++;
            }
        }
        System.out.println("count = " + count);
        validedPhone = new ArrayList<>(count);
        count = 0;
        String element;

        for (int i = 0; i < readedFile.size(); i++) {
            ptrnMask1 = Pattern.compile(mask1);
            matcherMask1 = ptrnMask1.matcher(readedFile.get(i));
            ptrnMask2 = Pattern.compile(mask2);
            matcherMask2 = ptrnMask2.matcher(readedFile.get(i));
            if (matcherMask1.find() || matcherMask2.find()) {
                element = readedFile.get(i);
                validedPhone.add(element);
                System.out.println(validedPhone.get(count));
                count++;
            }
        }

    }

    public static void main(String[] args) {
        FileRead();
        ValidedPhone();
        FileWrite();
    }


}
