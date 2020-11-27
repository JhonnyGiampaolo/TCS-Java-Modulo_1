package com.clientes;

import com.clases.BeneficiosCovid19;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.random;

public class Main {

    static final double TOPLIMIT = 999999;

    public static void main(String[] args) {
        /**
         * Crear 2 lista de beneficios para clientes Lista 1 y Lista 2 por ejemplo
         * Ejemplo:
         * id:12121
         * nombre: Beneficiados que perdieron su trabajo por COVID19
         * valorSubsidio: 150000
         *
         * Ejemplo:
         * id:895656
         * Nombre: Beneficios para persona tercera edad dagnificados COVID
         * valorSubsidio:200000
         */

        ArrayList<BeneficiosCovid19> objectList = new ArrayList();
        BeneficiosCovid19 object = new BeneficiosCovid19();
        Scanner input = new Scanner(System.in);
        String cantidad = null;
        String money = null;
        Integer iteractions = 0;
        boolean goOn = true;

        while (goOn) {
            System.out.println("Bienvenido al sistema de registro de Beneficios del Covid 19");
            System.out.print("Cuantos beneficios deseas ingresar: ");
            cantidad = input.nextLine();
            goOn = !(isNumeric(cantidad));
        }
        iteractions = Integer.parseInt(cantidad);

        for (int i = 1; i <= iteractions; i++) {
            boolean follow = false;
            object.setId(getIdBeneficio());
            System.out.println("El ID del beneficio Nro "+i+" que estas creando es: "+object.getId());
            System.out.print("Escribe el nombre del beneficio que estas creando: ");
            object.setNombre(input.nextLine());
            while(!(follow)){
                System.out.print("Escribe el valor monetario de este beneficio: ");
                money = input.nextLine();
                follow = (isNumeric(money));
            }
            object.setValorSubsidio(money);
            objectList.add(object);
        }
        getMejorBeneficio(objectList);
    }

    private static String getIdBeneficio(){
        Double number =  Math.random()*TOPLIMIT;
        Integer id = number.intValue();
        return id.toString();
    }

    public static boolean isNumeric(String value) {
        boolean validation;

        try {
            Double.parseDouble(value);
            validation = true;
        }catch (Exception e){
            System.out.println("Has ingresado un valor incorrecto.");
            System.out.println("Debes ingresar un numero");
            validation = false;
        }
        return validation;
    }

    public static void  getMejorBeneficio (ArrayList<BeneficiosCovid19> list) {
        BeneficiosCovid19 element = new BeneficiosCovid19();
        Float value = Float.valueOf(0);

        for (int j = 0; j < list.size(); j++) {
            element = list.get(j);
            Float elementValue = element.getValorSubsidio();
            if (value < elementValue) {
                value = elementValue;
                element = list.get(j);
            }
        }
        showContent(element);
    }

    public static void showContent(BeneficiosCovid19 list){
        System.out.println("El mejor beneficio de los que creaste es el siguiente: ");
        System.out.println("ID: "+list.getId());
        System.out.println("Nombre: "+list.getNombre());
        System.out.println("El Valor del subsidio es: "+list.getValorSubsidio());
    }
}
