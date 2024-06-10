import java.util.*;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        solveNQueensUtil(board, 0, result);
        return result;
    }

    private void solveNQueensUtil(char[][] board, int col, List<List<String>> result) {
        if (col == board.length) {
            result.add(constructSolution(board));
            return;
        }

        for (int row = 0; row < board.length; row++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                solveNQueensUtil(board, col + 1, result);
                board[row][col] = '.';
            }
        }
    }

    private boolean isSafe(char[][] board, int row, int col) {
        int i, j;

        // Check this row on the left side
        for (i = 0; i < col; i++) {
            if (board[row][i] == 'Q') {
                return false;
            }
        }

        // Check upper diagonal on left side
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Check lower diagonal on left side
        for (i = row, j = col; j >= 0 && i < board.length; i++, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    private List<String> constructSolution(char[][] board) {
        List<String> solution = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            solution.add(new String(board[i]));
        }
        return solution;
    }

    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        int n = 4; // Number of queens
        List<List<String>> result = nQueens.solveNQueens(n);
        for (List<String> solution : result) {
            System.out.println("Solution:");
            for (String row : solution) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}
