/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
public class RMINangCao {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException{
        confixlog n = new confixlog();

        // TODO code application logic here
        try {
            IMath imath = (IMath) Naming.lookup("rmi://localhost:5000/MyServices");
            float[] nghiem = imath.PTBac2(1, -2, -3);
            System.out.println("Phuong trinh co 2 nghiem la: " + nghiem[0] + ", " + nghiem[1]);
            n.Logs("Ket qua tinh phuong trinh bac hai!");
        }
        catch (Exception e) {
        System.err.println("Error: " + e.getMessage());
        System.out.println("nhap vao bi loi");
        n.Logs("nhap vao bi loi");
        }
    }
}
