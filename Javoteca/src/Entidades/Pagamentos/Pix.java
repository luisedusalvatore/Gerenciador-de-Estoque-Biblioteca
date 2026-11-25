package Entidades.Pagamentos;

import Interfaces.MeioPagamento;

public class Pix implements MeioPagamento {

    @Override
    public String getNome() {
        return "Pix";
    }

    @Override
    public boolean processar(double valor) {
        // Simulação: aqui entraria a chamada ao gateway/banco real.
        return true;
    }
}
