import java.io.*;

public class EscreverTxt {

    public boolean write(String txt,String caminho)
    {
        try{        	
            FileWriter arq        = new FileWriter(caminho, true);
            PrintWriter gravarArq = new PrintWriter(arq);
            gravarArq.write(txt);
            gravarArq.close();
            arq.close();
            return true;
        }catch(IOException err){
            System.err.println(err.getMessage());
            return false;
        }       
    }
}//class
