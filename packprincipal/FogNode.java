package packprincipal;

public class FogNode {
    private final int idFog;
    private final CloudServer cloudServer;

    public FogNode(int idFog, CloudServer cloudServer) {
        this.idFog = idFog;
        this.cloudServer = cloudServer;
    }

    public void procesarDato(int idEdge, SensorData data) {
        String alerta = (data.getTemperatura() > 30) ? "ALERTA" : "";
        System.out.println("Fog " + idFog + " (desde Edge " + idEdge + "): " + data + alerta);
        
        cloudServer.guardarDato(data);
    }

    public boolean debeParar() {
        return cloudServer.limiteAlcanzado();
    }
}