package clases;

public class CapacidadEndedudamiento {
    private Double ingresosTotales;
    private Double gastosFijos;
    private Double gastoVariables;
    private final double POR_FIJO = 0.35;

    //Metodos getter and setter para la clase

    public Double getGastosFijos() {
        return gastosFijos;
    }

    public Double getIngresosTotales() {
        return ingresosTotales;
    }

    public void setIngresosTotales(Double ingresosTotales) {
        this.ingresosTotales = ingresosTotales;
    }

    public Double getGastoVariables() {
        return gastoVariables;
    }

    public void setGastoVariables(Double gastoVariables) {
        this.gastoVariables = gastoVariables;
    }

    public double getPorFijo() {
        return POR_FIJO;
    }

    public void setGastosFijos(Double gastosFijos) {
        this.gastosFijos = gastosFijos;
    }

    //Construye un metodo que retorne una cadena con las propiedades de la clase
    public String properties(){
        return "Los valores de las propiedades del objeto de la clase son: \n" +
                "Ingresos Totales: "+getIngresosTotales()+" pesos \n" +
                "Gastos Fijos: "+getGastosFijos()+" pesos \n" +
                "Gastos Variables: "+getGastoVariables()+" pesos \n" +
                "Tasa de Interes Fijo (Constante): "+getPorFijo() +" \n";
    }

    public String getCapacidadEndeudamiento() {
    // retornar la capacidad de endeudamiento puede ser una cadena con el valor
        return (getIngresosTotales() - getGastosFijos() + getGastoVariables()) * getPorFijo() +" pesos \n";
    }
}
