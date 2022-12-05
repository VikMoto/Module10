import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;



public class TestUserMain {

    public static void main(String[] args) {
        UserTestJson userTest = new UserTestJson();
        userTest.FileRead();
        userTest.FileWrite();
    }
}
class UserTestJson {

    public ArrayList<User> users = new ArrayList<>();
    public void FileRead() {
        String absPath = "E:\\Business\\Code\\Module10\\src\\main\\resources\\fileTask2.txt";
        File file = new File(absPath);
        if(!file.exists()) {
            throw new RuntimeException("File with name  " + file.getPath() + " not exist");
        }

        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line = bufferedReader.readLine();
            String[] words = line.split(" "); //read first line in file and split into two words
            String[] wordsElement;
            String thisLine = null;
            int index = 0;



            while ((thisLine = bufferedReader.readLine()) != null) {
                //read another lines in file and split into two words - name and age

                wordsElement= thisLine.split(" ");

                //add new object in to arraylist
                users.add(new User(wordsElement[0], wordsElement[1]));

                // System.out.println(users.get(index));
                index++;


            }


        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        int index = 0;
        //while (index < users.size()) {

        index++;
        //}


    }

    public void FileWrite() {
        String absPath = "E:\\Business\\Code\\Module10\\src\\main\\resources\\user.json";
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

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(users);
            System.out.println(json);

            bufferedWriter.write(String.valueOf(json));
            //System.out.println("users.size() = " + users.size());
            // System.out.println(users);


        }catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }




}

class  User {
    private String name;
    private  String age;


    public  String getName() {
        return this.name;
    }

    public  void setName(String name) {
        this.name = name;
    }

    public  String getAge() {
        return this.age;
    }

    public  void setAge(String age) {
        this.age = age;
    }



    public User(String name,String age) {
        this.name = name;
        this.age = age;
    }

//    @Override
//    public String toString() {
//        return "\n    {\n" + "        " + "\"" + name + "\": \"" + nameElement + "\",\n"
//                + "        " + "\"" + age  + "\":" + ageElement + "\n    }\n";
//    }
}

