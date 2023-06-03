package concessionaria;

public abstract class Pessoa {
	private String nome;
	private String estado;
	private String cidade;
	private String endereco;
	private String complemento;
	protected String status;
	private int telefone;
	protected int codigo;
	
	
	// contrutor
	public Pessoa(String nome, String estado, String cidade, String endereco, String complemento,int telefone) {
		super();
		this.nome = nome;
		this.estado = estado;
		this.cidade = cidade;
		this.endereco = endereco;
		this.complemento = complemento;
		this.telefone = telefone;
		this.codigo =0;
	}
	
	/// Getters e Setters
	public String getStatus() {
		return status;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public int getTelefone() {
		return telefone;
	}
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public abstract void setStatus(String sts);
	
}
