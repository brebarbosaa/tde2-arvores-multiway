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
    // -------------------------------------
    // REMOÇÃO RECURSIVA OTIMIZADA
    // -------------------------------------

    public void remover(String palavra) {
        // A busca é essencial para garantir que a palavra existe antes de iniciar a recursão
        if (busca(palavra)) {
            removerAuxiliar(raiz, palavra, 0);
        }
    }

    // Verifica manualmente se há algum nó filho não nulo
    private boolean temFilhos(ArvoreTrie no) {
        int i = 0;
        while (i < 26) {
            if (no.filhos[i] != null) {
                return true;
            }
            i = i + 1;
        }
        return false;
    }

    private ArvoreTrie removerAuxiliar(ArvoreTrie noAtual, String palavra, int indice) {
        if (indice == palavra.length()) {
            noAtual.fimDaString = false;

            // Se o nó final não tem filhos, ele pode ser apagado
            if (this.temFilhos(noAtual) == false) {
                return null
            }
            return noAtual;
        }

    
        char c = palavra.charAt(indice);
        int i = c - 'a';

        if (noAtual.filhos[i] == null) {
            return noAtual;
        }

        // Chamada recursiva para o próximo nível
        ArvoreTrie filhoAposRemocao = removerAuxiliar(noAtual.filhos[i], palavra, indice + 1);
        
        // Backtracking: Atribui o resultado da remoção
        noAtual.filhos[i] = filhoAposRemocao; 

        // Verifica se o nó atual pode ser apagado
        if (noAtual.fimDaString == false && this.temFilhos(noAtual) == false) {
            if (noAtual != raiz) {
                return null; // Sinaliza que este nó deve ser removido
            }
        }
        
        return noAtual; 
    }
}
