package backpack;

import javax.swing.*;

public class FillBack {

    public static void Fill() {

        Element elements[];
        Element totalElements[];
        Element auxElementBack[];
        BackPack backPacks[];
        Element auxElements[];
        int newLengthAuxElements;
        int deleteElements;
        int backPacksTotal = 50;
        int backPackCounter = 0;
        int backResult = 0;
        int ElementWeight = 0;
        int ElementBenefit = 0;
        int content = 1;

        JOptionPane.showMessageDialog(null, "Bienvenido al supermercado ");
        int BackWeight = Integer.parseInt(JOptionPane.showInputDialog(null, "por favor ingrese el peso maximo de cada bolsa"));
        int BackElements = Integer.parseInt(JOptionPane.showInputDialog(null, "por favor ingrese la cantidad  de elementos  que llevara el dia de hoy"));
        String ChainsOfElement = "";


        elements = new Element[BackElements];

        for (int i = 0; i < elements.length; i++) {
            int element = i + 1;

            ElementWeight = Integer.parseInt(JOptionPane.showInputDialog(null, "por favor ingrese el peso del elemento  # " + element));
            ElementBenefit = Integer.parseInt(JOptionPane.showInputDialog(null, "por favor ingrese el precio del elemento  # " + element));
            elements[i] = new Element(ElementWeight, ElementBenefit);
        }

        totalElements = new Element[BackElements];
        for (int i = 0; i < elements.length; i++) {

            totalElements[i] = elements[i]; //elimina el elemento

        }

        backPacks = new BackPack[backPacksTotal];
        auxElements = elements;

        while (content > 0) {

            content = 0;
            deleteElements = 0;

            BackPack BackPackBase = null;
            BackPack BackPackOptimized = null;
            BackPackBase = new BackPack(BackWeight, auxElements.length);
            BackPackOptimized = new BackPack(BackWeight, auxElements.length);


            FillBackpack(BackPackBase, auxElements, false, BackPackOptimized);

            backPacks[backPackCounter] = BackPackOptimized;
            backPackCounter++;

            auxElementBack = BackPackOptimized.getElements();
            int j = 0;
            for (int i = 0; i < elements.length; i++) {
                if (elements[i] != null && elements[i].equals(auxElementBack[j])) {
                    elements[i] = null; //elimina el elemento
                    j++;
                }
            }

            for (int i = 0; i < elements.length; i++) {

                if (elements[i] == null) {
                    deleteElements++;
                }
            }
            if (auxElements.length > deleteElements) {

                newLengthAuxElements = auxElements.length - deleteElements;

            } else {

                newLengthAuxElements = auxElements.length - 1;

            }


            auxElements = null;
            auxElements = new Element[newLengthAuxElements];

            if (newLengthAuxElements > 0) {
                int k = 0;
                for (int i = 0; i < elements.length; i++) {
                    if (elements[i] != null && elements[i].getBenefit() > 0) {
                        auxElements[k] = elements[i];
                        content = 1;
                        k++;
                    }

                }
            }
        }
        //esto va por fuera  del  while
        for (int i = 0; i < totalElements.length; i++) {
            int element2 = i + 1;

            ChainsOfElement = ChainsOfElement + "El elemento #" + element2 + " Contiene:\n Peso: " + totalElements[i].getWeight() + "\n Beneficio: " + totalElements[i].getBenefit() + "\n";

        }

        System.out.println(ChainsOfElement);

        for (int i = 0; i < backPackCounter; i++) {
            int element2 = i + 1;

            System.out.println(" la bolsa #" + element2 + " contiene los siguiente elementos: \n" + backPacks[i]);

        }
        backResult = backPacksTotal - backPackCounter;
        System.out.println("La tienda inicio con un total de " + backPacksTotal + " bolsas, despues de su compra la tienda culmino con " + backResult + " bolsas \n " +
                "Gracias por su compra  y vuelva pronto");

    }

    public static void FillBackpack(BackPack BackPackBase, Element[] elements, boolean full, BackPack BackPackOptimized) {

        //si esta llena
        if (full) {
            //compruebo si tiene mas beneficio que otra
            if (BackPackBase.getBenefit() > BackPackOptimized.getBenefit()) {

                Element[] elementsBase = BackPackBase.getElements();
                BackPackOptimized.clear();

                //metemos los elementos
                for (Element e : elementsBase) {
                    if (e != null) {
                        BackPackOptimized.AddElement(e);
                    }

                }

            }

        } else {
            //Recorre los elementos
            if (elements.length == 1) {
                Element auxElements2[];
                auxElements2 = new Element[elements.length + 1];
                auxElements2[0] = elements[0];
                auxElements2[1] = new Element(100, 10);
                for (int i = 0; i < auxElements2.length; i++) {
                    //si existe el elemento
                    if (!BackPackBase.ElementExist(auxElements2[i])) {
                        //Si el peso de la mochila se supera, indicamos que esta llena
                        if (BackPackBase.getMaxWeight() >= BackPackBase.getWeight() + auxElements2[i].getWeight()) {
                            BackPackBase.AddElement(auxElements2[i]); //añadimos
                            FillBackpack(BackPackBase, auxElements2, false, BackPackOptimized);
                            BackPackBase.DeleteElement(auxElements2[i]); // lo eliminamos
                        } else {
                            FillBackpack(BackPackBase, auxElements2, true, BackPackOptimized);
                        }
                    }

                }
            } else {
                Element auxElements3[];
                auxElements3 = new Element[elements.length + 1];

                for (int i = 0; i < auxElements3.length; i++) {

                    if (i < elements.length) {
                        auxElements3[i] = elements[i];
                    } else {
                        auxElements3[i] = new Element(100, 10);
                    }
                }

                for (int i = 0; i < auxElements3.length; i++) {
                    //si existe el elemento
                    if (!BackPackBase.ElementExist(auxElements3[i])) {
                        //Si el peso de la mochila se supera, indicamos que esta llena
                        if (BackPackBase.getMaxWeight() >= BackPackBase.getWeight() + auxElements3[i].getWeight()) {
                            BackPackBase.AddElement(auxElements3[i]); //añadimos
                            FillBackpack(BackPackBase, auxElements3, false, BackPackOptimized);
                            BackPackBase.DeleteElement(auxElements3[i]); // lo eliminamos
                        } else {
                            FillBackpack(BackPackBase, auxElements3, true, BackPackOptimized);
                        }
                    }

                }

            }

        }

    }
}
