package algorithms.before20200830;

/**
 * @author twt
 * @description
 * @date 2020/08/30
 */
public class ReverseWordsQuestion {

/*    public String reverseWords(String s) {
        if (s.isEmpty()) return s;

        StringBuilder sb = new StringBuilder();
        String[] split = s.split(" ");
        for (int i = 0; i < split.length; i++) {
            String str = split[i];
            int l = str.length();
            char[] chars = str.toCharArray();
            for (int j = 0; j < l / 2; j++) {
                char temp = chars[j];
                chars[j] = chars[l - 1 - j];
                chars[l - 1 - j] = temp;
            }
            if (i == split.length - 1) {
                sb.append(new String(chars));
            } else {
                sb.append(new String(chars)).append(" ");
            }
        }
        return sb.toString();
    }*/

  /*  public String reverseWords(String s) {
        if (s.isEmpty()) return s;
        StringBuilder sb = new StringBuilder();
        String[] split = s.split(" ");
        for (int i = 0; i < split.length; i++) {
            String reverse = new StringBuilder().append(split[i]).reverse().toString();
            sb.append(reverse).append(' ');
        }
        return sb.toString().trim();
    }*/


}
