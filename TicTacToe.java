/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author mmahm
 */

public final class TicTacToe extends JPanel{
    JButton buttons[] = new JButton[9]; 
    
    public TicTacToe(){
      setLayout(new GridLayout(3,3));
      createButtons(); 
    }
    
    public void createButtons(){
        for(int i = 0; i <= 8; i++){
            buttons[i] = new JButton();
            buttons[i].setText("");
            buttons[i].addActionListener(new buttonListener());
            add(buttons[i]);         
        }
    }
    
    int letterNum = 0;
    public class Player1{
        String letter;
        int num;
        public Player1(String letter){
            this.letter = letter;
            if ("X".equals(letter)){
                num = letterNum;
            }
            else{
                num = 1;
            }
        }
    }
    
    private class buttonListener implements ActionListener{
       
        @Override
        public void actionPerformed(ActionEvent action){            
            JButton button = (JButton)action.getSource(); 
            if(letterNum%2 == 0){
                button.setText("X");
            }
            else{
                button.setText("O");
            }
            if(checkIfGame() == true){
                if (letterNum%2 == 0){
                    JOptionPane.showMessageDialog(null, "X wins.");
                }
                else {
                    JOptionPane.showMessageDialog(null, "O wins.");
                }
            }    
            letterNum++;   
        }
        
        public boolean checkIfGame(){
            if(ifAdjacent(0,1) && ifAdjacent(1,2)){ 
                return true;
            }
            else if (ifAdjacent(0,3) && ifAdjacent(3,6)){
                return true;
            }
            else if (ifAdjacent(0,4) && ifAdjacent(4,8)){
                return true;  
            }
            else if(ifAdjacent(3,4) && ifAdjacent(4,5)){
                return true;
            }
            else if (ifAdjacent(1,4) && ifAdjacent(4,7)){
                return true;
            }
            else if (ifAdjacent(2,5) && ifAdjacent(5,8)){
                return true;
            }
            else if (ifAdjacent(6,7) && ifAdjacent(7,8)){
                return true;
            }
            else return ifAdjacent(2,4) && ifAdjacent(4,6);    
        }
        
        public boolean ifAdjacent(int current, int adj){
            return buttons[current].getText().equals(buttons[adj].getText()) && !buttons[current].getText().equals("");
        }     
    }
    
    public static void main(String[] args){
        JFrame window = new JFrame("TicTacToe");
        window.getContentPane().add(new TicTacToe());
        window.setBounds(500,500,500,500);
        window.setVisible(true);
    }
}
