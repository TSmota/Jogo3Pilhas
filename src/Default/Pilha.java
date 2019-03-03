package Default;

public class Pilha {

    int tamanhoMax = 10;
    int topo = -1;
    int[] pilha = new int[tamanhoMax];

    public Pilha() {
    }

    public Pilha(int[] n) {
        this.pilha = n;
    }
    
    public int[] Pilha() {
        return pilha;
    }

    public void push(int n) {
        if (cheia()) {
            Utils.mostrarMsg("A pilha está cheia, não é possível adicionar mais valores!");
        } else {
            this.pilha[++topo] = n;
        }
    }

    public int pop() {
        if (vazia()) {
            Utils.mostrarMsg("A pilha está vazia, não é possível remover um número dela!");
            return -1;
        } else {
            return pilha[topo--];
        }
    }

    public boolean cheia() {
        return (topo + 1) == tamanhoMax;
    }

    public boolean vazia() {
        return topo == -1;
    }
}