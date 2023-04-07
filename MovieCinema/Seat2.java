package teamplay;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Seat2 extends JFrame{
   public static JPanel Panel;
   JPanel RightSeatPanel, LeftSeatPanel, MiddleSeatPanel,FrontSeatPanel;
   public static JLabel screen,Lchair[],Mchair[],Rchair[],Fchair[];
   JButton Backbt1,Nextbt1; 
   ArrayList<String> SeatNum = new ArrayList<String>();
   ImageIcon img = new ImageIcon("f.jpg"); 
   int num = 65;
   boolean[] select;
   static int people = 108;
   int i,j,k,l,m,n;
   static int count;
   static int[] sele;
   public static ArrayList<String> rsel = new ArrayList<String>() ;
   public static ArrayList<String> lsel = new ArrayList<String>() ;
   public static ArrayList<String> msel = new ArrayList<String>() ;
   public static ArrayList<String> fsel = new ArrayList<String>() ;
   public static ArrayList<JLabel> jl = new ArrayList<JLabel>();
   public Seat2() {
	  
      setSize(800,800);
      setTitle("Hansung Cinema");
      Image img2 = Toolkit.getDefaultToolkit().getImage("f.jpg"); 
      
         JPanel Panel = new JPanel() 
          { 
            @Override 
            protected void paintComponent(Graphics g) 
            { 
            
              g.drawImage(img2, 0, 0, 800,800, this); 
           } 
        }; 
        Panel.setLayout(null);
 
      screen = new JLabel("SCREEN");
      screen.setBackground(Color.cyan);
      screen.setOpaque(true);
      ImageIcon ba = new ImageIcon("back.png");
       ImageIcon backi;
       Image jm;
       Image chjm;
       jm = ba.getImage();
       chjm = jm.getScaledInstance(60,30,Image.SCALE_SMOOTH);
       backi = new ImageIcon(chjm);
      Backbt1 = new JButton(backi);
      Backbt1.setBorderPainted(false);
      Backbt1.setContentAreaFilled(false);
      Backbt1.setFocusPainted(false);
      Backbt1.setBounds(100,550,10,10);  
       Backbt1.addActionListener(new ActionListener() {
             @SuppressWarnings("deprecation")
         @Override
             public void actionPerformed(ActionEvent e) {// 
                // TODO Auto-generated method stub
                new Fr().show();
                Seat2.this.setVisible(false);
             }
          });
       ImageIcon ne = new ImageIcon("next.png");
       ImageIcon nexti;
       Image im;
       Image chim;
       im = ne.getImage();
       chim = im.getScaledInstance(60,30,Image.SCALE_SMOOTH);
       nexti = new ImageIcon(chim);
       
      Nextbt1 = new JButton(nexti);
      Nextbt1.setBorderPainted(false);
      Nextbt1.setContentAreaFilled(false);
      Nextbt1.setFocusPainted(false);
      Nextbt1.setBounds(620,550,60,30);  
      
      RightSeatPanel = new JPanel(new GridLayout(9, 4,10,10));
      LeftSeatPanel = new JPanel(new GridLayout(9, 4,10,10));
      MiddleSeatPanel = new JPanel(new GridLayout(6,12,0,0));
      FrontSeatPanel = new JPanel(new GridLayout(3,12,0,0));
      Lchair = new JLabel[36];
      Mchair = new JLabel[72];
      Fchair = new JLabel[36];
      Rchair = new JLabel[36];
      select = new boolean[108];
      RightSeatPanel.setBackground(Color.white);
      LeftSeatPanel.setBackground(Color.white);
      MiddleSeatPanel.setBackground(Color.white);
      FrontSeatPanel.setBackground(Color.white);
      RightSeatPanel.setOpaque(true);
      LeftSeatPanel.setOpaque(true);
      MiddleSeatPanel.setOpaque(true);
      FrontSeatPanel.setOpaque(true);
       File info = new File("예매정보.txt");
         ArrayList<String> I_list = new ArrayList<String>();
         try{
            String s;
             boolean loop = true;
             BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(info),"utf-8"));
             while(loop){
                 
                if((s=br.readLine())!=null) {
                 
                  I_list.add(s); 
                  
             }
                else
                {
                   loop=false;
                }
                
             }
             br.close();
             
             //출력         
      
            
     } catch (NullPointerException e){ // null이 있을 경우
        e.getStackTrace();
     } catch (FileNotFoundException e){ // 파일을 찾을 수 없는 경우
        e.getStackTrace();
     } catch (IOException e){ // 파일 읽기 중  
     }
         String[] MovieList = I_list.toArray(new String[0]);
         String str = MovieList[0];
      
         String[] array = str.split("/");
         
       count = Integer.parseInt(array[3]);
       
       int pick = 0;
      for(j=0;j<9;j++) {
         for(i=0;i<4;i++) {

            final int x = j*4+i;//좌석 절대 값
            
            Lchair[x] = new JLabel((char)(num+j) + Integer.toString(i+1)); 
            Rchair[x] = new JLabel((char)(num+j) + Integer.toString(i+17));
            Lchair[x].setHorizontalAlignment(JLabel.CENTER);
            Rchair[x].setHorizontalAlignment(JLabel.CENTER);
            
            Lchair[x].addMouseListener(new MouseListener() {
               @Override
               public void mouseReleased(MouseEvent arg0) {
               
               }
               
               @Override
               public void mousePressed(MouseEvent arg0) {
      
               }
               
               @Override
               public void mouseExited(MouseEvent arg0) {
               
               }
               
               @Override
               public void mouseEntered(MouseEvent arg0) {
               
               }
               
               @Override
               public void mouseClicked(MouseEvent arg0) {
                  if(Lchair[x].getBackground()==Color.green) {
                     Lchair[x].setBackground(Color.WHITE);       
                     select[x] = false;                                 
                     people++;
                     count++;
              
                
             
                     lsel.remove(Integer.toString(x));
                     SeatNum.remove(Lchair[j*4+i].getText());
                  }
                  else if(people>0 && count>0 &&  Lchair[x].getBackground()!=Color.RED){
                     
                     Lchair[x].setBackground(Color.green);               
                     select[x] = true;                  
                     people--;
                     count--;

    
                     lsel.add(Integer.toString(x));
                     SeatNum.add(Lchair[x].getText());
         
                  
                  Lchair[x].setOpaque(true);
                  
               
            }}});
            Rchair[x].addMouseListener(new MouseListener() {
               @Override
               public void mouseReleased(MouseEvent arg0) {
                  
                  
               }
               
               @Override
               public void mousePressed(MouseEvent arg0) {
                  
                  
               }
               
               @Override
               public void mouseExited(MouseEvent arg0) {
               
                  
               }
               
               @Override
               public void mouseEntered(MouseEvent arg0) {
               
                  
               }
               
               @Override
               public void mouseClicked(MouseEvent arg0) {
                  if(Rchair[x].getBackground()==Color.green) {
                     Rchair[x].setBackground(Color.WHITE);       
                     select[x] = false;                                 
                     people++;
                     count++;
      
                     rsel.remove(Integer.toString(x));
                     SeatNum.remove(Rchair[x].getText());

                  }
                  else if(people>0 && Rchair[x].getBackground()!=Color.RED){    
                     Rchair[x].setBackground(Color.green);                  
                     select[x] = true; 
                     people--;   
                     count--;
                     rsel.add(Integer.toString(x));
                     SeatNum.add(Rchair[x].getText());

                  }
                  
                  Rchair[x].setOpaque(true);
                  
                  
               }
            });
            
            LeftSeatPanel.add(Lchair[x]);
            RightSeatPanel.add(Rchair[x]);

         }}
      
      for(k=0;k<6;k++)
         for(l=0;l<12;l++) {      
            final int z = k*12+l;   
            Mchair[z] = new JLabel((char)((num+3)+k)+Integer.toString(l+5)); 
            Mchair[z].setHorizontalAlignment(JLabel.CENTER);
            MiddleSeatPanel.add(Mchair[z]);
            
   
            Mchair[z].addMouseListener(new MouseListener() {
               @Override
               public void mouseReleased(MouseEvent arg0) {
                  
                  
               }
               
               @Override
               public void mousePressed(MouseEvent arg0) {
                  
                  
               }
               
               @Override
               public void mouseExited(MouseEvent arg0) {
               
                  
               }
               
               @Override
               public void mouseEntered(MouseEvent arg0) {
               
                  
               }
               
               @Override
               public void mouseClicked(MouseEvent arg0) {
                  if(Mchair[z].getBackground()==Color.green) {
                     Mchair[z].setBackground(Color.WHITE);       
                     select[z] = false;                                 
                     people++;
                     count++;
             
                     msel.remove(Integer.toString(z));
                     SeatNum.remove(Mchair[z].getText());
   
                  }
                  else if(people>0 && count>0 &&  Mchair[z].getBackground()!=Color.RED){    
                     Mchair[z].setBackground(Color.green);                  
                     select[z] = true;                  
                     people--;      
                     count--;
              
                     msel.add(Integer.toString(z));
                     SeatNum.add(Mchair[z].getText());

                  }
                  
                  Mchair[z].setOpaque(true);
                  
               }
            });
            MiddleSeatPanel.add(Mchair[z]);
         
         }
   

      for(m=0;m<3;m++)
         for(n=0;n<12;n++){   
            final int y = m*12+n;
            Fchair[y] = new JLabel((char)(num+m)+ Integer.toString(n+5)); 
            Fchair[y].setHorizontalAlignment(JLabel.CENTER);
            FrontSeatPanel.add(Fchair[y]);
               
            
            Fchair[y].addMouseListener(new MouseListener() {
               @Override
               public void mouseReleased(MouseEvent arg0) {
                  
                  
               }
               
               @Override
               public void mousePressed(MouseEvent arg0) {
                  
                  
               }
               
               @Override
               public void mouseExited(MouseEvent arg0) {
               
                  
               }
               
               @Override
               public void mouseEntered(MouseEvent arg0) {
               
                  
               }
               
               @Override
               public void mouseClicked(MouseEvent arg0) {
                  if(people>0 && count >0 && Fchair[y].getBackground()==Color.green) {
                     Fchair[y].setBackground(Color.WHITE);       
                     select[y] = false;                                 
                     count++;
                     people++;
           
                     fsel.remove(Integer.toString(y));
                     SeatNum.remove(Fchair[y].getText());

                  }
                  else if(people>0 && count>0 && Fchair[y].getBackground()!=Color.RED){    
                     Fchair[y].setBackground(Color.green);                  
                     select[y] = true;                  
                     count--;   
                     people--;

                     fsel.add(Integer.toString(y));
                     SeatNum.add(Fchair[y].getText());

                  }
                  
                  Fchair[y].setOpaque(true);
                  
               }
            });
            FrontSeatPanel.add(Fchair[y]);

         }
      

      Nextbt1.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent T) {
      
          
              
                   

          try{
              BufferedWriter bos = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("예매정보.txt",true),"UTF8"));
             for (int arr=0;arr<SeatNum.size();arr++) {
                  bos.write(SeatNum.get(arr)+" ");
                 
    
                  
          }
              
         
             
              bos.close();
      
              if(count != 0){ 
                  JOptionPane.showMessageDialog(null, "자리를 선택해주세요");
                 
              }  
              else{
                 JOptionPane.showMessageDialog(null, "예매 완료");
                 new Ticketing().show();
                 Seat2.this.setVisible(false);
            
              }

          }catch (Exception ex){
              JOptionPane.showMessageDialog(null, "오류");
              
           }
       
                }
               
          });

      if(fsel.size() != 0) {
      for(int l1 =0;l1<fsel.size();l1++) {
    	  Fchair[Integer.parseInt(Seat2.fsel.get(l1))].setBackground(Color.RED);
    	  Fchair[Integer.parseInt(Seat2.fsel.get(l1))].setOpaque(true);
    	  System.out.println(Seat2.fsel.get(l1));
      }
      }
      else if(msel.size() != 0) {
    	  for(int l2 =0;l2<msel.size();l2++) {
        	  Mchair[Integer.parseInt(Seat2.msel.get(l2))].setBackground(Color.RED);
        	  Mchair[Integer.parseInt(Seat2.msel.get(l2))].setOpaque(true);
          }
      }
      else if(lsel.size() != 0) {
    	  for(int l3 =0;l3<lsel.size();l3++) {
        	  Lchair[Integer.parseInt(Seat2.lsel.get(l3))].setBackground(Color.RED);
        	  Lchair[Integer.parseInt(Seat2.lsel.get(l3))].setOpaque(true);
          }
      }
      else if(rsel.size() != 0) {
    	  for(int l4 =0;l4<rsel.size();l4++) {
        	  Rchair[Integer.parseInt(Seat2.rsel.get(l4))].setBackground(Color.RED);
        	  Rchair[Integer.parseInt(Seat2.rsel.get(l4))].setOpaque(true);
          }
      }
         
      Panel.add(Nextbt1);
      Panel.add(Backbt1);
      Nextbt1.setSize(60,30);
      Backbt1.setSize(60,30);
      Nextbt1.setOpaque(false);
      Backbt1.setOpaque(false);
      Panel.add(RightSeatPanel);
      Panel.add(LeftSeatPanel);
      Panel.add(MiddleSeatPanel);
      Panel.add(FrontSeatPanel);
      screen.setBounds(190,100,400,20);
      
      FrontSeatPanel.setBounds(240,200,300,95);
      LeftSeatPanel.setBounds(110,200,120,300);
      MiddleSeatPanel.setBounds(240,300,300,200);
      RightSeatPanel.setBounds(550,200,120,300);
      screen.setHorizontalAlignment(SwingConstants.CENTER);
      Panel.add(screen);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setResizable(false);
      add(Panel);
      Panel.updateUI();
      setVisible(true);

   }
   
   public static void main(String[] args) {
      new Seat2();
    
   }
   
}