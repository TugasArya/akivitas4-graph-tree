public class aktivitas4 {
    static final int INF = 999;
    static final int V = 5; // A, B, C, D, E

    public static void main(String[] args) {
        int[][] graph = {
            {0, 4, 2, INF, INF},
            {4, 0, INF, 5, INF},
            {2, INF, 0, 1, 3},
            {INF, 5, 1, 0, 2},
            {INF, INF, 3, 2, 0}
        };

        int[][] dist = new int[V][V];
        String[] gedung = {"A", "B", "C", "D", "E"};
        
        // Inisialisasi
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        // Floyd-Warshall
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Output hasil
        System.out.println("=== PETA KAMPUS MINI ===");
        System.out.println("Gedung: A, B, C, D, E\n");
        
        System.out.println("Matriks Jarak Terpendek Antar Gedung:");
        System.out.print("\t");
        for (String g : gedung) System.out.print(g + "\t");
        System.out.println();
        
        for (int i = 0; i < V; i++) {
            System.out.print(gedung[i] + "\t");
            for (int j = 0; j < V; j++) {
                if (dist[i][j] == INF)
                    System.out.print("-\t");
                else
                    System.out.print(dist[i][j] + "\t");
            }
            System.out.println();
        }

        // Contoh jarak tertentu
        System.out.println("\nContoh Jarak Terpendek:");
        System.out.println("A -> D: " + dist[0][3] + " (via C)");
        System.out.println("B -> E: " + dist[1][4] + " (via D)");
        System.out.println("A -> E: " + dist[0][4] + " (via C dan D)");
    }
}
