public class MatrixChainMultiplication {
    
    public static int matrixChainOrder(int[] dimensions) {
        int n = dimensions.length - 1; 
        int[][] dp = new int[n][n];
   
        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
        }
        
        for (int length = 2; length <= n; length++) {
            for (int i = 0; i < n - length + 1; i++) {
                int j = i + length - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + dimensions[i] * dimensions[k + 1] * dimensions[j + 1];
                    if (cost < dp[i][j]) {
                        dp[i][j] = cost;
                    }
                }
            }
        }
        return dp[0][n - 1];
    }
    
    public static void main(String[] args) {
        int[] dimensions = {30, 35, 15, 5, 10, 20, 25}; 
        int minCost = matrixChainOrder(dimensions);
        System.out.println("Minimum number of multiplications required: " + minCost);
    }
}
