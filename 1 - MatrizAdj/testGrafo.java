public class testGrafo {

        public static void main(String[] args) {
                int grafoA[][] = {
                                // 0, 1, 2, 3, 4, 5, 6, 7
                                { 0, 1, 0, 1, 1, 0, 0, 0 }, // 0
                                { 1, 0, 1, 0, 0, 1, 0, 0 }, // 1
                                { 0, 1, 0, 1, 0, 0, 1, 0 }, // 2
                                { 1, 0, 1, 0, 0, 0, 0, 1 }, // 3
                                { 1, 0, 0, 0, 0, 1, 0, 1 }, // 4
                                { 0, 1, 0, 0, 1, 0, 1, 0 }, // 5
                                { 0, 0, 1, 0, 0, 1, 0, 1 }, // 6
                                { 0, 0, 0, 1, 1, 0, 1, 0 } // 7
                };

                int grafoB[][] = {
                                // 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
                                { 0, 1, 1, 1, 0, 1, 0, 0, 0, 0 }, // 0 ok
                                { 0, 0, 1, 0, 0, 0, 0, 0, 0, 0 }, // 1 ok
                                { 0, 0, 0, 1, 1, 0, 0, 0, 0, 0 }, // 2 ok
                                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 3 ok
                                { 0, 0, 0, 0, 0, 0, 1, 0, 0, 0 }, // 4 ok
                                { 0, 0, 0, 0, 1, 0, 1, 0, 0, 0 }, // 5 ok
                                { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0 }, // 6 ok
                                { 0, 0, 0, 0, 0, 0, 0, 0, 1, 0 }, // 7 ok
                                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 8 ok
                                { 0, 0, 0, 0, 0, 0, 1, 0, 0, 0 } // 9 ok
                };

                XGrafo xga = new XGrafo(8);
                XGrafo xgb = new XGrafo(10);

                for (int i = 0; i < grafoA.length; i++) {
                        for (int j = 0; j < grafoA.length; j++) {
                                xga.insereAresta(i, j, grafoA[i][j]);
                        }
                }

                for (int i = 0; i < grafoB.length; i++) {
                        for (int j = 0; j < grafoB.length; j++) {
                                xgb.insereAresta(i, j, grafoB[i][j]);
                        }
                }

                System.out.println("------------------------------------------------------\n");
                xga.imprime();
                xga.verificaCiclo();
                System.out.println("------------------------------------------------------\n");
                xgb.imprime();
                xgb.verificaCiclo();
                System.out.println("------------------------------------------------------\n");
        }
}
