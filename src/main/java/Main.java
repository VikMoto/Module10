import java.io.FileReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        String absPath = "E:\\Business\\Code\\Module10\\src\\main\\resources\\words.txt";

        FileReader fr= new FileReader(absPath);
        Scanner scan = new Scanner(fr);
        String expres = "";
        int i = 1;

        while (scan.hasNextLine()) {
             expres = scan.nextLine();
            i++;
        }

        fr.close();
        System.out.println("expres = " + expres);

    }
}