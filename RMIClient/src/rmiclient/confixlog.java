/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rmiclient;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
/**
 *
 * @author Admin
 */
public class confixlog {
    public confixlog()
    {
    
    }
    public void Logs(String s) throws IOException{
        Date date = new Date();
        System.out.print(date +": "+ s + "\n");
        try{
            //tạo tệp và lưu vào ổ D:\\JavaTest\\test22_5 với tên là Logs
               File foder = new File("D:\\JavaTest\\RMI\\RMIClient\\Logs");
                if (!foder.exists()) {
                if (foder.mkdir()) { }
                 }
            //tạo file txt để ghi log và lưu vào tệp vừa tạo
               File file =new File("D:\\JavaTest\\RMI\\RMIClient\\Logs\\DangTrongDanh_20521160.txt");

               if(!file.exists()){
                  file.createNewFile();
               }

               //nối thêm nội dung vào tệp
               FileWriter fw = new FileWriter(file,true);
               //ghi bufferedWriter để cho hiệu suất tốt hơn
               BufferedWriter bw = new BufferedWriter(fw);
               bw.write(date+": " + s + "\n");
               //đóng luồng
               bw.close();

             }catch(IOException ioe){
                System.out.println(ioe);
              }
    }
    
}
