package Aplicacao;
import Entidades.Estoques.Estoque;
import Entidades.Emprestimos.Usuario;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bem vindo ao sistema Javoteca!");
        int op ;
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Estoque estoque = new Estoque();
        List<Usuario> usuarios = new ArrayList<>();
        do{
            System.out.println("Digite a opção desejada: ");
            System.out.println("0 - Sair");
            System.out.println("1 - Cadastrar usuário");
            System.out.println("2 - Cadastrar Item no Estoque");
            System.out.println("3 - Remover Item do Estoque");
            System.out.println("4 - Alterar a Quantidade de Itens no Estoque");
            System.out.println("5 - Realizar Empréstimo");
            System.out.println("6 - Anotar Devolução");
            System.out.println("7 - Verificar Multa e Pagar");
            op = sc.nextInt();
            sc.nextLine();
            
            switch (op) {
                case 1:
                    System.out.println("Qual o nome do usuário? ");
                    String nome = sc.nextLine();
                    System.out.println("Digite o email do usuário? ");
                    String email = sc.nextLine();
                    System.out.println("Digite a data de nascimento do usuário no formato dd/mm/yyyy");
                    String dataString = sc.nextLine();
                    LocalDate dataDate = LocalDate.parse(dataString, formato);
                    Instant data = dataDate.atStartOfDay(ZoneId.systemDefault()).toInstant();
                    Usuario usuario = new Usuario(nome, email, data);
                    usuarios.add(usuario);
                    break;
                case 2:
                    
                    break;
            }
        }while(op != 0);
        System.out.println("Saindo do sistema...");

        sc.close();
    }
}
