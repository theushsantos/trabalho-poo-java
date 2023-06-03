package concessionaria;

import java.io.*;
import java.util.UUID;

public class MotoNova extends Moto {
    // Declaração da variavel que vai armazenar o diretorio e ao mesmo tempo criar
    // um arquivo txt para armazenar os dados
    private final String ARQUIVO;

    //// Ao criar a classe o construtor vai incluir o novo registro no arquivo
    public MotoNova(String marca, String modelo, String cor, double kmPorHora, double valor, int anoFabricacao,
            String arquivo) {
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.kmPorHora = kmPorHora;
        this.valor = valor;
        this.anoFabricacao = anoFabricacao;
        this.gerarChassi();
        this.ARQUIVO = arquivo;

    }

    // Função que vai gerar o chassi automaticamente
    @Override
    public void gerarChassi() {
        while (true) {
            UUID aleatorio = UUID.randomUUID();
            String codChassi = aleatorio.toString().substring(0, 7).replace("-", "").replace(" ", "").toUpperCase();

            if (!(this.getChassi() == codChassi)) {
                this.setChassi(codChassi);
                break;
            }
        }
    }

    //// Metodo que insere os dados no arquivo
    public void inserirArquivo() throws IOException {

        FileWriter insere = new FileWriter(ARQUIVO, true);
        BufferedWriter buffer = new BufferedWriter(insere);
        buffer.write("\nChassi: " + this.getChassi() + "\nMarca: " + this.getMarca() +
                "\nModelo: " + this.getModelo() + "\nCor: " + this.getCor() + "\nKilômetros rodados: " +
                this.getKilometragem() + "\nKM/H: " + this.getKmPorHora() + "\nAno de Fabricação: " +
                this.getAnoFabricacao() + "\nValor da moto: R$" + this.getValor() + "\n\n");
        buffer.close();
        insere.close();
    }


    public String getArquivo() {
        return ARQUIVO;
    }
    
}
