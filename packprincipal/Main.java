package packprincipal;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CloudServer cloud = new CloudServer();
        List<FogNode> fogs = new ArrayList<>();
        List<EdgeNode> allEdges = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            FogNode fn = new FogNode(i, cloud);
            fogs.add(fn);
            for (int j = 1; j <= 5; j++) {
                allEdges.add(new EdgeNode(j, fn));
            }
        }

        System.out.println("Iniciando sistema con lotes de 5...");

        while (!cloud.limiteAlcanzado()) {
            for (EdgeNode edge : allEdges) {
                edge.enviarLectura();
                
                // Si el límite se alcanza a mitad de un proceso, detenemos inmediatamente
                if (cloud.limiteAlcanzado()) break;
            }
        }

        cloud.mostrarResumen();
    }
}