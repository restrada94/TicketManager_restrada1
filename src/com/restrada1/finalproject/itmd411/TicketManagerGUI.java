package com.restrada1.finalproject.itmd411;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TicketManagerGUI {

    public TicketManagerGUI() {
        displayGUI();
    }

    void displayGUI(){
        JFrame ticketManagerFrame = new JFrame();
        ticketManagerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ticketManagerFrame.setSize(720,480);
        ticketManagerFrame.setTitle("restrada1 - Ticket Manager");
        JPanel currentPanel = loginPanel();
        ticketManagerFrame.add(currentPanel);
        ticketManagerFrame.setContentPane(currentPanel);
        ticketManagerFrame.setVisible(true);
        ticketManagerFrame.repaint();
        ticketManagerFrame.revalidate();
    }
     JPanel loginPanel(){
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.PAGE_AXIS));
        loginPanel.setSize(720,480);
        JTextField username = new JTextField();
        username.setSize(300, 25);
        JPasswordField passwordField = new JPasswordField();
        passwordField.setSize(300,25);
        JButton login = new JButton("Log In");
        loginPanel.add(username);
        loginPanel.add(passwordField);
        loginPanel.add(login);
        return loginPanel;
    }
    void ticketManagerPanel(){JPanel ticketManagerPanel;}
    void createTicketPanel(){JPanel createTicketPanel;}
    void retrieveTicketPanel(){JPanel retrieveTicketPanel;}
    void updateTicketPanel(){JPanel updateTicketPanel;}
    void deleteTicketPanel(){JPanel deleteTicketPanel;}
    void retrieveAllTicketsPanel(){JPanel retrieveAllTicketsPanel;}

    public static void main(String[] args){
        TicketManagerGUI gui = new TicketManagerGUI();
    }
}
