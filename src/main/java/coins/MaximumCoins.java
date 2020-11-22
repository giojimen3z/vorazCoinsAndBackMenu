package coins;

import javax.swing.*;

public class MaximumCoins {


public static void MaximumCoinsPossible(){

    int Amount;
    int Change = 0;
    int Coins[] = {20, 18, 10,5, 2};
    int Counter = Coins.length - 1;
    int CoinsCounter[] = {0, 0, 0,0, 0};
    int TotalCoins = 0;
    String Response = "El cambio se realizo de la siguiente forma: \n";

    Amount = Integer.parseInt(JOptionPane.showInputDialog("Bienvenido \n En este pograma podras cambiar tu dinero  obteniendo la mayor cantidad de modenas posibles \n recuerda que cuento con  monedas de la siguiente denominacion: \n" +
            "2 pesos \n" +
            "5 pesos \n" +
            "10 pesos \n" +
            "18 pesos \n" +
            "20 pesos \n" +
            "por favor ingresa la cantidad que desea convertir"));

    if (Amount <= 0) {

        JOptionPane.showMessageDialog(null, "Por favor revise la cifra  que acaba de ingresar  ya que o el monto a cambir es 0 o es un valor negativo\n muchas raciaspor su atencion");

    } else {

        while (Counter >= 0) {

            if (Change + Coins[Counter] <= Amount) {
                Change = Change + Coins[Counter];

                CoinsCounter[Counter] = CoinsCounter[Counter] + 1;

                if (Amount - Change == 5){
                    Counter--;
                }

            }else {
                Counter--;
            }


        }

        for (int i = CoinsCounter.length - 1; i >= 0; i--) {

            if (CoinsCounter[i] != 0) {
                Response = Response + CoinsCounter[i]+ " Monedas de "+Coins[i] + " Pesos \n";
                TotalCoins = TotalCoins +   CoinsCounter[i];
            } else {
                Response = Response + "";
            }


        }

        Response =  Response + "El total de monedas utilizadas fue: " + TotalCoins;

        JOptionPane.showMessageDialog(null, Response);

    }
}

}
