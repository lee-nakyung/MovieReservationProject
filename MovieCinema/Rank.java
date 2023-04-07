package teamplay;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
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
import java.util.Hashtable;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Rank extends JFrame implements Runnable{
   String[] MovieList;
   int kk;
   static Thread thread;
   private JLabel poster;
   JButton back;
   ArrayList<String> M_list = new ArrayList<String>();
   Image img2;
   static int sum[]=new int[6];
   ArrayList<String> MovieName = new ArrayList<String>();
   JLabel []MovieLabel = new JLabel[6];
   static JLabel []RankLabel = new JLabel[6];
    Point[] p = new Point[6];
    Point[] p2 = new Point[6];
    ImageIcon a[]=new ImageIcon[6];
      Image changeImg; 
      Hashtable<Integer, String> ht = new Hashtable<Integer, String>();
      Hashtable<Integer, ImageIcon> htt = new Hashtable<Integer, ImageIcon>();
      ImageIcon []img = {
               new ImageIcon("범죄도시.jpg"),
               new ImageIcon("마녀.jpg"),
               new ImageIcon("토르.jpg"),
               new ImageIcon("미니언즈2.jpg"),
               new ImageIcon("스파이더맨.jpg"),
               new ImageIcon("블랙팬서.jpg")
               
         };
      ImageIcon[] imgcon = {
               new ImageIcon("범죄도시.jpg"),
               new ImageIcon("마녀.jpg"),
               new ImageIcon("토르.jpg"),
               new ImageIcon("미니언즈2.jpg"),
               new ImageIcon("스파이더맨.jpg"),
               new ImageIcon("블랙팬서.jpg")
               
     };
      Image img5 = Toolkit.getDefaultToolkit().getImage("OIP.jpg");
      JPanel panel = new JPanel() { 
           @Override 
           protected void paintComponent(Graphics g) 
           { 
           
             g.drawImage(img5, 0, 0, 600,600, this); 
          } 
       }; 
      Font fontb = new Font("CookieRun Bold", Font.BOLD, 15);
      JLabel icon = new JLabel(imgcon[0]);
      static int[] counts = new int[6];
   public Rank() {
         
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
         ImageIcon ba = new ImageIcon("back.png"); //예매하기 버튼
         ImageIcon backi;
         Image jm;
         Image chjm;
         jm = ba.getImage();
         chjm = jm.getScaledInstance(60,30,Image.SCALE_SMOOTH);
         backi = new ImageIcon(chjm);
        back = new JButton(backi);
        back.setBorderPainted(false);
        back.setContentAreaFilled(false);
        back.setFocusPainted(false);
        
        back.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {// 
                  new mypage().show();
                  Rank.this.setVisible(false);
               }
            });
        back.setBounds(5,5,150,100);
        panel.add(back);
           for(int p =0;p<img.length;p++) {
               img2 = img[p].getImage();
               changeImg = img2.getScaledInstance(200,300,Image.SCALE_SMOOTH);
               imgcon[p] = new ImageIcon(changeImg);
            }
           File MovieL= new File("영화.txt");
        
           try{
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(MovieL),"utf-8"));
                String str = br.readLine();
                  while(str != null){
                     M_list.add(str); 
                     str = br.readLine();
                  }

                br.close();
        } catch (NullPointerException e){ 
           e.getStackTrace();
        } catch (FileNotFoundException e){ 
           e.getStackTrace();
        } catch (IOException e){ 
           e.getStackTrace();
        }
            
           MovieList = M_list.toArray(new String[6]);
            int k=MovieList.length-1;
            for(int i=0; i<MovieList.length;i++) {
               
                MovieLabel[i] = new JLabel(MovieList[i]);
                MovieLabel[i].setBounds(300,185+(i*60),800,40);
                MovieLabel[i].setFont(fontb);
                MovieLabel[i].setForeground(Color.yellow);
               
                RankLabel[i] = new JLabel(MovieList[i]+"\n"+Integer.toString(sum[i]));
                RankLabel[i].setBounds(300,205+(i*60),800,40);
                RankLabel[i].setFont(fontb);
                RankLabel[i].setForeground(Color.cyan);
                p2[i]=MovieLabel[i].getLocation();
                p[k]=RankLabel[i].getLocation(); 
                k--;
                panel.add(RankLabel[i]);
                panel.add(MovieLabel[i]);

                }
        
           panel.setLayout(null);
           ImageIcon titl = new ImageIcon("title.png");
           JLabel titlab = new JLabel(titl);
           titlab.setBounds(100, 10, 400, 175);
           panel.add(titlab);
           panel.add(icon);
           icon.setBounds(30, 200, 250, 330);

           
               
               thread = new Thread(this);
               thread.start();
            
           
           
           add(panel);
           setTitle("Movie Ranking");
           setSize(600,600);
           setVisible(true);
   }
   
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      new Rank().show();
      
      
   }
   @Override
   public void run() {
   // TODO Auto-generated method stub
      
      while(true){
         
         for(int o =0;o<counts.length;o++) {
         counts[o]=((int)((Math.random()+1)*100));
         sum[o]=sum[o]+counts[o];
         ht.put(sum[o],MovieList[o]);
         htt.put(sum[o],imgcon[o]);
         
         }
         for(int k=0;k<counts.length;k++) {
            for(int l=k+1;l<counts.length;l++) {
            	
               if(sum[k]>sum[l]) {
                  int temp = sum[k];
                  sum[k]=sum[l];
                  sum[l]=temp;
              	
               }
             

            }
            
            MovieLabel[k].setText(ht.get(sum[k]));
            RankLabel[k].setText(Integer.toString(sum[k])+"▲"+Integer.toString(counts[k]));
            MovieLabel[k].setLocation(p2[k]);
            RankLabel[k].setLocation(p[k]);
            
            
           
         }
       
         icon.setVisible(false);
         icon = new JLabel(htt.get(sum[0]));
         panel.add(icon);
         icon.setBounds(5, 140, 320, 450);
         try{
            
               
            Rank.thread.sleep((int)(2000));
            
         
            
         }catch(Exception e){
            e.toString();
            e.printStackTrace();
         }

      }
   
      
   }

}