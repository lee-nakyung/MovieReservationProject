package teamplay;




import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class mypage extends JFrame {
   
   JButton next,back;
   
   
   mypage(){
      
      
      Image imgi = Toolkit.getDefaultToolkit().getImage("space.png");
       
      ImageIcon rab = new ImageIcon("dddd.gif");
      JLabel rabb = new JLabel(rab);
      
     
     
    
      
   ImageIcon ba = new ImageIcon("reser.png"); //예매하기 버튼
    ImageIcon backi;
    Image jm;
    Image chjm;
    jm = ba.getImage();
    chjm = jm.getScaledInstance(150,80,Image.SCALE_SMOOTH);
    backi = new ImageIcon(chjm);
   back = new JButton(backi);
   back.setBorderPainted(false);
   back.setContentAreaFilled(false);
   back.setFocusPainted(false);
   
   back.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {// 
             new Fr().show();
             mypage.this.setVisible(false);
          }
       });
   
    
      Font fontb = new Font("CookieRun Bold", Font.BOLD, 22);
      Font fontc = new Font("CookieRun Bold", Font.BOLD, 32);
      Font fontd = new Font("CookieRun Bold", Font.BOLD, 18);
      JLabel s_movie;
      
      JPanel l = new JPanel(){ 
          @Override 
          protected void paintComponent(Graphics g) 
          { 
          
            g.drawImage(imgi, 0, 0, 800,800, this); 
         } 
      }; 
      
      ImageIcon ne = new ImageIcon("ranking.png"); //영화 랭킹 버튼
      ImageIcon nexti;
      Image im;
      Image chim;
      im = ne.getImage();
      chim = im.getScaledInstance(150,80,Image.SCALE_SMOOTH);
      nexti = new ImageIcon(chim);
    
     next = new JButton(nexti);
     next.setBorderPainted(false);
     next.setContentAreaFilled(false);
     next.setFocusPainted(false);
     next.addActionListener(new ActionListener() {
         @SuppressWarnings("deprecation")
     @Override
         public void actionPerformed(ActionEvent e) {// 
            // TODO Auto-generated method stub
           new Rank().show();
          mypage.this.setVisible(false);
              
           
         }
         
      });
     
      l.setLayout(null);
     
      
      next.setBounds(430,350,150,100);
      back.setBounds(230,350,150,100);
      l.add(next);
      l.add(back);
     
      l.setSize(800,800);
     
      
     
      
      
     
     
   


      add(l);
      
     
      setSize(800,800);
 
      setTitle("한성시네마");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);

  

     
   }
   public static void main(String[] args){
      new mypage();

   }
}