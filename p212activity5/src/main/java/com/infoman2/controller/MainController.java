package com.infoman2.controller;

import com.infoman2.DatabaseConnection;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MainController {
    @FXML
    private TextField firstName;
    @FXML
    private TextField middleName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField phoneNumber;
    @FXML
    private TextField email;


    @FXML
    private RadioButton gender;


    private DatabaseConnection connection;

    public void initialize() {
        connection = new DatabaseConnection();
    }

    @FXML
    private void save() throws SQLException {
        String sql = "INSERT INTO students(first_name, middle_name, last_name, email, phone_number, gender) VALUES(?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = connection.connection.prepareStatement(sql);

        stmt.setString(1, firstName.getText());
        stmt.setString(2, middleName.getText());
        stmt.setString(3, lastName.getText());
        stmt.setString(4, email.getText());
        stmt.setString(5, phoneNumber.getText());

        String gdr;
        if (gender.isSelected()) {
            gdr = "Male";
        } else {
            gdr = "Female";
        }
        stmt.setString(6, gdr);

        stmt.execute();
    }

}
