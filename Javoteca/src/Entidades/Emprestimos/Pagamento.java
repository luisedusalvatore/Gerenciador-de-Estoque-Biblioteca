package Entidades.Emprestimos;

import Enumeracoes.ResultadoPagamento;
import Interfaces.MeioPagamento;
import Interfaces.SistemaPagamento;

// Implementa a regra de negócio responsável pelo pagamento de multas.
public class Pagamento implements SistemaPagamento {

    // Tenta quitar a multa do usuário usando o meio de pagamento informado.
    @Override
    public ResultadoPagamento pagar(Usuario usuario, MeioPagamento meio) {
        // Impede o pagamento quando o usuário não possui uma multa pendente.
        if (!usuario.getMulta()) {
            return ResultadoPagamento.SEM_MULTA;
        }
        // Solicita ao meio de pagamento que processe o valor da multa.
        if (!meio.processar(usuario.getValor_multa())) {
            return ResultadoPagamento.RECUSADO;
        }
        // Após a aprovação, remove a multa e zera seu valor.
        usuario.atualizarStatusEmprestimo(usuario.getInventario(), false, 0.0);
        return ResultadoPagamento.APROVADO;
    }
}
