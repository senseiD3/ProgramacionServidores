package packprincipal;

import java.util.ArrayList;
import java.util.List;

public class CloudServer {
    private final List<SensorData> historicoDatos = new ArrayList<>();
    private int contadorAltasGlobal = 0;

    public void guardarDato(SensorData data) {
        historicoDatos.add(data);
        if (data.getTemperatura() > 30) {
            contadorAltasGlobal++;
        }
    }

    public boolean limiteAlcanzado() {
        return contadorAltasGlobal >= 20;
    }

    public void mostrarResumen() {
        System.out.println("Total de registros: " + historicoDatos.size());
        System.out.println("Total temperaturas altas: " + contadorAltasGlobal);
    }
}
