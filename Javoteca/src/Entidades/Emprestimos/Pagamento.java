package Entidades.Emprestimos;

import Enumeracoes.ResultadoPagamento;
import Interfaces.MeioPagamento;
import Interfaces.SistemaPagamento;

public class Pagamento implements SistemaPagamento {

    @Override
    public ResultadoPagamento pagar(Usuario usuario, MeioPagamento meio) {
        if (!usuario.getMulta()) {
            return ResultadoPagamento.SEM_MULTA;
        }
        if (!meio.processar(usuario.getValor_multa())) {
            return ResultadoPagamento.RECUSADO;
        }
        usuario.atualizarStatusEmprestimo(usuario.getInventario(), false, 0.0);
        return ResultadoPagamento.APROVADO;
    }
}
