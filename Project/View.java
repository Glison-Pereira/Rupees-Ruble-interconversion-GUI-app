import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.io.*;

class View extends JFrame
{
      JButton goBackButton,clearHistoryButton,viewHistoryButton;
      JTextArea labAnswer;
      Container c;
      View()
      {
           c=getContentPane();
           c.setLayout(new FlowLayout(FlowLayout.CENTER,80,30));
           Color co=new Color(204,204,204);
           c.setBackground(co);
           Font f=new Font("Algerian",Font.BOLD,30);
           labAnswer=new JTextArea("");
           goBackButton=new JButton("Go Back");
           viewHistoryButton=new JButton("View History");
           clearHistoryButton=new JButton("Clear History");
           goBackButton.setBackground(Color.WHITE);
           viewHistoryButton.setBackground(Color.WHITE);
           clearHistoryButton.setBackground(Color.WHITE);
           labAnswer.setForeground(Color.RED);
           goBackButton.setFont(f);
           viewHistoryButton.setFont(f);
           clearHistoryButton.setFont(f);
           labAnswer.setFont(f);
           c.add(goBackButton);
           c.add(viewHistoryButton);
           c.add(clearHistoryButton);
           c.add(labAnswer);
           
           ActionListener a=(ae)->{
                  Convert c=new Convert();
                  dispose();
           };
           ActionListener b=(be)->{
                try
    	   	 {
          		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
          		String url="jdbc:mysql://localhost:3306/project126dec23";
          		Connection con=DriverManager.getConnection(url,"root","abc123");
          		String sql="select * from rupeesruble";
          		PreparedStatement pst=con.prepareStatement(sql);
          		ResultSet rs=pst.executeQuery();
          		while(rs.next())
          		{
               			labAnswer.append(rs.getDouble(1)+" "+rs.getString(2)+"\n");
          		}
          		con.close();
     	  	}catch(SQLException e){
        			JOptionPane.showMessageDialog(c,e.getMessage());
     	  	} 
          };
          ActionListener d=(de)->{
                try
    	   	 {
          		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
          		String url="jdbc:mysql://localhost:3306/project126dec23";
          		Connection con=DriverManager.getConnection(url,"root","abc123");
          		String sql="delete from rupeesruble";
          		PreparedStatement pst=con.prepareStatement(sql);
                        pst.executeUpdate();
                        JOptionPane.showMessageDialog(c,"Your table records are deleted. Go back to enter new records");
                        con.close();
     	  	}catch(SQLException e){
        			JOptionPane.showMessageDialog(c,e.getMessage());
     	  	}
          };
           goBackButton.addActionListener(a);
           viewHistoryButton.addActionListener(b);
           clearHistoryButton.addActionListener(d);
           setTitle("Indian Rupees to Russian Ruble Converter");
           setSize(500,500);
           setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           setLocationRelativeTo(null);
           
           setVisible(true);
      }
}