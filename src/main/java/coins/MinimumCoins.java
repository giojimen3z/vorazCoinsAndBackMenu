package coins;

import javax.swing.*;

public class MinimumCoins {
    public static void MinimumCoinsPossible() {

//se inicializan las variables es lo que se va a dividir con las monedas
        int Amount;//monto a convertir
        int Change = 0;//cambio este es el conversor
        int Coins[] = {1, 2, 3, 5, 10,20};//array que nos contiene el valor de las monedas
        int Counter = Coins.length - 1;// se iguala a coins la cantidad de monedas que hay lo cual es igual
        // Counter es el que recorre el ciclo while
        int CoinsCounter[] = {0, 0, 0,0, 0,0};
        int TotalCoins = 0;
        String Response = "El cambio se realizo de la siguiente forma: \n"; //muestra el resultado en pantalla

        //convierte el valor que se ingresa de estring a entero
        Amount = Integer.parseInt(JOptionPane.showInputDialog("Bienvenido \n En este programa podra cambiar su dinero obteniendo la menor cantidad de monedas posibles \n recuerde que cuenta con  monedas de la siguiente denominacion: \n" +

                "1 pesos \n" +
                "2 pesos \n" +
                "3 pesos \n" +
                "5 pesos \n" +
                "10 pesos \n" +
                "20 pesos \n" +
                "por favor ingrese la cantidad que desea convertir"));


        // no se puede convertir nada por eso se muestra el mensaje de error
        if (Amount <= 0) {

            JOptionPane.showMessageDialog(null, "Por favor revise la cifra  que acaba de ingresar  ya que o el monto a cambiar es 0 o es un valor negativo\n muchas gracias por su atencion");

        } else {
            while (Counter >= 0) { //aqui realiza la convercion y la realiza si el contador es mayor o igual a cero
                //el cambio  + el contador es menor o igual entonces al cambio se le agrega la moneda
                if (Change + Coins[Counter] <= Amount) {
                    Change = Change + Coins[Counter]; //le agrega la moneda que hya en ese momento

                    CoinsCounter[Counter] = CoinsCounter[Counter] + 1;

                } else { //cuando evalua el numero y este es mayor a la moneda que se esta evaluando anterior

                    Counter--; //disminuye de a uno por ende no se evalua la ultimaa si no la penultima y asi susecivamente
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