package packprincipal;

import java.util.ArrayList;
import java.util.List;

public class CloudServer {
    private final List<SensorData> historicoDatos = new ArrayList<>();

    public void guardarDato(SensorData data) {
        historicoDatos.add(data);
    }

    public void mostrarResumen() {
        System.out.println("Total de registros recibidos: " + historicoDatos.size());
        for (SensorData data : historicoDatos) {
            System.out.println(data);
        }
    }
}
