/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rmiclient;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;
import rmiserver.IMath;
import rmiserver.MathObject;


public class CalculatorClient extends Frame implements ActionListener {
	
	Frame frame = new Frame("Calculator");
	MenuBar menuBar = new MenuBar();
	Panel p = new Panel();
	TextField tf = new TextField("");
	Panel p1 = new Panel();
	GridBagLayout gbl_panel_1 = new GridBagLayout();
	Button btnmc = new Button("MC");
	Button btnmr = new Button("MR");
	Button btnms = new Button("MS");
	Button btnmcong = new Button("M+");
	Button btnmtru = new Button("M-");
	Button btnmuiten = new Button("<--");
	Button btnce = new Button("CE");
	Button btnc = new Button("C");
	Button btncongtru = new Button("+-");
	Button btncan = new Button("CAN");
	Button btn7 = new Button("7");
	Button btn8 = new Button("8");
	Button btn9 = new Button("9");
	Button btnchia = new Button("/");
	Button btnphantram = new Button("%");
	Button btn4 = new Button("4");
	Button btn5 = new Button("5");
	Button btn6 = new Button("6");
	Button btnnhan = new Button("*");
	Button btn1chiax = new Button("1/x");
	Button btn1 = new Button("1");
	Button btn2 = new Button("2");
	Button btn3 = new Button("3");
	Button btntru = new Button("-");
	Button btnbang = new Button("=");
	Button btn0 = new Button("0");
	Button btncham = new Button(".");
	Button btncong = new Button("+");
	
	int num1,num2,check;
        int xd;
    
