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

public class Client{  
    public static void main(String args[]){
    try{
    Communicate user = (Communicate)Naming.lookup("rmi://localhost:6666/javatpoint");  
    GUI plateform = new GUI();
    plateform.SetUp();
    while(true){
        List UserName = plateform.Send();
        if(UserName.getItemCount() > 0){
            plateform.display(user.sentMessage(UserName.getItem(0), UserName.getItem(1)));
            plateform.remove();
        }

        String User_Name = plateform.Retrieve();
        if(User_Name != ""){
            plateform.display(user.retrieveMessage(User_Name));
           plateform.reset();
        }
    }
    }    
    catch (Exception e) {
        // nothing
    }   
    }
}  