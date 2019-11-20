public class BubbleSort 
{

        private String[] vetor;

        public String[] getVetor() {
            return vetor;
        }

        public void setVetor(String[] vetor) {
            this.vetor = vetor;
            bubbleSort();
        }

        public void bubbleSort() {
            int tamanho = vetor.length;

            for (int i = 0; i < tamanho - 1; i++) {
                for (int j = 0; j < tamanho - 1 - i; j++) {
                    if(vetor[j].compareTo(vetor[ j+1 ])>0) {
                        String auxiliar = vetor[j];
                        vetor[j] = vetor[j + 1];
                        vetor[j + 1] = auxiliar;
                    }
                }
            }
        }
/*
        public static void main(String[] args) {
            String vector[] = {"z", "g", "a", "c", "b"};
            BubbleSort o = new BubbleSort();
            o.setVetor(vector);
            o.bubbleSort();
            vector = o.getVetor();

            for (String i : vector)
                System.out.print(i + " ");
        }//main*/

}//class

