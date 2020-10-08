package com.javatpoint; 
import java.rmi.Remote;
import java.rmi.RemoteException;

interface Communicate extends  Remote{
  public String sentMessage(String User, String Message)throws RemoteException;
  public String retrieveMessage(String User)throws RemoteException;
}