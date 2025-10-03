class ArvoreTrie {
    ArvoreTrie[] filhos;
    boolean fimDaString;

    public ArvoreTrie() {
        filhos = new ArvoreTrie[26]; // 26 letras do alfabeto
        fimDaString = false;
    }
}

public class Trie {
    private ArvoreTrie raiz;

    public Trie() {
        raiz = new ArvoreTrie();
    }

    public void inserir(String palavra) {
        ArvoreTrie atual = raiz;

        for (int i = 0; i < palavra.length(); i++) {
            char c = palavra.charAt(i);
            int indice = c - 'a';

            if (atual.filhos[indice] == null) {
                atual.filhos[indice] = new ArvoreTrie(); // cria novo nó se não existir
            }

            atual = atual.filhos[indice]; // avança para o nó filho
        }

        atual.fimDaString = true; // marca fim da palavra
    }
}
