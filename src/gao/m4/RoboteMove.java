package gao.m4;

import java.util.HashSet;
import java.util.Set;

/**
 * <b>移动范围</b></br>
 * 机器人最大移动范围
 * @Company 有谦软联（北京）信息技术有限公司</br>
 * @Version V1.0
 * @Author 高祥
 * @Date 2020/4/8 14:56
 */
public class RoboteMove {
    public static void main(String[] args) {
        System.out.println(movingCount(38,15,9));
        System.out.println(dfsMoveCount(38,15,9));
    }
    public static int movingCount(int m, int n, int k) {
        Set<String> temp = new HashSet<>();
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int a = j/10;
                int b = j%10;
                int c = i/10;
                int d = i%10;
                if(a+b+c+d<=k){
                    if(i==0&&j==0){
                        temp.add(i+"-"+j);
                        count++;
                        continue;
                    }
                    int pi = i-1;
                    int pj = j-1;
                    if(temp.contains(pi+"-"+j)||temp.contains(i+"-"+pj)){
                        temp.add(i+"-"+j);
                        count++;
                    }
                }
            }
        }
        return count;
    }
    public static int dfsMoveCount(int m, int n, int k){
        boolean [][] visited = new boolean[m][n];
        return dfs(0,0,m,n,k,visited);
    }

    public static int dfs(int sr,int sc,int m,int n,int k,boolean[][] visited){
        if(sr==m||sc==n||visited[sr][sc]){
            return 0;
        }
        int a = sr/10;
        int b = sr%10;
        int c = sc/10;
        int d = sc%10;
        if(a+b+c+d<=k){
            int r = 1;
            int s = 0;
            int t = 0;
            visited[sr][sc]=true;
            if(sr<m-1){
                s = dfs(sr+1,sc,m,n,k,visited);
            }
            if(sc<n-1){
                t = dfs(sr,sc+1,m,n,k,visited);
            }
            return r+s+t;
        }
        return 0;
    }
}
