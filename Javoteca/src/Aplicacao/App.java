package Aplicacao;
import Entidades.Estoques.Estoque;
import Entidades.Estoques.ItemEstoque;
import Entidades.Acervos.ItemAcervo;
import Entidades.Acervos.Livro;
import Entidades.Acervos.Revista;
import Entidades.Acervos.Dvd;
import Entidades.Emprestimos.Usuario;
import Entidades.Emprestimos.Usuarios;

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
        int op2 = 0;
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataString;
        LocalDate dataDate;
        Estoque estoque = new Estoque();
        Usuarios usuarios = new Usuarios();
        
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
                    dataString = sc.nextLine();
                    dataDate = LocalDate.parse(dataString, formato);
                    Instant data = dataDate.atStartOfDay(ZoneId.systemDefault()).toInstant();
                    Usuario usuario = new Usuario(nome, email, data);
                    usuarios.addUsuario(usuario);
                    break;
                case 2:
                    
                    ItemAcervo itemAcervo = null;
                    System.out.println("O selecione o tipo de item que sera cadastrado:");
                    System.out.println("1 - Livro");
                    System.out.println("2 - Revista");
                    System.out.println("3 - DVD");
                    op2 = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Digite o nome do item: ");
                    String titulo = sc.nextLine();
                    System.out.println("Digite o ano de criação do item");
                    int ano = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Digite a data de cadastro do item dd/mm/yyyy");
                    dataString = sc.nextLine();
                    dataDate = LocalDate.parse(dataString, formato);
                    Instant dataCadastro = dataDate.atStartOfDay(ZoneId.systemDefault()).toInstant();

                    switch (op2) {
                        case 1:
                            System.out.println("Digite o autor do titulo");
                            String autor = sc.nextLine();
                            System.out.println("Digite o ISBN do livro");
                            String isbn = sc.nextLine();
                            System.out.println("Digite o número de páginas do livro");
                            int paginas = sc.nextInt();
                            sc.nextLine();
                            itemAcervo = new Livro(titulo, ano, dataCadastro, autor, isbn, paginas);
                            break;
                        case 2:
                            System.out.println("Digite a edição da revista");
                            int edicao = sc.nextInt();
                            sc.nextLine();
                            itemAcervo = new Revista(titulo, ano, dataCadastro, edicao);
                            break;
                        case 3:
                            System.out.println("Digite a duração do filme em minutos");
                            int duracaoMinutos = sc.nextInt();
                            sc.nextLine();
                            itemAcervo = new Dvd(titulo, ano, dataCadastro, duracaoMinutos);
                            break;
                        default:
                            break;   
                    }
                    System.out.println("Digite a quantidade desse item que serão inseridas no sistema: ");
                    int quantidade = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Digite a localização desse acervo");
                    String localizacao = sc.nextLine();
                    ItemEstoque itemEstoque = new ItemEstoque(quantidade, localizacao, itemAcervo);
                    estoque.addItem(itemEstoque);
                    break;
            }
        }while(op != 0);
        System.out.println("Saindo do sistema...");

        sc.close();
    }
}