	public CalculatorClient()
	{
		
		//Tạo một frame có tên là calculator với kích thước 400, 600
		
		frame.addWindowListener(new WindowAdapter(){
		    public void windowClosing(WindowEvent e){
		    	System.exit(0);
		    }
		});

		frame.setSize(250, 300);
		frame.setVisible(true);
		frame.setLayout(null);
		
		//Tạo một menubar như yêu cầu bài toán với các menu View, Edit, help
		
        Menu menuV = new Menu("View");
        Menu menuE = new Menu("Edit");
        Menu menuH = new Menu("Help");
        
        //add các menu vào menubar
        menuBar.add(menuV);
        menuBar.add(menuE);
        menuBar.add(menuH);
        
        //add menuBar vào frame
        frame.setMenuBar(menuBar);
		//
        
        p.setBounds(20, 40, 200, 50);
        p.setLayout(null);
        frame.add(p);
        
        
        tf.setBounds(10, 10, 185, 40);
        tf.setColumns(10);
        tf.enable(false);
        p.add(tf);
        
        //Panel chứa button
        
        p1.setBounds(30, 100, 400, 350);
        frame.add(p1);
        
        //
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		p1.setLayout(gbl_panel_1);
		
		//Button MC
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridheight = 2;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 0;
		p1.add(btnmc, gbc_btnNewButton);
		
		//Button MR
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton_1.gridheight = 2;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 2;
		gbc_btnNewButton_1.gridy = 0;
		p1.add(btnmr, gbc_btnNewButton_1);
		
		//Button MS
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.gridheight = 2;
		gbc_btnNewButton_2.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 4;
		gbc_btnNewButton_2.gridy = 0;
		p1.add(btnms, gbc_btnNewButton_2);
		
		//Button M+
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.gridheight = 2;
		gbc_btnNewButton_3.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_3.gridx = 6;
		gbc_btnNewButton_3.gridy = 0;
		p1.add(btnmcong, gbc_btnNewButton_3);
		
		//Button M-
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.gridheight = 2;
		gbc_btnNewButton_4.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_4.gridx = 8;
		gbc_btnNewButton_4.gridy = 0;
		p1.add(btnmtru, gbc_btnNewButton_4);
		
		//Button <--
		GridBagConstraints gbc_btnNewButton_5 = new GridBagConstraints();
		gbc_btnNewButton_5.gridheight = 2;
		gbc_btnNewButton_5.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_5.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_5.gridx = 0;
		gbc_btnNewButton_5.gridy = 2;
		p1.add(btnmuiten, gbc_btnNewButton_5);
		
		//Button CE
		GridBagConstraints gbc_btnNewButton_6 = new GridBagConstraints();
		gbc_btnNewButton_6.gridheight = 2;
		gbc_btnNewButton_6.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_6.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_6.gridx = 2;
		gbc_btnNewButton_6.gridy = 2;
		p1.add(btnce, gbc_btnNewButton_6);
		
		//Button C
		GridBagConstraints gbc_btnNewButton_7 = new GridBagConstraints();
		gbc_btnNewButton_7.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_7.gridheight = 2;
		gbc_btnNewButton_7.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_7.gridx = 4;
		gbc_btnNewButton_7.gridy = 2;
		p1.add(btnc, gbc_btnNewButton_7);
		
		//Button +-
		GridBagConstraints gbc_btnNewButton_8 = new GridBagConstraints();
		gbc_btnNewButton_8.gridheight = 2;
		gbc_btnNewButton_8.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_8.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_8.gridx = 6;
		gbc_btnNewButton_8.gridy = 2;
		p1.add(btncongtru, gbc_btnNewButton_8);
		
		//Button CAN
		GridBagConstraints gbc_btnNewButton_9 = new GridBagConstraints();
		gbc_btnNewButton_9.gridheight = 2;
		gbc_btnNewButton_9.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton_9.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_9.gridx = 8;
		gbc_btnNewButton_9.gridy = 2;
		p1.add(btncan, gbc_btnNewButton_9);
		
		//Button 7
		btn7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_btnNewButton_10 = new GridBagConstraints();
		gbc_btnNewButton_10.gridheight = 2;
		gbc_btnNewButton_10.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_10.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_10.gridx = 0;
		gbc_btnNewButton_10.gridy = 4;
		p1.add(btn7, gbc_btnNewButton_10);
		
		//Button 8
		GridBagConstraints gbc_btnNewButton_11 = new GridBagConstraints();
		gbc_btnNewButton_11.gridheight = 2;
		gbc_btnNewButton_11.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_11.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_11.gridx = 2;
		gbc_btnNewButton_11.gridy = 4;
		p1.add(btn8, gbc_btnNewButton_11);
		
		//Button 9
		GridBagConstraints gbc_btnNewButton_12 = new GridBagConstraints();
		gbc_btnNewButton_12.gridheight = 2;
		gbc_btnNewButton_12.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_12.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_12.gridx = 4;
		gbc_btnNewButton_12.gridy = 4;
		p1.add(btn9, gbc_btnNewButton_12);
		
		//Button /
		GridBagConstraints gbc_btnNewButton_13 = new GridBagConstraints();
		gbc_btnNewButton_13.gridheight = 2;
		gbc_btnNewButton_13.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_13.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_13.gridx = 6;
		gbc_btnNewButton_13.gridy = 4;
		p1.add(btnchia, gbc_btnNewButton_13);
		
		//Button %
		GridBagConstraints gbc_btnNewButton_14 = new GridBagConstraints();
		gbc_btnNewButton_14.gridheight = 2;
		gbc_btnNewButton_14.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_14.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_14.gridx = 8;
		gbc_btnNewButton_14.gridy = 4;
		p1.add(btnphantram, gbc_btnNewButton_14);
		
		//Button 4
		GridBagConstraints gbc_btnNewButton_15 = new GridBagConstraints();
		gbc_btnNewButton_15.gridheight = 2;
		gbc_btnNewButton_15.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_15.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_15.gridx = 0;
		gbc_btnNewButton_15.gridy = 6;
		p1.add(btn4, gbc_btnNewButton_15);
		
		//Button 5
		GridBagConstraints gbc_btnNewButton_16 = new GridBagConstraints();
		gbc_btnNewButton_16.gridheight = 2;
		gbc_btnNewButton_16.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_16.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_16.gridx = 2;
		gbc_btnNewButton_16.gridy = 6;
		p1.add(btn5, gbc_btnNewButton_16);
		
		//Button 6
		GridBagConstraints gbc_btnNewButton_17 = new GridBagConstraints();
		gbc_btnNewButton_17.gridheight = 2;
		gbc_btnNewButton_17.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_17.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_17.gridx = 4;
		gbc_btnNewButton_17.gridy = 6;
		p1.add(btn6, gbc_btnNewButton_17);
		
		//Button *
		GridBagConstraints gbc_btnNewButton_18 = new GridBagConstraints();
		gbc_btnNewButton_18.gridheight = 2;
		gbc_btnNewButton_18.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_18.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_18.gridx = 6;
		gbc_btnNewButton_18.gridy = 6;
		p1.add(btnnhan, gbc_btnNewButton_18);
		
		//Button 1/x
		GridBagConstraints gbc_btnNewButton_19 = new GridBagConstraints();
		gbc_btnNewButton_19.gridheight = 2;
		gbc_btnNewButton_19.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_19.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_19.gridx = 8;
		gbc_btnNewButton_19.gridy = 6;
		p1.add(btn1chiax, gbc_btnNewButton_19);
		
		//Button 1
		GridBagConstraints gbc_btnNewButton_20 = new GridBagConstraints();
		gbc_btnNewButton_20.gridheight = 2;
		gbc_btnNewButton_20.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_20.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_20.gridx = 0;
		gbc_btnNewButton_20.gridy = 8;
		p1.add(btn1, gbc_btnNewButton_20);
		
		//Button 2
		GridBagConstraints gbc_btnNewButton_21 = new GridBagConstraints();
		gbc_btnNewButton_21.gridheight = 2;
		gbc_btnNewButton_21.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_21.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_21.gridx = 2;
		gbc_btnNewButton_21.gridy = 8;
		p1.add(btn2, gbc_btnNewButton_21);
		
		//Button 3
		GridBagConstraints gbc_btnNewButton_22 = new GridBagConstraints();
		gbc_btnNewButton_22.gridheight = 2;
		gbc_btnNewButton_22.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_22.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_22.gridx = 4;
		gbc_btnNewButton_22.gridy = 8;
		p1.add(btn3, gbc_btnNewButton_22);
		
		//Button -
		GridBagConstraints gbc_btnNewButton_23 = new GridBagConstraints();
		gbc_btnNewButton_23.gridheight = 2;
		gbc_btnNewButton_23.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_23.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_23.gridx = 6;
		gbc_btnNewButton_23.gridy = 8;
		p1.add(btntru, gbc_btnNewButton_23);
		
		//Button =
		GridBagConstraints gbc_btnNewButton_24 = new GridBagConstraints();
		gbc_btnNewButton_24.gridheight = 4;
		gbc_btnNewButton_24.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_24.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_24.gridx = 8;
		gbc_btnNewButton_24.gridy = 8;
		p1.add(btnbang, gbc_btnNewButton_24);
		
		//Button 0
		GridBagConstraints gbc_btnNewButton_25 = new GridBagConstraints();
		gbc_btnNewButton_25.gridheight = 2;
		gbc_btnNewButton_25.gridwidth = 3;
		gbc_btnNewButton_25.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_25.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_25.gridx = 0;
		gbc_btnNewButton_25.gridy = 10;
		p1.add(btn0, gbc_btnNewButton_25);
		
		//Button .
		GridBagConstraints gbc_btnNewButton_27 = new GridBagConstraints();
		gbc_btnNewButton_27.gridheight = 2;
		gbc_btnNewButton_27.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_27.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_27.gridx = 4;
		gbc_btnNewButton_27.gridy = 10;
		p1.add(btncham, gbc_btnNewButton_27);
		
		//Button +
		GridBagConstraints gbc_btnNewButton_28 = new GridBagConstraints();
		gbc_btnNewButton_28.gridheight = 2;
		gbc_btnNewButton_28.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_28.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_28.gridx = 6;
		gbc_btnNewButton_28.gridy = 10;
		p1.add(btncong, gbc_btnNewButton_28);
		
		//sử lí sự kiện 
		btn0.addActionListener((ActionListener) this);
		btn1.addActionListener((ActionListener) this);
		btn2.addActionListener((ActionListener) this);
		btn3.addActionListener((ActionListener) this);
		btn4.addActionListener((ActionListener) this);
		btn5.addActionListener((ActionListener) this);
		btn6.addActionListener((ActionListener) this);
		btn7.addActionListener((ActionListener) this);
		btn8.addActionListener((ActionListener) this);
		btn9.addActionListener((ActionListener) this);
		
		btncong.addActionListener((ActionListener) this);
		btntru.addActionListener((ActionListener) this);
		btnnhan.addActionListener((ActionListener) this);
		btnchia.addActionListener((ActionListener) this);
		btnbang.addActionListener((ActionListener) this);
	}

