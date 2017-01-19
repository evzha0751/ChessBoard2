/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.*;
import javax.swing.*;
        
public class Chess extends javax.swing.JFrame {
    boolean aiChooesed;
    int colorChoosed;
    JLabel [] [] gridboard= new JLabel [8][8];
    JLabel [] [] gridboard1= new JLabel [8][8];
    Game game=new Game(true,1);
    Player[] p={new Human(0),new AI(1)};
    int moveNum=0,selectX=-1,selectY=-1;
    boolean pieceSelected=false;
    public void display(){
        ImageIcon[] icon = new ImageIcon[13];
        icon[0] = new ImageIcon("src/chess/0.png");
        icon[1] = new ImageIcon("src/chess/1.png");
        icon[2] = new ImageIcon("src/chess/2.png");
        icon[3] = new ImageIcon("src/chess/3.png");
        icon[4] = new ImageIcon("src/chess/4.png");
        icon[5] = new ImageIcon("src/chess/5.png");
        icon[6] = new ImageIcon("src/chess/6.png");
        icon[7] = new ImageIcon("src/chess/7.png");
        icon[8] = new ImageIcon("src/chess/8.png");
        icon[9] = new ImageIcon("src/chess/9.png");
        icon[10] = new ImageIcon("src/chess/10.png");
        icon[11] = new ImageIcon("src/chess/11.png");
        icon[12] = new ImageIcon("src/chess/12.png");
        for(int j=0;j<8;j++){
            for(int i=0;i<8;i++){
                if(game.b.board[i][j][0]!=null){
                    switch(game.b.board[i][j][0]){
                        case PAWNINDANGER:
                        case NEWPAWN:
                        case PAWN:
                            gridboard[i][j].setIcon(icon[1]);
                            break;
                        case ROOK:
                            gridboard[i][j].setIcon(icon[2]);
                            break;
                        case KNIGHT:
                            gridboard[i][j].setIcon(icon[3]);
                            break;
                        case BISHOP:
                            gridboard[i][j].setIcon(icon[4]);
                            break;
                        case QUEEN:
                            gridboard[i][j].setIcon(icon[5]);
                            break;
                        case KING:
                            gridboard[i][j].setIcon(icon[6]);
                            break;
                        default:
                            gridboard[i][j].setIcon(icon[0]);
                    }
                }
                if(game.b.board[i][j][1]!=null){
                    switch(game.b.board[i][j][1]){
                        case PAWNINDANGER:
                        case NEWPAWN:
                        case PAWN:
                            gridboard[i][j].setIcon(icon[7]);
                            break;
                        case ROOK:
                            gridboard[i][j].setIcon(icon[8]);
                            break;
                        case KNIGHT:
                            gridboard[i][j].setIcon(icon[9]);
                            break;
                        case BISHOP:
                            gridboard[i][j].setIcon(icon[10]);
                            break;
                        case QUEEN:
                            gridboard[i][j].setIcon(icon[11]);
                            break;
                        case KING:
                            gridboard[i][j].setIcon(icon[12]);
                            break;
                        default:
                            gridboard[i][j].setIcon(icon[0]);
                    }
                }
                if(game.b.board[i][j][1]==null&&game.b.board[i][j][0]==null){
                    gridboard[i][j].setIcon(icon[0]);
                }
            }
        }
        
    }
    
