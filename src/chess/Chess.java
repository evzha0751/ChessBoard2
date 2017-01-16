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

    JLabel [] [] gridboard= new JLabel [8][8];
    JLabel [] [] gridboard1= new JLabel [8][8];
    Game game=new Game(true,1);
    Human player1=new Human(0);
    AI aiPlayer=new AI(1);
    
    public void display(){
        ImageIcon[] icon = new ImageIcon[14];
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
        icon[13] = new ImageIcon("src/chess/13.png");
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
            }
        }
        
    }
    
    public Chess() {
        initComponents();
        //piecesPanel1.setBounds(55,55,600,600);
        // make grid 
        gridboard = new JLabel [8][8];
        ImageIcon greenBox = new ImageIcon("src/chess/13.png");
        piecesPanel.setLayout(new GridLayout (8,8,0,0));
        for (int y = 0; y < 8; y++){
            for (int x = 0; x < 8; x++){
//                String position = Integer.toString(x) + ", " + Integer.toString(y);
                gridboard[7-y][7-x] = new JLabel(); //adds text for debugging
//                gridboard[x][y].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                
                gridboard[7-y][7-x].setPreferredSize(new Dimension(75,75));
                
                piecesPanel.add(gridboard[7-y][7-x]);
                
            }
        }
        
        // make grid 
        gridboard1 = new JLabel [8][8];
        piecesPanel1.setLayout(new GridLayout (8,8,0,0));
        for (int y = 0; y < 8; y++){
            for (int x = 0; x < 8; x++){
//                String position = Integer.toString(x) + ", " + Integer.toString(y);
                gridboard1[7-y][7-x] = new JLabel(); //adds text for debugging
//                gridboard[x][y].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                
                gridboard1[7-y][7-x].setPreferredSize(new Dimension(75,75));
                
                piecesPanel1.add(gridboard1[7-y][7-x]);
                
            }
        }
        // array for recording pieces
    //    int[][] pieces = new int[8][8];
        
        // add array for icons
        /*ImageIcon[] icon = new ImageIcon[14];
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
        icon[13] = new ImageIcon("src/chess/13.png");*/
        
    /*    gridboard[0][5].setIcon(icon[13]);
        
        //white-----------------------------------------------------------------
        // pawn
        gridboard[0][6].setIcon(icon[1]);
        gridboard[1][6].setIcon(icon[1]);
        gridboard[2][6].setIcon(icon[1]);
        gridboard[3][6].setIcon(icon[1]);
        gridboard[4][6].setIcon(icon[1]);
        gridboard[5][6].setIcon(icon[1]);
        gridboard[6][6].setIcon(icon[1]);
        gridboard[7][6].setIcon(icon[1]);
            // record pieces
            for(int i=0;i<8;i++)
                pieces[i][6] = 1;
                
        // rook
        gridboard[0][7].setIcon(icon[2]);
        gridboard[7][7].setIcon(icon[2]);
             //record pieces
            pieces[0][7]=2;
            pieces[7][7]=2;
            
        // knight
        gridboard[1][7].setIcon(icon[3]);
        gridboard[6][7].setIcon(icon[3]);
             //record pieces
            pieces[1][7]=3;
            pieces[6][7]=3;
            
        // bishop
        gridboard[2][7].setIcon(icon[4]);
        gridboard[5][7].setIcon(icon[4]);
             //record pieces
            pieces[2][7]=4;
            pieces[5][7]=4;
            
        //queen
        gridboard[3][7].setIcon(icon[5]);
             //record pieces
            pieces[3][7]=5;
            
        //king
        gridboard[4][7].setIcon(icon[6]);
             //record pieces
            pieces[4][7]=6;
            
        //black-----------------------------------------------------------------
        // pawn
        gridboard[0][1].setIcon(icon[7]);
        gridboard[1][1].setIcon(icon[7]);
        gridboard[2][1].setIcon(icon[7]);
        gridboard[3][1].setIcon(icon[7]);
        gridboard[4][1].setIcon(icon[7]);
        gridboard[5][1].setIcon(icon[7]);
        gridboard[6][1].setIcon(icon[7]);
        gridboard[7][1].setIcon(icon[7]);
            // record pieces
            for(int i=0;i<8;i++)
                pieces[i][1] = 1;
                
        // rook
        gridboard[0][0].setIcon(icon[8]);
        gridboard[7][0].setIcon(icon[8]);
            //record pieces
            pieces[0][0]=8;
            pieces[7][0]=8;
            
        // knight
        gridboard[1][0].setIcon(icon[9]);
        gridboard[6][0].setIcon(icon[9]);
            //record pieces
            pieces[1][0]=9;
            pieces[6][0]=9;
          
        // bishop
        gridboard[2][0].setIcon(icon[10]);
        gridboard[5][0].setIcon(icon[10]);
            //record pieces
            pieces[2][0]=10;
            pieces[5][0]=10;
          
        //queen
        gridboard[3][0].setIcon(icon[11]);
            //record pieces
            pieces[3][0]=11;
            
        //king
        gridboard[4][0].setIcon(icon[12]);
            //record pieces
            pieces[4][0]=12;*/
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(chessPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(chessPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        
    }//GEN-LAST:event_jLabel1MouseClicked

    private void piecesPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_piecesPanelMouseClicked
        int x=evt.getX(),y=evt.getY();
        int LabelX,LabelY;
        ImageIcon greenBox = new ImageIcon("src/chess/13.png");
        boolean[][] valid;
        LabelY = x/75;
        LabelX = 7-y/75;
        System.out.println(LabelX+" "+LabelY);
        
        gridboard1 = new JLabel [8][8];
        /*for (int q = 0; q < 8; q++){
            for (int w = 0; w < 8; w++){
//                String position = Integer.toString(x) + ", " + Integer.toString(y);
                gridboard1[7-q][7-w] = new JLabel(); //adds text for debugging
//                gridboard[x][y].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                
                gridboard1[7-q][7-w].setPreferredSize(new Dimension(75,75));
                
                piecesPanel1.add(gridboard1[7-q][7-w]);
                
            }
        }*/
        
        
        if(game.b.board[LabelX][LabelY][0]!=null){
            valid=game.b.analyzeBoard(0,LabelX,LabelY);
            for(int j=0;j<8;j++){
            for(int i=0;i<8;i++){
            if(valid[i][j]){
                gridboard1[i][j].setIcon(greenBox);
            }
            }
            }
        }else if(game.b.board[LabelX][LabelY][1]!=null){
            valid=game.b.analyzeBoard(1,LabelX,LabelY);
             for(int j=0;j<8;j++){
            for(int i=0;i<8;i++){
            if(valid[i][j]){
                gridboard1[i][j].setIcon(greenBox);
            }
            }
            }
        }
    }//GEN-LAST:event_piecesPanelMouseClicked

    private void piecesPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_piecesPanel1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_piecesPanel1MouseClicked

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
    private javax.swing.JPanel backgroundPanel;
    private javax.swing.JPanel chessPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel piecesPanel;
    private javax.swing.JPanel piecesPanel1;
    // End of variables declaration//GEN-END:variables
    
    
    
    
}