	public static void main(String[] args) {
                confixlog n = new confixlog();
		// TODO Auto-generated method stub
		new CalculatorClient();
                try {
                LocateRegistry.createRegistry(5000);
                Naming.bind("rmi://localhost:5000/MyServices", new MathObject());
                System.out.println("Server Started!!!");
            }
            catch (Exception e) {
                System.err.println("Error: " + e.getMessage());	
            }
                

	}
	
	public void actionPerformed(ActionEvent e) {
            confixlog n = new confixlog();
        String z, zt;
        if (e.getSource() == btn0) {
            zt = tf.getText();
            z = zt + "0";
            tf.setText(z);
                try {
                    n.Logs("Da nhap vao 0");
                } catch (IOException ex) {
                    Logger.getLogger(CalculatorClient.class.getName()).log(Level.SEVERE, null, ex);
                }

        }
        if (e.getSource() == btn1) {
            zt = tf.getText();
            z = zt + "1";
            tf.setText(z);
            try {
                    n.Logs("Da nhap vao 1");
                } catch (IOException ex) {
                    Logger.getLogger(CalculatorClient.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        if (e.getSource() == btn2) {
            zt = tf.getText();
            z = zt + "2";
            tf.setText(z);
            try {
                    n.Logs("Da nhap vao 2");
                } catch (IOException ex) {
                    Logger.getLogger(CalculatorClient.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        if (e.getSource() == btn3) {
            zt = tf.getText();
            z = zt + "3";
            tf.setText(z);
            try {
                    n.Logs("Da nhap vao 3");
                } catch (IOException ex) {
                    Logger.getLogger(CalculatorClient.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        if (e.getSource() == btn4) {
            zt = tf.getText();
            z = zt + "4";
            tf.setText(z);
            try {
                    n.Logs("Da nhap vao 4");
                } catch (IOException ex) {
                    Logger.getLogger(CalculatorClient.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        if (e.getSource() == btn5) {
            zt = tf.getText();
            z = zt + "5";
            tf.setText(z);
            try {
                    n.Logs("Da nhap vao 5");
                } catch (IOException ex) {
                    Logger.getLogger(CalculatorClient.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        if (e.getSource() == btn6) {
            zt = tf.getText();
            z = zt + "6";
            tf.setText(z);
            try {
                    n.Logs("Da nhap vao 6");
                } catch (IOException ex) {
                    Logger.getLogger(CalculatorClient.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        if (e.getSource() == btn7) {
            zt = tf.getText();
            z = zt + "7";
            tf.setText(z);
            try {
                    n.Logs("Da nhap vao 7");
                } catch (IOException ex) {
                    Logger.getLogger(CalculatorClient.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        if (e.getSource() == btn8) {
            zt = tf.getText();
            z = zt + "8";
            tf.setText(z);
            try {
                    n.Logs("Da nhap vao 8");
                } catch (IOException ex) {
                    Logger.getLogger(CalculatorClient.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        if (e.getSource() == btn9) {
            zt = tf.getText();
            z = zt + "9";
            tf.setText(z);
            try {
                    n.Logs("Da nhap vao 9");
                } catch (IOException ex) {
                    Logger.getLogger(CalculatorClient.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        if (e.getSource() == btncham) {
            zt = tf.getText();
            z = zt + ".";
            tf.setText(z);
            try {
                    n.Logs("Da nhap vao .");
                } catch (IOException ex) {
                    Logger.getLogger(CalculatorClient.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        
        
            
        
        //Sử lí cộng
        if(e.getSource() == btncong)
        {
            try{
                num1 = Integer.parseInt(tf.getText());
            }catch(NumberFormatException f){
                tf.setText("Invalid Format");
                return;
            }
            z = "";
            tf.setText(z);
            check = 1;
            try {
                    n.Logs("Thuc hien phep tinh cong");
                } catch (IOException ex) {
                    Logger.getLogger(CalculatorClient.class.getName()).log(Level.SEVERE, null, ex);
                }

        }
        //Sử lí trừ
        if(e.getSource() == btntru)
        {
            try{
                num1 = Integer.parseInt(tf.getText());
            }catch(NumberFormatException f){
                tf.setText("Invalid Format");
                return;
            }
            z = "";
            tf.setText(z);
            check = 2;
            try {
                    n.Logs("thuc hien phep tinh tru");
                } catch (IOException ex) {
                    Logger.getLogger(CalculatorClient.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        //Sử lí nhân
        if(e.getSource() == btnnhan)
        {
            try{
                num1 = Integer.parseInt(tf.getText());
            }catch(NumberFormatException f){
                tf.setText("Invalid Format");
                return;
            }
            z = "";
            tf.setText(z);
            check = 3;
            try {
                    n.Logs("thuc hien phép tinh nhan");
                } catch (IOException ex) {
                    Logger.getLogger(CalculatorClient.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        //Sử lí chia
        if(e.getSource() == btnchia)
        {
            try{
                num1 = Integer.parseInt(tf.getText());
            }catch(NumberFormatException f){
                tf.setText("Invalid Format");
                return;
            }
            z = "";
            tf.setText(z);
            check = 4;
            try {
                    n.Logs("thuc hien phep tinh chia");
                } catch (IOException ex) {
                    Logger.getLogger(CalculatorClient.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        //Sử lí bằng
        if(e.getSource() == btnbang)
        {
            
            try{
                num2 = Integer.parseInt(tf.getText());
            }catch(Exception f)
            {
                tf.setText("Enter your number!!");
                return;
            }
            if(check == 1)
            {
                try {
                    IMath imath = (IMath) Naming.lookup("rmi://localhost:5000/MyServices");
                    xd = imath.add(num1, num2);
                } catch (NotBoundException ex) {
                    Logger.getLogger(CalculatorClient.class.getName()).log(Level.SEVERE, null, ex);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(CalculatorClient.class.getName()).log(Level.SEVERE, null, ex);
                } catch (RemoteException ex) {
                    Logger.getLogger(CalculatorClient.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    n.Logs("ket qua cua phep tinh cong");
                } catch (IOException ex) {
                    Logger.getLogger(CalculatorClient.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if(check == 2)
            {
                try {
                    IMath imath = (IMath) Naming.lookup("rmi://localhost:5000/MyServices");
                    xd = imath.sub(num1, num2);
                } catch (NotBoundException ex) {
                    Logger.getLogger(CalculatorClient.class.getName()).log(Level.SEVERE, null, ex);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(CalculatorClient.class.getName()).log(Level.SEVERE, null, ex);
                } catch (RemoteException ex) {
                    Logger.getLogger(CalculatorClient.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    n.Logs("ket qua cua phep tinh tru");
                } catch (IOException ex) {
                    Logger.getLogger(CalculatorClient.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(check == 3)
            {
                try {
                    IMath imath = (IMath) Naming.lookup("rmi://localhost:5000/MyServices");
                    xd = imath.mul(num1, num2);
                } catch (NotBoundException ex) {
                    Logger.getLogger(CalculatorClient.class.getName()).log(Level.SEVERE, null, ex);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(CalculatorClient.class.getName()).log(Level.SEVERE, null, ex);
                } catch (RemoteException ex) {
                    Logger.getLogger(CalculatorClient.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    n.Logs("ket qua phep tinh nhan");
                } catch (IOException ex) {
                    Logger.getLogger(CalculatorClient.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(check == 4)
            {
                try {
                    IMath imath = (IMath) Naming.lookup("rmi://localhost:5000/MyServices");
                    xd = imath.div(num1, num2);
                } catch (NotBoundException ex) {
                    Logger.getLogger(CalculatorClient.class.getName()).log(Level.SEVERE, null, ex);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(CalculatorClient.class.getName()).log(Level.SEVERE, null, ex);
                } catch (RemoteException ex) {
                    Logger.getLogger(CalculatorClient.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    n.Logs("ket qua phep tinh chia");
                } catch (IOException ex) {
                    Logger.getLogger(CalculatorClient.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            tf.setText(String.valueOf(xd));
        }
        }
}

