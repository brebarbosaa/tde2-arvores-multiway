public class Main{
    public static void main(String[] args){
        ArvoreTrie raiz = new ArvoreTrie();

        inserir in = new inserir();

        in.inserir(raiz, "arvore");
        in.inserir("galho");
        in.inserir("gato");

        System.out.println(ArvoreTrie.busca("arvore")); //palavra encontrada
        System.out.println(ArvoreTrie.busca("arvor")); //palavra não encontrada
    }
}
