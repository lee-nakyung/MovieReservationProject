package teamplay;

import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;


@SuppressWarnings("serial")
public class Frame extends JFrame{

	ArrayList<String> MovieInfo;

   private String[] date = {"2022.11.16","2022.11.17","2022.11.18","2022.11.19","2022.11.20","2022.11.21"};
   private String[] hour = {"12:00","14:00","16:00","18:00","20:00","22:00"};
   JButton Backbt,Nextbt; 
    Frame() {
    																	
    																				
       Font font = new Font("digital-7", Font.BOLD, 40);
       Font fontb = new Font("IBMPlexSansKR-Bold", Font.BOLD, 20);
       ImageIcon []img = {
    		   new ImageIcon("범죄도시.jpg"),
    		   new ImageIcon("마녀.jpg"),
    		   new ImageIcon("토르.jpg"),
    		   new ImageIcon("미니언즈2.jpg"),
    		   new ImageIcon("스파이더맨.jpg"),
    		   new ImageIcon("블랙팬서.jpg")
    		   
       };
       
       
       Image img2;
       Image changeImg; 
       ImageIcon[] imgcon = {
    		   new ImageIcon("범죄도시.jpg"),
    		   new ImageIcon("마녀.jpg"),
    		   new ImageIcon("토르.jpg"),
    		   new ImageIcon("미니언즈2.jpg"),
    		   new ImageIcon("스파이더맨.jpg"),
    		   new ImageIcon("블랙팬서.jpg")
    		   
   };
		ImageIcon ba = new ImageIcon("back.png");
	    ImageIcon backi;
	    Image jm;
	    Image chjm;
	    jm = ba.getImage();
	    chjm = jm.getScaledInstance(60,30,Image.SCALE_SMOOTH);
	    backi = new ImageIcon(chjm);
		Backbt = new JButton(backi);
		Backbt.setBorderPainted(false);
		Backbt.setContentAreaFilled(false);
		Backbt.setFocusPainted(false);  
		Backbt.setBounds(25,480,90,30);  
	    Backbt.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent e) {// 
	             // TODO Auto-generated method stub
	             StartFrame st = new StartFrame();
	          }
	       });
	    
		ImageIcon ne = new ImageIcon("next.png");
	    ImageIcon nexti;
	    Image im;
	    Image chim;
	    im = ba.getImage();
	    chim = im.getScaledInstance(60,30,Image.SCALE_SMOOTH);
	    nexti = new ImageIcon(chim);
		Nextbt = new JButton(nexti);
		Nextbt.setBorderPainted(false);
		Nextbt.setContentAreaFilled(false);
		Nextbt.setFocusPainted(false);
		Nextbt.setBounds(485,480,90,30);  
		Nextbt.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent e) {// 
	             // TODO Auto-generated method stub
	             Seat1 seat = new Seat1();
	          }
	       });
	
       for(int p =0;p<img.length;p++) {
    	   img2 = img[p].getImage();
    	   changeImg = img2.getScaledInstance(200,300,Image.SCALE_SMOOTH);
    	   imgcon[p] = new ImageIcon(changeImg);
       }
       JLabel icon = new JLabel(imgcon[0]);
       
       icon.setBounds(20, 240, 200, 300);
       
       File cinema = new File("영화관.txt");
       File MovieL= new File("영화.txt");
       ArrayList<String> N_list = new ArrayList<String>(); // 리스트 선언
       ArrayList<String> M_list = new ArrayList<String>();
       
       
             try{
                     BufferedReader br = new BufferedReader(new FileReader(cinema));
                     String str = br.readLine();
                       while(str != null){
                          N_list.add(str); 
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
          
             String[] CinemaList = N_list.toArray(new String[0]);
             try{
                 BufferedReader br = new BufferedReader(new FileReader(MovieL));
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
             String[] MovieList = M_list.toArray(new String[0]);
             
             
             
             
             
          
             
      
             
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Container c = getContentPane();
      c.setLayout(null);
      c.add(Nextbt);
      c.add(Backbt);
      c.add(icon);
      JLabel lb1 = new JLabel("날짜 선택");
      lb1.setBounds(20, 10, 300, 40);
      lb1.setFont(fontb);
      c.add(lb1);
      
      JComboBox<String> p1 = new JComboBox <String>(date);
      p1.setBounds(115,15,250,25);
      p1.setFont(fontb);
      c.add(p1);
      
      JLabel lb2 = new JLabel("영화관 선택");
      lb2.setBounds(20, 50, 300, 40);
      lb2.setFont(fontb);
      c.add(lb2);
      
      JList<String> p2 = new JList <String>(hour);
      p2.setBounds(400, 10, 150, 300); 
      p2.setFont(font);
      c.add(p2);
      
      JComboBox<String> p3 = new JComboBox <String>(CinemaList);
      p3.setBounds(20, 90, 300, 40);
      p3.setFont(fontb);
      c.add(p3);
      
      JLabel lb4 = new JLabel("영화 선택");
      lb4.setBounds(20, 140, 300, 40);
      lb4.setFont(fontb);
      c.add(lb4);
      
      JComboBox<String> p4 = new JComboBox <String>(MovieList);
      p4.addActionListener(new ActionListener() {
    	  public void actionPerformed(ActionEvent e) {
    		  JComboBox cb = (JComboBox)e.getSource();
    		  int ind = cb.getSelectedIndex();
    		  icon.setIcon(imgcon[ind]);
    	  }
      });
      
      p4.setBounds(20, 180, 300, 40);
      p4.setFont(fontb);
      c.add(p4);
      
      setTitle("Inform");
      setSize(600,600);
      setVisible(true);
      
      
    }
    public static void main(String[] args) {
      new Frame();
   }

}