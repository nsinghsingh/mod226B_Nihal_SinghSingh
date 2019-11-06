package TicTacToe;

public class TicTacToeAI {

    int bestIndex;
    int bestScore = -1000000;
    int score;

    public void calculateMove(String[][] squares, int depth, int currentPlayer) {
        for (int i = 0; i < 9; i++) {
            String[][] copy = deepCopy(squares, 3, 3);
            if (copy[i / 3][i % 3].equals("")) {
                if (currentPlayer == 1) {
                    copy[i / 3][i % 3] = "X";
                    currentPlayer = 2;
                } else {
                    copy[i / 3][i % 3] = "O";
                    currentPlayer = 1;
                }
                depth += 1;
                score += calculateScore(copy , depth);
                calculateMove(copy, depth, currentPlayer);
                depth -= 1;
                if (depth == 1) {
                    if (score > bestScore) {
                        bestScore = score;
                        bestIndex = i;
                    }
                    score = 0;
                    currentPlayer = 2;
                }
            }
        }
    }

    public int calculateScore(String[][] squares, int depth) {
        for (int i = 0; i < 3; i++) {
            if (squares[i][0].equals(squares[i][1]) && squares[i][0].equals(squares[i][2]) && !squares[i][0].equals("")) {
                if (squares[i][0].equals("X")) {
                    return -10 * (9-depth);
                } else {
                    return 10 - depth;
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            if (squares[0][i].equals(squares[1][i]) && squares[0][i].equals(squares[2][i]) && !squares[0][i].equals("")) {
                if (squares[i][0].equals("X")) {
                    return -10 * (9-depth);
                } else {
                    return 10 - depth;
                }
            }
        }
        if (squares[0][0].equals(squares[1][1]) && squares[0][0].equals(squares[2][2]) && !squares[0][0].equals("")) {
            if (squares[0][0].equals("X")) {
                return -10 * (9-depth);
            } else {
                return 10 - depth;
            }
        }
        if (squares[2][0].equals(squares[1][1]) && squares[2][0].equals(squares[0][2]) && !squares[2][0].equals("")) {
            if (squares[2][0].equals("X")) {
                return -10 * (9-depth);
            } else {
                return 10 - depth;
            }
        }
        return 0;
    }

    public String[][] deepCopy(String[][] input, int x, int y) {
        String[][] result = new String[x][y];
        for (int i = 0; i < input.length; i++) {
            result[i] = input[i].clone();
        }
        return result;
    }

    public int getBestIndex() {
        int copy = bestIndex;
        bestIndex = 0;
        bestScore = -1000000;
        score = 0;
        return copy;
    }

}
