package com.restrada1.finalproject.itmd411;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.SepiaTone;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;

public class TicketManagerGUI extends Application {

    Dao dao = new Dao();

    Stage primaryWindow;
    Scene mainMenu, createTicketMenu, retrieveTicketMenu, updateTicketMenu, deleteTicketMenu, retrieveAllTicketsMenu;

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            primaryWindow = primaryStage;
            primaryWindow.setScene(loginScreenUI());
            primaryWindow.setResizable(false);
            primaryWindow.setTitle("ITMD 411 - Restrada1 TicketManager Final Project");
            primaryWindow.show();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    Scene loginScreenUI(){
        VBox vBox = new VBox(20);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(25,50,20,50));
        Scene scene = new Scene(vBox, 850, 600);

        //Title fields
        Text text = new Text("TicketManager Login");
        text.setFont(Font.font("Courier New", FontWeight.BOLD, 24));

        //Login Fields
        Label usernameLabel = new Label("Username:");
        TextField usernameField = new TextField();
        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();
        Label statusLabel = new Label("");
        //Login Button
        Button loginButton = new Button("Log In");

        //login Validation
        if(loginValidator(usernameField, passwordField)) {
            loginButton.setOnAction(e -> primaryWindow.setScene(mainMenuUI()));
        } else {
            loginButton.setOnAction(e -> statusLabel.setText("Invalid Credentials"));
            statusLabel.setTextFill(Color.RED);
            usernameField.setText("");
            passwordField.setText("");
        }
        //Exit button
        Button exitButton = new Button ("Exit");
        exitButton.setOnAction(e -> Platform.exit());

        //add components to the layout
        vBox.getChildren().addAll(text, usernameLabel, usernameField, passwordLabel, passwordField, loginButton, exitButton, statusLabel);

        return scene;
    }

    boolean loginValidator(TextField textField, PasswordField passwordField){
        return textField.getText().equals("admin") && passwordField.getText().equals("admin");
    }

    Scene mainMenuUI(){ return null;}

    Scene createTicketMenuUI(){return null;}

    Scene retrieveTicketMenuUI(){return null;}

    Scene updateTicketMenuUI(){return null;}

    Scene deleteTicketMenuUI(){return  null;}

    Scene retrieveAllTicketsMenuUI(){return null;}

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