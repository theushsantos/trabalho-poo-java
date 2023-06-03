package concessionaria;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Consultas {
    /// Define os caminhos que vai consultar as motos
    private static final String ARQUIVO = Cadastros.getCaminho1();
    private static final String ARQUIVO2 = Cadastros.getCaminho2();
    private static final String ARQUIVO3 = Cadastros.getCaminho3();
    private static final String ARQUIVO4 = Cadastros.getCaminho4();
    private static final String ARQUIVO5 = Cadastros.getCaminho5();

    public static String consultarDadosMotoNova() throws IOException {

        System.out.println("\nMotos Nova:\nLocal do arquivo:" + ARQUIVO + "\n");
        StringBuilder dados = new StringBuilder();
        FileReader leitura = new FileReader(ARQUIVO);
        BufferedReader bufferedReader = new BufferedReader(leitura);

        String linha;
        while ((linha = bufferedReader.readLine()) != null) {
            dados.append(linha).append("\n");
        }

        bufferedReader.close();
        leitura.close();

        return dados.toString();
    }

    public static String consultarDadosMotoUsada() throws IOException {
        System.out.println("\nMotos usadas:\nLocal do arquivo:" + ARQUIVO2 + "\n");
        StringBuilder dados = new StringBuilder();
        FileReader leitura = new FileReader(ARQUIVO2);
        BufferedReader bufferedReader = new BufferedReader(leitura);

        String linha;
        while ((linha = bufferedReader.readLine()) != null) {
            dados.append(linha).append("\n");
        }

        bufferedReader.close();
        leitura.close();

        return dados.toString();
    }
    public static String consultarClientes() throws IOException {
        System.out.println("\nLocal do arquivo:" + ARQUIVO3 + "\n");
        StringBuilder dados = new StringBuilder();
        FileReader leitura = new FileReader(ARQUIVO3);
        BufferedReader bufferedReader = new BufferedReader(leitura);

        String linha;
        while ((linha = bufferedReader.readLine()) != null) {
            dados.append(linha).append("\n");
        }

        bufferedReader.close();
        leitura.close();

        return dados.toString();
    }
    public static String consultarVendedor() throws IOException {
        System.out.println("\nLocal do arquivo:" + ARQUIVO4 + "\n");
        StringBuilder dados = new StringBuilder();
        FileReader leitura = new FileReader(ARQUIVO4);
        BufferedReader bufferedReader = new BufferedReader(leitura);

        String linha;
        while ((linha = bufferedReader.readLine()) != null) {
            dados.append(linha).append("\n");
        }

        bufferedReader.close();
        leitura.close();

        return dados.toString();
    }
    public static String consultarVendas() throws IOException {
        System.out.println("\nLocal do arquivo:" + ARQUIVO5 + "\n");
        StringBuilder dados = new StringBuilder();
        FileReader leitura = new FileReader(ARQUIVO5);
        BufferedReader bufferedReader = new BufferedReader(leitura);

        String linha;
        while ((linha = bufferedReader.readLine()) != null) {
            dados.append(linha).append("\n");
        }

        bufferedReader.close();
        leitura.close();

        return dados.toString();
    }
}
