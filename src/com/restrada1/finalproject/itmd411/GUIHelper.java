package com.restrada1.finalproject.itmd411;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import static com.restrada1.finalproject.itmd411.TicketManagerGUI.statusMessage;

interface GUIHelper extends Controller{

    default Scene createTicketMenuUI(CrudType crudType){

        //stage.setTitle("TEST"); //TODO populate value per enum
        String titleString = "TEST"; //TODO populate value per enum

        //Title
        Text title = new Text(titleString);
        title.setFont(Font.font("Courier New", FontWeight.BOLD, 18));

        //Ticket object parameter descriptions (HBox 2)
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

        HBox ticketFieldsHBox = new HBox(5);
        ticketFieldsHBox.setPadding(new Insets(0,20,-8,20));
        ticketFieldsHBox.setAlignment(Pos.CENTER);
        ticketFieldsHBox.getChildren().setAll(id, customerName, dateTime, isResolved, priority);

        //Ticket object parameter textboxes (HBox 3)
        TextField idTextField = new TextField();
        idTextField.setPrefSize(100,20);
        addTextFieldLimiter(idTextField, 50);
        idTextField.setEditable(false);
        idTextField.setDisable(true);

        TextField customerNameField = new TextField();
        customerNameField.setPrefSize(100, 20);
        addTextFieldLimiter(customerNameField, 50);

        TextField dateTimeField = new TextField();
        dateTimeField.setPrefSize(100, 20);
        addTextFieldLimiter(dateTimeField, 25);

        TextField isResolvedField = new TextField();
        isResolvedField.setPrefSize(100, 20);
        addTextFieldLimiter(isResolvedField, 1);

        TextField priorityField = new TextField();
        priorityField.setPrefSize(100, 20);
        addTextFieldLimiter(priorityField, 1);

        HBox hBox2 = new HBox(5);
        hBox2.setAlignment(Pos.CENTER);
        hBox2.setPadding(new Insets(-8,20,0,20));
        hBox2.getChildren().setAll(idTextField, customerNameField, dateTimeField, isResolvedField, priorityField);

        TextArea descriptionField = new TextArea();
        descriptionField.setPrefSize(400, 120);
        descriptionField.setWrapText(true);
        addTextAreaLimiter(descriptionField, 255);

        //function button, "Clear" button and "Exit" button on an HBox pane
        Button createButton = new Button("");
        createButton.setOnAction(e -> {});
        createButton.setPrefSize(100, 20);

        Button clearResults = new Button("Clear");
        clearResults.setOnAction(e -> {});
        clearResults.setPrefSize(100, 20);

        Button exitButton = new Button("Exit");
        exitButton.setPrefSize(100, 20);
        //exitButton.setOnAction(e -> stage.close());

        HBox hBox1 = new HBox(5);
        hBox1.setAlignment(Pos.CENTER);
        hBox1.getChildren().addAll(createButton, clearResults, exitButton);

        //status for tracking events
        Label statusLabel = new Label(statusMessage);

        //Search for ID functionality defined in an HBox
        Label findTicketIDLabel = new Label("Find Ticket by ID#:");

        TextField searchField = new TextField();
        searchField.setPrefSize(120, 20);
        addTextFieldLimiter(searchField, 50);

        Button searchButton = new Button("Search");
        searchButton.setOnAction(e -> {});
        searchButton.setPrefSize(100, 20);

        Button clearIDSearch = new Button("Clear");
        clearIDSearch.setOnAction(e -> searchField.setText(""));
        clearIDSearch.setPrefSize(100, 20);

        HBox idSearchHbox = new HBox(5);
        idSearchHbox.setAlignment(Pos.CENTER);
        idSearchHbox.getChildren().addAll(findTicketIDLabel, searchField, searchButton, clearIDSearch);

        Label descriptionLabel = new Label("Ticket Description");
        findTicketIDLabel.setPadding(new Insets(-8, 20, -16, 20));

        //Creating a new VBox pane.
        VBox vBox = new VBox(20);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(25,50,20,50));
        vBox.getChildren().setAll(title, hBox1, statusLabel, hBox2, idSearchHbox, descriptionLabel, descriptionField);

        Scene scene = new Scene(vBox, 640, 480);

        return scene;
    }
    //Method for defining a max setting for the number of allowed characters on a TextField.
    default void addTextFieldLimiter(final TextField tf, final int maxLength) {
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

    //Method for defining a max setting for the number of allowed characters on a TextArea.
    default void addTextAreaLimiter(final TextArea ta, final int maxLength) {
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
}
