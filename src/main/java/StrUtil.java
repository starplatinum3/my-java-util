//import org.apache.commons.lang.StringUtils;
//import org.apache.commons.lang.text.StrBuilder;
//
//import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.CharSetUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//https://blog.csdn.net/echizao1839/article/details/80890490
public class StrUtil {
    /**
     * StrUtil 类，声明省略
     */

//
//    public static String getRequestContain(HttpServletRequest request) {
//
//        Enumeration enu = request.getParameterNames();
//        StringBuilder stringBuilder = new StringBuilder();
//        while (enu.hasMoreElements()) {
//            String paraName = (String) enu.nextElement();
//            stringBuilder.append(paraName).append(": ").
//                    append(request.getParameter(paraName)).append(", ");
////        System.out.println(paraName+": "+request.getParameter(paraName));
//        }
//        return stringBuilder.toString();
//    }
    public static String addBackslash(String origin) {
//        return origin.replaceAll("[\"']", "\\\\$0");
        return origin.replace("'", "\\\"");
    }

    //format方法
    public static String formatToFour0(String s) {

//写上你要怎么处理字符串
//这里假定是一个1到4位的整数，不足四位时前面补0
        int len = s.length();
//不足四位
//        https://zhidao.baidu.com/question/175025220.html
        if (len < 4) {
            int prefixNum = 4 - len;//计算要补几个0
//前面补0
            StringBuilder sBuilder = new StringBuilder(s);
            for (int i = 0; i < prefixNum; i++) {
                sBuilder.insert(0, "0");
            }
            s = sBuilder.toString();
        }
        return s;
    }

    //正则表达式   :   完美
    public static boolean isNumber(String str) {
        String reg = "^[0-9]+(.[0-9]+)?$";
        return str.matches(reg);
    }

    //    void leftSlashToRightSlash(String string){
//
//    }

    /**
     * 去掉前面的0的parseInt
     *
     * @param str
     * @return
     */
    public static int parseInt(String str) {

        int start = 0;

        while (str.charAt(start) == '0') start++;
        str = str.substring(start);
        return Integer.parseInt(str);
    }


    void testRegion(){
        //        oneLineJapaneseOneLineChineseShow();
//        and();
//        getLines();
//        getBelowLinesInPara();
//        String str = "1234";
//        String stripChars = "124";
//        3
//        也就是说 stripchars 里面带有的东西 都会被消掉
//        System.out.println(StringUtils.strip(str, stripChars));
//        System.out.println(StringUtils.trim(str));  //消除空格
//        System.out.println(StringStartTrim(str, stripChars));
//        System.out.println(rDelStr(str, stripChars));
//        String string = "1：1";
//        System.out.println(Arrays.toString(string.split("[:：]")));
//
//        String res = addBackslash("{'id':'1','name':'jojo','gender':'男'}");
////        java 有没有类似 r"" python
//
//        System.out.println(res);
        String  string=     "晚上 下面\n" +
                "3.325一盒 \n" +
                "6.0微一你和小在能好时下有不嘻 https://m.tb.cn/h.fUKQs4s?sm=e8d496  奶气有机纯牛奶200ml*12盒3.6g蛋白质牛奶整箱批发营养早餐奶\n" +
                "ghhn\n" +
                "\n" +
                "\n" +
                "cds\n" +
                "sdss蛋白质\n" +
                "d\n" +
                "a\n" +
                "d\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n";
//        List<Region> regions = matchPatternStr(string, ".*蛋白质.*");
        List<Region> regions = matchPatternStr(string, "蛋白质");
        System.out.println("regions");
        System.out.println(regions);
//        regions
//                [Region{start=89, end=92}, Region{start=119, end=122}]

    }

