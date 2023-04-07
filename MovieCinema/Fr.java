package teamplay;

import java.awt.Choice;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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

public class Fr extends JFrame implements ItemListener, ActionListener{
   Choice movieName;
   Choice selectTime;
   Choice selectTheater;
   Choice selectDate;
   Choice selectHuman;
   JPanel panel;
   JLabel label,name,time,theater,date,human;
   JButton next,back;
   ImageIcon run;
   int index;
   int ticketNum,select;
   Image img2;

   Image changeImg; 

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

   
   JLabel icon = new JLabel(imgcon[0]);
   
   public Fr(){
      
      Font font = new Font("DalseoHealingBold", Font.BOLD, 20);
         Font fontb = new Font("CookieRun Bold", Font.BOLD, 24);
      
      for(int p =0;p<img.length;p++) {
           img2 = img[p].getImage();
           changeImg = img2.getScaledInstance(250,380,Image.SCALE_SMOOTH);
           imgcon[p] = new ImageIcon(changeImg);
        }
      Image img3 = Toolkit.getDefaultToolkit().getImage("Sangsang.png"); 
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
      setSize(800,800);
      setTitle("한성시네마");
      
      panel = new JPanel(){ 
          @Override 
          protected void paintComponent(Graphics g) 
          { 
          
            g.drawImage(img3, 0, 0, 800,800, this); 
         } 
      };
      
      label = new JLabel("한성시네마");
      name = new JLabel("영화 선택");
      time = new JLabel("시간 선택");
      theater = new JLabel("영화관 선택");
      date = new JLabel("날짜 선택");
      human = new JLabel("인원 선택");
      panel.setLayout(null);
      ImageIcon ba = new ImageIcon("back.png");
       ImageIcon backi;
       Image jm;
       Image chjm;
       jm = ba.getImage();
       chjm = jm.getScaledInstance(90,50,Image.SCALE_SMOOTH);
       backi = new ImageIcon(chjm);
      back = new JButton(backi);
      back.setBorderPainted(false);
      back.setContentAreaFilled(false);
      back.setFocusPainted(false);
      back.setBounds(25,480,10,10);  
       back.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {// 
                // TODO Auto-generated method stub
                new mypage().show();
                Fr.this.setVisible(false);
             }
          });
       ImageIcon ne = new ImageIcon("next.png");
       ImageIcon nexti;
       Image im;
       Image chim;
       im = ne.getImage();
       chim = im.getScaledInstance(90,50,Image.SCALE_SMOOTH);
       nexti = new ImageIcon(chim);
       
      next = new JButton(nexti);
      next.setBorderPainted(false);
      next.setContentAreaFilled(false);
      next.setFocusPainted(false);
      next.setBounds(485,480,30,30);  
      
      next.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent T) {
             int movie_human= selectHuman.getSelectedIndex();
              System.out.println(movie_human);
          
             int total_price=movie_human*12000;

    try{
        BufferedWriter bos = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("예매정보.txt"),"UTF8"));
        bos.write(movieName.getItem(select)+"/");
        bos.write(selectTime.getSelectedItem()+"/");
        bos.write(selectTheater.getSelectedItem()+"/");
        bos.write(selectHuman.getSelectedItem()+"/");
        bos.write(selectDate.getSelectedItem()+"/");
        bos.write(total_price+"/");
        bos.close();
        System.out.println(movieName);
        System.out.println(selectTime);
        System.out.println(selectTheater);
        System.out.println(selectHuman);
        System.out.println(selectDate);
        System.out.println(total_price);
        if(movie_human==0){ 
            JOptionPane.showMessageDialog(null, "인원수를 선택해주세요");
            
        }  
        else{
           JOptionPane.showMessageDialog(null, "예매 정보가 저장되었습니다.\n 좌석을 선택해주세요!");
           System.out.println(movieName.getItem(select));
           if(index==0) {
               new Seat1().show();
          Fr.this.setVisible(false);
               }
               else if(index==1) {
            	   new Seat2().show();
                   Fr.this.setVisible(false);
               }
               else if(index==2) {
            	   new Seat3().show();
                   Fr.this.setVisible(false);
               }
               else if(index==3) {
            	   new Seat4().show();
                   Fr.this.setVisible(false);
               }
               else if(index==4) {
            	   new Seat5().show();
                   Fr.this.setVisible(false);
               }
               else if(index==5) {
            	   new Seat6().show();
                   Fr.this.setVisible(false);
               }
        }

    }catch (Exception ex){
        JOptionPane.showMessageDialog(null, "예매 오류");
    	ex.getMessage();
        ex.printStackTrace();
      
     }
 
          }});
  

          
      
      back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {// 
               // TODO Auto-generated method stub
               mypage st = new mypage();
            }
         });
      
      File cinema = new File("영화관.txt");
      File MovieL= new File("영화.txt");
      ArrayList<String> N_list = new ArrayList<String>(); // 리스트 선언
      ArrayList<String> M_list = new ArrayList<String>();
      
      
            try{
                    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(cinema),"utf-8"));

                    String str = br.readLine();
                      while(str != null){
                         N_list.add(str); 
                         str = br.readLine();
                      }

                    br.close();
            } catch (NullPointerException e){ // null이 있을 경우
               e.getStackTrace();
            } catch (FileNotFoundException e){ // 파일을 찾을 수 없는 경우
               e.getStackTrace();
            } catch (IOException e){ // 파일 읽기 중 에러가 발생한 경우
               e.getStackTrace();
            }
         
            String[] CinemaList = N_list.toArray(new String[0]);
            try{
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(MovieL),"utf-8"));
                String str = br.readLine();
                  while(str != null){
                     M_list.add(str); 
                     str = br.readLine();
                  }

                br.close();
        } catch (NullPointerException e){ // null이 있을 경우
           e.getStackTrace();
        } catch (FileNotFoundException e){ // 파일을 찾을 수 없는 경우
           e.getStackTrace();
        } catch (IOException e){ // 파일 읽기 중 에러가 발생한 경우
           e.getStackTrace();
        }
            
            String[] MovieList = M_list.toArray(new String[0]);
     
     
      
          
      
                  
      selectTime=new Choice(); 
      movieName=new Choice();   
      selectTheater=new Choice();
      selectDate=new Choice();
      selectHuman = new Choice();
      selectTime.add("09:00~11:20");    
      selectTime.add("11:30~13:50");
      selectTime.add("14:00~16:20");
      selectTime.add("16:30~18:50");
      selectTime.add("19:00~17:20");
      selectTime.add("17:30~19:50");
      selectTime.add("22:00~24:20");
      
      
      selectDate.add("2022.11.16");
      selectDate.add("2022.11.17");
      selectDate.add("2022.11.18");
      selectDate.add("2022.11.19");
      selectDate.add("2022.11.20");
    
      selectHuman.add("0");
      selectHuman.add("1");
      selectHuman.add("2");
      selectHuman.add("3");
      selectHuman.add("4");
      selectHuman.add("5");
    

      for(int i=0; i<MovieList.length;i++) {
      movieName.add(MovieList[i]);
      }
      movieName.addItemListener(this);
      for(int j=0; j<CinemaList.length;j++) {
         selectTheater.add(CinemaList[j]);
          }

      
                                                                                  
      JLabel remain = new JLabel();
      panel.add(remain);
      remain.setText("잔여 좌석 : "+Integer.toString(Seat1.people));
      remain.setBounds(150,550,200,100);

      
      panel.add(icon);
      icon.setBounds(62, 177, 314, 420);

     
                                       
      name.setBounds(170,55,120,50);
      movieName.setBounds(126,105,200,60);
      
     
      
      time.setBounds(500,55,120,50);
      selectTime.setBounds(456,105,200,60);
      
      theater.setBounds(495, 210, 140, 50);
      selectTheater.setBounds(456,260,200,60);
      
      
      date.setBounds(495, 365, 120, 50);
      selectDate.setBounds(456,415,200,60);
      
      human.setBounds(495,520, 120, 50);
      selectHuman.setBounds(456,570,200,60);
      
      next.setBounds(600,650,150,100);
      back.setBounds(80,650,150,100);
      
     
      
      name.setFont(fontb);
      movieName.setFont(font);
      human.setFont(fontb);
      selectHuman.setFont(font);
      panel.add(name);
      panel.add(movieName);
      time.setFont(fontb);
      selectTime.setFont(font);
    
      panel.add(time);
      panel.add(selectTime);
      theater.setFont(fontb);
      selectTheater.setFont(font);
      
      panel.add(theater);
      panel.add(selectTheater);
      date.setFont(fontb);
      selectDate.setFont(font);
      
      panel.add(selectHuman);
      panel.add(human);
      panel.add(date);
      panel.add(selectDate);
      panel.add(next);
      panel.add(back);
      setResizable(false);
      add(panel);
      
      
   }
     
   
   public void actionPerformed(ActionEvent e){

         



       
         

         
       }


