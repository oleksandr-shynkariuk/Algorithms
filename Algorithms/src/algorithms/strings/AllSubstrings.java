package algorithms.strings;

/**
 * @author Oleksandr Shynkariuk oleksandr.shynkariuk@gmail.com
 */
public class AllSubstrings {

    public static void main(String[] args) {
        String str = "super";
        substrings(str);
    }

    static void substrings(String str){
        for(int i = 0; i <= str.length(); ++i){      //index i implicitly indicates the substring size!
            for(int j = 0; j <= str.length() - i; ++j){      //index j sets the indicates the start character in a substring
                System.out.println(str.substring(j, i + j));
            }
        }
    }
}
