package top.starp.util;

import java.io.File;
import java.util.Arrays;

public class FileUtil {

    public static void main(String[] args) {
//        D:\proj\springShort\white\White-Jotter\wj-vue\node_modules

        File dir = new File("D:\\proj\\springShort\\white\\White-Jotter\\wj-vue\\node_modules"); //要遍历的目录
        File[] files = dir.listFiles();
        for (File file : files) {
            String name = file.getName();
            if (name.contains("sass")) {
//                System.out.println(name);
                System.out.println(file);
            }
//            "sass".contains()
        }
//        System.out.println(Arrays.toString(files));
//        visitAllDirsAndFiles(dir);
    }

    public static void visitAllDirsAndFiles(File dir) {
        System.out.println(dir);
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (String child : children) {
                visitAllDirsAndFiles(new File(dir, child));
            }
        }
    }

    /**
     * 没有递归
     * @param dir
     */
    public static void visitSonFiles(File dir) {
        System.out.println(dir);
//        dir.
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (String child : children) {
                visitAllDirsAndFiles(new File(dir, child));
            }
        }
    }
}
