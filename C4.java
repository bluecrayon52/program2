/* Nathaniel Clay Arnold 
 * Author: 
 * Program 1 - MyString
 * CSC230-02 Spring 2016
 */

       
package mygame;  

public class C4 extends Game {
   
   private final int ROWS = 6, COLS = 7; 
   private int[][] board = new int[ROWS][COLS];  //final?
   // more than one instance at a time? 

/* 
The Game class has the following public methods that you may utilize:
A constructor that takes a String that is the name of the game 
and an int that represents the number of players for the game – 2 in this case.
A method getName that returns a String that is the name of the game
A method currentTurn that returns the int value of the current player
A method next that sets the turn to the next player
A method winner that outputs the winner of the game
A method getTries that returns an int representing the number of total turns
*/ 



// a constructor that initializes the array to all 0’s
public C4(){
    
    super("connect 4", 2); 
    
    clearboard();  
}
        



// a clearBoard method that sets all values of board to 0a
private void clearboard(){
       for(int i = 0; i < ROWS; i++){
           for(int j = 0; j < COLS; j++){
               board[i][j] = 0; 
           }
       }
}

/* a getPiece method that returns the value of board 
   at the provided row and col
*/ 
public int getPiece(int row, int col){
    return board[row][col]; 
}

// a getTurn method that returns the int value of the current player
public int getTurn(){
   return super.currentTurn(); 
}
/* an isColFull method that returns true if 
the provided col has no more 0 values, otherwise false
*/
public boolean isColFull(int col){
    for( int i = 0; i < ROWS; i++){
        if(board[i][col] == 0){
            return false; 
        }
    }
    return true; 
}

/* an isDiagWinner method that returns true if there are 
4 diagonal int values on board, otherwise false
*/
private boolean isDiagWinner(){
    for(int i = 0; i < 3; i++){
        for(int j = 0; j < 4; j++){
          
        // right to left, bottom to top check 
            if(board[5-i][0+j] == board[4-i][1+j]){
                if(board[4-i][1+j] == board[3-i][2+j]){
                    if(board[3-i][2+j] == board[2-i][3+j]){
                        return true; 
                     }  
                }        
            }
            
        // right to left, bottom to top check 
           if(board[5-i][6-j] == board[4-i][5-j]){
                if(board[4-i][5-j] == board[3-i][4-j]){
                    if(board[3-i][4-j] == board[2-i][3-j]){
                        return true; 
                     }   
                }
            }
           
        }
    }
    return false; 
} 
    
/* an isFull method that returns false if 
board contains any 0 values, otherwise true
*/
public boolean isFull(){
    for(int i = 0; i < ROWS; i++){
        for( int j = 0; j <COLS; j++){
            if(board[i][j]==0){
                return false; 
            }
        }
    }
    return true; 
}

/* an isHorizWinner method that returns true if board contains
4 consecutive int values in the same row, otherwise false
*/
private boolean isHorizWinner(){
for(int i = 0; i < ROWS; i++){
    for(int j = 0; j < 4; j++){
        if(board[i][0+j] == board[i][1+j]){
            if(board[i][1+j] == board[i][2+j]){
                if(board[i][2+j] == board[i][3+j]){
                    return true; 
                }
            }
        }
    }
} 
return false; 
}

/* an isVertWinner method that returns true if board contains 
4 consecutive int values in the same column, otherwise false
*/
private boolean isVertWinner(){
 for(int i = 0; i < COLS; i++){
     for(int j = 0; j < 3; j++){
         if(board[0+j][i] == board[1+j][i]){
             if(board[1+j][i] == board[2+j][i]){
                 if(board[2+j][i] == board[3+j][i]){
                     return true; 
                 }
             }
         }
     }
 }
 return false; 
}

/* an isWinner method that returns true if board contains
4 consecutive int values in the same row, column or diagonal
*/
public boolean isWinner(){
    return isDiagWinner() == true || isHorizWinner() == true 
            || isVertWinner() == true; 
}


// a nextTurn method that advances Game to the next player

public void nextturn(){
    super.next(); 
}
/* a playPiece method that inserts the value of the current player 
into board at the next available row for the given col
*/
public void playPiece(int col){
    if(isColFull(col) == true){
    // throws, try catch? 
    }
    for(int i = 0; i < ROWS; i++){ 
        if (board[i][col] != 0){
            board[i-1][col] = getTurn(); 
        }
    }
}

/* a printBoard method that prints a visual 
representation of the game board to the console
*/
public void printBoard(){
    
}

}