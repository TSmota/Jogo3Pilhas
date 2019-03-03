package Default;

import static javax.swing.JOptionPane.*;

public class Utils {

    static int jogadas = 0;

    public static int lerInteiro(String msg) {
        int n = -1;
        boolean inteiro = false;
        while (!inteiro) {
            try {
                n = Integer.parseInt(showInputDialog(msg));
                inteiro = true;
            } catch (NumberFormatException ex) {
                showMessageDialog(null, "O valor deve ser um número inteiro!");
            }
        }
        return n;
    }

    public static double lerDouble(String msg) {
        double n = 0;
        boolean valido = false;
        while (!valido) {
            try {
                n = Double.parseDouble(showInputDialog(msg));
                valido = true;
            } catch (NumberFormatException ex) {
                showMessageDialog(null, "O valor deve ser um número: ");
            }
        }
        return n;
    }

    public static int menu(String... opcoes) {
        int n = -1;
        boolean valido = false;
        while (!valido) {
            int cont = 0;
            String msg = ">>> MENU PRINCIPAL" + "\nOPÇÕES DISPONÍVEIS:\n";
            for (String opcao : opcoes) {
                msg += "(" + cont + ") " + opcao + "\n";
                cont++;
            }
            msg += "\nSelecione uma opção: ";
            n = lerInteiro(msg);
            if (n >= 0 && n < cont) {
                valido = true;
            } else {
                showMessageDialog(null, "Opção inválida!");
            }
        }
        return n;
    }

    public static String lerString(String msg) {
        String nome = showInputDialog(msg);
        return nome;
    }

    public static void mostrarMsg(String msg) {
        showMessageDialog(null, msg);
    }

    public static String pilhaToString(Pilha p1, Pilha p2, Pilha p3) {
        int[] pilha1 = p1.Pilha();
        int[] pilha2 = p2.Pilha();
        int[] pilha3 = p3.Pilha();
        String pilhas = ">Pilha 1< >Pilha 2< >Pilha 3<\n";
        int cont = 9;
        while (cont != -1) {
            if (p1.topo >= cont && !p1.vazia()) {
                String num = "0";
                if (pilha1[cont] < 10) {
                    num += pilha1[cont];
                } else {
                    num = "" + pilha1[cont];
                }
                pilhas += "  | " + num + " |    ";
            } else {
                pilhas += "  | --- |    ";
            }
            if (p2.topo >= cont && !p2.vazia()) {
                String num = "0";
                if (pilha2[cont] < 10) {
                    num += pilha2[cont];
                } else {
                    num = "" + pilha2[cont];
                }
                pilhas += "       | " + num + " |";
            } else {
                pilhas += "       | --- |";
            }
            if (p3.topo >= cont && !p3.vazia()) {
                String num = "0";
                if (pilha3[cont] < 10) {
                    num += pilha3[cont];
                } else {
                    num = "" + pilha3[cont];
                }
                pilhas += "           | " + num + " |\n";
            } else {
                pilhas += "            | --- |\n";
            }
            cont--;
            if (p1.vazia() && p2.vazia() && p3.vazia()) {
                break;
            }
        }
        return pilhas;
    }

    public static void escolherPilha(Pilha p1, Pilha p2, Pilha p3) {
        String pilhas = pilhaToString(p1, p2, p3);
        String msg = "Número de jogadas: " + jogadas + "\n" + pilhas + "Digite o número da pilha de origem";
        String msg2 = pilhas + "Digite o número da pilha destino";
        int pilhaUm = lerInteiro(msg);
        int pilhaDois = lerInteiro(msg2);
        transferir(p1, p2, p3, pilhaUm, pilhaDois);
    }
    
    public static void transferir(Pilha p1, Pilha p2, Pilha p3, int origem, int destino) {
        int m = -1;
        switch (origem) {
            case 1:
                m = p1.pop();
                break;
            case 2:
                m = p2.pop();
                break;
            case 3:
                m = p3.pop();
                break;
            default:
                System.out.println("Opção inválida");
                break;
        }
        switch (destino) {
            case 1:
                p1.push(m);
                break;
            case 2:
                p2.push(m);
                break;
            case 3:
                p3.push(m);
                break;
            default:
                System.out.println("Opção inválida");
                break;
        }
        jogadas++;
        if (!fullAndSorted(p1, p2, p3)) {
            mostrarMsg(">> Número de jogadas: " + jogadas + "\n" + pilhaToString(p1, p2, p3));
        }
    }
    
    // Verifica se a pilha está cheia, e se estiver, chama o método que
    // verifica se ela está ordenada
    public static Boolean fullAndSorted(Pilha p1, Pilha p2, Pilha p3) {
        if (p1.cheia()) {
            // retorna a pilha em forma de array para verificar se está ordenada
            int[] pilha1 = p1.Pilha();
            if (isSorted(pilha1)) {
                mostrarMsg(">> Pilha um ordenada em " + jogadas + " jogadas.\n" + pilhaToString(p1, p2, p3));
                return true;
            }
            return false;
        } else if (p2.cheia()) {
            int[] pilha2 = p2.Pilha();
            if (isSorted(pilha2)) {
                mostrarMsg(">> Pilha dois ordenada em " + jogadas + " jogadas.\n" + pilhaToString(p1, p2, p3));
                return true;
            }
            return false;
        } else if (p3.cheia()) {
            int[] pilha3 = p3.Pilha();
            if (isSorted(pilha3)) {
                mostrarMsg(">> Pilha três ordenada em " + jogadas + " jogadas.\n" + pilhaToString(p1, p2, p3));
                return true;
            }
            return false;
        } else {
            return false;
        }
    }
    
    // Verifica se o array está ordenado
    public static Boolean isSorted(int[] a) {
        int i;
        for (i = 0; i < a.length - 1 && a[i] < a[i + 1]; i++) {
        }
        return (i == a.length - 1);
    }
}
