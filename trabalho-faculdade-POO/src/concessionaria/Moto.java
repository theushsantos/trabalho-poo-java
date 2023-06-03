package concessionaria;

// classe pai dos dois tipos de motos (Usadas e novas)
public abstract class Moto {
	// Atributos
	protected String chassi, marca, modelo, cor;

	protected double kilometragem, kmPorHora, valor;
	protected int anoFabricacao;

	public Moto() {
	}

	// Função que vai gerar o chassi da moto
	public void gerarChassi() {
	}

	// Funções getters e setters
	public String getChassi() {
		return chassi;
	}

	protected void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public double getKilometragem() {
		return kilometragem;
	}

	public void setKilometragem(double kilometragem) {
		this.kilometragem = kilometragem;
	}

	public double getKmPorHora() {
		return kmPorHora;
	}

	public void setKmPorHora(double kmPorHora) {
		this.kmPorHora = kmPorHora;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

}
