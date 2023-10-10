/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pproyecto;

import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class PProyecto {

    /**
     * @param args the command line arguments
     */ 
         public static void main(String[] args) {
             // TODO code application logic here
        while (true) {
            mostrarMenu();
            int opcion = obtenerOpcion();

            switch (opcion) {
                case 1:
                    realizarOperacion("+");
                    break;
                case 2:
                    realizarOperacion("-");
                    break;
                case 3:
                    realizarOperacion("*");
                    break;
                case 4:
                    realizarOperacion("/");
                    break;
                case 5:
                    verificarPrimo();
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, "Gracias");
                    //comando para salir del sistema
                    System.exit(0);
                default:
                    JOptionPane.showMessageDialog(null, "Opcion Invalida");
            }
        }
    }

    public static void mostrarMenu() {
        String mensaje = "Calculadora\n" +
                "1. Suma\n" +
                "2. Resta\n" +
                "3. Multiplicación\n" +
                "4. División\n" +
                "5. Verificar si el número es primo\n" +
                "6. Salir";
        JOptionPane.showMessageDialog(null, mensaje, "Anderson", JOptionPane.PLAIN_MESSAGE);
    }

    public static int obtenerOpcion() {
        String opcionStr = JOptionPane.showInputDialog("Escoja una operacion según la lista:");
        return Integer.parseInt(opcionStr);
    }
      // Aqui podemos agregar mas opcion y como el valor se obtiene no hay que modificar mucho en el menu para agregar otras opciones
    
    public static void realizarOperacion(String operador) {
        String num1Str = JOptionPane.showInputDialog("Digite el primer número:");
        String num2Str = JOptionPane.showInputDialog("Digite el segundo número:");
        double resultado = 0;
 //Esto para los decimales           
        num1Str = num1Str.replace(',', '.');
        num2Str = num2Str.replace(',', '.');
        double num1 = Double.parseDouble(num1Str);
        double num2 = Double.parseDouble(num2Str);
        switch (operador) {
            case "+":
                resultado = num1 + num2;
                break;
            case "-":
                resultado = num1 - num2;
                break;
            case "*":
                resultado = num1 * num2;
                break;
            case "/":
                // En la division se debe de tomar en cuenta los numero que no son divisibles por 0
                if (num2 != 0) {
                    resultado = num1 / num2;
                } else {
                    JOptionPane.showMessageDialog(null, "No se puede dividir por cero.");
                    return;
                }
                break;
        }

        JOptionPane.showMessageDialog(null, "Resultado de la operación: " + resultado );
    }

    public static void verificarPrimo() {
        int num = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un número para verificar si es primo:"));

        if (esPrimo(num)) {
            JOptionPane.showMessageDialog(null,  "El número " + num + " es un número primo.");
        } else {
            JOptionPane.showMessageDialog(null, "El número " + num + " no es un número primo.");
        }
    }

    public static boolean esPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }
    }
