package com.clientes;

import com.clases.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);
    static OperacionesMenu operation = new OperacionesMenu(in);

    public static void main(String[] args) {
        String menu =
                        "         * 1 Agregar cliente\n" +
                        "         * 2 Editar cliente\n" +
                        "         * 3 Eliminar cliente\n" +
                        "         * 4 Agregar productos\n" +
                        "         * 5 Consultar clientes con documento y tipo de documento \n" +
                        "         * 0 salir de la aplicacion";

        ArrayList<Clientes> customerList = new ArrayList<>();
        ArrayList<Producto> productList = new ArrayList<>();
        Integer opMenu = new Integer(0);

        do {

            System.out.println(menu);
            opMenu = in.nextInt();
            switch (opMenu.toString()) {
                case "1":
                    customerList.add(operation.addCustomer(productList));
                    break;
                case "2":
                    operation.changeTheData(operation.lookFor(operation.showClients(customerList),customerList),customerList,productList);
                    break;
                case "3":
                    customerList.remove(operation.lookFor(operation.showClients(customerList),customerList));
                    break;
                case "4":
                    operation.additionalProduct(customerList,productList);
                    break;
                case "5":
                    operation.showCustomerData(customerList);
                    break;
                case "0":
                    System.out.println("Muchas gracias por usar nuestra app, hasta luego");
                    break;
                default:
                    System.out.println("El valor ingresado no es una opcion de menu");
                    break;
            }
        } while (!opMenu.toString().equals("0"));
        in.close();
    }
}
