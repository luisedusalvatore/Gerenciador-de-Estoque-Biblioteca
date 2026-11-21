package Aplicacao;
import Entidades.Acervos.Dvd;
import Entidades.Acervos.ItemAcervo;
import Entidades.Acervos.Livro;
import Entidades.Acervos.Revista;
import Entidades.Emprestimos.Emprestimo;
import Entidades.Emprestimos.Emprestimos;
import Entidades.Emprestimos.Usuario;
import Entidades.Emprestimos.Usuarios;
import Entidades.Estoques.Estoque;
import Entidades.Estoques.ItemEstoque;
import Enumeracoes.operacaoAlteracao;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
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
        Emprestimos emprestimos = new Emprestimos();
        
        do{
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
                System.out.println("8 - Imprimir acervo");
                System.out.println("9 - Imprimir Usuários");
                op = sc.nextInt();
                sc.nextLine();
                if(op < 0 || op > 9){
                    System.out.println("Opção Inválida, tente novamente");
                }
            }while(op < 0 || op > 9);
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
                    do{
                        System.out.println("O selecione o tipo de item que sera cadastrado:");
                        System.out.println("1 - Livro");
                        System.out.println("2 - Revista");
                        System.out.println("3 - DVD");
                        op2 = sc.nextInt();
                        sc.nextLine();
                        if(op2 < 1 || op2 > 3){
                            System.out.println("Opção Inválida, tente novamente");
                        }
                    } while(op2 < 1 || op2 > 3);
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
                
                case 3:
                    System.out.println("Digite o nome do item que você deseja remover");
                    String nomeItem = sc.nextLine();
                    ItemEstoque i = estoque.buscarPorTitulo(nomeItem);
                    if(i != null){
                        estoque.removeItem(i);
                    }
                    else{
                        System.out.println("Erro, titulo não achado no sistema");
                    }
                    
                    break;
                
                case 4:
                    System.out.println("Digite o nome do item que você deseja alterar o estoque");
                    String nomeAltera = sc.nextLine();
                    int quantidadeAltera;
                    do{
                        System.out.println("Selecione a opção desejada:");
                        System.out.println("1 - Aumentar a quantidade no estoque");
                        System.out.println("2 - Diminuir a quantidade no estoque");
                        System.out.println("3 - Alterar a quantidade no estoque");
                        op2 = sc.nextInt();
                        sc.nextLine();
                        if(op2 < 1 || op2 > 3){
                            System.out.println("Opção inválida! tente novamente");
                        }
                    }while(op2 < 1 || op2 > 3);
                    switch (op2) {
                        case 1:
                            System.out.println("Quantos itens você deseja adicioar ao estoque?");
                            quantidadeAltera = sc.nextInt();
                            sc.nextLine();
                            estoque.alteraQuantidade(nomeAltera, quantidadeAltera, operacaoAlteracao.AUMENTAR);
                            break;
                        case 2:
                            
                            do{
                                System.out.println("Quantos itens você deseja remover do estoque?");
                                quantidadeAltera = sc.nextInt();
                                sc.nextLine();
                                if(quantidadeAltera > estoque.buscarPorTitulo(nomeAltera).getQuantidade()){
                                    System.out.println("Digite um número válido");
                                }
                            }while(quantidadeAltera > estoque.buscarPorTitulo(nomeAltera).getQuantidade());
                            estoque.alteraQuantidade(nomeAltera, quantidadeAltera, operacaoAlteracao.DIMINUIR);
                            break;
                        case 3:
                            do{
                                System.out.println("Qual a nova quantidade no estoque? ");
                                quantidadeAltera = sc.nextInt();
                                sc.nextLine();
                                if(quantidadeAltera < 0){
                                    System.out.println("Digite um número válido");
                                }
                            }while(quantidadeAltera < 0);
                            estoque.alteraQuantidade(nomeAltera, quantidadeAltera, operacaoAlteracao.ALTERAR);
                            break;
                        default:
                            break;
                    }
                    break;
                case 5:
                    System.out.println("Digite o nome do usuário");
                    String nomeUser = sc.nextLine();
                    System.out.println("Digite o email do usuário");
                    String emailUser = sc.nextLine();
                    Usuario u = usuarios.buscaUsuario(nomeUser, emailUser);
                    while(u == null){
                        System.out.println("Nome e/ou email inválido, tente novamente");
                        System.out.println("Digite o nome do usuário");
                        nomeUser = sc.nextLine();
                        System.out.println("Digite o email do usuário");
                        emailUser = sc.nextLine();
                        u = usuarios.buscaUsuario(nomeUser, emailUser);
                    }
                    System.out.println("Digite o nome do título");
                    String nomeTitulo = sc.nextLine();
                    ItemAcervo itemEmprestimo =  estoque.realizaEmprestimo(nomeTitulo);
                    if(itemEmprestimo == null){
                        System.out.println("Item não encontrado no acervo"); //luisão você tem que avisar quando não tiver item no acervo, fiquei batendo cabeça meia hora
                        break;
                    } 
                    System.out.println("Qual a data de empréstimo (dd/MM/yyyy)");
                    dataString = sc.nextLine();
                    dataDate = LocalDate.parse(dataString, formato);
                    Instant dataEmprestimo = dataDate.atStartOfDay(ZoneId.systemDefault()).toInstant();
                    System.out.println("Qual a data prevista para a devolução (dd/MM/yyyy)");
                    dataString = sc.nextLine();
                    dataDate = LocalDate.parse(dataString, formato);
                    Instant dataPrevistaDevolucao = dataDate.atStartOfDay(ZoneId.systemDefault()).toInstant();
                    Emprestimo emprestimo = new Emprestimo(u, itemEmprestimo, dataEmprestimo, dataPrevistaDevolucao);
                    emprestimos.addEmprestimo(emprestimo);


                    break;
                case 6:
                    System.out.println("Digite o nome do usuário: ");
                    String userName = sc.nextLine();
                    System.out.println("Digite o email do usuário: ");
                    String userMail = sc.nextLine();
                    Usuario u1 = usuarios.buscaUsuario(userName, userMail);
                    while(u1 == null){
                        System.out.println("Usuário e/ou email inválido(s). Tente novamente.");
                        System.out.println("Digite o nome do usuário: ");
                        userName = sc.nextLine();
                        System.out.println("Digite o email do usuário: ");
                        userMail = sc.nextLine();  
                        u1 = usuarios.buscaUsuario(userName, userMail);                                          
                    }

                    System.out.print("Digite o título do item a ser devolvido: ");
                    String itemTitulo = sc.nextLine();

                    Emprestimo e = emprestimos.buscaEmprestimo(u1, itemTitulo); // função pra saber se o emprestimo existe na lista de emprestimos
                    if (e == null){
                        System.out.println("Emprestimo não encontrado");
                    } 
                    
                    if(e != null){
                        System.out.println("Digite a data de devolução (dd/MM/yyyy): ");
                        String dataDev = sc.nextLine();
                        LocalDate dataDateDev = LocalDate.parse(dataDev, formato);
                        Instant dataDevolucao = dataDateDev.atStartOfDay(ZoneId.systemDefault()).toInstant(); //conversão pra facilitar a digitação da data 
                        e.registrarDevolucao(dataDevolucao); 
                    } 
                    break;
                case 7:
                    //verificar e pagar multa
                    break;

            }
        }while(op != 0);
        System.out.println("Saindo do sistema...");

        sc.close();
    }
}
