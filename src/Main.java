/**
 * Created by anurags on 8/24/15.
 */
public class Main {
    private static int longestLen2Unique(String str) {
        int aShortestDist = 0, bShortestDist = 0;
        char a = (char)0, b = (char)0;
        int maxLength = 0, length = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == a) {
                aShortestDist = 0;
                bShortestDist++;
            } else if (str.charAt(i) == b) {
                bShortestDist = 0;
                aShortestDist++;
            } else if (aShortestDist < bShortestDist) {
                length = bShortestDist;
                bShortestDist = 0;
                aShortestDist++;
                b = str.charAt(i);
            } else {
                length = aShortestDist;
                aShortestDist = 0;
                bShortestDist++;
                a = str.charAt(i);
            }

            length++;

            if (length > maxLength) {
                maxLength = length;
            }
        }

        return maxLength;
    }

    private static void test1() {
        String str = "baaaca";

        System.out.println("input: " + str + "; maxLength = " + longestLen2Unique(str));
    }

    private static void test2() {
        String[] strs = new String[] {
                "baaaca",
                "baaacd",
                "baadaac",
                "aaaaaa",
                "abab"
        };

        for (String str : strs) {
            System.out.println("input: " + str + "; maxLength = " + longestLen2Unique(str));
        }
    }

    public static void main(String[] args) {
        test2();
    }
}
