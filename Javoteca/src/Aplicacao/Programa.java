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
import Excecoes.ItemIndisponivel;
import Excecoes.ItemNaoEncontrado;
public class Programa {
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
                System.out.println("\n\n\n-----------------------------------------------------");
                System.out.println("DIGITE A OPÇÃO DESEJADA\n");
                System.out.println("0)  Sair");
                System.out.println("1)  Cadastrar usuário");
                System.out.println("2)  Cadastrar item no estoque");
                System.out.println("3)  Remover item do estoque");
                System.out.println("4)  Alterar a quantidade de itens no estoque");
                System.out.println("5)  Realizar empréstimo");
                System.out.println("6)  Anotar devolução");
                System.out.println("7)  Verificar multa e pagar");
                System.out.println("8)  Imprimir acervo");
                System.out.println("9)  Imprimir usuários");
                System.out.println("-----------------------------------------------------\n");
                System.out.print("-> ");
                op = sc.nextInt();
                sc.nextLine();
                if(op < 0 || op > 9){
                    System.out.println("\n~ OPÇÃO INVALIDA\ntente novamente ~");
                }
            }while(op < 0 || op > 9);
            switch (op) {
                case 1:
                    System.out.println("\n\n\n CADASTRO DE USUÁRIO \n");
                    System.out.print("* Nome do usuário: ");
                    String nome = sc.nextLine();
                    System.out.print("\n* Email do usuário: ");
                    String email = sc.nextLine();
                    System.out.print("\n* Data de nascimento do usuário (dd/mm/yyyy): ");
                    dataString = sc.nextLine();
                    dataDate = LocalDate.parse(dataString, formato);
                    Instant data = dataDate.atStartOfDay(ZoneId.systemDefault()).toInstant();
                    Boolean inventario = false;
                    Boolean multa = false;
                    Double valor_multa = 0.0;
                    Usuario usuario = new Usuario(nome, email, data, inventario, multa, valor_multa);
                    usuarios.addUsuario(usuario);
                    System.out.println("\n\n\n CADASTRO REALIZADO COM SUCESSO \n");
                    sc.nextLine();
                    break;
                case 2:
                    
                    ItemAcervo itemAcervo = null;
                    do{
                        System.out.println("\n\n\n CADASTRO DE ITEM \n");
                        System.out.println("* tipo de item:");
                        System.out.println("1 - Livro");
                        System.out.println("2 - Revista");
                        System.out.println("3 - DVD");
                        System.out.print("-> ");
                        op2 = sc.nextInt();
                        sc.nextLine();
                        if(op2 < 1 || op2 > 3){
                            System.out.println("\n~ OPÇÃO INVALIDA\ntente novamente ~");
                        }
                    } while(op2 < 1 || op2 > 3);
                    System.out.print("\n* Nome do item: ");
                    String titulo = sc.nextLine();
                    System.out.print("\n* Ano de criação do item: ");
                    int ano = sc.nextInt();
                    sc.nextLine();
                    System.out.print("\n* Data de cadastro do item (dd/mm/yyyy): ");
                    dataString = sc.nextLine();
                    dataDate = LocalDate.parse(dataString, formato);
                    Instant dataCadastro = dataDate.atStartOfDay(ZoneId.systemDefault()).toInstant();

                    switch (op2) {
                        case 1:
                            System.out.print("\n* Autor do livro: ");
                            String autor = sc.nextLine();
                            System.out.print("\n* ISBN do livro: ");
                            String isbn = sc.nextLine();
                            System.out.print("\n* Número de páginas do livro: ");
                            int paginas = sc.nextInt();
                            sc.nextLine();
                            itemAcervo = new Livro(titulo, ano, dataCadastro, autor, isbn, paginas);
                            break;
                        case 2:
                            System.out.print("\n* Edição da revista: ");
                            int edicao = sc.nextInt();
                            sc.nextLine();
                            itemAcervo = new Revista(titulo, ano, dataCadastro, edicao);
                            break;
                        case 3:
                            System.out.print("\n* Duração do filme (min): ");
                            int duracaoMinutos = sc.nextInt();
                            sc.nextLine();
                            itemAcervo = new Dvd(titulo, ano, dataCadastro, duracaoMinutos);
                            break;
                        default:
                            break;   
                    }
                    System.out.print("\n* Quantidade desse item que será inseridas no sistema: ");
                    int quantidade = sc.nextInt();
                    sc.nextLine();
                    System.out.print("\n* Digite a localização desse acervo: ");
                    String localizacao = sc.nextLine();
                    ItemEstoque itemEstoque = new ItemEstoque(quantidade, localizacao, itemAcervo);
                    estoque.addItem(itemEstoque);
                    System.out.println("\n\n\n CADASTRO REALIZADO COM SUCESSO \n");
                    sc.nextLine();
                    break;
                
                case 3:
                    System.out.println("\n\n\n REMOÇÃO DE ITEM\n");
                    System.out.print("* Nome do item que será removido: ");
                    String nomeItem = sc.nextLine();
                    ItemEstoque i = estoque.buscarPorTitulo(nomeItem);
                    if(i != null){
                        System.out.println("\n\nAPERTE ENTER PARA CONFIRMAR REMOÇÃO\n");
                        sc.nextLine();
                        estoque.removeItem(i);
                    }
                    else{
                        System.out.println("\n ERRO\ntitulo não achado no sistema");
                    }
                    System.out.println("\n\n\n REMOÇÃO REALIZADA COM SUCESSO \n");
                    sc.nextLine();
                    break;
                
                case 4:
                    System.out.println("\n\n\nALTERAÇÃO DE QUANTIDADE\n");
                    System.out.print("* Nome do item que será alterado no estoque: ");
                    String nomeAltera = sc.nextLine();
                    int quantidadeAltera;
                    do{
                        System.out.println("Selecione a opção desejada:");
                        System.out.println("1 - Aumentar a quantidade no estoque");
                        System.out.println("2 - Diminuir a quantidade no estoque");
                        System.out.println("3 - Alterar a quantidade no estoque");
                        System.out.print("-> ");
                        op2 = sc.nextInt();
                        sc.nextLine();
                        if(op2 < 1 || op2 > 3){
                            System.out.println("\nOPÇÃO INVALIDA\ntente novamente:");
                        }
                    }while(op2 < 1 || op2 > 3);
                    switch (op2) {
                        case 1:
                            System.out.print("\n* Quantidade que será adicionada ao estoque: ");
                            quantidadeAltera = sc.nextInt();
                            sc.nextLine();
                            estoque.alteraQuantidade(nomeAltera, quantidadeAltera, operacaoAlteracao.AUMENTAR);
                            break;
                        case 2:
                            
                            do{
                                System.out.print("\n* Quantidade que será removida do estoque: ");
                                quantidadeAltera = sc.nextInt();
                                sc.nextLine();
                                if(quantidadeAltera > estoque.buscarPorTitulo(nomeAltera).getQuantidade()){
                                    System.out.println("~ Digite um número válido ~");
                                }
                            }while(quantidadeAltera > estoque.buscarPorTitulo(nomeAltera).getQuantidade());
                            estoque.alteraQuantidade(nomeAltera, quantidadeAltera, operacaoAlteracao.DIMINUIR);
                            break;
                        case 3:
                            do{
                                System.out.print("\n* Quantidade de estoque: ");
                                quantidadeAltera = sc.nextInt();
                                sc.nextLine();
                                if(quantidadeAltera < 0){
                                    System.out.println("~ Digite um número válido ~");
                                }
                            }while(quantidadeAltera < 0);
                            estoque.alteraQuantidade(nomeAltera, quantidadeAltera, operacaoAlteracao.ALTERAR);
                            break;
                        default:
                            break;
                    }
                    System.out.println("\n\n\n ALTERAÇÃO REALIZADA COM SUCESSO \n");
                    sc.nextLine();
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

                    // Verificação de status do usuario
                    if(u.getInventario() == true){
                        System.out.println("O usuário já tem um emprestimo em andamento. Após o fim do atual emprestimo o usuário poderá fazer outro.");
                        break;
                    }
                    if(u.getMulta() == true){
                        System.out.println("O usuário tem uma multa em aberto. Após efetuar o pagamento da multa o usuário poderá fazer um emprestimo.");
                        break;
                    }

                    System.out.println("Digite o nome do título");
                    String nomeTitulo = sc.nextLine();
                    ItemAcervo itemEmprestimo = null;
                    try {
                        itemEmprestimo = estoque.realizaEmprestimo(nomeTitulo);
                    } catch (ItemNaoEncontrado | ItemIndisponivel ex) {
                        System.out.println(ex.getMessage());
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
                    u.atualizarStatusEmprestimo(true, false, 0.0);


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
                        if(e.diasAtraso() == 0){
                            u1.atualizarStatusEmprestimo(false, false, 0.0);
                        }else{
                            double vm = e.acessarValorMulta(e.diasAtraso()); // Pegando o valor da multa a ser paga.
                            u1.atualizarStatusEmprestimo(false, true, vm);
                        }
                        emprestimos.removeEmprestimo(e);
                    } 
                    break;
                case 7:
                    System.out.println("Digite o nome do usuário: ");
                    String uName = sc.nextLine();
                    System.out.println("Digite o email do usuário: ");
                    String uMail = sc.nextLine();
                    Usuario user = usuarios.buscaUsuario(uName, uMail);
                    while(user == null){
                        System.out.println("Usuário e/ou email inválido(s). Tente novamente.");
                        System.out.println("Digite o nome do usuário: ");
                        uName = sc.nextLine();
                        System.out.println("Digite o email do usuário: ");
                        uMail = sc.nextLine();  
                        user = usuarios.buscaUsuario(uName, uMail);                                          
                    }

                    if(user.getMulta() == false){
                        System.out.println("O usuário não tem multa a ser paga.");
                        break;
                    }else{
                        Boolean inv = user.getInventario();
                        Double valor = user.getValor_multa();
                        System.out.printf("O usuario deve pagar um valor de R$ %.2f\n", valor);
                        System.out.println("Como será o pagamento (Pix, débito, crédito, boleto ou a vista)?");
                        sc.nextLine();
                        System.out.println("Processando...");
                        System.out.println("Pagamento efetuado com sucesso!");
                        user.atualizarStatusEmprestimo(inv, false, 0.0);
                        break;
                    }
                case 8:
                    for(ItemEstoque ie : estoque.getItens()){
                        System.out.println(ie);
                    }

                    break;
                case 9:
                    for(Usuario user1 : usuarios.getLista()){
                        System.out.println(user1);
                    }

                    break;
            }
        }while(op != 0);
        System.out.println("Saindo do sistema...");

        sc.close();
    }
}
