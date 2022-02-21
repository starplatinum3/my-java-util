package sqlGen;

//import com.sun.org.slf4j.internal.Logger;
//import com.sun.org.slf4j.internal.LoggerFactory;

//import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.stream.Collectors;

//import common.Commons;
//import entity.SqliteCol;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import java.util.logging.Logger;

/***
 *
 * @Author : 吟雪情枫

 * @Description 根据实体类生成建库语句

 * @Version : v1.0.0

 * @Date : Created in 2020/7/31 10:12

 * @Modified By :
 **/

//@Slf4j
//https://blog.csdn.net/weixin_36090220/article/details/114213993
public class SqlGenerator {

    //    private static final int  = 465;
    public static final String CAMEL = "camel";
    public static final String UNDERLINE = "underline";

//    private static final Logger logger = LoggerFactory.getLogger(SqlGenerator.class);

    /**
     * 用来存储Java等属性类型与sql中属性类型的对照
     * <p>
     * <p>
     * <p>
     * 例如：java.lang.Integer 对应 integer
     */

    public static Map<String, String> map = new HashMap<>();
    public static Map<String, String> mapSQLite = new HashMap<>();

    static void putMapSQLite() {
//        Set
//        HashSet
//        mapSQLite.put("class java.lang.String", "varchar(255)");
//        mapSQLite.put("class java.lang.String", "VARCHAR(255)");
        mapSQLite.put("class java.lang.String", "TEXT");

        mapSQLite.put("class java.lang.Integer", "INTEGER");

        mapSQLite.put("class java.lang.Long", "BIGINT");

        mapSQLite.put("class java.lang.byte[]", "BLOB");

//        mapSQLite.put("class java.lang.Boolean", "TINYINT");
        mapSQLite.put("class java.lang.Boolean", "INTEGER");

        mapSQLite.put("class java.math.BigInteger", "VARCHAR(255)");

        mapSQLite.put("class java.lang.Float", "FLOAT");

        mapSQLite.put("class java.lang.Double", "DOUBLE");

        mapSQLite.put("class java.sql.Date", "DATETIME");

        mapSQLite.put("class java.sql.Time", "DATETIME");

        mapSQLite.put("class java.sql.Timestamp", "DATETIME");

        mapSQLite.put("class java.util.Date", "DATETIME");

        mapSQLite.put("class java.lang.Byte", "TINYINT");
        mapSQLite.put("int", "INTEGER");
        mapSQLite.put("double", "DOUBLE");
        mapSQLite.put("long", "BIGINT");
//        mapSQLite.put("boolean", "TINYINT");
        mapSQLite.put("boolean", "INTEGER");
        mapSQLite.put("float", "FLOAT");
        mapSQLite.put("byte", "TINYINT");
    }


    static void run() {
        map.put("class java.lang.String", "varchar(255)");

        map.put("class java.lang.Integer", "int");

//        map.put("class java.lang.Long", "integer unsigned");
//        map.put("class java.lang.Long", "long int");
//        map.put("class java.lang.Long", "long");
        map.put("class java.lang.Long", "int");

        map.put("class java.lang.byte[]", "blob");

        map.put("class java.lang.Boolean", "bit");

        map.put("class java.math.BigInteger", "bigint unsigned");

        map.put("class java.lang.Float", "float");

//        map.put("class java.lang.Double", "long float");
        map.put("class java.lang.Double", "double");

        map.put("class java.sql.Date", "datetime");

        map.put("class java.sql.Time", "time");

        map.put("class java.sql.Timestamp", "datetime");

        map.put("class java.util.Date", "datetime");

        map.put("class java.lang.Byte", "tinyint");

        putMapSQLite();
        sqlConstruction();

    }
//    void moveJavaCode(File file){
//        try ( Scanner scanner  =new Scanner(file)){
//            while (scanner.hasNextLine()) {
//                String line = scanner.nextLine();
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//
//    }
    void moveAndroidCode(){
//        D:\moveAndDir
        File file = new File("D:\\moveAndDir");
//        String[] list = file.list();
//        java
        File[] files = file.listFiles();
        for (File file1 : files) {
            String name = file1.getName();
            if(name.endsWith(".java")){

            }
        }
//        try (new Scanner(new File())){
//
//        }
    }

