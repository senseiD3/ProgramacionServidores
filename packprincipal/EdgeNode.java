package packprincipal;

import java.util.Random;

public class EdgeNode {
    private final int idEdge;
    private final FogNode fogNode;
    private final Random random = new Random();

    public EdgeNode(int idEdge, FogNode fogNode) {
        this.idEdge = idEdge;
        this.fogNode = fogNode;
    }

    public void enviarLectura() {
        double temp = 10 + (35 - 10) * random.nextDouble();
        SensorData data = new SensorData("S-" + idEdge, temp);
        fogNode.procesarDato(idEdge, data);
    }
}