    void testURLDecoder() throws UnsupportedEncodingException {
        //        天津
//        https://zhidao.baidu.com/question/1895414181975091340.html
        String s = URLDecoder.decode("%E5%A4%A9%E6%B4%A5","UTF-8");
        System.out.println(s);
    }
    public static void main(String[] args) throws UnsupportedEncodingException {


//        byte[] bytes = "oahdoah没带嗲😀".getBytes(StandardCharsets.UTF_8);
        byte[] bytes = {(byte) 0xF0, (byte) 0x9F, (byte) 0x8D, (byte) 0xAD};
//        byte[] bytes = {'\xF0',\x9F\x8D\xAD};
//        String s1 = "\xF0\x9F\x8D\xAD";
//        bytes 转化为 字符串
        String s = new String(bytes);
//        🍭
//        尽然 可以 显示
//        如何判断 java utf 是 3字符的 还是 4字符的
//        System.out.println(Arrays.toString(bytes));
//        System.out.println(s);

//        System.out.println("length");
//        System.out.println("爱".getBytes().length);
//        https://zhidao.baidu.com/question/368009596744915364.html
        String  s2="\uD83C\uDF6D爱";
//        byte[] bytes1 = s2.getBytes();
//        System.out.println("bytes1");
//        System.out.println(Arrays.toString(bytes1));
//
//        System.out.println("bytes1.length");
//        System.out.println(bytes1.length);

        for (int i = 0; i <s2.length() ; i++) {
            Character ch=s2.charAt(i);
            String string = ch.toString();
            byte[] bytes2 = string.getBytes();
            System.out.println(string);
            System.out.println("length");
            System.out.println(bytes2.length);
        }
//        ?
//        length
//        1
//                ?
//                length
//        1
//        爱
//                length
//        3


    }

    void find(){

        String string="dada";
//        Pattern datePattern = Pattern.compile(".*蛋白质.*");
//        Pattern datePattern = Pattern.compile(".*(蛋白质).*");
        Pattern datePattern = Pattern.compile("蛋白质");

        Matcher dateMatcher = datePattern.matcher(string);
//        dateMatcher.
        while (dateMatcher.find()){
            int end = dateMatcher.end();
            int start = dateMatcher.start();
            System.out.println("start");
            System.out.println(start);
            System.out.println("end");
            System.out.println(end);
            System.out.println( dateMatcher.group());

        }
    }

    /**
     * 去掉指定字符串的开头的指定字符
     *
     * @param stream 原始字符串
     * @param trim   要删除的字符串
     * @return 这个是trim的前面部分，如果stream里面有的话，会被删掉，比如说
     * trim是124，stream是1234，那么前面一样的12 会被删掉，变成34
     */
    public static String StringStartTrim(String stream, String trim) {
        // null或者空字符串的时候不处理
        if (stream == null || stream.length() == 0 || trim == null || trim.length() == 0) {
            return stream;
        }
        // 要删除的字符串结束位置
        int end;
        // 正规表达式
        String regPattern = "[" + trim + "]*+";
        Pattern pattern = Pattern.compile(regPattern, Pattern.CASE_INSENSITIVE);
        // 去掉原始字符串开头位置的指定字符
        Matcher matcher = pattern.matcher(stream);
        if (matcher.lookingAt()) {
            end = matcher.end();
            stream = stream.substring(end);
        }
        // 返回处理后的字符串
        return stream;
    }

    public static String frontDelStr(String oldStr, String dontWant) {

        if (dontWant.equals("")) {
            return oldStr;
        }
        int oldStrLen = (oldStr).length();
        int dontWantLen = (dontWant).length();
        int minLen = Math.min(oldStrLen, dontWantLen);

        int iOld = 0;
        int iDont = 0;

        int iRes = 0;
        int iNow = 0;
        while (true) {


            if (!(oldStr.charAt(iOld) == dontWant.charAt(iDont))) {
                return oldStr.substring(iRes, oldStrLen - iRes);
            }

            iNow++;
            if (iNow - iRes == dontWantLen) {
                iRes += dontWantLen;

            }
            if (iDont == minLen - 1 || iOld == minLen - 1)
                return oldStr.substring(iRes, oldStrLen - iRes);

            iOld++;
            iDont++;

        }
    }


//  public static String getBasePath(HttpServletRequest request){
//        String path = request.getContextPath();
//      return request.getScheme()+"://"+request.getServerName()
//              +":"+request.getServerPort()+path+"/";
//    }

