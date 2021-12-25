import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiConverterUtil {

    public static void main(String[] args) {
        String  s2="\uD83C\uDF6D爱";
        String s = emojiConvert1(s2);
//        System.out.println(s);
//        [[%F0%9F%8D%AD]]爱
//        这样可能 回来的时候也要代码转化了
        String s1 = emojiRemove(s2);
        System.out.println(s1);
//        爱
    }


    /**
     * @Description 将字符串中的emoji表情转换成可以在utf-8字符集数据库中保存的格式（表情占4个字节，需要utf8mb4字符集）
     * @param str
     * 待转换字符串
     * @return 转换后字符串
     * @throws UnsupportedEncodingException
     * exception
     */
    public static String emojiConvert1(String str)
           {
        String patternString = "([\\x{10000}-\\x{10ffff}\ud800-\udfff])";
 
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while(matcher.find()) {
            try {
                matcher.appendReplacement(
                        sb,
                        "[["
                                + URLEncoder.encode(matcher.group(1),
                                "UTF-8") + "]]");
            } catch(UnsupportedEncodingException e) {
            }
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    public static String emojiRemove(String str)
    {
        String patternString = "([\\x{10000}-\\x{10ffff}\ud800-\udfff])";

        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while(matcher.find()) {
                matcher.appendReplacement(
                        sb,
                        "");
        }
        matcher.appendTail(sb);
        return sb.toString();
    }


    /**
     * @Description 还原utf8数据库中保存的含转换后emoji表情的字符串
     * @param str
     * 转换后的字符串
     * @return 转换前的字符串
     * exception
     */
    public static String emojiRecovery2(String str){
        String patternString = "\\[\\[(.*?)\\]\\]";
 
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(str);
 
        StringBuffer sb = new StringBuffer();
        while(matcher.find()) {
            try {
                matcher.appendReplacement(sb,
                        URLDecoder.decode(matcher.group(1), "UTF-8"));
            } catch(UnsupportedEncodingException e) {
 
            }
        }
        matcher.appendTail(sb);
        return sb.toString();
    }
 
 
}