    public static void main(String[] args) throws ClassNotFoundException {
        run();
//        Class.forName("zucc.kinect.entity.RedPacketRecord");
//       String s=getStandardFields("comAddr");
//        System.out.println(s);
    }

    /**
     * 生成sql建库语句
     */

    private static void sqlConstruction() {
//实体类所在的package在磁盘上的绝对路径


//        String packageName = "F:/article/newbee-mall/src/main/java/ltd/newbee/mall/entity";
//
////生成sql的文件夹
////        这个是整个path  sqlFile.sql
//        String filePath = "F:/article/newbee-mall/newbee";
//
//
////项目中实体类的路径
//
//        String prefix = "ltd.newbee.mall.entity.";


//        String packageName = "G:\\project\\springbootProj\\bankedback\\src\\main\\java\\zucc\\kinect\\entity";
////生成sql的文件夹
////        这个是整个path  sqlFile.sql
//        String filePath = "G:\\sqlFile\\kinectSql";
//
////项目中实体类的路径
////        前面多写了 空格 ，怪不得
//        String prefix = "zucc.kinect.entity.".trim();
//
//
//        String className = "";

//        String packageName = "G:\\project\\Android\\AlarmClock\\app\\src\\main\\java\\cn\\chenjianlink\\android\\alarmclock\\model";
//        String packageName = "G:\\project\\javaProj\\gaoji\\src\\gitignore\\util\\entity";
////生成sql的文件夹
////        这个是整个path  sqlFile.sql
//        String filePath = "G:\\project\\Android\\AlarmClock\\doc\\AlarmClock.sql";
////        AlarmClock
////项目中实体类的路径
////        前面多写了 空格 ，怪不得
////        String prefix = "cn.chenjianlink.android.alarmclock.model.".trim();
////        String prefix = "gitignore.util.".trim();
//        String prefix = "gitignore.util.entity.".trim();
////        String className = "";
////        prefix 需要是这个项目的 而不是 你想要的


//        String packageName = "G:\\project\\javaProj\\myJavaUtil\\src\\main\\java\\genentity";
//        String packageName = "G:\\project\\springbootProj\\pz-blog\\src\\main\\java\\com\\pz\\pojo";
////生成sql的文件夹
////        这个是整个path  sqlFile.sql
//        String filePath = "G:\\project\\Android\\AlarmClock\\doc\\AlarmClock2.sql";
////        AlarmClock
////项目中实体类的路径
////        前面多写了 空格 ，怪不得
////        String prefix = "cn.chenjianlink.android.alarmclock.model.".trim();
////        String prefix = "gitignore.util.".trim();
////        String prefix = "gitignore.util.entity.".trim();
//        String prefix = "genentity.".trim();
////        String className = "";
////        prefix 需要是这个项目的 而不是 你想要的

//        String packageName = "G:\\project\\springbootProj\\pz-blog\\src\\main\\java\\com\\pz\\pojo";
//        String filePath = "G:\\project\\springbootProj\\pz-blog\\doc\\data.sql";
//        String prefix = "com.pz.pojo.".trim();

//        String packageName = "G:\\project\\javaProj\\myJavaUtil\\src\\main\\java\\entity";
//        String filePath = "G:\\project\\springbootProj\\pz-blog\\doc\\data.sql";
//        String prefix = "entity.".trim();
        String packageName = "D:\\proj\\javaProj\\my-java-util\\src\\main\\java\\entity";
        String filePath = "G:\\project\\springbootProj\\pz-blog\\doc\\data.sql";
        String prefix = "entity.".trim();

        boolean doWriteFile = false;


//        G:\project\Android\AlarmClock\app\src\main\java\cn\chenjianlink\android\alarmclock\model\AlarmClock.java
        StringBuilder sqls = new StringBuilder();

//获取包下的所有类名称

        List<String> list = getAllClasses(packageName);

        if (list == null) {
//            logger.error("getAllClasses 是空");
//            log.error("getAllClasses 是空");
//            log.e
            System.out.println("getAllClasses 是空");
            return;
        }
        for (String str : list) {
//            String str = (String) oStr;
            String className = prefix + str.substring(0, str.lastIndexOf("."));

//            我目前是不写入 file的
            String sql = generateSql(className, filePath);

            String tableName = "clock_table";
            String idName = "clock_id";
            String sqlMigration = generateSqlMigration(className,
                    "", tableName, idName);
//            System.out.println("sqlMigration:");
//            System.out.println(sqlMigration);

            sqls.append(sql);

        }

        System.out.println("================");
        System.out.println("建表语句");
        System.out.println(sqls.toString());


//        StringToSql(sqls.toString(), filePath + ".sql");
        if (doWriteFile) {
            StringToSql(sqls.toString(), filePath);

        }

    }

