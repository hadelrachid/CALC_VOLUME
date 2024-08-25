/* ***************************************************************
 * Arquivo:     Cube.java
 * Propósito:   Essa classe define Cube para validar as dimensões
 *              (base, altura e comprimento) e calcular o volume.
 * Autor:       Hadel Rachid Daher Junior
 * Criado:      25/08/2024
 * Copyright:   (c) hadelrachid 2024
 * *************************************************************** */

package org.volume.calc.cube;

// Definição da classe Cube para o cálculo de Volume
public class Cube {

    private double base;        // Base
    private double height;      // Altura
    private double length;      // Comprimento
    private double volume;      // Volume

    // Método Construtor
    public Cube(double base, double height, double length) {

        // Tratamento de validação dentro do construtor

        // Se base for um número positivo, base será atribuida ao valor this.base, senão este será 0.0
        this.base = base >= 0.0 ? base : 0.0;   
        // Se height for um número positivo, height será atribuida ao valor this.height, senão este será 0.0
        this.height = height >= 0.0 ? height : 0.0;
        // Se length for um número positivo, length será atribuida ao valor this.length, senão este será 0.0
        this.length = length >= 0.0 ? length : 0.0;

        // Chama o método para calcuar o volume do cubo
        this.volume = this.base * this.height * this.length;

    } // Fim do método Construtor

    // Método volume que calcula o volume do cubo
    public double getVolume(){
        return volume;
    } // Fim do método volume
    
} // Fim da classe Cube
