package Entidades.Pagamentos;

import Interfaces.MeioPagamento;

public class Credito implements MeioPagamento {

    @Override
    public String getNome() {
        return "Crédito";
    }

    @Override
    public boolean processar(double valor) {
        // Simulação: aqui entraria a chamada ao gateway/banco real.
        return true;
    }
}
