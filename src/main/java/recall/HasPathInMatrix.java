package recall;

/**
 * @Author Lujs
 * @Date 2022/10/6
 * 矩阵中的路径
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，
 * 每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
 * 例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
 * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 */
public class HasPathInMatrix {
    //dfs(初始矩阵，矩阵行数n，矩阵列数m，索引行坐标i，索引纵坐标j，待判断的字符串，待判断字符串的索引[初始为0即先判断字符串的第一位]，标志位数组)
    private boolean dfs(char[][] matrix, int n, int m, int i, int j, String word, int k, boolean[][] flag) {
        if (i < 0 || i >= n || j < 0 || j >= m || matrix[i][j] != word.charAt(k) || flag[i][j] == true){
            //下标越界、字符不匹配、已经遍历过不能重复
            return false;
        }
        //k为记录当前第几个字符
        if (k == word.length()-1){
            return true;
        }
        flag[i][j] = true;
        //该结点任意方向可行就可
        if (dfs(matrix, n, m, i -1, j, word, k + 1, flag)
          ||dfs(matrix, n, m, i+1, j, word, k+1, flag)
          ||dfs(matrix, n, m, i, j-1, word, k+1, flag)
          ||dfs(matrix, n, m, i, j+1, word, k+1, flag)){
            return true;
        }
        //没找到经过此格的，此格未被占用
        flag[i][j] = false;
        return false;
    }

    public boolean hasPath (char[][] matrix, String word) {
        //优先处理特殊情况
        if (matrix.length == 0){
            return false;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        //初始化flag矩阵记录是否走过
        boolean[][] flag = new boolean[n][m];
        //遍历矩阵找起点
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //通过dfs找到路径
                if (dfs(matrix,n,m,i,j,word,0,flag)){
                    return true;
                }
            }
        }
        return false;
    }
}
