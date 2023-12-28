import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.io.*;

class SplashWindow extends JFrame
{
     JLabel labShown;
     Container c;
     SplashWindow()
     {
           c=getContentPane();
           c.setLayout(new FlowLayout(FlowLayout.CENTER,250,125));
           Color co=new Color(51,204,255);
           c.setBackground(co);
           labShown=new JLabel("<html><body><center>Welcome <br> to <br> Rupees-Ruble <br> Converter App</center></body></html>");
           Font f=new Font("Courier",Font.BOLD,40);
           labShown.setFont(f);
           labShown.setForeground(Color.RED);
           c.add(labShown);
           setTitle("Indian Rupees to Russian Ruble Converter");
           setSize(500,500);
           setUndecorated(true);
           setLocationRelativeTo(null);
           setVisible(true);
           try{
               Thread.sleep(20000);
               dispose();
               Convert c=new Convert();
           }
           catch(Exception e)
           {
                  System.out.println(e.getMessage());
           }
     }
        
}

