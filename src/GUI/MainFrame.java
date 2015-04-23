/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import COD_main.User;
import database_conn.DbConnect;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//main frame class definition
//this class holds the frame of the application
//the welcome page of the system
public class MainFrame extends javax.swing.JFrame {
    
    //declaring and initialising main panels
    DbConnect db = new DbConnect();
    User user;
    LogoPanel logo = new LogoPanel();
    LoginPanel login = new LoginPanel(this);
    RegistrationFormPanel regform = new RegistrationFormPanel(this);
    JButton registerButton = new JButton();
    //initialising menu panel without displaying order functionalities
    MenuPanel menu = new MenuPanel(this,false,null);
    CustomerDashboard cd;
    
    //constructor that adds the panels to the frame
    public MainFrame() throws SQLException {
        super("COD - ElevenExpress");
        add(logo, BorderLayout.NORTH);
        add(login, BorderLayout.WEST);
        add(menu, BorderLayout.SOUTH);
        registerButton.setText("Register");
        
        add(registerButton, BorderLayout.CENTER);
        //when register button is pressed, a registration form panel is initialised and added to the frame
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                add(regform, BorderLayout.EAST);
                clearDash();
            }
        });
        //setting menu checkout buttons visibility to false
        menu.SetCheckoutVisible(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        user = login.user;
        pack();
        setVisible(true);
        //  initComponents();

    }
    //method to remove panels from the initial dashboard
    public void clearDash() {
        login.reset();
        remove(login);
        remove(menu);
        remove(registerButton);
        repaint();
        pack();
    }
    //method to add initial dashboard panels
    public void homeDash() {
        add(login, BorderLayout.WEST);
        add(menu, BorderLayout.SOUTH);
        add(registerButton, BorderLayout.CENTER);
        pack();
    }
    public void setCustomerDash(CustomerDashboard c){
        this.cd = c;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 601, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 376, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
