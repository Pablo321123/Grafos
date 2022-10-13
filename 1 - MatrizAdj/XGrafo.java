
public class XGrafo {

    private static class XCiclo {
        private int[][] grafo;
        private int numVertices;

        public XCiclo(int[][] grafo, int numVertices) {
            this.grafo = grafo;
            this.numVertices = numVertices;
        }

        private boolean verifyPath(int linha[], int elementoInicio) {
            for (int i = 0; i < numVertices; i++) {
                if (linha[i] != 0) {
                    if (i == elementoInicio) {
                        return true;
                    } else {
                        return verifyPath(grafo[i], elementoInicio); // Trilha as ligacoes dos elementos do grafo a fim
                                                                     // de encontrar um Vk = Vo
                    }
                }
            }
            return false;
        }

        public boolean isCicle() {
            for (int i = 0; i < numVertices; i++) {
                for (int j = 0; j < numVertices; j++) {
                    if (grafo[i][j] != 0) {// Verifica a linha se o elemento do grafo faz
                        boolean retornoLinha = verifyPath(grafo[j], i); // ligaçao com algum outro elemento
                        if (retornoLinha) {
                            return retornoLinha;
                        }
                    }
                }
            }
            return false;
        }
    }

    private int mat[][]; // pesos do tipo inteiro
    private int numVertices;
    private int pos[]; // posição atual ao se percorrer os adjs de um vértice v

    public XGrafo(int numVertices) { // matriz (n x n) bits
        this.mat = new int[numVertices][numVertices];
        this.pos = new int[numVertices];
        this.numVertices = numVertices;

        for (int i = 0; i < this.numVertices; i++) {
            for (int j = 0; j < this.numVertices; j++) {
                this.mat[i][j] = 0;
            }
            this.pos[i] = -1;
        }

    }

    public void insereAresta(int v1, int v2, int peso) {
        this.mat[v1][v2] = peso;
    }

    public boolean existeAresta(int v1, int v2) {
        return (this.mat[v1][v2] > 0);
    }

    public boolean listaAdjVazia(int v) {
        for (int i = 0; i < this.numVertices; i++)
            if (this.mat[v][i] > 0)
                return false;
        return true;
    }

    public Aresta primeiroListaAdj(int v) {
        // Retorna a primeira aresta que o vértice v participa ou
        // null se a lista de adjacência de v for vazia
        this.pos[v] = -1;
        return this.proxAdj(v);
    }

    public Aresta proxAdj(int v) {
        // Retorna a próxima aresta que o vértice v participa ou
        // null se a lista de adjacência de v estiver no fim
        this.pos[v]++;
        while ((this.pos[v] < this.numVertices) &&
                (this.mat[v][this.pos[v]] == 0))
            this.pos[v]++;
        if (this.pos[v] == this.numVertices)
            return null;
        else
            return new Aresta(v, this.pos[v], this.mat[v][this.pos[v]]);
    }

    public Aresta retiraAresta(int v1, int v2) {
        if (this.mat[v1][v2] == 0) {
            return null; // Aresta não existe
        } else {
            Aresta aresta = new Aresta(v1, v2, this.mat[v1][v2]);
            this.mat[v1][v2] = 0;
            return aresta;
        }
    }

    public void imprime() {
        System.out.print(" ");

        for (int i = 0; i < this.numVertices; i++) {
            System.out.print(" " + Cores.ANSI_YELLOW + i + Cores.ANSI_RESET);
        }
        System.out.println();

        for (int i = 0; i < this.numVertices; i++) {
            System.out.print(Cores.ANSI_YELLOW + i + Cores.ANSI_RESET + " ");
            for (int j = 0; j < this.numVertices; j++) {
                System.out.print((this.mat[i][j] == 0 ? Cores.ANSI_RED : Cores.ANSI_GREEN) + this.mat[i][j]
                        + Cores.ANSI_RESET + " ");
            }
            System.out.println();
        }

    }

    public int numVertices() {
        return this.numVertices;
    }

    public void verificaCiclo() {
        XCiclo xc = new XCiclo(mat, numVertices);
        System.out.println("\n" + Cores.ANSI_CYAN + "O grafo analisado "
                + (xc.isCicle() ? (Cores.ANSI_GREEN + "possui ciclos!" + Cores.ANSI_RESET)
                        : (Cores.ANSI_RED + "nao possui ciclos!" + Cores.ANSI_RESET))
                + "\n");
    }
}
