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

public class Ticketing extends JFrame {
   JLabel NameInfo,TimeInfo,TeaterInfo,CountInfo,DateInfo,PriceInfo;
   JLabel st;
   JButton back,gogo,clo;
   Choice buy;
   
   Ticketing(){
      
      Image imgi = Toolkit.getDefaultToolkit().getImage("white.png");
       
      ImageIcon rab = new ImageIcon("dddd.gif");
      JLabel rabb = new JLabel(rab);
      
      ImageIcon go = new ImageIcon("gogo.png");
      ImageIcon goi;
      Image gom;
      Image gojm;
      gom = go.getImage();
      gojm = gom.getScaledInstance(90,50,Image.SCALE_SMOOTH);
      goi = new ImageIcon(gojm);
     gogo = new JButton(goi);
     gogo.setBorderPainted(false);
     gogo.setContentAreaFilled(false);
     gogo.setFocusPainted(false);
     
     gogo.setBounds(320,650,150,100);
     
     gogo.addActionListener(new ActionListener() {
         @SuppressWarnings("deprecation")
     @Override
         public void actionPerformed(ActionEvent e) {// 
            // TODO Auto-generated method stub
            int how_buy=buy.getSelectedIndex();
           if(how_buy==0) {
              JOptionPane.showMessageDialog(null, "결제수단을 선택해주세요");
           }
           else {
              JOptionPane.showMessageDialog(null, "예매가 완료되었습니다!");
              
              
           }
         }
         
      });
     
     ImageIcon close = new ImageIcon("close.png");
     ImageIcon closei;
     Image closem;
     Image closejm;
     closem = close.getImage();
     closejm = closem.getScaledInstance(90,50,Image.SCALE_SMOOTH);
     closei = new ImageIcon(closejm);
    clo = new JButton(closei);
    
    clo.setBorderPainted(false);
    clo.setContentAreaFilled(false);
    clo.setFocusPainted(false);
    
    clo.setBounds(670,30,100,100);
    
    clo.addActionListener(new ActionListener() {
        @SuppressWarnings("deprecation")
    @Override
        public void actionPerformed(ActionEvent e) {// 
           
             new mypage().show();
             Ticketing.this.setVisible(false);
          
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
      
     
      
      buy=new Choice();
      buy.add("선택안함");
      buy.add("카카오페이");
      buy.add("현장결제");
      buy.add("신용카드");
      buy.add("무통장입금");
      buy.add("계좌이체");
      l.add(clo);
      l.add(gogo);
      buy.setBounds(380,580,150,40);
      l.add(buy);
      buy.setFont(fontd);
    
      l.setLayout(null);
      JLabel complete=new JLabel("예매하기");
      JLabel lmovie= new JLabel("관람 영화:");   
   
      s_movie= new JLabel();
      JLabel ldate = new JLabel("관람 일시:");
      JLabel ltime = new JLabel("관람 시간:");
      JLabel ltheater= new JLabel("관람 극장:");
      JLabel lperson = new JLabel("관람 인원:");
      JLabel lseat = new JLabel("관람 좌석:");
      JLabel lprice = new JLabel("결제 금액:");
      JLabel lbuy= new JLabel("결제 수단: ");
      

      l.setSize(800,800);
      complete.setBounds(300,80,400,40);
      complete.setFont(fontc);
      
      complete.setForeground(Color.BLUE);
      rabb.setBounds(10, 550, 200, 200);
      l.add(rabb);
      ltime.setBounds(200, 160,100,40);
      lmovie.setBounds(200, 210, 100, 40);
      ldate.setBounds(200, 270, 100, 40);
      ltheater.setBounds(200,330,100,40);
      lperson.setBounds(200, 390, 100, 40);
      lseat.setBounds(200, 450, 100, 40);
      lprice.setBounds(200,510,100,40);
      lbuy.setBounds(200,570,100,40);
      
      lmovie.setFont(fontb);
      ldate.setFont(fontb);
      ltheater.setFont(fontb);
      lperson.setFont(fontb);
      lseat.setFont(fontb);
      ltime.setFont(fontb);
      lprice.setFont(fontb);
      lbuy.setFont(fontb);
      
      l.add(complete);
      l.add(lmovie);
      l.add(ldate);
      l.add(ltheater);
      l.add(lperson);
      l.add(lseat);
      l.add(ltime);
      l.add(s_movie);
      l.add(lprice);
      l.add(lbuy);
      
     
      
      
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
  } catch (IOException e){ // 파일 읽기 중 에러가 발생한 경우
     e.getStackTrace();
  }
      String[] MovieList = I_list.toArray(new String[0]);
      String str = MovieList[0];
      System.out.println(MovieList[0]);
      String[] array = str.split("/");
      
     int c=0;
     JLabel []stl = new JLabel[(array.length)-5];
     String[]stn = new String[(array.length)-5];
     for(int n=6;n<array.length;n++) {
        stn[c]= array[n];
       
        stl[c]=new JLabel(stn[c]);
        stl[c].setBounds(380+(c*30),460,600,20);
        System.out.println(stl[c]);
        l.add(stl[c]);
        stl[c].setFont(fontb);
        c++;
     }
     
     TimeInfo = new JLabel(array[1]);
     NameInfo = new JLabel(array[0]);
     DateInfo = new JLabel(array[4]);
     TeaterInfo = new JLabel(array[2]);
     CountInfo = new JLabel(array[3]+"명");
     PriceInfo = new JLabel(array[5]+"원");
     
     
     TimeInfo.setBounds(380, 160, 220, 40);
     NameInfo.setBounds(380, 210, 500, 40);
     DateInfo.setBounds(380, 270, 500, 40);
     TeaterInfo.setBounds(380, 330, 500, 40);
     CountInfo.setBounds(380, 390, 220, 40);
     PriceInfo.setBounds(380,510,220,40);
     
     NameInfo.setFont(fontb);
     TimeInfo.setFont(fontb);
     TeaterInfo.setFont(fontb);
     CountInfo.setFont(fontb);
     DateInfo.setFont(fontb);
     PriceInfo.setFont(fontb);
     
     l.add(NameInfo);
     l.add(TimeInfo);
     l.add(TeaterInfo);
     l.add(CountInfo);
     l.add(DateInfo);
     l.add(PriceInfo);
     PriceInfo.setForeground(Color.RED);


      add(l);
      
     
      setSize(800,800);
 
      setTitle("한성시네마");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);

  

     
   }
   public static void main(String[] args){
      new Ticketing();

   }
}