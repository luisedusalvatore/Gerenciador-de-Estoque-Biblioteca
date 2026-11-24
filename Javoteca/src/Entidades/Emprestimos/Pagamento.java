package Entidades.Emprestimos;

import java.util.Scanner;

import Interfaces.SistemaPagamento;

public class Pagamento implements SistemaPagamento{
    
    public Pagamento() {
    }

    @Override
    public void pagar(Usuario usuario){
        Scanner sc = new Scanner(System.in);
        if(usuario.getMulta() == false){
            System.out.println("O usuário não tem multa a ser paga.");
            sc.close();
            return;
            }
        Boolean inv = usuario.getInventario();
        Double valor = usuario.getValor_multa();
        System.out.printf("O usuario deve pagar um valor de R$ %.2f\n", valor);
        System.out.println("Como será o pagamento (Pix, débito, crédito, boleto ou a vista)?");
        sc.nextLine();
        System.out.println("Processando...");
        System.out.println("Pagamento efetuado com sucesso!");
        usuario.atualizarStatusEmprestimo(inv, false, 0.0);
        sc.close();
    }
}
