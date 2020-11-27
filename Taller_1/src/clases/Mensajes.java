package clases;

public enum Mensajes {
    ENTER_THE_INCOME ("Introduzca sus ingresos mensuales: "),
    ENTER_THE_FIXED_COSTS ("Introduzca sus gastos fijos: "),
    ENTER_THE_VARIABLE_COSTS ("Introduzca sus gastos variables: "),
    YES ("S"),
    NO ("N"),
    CONTINUE("Deseas realizar otro calculo?(S/N): "),
    DEBT("La capacidad de deuda con los datos ingresados es: "),
    CHOOSE("Debe ingresar una S o una N"),
    ERROR("Has ingresado un valor no numerico"),
    INFORMATIVE("Debes ingresar un valor valido");

    private String message;

    public String getMessage(){return message;}

    Mensajes(String message){this.message = message;}
}
