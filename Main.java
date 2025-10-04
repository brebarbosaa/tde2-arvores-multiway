public class Main{
    public static void main(String[] args){
        ArvoreTrie raiz = new ArvoreTrie();

        inserir in = new inserir();

        in.inserir(raiz, "arvore");
        
        // Para testar a remoção, você chamaria o novo método:
        in.remover("arvore");

        System.out.println(ArvoreTrie.busca("arvore")); //palavra encontrada
        System.out.println(ArvoreTrie.busca("arvor")); //palavra não encontrada
    }
}
