
package chess;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SyBye8898
 */
public class Game {
    
    Board b,undoBoard;
    boolean t;
    int n;
    public boolean[][]validMove=new boolean[8][8];
    public Game(boolean t,int n){
        this.t=t;
        this.n=n;
        b=new Board();
    }
    public Game(Board b){
        this.b=b.clone();
    }
    public void Move(int a,int c,int x,int y,int p){//n is piece number
        //GOTTA INCLUDE PAWN->QUEEN RULE
        validMove=b.analyzeBoard(p,a,c);
        if(validMove[x][y]){
            if(b.board[a][c][p]==Piece.NEWPAWN){
                if(a==3){
                    b.board[a][c][p]=Piece.PAWNINDANGER;
                }else{
                    b.board[a][c][p]=Piece.PAWN;
                }
            }
            if(b.board[a][c][p]==Piece.PAWNINDANGER){
                b.board[a][c][p]=Piece.PAWN;
            }
            b.board[x][y][p]=b.board[a][c][p];
            b.board[x][y][(p-1)*(p-1)]=null;
            b.board[a][c][p]=null;
        }
    }
    public Game clone(){
        Game g=new Game(b);
        return g;
    }
    public void saveUndo(){
        undoBoard=b.clone();
    }
}