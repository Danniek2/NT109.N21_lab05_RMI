/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rmiserver;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 *
 * @author Admin
 */
public class RMIServer {

    public static void main(String[] args) {
        // TODO code application logic here
        try {
            LocateRegistry.createRegistry(5000);
            Naming.bind("rmi://localhost:5000/MyServices", new MathObject());
            System.out.println("Server Started!!!");
	}
	catch (Exception e) {
            System.err.println("Error: " + e.getMessage());	
	}
    }
}

