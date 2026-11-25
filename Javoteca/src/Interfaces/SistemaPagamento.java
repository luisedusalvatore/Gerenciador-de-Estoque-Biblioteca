package Interfaces;

import Entidades.Emprestimos.Usuario;
import Enumeracoes.ResultadoPagamento;

/**
 * Contrato do pagamento de multas. Não lê nem imprime nada:
 * recebe dados, aplica a regra de negócio e devolve o resultado.
 */
public interface SistemaPagamento {
    ResultadoPagamento pagar(Usuario usuario, MeioPagamento meio);
}
