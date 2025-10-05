public class Main{
    public static void main(String[] args){
        ArvoreTrie raiz = new ArvoreTrie();

        inserir in = new inserir();

        in.inserir(raiz, "arvore");
        in.inserir("galho");
        in.inserir("gato");
        trie.inserir("galo");
        trie.inserir("g");

        

        System.out.println(ArvoreTrie.busca("arvore")); //palavra encontrada
        System.out.println(ArvoreTrie.busca("arvor")); //palavra não encontrada
        System.out.println("Busca por 'galho': " + trie.busca("galho")); 
        System.out.println("Busca por 'g': " + trie.busca("g"));

        trie.remover("gato");
        trie.remover("galho");
        trie.remover("g");

                // Buscas depois da remoção
        System.out.println("\n--- Após remoções ---");
        System.out.println("Busca por 'gato': " + trie.busca("gato"));       // false
        System.out.println("Busca por 'galho': " + trie.busca("galho"));     // false
        System.out.println("Busca por 'galo': " + trie.busca("galo"));       // true
        System.out.println("Busca por 'g': " + trie.busca("g"));             // false
    }
}
