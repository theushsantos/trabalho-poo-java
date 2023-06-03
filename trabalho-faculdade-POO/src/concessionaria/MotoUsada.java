package concessionaria;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;

public class MotoUsada extends Moto {

	private String historicoManutencao;
	private final String ARQUIVO2;

	/// Contrutor da classe

	public MotoUsada(String marca, String modelo, String cor, double kilometragem, double kmPorHora, double valor,
			int anoFabricacao, String historico, String arquivo) throws IOException {
		this.marca = marca;
		this.modelo = modelo;
		this.cor = cor;
		this.kilometragem = kilometragem;
		this.kmPorHora = kmPorHora;
		this.valor = valor;
		this.anoFabricacao = anoFabricacao;
		this.gerarChassi();
		this.setHistoricoManutencao(historico);
		this.ARQUIVO2 = arquivo;

	}

	@Override
	public void gerarChassi() {
		while (true) {
			UUID aleatorio = UUID.randomUUID();
			String myRandom = aleatorio.toString();
			String codChassi = myRandom.substring(0, 7).replace("-", "").replace(" ", "").toUpperCase();

			if (!(this.getChassi() == codChassi)) {
				this.setChassi(codChassi);
				break;
			} else {
				continue;
			}
		}
	}

	// Getter e Setter do atributo
	public String getHistoricoManutencao() {
		return historicoManutencao;
	}

	public void setHistoricoManutencao(String historico) {
		if (historico.length() <= 300) {
			this.historicoManutencao = historico;
		} else {
			this.historicoManutencao = historico.substring(0, 300);
		}
	}

	public void inserirArquivo() throws IOException {
		FileWriter insere = new FileWriter(ARQUIVO2, true);
		BufferedWriter buffer = new BufferedWriter(insere);
		buffer.write("Cadastro Moto Usada:\nChassi: " + this.getChassi() + "\nMarca: " + this.getMarca() +
				"\nModelo: " + this.getModelo() + "\nCor: " + this.getCor() + "\nKilômetros rodados: " +
				this.getKilometragem() + "\nKM/H: " + this.getKmPorHora() + "\nAno de Fabricação: " +
				this.getAnoFabricacao() + "\nValor da moto: R$" + this.getValor() + "\nHistórico de Manutenção: " +
				this.getHistoricoManutencao() + "\n\n");
		buffer.close();
		insere.close();
	}

	public String getARQUIVO2() {
		return ARQUIVO2;
	}
	
}
