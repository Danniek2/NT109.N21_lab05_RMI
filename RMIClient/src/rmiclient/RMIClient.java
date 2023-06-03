/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rmiclient;

import java.rmi.Naming;
import rmiserver.IMath;
import java.util.Scanner;
import java.io.IOException;
/**
 *
 * @author Admin
 */
public class RMIClient {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException{
        confixlog n = new confixlog();
        System.out.print("Nhap so thu nhat, a = ");
        int a = RMIClient.scanner.nextInt();
        n.Logs("Nhap vao so thu nhat");
        System.out.print("Nhap so thu hai, b = ");
        int b = RMIClient.scanner.nextInt();
        n.Logs("Nhap vao so thu hai");
        // TODO code application logic here
        try {
            IMath imath = (IMath) Naming.lookup("rmi://localhost:5000/MyServices");
            
            int tong = imath.add(a, b);
            int hieu = imath.sub(a, b);
            int tich = imath.mul(a, b);
            int thuong = imath.div(a, b);
            System.out.println("Tong 2 so: " + tong);
            n.Logs("ket qua cua phep tinh tong hai so");
            System.out.println("Hieu 2 so: " + hieu);
            n.Logs("ket qua cua phep tinh hieu hai so");
            System.out.println("Tich 2 so: " + tich);
            n.Logs("ket qua cua phep tinh tich hai so");
            System.out.println("Thuong 2 so: " + thuong);
            n.Logs("ket qua cua phep tinh thuong hai so");
        }
        catch (Exception e) {
        System.err.println("Error: " + e.getMessage());
        n.Logs("nhap vao bi loi");
        }
    }
}

