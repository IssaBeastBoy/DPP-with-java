package com.javatpoint; 
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Hashtable;


class Comunicate_impl extends UnicastRemoteObject implements Communicate{
    Comunicate_impl()throws RemoteException
    {  
        user_Table =  new Hashtable<String, String>();
        } 
    
    private Hashtable<String, String> user_Table;

    public String sentMessage(String User, String sentMessage){
        if (user_Table.contains(User)){
            String curr_Message = user_Table.get(User);
            String add_Message = curr_Message + '\n' + sentMessage;
            user_Table.remove(User);
            user_Table.put(User, add_Message);
            return "Message added";
        }
        else{
            return "User does not exist";
        }

    }

    public String retrieveMessage(String User){
        if (user_Table.contains(User)){
            return user_Table.get(User);
        }
        else{
            return "User does not exist";
        }
    }
}
