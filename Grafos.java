import java.util.*;

public class Grafos {
    int Vertices; // Numero de vertices
    ArrayList<ArrayList<Integer>> ListaAdy; // Lista de adyacencia
    int[][] MatrizAdy; // Matriz de adyacencia
    boolean[] Visitados; // Para marcar los vertices visitados
    LinkedList<Integer> Cola; // Se crea una cola que almacena los nodos a visitar
    Stack<Integer> Pila; // Se crea una pila para los vertices a visitar

    // Contructor
    public Grafos(int vertices) {
        Vertices = vertices;
        ListaAdy = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            ListaAdy.add(new ArrayList<>());
        }
        MatrizAdy = new int[vertices][vertices];
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                MatrizAdy[i][j] = Integer.MAX_VALUE;
            }
        }
        Visitados = new boolean[vertices];
        Cola = new LinkedList<>();
        Pila = new Stack<>();
    }

    // Agregar Arista A Los Grafos; v = Vertice Origen; w = Vertice Destino
    public void AgregarArista(int v, int w) {
        // Agrega las aristas a la lista de adyacencia
        ListaAdy.get(v).add(w);
    }

    // Agregar Arista Para Dijkstra
    public void AggAristaDijkstra(int v, int w, int peso) {
        MatrizAdy[v][w] = peso;
    }

    // Metodos = Algoritmos
    public void EmparejamientoPerfecto(int S) {
        // Se inicia un array para almacenar emparejamientos
        // El -1 indica que no hay emparezamientos para ese vertice
        int[] Emparejamiento = new int[Vertices];
        Arrays.fill(Emparejamiento, -1);

        // Clase interna para DFS
        class DFS {
            boolean Dfs(int vertice, int[] emparejamiento) {
                // Recorremos todos los vertices adyacentes al actual
                for (int i : ListaAdy.get(vertice)) {
                    if (emparejamiento[i] == -1) {
                        // Emparejamos el vertice actual con el adyacente
                        emparejamiento[i] = vertice;
                        emparejamiento[vertice] = i;
                        // Se indica que se ha encontrado el emparejamiento
                        return true;
                    }
                }

                // Si no se encontro un emparejamiento se busca para los vertices adyacentes
                for (int j : ListaAdy.get(vertice)) {
                    if (Dfs(Emparejamiento[j], Emparejamiento)) {
                        // Emparejamos el vertice actual con el adyacente
                        emparejamiento[vertice] = j;
                        emparejamiento[j] = vertice;
                        // Se indica que se ha encontrado el emparejamiento
                        return true;
                    }
                }

                // Si no se encontro emparejamiento se devuelve falso
                return false;
            }
        }

        // Se instancia la clase DFS
        DFS dfs = new DFS();

        // Se recorren todos los vertices
        for (int i = 0; i < Vertices; i++) {
            if (Emparejamiento[i] == -1) {
                // Se intenta encontrar un emparejamiento
                if (!dfs.Dfs(i, Emparejamiento)) {
                    // Si no se logra encontrar un emparejamiento
                    System.out.println("No se pudo encontrar un emparejamiento perfecto");
                }
            }
        }

        // Si se encontro un emparejamiento y se muestra
        System.out.println("Se ha encontrado un emparejamiento perfecto");
        for (int i = 0; i < Vertices; i++) {
            System.out.println(i + " -> " + Emparejamiento[i]);
        }
    }

    public void TMA_MatrimonioEstable() {
    }

    public void BFS_BusquedaEnAmplitud(int S) {
        // Se marcan todos los vertices como no visitados
        for (int i = 0; i < Vertices; i++) {
            Visitados[i] = false;
        }

        // Se marca el nodo actual como visitado y se pone en la cola
        Visitados[S] = true;
        Cola.add(S);

        // Se ejecuta mientras haya nodos en la cola
        while (Cola.size() != 0) {
            // Se saca de la cola el nodo y se imprime
            S = Cola.poll();
            System.out.print(S + " ");

            // Se obtienen los vertices adyacentes del vertice S
            Iterator<Integer> i = ListaAdy.get(S).listIterator();
            // Se ejecuta mientras haya nodos adyacentes
            while (i.hasNext()) {
                // Obtiene los nodos adyacentes
                int VericeAdy = i.next();
                // Si el nodo adyacente no ha sido visitado
                if (!Visitados[VericeAdy]) {
                    // Marca el nodo como visitado y lo agrega a la cola
                    Visitados[VericeAdy] = true;
                    Cola.add(VericeAdy);
                }
            }
        }
    }

    public void DFS_BusquedaEnProfundidad(int S) {
        // Se agrega el vertice al inicio y se marca como visitado
        Pila.push(S);
        Visitados[S] = true;

        // Funciona mientras la pila no este vacia
        while (!Pila.isEmpty()) {
            // Se toma el vertice superior y se imprime
            int Actual = Pila.pop();
            System.out.print(Actual + " ");

            // Para los vertices adyacentes al actual
            for (int Adyacentes : ListaAdy.get(Actual)) {
                // Si el adyacente no ha sido visitado
                if (!Visitados[Adyacentes]) {
                    // Se agrega a la pila y se marca como visitado
                    Pila.push(Adyacentes);
                    Visitados[Adyacentes] = true;
                }
            }
        }
    }

    public void Dijkstra(int Origen) {
        // Inicia el array con el numero de vertices
        int[] Distancias = new int[Vertices];
        // Se llena el array con el valor maximo de enteros
        Arrays.fill(Distancias, Integer.MAX_VALUE);
        // Indica que la distancia desde el origen hasta el origen es 0
        Distancias[Origen] = 0;
        // Se inicia el array con el numero de vertices
        boolean[] Visitados = new boolean[Vertices];

        for (int i = 0; i < Vertices; i++) {
            int MasCorto = -1;
            for (int j = 0; j < Vertices; j++) {
                if (!Visitados[j] && (MasCorto == -1 || Distancias[j] < Distancias[MasCorto])) {
                    MasCorto = j;
                }
            }

            // Marcar vertice como visitado
            Visitados[MasCorto] = true;
            // Actualizar distancias de los vertices adyacentes al mas corto
            for (int m = 0; m < Vertices; m++) {
                if (MatrizAdy[MasCorto][m] != Integer.MAX_VALUE && Distancias[MasCorto] + MatrizAdy[MasCorto][m] < Distancias[m]) {
                    // Actualiza distancias desde origen hasta m
                    Distancias[m] = Distancias[MasCorto] + MatrizAdy[MasCorto][m];
                }
            }
        }

        // Se imprimen las distancias calculadas
        System.out.println("Vertice     ---     Distancia");
        for (int i = 0; i < Vertices; i++) {
            System.out.println("   " + i + "        ---        " + Distancias[i]);
        }
    }

    // TENGO MIS DUDAS AQUI, REVISEN
    public void Forward() {
        double[] Alpha = new double[Vertices];
        for (int i = 0; i < Vertices; i++) {
            Alpha[i] = 1.0;
        }

        // Calcula los valores de Alpha
        for (int m = 0; m < Vertices; m++) {
            for (int i = 0; i < Vertices; i++) {
                double Suma = 0.0;
                for (int j = 0; j < Vertices; j++) {
                    Suma = Suma + Alpha[j] * MatrizAdy[j][i];
                }
                Alpha[i] = Suma;
            }
        }

        // Se imprimen los valores de Alpha
        for (int i = 0; i < Vertices; i++) {
            System.out.println("Alpha[" + i + "] = " + Alpha[i]);
        }
    }

    public void BellmanFord() {
    }

    public void DAG_OrdenamientoTopologico() {
        // Se recorren todos los vertices
        for (int i = 0; i < Vertices; i++) {
            // Si el verice no se ha visitado
            if (!Visitados[i]) {
                Visitados[i] = true;
                // Se recorren los vertices adyacentes al actual
                for (int j = 0; j < ListaAdy.get(i).size(); j++) {
                    int Ady = ListaAdy.get(i).get(j);
                    // Si el verice no se ha visitado
                    if (!Visitados[Ady]) {
                        DAG_OrdenamientoTopologico();
                    }
                }

                // Si no hay vertices adyacentes no visitados, se agregan a la Pila y se imprime
                Pila.push(i);
                System.out.print(i + " ");
            }
        }
    }

    public void Kruskal() {
    }

    public void MST_ArbolDeExpansionMinma() {
    }

    public static void main(String[] args) {
        // Recibe el grafo
        // Menu
        // If con codiciones pra uso de metodos
    }
}