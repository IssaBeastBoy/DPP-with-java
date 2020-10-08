package com.javatpoint; 
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.RemoteException;
import java.rmi.*;

public class Server{  
    public static void main(String args[])throws Exception{  
        Remote communicate = new Comunicate_impl();
        Naming.rebind("rmi://localhost:6666/javatpoint", communicate);
    }
}