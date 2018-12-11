package com.restrada1.finalproject.itmd411;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TicketManagerGUI extends Application {

    Stage primaryWindow;
    Scene loginScreen, mainMenu, createTicketMenu, retrieveTicketMenu, updateTicketMenu, deleteTicketMenu, retrieveAllTicketsMenu;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryWindow = primaryStage;
    }

    void mainMenuUI(){}

    void createTicketMenuUI(){}

    void retrieveTicketMenuUI(){}

    void updateTicketMenuUI(){}

    void deleteTicketMenuUI(){}

    void retrieveAllTicketsMenuUI(){}

    public static void main(String[] args){
        launch(args);
    }
}
//    void ticketManagerPanel(){JPanel ticketManagerPanel;}
//    void createTicketPanel(){JPanel createTicketPanel;}
//    void retrieveTicketPanel(){JPanel retrieveTicketPanel;}
//    void updateTicketPanel(){JPanel updateTicketPanel;}
//    void deleteTicketPanel(){JPanel deleteTicketPanel;}
//    void retrieveAllTicketsPanel(){JPanel retrieveAllTicketsPanel;}