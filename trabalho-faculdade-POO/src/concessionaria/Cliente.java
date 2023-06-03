package concessionaria;

import java.io.*;
import java.util.Scanner;


public class Cliente extends Pessoa{
	
	private String cpf_cnpj, ie, rg;
	private String data_nascimento;
	private Scanner leia;
	private final String arq_cliente;

	
	//Construtor
	
	
	public Cliente(String nome, String estado, String cidade, String endereco, String complemento,
			int telefone, String insere_caminho,String cpf_cnpj,String ie,String rg,String data, String status){
		super(nome, estado, cidade, endereco, complemento, telefone);
		// TODO Auto-generated constructor stub
		this.status = status;
		this.data_nascimento = data;
		this.arq_cliente = insere_caminho;
		this.cpf_cnpj = cpf_cnpj;
		this.ie = ie;
		this.rg = rg;
		this.obterProximoCodigo();
		
	}

	/// Inserindo os dados no arquivo
    public void inserirArquivo() throws IOException {
        FileWriter insere = new FileWriter(arq_cliente, true);
        BufferedWriter buffer = new BufferedWriter(insere);
        buffer.write("Código: " + this.getCodigo() + "\nCNPJ/CPF: " + this.getCpf_cnpj() +
                "\nNome: " + this.getNome() + "\nEndereço: " + this.getEndereco() + "\nIE: " +
                this.getIe() + "\nRG: " + this.getRg() + "\nData de Aniversário: " +
                this.getData_nascimento() + "\nCidade: " + this.getCidade() + "\nEstado: " + this.getEstado() +
                "\nComplemento: " + this.getComplemento() + "\nTelefone: " + this.getTelefone() + "\nSituação: " 
                + this.getStatus()+"\n\n");
        buffer.newLine();
        buffer.close();
        insere.close();
    }
	/// Essa parte gera um numero e verigica dentro do arquivo se ele já existe para evitar duplicidade
    public int gerarCodigo() {
        this.setCodigo(this.getCodigo() + 1);
        return this.getCodigo();
    }

    public void obterProximoCodigo(){
        int codigo = gerarCodigo();
        try {
			while (verificarCodigoExistente(codigo)){
			    codigo = gerarCodigo();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        this.codigo = codigo;
    }

    public boolean verificarCodigoExistente(int codigo)throws IOException{
       
            File arquivo = new File(this.arq_cliente);
            leia = new Scanner(arquivo);
            while (leia.hasNextLine()) {
                String linha = leia.nextLine();
                if (linha.startsWith("Código")) {
                    int codigoExistente = Integer.parseInt(linha.split(" ")[1]);
                    if (codigoExistente == codigo) {
                        leia.close();
                        return true;
                    }
                }
            }
            leia.close();
     
        return false;
    }
    
	///Getters e Setters
	public String getIe() {
		return ie;
	}


	public String getData_nascimento() {
		return data_nascimento;
	}
	
	public String getCpf_cnpj() {		
		return cpf_cnpj;
	}
	
	
	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getArq_cliente() {
		return arq_cliente;
	}

	public void setCpf_cnpj(String cpf_cnpj) {
		this.cpf_cnpj = cpf_cnpj;
	}

	public void setIe(String ie) {
		this.ie = ie;
	}

	public void setData_nascimento(String data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	@Override
	public void setStatus(String status) {
		// TODO Auto-generated method stub
		this.status = status;
	}

}


