package com.my.calendar.textfields;

import com.my.calendar.ChangeDate;
import com.my.calendar.controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TextViewField extends JTextField implements ChangeDate, ActionListener {


    public TextViewField(LocalDate date) {
        super(date.toString());
        addActionListener(this);
    }

    @Override
    public void updateDate() { }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this) {

            //TODO
            /*
            try move logic to updateDate method
            */

            String receiveDate = JOptionPane.showInputDialog("Input the date in the format \"yyyy-mm-dd\"",
                    Controller.getInstance().localDate.toString());

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date = LocalDate.parse(receiveDate, formatter);
            Controller.getInstance().setLocalDate(date);
            Controller.getInstance().notifyChangeDate();
            updateDate();
        }
    }
}