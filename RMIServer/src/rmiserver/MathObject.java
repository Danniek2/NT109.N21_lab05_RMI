/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rmiserver;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Admin
 */
public class MathObject extends UnicastRemoteObject implements IMath {
    public MathObject() throws RemoteException {
            super();
    }
    @Override
    public int add(int a, int b) throws RemoteException {
            return a+b;
    }    
    @Override
    public int sub(int a, int b) throws RemoteException {
            return a-b;
}   
    @Override
    public int mul(int a, int b) throws RemoteException {
            return a*b;
    }
    @Override
    public int div(int a, int b) throws RemoteException {
            return a/b;
    }
}

