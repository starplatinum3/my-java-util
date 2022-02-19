public class ArrayUtil {
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
}
