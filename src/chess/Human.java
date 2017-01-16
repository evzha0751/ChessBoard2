
package chess;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SyBye8898
 */
public class Human extends Player{
    public Human(int playerNum){
        super.playerNum=playerNum;
    }
    @Override
    public void move(int a,int b,int x,int y,Game g){
        g.Move(a,b, x, y,playerNum);
    }
    
}