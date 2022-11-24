package com.example.passwordgenerator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
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
        textField.setText(generatePassword(getChoices()).toString());
    }

    public void copy(ActionEvent e) {
        StringSelection selection = new StringSelection(textField.getText());
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, selection);
    }

    public StringBuilder generatePassword(String choices) {
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < 12; i++) {
            password.append(choices.charAt(random.nextInt(choices.length())));
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