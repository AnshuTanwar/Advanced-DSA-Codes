public class LongestCommonSubstring {
    
    public static String longestCommonSubstring(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        
        int[][] dp = new int[m + 1][n + 1];
        int maxLength = 0;
        int endIndex = 0;
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > maxLength) {
                        maxLength = dp[i][j];
                        endIndex = i - 1;
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        
        if (maxLength == 0) {
            return ""; 
        } else {
            return str1.substring(endIndex - maxLength + 1, endIndex + 1);
        }
    }

    public static void main(String[] args) {
        String str1 = "ABCBAAAABBBABCDABABBBAA";
        String str2 = "BDCABAABBABABABBDC";
        
        String longestCommonSubstr = longestCommonSubstring(str1, str2);
        
        if (longestCommonSubstr.isEmpty()) {
            System.out.println("No common substring found.");
        } else {
            System.out.println("Longest common substring: " + longestCommonSubstr);
        }
    }
}
