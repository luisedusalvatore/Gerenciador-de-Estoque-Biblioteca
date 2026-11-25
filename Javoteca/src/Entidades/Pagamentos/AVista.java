package Entidades.Pagamentos;

import Interfaces.MeioPagamento;

public class AVista implements MeioPagamento {

    @Override
    public String getNome() {
        return "À vista";
    }

    @Override
    public boolean processar(double valor) {
        // Simulação: aqui entraria a chamada ao gateway/banco real.
        return true;
    }
}
