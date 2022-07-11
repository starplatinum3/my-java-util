package top.starp.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * achieve file copy and delete using recursion
 *
 * @author ForeverLover
 *
 */
public class FileCopyAndDelete {

    // delete files of this path
    public void deleteFile(String path) {
        File f = new File(path);
        if (f.isDirectory()) {
            File[] file = f.listFiles();
            for (File file1 : file) {
                this.deleteFile(file1.toString());
                file1.delete();
            }
        } else {
            f.delete();
        }
        f.delete();
    }

    // copy files from path1 to path2
    public void copyFiles(String fromPath, String toPath) throws IOException {
        File f = new File(fromPath);
        if (f.isDirectory()) {
            File file = new File(toPath);
            if (!file.exists())
                file.mkdir();
            File[] file1 = f.listFiles();
            for (File file2 : file1) {
                copyFiles(file2.toString(), toPath + "/" + file2.getName());
            }
        } else {
            copy(fromPath, toPath);
        }
    }

    // copy file from path1 to path2 one by one
    public void copy(String fromPath, String toPath) throws IOException {

        DataInputStream in = new DataInputStream(new BufferedInputStream(
                new FileInputStream(fromPath)));

        byte[] b = new byte[in.available()];// available返回实际可读字节数，即总大小
        in.read(b);

        DataOutputStream out = new DataOutputStream(new BufferedOutputStream(
                new FileOutputStream(toPath)));
        out.write(b);

        in.close();
        out.close();
    }

    //main method
    public static void main(String[] args) {
        FileCopyAndDelete f = new FileCopyAndDelete();

        // test copy files using recursive
        /*
         * { String path1 = "D://Folder1"; String path2 = "D://Folder2"; try {
         * f.copyFiles(path1, path2); System.out.println("OK,COPY FINISH"); }
         * catch (IOException e) { e.printStackTrace(); } }
         */

        // test delete files using recursive
        /*
         * { f.deleteFile("C://Folder1");
         * System.out.println("OK,DELETE FINISH"); }
         */

    }
}
