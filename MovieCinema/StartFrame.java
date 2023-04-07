package teamplay;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



@SuppressWarnings("serial")
public class StartFrame extends JFrame implements Runnable{
   private Thread thread;
   private JLabel Clock;
   
   StartFrame() {
    
     
     
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Container c = getContentPane();
   
      Image img2 = Toolkit.getDefaultToolkit().getImage("부기시네마.jpg");
    
       JPanel panel = new JPanel() { 
            @Override 
            protected void paintComponent(Graphics g) 
            { 
            
              g.drawImage(img2, 0, 0, 600,600, this); 
           } 
        }; 
      panel.setLayout(null);
      JLabel IDlab=new JLabel("ID");    
      IDlab.setBounds(155,350, 80,30);
      panel.add(IDlab);
       JLabel PWlab=new JLabel("PW");    
       PWlab.setBounds(155,390, 80,30);
       panel.add(PWlab);
       JTextField Ifl = new JTextField(); 
       Ifl.setBounds(195,350, 200,30);
       panel.add(Ifl);
       JPasswordField Pfl = new JPasswordField();   
       Pfl.setBounds(195,390,200,30);
       panel.add(Pfl);
       Pfl.setEchoChar('*');
       JButton bt1 = new JButton("로그인");
       bt1.setBounds(195,430,90,30);    
       panel.add(bt1);
       JButton bt2 = new JButton("회원가입");    
       bt2.setBounds(305,430,90,30);    
       panel.add(bt2);
       IDlab.setForeground(Color.yellow);
       PWlab.setForeground(Color.yellow);
      Clock = new JLabel();
     Clock.setFont(new Font("LAB디지털", Font.BOLD, 20));
     Clock.setForeground(Color.yellow);
     if(thread == null){
         
         
         thread = new Thread(this);
         thread.start();
      }
     panel.add(Clock);
     Clock.setBounds(10,450,400,200);
     
      add(panel);
      setTitle("Hansung Cinema");
      setSize(600,600);
      setVisible(true);
      bt2.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {// 
            // TODO Auto-generated method stub
            register f2= new register();
         }
      });;
      

      
      bt1.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e2) {
            // TODO Auto-generated method stub
            try{
               String s;
               boolean loop = true;
               String[] array;
               BufferedReader bos = new BufferedReader(new FileReader("로그인정보.txt"));
               while(loop){
                  
                  if((s=bos.readLine())!=null) {
                     array=s.split("/");
                     
                     if(Ifl.getText().equals(array[1])&&Pfl.getText().equals(array[2]))
                     {
                        JOptionPane.showMessageDialog(null, "로그인에 성공했습니다!!");
                        new mypage().show();                            // ticketframe         
                    StartFrame.this.dispose();
                        break;
                     }
                     else
                     {
                        continue;
                     }
                  }
                  else
                  {
                     JOptionPane.   showMessageDialog(null, "로그인에 실패했습니다!!");
                     loop=false;
                     new Fr();
                  }
               }
               bos.close();
            }catch (IOException E10){
    
               E10.printStackTrace();
            }
         }
      });
  
   }
   public void run(){
       while(true){
          Calendar cal = Calendar.getInstance();
          String now = cal.get(Calendar.YEAR)+"년 "+
                (cal.get(Calendar.MONTH)+1)+"월 "+
                cal.get(Calendar.DATE)+"일 "+
                cal.get(Calendar.HOUR)+"시 "+
                cal.get(Calendar.MINUTE)+"분 "+
                cal.get(Calendar.SECOND)+"초 ";
          Clock.setText(now);
          try{
             Thread.sleep(1000);
          }catch(InterruptedException e){
             e.printStackTrace();
          }
       }   
    }
   public static void main(String[] args) throws Exception {
      new StartFrame();
      while(true)
      {
         File a = new File("The-Beginnig-of-The-Adventure.wav");
         AudioInputStream b = AudioSystem.getAudioInputStream(a);
         Clip c = AudioSystem.getClip();
      
         c.open(b);
         c.start();
      
         Thread.sleep(c.getMicrosecondLength()/1000);

   }
}
    
}