import backpack.FillBack;
import coins.MaximumCoins;
import coins.MinimumCoins;

import javax.swing.*;

public class main {

    public static void main(String[] args) {
        int counter = 0;
        int problem = 0;

        MaximumCoins maximumCoins = new MaximumCoins();
        MinimumCoins minimumCoins = new MinimumCoins();


        while (counter == 0) {


            problem = Integer.parseInt(JOptionPane.showInputDialog(null, "Bienvenido al programa por favor elija a que problema quiere ingresar: \n" +
                    "1.  Problema voraz que te entregara el maximo de monedas posibles deacuerdo al valor que le ingreses \n" +
                    "2.  Problema voraz que te entregara el minimo de monedas posibles deacuerdo al valor que le ingreses \n" +
                    "3.  Problema voraz Llenado de bolsas supermercado \n"));

            if (problem > 3 || problem < 1) {

                JOptionPane.showMessageDialog(null, "ha ingresado un valor incorrecto por favor  revise su respuesta ");
            }

            switch (problem) {

                case 1:
                    maximumCoins.MaximumCoinsPossible();
                    break;

                case 2:
                    MinimumCoins.MinimumCoinsPossible();
                    break;
                case 3:
                    FillBack.Fill();
                    break;
            }


            counter = Integer.parseInt(JOptionPane.showInputDialog(null, "para  continuar  probando aplicacion por favor  ingrese el  numero 0  de lo contrario  ingrese cualquier valor"));
        }

        JOptionPane.showMessageDialog(null, "Gracias por  hacer prueba de este aplicativo ");

    }
}


