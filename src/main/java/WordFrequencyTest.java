public class WordFrequencyTest {

    public static void main(String[] args) {
        WordFrequency wordTest = new WordFrequency();
        wordTest.FileRead();
        wordTest.CountFrequency();
        wordTest.FileWrite();
    }
}
