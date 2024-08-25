/* ***************************************************************
 * Arquivo:     NumberCheck.java
 * Propósito:   Essa classe possui um método static para verificar
 *              se o texto é um número.
 * Autor:       Hadel Rachid Daher Junior
 * Criado:      25/08/2024
 * Copyright:   (c) hadelrachid 2024
 * *************************************************************** */

package org.volume.calc.cube;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

// Definição da classe NumberCheck que verifica se o campo de texto (JTextField)
// contém apenas números.
public class NumberCheck {

    public static void validation(JTextField  field1, JTextField field2, JTextField field3) {

        String input1 = field1.getText();
        String input2 = field2.getText();
        String input3 = field3.getText();

        // Substitui a vírgual por ponto
        input1 = input1.replace(',', '.');
        input2 = input2.replace(',', '.');
        input3 = input3.replace(',', '.');

        // Se não for verdadeiro que input é um número, mostre a mensagem de Erro
        if (!isNumeric(input1) || !isNumeric(input3) || !isNumeric(input3)) {
            JOptionPane.showMessageDialog(null, "Por favor, digite somente números.", "Erro", JOptionPane.ERROR_MESSAGE);
            field1.setText("0.0"); // Configura o texto para "0.0"
            field2.setText("0.0"); // Configura o texto para "0.0"
            field3.setText("0.0"); // Configura o texto para "0.0"
        }
        else{ // Caso contrário
            field1.setText(input1); // Configura o texto novamente para field1, caso haja vírgula
            field2.setText(input2); // Configura o texto novamente para field2, , caso haja vírgula
            field3.setText(input3); // Configura o texto novamente para field3, , caso haja vírgula
        }

    }

    // Método que verifica se uma string é numérica
    private static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

} // Fim da classe NumberCheck
