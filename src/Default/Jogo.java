package Default;

import java.util.Random;

public class Jogo {

    public static void main(String[] args) {
        // Variáveis
        Pilha pilha1, pilha2, pilha3;
        Random gerador = new Random();
        // Instância das pilhas
        pilha1 = new Pilha();
        pilha2 = new Pilha();
        pilha3 = new Pilha();
        
        // Gerar valores aleatórios para primeira pilha
        for (int i = 0; i < 10; i++) {
            pilha1.push((gerador.nextInt(100) + 1));
        }
        
        // Laço de repetição do menu
        OUTER:
        while (true) {
            int opc = Utils.menu("Sair do jogo", "Movimentar", "Ver pilhas");
            switch (opc) {
                case 0:
                    break OUTER;
                case 1:
                    Utils.escolherPilha(pilha1, pilha2, pilha3);
                    break;
                case 2:
                    String a = Utils.pilhaToString(pilha1, pilha2, pilha3);
                    Utils.mostrarMsg(a);
                    break;
            }
        }
    }
}
