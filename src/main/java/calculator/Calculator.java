/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import javax.swing.JFrame;

/**
 *
 * @author Леонид
 */
public class Calculator {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Калькулятор");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(800, 600, 320, 240);
        frame.setVisible(true);
        CalcPanel panel = new CalcPanel();
        frame.add(panel);
        
    }
}
