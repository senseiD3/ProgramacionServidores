package packprincipal;

public class Main {
    public static void main(String[] args) {
        
        CloudServer miCloud = new CloudServer();
        FogNode miFog = new FogNode(miCloud);
        EdgeNode miEdge = new EdgeNode(miFog);

        miEdge.iniciarCapturaContinua();

        miCloud.mostrarResumen();
    }
}
