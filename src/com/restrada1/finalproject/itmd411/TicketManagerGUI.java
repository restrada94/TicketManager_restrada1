package com.restrada1.finalproject.itmd411;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.*;

import java.sql.SQLException;

public class TicketManagerGUI extends Application implements GUIHelper, Controller{

    private Stage primaryWindow;
    private Stage popupStage;
    private Stage miniPopupStage;

    static String statusMessage = "";

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            primaryWindow = primaryStage;
            primaryWindow.setScene(mainMenuUI()); //TODO: TEMPORARY!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            primaryWindow.setResizable(false);
            primaryWindow.setTitle("ITMD 411 - Restrada1 TicketManager Final Project");
            primaryWindow.show();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    private Scene loginScreenUI(){

        //establishing two panes - a vbox for the overall components, and an HBox to contain the login and exit buttons.
        VBox vBox = new VBox(20);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(25,50,20,50));

        HBox hBox = new HBox(5);
        hBox.setAlignment(Pos.CENTER);

        //creating a new scene
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
        statusLabel.setTextFill(Color.RED);
        //Login Button
        Button loginButton = new Button("Log In");
        loginButton.setPrefSize(100, 20);
        //login Validation

        loginButton.setOnAction(e -> loginAuthenticator(usernameField, passwordField, statusLabel));

        //Exit button
        Button exitButton = new Button ("Exit");
        exitButton.setPrefSize(100, 20);
        exitButton.setOnAction(e -> Platform.exit());

        //add components to the layout
        hBox.getChildren().addAll(loginButton, exitButton);
        vBox.getChildren().addAll(text, usernameLabel, usernameField, passwordLabel, passwordField, statusLabel, hBox);

        return scene;
    }

    private Scene mainMenuUI(){
        VBox vBox = new VBox(20);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(25,50,20,50));
        Scene scene = new Scene(vBox, 850, 600);

        HBox hBox = new HBox(20);
        hBox.setPadding(new Insets(20,10,10,10));
        hBox.setAlignment(Pos.CENTER);

        //Title fields
        Text text = new Text("Ticket Manager Main Menu");
        text.setFont(Font.font("Courier New", FontWeight.BOLD, 24));

        Label label = new Label("Please select an action below:");
        label.setFont(Font.font("Courier New", FontWeight.BOLD, 14));

        //Create new ticket menu button.
        Button createTicketButton = new Button("Create a New Ticket");
        createTicketButton.setPrefSize(225, 50);
        createTicketButton.setOnAction(e -> createPopupWindow(createTicketMenuUI(CrudType.CREATE)));

        //Retrieve existing ticket menu button.
        Button retrieveTicketButton = new Button("Retrieve an Existing Ticket");
        retrieveTicketButton.setPrefSize(225, 50);
//        retrieveTicketButton.setOnAction(e -> createPopupWindow(retrieveTicketMenuUI(), retrieveTicketButton.getText()));

        //Update existing ticket menu button.
         Button updateTicketButton = new Button("Update an Existing Ticket");
         updateTicketButton.setPrefSize(225, 50);
//        updateTicketButton.setOnAction(e -> createPopupWindow(updateTicketMenuUI(), updateTicketButton.getText()));

        //Delete existing ticket menu button.
        Button deleteTicketButton = new Button("Delete an Existing Ticket");
        deleteTicketButton.setPrefSize(225, 50);
//        deleteTicketButton.setOnAction(e -> createPopupWindow(deleteTicketMenuUI(), deleteTicketButton.getText()));

        //Retrieve all tickets menu button.
        Button allTicketsButton = new Button("View a List of All Tickets");
        allTicketsButton.setPrefSize(225, 50);
//        allTicketsButton.setOnAction(e -> createPopupWindow(retrieveAllTicketsMenuUI(), allTicketsButton.getText()));

        //Logout Button
        Button logoutButton = new Button("Log Out");
        logoutButton.setOnAction(e -> primaryWindow.setScene(loginScreenUI()));
        logoutButton.setPrefSize(100, 20);

        //Exit button
        Button exitButton = new Button ("Exit");
        exitButton.setOnAction(e -> Platform.exit());
        exitButton.setPrefSize(100, 20);

        //add components to the layout
        hBox.getChildren().addAll(logoutButton, exitButton);
        vBox.getChildren().addAll(text, label, createTicketButton, retrieveTicketButton, updateTicketButton, deleteTicketButton, allTicketsButton, hBox);

        return scene;
    }
    //validation used for authenticating a user
    private void loginAuthenticator(TextField textField, PasswordField passwordField, Label statusLabel){
        if(textField.getText().equals("admin") && passwordField.getText().equals("admin")){
            primaryWindow.setScene(mainMenuUI());
        } else {
            statusLabel.setText("Invalid Credentials.");
            textField.setText("");
            passwordField.setText("");
        }
    }
    //adapter code for eliminating boilerplate and for creating a scene on a new popup window
    private void createPopupWindow(Scene scene){
        popupStage = new Stage();
        popupStage.initModality(Modality.APPLICATION_MODAL);
        popupStage.setScene(scene);
        popupStage.showAndWait();
    }

    public static void main(String[] args) throws SQLException {
        //launch(args);
        Dao dao = new Dao();
        dao.createTicketsTable();
    }
}
