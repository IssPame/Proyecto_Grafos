# Proyecto_Grafos
Se crean todos los algoritmos vistos en clases para el estudio de Grafos

# A L G O R I T M O S

# Emparejamiento Perfecto
- Emparejamiento maximo: aquel que contiene el numero maximo posible de aristas (que no hay emparejamientos con mas aristas)
- Un emparejamiento se dice que es maximal si no esta contenido en otro emparejamiento.
- Un emparejamiento es perfecto si todos los veertices del grafo forman parte de el.

# Matrimonio Estable (TMA)
- Este problema se puede definir en terminos de grafos, puesto que partimos de dos conjuntos disjuntos del mismo cardinal, H = {h1, h2, ..., hn} y M = {m1, m2, ..., mn}, que conformaran el conjunto de vertices de nuestro grafo bipartito (V = H ∪ M, con |H| = |M|).
- Ademas, cada vertice de H y cada vertices de M tiene su propia lista de preferencias en la que ordena a todos los vertice del conjunto al que no pertenece. Es decir, que cada vertice de H tiene una ordenacion en sus aristas incidentes en cada vertice de M, y viceversa.

# Busqueda en Amplitud o Anchura (Breadth First Search, BFS)
- Recorre el grafo al primero comprobar el nodo actual y luego expandirlo al agregar sus sucesores al siguiente nivel.
- El proceso se repite para todos los nodos del nivel actual  antes de moverse al siguiente.

# Busqueda en Profundidad (Depth First Search, DFS)
- Recorre el grafo revisando primero el nodo actual y moviéndose después a uno de sus sucesores para repetir el proceso.
- Si el nodo actual no tiene sucesor a revisar, regresamos a su predecesor y el proceso continúa (moviéndose a otro sucesor).

# Dijkstra
- Encuentra el camino más corto de origen único en un grafo con aristas no negativas.
- Creamos dos arreglos: visitado y distancia, que registran si un vértice es visitado y cuál es la mínima distancia desde el vértice origen, respectivamente. Inicialmente, el arreglo visitado se asigna como falso y distancia como infinito.
- Partimos del vértice origen. Dejemos que el vértice actual sea u y sus vértices adyacentes sean v. Ahora, por cada v que es adyacente a u, la distancia se actualiza si no ha sido visitado antes y la distancia desde u es menor que su distancia actual.
- Luego seleccionamos el siguiente vértice con la menor distancia y que no haya sido visitado.

# Forward
- La funcion α() puede representarse como una matriz: α(q,t) ≡ α(q, t). Esta define un grafo multietapa denominado trellis y permite el calculo iterativo eficiente de α(q,|y|) por Programacion Dinamica.
- Complejidad temporal del algoritmo: O(mb), donde m es la longitud de la cadena y b es el numero de transciones entre estados.

# Bellman-Ford
- Algoritmo de busqueda del camino mas corto para grafos que puede tener pesos negativos.
- Es tambien ideal para detectar ciclos de pesos negativos, ya que el algoritmo converge hacia una solución optima en O(V*E) pasos.

# Ordenamiento Topologico (DAG)
- Toma un grafo aciclico dirigido y produce un ordenamiento lineal de todos sus vertices de tal manera que si el grafo G contiene una arista (v,w) entonces el vertice v está, en el orden, antes del vértice w.

# Arbol de Expansion Minima (MST)
- Es aquel que comienza desde un vertice y encuentra todos sus nodos accesibles y las relaciones en conjunto que permiten que se conecten dichos nodos con el menor peso posible.