    /**
     * 根据实体类生成建表语句
     *
     * @param className 全类名
     * @param filePath  磁盘路径
     * @return
     */

    public static String generateSql(String className, String filePath) {

        return generateSql(className, filePath, "");

    }


    /**
     *
     * @param className    className 比如 com.sun.accessibility.J
     * @param filePath
     * @param clzNamePrefix
     * @return
     */
    public static String generateSql(String className, String filePath, String clzNamePrefix) {
        try {
//            System.out.println(className);
//            System.out.println("className: "+className);
//          Class  redPacketRecordClz= Class.forName("zucc.kinect.entity.RedPacketRecord");
//            System.out.println(redPacketRecordClz.getName());
            Class clz = Class.forName(className);
//            className 比如 com.sun.accessibility.J

//            这个需要是 项目里面的类
            className = clz.getSimpleName();

// 表表名adminUser → tb_admin_user

            className = clzNamePrefix + getStandardFields(className);

            Field[] fields = clz.getDeclaredFields();

            StringBuilder column = new StringBuilder();

            String varchar = " CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,";
//            String filedType = UNDERLINE;
//            String filedType = CAMEL;
            String filedType = UNDERLINE;
            for (Field f : fields) {
                int modifiers = f.getModifiers();
                if (Modifier.isStatic(modifiers)) {

                    continue;
                }
                String name = f.getName();
                if (f.getName().equals("id")) continue;
                if(name.equals("serialVersionUID"))continue;
//                if ("class java.lang.String".equals(f.getType().toString())) {
//                    column.append(" \n `").append(getStandardFields(f.getName())).append("`").append(" ")
//                            .append(map.get(f.getType().toString())).append(varchar);
//
//                } else {
////                    变成下划线
//                    column.append(" \n `").append(getStandardFields(f.getName())).append("`").append(" ")
//                            .append(map.get(f.getType().toString())).append(",");
//
//                }
//                column.append(" \n `").append(getStandardFields(f.getName())).append("`").append(" ")
//                        .append(map.get(f.getType().toString()));
                column.append(" \n `").append(getFieldStr(f.getName(), filedType))
                        .append("`").append(" ")
                        .append(map.get(f.getType().toString()));
                if ("class java.lang.String".equals(f.getType().toString())) {
//                    column.append(" \n `").append(getStandardFields(f.getName())).append("`").append(" ")
//                            .append(map.get(f.getType().toString())).append(varchar);
                    column.append(varchar);
                } else {
//                    变成下划线
//                    column.append(" \n `").append(getStandardFields(f.getName())).append("`").append(" ")
//                            .append(map.get(f.getType().toString())).append(",");
                    column.append(",");
                }

            }

            return "\n DROP TABLE IF EXISTS `" + className + "`; " +
                    " \n CREATE TABLE `" + className + "` (" +
                    " \n `id` int(11) NOT NULL AUTO_INCREMENT," +
                    " \n " + column +
                    " \n PRIMARY KEY (`id`) USING BTREE," +
                    "\n INDEX `id`(`id`) USING BTREE" +
                    " \n ) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci;\n";

        } catch (ClassNotFoundException e) {
//            logger.debug("该类未找到！" + className);
//            log.debug("该类未找到！" + className);
//            log.
            System.out.println("该类未找到！" + className);
            return null;

        }

    }

