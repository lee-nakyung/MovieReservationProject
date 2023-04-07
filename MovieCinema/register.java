package teamplay;



import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class register extends JFrame {
   public register(){
      
      JButton next,back;
      
      
     
         
         Image imgi = Toolkit.getDefaultToolkit().getImage("sky.png");
          
         

         
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
      
       back.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {// 
                // TODO Auto-generated method stub
                new StartFrame().show();
                register.this.setVisible(false);
                
             }
          });
      
       
         Font fontb = new Font("CookieRun Bold", Font.BOLD, 22);
         Font fontc = new Font("CookieRun Bold", Font.BOLD, 32);
         Font fontd = new Font("CookieRun Bold", Font.BOLD, 18);
         
         
         JPanel l = new JPanel(){ 
             @Override 
             protected void paintComponent(Graphics g) 
             { 
             
               g.drawImage(imgi, 0, 0, 800,800, this); 
            } 
         }; 
         
         ImageIcon ne = new ImageIcon("next.png");
         ImageIcon nexti;
         Image im;
         Image chim;
         im = ne.getImage();
         chim = im.getScaledInstance(90,50,Image.SCALE_SMOOTH);
         nexti = new ImageIcon(chim);
         
         TextField tname = new TextField();
         TextField tid = new TextField();
         TextField tpwd = new TextField();
         TextField taddress = new TextField();
         TextField temail = new TextField();
         
        
         tname.setBounds(290, 175, 200, 40);
         tid.setBounds(290, 260, 200, 40);
         tpwd.setBounds(290, 350, 200, 40);
         taddress.setBounds(290, 440, 200, 40);
         temail.setBounds(290, 530, 200, 40);
         
         
        next = new JButton(nexti);
        next.setBorderPainted(false);
        next.setContentAreaFilled(false);
        next.setFocusPainted(false);
       next.addActionListener(new ActionListener() {
            @SuppressWarnings("deprecation")
        @Override
            public void actionPerformed(ActionEvent e) {// 
               try{
                    BufferedWriter bos = new BufferedWriter(new FileWriter("로그인정보.txt",true));
                    bos.write(tname.getText()+"/");
                    bos.write(tid.getText()+"/");
                    bos.write(tpwd.getText()+"/");
                    bos.write(taddress.getText()+"/");
                    bos.write(temail.getText()+"\r\n");
                    bos.close();
                    JOptionPane.showMessageDialog(null, "회원가입을 축하합니다!!");
                    dispose();
                    new StartFrame();
                 }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "빈 곳 없이 작성해주세요!");
                 }
              }
           });
           
        
         l.setLayout(null);
         JLabel lregister=new JLabel("회원가입");
         JLabel lname = new JLabel("이름:");
         JLabel lid= new JLabel("아이디:");   
         JLabel lpwd = new JLabel("패스워드:");
      
        
         JLabel laddress= new JLabel("주소:");
         JLabel lemail = new JLabel("이메일:");
         
          add(tname);
          add(tid);
          add(tpwd);
          add(taddress);
          add(temail);
          
          tpwd.setEchoChar('*'); //*로 써지게함
         
          
          
         
         next.setBounds(600,650,150,100);
         back.setBounds(60,650,150,100);
         l.add(next);
         l.add(back);
        
         l.setSize(800,800);
         lregister.setBounds(350,80,400,40);
         lregister.setFont(fontc);
         
         lregister.setForeground(Color.BLUE);
         
         lname.setBounds(200, 170,100,40);
         lid.setBounds(200, 260, 100, 40);
         lpwd.setBounds(190, 350, 100, 40);
         laddress.setBounds(200,440,100,40);
         lemail.setBounds(200, 530, 100, 40);
        
   
         lregister.setFont(fontb);
         lname.setFont(fontb);
         lid.setFont(fontb);
         lpwd.setFont(fontb);
         laddress.setFont(fontb);
         lemail.setFont(fontb);
         
         
         l.add(lregister);
         l.add(lname);
         l.add(lid);
         l.add(lpwd);
         l.add(laddress);
         l.add(lemail);
         
         
        
         
         
        
       


         add(l);
         
        
         setSize(800,800);
    
         setTitle("부기시네마");
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setVisible(true);
   }
   public static void main(String[] args){
         new register();

      }
}