import java.util.Scanner;
import proyecto.Moneda;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String equivale="";
        System.out.println("Selecciona el tipo de cambio:\n" 
        +"1. USD a MXN\n 2. MXN a USD\n 3. USD a CAD\n 4. CAD a USD\n 5. CAD a MXN\n 6. MXN a CAD\n");
        int entrada=in.nextInt();
        Moneda moneda = new Moneda(entrada);
        System.out.println("\nIngresa la cantidad en " + moneda.getTipoDeMoneda() + " a convertir en "+moneda.getTipoDeMonedaDestino()+": ");
        double cantidad=in.nextDouble();
        moneda.setCantidad(cantidad);
        in.close();
        if (cantidad==1){
            equivale=" equivale";
        } else {
            equivale=" equivalen";
        }
        System.out.println("\n" + moneda.getCantidad() + " " + moneda.getTipoDeMoneda() + equivale + " a " +
        moneda.getConvertedValue() + " " +  moneda.getTipoDeMonedaDestino());
        System.out.println("");
    }
}
