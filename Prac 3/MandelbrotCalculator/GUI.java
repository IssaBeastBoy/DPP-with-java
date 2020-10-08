package com.javatpoint; 
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.*;
import javax.swing.*;
import java.awt.event.*;

public class GUI{
    private JButton send;
    private JButton retrieve;
    private JTextArea message;
    private JTextField name;
    private JLabel User_name;
    private JLabel indicator;
    private JFrame frame;
    private List storeInfo;
    private String store;

    public GUI(){
        frame = new JFrame("Message Store");
        User_name = new JLabel("Enter User Name:");
        name = new JTextField(10);
        indicator = new JLabel("Enter messsage:");
        message = new JTextArea(30, 15);
        send = new JButton("Send");
        retrieve = new JButton("Retrieve");
        store = "";
        storeInfo = new List();
    }
    
    public void SetUp(){
        Container con = frame.getContentPane();
        FlowLayout Flow = new FlowLayout();
        con.setLayout(Flow);
        frame.setSize(200, 200);
        frame.setTitle("Message Store");
        con.add(User_name);
        con.add(name);
        con.add(indicator);
        con.add(message);
        frame.add(send);
        frame.add(retrieve);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    public List Send(){
        ActionListener sendMes = new ActionListener(){
            @Override
            public void actionPerformed (ActionEvent e){
                storeInfo.add(name.getText());
                storeInfo.add(message.getText());
            }
        };
        send.addActionListener(sendMes); 
        return storeInfo;      
    }

    public String Retrieve(){
        ActionListener retrieveMes = new ActionListener(){
            @Override
            public void actionPerformed (ActionEvent e){
                store = name.getText();
            }
        };
        retrieve.addActionListener(retrieveMes);
        return store;
    }

    public void display(String storedMes){
        message.setText(storedMes);
    }

    public void remove(){
        storeInfo.removeAll();
    }

    public void reset(){
        store = "";
    }
}
