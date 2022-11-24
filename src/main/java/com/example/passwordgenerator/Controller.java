package com.example.passwordgenerator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import java.util.Random;

public class Controller {

    @FXML
    private TextField textField;
    @FXML
    private CheckBox hasNum, hasChar, hasLower, hasUpper;
    private Random random = new Random();
    private String lettersLower = "abcdefghijklmnopqrstuvwxyz";
    private String lettersUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String numbers = "0123456789";
    private String specialChars = "!@#$%^&*()_?[]{}<>/|\";:',.`";

    public void up(ActionEvent e) {
        textField.setText(generatePassword(getChoices()));
    }

    public void copy(ActionEvent e) {

    }

    public String generatePassword(String choices) {
        String password = "";
        for (int i = 0; i < 12; i++) {
            password += choices.charAt(random.nextInt(choices.length()));
        }
        return password;
    }

    public String getChoices() {
        String returnThis = "";
        if (hasNum.isSelected()) {
            returnThis += numbers;
        }
        if (hasChar.isSelected()) {
            returnThis += specialChars;
        }
        if (hasLower.isSelected()) {
            returnThis += lettersLower;
        }
        if (hasUpper.isSelected()) {
            returnThis += lettersUpper;
        }
        return returnThis;
    }

    public void shuffle(String string) {

    }

}