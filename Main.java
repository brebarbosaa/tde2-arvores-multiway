public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.inserir("arvore");
        trie.inserir("galho");
        trie.inserir("gato");
        trie.inserir("galo");
        trie.inserir("g");

        System.out.println(trie.busca("arvore")); // true
        System.out.println(trie.busca("arvor"));  // false
        System.out.println("Busca por 'galho': " + trie.busca("galho"));
        System.out.println("Busca por 'g': " + trie.busca("g"));

        trie.remover("gato");
        trie.remover("galho");
        trie.remover("g");

        System.out.println("\n--- Após remoções ---");
        System.out.println("Busca por 'gato': " + trie.busca("gato"));   // false
        System.out.println("Busca por 'galho': " + trie.busca("galho")); // false
        System.out.println("Busca por 'galo': " + trie.busca("galo"));   // true
        System.out.println("Busca por 'g': " + trie.busca("g"));         // false
    }
}