    /**
     * 从背后删除字符串，比如1234，我不要34，就会得到12.比如1234，我不要2，如果是
     * strip的话，就会把那个2也删掉的，但是我这个是直接忽略，因为最后没有2，返回的
     * 还是1234
     *
     * @param oldStr   原来的字符串
     * @param dontWant 不想要的字符串
     * @return
     */
    public static String rDelStr(String oldStr, String dontWant) {
        //todo ,completed
        if (dontWant.equals("")) {
            return oldStr;
        }
        int oldStrLen = (oldStr).length();
        int dontWantLen = (dontWant).length();
        int iOld = oldStrLen - 1;
        int iDont = dontWantLen - 1;

        int iRes = oldStrLen;
        int iNow = oldStrLen;
        while (true) {


            if (!(oldStr.charAt(iOld) == dontWant.charAt(iDont))) {
                return oldStr.substring(0, iRes);
            }

            iNow -= 1;
            if (iRes - iNow == dontWantLen) {
                iRes -= dontWantLen;

            }
            if (iDont == 0 || iOld == 0)
                return oldStr.substring(0, iRes);

            iOld--;
            iDont--;

        }

    }

//    https://www.iteye.com/blog/full-stack-2174226
    void d() throws UnsupportedEncodingException {
        String encode = "UTF-8";
        // 截取10字节,不出错
        int sublen = 10;
        // UTF-8字节
        String srcStr = "出错出hh错出错hello1出错";
        // 先转化成char
        char[] srcStrChars = srcStr.toCharArray();
        int cnt = 0;
        Charset cs = Charset.forName(encode);
        CharBuffer cb = CharBuffer.allocate(1);
        ByteBuffer resultBuff = ByteBuffer.allocate(sublen);
        for (int i = 0; i < srcStrChars.length; i++) {
            char c = srcStrChars[i];
            cb.put(c);
            cb.flip();
            ByteBuffer bb = cs.encode(cb);
            cnt += bb.array().length;
            if(cnt > sublen){
                break;
            }
            resultBuff.put(bb);
            cb.clear();
        }
        String result = new String(resultBuff.array(), encode);
        System.out.println(result);
    }

    static void getLinesInPara(Place place) {

        System.out.println("get " + (place.equals(Place.BELOW) ? "below" : "up")
                + " lines ,input eof to stop input");
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        List<String> strings = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            if (s.equals("eof")) {
                break;
            }
            if ((i & 1) == (place.equals(Place.BELOW) ? 1 : 0)) {
                strings.add(s);
            }
            i++;
        }
        for (String s : strings) {
            System.out.println(s);
        }
    }

    static void getBelowLinesInPara() {
        getLinesInPara(Place.BELOW);

    }

    //    https://blog.csdn.net/sinaihalo/article/details/80908399
