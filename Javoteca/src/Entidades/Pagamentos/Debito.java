package Entidades.Pagamentos;

import Interfaces.MeioPagamento;

public class Debito implements MeioPagamento {

    @Override
    public String getNome() {
        return "Débito";
    }

    @Override
    public boolean processar(double valor) {
        // Simulação: aqui entraria a chamada ao gateway/banco real.
        return true;
    }
}
