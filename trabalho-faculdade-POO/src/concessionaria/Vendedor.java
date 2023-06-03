package concessionaria;

import java.io.*;
import java.util.Scanner;

public class Vendedor extends Pessoa{
	private final String arq_vendedor;
	private String dataAniversario;
	Scanner leia;

	public Vendedor(String nome, String estado, String cidade, String endereco, String complemento,
			int telefone, String caminho_arq, String data, String sts) {
		super(nome,estado, cidade, endereco, complemento, telefone);
		// TODO Auto-generated constructor stub
		this.dataAniversario = data;
		this.status = sts;
		this.arq_vendedor = caminho_arq;
		this.codigo = obterProximoCodigo();
	}

	@Override
	public void setStatus(String status) {
		this.status = status;
	}
	
	/// Essa parte gera um numero e verigica dentro do arquivo se ele já existe para evitar duplicidade
    public int gerarCodigo() {
        this.setCodigo(this.getCodigo() + 1);
        return this.getCodigo();
    }

    public int obterProximoCodigo() {
        int codigo = gerarCodigo();
        while (verificarCodigoExistente(codigo)) {
            codigo = gerarCodigo();
        }
        return codigo;
    }

    public boolean verificarCodigoExistente(int codigo) {
        try {
            
			File arquivo = new File(arq_vendedor);
            Scanner leitura = new Scanner(arquivo);
            while (leitura.hasNextLine()) {
                String linha = leitura.nextLine();
                if (linha.startsWith("Código")) {
                    int codigoExistente = Integer.parseInt(linha.split(" ")[1]);
                    if (codigoExistente == codigo) {
                        leitura.close();
                        return true;
                    }
                }
            }
            leitura.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado.");
            return false;
        }
        return false;
    }
  /// Inserindo os dados no arquivo
    public void inserirArquivo() throws IOException {
        FileWriter insere = new FileWriter(arq_vendedor, true);
        BufferedWriter buffer = new BufferedWriter(insere);
        buffer.write("Código: " + this.getCodigo() +
                "\nNome: " + this.getNome() + "\nEndereço: " + this.getEndereco() + "\nCidade: " + this.getCidade() + "\nEstado: " + this.getEstado() +
                "\nComplemento: " + this.getComplemento() + "\nTelefone: " + this.getTelefone() +"\nData de aniversario:"+ this.getDataAniversario()+ "\nSituação: " + this.getStatus()+"\n\n");
        buffer.newLine();
        buffer.close();
        insere.close();
    }

	public String getDataAniversario() {
		return dataAniversario;
	}

	public void setDataAniversario(String dataAniversario) {
		this.dataAniversario = dataAniversario;
	}

	public String getArq_vendedor() {
		return arq_vendedor;
	} 
    
}
