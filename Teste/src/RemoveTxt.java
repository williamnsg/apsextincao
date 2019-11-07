import java.util.ArrayList;

public class RemoveTxt {
    LerTxt lerTxt;
    EscreverTxt escreveTxt;
    private String[] dadosCadastro;
    MenuPrincipal menu = new MenuPrincipal();

    public RemoveTxt(){
        lerTxt        = new LerTxt();
        escreveTxt    = new EscreverTxt();
        dadosCadastro = new String[5];
    }

    public void removeLine(int idCadastro){
        String aux                  = "";
        ArrayList<String> dadosArqu = new ArrayList<>();
        lerTxt.lerArquivo(menu.getCaminho());

        /*
            O primeiro if abaixo verifica se o "idCadastro" é maior que o tamanho de linhas ou menor que 0.

            no else:
            ele verifica se o numero do idCadastro é igual ao numero da linha no .Txt, se for valido, ele remove esta linha.
        */
        if(idCadastro >= lerTxt.getArqTxt().size() || idCadastro < 0)
        {
            System.out.println("Cadastro invalido");
        }else{
            for(int i = 0; i < lerTxt.getArqTxt().size(); i++){
                if(idCadastro == i){
                    dadosArqu.add(lerTxt.getArqTxt().get(i));
                    dadosArqu.remove(i);
                }else{
                    dadosArqu.add(lerTxt.getArqTxt().get(i));
                }
            }//for
        }//else


        /*
        no for:
            eu adiciono todas as linhas restantes em uma String e escrevo no arquivo o restante dos cadastros.
         */
        for(int i = 0; i < dadosArqu.size(); i++){
            aux += dadosArqu.get(i)+"\n";
        }
        escreveTxt.write("",menu.getCaminho());
    }//removeLine()

//    public static void main(String arg[]){
//        RemoveTxt obj = new RemoveTxt();
//
//        obj.removeLine(5);
//
//    }
}//class
