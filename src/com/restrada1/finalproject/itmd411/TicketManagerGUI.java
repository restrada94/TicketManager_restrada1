package com.restrada1.finalproject.itmd411;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class TicketManagerGUI extends Application {

    private Dao dao = new Dao();

    private Stage primaryWindow;
    private Stage popupStage;
    private Stage miniPopupStage;

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

    Scene loginScreenUI(){

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

    Scene mainMenuUI(){
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
        createTicketButton.setOnAction(e -> createPopupWindow(createTicketMenuUI(), createTicketButton.getText()));

        //Retrieve existing ticket menu button.
        Button retrieveTicketButton = new Button("Retrieve an Existing Ticket");
        retrieveTicketButton.setPrefSize(225, 50);
        retrieveTicketButton.setOnAction(e -> createPopupWindow(retrieveTicketMenuUI(), retrieveTicketButton.getText()));

        //Update existing ticket menu button.
        Button updateTicketButton = new Button("Update an Existing Ticket");
        updateTicketButton.setPrefSize(225, 50);
        updateTicketButton.setOnAction(e -> createPopupWindow(updateTicketMenuUI(), updateTicketButton.getText()));

        //Delete existing ticket menu button.
        Button deleteTicketButton = new Button("Delete an Existing Ticket");
        deleteTicketButton.setPrefSize(225, 50);
        deleteTicketButton.setOnAction(e -> createPopupWindow(deleteTicketMenuUI(), deleteTicketButton.getText()));

        //Retrieve all tickets menu button.
        Button allTicketsButton = new Button("View a List of All Tickets");
        allTicketsButton.setPrefSize(225, 50);
        allTicketsButton.setOnAction(e -> createPopupWindow(retrieveAllTicketsMenuUI(), allTicketsButton.getText()));

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

    Scene createTicketMenuUI(){
        //Creating a new VBox pane.
        VBox vBox = new VBox(20);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(25,50,20,50));

        //Title
        Text title = new Text("CHANGE AS NEEDED"); //TODO UPDATE TITLE
        title.setFont(Font.font("Courier New", FontWeight.BOLD, 18));

         //ID + "function" button Hbox pane + "Clear" button
        Label idLabel = new Label("Search for Ticket ID:");

        TextField idField = new TextField();

        Button functionButton = new Button("SUBSTITUTE HERE"); //TODO Replace Action, Program in functionality
        functionButton.setOnAction(e -> {});
        functionButton.setPrefSize(100, 20);

        Button clearResults = new Button("Clear"); //TODO add functionality
        clearResults.setOnAction(e -> {});
        clearResults.setPrefSize(100, 20);

        HBox hBox1 = new HBox(5);
        hBox1.setAlignment(Pos.CENTER);
        hBox1.getChildren().addAll(idLabel, idField, functionButton, clearResults);

        //Ticket object parameter descriptions (HBox)
        Label id = new Label("ID");
        id.setPrefSize(100,20);
        id.setAlignment(Pos.CENTER);

        Label customerName = new Label("Customer Name");
        customerName.setPrefSize(100, 20);
        customerName.setAlignment(Pos.CENTER);

        Label dateTime = new Label("Date/Time");
        dateTime.setPrefSize(100, 20);
        dateTime.setAlignment(Pos.CENTER);

        Label isResolved = new Label("Resolved?");
        isResolved.setPrefSize(100, 20);
        isResolved.setAlignment(Pos.CENTER);

        Label priority = new Label("Priority");
        priority.setPrefSize(100, 20);
        priority.setAlignment(Pos.CENTER);

        HBox hBox2 = new HBox(5);
        hBox2.setPadding(new Insets(0,20,-8,20));
        hBox2.setAlignment(Pos.CENTER);
        hBox2.getChildren().setAll(id, customerName, dateTime, isResolved, priority);

        //Ticket object parameter textboxes (HBox)
        TextField idTextField = new TextField();
        idTextField.setPrefSize(100,20);

        TextField customerNameField = new TextField();
        customerNameField.setPrefSize(100, 20);

        TextField dateTimeField = new TextField();
        dateTimeField.setPrefSize(100, 20);

        TextField isResolvedField = new TextField();
        isResolvedField.setPrefSize(100, 20);

        TextField priorityField = new TextField();
        priorityField.setPrefSize(100, 20);

        HBox hBox3 = new HBox(5);
        hBox3.setAlignment(Pos.CENTER);
        hBox3.setPadding(new Insets(-8,20,0,20));
        hBox3.getChildren().setAll(idTextField, customerNameField, dateTimeField, isResolvedField, priorityField);

        //Description in VBox
        Label descriptionLabel = new Label("Ticket Description");
        descriptionLabel.setPadding(new Insets(-8, 20, -16, 20));
        //Description Text box
        TextArea descriptionField = new TextArea();
        descriptionField.setPrefSize(400, 120);
        descriptionField.setWrapText(true);
        addTextAreaLimiter(descriptionField, 255);
        //"Exit" Button

        Button exitButton = new Button("Exit");
        exitButton.setPrefSize(100, 20);
        exitButton.setOnAction(e -> popupStage.close());

        //creating a new scene.
        Scene scene = new Scene(vBox, 640, 480);
        vBox.getChildren().addAll(hBox1, hBox2, hBox3, descriptionLabel, descriptionField, exitButton);

        return scene;
    }

    Scene retrieveTicketMenuUI(){
        //Creating a new VBox pane.
        VBox vBox = new VBox(20);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(25,50,20,50));

        //creating a new scene.
        Scene scene = new Scene(vBox, 640, 480);
        vBox.getChildren().addAll();

        return scene;
    }

    Scene updateTicketMenuUI(){        //Creating a new VBox pane.
        VBox vBox = new VBox(20);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(25,50,20,50));

        //creating a new scene.
        Scene scene = new Scene(vBox, 640, 480);
        vBox.getChildren().addAll();

        return scene;
    }

    Scene deleteTicketMenuUI(){        //Creating a new VBox pane.
        VBox vBox = new VBox(20);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(25,50,20,50));

        //creating a new scene.
        Scene scene = new Scene(vBox, 640, 480);
        vBox.getChildren().addAll();

        return scene;
    }

    Scene retrieveAllTicketsMenuUI(){
        //Creating a new VBox pane.
        VBox vBox = new VBox(20);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(25,50,20,50));

        //creating a new scene.
        Scene scene = new Scene(vBox, 640, 480);
        vBox.getChildren().addAll();

        return scene;
    }

    //validation used for authenticating a user
    void loginAuthenticator(TextField textField, PasswordField passwordField, Label statusLabel){
        if(textField.getText().equals("admin") && passwordField.getText().equals("admin")){
            primaryWindow.setScene(mainMenuUI());
        } else {
            statusLabel.setText("Invalid Credentials.");
            textField.setText("");
            passwordField.setText("");
        }
    }
    //adapter code for eliminating boilerplate and for creating a scene on a new popup window
    void createPopupWindow(Scene scene, String title){
        popupStage = new Stage();

        popupStage.initModality(Modality.APPLICATION_MODAL);
        popupStage.setTitle(title);

        popupStage.setScene(scene);
        popupStage.showAndWait();
    }

    //Method for defining a max setting for the number of allowed characters on a TextArea.
    public void addTextAreaLimiter(final TextArea ta, final int maxLength) {
        ta.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(final ObservableValue<? extends String> ov, final String oldValue, final String newValue) {
                if (ta.getText().length() > maxLength) {
                    String s = ta.getText().substring(0, maxLength);
                    ta.setText(s);
                }
            }
        });
    }

    //Method for defining a max setting for the number of allowed characters on a TextField.
    public void addTextLimiter(final TextField tf, final int maxLength) {
        tf.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(final ObservableValue<? extends String> ov, final String oldValue, final String newValue) {
                if (tf.getText().length() > maxLength) {
                    String s = tf.getText().substring(0, maxLength);
                    tf.setText(s);
                }
            }
        });
    }

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