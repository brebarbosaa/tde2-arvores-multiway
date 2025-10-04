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
    //inserçao
    public boolean busca(String palavra){
        ArvoreTrie atual = raiz;
        int i = 0;

        while (i < palavra.length()){
            char c = palavra.charAt(i);
            int indice = c - 'a';

            if (atual.filhos[indice] == null){ //o nó filho não exite
                return false; //palavra não encontrada
            }

            atual = atual.filhos[indice]; //avança manualmente na árvore
            i = i + 1;
        }

        if (atual.fimDaString == true){ //último nó = ao fim da palavra
            return true; //palavra encontrada
        }

        return false;
    }
}