    static String getFieldStr(String fieldName, String type) {
        if (type.equals(UNDERLINE)) {
            return getStandardFields(fieldName);
        }
        return fieldName;
    }

    /**
     * 转换为标准等sql字段 例如 adminUser → admin_user
     *
     * @param str 转换为字符串的字段名
     * @return
     */

    public static String getStandardFields(String str) {
        StringBuilder sb = new StringBuilder();

//        boolean firstUpperAfterUnder=false;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

//            if (i != 0 && (c >= 'A' && c <= 'Z')) {
            if (c >= 'A' && c <= 'Z') {
                if(i!=0){
                    sb.append("_");

                }
//                firstUpperAfterUnder=true;
                c = Character.toLowerCase(c);

            }
//lower char java
//            https://www.runoob.com/java/character-tolowercase.html
            sb.append(c);

        }

        return sb.toString();

    }


    /**
     * 获取包下面等所有实体类名称，类似于获取 XXX.java
     *
     * @param packageName 全类名
     * @return
     */

    public static List<String> getAllClasses(String packageName) {
        List<String> classList = new ArrayList<>();

        String className = "";

//        try(  File f = new File(packageName)){
//
//        }
        File f = new File(packageName);

        if (f.exists() && f.isDirectory()) {
            File[] files = f.listFiles();

// 遍历实体类下面等所有.java文件 获取其类名
//file 不用close 的啊，这没有
            for (File file : files) {
                className = file.getName();

                classList.add(className);

            }

            return classList;

        } else {
//            logger.debug("包路径未找到！");
//            log.debug("包路径未找到！");
            System.out.println("包路径未找到！");
            return null;

        }

    }


    public static String generateSqlMigration(String className,
                                              String clzNamePrefix, String tableName,
                                              String idName) {
//        String  fieldType="underline";
//        String  fieldType="camel";
//        String  fieldType= Commons.CAMEL;
        String fieldType = CAMEL;
        try {
//            System.out.println(className);
//            System.out.println("className: "+className);
//          Class  redPacketRecordClz= Class.forName("zucc.kinect.entity.RedPacketRecord");
//            System.out.println(redPacketRecordClz.getName());
            Class clz = Class.forName(className);

//            这个需要是 项目里面的类
            className = clz.getSimpleName();

// 表表名adminUser → tb_admin_user

            className = clzNamePrefix + getStandardFields(className).toLowerCase();

            Field[] fields = clz.getDeclaredFields();
            if (tableName == null) {
                tableName = className;
            }

//            StringBuilder column = new StringBuilder();
//
//            String varchar = " CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,";
//            database.execSQL("CREATE TABLE users_new (userid TEXT, username TEXT, last_update INTEGER, PRIMARY KEY(userid))");
            String insColLst = "";
            List<String> underlineWords = new ArrayList<>();
            List<SqliteCol> sqliteCols = new ArrayList<>();
            for (Field f : fields) {
                if (f.getName().equals("id")) continue;
//                String standardFields = getStandardFields(f.getName());
//                下划线的
                String type = f.getType().toString();
                String field;
                if (fieldType.equals(CAMEL)) {
                    field = f.getName();
                } else {
//                    String underlineWord = getStandardFields(f.getName());
                    field = getStandardFields(f.getName());
                }
//                String underlineWord = getStandardFields(f.getName());
//                String field=f.getName();
//                underlineWords.add(underlineWord);
                SqliteCol sqliteCol = new SqliteCol();
//                sqliteCol.setField(underlineWord.toLowerCase());
                sqliteCol.setField(field);
                sqliteCol.setType(mapSQLite.get(type));
                sqliteCols.add(sqliteCol);
//                String standardFields = getStandardFields(f.getName());
//                column.append(getStandardFields(f.getName())).append(" ").append(mapSQLite.get(type)).append(" , ");
//                if ("class java.lang.String".equals(f.getType().toString())) {
//                    column.append(" \n `").append(getStandardFields(f.getName())).append("`").append(" ")
//                            .append(map.get(f.getType().toString())).append(varchar);
//
//                } else {
//                    column.append(" \n `").append(getStandardFields(f.getName())).append("`").append(" ")
//                            .append(map.get(f.getType().toString())).append(",");
//
//                }
//                insColLst+=standardFields

            }


//            String tableNew=className+"_new";
            String tableNew = tableName + "_new";

            String colsWithTypeAndPrimKey = sqliteCols.stream()
                    .map(o -> o.getField() + " " + o.getType() + " , ").
                            collect(Collectors.joining()) +
                    String.format(" PRIMARY KEY( %s ) ", idName == null ? "id" : idName);
//            idName
            String cols = sqliteCols.stream()
                    .map(SqliteCol::getField).
                            collect(Collectors.joining(", "));


            String createCode = String.format("database.execSQL(\"CREATE TABLE %s ( %s )\");"
                    , tableNew,
                    colsWithTypeAndPrimKey);

            String copyCode = String.format(" database.execSQL(\"INSERT INTO %s" +
                            " ( %s ) SELECT  %s  FROM   %s  \");\n"

                    , tableNew,
                    cols, cols, tableName);

            String dropCode = String.format("database.execSQL(\"DROP TABLE %s \");"

                    , tableName);
            String alterNameCode = String.format(" database.execSQL" +
                            "(\"ALTER TABLE %s RENAME TO %s\");"
                    , tableNew, tableName);
            return "// Create the new table\n" +
                    createCode + "\n" +
                    "//  Copy the data\n" +
                    copyCode + "\n" +
                    "// Remove the old table\n" +
                    dropCode + "\n" +
                    "// Change the table name to the correct one\n" +
                    alterNameCode + "\n";

        } catch (ClassNotFoundException e) {
//            logger.debug("该类未找到！" + className);
//            log.debug("该类未找到！" + className);
            System.out.println("该类未找到！" + className);
            return null;

        }

    }


    /**
     * 将生成等String字符串 写进sql文件
     *
     * @param str  String字符串
     * @param path sql文件路径路径
     */

    public static void StringToSql(String str, String path) {
        byte[] sourceByte = str.getBytes();

        FileOutputStream os = null;

        if (null != sourceByte) {
            try {
//文件路径(路径+文件名)

                File file = new File(path);
                if (file.exists()) {
                    System.out.println("文件已经存在: " + file);
//                    System.out.println("所以我就不写入了");
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("是否覆盖文件?(y/n)");
                    String select = scanner.next();
                    scanner.close();
                    if (select.equals("y")) {

                        //文件输出流用于将数据写入文件

                        os = new FileOutputStream(file);

                        os.write(sourceByte);

                        os.flush();
                        os.close();

                        System.out.println("生成成功!! 位置: " + file);
//                        生成成功!! 位置: G:\project\Android\AlarmClock\doc\AlarmClock.sql.sql

                    }
                    return;
                }


//文件不存在则创建文件，先创建目录

                File dir = new File(file.getParent());

                dir.mkdirs();

                file.createNewFile();

//文件输出流用于将数据写入文件

                os = new FileOutputStream(file);

                os.write(sourceByte);

                os.flush();
                os.close();
//                不close的话，我打开文件，文件管理器就出问题了
//                System.out.println("生成成功!!");
                System.out.println("生成成功!! 位置: " + file);
//                if (!file.exists()) {
//                    File dir = new File(file.getParent());
//
//                    dir.mkdirs();
//
//                    file.createNewFile();
//
//                }


            } catch (Exception e) {
                e.printStackTrace();

            } finally {
// 关闭文件输出流

                try {
                    if (os != null) {
                        os.close();

                    }

                } catch (IOException e) {
                    e.printStackTrace();

                }

            }

        }

    }

}
//————————————————
//        版权声明：本文为CSDN博主「我爱香菜」的原创文章，遵循CC4.0BY-SA版权协议，转载请附上原文出处链接及本声明。
//        原文链接：https://blog.csdn.net/weixin_36090220/article/details/114213993