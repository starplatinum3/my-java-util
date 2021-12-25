import java.io.File;

public  class MyFile extends RenameFile{
//    RenameFile renameFile;
//    ReadFromFile readFromFile;
//    WriteToFile writeToFile;
    File file;
    MyFile(){

    }

    MyFile(String  fileName){

    }
    public static void main(String[] args) {
       RenameFile.rename();
       MyFile.rename();
    }
}