package com.clientes;

import com.clases.Clientes;
import com.clases.Empresas;
import com.clases.Personas;
import com.clases.Producto;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final int TOPLIMIT = 999999;
    static Scanner in = new Scanner(System.in);

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
                    customerList.add(addCustomer(productList));
                    break;
                case "2":
                    changeTheData(lookFor(showClients(customerList),customerList),customerList,productList);
                    break;
                case "3":
                    customerList.remove(lookFor(showClients(customerList),customerList));
                    break;
                case "4":
                    additionalProduct(customerList,productList);
                    break;
                case "5":
                    showCustomerData(customerList);
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

    public static Producto addProduct(){
        Producto product = new Producto();
        product.setIdProducto(String.valueOf(Math.random()*TOPLIMIT));
        System.out.println("El código del producto que estas creando será: "+product.getIdProducto());
        String saltoDeLinea = in.nextLine();
        System.out.print("Nombre: ");
        product.setNombre(in.nextLine());
        System.out.print("Características: ");
        product.setCarateristicas(in.nextLine());
        System.out.print("Condiciones: ");
        product.setCondiciones(in.nextLine());
        return product;
    }

    public static char chooseTypeOfCustomer (){
        boolean follow = true;
        char data =' ';
        while (follow) {
            System.out.print("Escoje la naturaleza del cliente (N=Natural, J=Juridica): ");
            data = Character.toUpperCase(in.next().charAt(0));
            if (data=='N' || data=='J') { follow = false; }
            }
        return data;
    }

    public static Clientes enterCustomerData (char tipoCliente, ArrayList<Producto>productList){
        if (tipoCliente=='N') {
            Personas natural = new Personas();
            System.out.print("** Introduzca los datos de la Persona Natural ** \n");
            String saltoDeLinea = in.nextLine();
            System.out.print("Nombre:");
            natural.setNombre(in.nextLine());
            System.out.print("Cédula: ");
            natural.setCedula(in.nextLine());
            System.out.print("Número movil: ");
            natural.setCelular(in.nextLine());
            System.out.print("Número fijo: ");
            natural.setTelefono(in.nextLine());
            System.out.print("Dirección: ");
            natural.setDireccion(in.nextLine());
            boolean goOn = true;
            while (goOn){
                System.out.println("Deseas agregar un producto a este cliente?(S/N)");
                char choose = Character.toUpperCase(in.next().charAt(0));
                if (choose=='N'){goOn = false;}
                else {
                    if (choose == 'S') {
                        boolean pursue = true;
                        while (pursue){
                            System.out.println("** Introduzca la información del Producto **");
                            productList.add(addProduct());
                            boolean validation = true;
                            char option = ' ';
                            while (validation){
                                System.out.println("Deseas agregar más productos? (S/N)");
                                option = Character.toUpperCase(in.next().charAt(0));
                                if (option=='S'|| option=='N') {validation=false;}
                            }
                            if (option=='N'){pursue=false;}
                        }
                        natural.setProductos(productList);
                        goOn = false;
                    }
                }
            }
            return natural;
        } else{
            Empresas juridica = new Empresas();
            System.out.println("** Introduzca los datos de la Empresa **");
            String saltoDeLinea = in.nextLine();
            System.out.print("Nombre: ");
            juridica.setNombre(in.nextLine());
            System.out.print("Tipo de Documento: ");
            juridica.setTipDoc(in.nextLine());
            System.out.print("Número de Documento: ");
            juridica.setDocumento(in.nextLine());
            System.out.print("Nombre del representante legal: ");
            juridica.setRepresentante(in.nextLine());
            System.out.print("Número fijo: ");
            juridica.setTelefono(in.nextLine());
            System.out.print("Dirección: ");
            juridica.setDireccion(in.nextLine());
            boolean goOn = true;
            while (goOn){
                System.out.println("Deseas agregar un producto a este cliente?(S/N)");
                char choose = Character.toUpperCase(in.next().charAt(0));
                if (choose=='N'){goOn = false;}
                else {
                    if (choose == 'S') {
                        boolean pursue = true;
                        while (pursue){
                            System.out.println("** Introduzca la información del Producto **");
                            productList.add(addProduct());
                            boolean validation = true;
                            char option = ' ';
                            while (validation){
                                System.out.println("Deseas agregar más productos? (S/N)");
                                option = Character.toUpperCase(in.next().charAt(0));
                                if (option=='S'|| option=='N') {validation=false;}
                            }
                            if (option=='N'){pursue=false;}
                        }
                        juridica.setProductos(productList);
                        goOn = false;
                    }
                }
            }
            return juridica;
        }
    }

    public static Clientes addCustomer(ArrayList<Producto> productList){
        System.out.println("*** Estas en la opción agregar Clientes ***");
        return enterCustomerData(chooseTypeOfCustomer(),productList);
    }

    public static String showClients (ArrayList<Clientes> ids){
        String identifier = null;
        List<String> naturalList = new ArrayList<>();
        List<String> juridicaList = new ArrayList<>();

        if (ids==null){
            System.out.println("No existen clientes para editar");
        }else{
            for (Clientes idCustomers:ids) {
                if (idCustomers instanceof Personas) {
                    naturalList.add(((Personas) idCustomers).getCedula());
                } else {
                    if (idCustomers instanceof Empresas) {
                        juridicaList.add(((Empresas) idCustomers).getDocumento());
                    }
                }
            }

            if(naturalList!=null){
                System.out.println("** Listado de cédulas de las Personas naturales **");
                for (int i =0; i< naturalList.size(); i++) {
                    System.out.println("Cédula: "+naturalList.get(i));
                }
            }

            if(juridicaList!=null){
                System.out.println("** Listado de Nro. Documento de las Personas Juridicas **");
                for (int j=0;j< juridicaList.size();j++){
                    System.out.println("Nro. Documento: "+juridicaList.get(j));
                }
            }

            String saltoDeLinea = in.nextLine();
            boolean moveAlong = true;
            while (moveAlong) {
                System.out.println("Escoje un número de cédula o documento según sea el caso para poder editarlo");
                identifier = in.nextLine();
                if (naturalList.contains(identifier)) {
                    moveAlong = false;
                } else {
                    if (juridicaList.contains(identifier)) {
                        moveAlong = false;
                    }
                }
                System.out.println("El número de documento o cédula que has introducido es incorrecto");
            }
        }
        return identifier;
    }

    public static int lookFor (String id, ArrayList<Clientes> customersRegisters){
        int index = 0;
        for (int i=0; i<customersRegisters.size();i++) {
            if (customersRegisters.get(i) instanceof Personas) {
                if (((Personas) customersRegisters.get(i)).getCedula().equals(id)) {
                    index = i;
                } else{
                    if (customersRegisters.get(i) instanceof Empresas) {
                        if (((Empresas) customersRegisters.get(i)).getDocumento().equals(id)) {
                            index = i;
                        }
                    }
                }
            }
        }
        return index;
    }

    public static void changeTheData (int index, ArrayList<Clientes> clientRegister, ArrayList<Producto> products){
        System.out.println("Esta opción editará los datos del cliente.");
        System.out.println("Deseas proseguir? (S/N)");
        char response = Character.toUpperCase(in.next().charAt(0));
        if (response == 'S') {
            if (clientRegister.get(index) instanceof Personas) {
                String saltoDeLinea = in.nextLine();
                System.out.print("Nombre: ");
                clientRegister.get(index).setNombre(in.nextLine());
                System.out.print("Cédula: ");
                ((Personas) clientRegister.get(index)).setCedula(in.nextLine());
                System.out.print("Número movil: ");
                ((Personas) clientRegister.get(index)).setCelular(in.nextLine());
                System.out.print("Número fijo: ");
                clientRegister.get(index).setTelefono(in.nextLine());
                System.out.print("Dirección: ");
                clientRegister.get(index).setDireccion(in.nextLine());
                boolean goOn = true;
                while (goOn){
                    System.out.println("Deseas modificar el/los producto(s) asociados a este cliente?(S/N)");
                    char choose = Character.toUpperCase(in.next().charAt(0));
                    if (choose=='N'){goOn = false;}
                    else {
                        if (choose == 'S') {
                            boolean pursue = true;
                            while (pursue){
                                System.out.println("** Introduzca la información del Producto **");
                                products.add(addProduct());
                                boolean validation = true;
                                char option = ' ';
                                while (validation){
                                    System.out.println("Deseas agregar más productos? (S/N)");
                                    option = Character.toUpperCase(in.next().charAt(0));
                                    if (option=='S'|| option=='N') {validation=false;}
                                }
                                if (option=='N'){pursue=false;}
                            }
                            clientRegister.get(index).setProductos(products);
                            goOn = false;
                        }
                    }
                }
            } else {
                if (clientRegister.get(index) instanceof Empresas) {
                    String saltoDeLinea = in.nextLine();
                    System.out.print("Nombre: ");
                    clientRegister.get(index).setNombre(in.nextLine());
                    System.out.print("Tipo de Documento: ");
                    ((Empresas) clientRegister.get(index)).setTipDoc(in.nextLine());
                    System.out.print("Número de Documento: ");
                    ((Empresas) clientRegister.get(index)).setDocumento(in.nextLine());
                    System.out.print("Nombre del representante legal: ");
                    ((Empresas) clientRegister.get(index)).setRepresentante(in.nextLine());
                    System.out.print("Número fijo: ");
                    clientRegister.get(index).setTelefono(in.nextLine());
                    System.out.print("Dirección: ");
                    clientRegister.get(index).setDireccion(in.nextLine());
                    boolean goOn = true;
                    while (goOn){
                        System.out.println("Deseas modificar el/los producto(s) asociados a este cliente?(S/N)");
                        char choose = Character.toUpperCase(in.next().charAt(0));
                        if (choose=='N'){goOn = false;}
                        else {
                            if (choose == 'S') {
                                boolean pursue = true;
                                while (pursue){
                                    System.out.println("** Introduzca la información del Producto **");
                                    products.add(addProduct());
                                    boolean validation = true;
                                    char option = ' ';
                                    while (validation){
                                        System.out.println("Deseas agregar más productos? (S/N)");
                                        option = Character.toUpperCase(in.next().charAt(0));
                                        if (option=='S'|| option=='N') {validation=false;}
                                    }
                                    if (option=='N'){pursue=false;}
                                }
                                clientRegister.get(index).setProductos(products);
                                goOn = false;
                            }
                        }
                    }
                }
            }
        }
    }

    public static void additionalProduct(ArrayList<Clientes> customerList, ArrayList<Producto> productList){

        System.out.println("Seleccione del listado de Personas Naturales y Juridicas a cual desea añadir productos");
        String id = showClients(customerList);
        int index = lookFor(id,customerList);
        ArrayList<Producto> productListCopy = new ArrayList<Producto>(customerList.get(index).getProductos());
        boolean moveOn = true;
        while (moveOn){
            productListCopy.add(addProduct());
            boolean repeat = true;
            char response =' ';
            while (repeat){
                System.out.println("Deseas seguir agregando productos? (S/N)");
                response = Character.toUpperCase(in.next().charAt(0));
                if (response == 'S' || response == 'N') { repeat = false;}
            }
            if (response=='N'){moveOn = false;}
        }
        customerList.get(index).setProductos(productListCopy);
    }

    public static void showCustomerData (ArrayList<Clientes> customers){
        Clientes client = new Clientes();
        String id = showClients(customers);
        client = customers.get(lookFor(id,customers));
        System.out.println("Los Datos del Cliente identificado con el numero: "+id+" son: ");
        if (client instanceof Personas){
            System.out.println("Persona Natural: ");
            System.out.println("Nombre: "+client.getNombre());
            System.out.println("Cédula: "+((Personas) client).getCedula());
            System.out.println("Número movil: "+((Personas) client).getCelular());
            System.out.println("Número fijo: "+client.getTelefono());
            System.out.println("Dirección: "+client.getDireccion());
            System.out.println("Los Productos asociados a este cliente son: ");
            if (client.getProductos() != null) {
                for (int i = 0; i < client.getProductos().size(); i++) {
                    System.out.println("Producto ID: " + client.getProductos().get(i).getIdProducto());
                    System.out.println("Nombre: " + client.getProductos().get(i).getNombre());
                    System.out.println("Características: " + client.getProductos().get(i).getCarateristicas());
                    System.out.println("Condiciones: " + client.getProductos().get(i).getCondiciones());
                    System.out.println("************************************************************");
                }
            }else{
                System.out.println("Este cliente no posee productos asociados");
            }
        }if (client instanceof Empresas){
            System.out.println("Persona Jurídica: ");
            System.out.println("Nombre: "+client.getNombre());
            System.out.println("Tipo de Documento: "+((Empresas) client).getTipDoc());
            System.out.println("Número de Documento: "+((Empresas) client).getDocumento());
            System.out.println("Representante Legal: "+((Empresas) client).getRepresentante());
            System.out.println("Número fijo: "+client.getTelefono());
            System.out.println("Dirección: "+client.getDireccion());
            System.out.println("Los Productos asociados a este cliente son: ");
            if (client.getProductos() != null) {
                for (int i = 0; i < client.getProductos().size(); i++) {
                    System.out.println("Producto ID: " + client.getProductos().get(i).getIdProducto());
                    System.out.println("Nombre: " + client.getProductos().get(i).getNombre());
                    System.out.println("Características: " + client.getProductos().get(i).getCarateristicas());
                    System.out.println("Condiciones: " + client.getProductos().get(i).getCondiciones());
                    System.out.println("************************************************************");
                }
            }else{
                System.out.println("Este cliente no posee productos asociados");
            }
        }
    }
}
