import javax.lang.model.type.ArrayType;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class RenameImport {

    public static void main(String[] args) throws IOException {

        changeImport("src/Employee.txt");
    }


    private static void  changeImport(String fileName) throws IOException {

        ArrayList<String> lines= ReadFromFile.readFileByLinesAndPutInToList(fileName);
        ArrayList<String> result=
                ReadFromFile.changeImport(lines,"com.atguigu.springboot","com.example.demo");
        ReadFromFile.printLines(result);
        WriteToFile.writeLinesToFile("src/result/Employee.txt",result);
        RenameFile.rename("src/result/Employee.txt","src/result/Employee.java");

    }

    public static void  changeImport(ArrayList<String >fileNames) throws IOException {
        System.out.println("change import names");
        for(String fileName:fileNames){
            changeImport(fileName);
        }
        System.out.println("change done");

    }

}

class WriteToFile{
    public static void writeLinesToFile(String fileName,ArrayList<String > lines) throws IOException {
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
        for( String line :lines){
            out.println(line);
        }
        out.close();
    }
}
class ReadFromFile {


    private static Logger logger;
//    public static void readFileByBytes(String fileName) throws IOException {
//        File file = new File(fileName);
//        InputStream in = null;
//        StringBuffer sb = new StringBuffer();
//
//
//
//        if (file.isFile() && file.exists()) { //判断文件是否存在
//            System.out.println("以字节为单位读取文件内容，一次读多个字节：");
//            // 一次读多个字节
//            byte[] tempbytes = new byte[1024];
//            int byteread = 0;
//            in = new FileInputStream(file);
//            ReadFromFile.showAvailableBytes(in);
//            // 读入多个字节到字节数组中，byteread为一次读入的字节数
//            while ((byteread = in.read(tempbytes)) != -1) {
//                //  System.out.write(tempbytes, 0, byteread);
//                String str = new String(tempbytes, 0, byteread);
//                sb.append(str);
//            }
//        } else {
//            logger.info("找不到指定的文件，请确认文件路径是否正确");
//        }
//    }

//    private static void showAvailableBytes(InputStream in) {
//        try {
//            logger.info("当前字节输入流中的字节数为"+in.available());
////                logger.info("当前字节输入流中的字节数为 {} ",in.available());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public static void main(String[] args) throws IOException {

//        String fileName = "D:/file/1.json";
//        String fileName="src/Employee.java";
        String fileName="src/Employee.txt";
        //  String fileName = "D:/file/8.json";
//        readFileByBytes(fileName);
        readFileByLines(fileName);
    }


    /**
     * 以字节为单位读取文件，常用于读二进制文件，如图片、声音、影像等文件。
     */
    public static void readFileByBytes(String fileName) {
        File file = new File(fileName);
        InputStream in = null;
        try {
            System.out.println("以字节为单位读取文件内容，一次读一个字节：");
            // 一次读一个字节
            in = new FileInputStream(file);
            int tempbyte;
            while ((tempbyte = in.read()) != -1) {
                System.out.write(tempbyte);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        try {
            System.out.println("以字节为单位读取文件内容，一次读多个字节：");
            // 一次读多个字节
            byte[] tempbytes = new byte[100];
            int byteread = 0;
            in = new FileInputStream(fileName);
            ReadFromFile.showAvailableBytes(in);
            // 读入多个字节到字节数组中，byteread为一次读入的字节数
            while ((byteread = in.read(tempbytes)) != -1) {
                System.out.write(tempbytes, 0, byteread);
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e1) {
                }
            }
        }
    }

    /**
     * 以字符为单位读取文件，常用于读文本，数字等类型的文件
     */
//    https://www.cnblogs.com/JonaLin/p/11057398.html
    public static void readFileByChars(String fileName) {
        File file = new File(fileName);
        Reader reader = null;
        try {
            System.out.println("以字符为单位读取文件内容，一次读一个字节：");
            // 一次读一个字符
            reader = new InputStreamReader(new FileInputStream(file));
            int tempchar;
            while ((tempchar = reader.read()) != -1) {
                // 对于windows下，\r\n这两个字符在一起时，表示一个换行。
                // 但如果这两个字符分开显示时，会换两次行。
                // 因此，屏蔽掉\r，或者屏蔽\n。否则，将会多出很多空行。
                if (((char) tempchar) != '\r') {
                    System.out.print((char) tempchar);
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            System.out.println("以字符为单位读取文件内容，一次读多个字节：");
            // 一次读多个字符
            char[] tempchars = new char[30];
            int charread = 0;
            reader = new InputStreamReader(new FileInputStream(fileName));
            // 读入多个字符到字符数组中，charread为一次读取字符数
            while ((charread = reader.read(tempchars)) != -1) {
                // 同样屏蔽掉\r不显示
                if ((charread == tempchars.length)
                        && (tempchars[tempchars.length - 1] != '\r')) {
                    System.out.print(tempchars);
                } else {
                    for (int i = 0; i < charread; i++) {
                        if (tempchars[i] == '\r') {
                            continue;
                        } else {
                            System.out.print(tempchars[i]);
                        }
                    }
                }
            }

        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }
//    https://www.cnblogs.com/JonaLin/p/11057398.html
    public  static ArrayList<String > readFileByLinesAndPutInToList(String fileName){
        ArrayList<String> list= new ArrayList<>();
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                System.out.println("line " + line + ": " + tempString);
                list.add(tempString);
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return list;
    }
    /**
     * 以行为单位读取文件，常用于读面向行的格式化文件
     */
    public static void readFileByLines(String fileName) {
        ArrayList<String >lst=readFileByLinesAndPutInToList(fileName);
         printLines(lst);

    }

     public static ArrayList<String > changeImport(ArrayList<String >lines,String toBeChanged,String changeTo){
        int cnt=0;
        for(String line :lines){
//            StringBuilder sb= new StringBuilder(line) ;
            if(line.startsWith("import")){
               line= line.replace(toBeChanged,changeTo);
               lines.set(cnt,line);
//               sb.replace(toBeChanged,changeTo);
            }
            cnt++;
        }
        return lines;

     }
    /**
     * 随机读取文件内容
     */
    public static void readFileByRandomAccess(String fileName) {
        RandomAccessFile randomFile = null;
        try {
            System.out.println("随机读取一段文件内容：");
            // 打开一个随机访问文件流，按只读方式
            randomFile = new RandomAccessFile(fileName, "r");
            // 文件长度，字节数
            long fileLength = randomFile.length();
            // 读文件的起始位置
            int beginIndex = (fileLength > 4) ? 4 : 0;
            // 将读文件的开始位置移到beginIndex位置。
            randomFile.seek(beginIndex);
            byte[] bytes = new byte[10];
            int byteread = 0;
            // 一次读10个字节，如果文件内容不足10个字节，则读剩下的字节。
            // 将一次读取的字节数赋给byteread
            while ((byteread = randomFile.read(bytes)) != -1) {
                System.out.write(bytes, 0, byteread);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (randomFile != null) {
                try {
                    randomFile.close();
                } catch (IOException e1) {
                }
            }
        }
    }

    /**
     * 显示输入流中还剩的字节数
     */
    private static void showAvailableBytes(InputStream in) {
        try {
            System.out.println("当前字节输入流中的字节数为:" + in.available());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printLines(ArrayList<String >lines){
        int cnt=1;
        for( String line :lines){
            System.out.println("line " + cnt + ": " + line);
            cnt++;
        }
    }
//    public static void main(String[] args) throws IOException {
//        String fileName = "C:/temp/newTemp.txt";
//        ReadFromFile.readFileByBytes(fileName);
//        ReadFromFile.readFileByChars(fileName);
//        ReadFromFile.readFileByLines(fileName);
//        ReadFromFile.readFileByRandomAccess(fileName);
//    }
}
//https://zhidao.baidu.com/question/91971366.html
class Test{
    public static void main(String[] args) {
      testChangeImport();
    }

    public  static  void testArrayList(){
        ArrayList<String > lst=new ArrayList<>();
        lst.add("hermit");
        lst.add("purple");

//        for(String &name: lst){
//
//        }
        for(int i=0;i<lst.size();i++){
            lst.set(i,"shit");
        }
        System.out.println(lst);
//        https://www.cnblogs.com/pcheng/p/9897596.html
    }
    public static void testChangeImport(){
        String fileName="src/Employee.txt";

        ArrayList<String> lines= ReadFromFile.readFileByLinesAndPutInToList(fileName);
        ArrayList<String> result=
                ReadFromFile.changeImport(lines,"com.atguigu.springboot","com.example.demo");
        ReadFromFile.printLines(result);


    }
}





//https://blog.csdn.net/qq_24644517/article/details/83346454
class RenameFile {

    public static void main(String[] args) {

    }

    public static void delete() {
//		删除文件或者文件夹
        File file=new File("yyy.txt");
        System.out.println(file.delete());

        File file1=new File("aaa");
        System.out.println(file1.delete());

        File file2=new File("ccc");
        System.out.println(file2.delete());
    }

    public static void rename() {
        //		把文件重命名为指定的文件路径---重命名并可以移动文件到新的路径
        File file1=new File("ooo.txt");
        File file2=new File("D:\\ooo1.txt");
        System.out.println(file1.renameTo(file2));
    }

    public static void rename(String oldName,String newName) {
        //		把文件重命名为指定的文件路径---重命名并可以移动文件到新的路径
//        File oldfile=new File(oldName);
//        File newfile=new File(newName);
        System.out.println(new File(oldName).renameTo(new File(newName)));


    }



}

