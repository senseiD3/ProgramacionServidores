package packprincipal;

import java.util.ArrayList;
import java.util.List;

public class FogNode {
    private final int idFog;
    private final CloudServer cloudServer;
    private final List<SensorData> buffer = new ArrayList<>();

    public FogNode(int idFog, CloudServer cloudServer) {
        this.idFog = idFog;
        this.cloudServer = cloudServer;
    }

    public void procesarDato(int idEdge, SensorData data) {
        buffer.add(data);
        System.out.println("Fog " + idFog + " [Edge " + idEdge + "] Buffer: " + buffer.size() + "/5");

        // Cuando el buffer llega a 5 se envía al Cloud
        if (buffer.size() == 5) {
            System.out.println("Fog " + idFog + " >>> Procesando y enviando lote al Cloud...");
            try {
                Thread.sleep(2000); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            cloudServer.guardarBatch(new ArrayList<>(buffer));
            buffer.clear();
        }
    }
}