import java.util.Scanner;

public class tictactoe{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] board = new char[3][3];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = ' ';
            }
        }

        char player = 'X';
        boolean gameOver = false;

        while(!gameOver){
            printBoard(board);
            System.out.println("Player "+player+" enter");
            int row = sc.nextInt();
            int col = sc.nextInt();
            if(board[row][col]==' '){
                board[row][col] = player;
                gameOver = hasWon(board,player);
                if(gameOver){
                    System.out.println("player "+player+" has won!");
                }else{
                    if(player=='X'){
                        player = 'O';
                    }
                    else{
                        player = 'X';
                    }
                }
            }
            else{
                System.out.println("Invalid input, Please try again!");       
            }
        }
        sc.close();
    }

    public static boolean hasWon(char[][] board, char player){
        // this for loop is used to check if the first row is filled with same letter or not
        for (int row = 0; row < board.length; row++) {
            if(board[row][0]== player && board[row][1]== player && board[row][2]==player){
                return true;
            }
        }
        // this for loop is used to check if the first column is filled with same letter or not
        for (int col = 0; col < board.length; col++) {
            if(board[0][col]==player && board[1][col]==player && board[2][col]==player){
                return true;
            }
        }
        // this loop is used to check for the diagonal elements is filled with the same letter or not first diagonal
        if(board[0][0]==player && board[1][1]==player && board[2][2]==player){
            return true;
        }
        // this loop is used to check the second diagonal from the left hand side
        if(board[0][2]==player && board[1][1]==player && board[2][0]==player){
            return true;
        }
        return false;   
    }

    public static void printBoard(char[][] board){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
        }
    }
}