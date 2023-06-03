package concessionaria;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Alteracao {
    private static BufferedReader br;
    private static Scanner ler;

    // Método para excluir um cliente do arquivo
    public static void excluir() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        ler = new Scanner(System.in);
        String nomeArquivo = null;
        System.out.println("Qual arquivo deseja alterar:\n1. Cadastros de clientes\n2. Cadastros motos novas\n3. Cadastros motos usadas\n4. Cadastros Vendedores");
        int op = ler.nextInt();
        while (op < 1 || op > 4) {
            System.out.println("Tente novamente:");
            op = ler.nextInt();
        }
        switch (op) {
            case 1:
                nomeArquivo = Cadastros.getCaminho3();
                break;
            case 2:
                nomeArquivo = Cadastros.getCaminho1();
                break;
            case 3:
                nomeArquivo = Cadastros.getCaminho2();
                break;
            case 4:
                nomeArquivo = Cadastros.getCaminho4();
                break;
        }
        File arquivo = new File(nomeArquivo);
        File arquivoTemporario = new File(nomeArquivo + ".tmp");

        BufferedReader reader = new BufferedReader(new FileReader(arquivo));
        BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoTemporario));

        String valor, campo;
        System.out.println("Digite o nome identificador do cadastro que deseja excluir:");
        campo = br.readLine().concat(": ");

        System.out.println("Qual o código identificador:");
        valor = br.readLine().concat(": ");

        String linha;
        boolean codigoEncontrado = false;

        while ((linha = reader.readLine()) != null) {
            // Verifica se a linha contém os dados do cliente a ser excluído
            if (linha.contains(campo + valor)) {
                codigoEncontrado = true;
            } else {
                // Escreve a linha no arquivo temporário
                writer.write(linha);
                writer.newLine();
            }
        }

        reader.close();
        writer.close();

        // Substitui o arquivo original pelo arquivo temporário
        if (codigoEncontrado) {
            if (arquivo.delete()) {
                if (!arquivoTemporario.renameTo(arquivo)) {
                    throw new IOException("Erro ao renomear o arquivo temporário.");
                }
                System.out.println("Dados excluídos com sucesso.");
            } else {
                throw new IOException("Erro ao excluir o cliente.");
            }
        } else {
            System.out.println("Dados não encontrados.");
        }
    }

    // Método para alterar os campos de um cliente no arquivo
    public static void alterar() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        ler = new Scanner(System.in);
        String novoArquivo = null;
        System.out.println("Qual arquivo deseja alterar:\n1. Cadastros de clientes\n2. Cadastros motos novas\n3. Cadastros motos usadas\n4. Cadastros Vendedores");
        int op = ler.nextInt();
        while (op < 1 || op > 4) {
            System.out.println("Tente novamente:");
            op = ler.nextInt();
        }
        switch (op) {
            case 1:
                novoArquivo = Cadastros.getCaminho3();
                break;
            case 2:
                novoArquivo = Cadastros.getCaminho1();
                break;
            case 3:
                novoArquivo = Cadastros.getCaminho2();
                break;
            case 4:
                novoArquivo = Cadastros.getCaminho4();
                break;
        }

        File arquivo = new File(novoArquivo);
        File arquivoTemporario = new File(novoArquivo + ".tmp");

        BufferedReader reader = new BufferedReader(new FileReader(arquivo));
        BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoTemporario));

        String linha;
        boolean encontrado = false;

        String codigo, valor, campo, novoValor;
        System.out.println("Digite o nome identificador do cadastro que deseja alterar:");
        codigo = br.readLine().concat(": ");

        while ((linha = reader.readLine()) != null) {
            // Verifica se a linha contém os dados do cliente a ser alterado
            System.out.println("Qual o código identificador:");
            valor = br.readLine().concat(": ");
            if (linha.contains(codigo + valor)) {
                encontrado = true;
                while (true) {
                    System.out.println("Qual o nome do campo que deseja alterar: ");
                    campo = br.readLine().concat(": ");

                    System.out.println("Qual o valor novo: ");
                    novoValor = br.readLine();
                    writer.write(campo + novoValor);
                    writer.newLine();

                    System.out.println("Deseja continuar alterando? (S/N)");
                    String continuar;
                    continuar = br.readLine();

                    if (continuar.equalsIgnoreCase("N")) {
                        break;
                    }
                }
            } else {
                // Escreve a linha original no arquivo temporário
                writer.write(linha);
                writer.newLine();
            }
        }

        reader.close();
        writer.close();

        // Substitui o arquivo original pelo arquivo temporário
        if (encontrado) {
            if (arquivo.delete()) {
                if (!arquivoTemporario.renameTo(arquivo)) {
                    throw new IOException("Erro ao renomear o arquivo temporário.");
                }
                System.out.println("Dados alterados com sucesso.");
            } else {
                throw new IOException("Erro ao excluir o cliente original.");
            }
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }
}
