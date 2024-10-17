package proyecto;
import com.google.gson.Gson;

public class Moneda{
    private double cantidad;
    private String tipoDeMoneda;
    private String monedaDestino;
    private double valorDeCambio;
    Server server;

    public Moneda(int tipoDeMoneda){
        switch(tipoDeMoneda){
           case 1: 
                this.tipoDeMoneda="USD";
                this.monedaDestino="MXN";
            break;
            case 2:
                this.tipoDeMoneda="MXN";
                this.monedaDestino="USD";
            break;
            case 3:
                this.tipoDeMoneda="USD";
                this.monedaDestino="CAD";
            break;
            case 4:
                this.tipoDeMoneda="CAD";
                this.monedaDestino="USD";
            break;
            case 5:
                this.tipoDeMoneda="CAD";
                this.monedaDestino="MXN";
            break;
            case 6:
                this.tipoDeMoneda="MXN";
                this.monedaDestino="CAD";
            break;
            default:
                System.out.println("Opción no identificada. Intenta nuevamente");
            break;
        }
    }

    public double getConvertedValue(){
            setServer();
            Gson gson = new Gson();
            Conversion conversion = gson.fromJson(server.getInfo().body(), Conversion.class);
            Conversionn conversion2=gson.fromJson(conversion.conversion_rates().toString(), Conversionn.class);
            switch(monedaDestino){
                case "MXN":
                valorDeCambio=Double.parseDouble(conversion2.MXN());
                break;
                case "USD":
                valorDeCambio=Double.parseDouble(conversion2.USD());
                break;
                case "CAD":
                valorDeCambio=Double.parseDouble(conversion2.CAD());
                break;
            }
        return cantidad*valorDeCambio;
    }

    public void setServer(){
        server=new Server("https://v6.exchangerate-api.com/v6/e22ca47df5afbc1cfab2ab2e/latest/"+
            tipoDeMoneda);
    }

   public void setCantidad(double cantidad){
        this.cantidad=cantidad;
   }

   public double getCantidad(){
        return this.cantidad;
   }

   public String getTipoDeMoneda(){
        return tipoDeMoneda;
   }

   public String getTipoDeMonedaDestino(){
    return monedaDestino;
}

}
