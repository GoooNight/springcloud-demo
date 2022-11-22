package algorithmTest;


/**
 * @author 雨天留恋
 * 句子相似性 III
 */
public class AreSentencesSimilar {
    public static boolean areSentencesSimilar(String sentence1, String sentence2) {
        // 首先判断句子的长度，才能知道谁包含谁
        int length1 = sentence1.length();
        int length2 = sentence2.length();
        String longSentence = length1>=length2?sentence1:sentence2;
        String shortSentence = length1<length2?sentence1:sentence2;
        String[] longWords = longSentence.split(" ");
        String[] shortWords = shortSentence.split(" ");
        int start = 0;
        int end = shortWords.length;
        if (longWords[0].equals(shortWords[0])){
            for (int i = 1; i < shortWords.length; i++) {
                if (!longWords[i].equals(shortWords[i])) {
                    start = i;
                    break;
                }
            }
            if (start != 0){
                for (int j = 0; j < shortWords.length-start; j++) {
                    if (!longWords[longWords.length-1-j].equals(shortWords[shortWords.length-1-j])){
                        return false;
                    }
                }
            }
            return true;
        }else {
            for (int j = 0; j < shortWords.length; j++) {
                if (!longWords[longWords.length-1-j].equals(shortWords[shortWords.length-1-j])){
                    return false;
                }
            }
        }


        return true;

    }

    public static void main(String[] args) {
        System.out.println(areSentencesSimilar("My is is Haley is", "My Haley is"));
    }
}