//    @WriteDataSource
    public static void updateEquipmentAssets(String tableName, List<String> keyList, List<String> valueList) {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE ").append(tableName).append(" SET ");//equipmentassetstable
        for (int i = 0; i < keyList.size(); i++) {
            if (!"ID".equals(keyList.get(i))) {
                sb.append(keyList.get(i));
                sb.append("=");
                sb.append("'").append(valueList.get(i)).append("'");
                if (i != keyList.size() - 1) {
                    sb.append(",");
                }
            }

        }
        for (int i = 0; i < keyList.size(); i++) {
            if ("ID".equals(keyList.get(i))) {
                sb.append(" WHERE ID = '").append(valueList.get(i)).append("'");
            }
        }
        //jt.execute(sb.toString());
        System.out.println(sb);
    }

    public static void splitJointUpdateSql(String tableName, Map<String, String> setMap,
                                           Map<String, String> conditionMap) {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE ").append(tableName).append(" SET ");//equipmentassetstable

//        https://www.cnblogs.com/damoblog/p/9124937.html
        int size = setMap.size();
        int i = 0;
        for (Map.Entry<String, String> entry : setMap.entrySet()) {
            String mapKey = entry.getKey();
            String mapValue = entry.getValue();
            sb.append(mapKey).append("='").append(mapValue).append("'");
//            System.out.println(mapKey+":"+mapValue);
            if (i != size - 1) {
                sb.append(",");
            }
            i++;
        }
        i = 0;
        size = conditionMap.size();
        sb.append(" where ");
        for (Map.Entry<String, String> entry : conditionMap.entrySet()) {
            String mapKey = entry.getKey();
            String mapValue = entry.getValue();
            sb.append(mapKey).append("=").append(mapValue);
            if (i != size - 1) {
                sb.append(" and ");
            }
            i++;
        }
//
//        for(int i=0;i<keyList.size();i++){
//            if(!"ID".equals(keyList.get(i))){
//                sb.append(keyList.get(i));
//                sb.append("=");
//                sb.append("'").append(valueList.get(i)).append("'");
//                if(i!=keyList.size()-1){
//                    sb.append(",");
//                }
//            }
//
//        }
//        for(int i=0;i<keyList.size();i++){
//            if("ID".equals(keyList.get(i))){
//                sb.append(" WHERE ID = '").append(valueList.get(i)).append("'");
//            }
//        }
        //jt.execute(sb.toString());
        System.out.println(sb);
    }


    public static StringBuilder listToStringBuilder(List<String> list, String suffix) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : list) {
            stringBuilder.append(string).append(suffix);
        }
        return stringBuilder;
    }

    public static StringBuilder listToStringBuilder(List<String> list, String suffix, Boolean endNo) {
        StringBuilder stringBuilder = new StringBuilder();
        if (endNo) {
            int size = list.size();
            int i = 0;

            for (String string : list) {
                stringBuilder.append(string);
                if (i != size - 1) stringBuilder.append(suffix);
                i++;
            }

        } else {

            for (String string : list) {
                stringBuilder.append(string).append(suffix);

            }
        }
        return stringBuilder;

    }

    public static StringBuilder oneLineJapaneseOneLineChinese(String japanese, String chinese) {
        String[] splitJapanese = japanese.split("\n");
        String[] splitChinese = chinese.split("\n");
        StringBuilder sb = new StringBuilder();
        int len = splitJapanese.length;
        for (int i = 0; i < len; i++) {
            sb.append(splitJapanese[i]).append("\n").append(splitChinese[i]);
        }
        return sb;
    }

    public static StringBuilder oneLineJapaneseOneLineChinese(List<String> japaneseList,
                                                              List<String> chineseList) {
//        String[] splitJapanese = japanese.split("\n");
//        String[] splitChinese = chinese.split("\n");
        StringBuilder sb = new StringBuilder();
        int len = japaneseList.size();
        for (int i = 0; i < len; i++) {
            sb.append(japaneseList.get(i)).append("\n").append(chineseList.get(i)).append("\n");
        }
        return sb;
    }

    //    https://www.runoob.com/java/java-scanner-class.html
    public static void oneLineJapaneseOneLineChineseShow() {
        Scanner scanner = new Scanner(System.in);
        List<String> japaneseList = new ArrayList<>();
        List<String> chineseList = new ArrayList<>();
        // 判断是否还有输入
        System.out.println("把一串日语和一串中文交错放置");
        System.out.println("输入一串日语，以eof结尾，并且回车");
        while (scanner.hasNextLine()) {
            String str1 = scanner.nextLine();
            if (str1.equals("eof")) break;
//            System.out.println("输入的数据为：" + str1);
            japaneseList.add(str1);
        }
        System.out.println("输入一串中文，以eof结尾，并且回车");
        while (scanner.hasNextLine()) {
            String str1 = scanner.nextLine();
            if (str1.equals("eof")) break;
//            System.out.println("输入的数据为：" + str1);
            chineseList.add(str1);
        }
        scanner.close();

        System.out.println(oneLineJapaneseOneLineChinese(japaneseList, chineseList));

    }

    static List<String> getBelowLines(String lines) {

        return getLines(lines, "below");
    }

    static List<String> getLines(String lines, String where) {
        String[] strings = lines.split("\n");
        List<String> belowLines = new ArrayList<>();

        int len = strings.length;
        for (int i = 0; i < len; i++) {
            if ((i & 1) == (where.equals("below") ? 1 : 0)) {
                belowLines.add(strings[i]);
            }
        }
        return belowLines;
    }

    static void and() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i & 1);
        }
    }

//    public static void main(String[] args) {
//        StrUtil.addBackslash()
//    }

    public  static  List<Region> matchPatternStr(String string , String  patternStr){
//        String line = "2016年10月11日我們去哪里玩近期我們近日，次年，同年等等，10月，2019年，3月4日";

//        String  patternStr;
//        Pattern datePattern = Pattern.compile("\\d{4}年\\d{1,2}月\\d{1,2}日|\\d{4}年\\d{1,2}月|\\d{1,2}月\\d{1,2}日|\\d{4}年|\\d{1,2}月|同年|次年|近日|近期");
        Pattern pattern = Pattern.compile(patternStr);

        Matcher matcher = pattern.matcher(string);

//        int dateCount = 0;

//        List<int[]>list=new ArrayList<>();
        List<Region> regions=new ArrayList<>();
        while(matcher.find()) {
//            dateMatcher.regionStart()
//            找到了 开始
//            dateMatcher.regionStart()
//            int[]
//            Region region=new Region(  dateMatcher.regionStart(),  dateMatcher.regionEnd());
            Region region=new Region(  matcher.start(),  matcher.end());
            regions.add(region);
//            String group = dateMatcher.group();
//            System.out.println(dateMatcher.group());

//            ++dateCount;

        }
        return regions;
//————————————————
//        版权声明：本文为CSDN博主「weixin_39999222」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
//        原文链接：https://blog.csdn.net/weixin_39999222/article/details/114782840
    }




}

