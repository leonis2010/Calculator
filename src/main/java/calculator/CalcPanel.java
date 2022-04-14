/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Леонид
 */
public class CalcPanel extends JPanel {

    private final JPanel panel;
    private boolean start;
    private final JButton display;
    private String lastCommand;
    private double result;

    public CalcPanel() {
        super();
        start = true;
        lastCommand = "=";
        result = 0;
        setLayout(new BorderLayout());
        display = new JButton("0");// кнопка ввиде дисплея
        display.setEnabled(false);//неактивная(нельзя нажимать)
        add(display, BorderLayout.NORTH);//добавляем в верхней части нашей рамки (frame)

        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));//4 строки, 4 столбца

        InsertAction insert = new InsertAction();
        CommandAction command = new CommandAction();

        addButton("7", insert);
        addButton("8", insert);
        addButton("9", insert);

        addButton("/", command);
        addButton("4", insert);
        addButton("5", insert);
        addButton("6", insert);

        addButton("*", command);
        addButton("1", insert);
        addButton("2", insert);
        addButton("3", insert);

        addButton("-", command);
        addButton("0", insert);
        addButton(".", insert);

        addButton("=", command);
        addButton("+", command);

        add(panel, BorderLayout.CENTER);//добавляем эту панель в нашу основную панель
    }

    private void addButton(String label, ActionListener listener) {
        JButton button = new JButton(label);
        button.addActionListener(listener);//на кнопку вешаем обработчик событий
        panel.add(button);
    }
    
    
    //Сделаем 2 обработчика событий
    
    

    
    private class InsertAction implements ActionListener {//Вставка символов и цифр

        @Override
        public void actionPerformed(ActionEvent ae) {
            String input = ae.getActionCommand();//считать цифру
            if (start) {
                display.setText("");//если вводится первое число, то 0 заменяется на ""
                start = false;
            }
            if (input.equals(".") && display.getText() == "") {//если точка и пусто, показывать "0."
                display.setText("0" + input);
            } else if (!input.equals(".") || !display.getText().contains(".")) {//либо не точка, либо она еще не содержится
                display.setText(display.getText() + input);
            }
        }
    }

    
    
   
    private class CommandAction implements ActionListener { //Вставка действий (+ - = /)

        @Override
        public void actionPerformed(ActionEvent ae) {
            String command = ae.getActionCommand();//считать 

            if (start) {
                lastCommand = command;
            } else {
                calc(Double.parseDouble(display.getText()));// парсит String в Double
                lastCommand = command;
                start = true;
            }

        }

        
        
        
        private void calc(double x) {
            switch (lastCommand) {
                case "+":
                    result += x;
                    break;
                case "-":
                    result -= x;
                    break;
                case "*":
                    result *= x;
                    break;
                case "/":
                    result /= x;
                    break;
                case "=":
                    result = x;
                    break;
                default:
                    break;
            }
            display.setText("" + result);
        }
    }

}
