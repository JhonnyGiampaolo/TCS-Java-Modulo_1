package com.company;

import clases.CapacidadEndedudamiento;
import clases.Mensajes;
import javafx.scene.input.KeyCode;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String continuar = null;

        do {
            Scanner in = new Scanner(System.in);
            CapacidadEndedudamiento deuda = new CapacidadEndedudamiento();
            boolean incomeValue=true;
            boolean fixedCostValue=true;
            boolean variableCostValue=true;
            boolean validar = true;

            while (incomeValue) {
                System.out.print(Mensajes.ENTER_THE_INCOME.getMessage());
                String income = in.nextLine();
                if (isNumeric(income)){
                    deuda.setIngresosTotales(Double.parseDouble(income));
                    incomeValue = false;
                }
            }

            while (fixedCostValue) {
                System.out.print(Mensajes.ENTER_THE_FIXED_COSTS.getMessage());
                String fixedCost = in.nextLine();
                if (isNumeric(fixedCost)){
                    deuda.setGastosFijos(Double.parseDouble(fixedCost));
                    fixedCostValue = false;
                }
            }

            while (variableCostValue) {
                System.out.print(Mensajes.ENTER_THE_VARIABLE_COSTS.getMessage());
                String variableCost = in.nextLine();
                if (isNumeric(variableCost)){
                    deuda.setGastoVariables(Double.parseDouble(variableCost));
                    variableCostValue = false;
                }
            }

            System.out.print(deuda.properties());
            System.out.print(Mensajes.DEBT.getMessage()+deuda.getCapacidadEndeudamiento());

            while (validar) {
                System.out.print(Mensajes.CONTINUE.getMessage());
                String entrada = in.nextLine();
                continuar = entrada.toUpperCase();
                if (continuar.equals(Mensajes.YES.getMessage()) || continuar.equals(Mensajes.NO.getMessage())){
                    validar = false;
                } else {
                    System.out.println(Mensajes.CHOOSE.getMessage());
                }
            }
        } while (continuar.equals(Mensajes.YES.getMessage()));
    }

    public static boolean isNumeric(String value) {
        // implementa un bloque try catch aca
        boolean validation;

            try {
                Double.parseDouble(value);
                validation = true;
            }catch (Exception e){
                System.out.println(Mensajes.ERROR.getMessage());
                System.out.println(Mensajes.INFORMATIVE.getMessage());
                validation = false;
            }
        return validation;
    }
}
