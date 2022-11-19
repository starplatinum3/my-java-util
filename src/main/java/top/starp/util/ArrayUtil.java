package top.starp.util;

//import netscape.javascript.JSObject;

import java.util.List;

public class ArrayUtil {

    void ma(String string){
        //[1,2,3,1]
        //JSObject.
    }
    int[][] doubleDimArrUnwrap() {
//二维数组
        return null;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int n = 0; n < matrix[0].length; n++) {
                System.out.print(ints[n] + " ");
            }
            System.out.println();
        }
    }

    public static <T> void printMatrix(T[][] matrix) {
        for (T[] ints : matrix) {
            for (int n = 0; n < matrix[0].length; n++) {
                System.out.print(ints[n] + " ");
            }
            System.out.println();
        }
    }
    public static <T>  void printListHighLight(List<T>list,List<Integer> HighLightPoses){
//        list.forEach(o);
//        for (T t : list) {
//            if()
//        }
        for (int i = 0; i < list.size(); i++) {
            if(HighLightPoses.contains(i)){
                System.out.print("("+list.get(i)+") ");
            }else{
                System.out.print(list.get(i)+" ");
            }

        }
        System.out.println();
    }

    public static <T>  void printListHighLight(String list,List<Integer> HighLightPoses){
//        list.forEach(o);
//        for (T t : list) {
//            if()
//        }
        for (int i = 0; i < list.length(); i++) {
            if(HighLightPoses.contains(i)){
                System.out.print("("+list.charAt(i)+") ");
            }else{
                System.out.print(list.charAt(i)+" ");
            }

        }
        System.out.println();
    }

    public static <T>  void printListCut(String list,int start,int end){
//        list.forEach(o);
//        for (T t : list) {
//            if()
//        }
        for (int i = 0; i < list.length(); i++) {
            if(start==i){
                System.out.print("("+list.charAt(i)+" ");

            }else if(end==i){
                System.out.print(list.charAt(i)+") ");
            }else{
                System.out.print(list.charAt(i)+" ");
            }


        }
        System.out.println();
    }

    public static <T>  void printListHighLight(T [] list,List<Integer> HighLightPoses){
//        list.forEach(o);
//        for (T t : list) {
//            if()
//        }
        for (int i = 0; i < list.length; i++) {
            if(HighLightPoses.contains(i)){
                System.out.print("("+list[i]+") ");
            }else{
                System.out.print(list[i]+" ");
            }

        }
        System.out.println();
    }


    public static  void printListHighLight(char [] list,List<Integer> HighLightPoses){
//        list.forEach(o);
//        for (T t : list) {
//            if()
//        }
        for (int i = 0; i < list.length; i++) {
            if(HighLightPoses.contains(i)){
                System.out.print("("+list[i]+")");
            }else{
                System.out.print(list[i]);
            }

        }
        System.out.println();
    }
}



