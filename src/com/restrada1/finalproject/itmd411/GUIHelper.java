package com.restrada1.finalproject.itmd411;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
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

public interface GUIHelper extends Controller{

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

    default Text getTitleTextPane(String titleString){
        //Title
        Text title = new Text(titleString); //TODO Copy for delete as well
        title.setFont(Font.font("Courier New", FontWeight.BOLD, 18));
        return title;
    }

    default HBox getTicketLabels(){
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

        HBox hBox = new HBox(5);
        hBox.setPadding(new Insets(0,20,-8,20));
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().setAll(id, customerName, dateTime, isResolved, priority);

        return hBox;
    }

    default HBox getMutableTicketFields(){
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

        HBox hBox = new HBox(5);
        hBox.setAlignment(Pos.CENTER);
        hBox.setPadding(new Insets(-8,20,0,20));
        hBox.getChildren().setAll(idTextField, customerNameField, dateTimeField, isResolvedField, priorityField);

        return hBox;
    }

    default HBox getImmutableTicketFields(){
        //Ticket object parameter textboxes (HBox 3)
        TextField idTextField = new TextField();
        idTextField.setPrefSize(100,20);
        addTextFieldLimiter(idTextField, 50);
        idTextField.setEditable(false);
        idTextField.setDisable(true);

        TextField customerNameField = new TextField();
        customerNameField.setPrefSize(100, 20);
        addTextFieldLimiter(customerNameField, 50);
        customerNameField.setEditable(false);
        customerNameField.setDisable(true);

        TextField dateTimeField = new TextField();
        dateTimeField.setPrefSize(100, 20);
        addTextFieldLimiter(dateTimeField, 25);
        dateTimeField.setEditable(false);
        dateTimeField.setDisable(true);

        TextField isResolvedField = new TextField();
        isResolvedField.setPrefSize(100, 20);
        addTextFieldLimiter(isResolvedField, 1);
        isResolvedField.setEditable(false);
        isResolvedField.setDisable(true);

        TextField priorityField = new TextField();
        priorityField.setPrefSize(100, 20);
        addTextFieldLimiter(priorityField, 1);
        priorityField.setEditable(false);
        priorityField.setDisable(true);

        HBox hBox = new HBox(5);
        hBox.setAlignment(Pos.CENTER);
        hBox.setPadding(new Insets(-8,20,0,20));
        hBox.getChildren().setAll(idTextField, customerNameField, dateTimeField, isResolvedField, priorityField);
        getReadOnlyFields(idTextField, customerNameField, dateTimeField, isResolvedField, priorityField);

        return hBox;
    }

    default TextArea getMutableDescriptionTextArea(){
        TextArea descriptionField = new TextArea();
        descriptionField.setPrefSize(400, 120);
        descriptionField.setWrapText(true);
        addTextAreaLimiter(descriptionField, 255);
        return descriptionField;
    }

    default TextArea getImmutableDescriptionTextArea(){
        TextArea descriptionField = new TextArea();
        descriptionField.setPrefSize(400, 120);
        descriptionField.setWrapText(true);
        addTextAreaLimiter(descriptionField, 255);
        descriptionField.setEditable(false);
        descriptionField.setDisable(true);
        return descriptionField;
    }

    default HBox getControllerButtons(String action, Stage stage){
        //function button, "Clear" button and "Exit" button on an HBox pane
        Button createButton = new Button(action);
        createButton.setOnAction(e -> {});
        createButton.setPrefSize(100, 20);

        Button clearResults = new Button("Clear");
        clearResults.setOnAction(e -> {});
        clearResults.setPrefSize(100, 20);

        Button exitButton = new Button("Exit");
        exitButton.setPrefSize(100, 20);
        exitButton.setOnAction(e -> stage.close());

        HBox hBox = new HBox(5);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(createButton, clearResults, exitButton);

        return hBox;
    }

    default HBox getSearchHBox(){

        Label label = new Label("Find Ticket by ID#:");

        TextField searchField = new TextField();
        searchField.setPrefSize(120, 20);
        addTextFieldLimiter(searchField, 50);

        Button searchButton = new Button("Search");
        searchButton.setOnAction(e -> {});
        searchButton.setPrefSize(100, 20);

        Button clearResults = new Button("Clear");
        clearResults.setOnAction(e -> searchField.setText(""));
        clearResults.setPrefSize(100, 20);

        HBox hBox = new HBox(5);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(label, searchField, searchButton, clearResults);

        return hBox;
    }


    default Label getDescriptionLabel(){
        Label label = new Label("Ticket Description");
        label.setPadding(new Insets(-8, 20, -16, 20));
        return label;
    }

    default VBox getNewPopupVBox(Node... elements){
        //Creating a new VBox pane.
        VBox vBox = new VBox(20);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(25,50,20,50));
        vBox.getChildren().setAll(elements);
        return vBox;
    }
}
