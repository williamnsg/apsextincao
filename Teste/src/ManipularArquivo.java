import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ManipularArquivo 
{
    ArrayList<String> linhas = new ArrayList();

    public String Read(String Caminho){
        String conteudo = "";

        try {
            FileReader arq        = new FileReader(Caminho);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha          = "";
            try {
                linha = lerArq.readLine();
                while(linha!=null){
                    if(linha.substring(0,1).equals("#")){
                        linha = lerArq.readLine();
                    }else{
                        conteudo += linha+"\n";
                        linhas.add(linha);
                        linha     = lerArq.readLine();
                    }
                }
                arq.close();
                return conteudo;
            } catch (IOException ex) {
                System.out.println("Erro: Não foi possível ler o arquivo!");
                return "";
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Erro: Arquivo não encontrado!");
            return "404";
        }
    }//Read

    public boolean Write(String Caminho,String Texto){
        try {
            FileWriter arq        = new FileWriter(Caminho, true);
            PrintWriter gravarArq = new PrintWriter(arq);
            gravarArq.println(Texto);
            gravarArq.close();
            return true;
        }catch(IOException e){
            System.out.println(e.getMessage());
            return false;
        }
    }//Write

    public boolean Write2(String Caminho,String Texto){
        try {
            FileWriter arq        = new FileWriter(Caminho);
            PrintWriter gravarArq = new PrintWriter(arq);
            gravarArq.write(Texto);
            gravarArq.close();
            return true;
        }catch(IOException e){
            System.out.println(e.getMessage());
            return false;
        }
    }//Write

    public String linhasDocumento(int linha){
        String informacao = "";

        if(linha >= 0){
            informacao = linhas.get(linha);
        }else{
            System.out.println("Valor digitado é menor que 0!");
        }
        return informacao;
    }
}//class
