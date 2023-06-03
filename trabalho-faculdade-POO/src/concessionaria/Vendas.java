package concessionaria;

import java.io.*;
import java.util.Scanner;

public class Vendas {
		private final String arq_vendas;
	
	    public String getArq_vendas() {
			return arq_vendas;
		}
	    
	    private String nomeVendedor,nomeCliente,cpfCnpj,codMoto;
	    private int codVendedor,codCliente,codigo = 0;
	    private Double valorUnit,valorTot;

	    public Vendas(String caminho) {
	    	this.arq_vendas = caminho;
	    }
	    public Vendas(int codVendedor,String nomeVendedor,int codCliente,String nomeCliente,String cpfCnpj
	    		,String codMoto,Double valorUnit, Double valorTot, String caminho) {
	    	this.arq_vendas = caminho;
	    	this.codVendedor = codVendedor;
	    	this.nomeVendedor = nomeVendedor;
	    	this.codCliente = codCliente;
	    	this.nomeCliente = nomeCliente;
	    	this.cpfCnpj = cpfCnpj;
	    	this.codMoto = codMoto;
	    	this.valorUnit = valorUnit;
	    	this.valorTot = valorTot;
	    	this.obterProximoCodigo();
	    }

	    // Método para obter o valor de uma moto pelo seu código
	    public Double obterValorDaMotoNova(String codigoMoto) {
	        try (BufferedReader br = new BufferedReader(new FileReader(Cadastros.getCaminho1()))) {
	            String linha;
	            while ((linha = br.readLine()) != null) {
	                if (linha.startsWith("Chassi:")) {
	                    String chassi = linha.substring(8).trim();
	                    if (chassi.equals(codigoMoto)) {
	                        while ((linha = br.readLine()) != null) {
	                            if (linha.startsWith("Valor da moto:")) {
	                                String valorString = linha.substring(15).trim();
	                                return Double.parseDouble(valorString.replace("R$", ""));
	                            }
	                        }
	                    }
	                }
	            }
	        } catch (IOException e) {
	            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
	        }
	        return null; // Retornar null caso o código da moto não seja encontrado
	    }
	    
	    public Double obterValorDaMotoUsada(String codigoMoto) {
	        try (BufferedReader br = new BufferedReader(new FileReader(Cadastros.getCaminho2()))) {
	            String linha;
	            while ((linha = br.readLine()) != null) {
	                if (linha.startsWith("Chassi:")) {
	                    String chassi = linha.substring(8).trim();
	                    if (chassi.equals(codigoMoto)) {
	                        while ((linha = br.readLine()) != null) {
	                            if (linha.startsWith("Valor da moto:")) {
	                                String valorString = linha.substring(15).trim();
	                                return Double.parseDouble(valorString.replace("R$", ""));
	                            }
	                        }
	                    }
	                }
	            }
	        } catch (IOException e) {
	            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
	        }
	        return null; // Retornar null caso o código da moto não seja encontrado
	    }
	 // Método para obter o nome e o código de um vendedor pelo seu código
	    public String[] obterNomeEcodigoVendedor(int codigoVendedor) {
	        try (BufferedReader br = new BufferedReader(new FileReader(Cadastros.getCaminho4()))) {
	            String linha;
	            while ((linha = br.readLine()) != null) {
	                if (linha.startsWith("Código:")) {
	                    int codigoExistente = Integer.parseInt(linha.substring(8).trim());
	                    if (codigoExistente == codigoVendedor) {
	                        String[] nomeECodigo = new String[2];
	                        nomeECodigo[0] = br.readLine().substring(6).trim(); // Linha do nome
	                        nomeECodigo[1] = " " + codigoExistente; // Linha do código
	                        return nomeECodigo;
	                    }
	                }
	            }
	        } catch (IOException e) {
	            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
	        }
	        return null; // Retornar null caso o código do vendedor não seja encontrado
	    }
	    
	    // Método para obter o código e o nome do cliente pelo código do cliente
	    public String[] obterCodigoENomeCliente(int codigoCliente) {
	        try (BufferedReader br = new BufferedReader(new FileReader(Cadastros.getCaminho3()))) {
	            String linha;
	            while ((linha = br.readLine()) != null) {
	                if (linha.startsWith("Código:")) {
	                    int codigoExistente = Integer.parseInt(linha.substring(8).trim());
	                    if (codigoExistente == codigoCliente) {
	                        String[] codigoENome = new String[3];
	                        codigoENome[0] = " "+codigoExistente; // Linha do código
	                        codigoENome[1] = br.readLine().substring(9).trim();
	                        codigoENome[2] = br.readLine().substring(6).trim();
	                        // Linha do nome
	                        return codigoENome;
	                    }
	                }
	            }
	        } catch (IOException e) {
	            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
	        }
	        return null; // Retornar null caso o código do cliente não seja encontrado
	    }
	    
	  /// Getters e Setters
		public String getNomeVendedor() {
			return nomeVendedor;
		}
		public void setNomeVendedor(String nomeVendedor) {
			this.nomeVendedor = nomeVendedor;
		}
		public String getNomeCliente() {
			return nomeCliente;
		}
		public void setNomeCliente(String nomeCliente) {
			this.nomeCliente = nomeCliente;
		}
		public String getCpfCnpj() {
			return cpfCnpj;
		}
		public void setCpfCnpj(String cpfCnpj) {
			this.cpfCnpj = cpfCnpj;
		}
		public String getCodMoto() {
			return codMoto;
		}
		public void setCodMoto(String codMoto) {
			this.codMoto = codMoto;
		}
		public int getCodVendedor() {
			return codVendedor;
		}
		public void setCodVendedor(int codVendedor) {
			this.codVendedor = codVendedor;
		}
		public int getCodCliente() {
			return codCliente;
		}
		public void setCodCliente(int codCliente) {
			this.codCliente = codCliente;
		}
		public double getValorUnit() {
			return valorUnit;
		}
		public void setValorUnit(double valorUnit) {
			this.valorUnit = valorUnit;
		}
		public double getValorTot() {
			return valorTot;
		}
		public void setValorTot(double valorTot) {
			this.valorTot = valorTot;
		}
	    
	    /// inserir arquivos do pedido
		public void inserirArquivo() throws IOException {
	        FileWriter insere = new FileWriter(arq_vendas, true);
	        BufferedWriter buffer = new BufferedWriter(insere);
	        buffer.write("Pedido: " + this.getCodigo() +
	                "\nNome do cliente: " +this.getCodCliente() +" - "+ this.getNomeCliente() 
	                		+ "\nVendedor: " + this.getCodVendedor() + " - "+this.getNomeVendedor()
	                		+ "\nChassi da moto: "+ this.getCodMoto() + "\nValor Unitario: "+ this.getValorUnit() 
	                		+ "\nValor Total do pedido: "+ this.getValorTot()+ "\n\n");
	        buffer.newLine();
	        buffer.close();
	        insere.close();
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
	            
				File arquivo = new File(this.arq_vendas);
	            Scanner leitura = new Scanner(arquivo);
	            while (leitura.hasNextLine()) {
	                String linha = leitura.nextLine();
	                if (linha.startsWith("Pedido")) {
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
		public int getCodigo() {
			return codigo;
		}
		public void setCodigo(int codigo) {
			this.codigo = codigo;
		}
	    

	}

