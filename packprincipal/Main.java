package packprincipal;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CloudServer cloud = new CloudServer();
        List<FogNode> fogs = new ArrayList<>();
        List<EdgeNode> allEdges = new ArrayList<>();

        // Crea 5 Fogs
        for (int i = 1; i <= 5; i++) {
            FogNode fn = new FogNode(i, cloud);
            fogs.add(fn);
            
            // Crea 5 Edges para cada Fog
            for (int j = 1; j <= 5; j++) {
                allEdges.add(new EdgeNode(j, fn));
            }
        }

        System.out.println("Iniciando sistema...");

        // Envío de datos hasta alcanzar el límite (20)
        boolean sistemaActivo = true;
        while (sistemaActivo) {
            for (EdgeNode edge : allEdges) {
                edge.enviarLectura();
                
                if (cloud.limiteAlcanzado()) {
                    System.out.println("SISTEMA: Límite de 20 alcanzado.");
                    sistemaActivo = false;
                    break;
                }
            }
        }

        // Mostrar resumen
        cloud.mostrarResumen();
    }
}