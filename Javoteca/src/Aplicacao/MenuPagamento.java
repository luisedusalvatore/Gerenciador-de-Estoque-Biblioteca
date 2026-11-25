package Aplicacao;

import java.util.List;
import java.util.Scanner;

import Entidades.Emprestimos.Usuario;
import Enumeracoes.ResultadoPagamento;
import Interfaces.MeioPagamento;
import Interfaces.SistemaPagamento;

/**
 * Tela de pagamento. Só conhece abstrações (SistemaPagamento, MeioPagamento);
 * tudo o que precisa chega pelo construtor.
 */
public class MenuPagamento {
    private final Scanner sc;
    private final SistemaPagamento sistemaPagamento;
    private final List<MeioPagamento> meios;

    public MenuPagamento(Scanner sc, SistemaPagamento sistemaPagamento, List<MeioPagamento> meios) {
        this.sc = sc;
        this.sistemaPagamento = sistemaPagamento;
        this.meios = List.copyOf(meios);
    }

    public void executar(Usuario usuario) {
        if (!usuario.getMulta()) {
            System.out.println("O usuário não tem multa a ser paga.");
            return;
        }
        System.out.printf("O usuario deve pagar um valor de R$ %.2f\n", usuario.getValor_multa());
        MeioPagamento meio = escolherMeio();

        System.out.println("Processando...");
        ResultadoPagamento resultado = sistemaPagamento.pagar(usuario, meio);

        switch (resultado) {
            case APROVADO:
                System.out.println("Pagamento efetuado com sucesso!");
                break;
            case RECUSADO:
                System.out.println("Pagamento recusado. A multa continua em aberto.");
                break;
            case SEM_MULTA:
                System.out.println("O usuário não tem multa a ser paga.");
                break;
        }
    }

    private MeioPagamento escolherMeio() {
        while (true) {
            System.out.println("Como será o pagamento?");
            for (int i = 0; i < meios.size(); i++) {
                System.out.printf("%d - %s\n", i + 1, meios.get(i).getNome());
            }
            System.out.print("-> ");
            try {
                int escolha = Integer.parseInt(sc.nextLine().trim());
                if (escolha >= 1 && escolha <= meios.size()) {
                    return meios.get(escolha - 1);
                }
            } catch (NumberFormatException e) {
                // cai na mensagem de opção inválida
            }
            System.out.println("\n~ OPÇÃO INVALIDA\ntente novamente ~");
        }
    }
}
