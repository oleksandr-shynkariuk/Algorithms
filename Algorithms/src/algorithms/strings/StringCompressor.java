package algorithms.strings;

/**
 * @author Oleksandr Shynkariuk oleksandr.shynkariuk@gmail.com
 */
public class StringCompressor {
    public static void main(String[] args) {
        StringCompressor compressor = new StringCompressor();
        System.out.println(compressor.compress("aabcccccaa"));
        System.out.println(compressor.compress("a"));
        System.out.println(compressor.compress(null));
        System.out.println(compressor.compress("abcde"));
    }

    public String compress(String str){
        if(str != null && str.length() > 1){
            int size = str.length();
            int index = 0;
            char[] arr = new char[size];
            char next;
            int counter = 0;
            for(int i = 0; i < size; ++i){
                ++counter;
                char ch = str.charAt(i);
                next = str.length() > i + 1 ? str.charAt(i + 1) : ' ';
                if(ch != next){
                    arr[index] = ch;
                    ++index;
                    char[] tmp = String.valueOf(counter).toCharArray();
                    if(arr.length <= index + tmp.length){
                        return str;
                    }
                    index = setChar(arr, index, tmp);
                    counter = 0;
                }
            }
            return String.valueOf(arr);
        } else {
            return str;
        }
    }

    private int setChar(char[] arr, int index, char[] tmp){

        for(int i = 0; i < tmp.length; ++i){
            arr[index] = tmp[i];
            ++index;
        }
        return index;
    }
}
