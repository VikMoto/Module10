import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class WordFrequency {
    public ArrayList<String> words = new ArrayList<>();

    public HashMap<String, Integer> freq = new HashMap<>();
    public HashMap<String, Integer> freqSorted = new HashMap<>();
    public Map<String, Integer> orderedMap;
    String wordsResult = "";
    public void FileRead() {
        String absPath = "E:\\Business\\Code\\Module10\\src\\main\\resources\\words.txt";
        File file = new File(absPath);
        if(!file.exists()) {
            throw new RuntimeException("File with name  " + file.getPath() + " not exist");
        }

        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {



            String[] wordsElement;
            String thisLine = null;
            int index = 0;
            while ((thisLine = bufferedReader.readLine()) != null) {
                //read another lines in file and split into two words - name and age

                wordsElement = thisLine.split(" ");

                //add new object in to arraylist
                for (int i = 0; i < wordsElement.length; i++) {


                    words.add(wordsElement[i]);
                }
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
        System.out.println(words);

    }



    public void CountFrequency() {


        for (int i = 0; i < words.size(); i++) {
            String elemWord = words.get(i);
            int num = 0;
            for (int j = 0; j < words.size(); j++) {
                if(elemWord.equals(words.get(j))) {
                    num++;
                }
            //freqArr.add(new Word(elemWord, num));
            freq.put(elemWord,num);
            }

        }

        /** sort Map by Value
         * **********************************************************************************
         * **********************************************************************************
         */
        orderedMap = freq.entrySet().stream()
                .sorted(Map.Entry.comparingByValue((a, b) -> b - a))
                .collect(LinkedHashMap::new,(m, c) -> m.put(c.getKey(), c.getValue()),
                        LinkedHashMap::putAll);

//        freq.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue))
//                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(e1, e2) -> e1, HashMap::new));

         mapToString();
         System.out.println(orderedMap);
    }

    private void mapToString () {
        for (Map.Entry m: orderedMap.entrySet()) {
            wordsResult = wordsResult + m.getKey() + " " + m.getValue() + "\n";
        }
    }

    public void FileWrite() {
        String absPath = "E:\\Business\\Code\\Module10\\src\\main\\resources\\wordsfrequency.txt";
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


            bufferedWriter.write(wordsResult);
            //System.out.println("users.size() = " + users.size());
            // System.out.println(users);


        }catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }




}



//class Word {
//    private  String name;
//    private  int freq;
//
//    public  String getName() {
//        return this.name;
//    }
//
//    public  void setName(String name) {
//        this.name = name;
//    }
//
//    public  int getFreq() {
//        return this.freq;
//    }
//
//    public  void setFreq(int freq) {
//        this.freq = freq;
//    }
//
//
//
//    public Word(String name, int freq) {
//        this.name = name;
//        this.freq = freq;
//
//    }
//
//    @Override
//    public String toString() {
//        return  name + " " + freq;
//    }
//}
