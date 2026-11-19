package Aplicacao;
import Entidades.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bem vindo ao sistema Javoteca!");
        int op = 999;


        do{
            System.out.println("Digite a opção desejada: ");
            System.out.printf("1 - Cadastrar usuário%n0 - Sair%n");
            op = sc.nextInt();


        }while(op != 0);
        System.out.println("Saindo do sistema...");

        sc.close();
    }
}
