public class SelectionSort 
{

	 public String[] selectionSort( String[] array )
	    {

	        // Encontre a refer�ncia de string que deve ir em cada c�lula de
	        // a matriz, da c�lula 0 at� o final
	        for ( int j=0; j < array.length-1; j++ )
	        {
	            // Find min: o �ndice da refer�ncia de string que deve entrar na c�lula j.
	            // Procure nas cadeias n�o classificadas (aquelas em j ou mais) a que � a primeira em ordem lexicogr�fica
	            int min = j;
	            for ( int k=j+1; k < array.length; k++ )
	                if ( array[k].compareTo( array[min] ) < 0 ) min = k;

	            String temp = array[j];
	            array[j] = array[min];
	            array[min] = temp;
	        }
	        return array;
	    }
/*
	    public static void main(String arg[]){
	        SelectionSort obj = new SelectionSort();
	        String vector[] = {"hugo", "will", "guilher", "caio", "felipe"};

			String listaOrdenada[] =  obj.selectionSort(vector);

	            for(int i =0; i < vector.length; i++){
	                System.out.println(listaOrdenada[i]);
	            }

	    }
   */

}//class
