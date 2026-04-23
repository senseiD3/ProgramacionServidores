package packprincipal;

import java.util.ArrayList;
import java.util.List;

public class CloudServer {
    private final List<SensorData> historicoDatos = new ArrayList<>();
    private int contadorAltasGlobal = 0;

    public void guardarBatch(List<SensorData> batch) {
        historicoDatos.addAll(batch);
        for (SensorData data : batch) {
            if (data.getTemperatura() > 30) {
                contadorAltasGlobal++;
            }
        }
    }

    public boolean limiteAlcanzado() {
        return contadorAltasGlobal >= 20;
    }

    public void mostrarResumen() {
        System.out.println("\n--- RESUMEN FINAL ---");
        System.out.println("Total registros: " + historicoDatos.size());
        System.out.println("Total alertas altas: " + contadorAltasGlobal);
    }
}