    public Chess() {
        initComponents();
        p[0]=new Human(0);
        p[1]=new AI(1);
        //piecesPanel1.setBounds(55,55,600,600);
        // make grid 
        gridboard = new JLabel [8][8];
        ImageIcon greenBox = new ImageIcon("src/chess/13.png");
        piecesPanel.setLayout(new GridLayout (8,8,0,0));
        for (int y = 0; y < 8; y++){
            for (int x = 0; x < 8; x++){
//                String position = Integer.toString(x) + ", " + Integer.toString(y);
                gridboard[7-y][x] = new JLabel(); //adds text for debugging
//                gridboard[x][y].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                
                gridboard[7-y][x].setPreferredSize(new Dimension(75,75));
                
                piecesPanel.add(gridboard[7-y][x]);
                
            }
        }
        
        // make grid 
        
        
        display();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chessPanel = new javax.swing.JPanel();
        backgroundPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        piecesPanel = new javax.swing.JPanel();
        piecesPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        xin = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        yin = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        ain = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        bin = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        chessPanel.setOpaque(false);
        chessPanel.setPreferredSize(new java.awt.Dimension(710, 710));

        backgroundPanel.setOpaque(false);
        backgroundPanel.setPreferredSize(new java.awt.Dimension(710, 710));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chess/chessboard.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout backgroundPanelLayout = new javax.swing.GroupLayout(backgroundPanel);
        backgroundPanel.setLayout(backgroundPanelLayout);
        backgroundPanelLayout.setHorizontalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 20, Short.MAX_VALUE))
        );
        backgroundPanelLayout.setVerticalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 22, Short.MAX_VALUE))
        );

        piecesPanel.setOpaque(false);
        piecesPanel.setPreferredSize(new java.awt.Dimension(600, 600));
        piecesPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                piecesPanelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout piecesPanelLayout = new javax.swing.GroupLayout(piecesPanel);
        piecesPanel.setLayout(piecesPanelLayout);
        piecesPanelLayout.setHorizontalGroup(
            piecesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        piecesPanelLayout.setVerticalGroup(
            piecesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        piecesPanel1.setOpaque(false);
        piecesPanel1.setPreferredSize(new java.awt.Dimension(600, 600));
        piecesPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                piecesPanel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout piecesPanel1Layout = new javax.swing.GroupLayout(piecesPanel1);
        piecesPanel1.setLayout(piecesPanel1Layout);
        piecesPanel1Layout.setHorizontalGroup(
            piecesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 625, Short.MAX_VALUE)
        );
        piecesPanel1Layout.setVerticalGroup(
            piecesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 625, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout chessPanelLayout = new javax.swing.GroupLayout(chessPanel);
        chessPanel.setLayout(chessPanelLayout);
        chessPanelLayout.setHorizontalGroup(
            chessPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 710, Short.MAX_VALUE)
            .addGroup(chessPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(chessPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(piecesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(chessPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(chessPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(backgroundPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(chessPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, chessPanelLayout.createSequentialGroup()
                    .addContainerGap(40, Short.MAX_VALUE)
                    .addComponent(piecesPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(45, 45, 45)))
        );
        chessPanelLayout.setVerticalGroup(
            chessPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 710, Short.MAX_VALUE)
            .addGroup(chessPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(chessPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(piecesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(chessPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(chessPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(backgroundPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(chessPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, chessPanelLayout.createSequentialGroup()
                    .addContainerGap(40, Short.MAX_VALUE)
                    .addComponent(piecesPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(45, 45, 45)))
        );

        jLabel2.setText("x");

        jLabel3.setText("y");

        jLabel4.setText("a");

        jLabel5.setText("b");

        jButton1.setText("MOVE!");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("UNDO!");

        jButton3.setText("EXIT");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(chessPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(xin, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(yin))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ain))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bin))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addComponent(jButton1)
                            .addComponent(jButton3))))
                .addGap(0, 65, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(chessPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(xin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(yin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(ain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(bin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        
    }//GEN-LAST:event_jLabel1MouseClicked

    private void piecesPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_piecesPanelMouseClicked
        int x=evt.getX(),y=evt.getY();
        int LabelX,LabelY;
        ImageIcon[] icon = new ImageIcon[7];
        if(moveNum==1){
            icon[0] = new ImageIcon("src/chess/g0.png");
            icon[1] = new ImageIcon("src/chess/g1.png");
            icon[2] = new ImageIcon("src/chess/g2.png");
            icon[3] = new ImageIcon("src/chess/g3.png");
            icon[4] = new ImageIcon("src/chess/g4.png");
            icon[5] = new ImageIcon("src/chess/g5.png");
            icon[6] = new ImageIcon("src/chess/g6.png");
        }else{
            icon[0] = new ImageIcon("src/chess/g0.png");
            icon[1] = new ImageIcon("src/chess/g7.png");
            icon[2] = new ImageIcon("src/chess/g8.png");
            icon[3] = new ImageIcon("src/chess/g9.png");
            icon[4] = new ImageIcon("src/chess/g10.png");
            icon[5] = new ImageIcon("src/chess/g11.png");
            icon[6] = new ImageIcon("src/chess/g12.png");
        }
        boolean[][] valid=new boolean[8][8];
        LabelY = x/75;
        LabelX = 7-y/75;
        display();
        if(game.b.board[LabelX][LabelY][p[moveNum].playerNum]!=null){
            valid=game.b.analyzeBoard(p[moveNum].playerNum,LabelX,LabelY);
            pieceSelected=true;
            selectX=LabelX;
            selectY=LabelY;
            for(int j=0;j<8;j++){
            for(int i=0;i<8;i++){
            if(valid[i][j]){
                gridboard[i][j].setIcon(icon[0]);
                if(game.b.board[i][j][(moveNum-1)*(moveNum-1)]!=null){
                    switch(game.b.board[i][j][(moveNum-1)*(moveNum-1)]){
                        case PAWNINDANGER:
                        case NEWPAWN:
                        case PAWN:
                            gridboard[i][j].setIcon(icon[1]);
                            break;
                        case ROOK:
                            gridboard[i][j].setIcon(icon[2]);
                            break;
                        case KNIGHT:
                            gridboard[i][j].setIcon(icon[3]);
                            break;
                        case BISHOP:
                            gridboard[i][j].setIcon(icon[4]);
                            break;
                        case QUEEN:
                            gridboard[i][j].setIcon(icon[5]);
                            break;
                        case KING:
                            gridboard[i][j].setIcon(icon[6]);
                            break;
                    }
                }
                if(game.b.board[i][j][(moveNum-1)*(moveNum-1)]==null&&game.b.board[i][j][moveNum]==null){
                    gridboard[i][j].setIcon(icon[0]);
                }
            }
            
            }
            }
        }else if(pieceSelected){
            p[moveNum].move(selectX,selectY,LabelX,LabelY,game);
            if(game.b.board[LabelX][LabelY][moveNum]!=null){
                //moveNum=(moveNum-1)*(moveNum-1);
                ((AI)p[1]).calculateMove(1,game);
               // moveNum=(moveNum-1)*(moveNum-1);
            }
            pieceSelected=false;
            display();
        }
        
    }//GEN-LAST:event_piecesPanelMouseClicked

    private void piecesPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_piecesPanel1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_piecesPanel1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int x=Integer.parseInt(xin.getText()),y=Integer.parseInt(yin.getText()),
                a=Integer.parseInt(ain.getText()),b=Integer.parseInt(bin.getText());
        p[moveNum].move(x,y,a,b,game);
        if(game.b.board[a][b][moveNum]!=null){
            moveNum=(moveNum-1)*(moveNum-1);
            //((AI)p[1]).calculateMove(5,game);
           // moveNum=(moveNum-1)*(moveNum-1);
        }
        display();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    
  
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Chess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Chess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Chess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Chess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Chess().setVisible(true);
            }
        });
    }
    
     

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ain;
    private javax.swing.JPanel backgroundPanel;
    private javax.swing.JTextField bin;
    private javax.swing.JPanel chessPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel piecesPanel;
    private javax.swing.JPanel piecesPanel1;
    private javax.swing.JTextField xin;
    private javax.swing.JTextField yin;
    // End of variables declaration//GEN-END:variables
    
    
    
    
}
