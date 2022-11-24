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
    private TextField textField, passLen;
    @FXML
    private CheckBox hasNum, hasChar, hasLower, hasUpper;
    @FXML
    private static Label warningLabel;
    private Random random = new Random();
    private final String lettersLower = "abcdefghijklmnopqrstuvwxyz";
    private final String lettersUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final String specialChars = "!@#$%^&*()_?[]{}<>/|\";:',.`+-*/=";
    private final String numbers = "0123456789";

    public void up(ActionEvent e) {
        textField.setText(generatePassword(getChoices().toString()).toString());
    }

    public void copy(ActionEvent e) {
        StringSelection selection = new StringSelection(textField.getText());
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, selection);
        System.out.println(passLen.getText());
    }

    public StringBuilder generatePassword(String choices) {
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < 12; i++) {
            password.append(choices.charAt(random.nextInt(choices.length())));
        }
        return password;
    }

    public StringBuilder getChoices() {
        StringBuilder returnThis = new StringBuilder();
        if (hasNum.isSelected()) {
            returnThis.append(numbers);
        }
        if (hasChar.isSelected()) {
            returnThis.append(specialChars);
        }
        if (hasLower.isSelected()) {
            returnThis.append(lettersLower);
        }
        if (hasUpper.isSelected()) {
            returnThis.append(lettersUpper);
        }
        return returnThis;
    }

    public void shuffle(String string) {

    }

}