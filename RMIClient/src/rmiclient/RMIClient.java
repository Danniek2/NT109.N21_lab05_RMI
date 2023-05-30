/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rmiclient;

import java.rmi.Naming;
import rmiserver.IMath;

/**
 *
 * @author Admin
 */
public class RMIClient {

    public static void main(String[] args) {
        // TODO code application logic here
        try {
            IMath imath = (IMath) Naming.lookup("rmi://localhost:5000/MyServices");
            
            int tong = imath.add(2,4);
            int hieu = imath.sub(2, 4);
            int tich = imath.mul(2, 4);
            int thuong = imath.div(4, 2);
            System.out.println("Tong 2 so: " + tong);
            System.out.println("Hieu 2 so: " + hieu);
            System.out.println("Tich 2 so: " + tich);
            System.out.println("Thuong 2 so: " + thuong);
        }
        catch (Exception e) {
        System.err.println("Error: " + e.getMessage());
        }
    }
}

