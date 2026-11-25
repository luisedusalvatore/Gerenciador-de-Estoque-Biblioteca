package Persistencia;

import Entidades.Acervos.*;
import Entidades.Emprestimos.*;
import Entidades.Estoques.*;
import Interfaces.SistemaSalvamento;

import java.io.*;
import java.time.Instant;
import java.time.format.DateTimeParseException;

public class SalvamentoCsv implements SistemaSalvamento {
    private static final String ARQ_USUARIOS = "usuarios.csv";
    private static final String ARQ_ESTOQUE = "estoque.csv";
    private static final String ARQ_EMPRESTIMOS = "emprestimos.csv";

    private Estoque estoque;
    private Usuarios usuarios;
    private Emprestimos emprestimos;

    public SalvamentoCsv(Estoque estoque, Usuarios usuarios, Emprestimos emprestimos) {
        this.estoque = estoque;
        this.usuarios = usuarios;
        this.emprestimos = emprestimos;
    }
    private void salvarUsuarios() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(ARQ_USUARIOS))) {
            for (Usuario u : usuarios.getLista()) {
                pw.println(u.getNome() + ";" + u.getEmail() + ";" + u.getDataNascimento() + ";"
                        + u.getInventario() + ";" + u.getMulta() + ";" + u.getValor_multa());
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar usuários: " + e.getMessage());
        }
    }

    private void salvarEstoque() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(ARQ_ESTOQUE))) {
            for (ItemEstoque ie : estoque.getItens()) {
                ItemAcervo a = ie.getItemAcervo();
                String base = a.getTitulo() + ";" + a.getAno() + ";" + a.getDataCadastro() + ";"
                        + ie.getQuantidade() + ";" + ie.getLocalizacao();

                if (a instanceof Livro) {
                    Livro l = (Livro) a;
                    pw.println("LIVRO;" + base + ";" + l.getAutor() + ";" + l.getIsbn() + ";" + l.getPaginas());
                } else if (a instanceof Revista) {
                    Revista r = (Revista) a;
                    pw.println("REVISTA;" + base + ";" + r.getEdicao());
                } else if (a instanceof Dvd) {
                    Dvd d = (Dvd) a;
                    pw.println("DVD;" + base + ";" + d.getDuracaoMinutos());
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar estoque: " + e.getMessage());
        }
    }

    private void salvarEmprestimos() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(ARQ_EMPRESTIMOS))) {
            for (Emprestimo e : emprestimos.getEmprestimos()) {
                pw.println(e.getUsuario().getNome() + ";" + e.getUsuario().getEmail() + ";"
                        + e.getItem().getTitulo() + ";" + e.getDataEmprestimo() + ";"
                        + e.getDataPrevistaDevolucao());
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar empréstimos: " + e.getMessage());
        }
    }
    private void carregarUsuarios() {
        File arquivo = new File(ARQ_USUARIOS);
        if (!arquivo.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            int numero = 0;
            while ((linha = br.readLine()) != null) {
                numero++;
                if (linha.trim().isEmpty()) continue;
                try {
                    String[] c = linha.split(";");
                    Usuario u = new Usuario(c[0], c[1], Instant.parse(c[2]),
                            Boolean.parseBoolean(c[3]), Boolean.parseBoolean(c[4]),
                            Double.parseDouble(c[5]));
                    usuarios.addUsuario(u);
                } catch (ArrayIndexOutOfBoundsException | NumberFormatException | DateTimeParseException ex) {
                    System.out.println("usuarios.csv: linha " + numero + " ignorada (dados inválidos).");
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler " + ARQ_USUARIOS + ": " + e.getMessage());
        }
    }

    private void carregarEstoque() {
        File arquivo = new File(ARQ_ESTOQUE);
        if (!arquivo.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            int numero = 0;
            while ((linha = br.readLine()) != null) {
                numero++;
                if (linha.trim().isEmpty()) continue;
                try {
                    String[] c = linha.split(";");
                    String tipo = c[0];
                    String titulo = c[1];
                    int ano = Integer.parseInt(c[2]);
                    Instant cadastro = Instant.parse(c[3]);
                    int quantidade = Integer.parseInt(c[4]);
                    String localizacao = c[5];

                    ItemAcervo item;
                    if (tipo.equals("LIVRO")) {
                        item = new Livro(titulo, ano, cadastro, c[6], c[7], Integer.parseInt(c[8]));
                    } else if (tipo.equals("REVISTA")) {
                        item = new Revista(titulo, ano, cadastro, Integer.parseInt(c[6]));
                    } else if (tipo.equals("DVD")) {
                        item = new Dvd(titulo, ano, cadastro, Integer.parseInt(c[6]));
                    } else {
                        System.out.println("estoque.csv: linha " + numero + " ignorada (tipo desconhecido).");
                        continue;
                    }
                    estoque.addItem(new ItemEstoque(quantidade, localizacao, item));
                } catch (ArrayIndexOutOfBoundsException | NumberFormatException | DateTimeParseException ex) {
                    System.out.println("estoque.csv: linha " + numero + " ignorada (dados inválidos).");
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler " + ARQ_ESTOQUE + ": " + e.getMessage());
        }
    }

    private void carregarEmprestimos() {
        File arquivo = new File(ARQ_EMPRESTIMOS);
        if (!arquivo.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            int numero = 0;
            while ((linha = br.readLine()) != null) {
                numero++;
                if (linha.trim().isEmpty()) continue;
                try {
                    String[] c = linha.split(";");
                    Usuario u = usuarios.buscaUsuario(c[0], c[1]);
                    ItemEstoque ie = estoque.buscarPorTitulo(c[2]);
                    if (u == null || ie == null) {
                        System.out.println("emprestimos.csv: linha " + numero + " ignorada (usuário ou item não existe mais).");
                        continue;
                    }
                    emprestimos.addEmprestimo(new Emprestimo(u, ie.getItemAcervo(),
                            Instant.parse(c[3]), Instant.parse(c[4])));
                } catch (ArrayIndexOutOfBoundsException | DateTimeParseException ex) {
                    System.out.println("emprestimos.csv: linha " + numero + " ignorada (dados inválidos).");
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler " + ARQ_EMPRESTIMOS + ": " + e.getMessage());
        }
    }


    @Override
    public void Salvar() {
        salvarUsuarios();
        salvarEstoque();
        salvarEmprestimos();
    }

    @Override
    public void Carregar() {
        // ordem importa: empréstimos dependem de usuários e estoque
        carregarUsuarios();
        carregarEstoque();
        carregarEmprestimos();
    }
}