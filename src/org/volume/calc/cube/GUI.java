/* ***************************************************************
 * Arquivo:     GUI.java
 * Propósito:   Essa classe define uma Interface Gráfica para o
 *              o usuário interagir e inserir dados.
 * Autor:       Hadel Rachid Daher Junior
 * Criado:      25/08/2024
 * Copyright:   (c) hadelrachid 2024
 * *************************************************************** */

package org.volume.calc.cube;

// Pacote AWT                  
import java.awt.Insets;              // É utilizada para definir margens ou preenchimentos internos de componentes gráficos
import java.awt.GridBagConstraints;  // Para definir como os componentes são posicionados dentro de um contêiner
import java.awt.GridBagLayout;       // Gerenciador de layout flexível que organiza os componentes em uma grade de células

// Pacote swing
import javax.swing.JLabel;           // importa uma classe JLabel para rótulos de texto
import javax.swing.JOptionPane;      // importa uma classe JOptionPane para mostrar Janelas de diálogo
import javax.swing.JFrame;           // importa uma classe JFrame (janela)
import javax.swing.JTextField;       // importa uma classe JTextField (campo de texto)
import javax.swing.JButton;          // importa uma classe JButton (botão)

// Definição da classe GUI (Inteface Gráfica de Usuário)
public class GUI {

    // Propriedades da classe GUI
    private JFrame frame;           // Um frame (janela)
    private JTextField baseField;   // Um campo de texto para a base
    private JTextField heightField; // Um campo de texto para a altura
    private JTextField lengthField; // Um campo de texto para o comprimento
    private JButton calcButton;     // Um botão para o evento calcular o volume

    // Método construtor de GUI
    public GUI() {

        /* *** Configura o frame (janela) *** */

        // Instancia uma JFrame com um Título na barra de título
        frame = new JFrame("Cálculo do Volume: ");

        // Configura as dimensões da Janela
        frame.setSize(400,300);

        // Configura caso a janela seja fechada no botão "X", encerra o objeto Frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Configura um layout para adicionar os campos de texto e botão 
        frame.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        // Espaçamento entre os componentes
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        /* *** Criar e adicionar os componentes no Frame *** */
       
        /* 1) ----------------------------------------------------------------- */
        // Adicona um rótulo de texto na posição (0, 0)
        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(new JLabel("Base (m): "), gbc); 

        // Instancia um JTextField na referência baseField
        gbc.gridx = 1;
        baseField = new JTextField(10); 

        // Adiciona baseField na posição (1, 0)
        frame.add(baseField, gbc);
        /* -------------------------------------------------------------------- */

        /* 2) ----------------------------------------------------------------- */
         // Adicona um rótulo de texto na posição (0, 1)
         gbc.gridx = 0;
         gbc.gridy = 1;
         frame.add(new JLabel("Altura (m):"), gbc);

         // Instancia um JTextField na referência heightField
         gbc.gridx = 1;
         heightField = new JTextField(10);

         // Adiciona heightField na posição (1, 1)
         frame.add(heightField, gbc);

        /* -------------------------------------------------------------------- */

        /* 3) ----------------------------------------------------------------- */
         // Adicona um rótulo de texto na posição (0, 2)
         gbc.gridx = 0;
         gbc.gridy = 2;
         frame.add(new JLabel("Comprimento (m):"), gbc);

         // Instancia um JTextField na referência lengthField
         gbc.gridx = 1;
         lengthField = new JTextField();

         // Adiciona lengthField na posição (1, 2)
         frame.add(lengthField, gbc);

        /* -------------------------------------------------------------------- */

        /* 4) ----------------------------------------------------------------- */
        // Instancia um JButton na referência calcButton
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        calcButton = new JButton("Calcular Volume");

        // Adiciona calcButton na posição (0, 3) centralizado, ocupando 2 celulas (merge)
        frame.add(calcButton, gbc);
        /* -------------------------------------------------------------------- */

        // Inclui o Método privado para quando o botão for clicado
        setButtonClickListener();

    } // Fim do método construtor

    // Método para que o Frame se torne visível
    public void show(){
        frame.setVisible(true);
    } // Fim do método show

    // Método privado para quando o botão for clicado
    private void setButtonClickListener() {

        // Adiciona uma ação Listener (ouvinte) para o calcButton
        calcButton.addActionListener(e -> {

            double baseText = 0.0;
            double heightText = 0.0;
            double lengthText = 0.0;

            // Condição para verificar se os campos estão preenchidos.
            // Exemplo: Não é verdade que baseField, heightField e lengthField
            // estão vazios. Se for verdadeiro, converta todos os campos para
            // double e atribua respectivamente às variáveis: baseText, heightText e
            // lengthText
            if(!baseField.getText().isEmpty() && 
                !heightField.getText().isEmpty() && 
                !lengthField.getText().isEmpty()) 
            {
                // Verifica se dentro dos JTextFields são apenas números
                NumberCheck.validation(lengthField, heightField, baseField);

                // Converte os campos de textos (String) em tipo double,
                // mas devem ser pelo menos números
                baseText = Double.parseDouble(baseField.getText());
                heightText = Double.parseDouble(heightField.getText());
                lengthText = Double.parseDouble(lengthField.getText());
            }

            // Instancia cube para validação e cálculo do volume
            Cube cube = new Cube(baseText, heightText, lengthText);

            // Mostra o resultado do volume numa janela de diálogo.
            JOptionPane.showMessageDialog(null, "O volume é: " + cube.getVolume());

            // Limpa todos os campos de texto
            baseField.setText("");
            heightField.setText("");
            lengthField.setText("");
        });


    } // Fim do método setButtonClickListener
    
} // Fim da classe GUI
