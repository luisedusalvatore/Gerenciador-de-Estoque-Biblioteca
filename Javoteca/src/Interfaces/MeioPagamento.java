package Interfaces;

/**
 * Abstração de COMO o dinheiro é cobrado (Pix, cartão, boleto...).
 * Cada implementação encapsula a integração com o seu meio.
 */
public interface MeioPagamento {
    String getNome();

    /** @return true se a cobrança foi aprovada, false se foi recusada. */
    boolean processar(double valor);
}
