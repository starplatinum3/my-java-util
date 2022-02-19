package leetcode.t1020;

//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSON;
//import top.starp.util.ArrayUtil;
//import sun.security.util.ArrayUtil;

//import java.util.Arrays;
//
class Solution {

    //boolean [] [] vis=new boolean[][];
    boolean[][] vis;
    int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    void dfs(int x, int y, int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        vis[x][y]=true;
        for (int[] ints : dir) {
            //if()
            int nx = x + ints[0];
            int ny = y + ints[1];
            if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                continue;
            }
            if (grid[nx][ny] != 0) {
                continue;
            }
            if(vis[nx][ny] ){
                continue;
            }
            dfs(x + ints[0], y + ints[1], grid);
        }
        //if(x)
    }

    //void test(){
    //    String str1="[[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]";
    //    //String[][] parse1 = JSON.parseObject(str1, String[][].class);
    //    Integer[][] grid = JSON.parseObject(str1, Integer[][].class);
    //    System.out.println("grid");
    //    //System.out.println(Arrays.deepToString(grid));
    //    //printMatrix(grid);
    //    ArrayUtil.printMatrix(grid);
    //    int [][]gridInt=new int[grid.length][grid[0].length];
    //    for (int i = 0; i < grid.length; i++) {
    //        for (int i1 = 0; i1 < grid[0].length; i1++) {
    //            gridInt[i][i1]=grid[i][i1];
    //        }
    //    }
    //    //for (Integer[] integers : grid) {
    //    //    gridInt[]
    //    //}
    //    int cnt = numEnclaves(gridInt);
    //    System.out.println("cnt  "+cnt);
    //    //https://blog.csdn.net/qq_34444616/article/details/120560373
    //}

    void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int n = 0; n < matrix[0].length; n++) {
                System.out.print(ints[n] + " ");
            }
            System.out.println();
        }
    }

    //void printMatrix(int[][] matrix) {
    //    for (int[] ints : matrix) {
    //        for (int n = 0; n < matrix[0].length; n++) {
    //            System.out.print(ints[n] + " ");
    //        }
    //        System.out.println();
    //    }
    //}


    void printMatrix(boolean[][] matrix) {
        for (boolean[] ints : matrix) {
            for (int n = 0; n < matrix[0].length; n++) {
                System.out.print(ints[n] + " ");
            }
            System.out.println();
        }
    }


    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        vis = new boolean[n][m];
        for (int i = 0; i < n - 1; i++) {

            dfs(i,m-1,grid);
            dfs(i,0,grid);
        }

        for (int i = 0; i < m - 1; i++) {

            dfs(n-1,i,grid);
            dfs(0,i,grid);
        }

        System.out.println("vis");
        printMatrix(vis);
        //System.out.println(Arrays.deepToString(vis));

        int cnt=0;
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <m ; j++) {
                if(vis[i][j]==false){
                    cnt++;
                }
            }
        }
        //for (int[] ints : grid) {
        //    int x=ints[0];
        //    int y=ints[1];
        //    if(vis[x][y]==false){
        //        cnt++;
        //    }
        //}

        return cnt;
    }

    //public static void main(String[] args) {
    //    Solution solution=new Solution();
    //    solution.test();
    //}
}