package packprincipal;

import java.util.Random;

public class EdgeNode {
    private final FogNode fogNode;
    private final Random random = new Random();

    public EdgeNode(FogNode fogNode) {
        this.fogNode = fogNode;
    }

    public void iniciarCapturaContinua() {
        System.out.println("Iniciando captura de datos...");
        int totalGenerados = 0;

        while (!fogNode.limiteAlcanzado()) {
            totalGenerados++;
            String id = "Sensor-E" + totalGenerados;
            double temp = 10 + (45 - 10) * random.nextDouble();
            
            SensorData nuevoDato = new SensorData(id, temp);

            fogNode.procesarDato(nuevoDato);
        }

        System.out.println("SISTEMA DETENIDO");
        System.out.println("Se ha alcanzado " + fogNode.getContadorAltas() + " temperaturas altas.");
        System.out.println("Total de datos procesados en la sesión: " + totalGenerados);
    }
}
