// Currency Converter: Indian Rupees to Russian Ruble.

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.io.*;


class Convert extends JFrame
{
     JLabel labNumber,labAnswer;
     JButton rpRuButton,ruRpButton,goViewButton;
     JTextField enterNumber;
     Container c;
     Convert()
     {
           c=getContentPane();
           c.setLayout(new FlowLayout(FlowLayout.CENTER,80,30));
           Color co=new Color(255,255,204);
           c.setBackground(co);
           Font f=new Font("Algerian",Font.BOLD,30);
           Font f1=new Font("Algerian",Font.BOLD,20);
           labNumber=new JLabel("Enter your money: ");
           labAnswer=new JLabel("");
           enterNumber=new JTextField(30);
           rpRuButton=new JButton("Rupees to Ruble");
           ruRpButton=new JButton("Ruble to Rupees");
           goViewButton=new JButton("View");
           labNumber.setForeground(Color.RED);
           labAnswer.setForeground(Color.RED);
           rpRuButton.setBackground(Color.WHITE);
           ruRpButton.setBackground(Color.WHITE);
           goViewButton.setBackground(Color.WHITE);
           labNumber.setFont(f);
           labAnswer.setFont(f1);
           rpRuButton.setFont(f);
           ruRpButton.setFont(f);
           goViewButton.setFont(f);
           c.add(labNumber);
           c.add(enterNumber);
           c.add(rpRuButton);
           c.add(ruRpButton);
           c.add(goViewButton); 
           c.add(labAnswer);
           ActionListener b=(be)->{
                  View v=new View();
                  dispose();
           };
           ActionListener a=(ae)->{
                              try
                              {
                                        String number=enterNumber.getText();
                                        String rs="rupees",ru="rubles";
                                        if(number.equals(""))
                              		throw new Exception("You cannot leave space empty");
                              		else if(number.trim().equals(""))
                              		throw new Exception("You cannot enter just white space");
                                        else if(number.contains(" "))
                              		throw new Exception("You cannot have white space");
                                        else if(number.replaceAll("[0-9-]","").matches("[A-Za-z!@#$%&*()_+=|<>?{}\\[\\]~]+"))
                                        throw new Exception("You cannot enter text or You cannot enter special symbol");
                                        else if(number.length()>7)
                                        throw new Exception("You should enter only numbers and you cannot enter numbers more than 10000000");
                                        long num=Long.parseLong(number);
                                        if(num<0)
                                        throw new Exception("You cannot enter negative numbers");
                                        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                                	String url="jdbc:mysql://localhost:3306/project126dec23";
                                	Connection con=DriverManager.getConnection(url,"root","abc123");
          				String sql="insert into rupeesruble values(?,?)";
          				PreparedStatement pst=con.prepareStatement(sql);
                              		if(ae.getSource()==rpRuButton)
                              		{
                                        	Double ans=num*1.10;
                              			labAnswer.setText("Your amount in Rubles is "+String.format("%.2f",ans)); 
                                                pst.setDouble(1,ans);                                       	                                                  
                                		pst.setString(2,rs);
                                        }
                              		else if(ae.getSource()==ruRpButton)
                              		{
                                       
                                        	Double ans=num/1.10;
                              			labAnswer.setText("Your amount in Rupees is "+String.format("%.2f",ans));
                                        	pst.setDouble(1,ans);
                                		pst.setString(2,ru);
                                        	
                              		}
                                        pst.executeUpdate();
          				con.close();
                                        enterNumber.setText("");
                       		        enterNumber.requestFocus();
                                      
                             }
                              catch(SQLException se)
                              {
                              	JOptionPane.showMessageDialog(c,se.getMessage());
                              }
                              catch(Exception e)
                              {
                                JOptionPane.showMessageDialog(c,e.getMessage());
                                enterNumber.setText("");
                       		enterNumber.requestFocus();
                              }   
           };
           rpRuButton.addActionListener(a);
           ruRpButton.addActionListener(a);
           goViewButton.addActionListener(b);
           setTitle("Indian Rupees to Russian Ruble Converter");
           setSize(500,500);
           setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           setLocationRelativeTo(null);
           setResizable(false);
           setVisible(true);
     }
}

