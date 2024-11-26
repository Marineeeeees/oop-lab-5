package com.example.mvc.controllers;

import com.example.mvc.models.Calculator;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;

/**
 * The CalculatorController class is responsible for handling user interactions
 * in the calculator application. It connects the user interface with the logic
 * implemented in the Calculator model. The controller manages arithmetic
 * operations, age category checks, and generation of multiplication tables.
 */
public class CalculatorController {

    @FXML
    private TextField input1;
    @FXML
    private TextField input2;
    @FXML
    private Button addButton;
    @FXML
    private Button subtractButton;
    @FXML
    private Button multiplyButton;
    @FXML
    private Button divideButton;
    @FXML
    private TextField ageInput;
    @FXML
    private Button checkAgeButton;
    @FXML
    private TextField multiplicationInput;
    @FXML
    private Button generateTableButton;

    private final Calculator model = new Calculator();

    /**
     * Initializes the controller by setting up event handlers for the buttons.
     */
    @FXML
    private void initialize() {
        addButton.setOnAction(e -> performCalculation("+"));
        subtractButton.setOnAction(e -> performCalculation("-"));
        multiplyButton.setOnAction(e -> performCalculation("*"));
        divideButton.setOnAction(e -> performCalculation("/"));
        checkAgeButton.setOnAction(e -> checkAge());
        generateTableButton.setOnAction(e -> generateMultiplicationTable());
    }

    /**
     * Performs the selected arithmetic operation on the two numbers entered by the user.
     * @param operator The operator for the arithmetic operation.
     */
    private void performCalculation(String operator) {
        try {
            double num1 = Double.parseDouble(input1.getText());
            double num2 = Double.parseDouble(input2.getText());
            double result = switch (operator) {
                case "+" -> model.add(num1, num2);
                case "-" -> model.subtract(num1, num2);
                case "*" -> model.multiply(num1, num2);
                case "/" -> model.divide(num1, num2);
                default -> 0;
            };
            showAlert(AlertType.INFORMATION, "Result: " + result);
        } catch (NumberFormatException e) {
            showAlert(AlertType.ERROR, "Enter numeric value!");
        } catch (ArithmeticException e) {
            showAlert(AlertType.ERROR, e.getMessage());
        }
    }

    /**
     * Checks the user's age category based on the input provided and shows the corresponding category.
     */
    private void checkAge() {
        try {
            int age = Integer.parseInt(ageInput.getText());
            String category = model.getAgeCategory(age);
            showAlert(AlertType.INFORMATION, "Age Category: " + category);
        } catch (NumberFormatException e) {
            showAlert(AlertType.ERROR, "Enter valid numeric value for age (0 < n)!");
        }
    }

    /**
     * Generates and displays the multiplication table for the number entered by the user.
     */
    private void generateMultiplicationTable() {
        try {
            int number = Integer.parseInt(multiplicationInput.getText());
            String table = model.generateMultiplicationTable(number);
            showAlert(AlertType.INFORMATION, table);
        } catch (NumberFormatException e) {
            showAlert(AlertType.ERROR, "Enter valid numeric value for multiplication table!");
        }
    }

    /**
     * Displays an alert with the specified message and type (information or error).
     * @param type The type of alert to display (e.g., INFORMATION, ERROR).
     * @param message The message to display in the alert.
     */
    private void showAlert(AlertType type, String message) {
        new Alert(type, message).showAndWait();
    }
}