@Override
public void itemStateChanged(ItemEvent e) {
    index = movieName.getSelectedIndex();
    System.out.println(index);
    selectTime.removeAll();
    selectDate.removeAll();
    selectHuman.removeAll();
    icon.setVisible(false);
    icon = new JLabel(imgcon[index]);
    panel.add(icon);
    icon.setBounds(60, 180, 320, 420);
    
   
    
    if(index == 0)
    {         
       selectDate.add("2022.11.16");
        selectDate.add("2022.11.17");
        selectDate.add("2022.11.18");
        selectDate.add("2022.11.19");
        selectDate.add("2022.11.20");
      
        selectHuman.add("0");
        selectHuman.add("1");
        selectHuman.add("2");
        selectHuman.add("3");
        selectHuman.add("4");
        selectHuman.add("5");
      
       selectTime.add("09:00~11:20");
       selectTime.add("11:30~13:50");
       selectTime.add("14:00~16:20");
       selectTime.add("16:30~18:50");
       selectTime.add("19:00~21:20");
       selectTime.add("17:30~19:50");
       selectTime.add("22:00~24:20");
    }
    else if(index==1)
    {               
      
       selectDate.add("2022.11.16");
        selectDate.add("2022.11.17");
        selectDate.add("2022.11.18");
        selectDate.add("2022.11.19");
        selectDate.add("2022.11.20");
      
        selectHuman.add("0");
        selectHuman.add("1");
        selectHuman.add("2");
        selectHuman.add("3");
        selectHuman.add("4");
        selectHuman.add("5");
        selectTime.add("09:10~12:10");
        selectTime.add("12:20~15:20");
        selectTime.add("15:30~18:30");
        selectTime.add("18:40~21:40");
        selectTime.add("19:00~17:20");
        selectTime.add("20:00~21:20");
        selectTime.add("21:50~24:50");

    }
    else if(index==2)
    {        
       selectDate.add("2022.11.16");
        selectDate.add("2022.11.17");
        selectDate.add("2022.11.18");
        selectDate.add("2022.11.19");
        selectDate.add("2022.11.20");
      
        selectHuman.add("0");
        selectHuman.add("1");
        selectHuman.add("2");
        selectHuman.add("3");
        selectHuman.add("4");
        selectHuman.add("5");
        selectTime.add("09:00~10:50");
        selectTime.add("11:00~12:50");
        selectTime.add("13:00~14:50");
        selectTime.add("15:00~16:50");
        selectTime.add("17:00~18:50");
        selectTime.add("19:00~20:50");
        selectTime.add("21:00~22:50");

    }
    else if(index==3)
    {               
       selectDate.add("2022.11.16");
        selectDate.add("2022.11.17");
        selectDate.add("2022.11.18");
        selectDate.add("2022.11.19");
        selectDate.add("2022.11.20");
      
        selectHuman.add("0");
        selectHuman.add("1");
        selectHuman.add("2");
        selectHuman.add("3");
        selectHuman.add("4");
        selectHuman.add("5");
        selectTime.add("09:00~10:50");
        selectTime.add("11:00~13:50");
        selectTime.add("14:00~16:50");
        selectTime.add("17:00~19:50");
        selectTime.add("19:00~20:50");
        selectTime.add("20:00~22:50");
        selectTime.add("23:00~25:50");

    }
    else if(index==4)
    {               
       selectDate.add("2022.11.16");
        selectDate.add("2022.11.17");
        selectDate.add("2022.11.18");
        selectDate.add("2022.11.19");
        selectDate.add("2022.11.20");
      
        selectHuman.add("0");
        selectHuman.add("1");
        selectHuman.add("2");
        selectHuman.add("3");
        selectHuman.add("4");
        selectHuman.add("5");
        selectTime.add("10:00~12:20");
        selectTime.add("12:30~14:50");
        selectTime.add("15:00~17:20");
        selectTime.add("17:00~18:50");
        selectTime.add("17:30~19:50");
        selectTime.add("20:00~22:50");
        selectTime.add("22:00~24:20");

    }
    else if(index==5)
    {               
       selectDate.add("2022.11.16");
        selectDate.add("2022.11.17");
        selectDate.add("2022.11.18");
        selectDate.add("2022.11.19");
        selectDate.add("2022.11.20");
      
        selectHuman.add("0");
        selectHuman.add("1");
        selectHuman.add("2");
        selectHuman.add("3");
        selectHuman.add("4");
        selectHuman.add("5");
        selectTime.add("10:00~12:20");
        selectTime.add("11:00~13:50");
        selectTime.add("14:00~16:50");
        selectTime.add("17:00~19:50");
        selectTime.add("19:00~20:50");
        selectTime.add("20:00~22:50");
        selectTime.add("22:00~24:20");

    }
    select = index;

    
   // TODO Auto-generated method stub
   
}
     }

   