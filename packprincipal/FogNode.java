package packprincipal;

public class FogNode {
    private final CloudServer cloudServer;
    private int contadorAltas = 0;

    public FogNode(CloudServer cloudServer) {
        this.cloudServer = cloudServer;
    }

    public void procesarDato(SensorData data) {
        String alerta = "";
        
        if (data.getTemperatura() > 30) {
            contadorAltas++;
            alerta = "ALERTA!!! TEMPERATURA ALTA!!!" + contadorAltas;
        }

        System.out.println("Recibido " + data + alerta);
        cloudServer.guardarDato(data);
    }

    public boolean limiteAlcanzado() {
        return contadorAltas >= 20;
    }

    public int getContadorAltas() {
        return contadorAltas;
    }
}
