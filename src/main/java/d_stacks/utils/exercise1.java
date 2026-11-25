package d_stacks.utils;

public class exercise1 {
    public static String exercise1(String word){
        String VOWELS = "aeiouAEIOU";

        char[] array = new char[word.length()];

        for (int i = 0; i < word.length(); i++) {
            array[i] = word.charAt(i);
        }

        char[] vowels = new char[array.length];
        int count1 = 0;

        for (int i = 0; i < array.length ; i++) {
            char ch = array[i];
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                vowels[count1] = ch;
                count1++;
            }
        }
        return null;
    }
}