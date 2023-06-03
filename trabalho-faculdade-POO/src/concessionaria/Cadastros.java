package concessionaria;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Cadastros {

	private static Scanner ler;
	
	static String Diretorio;
	static String Diretorio1;
	static String Diretorio2;
	static String Diretorio3;
	static String Diretorio4;
	static String Diretorio5;
	
	static Diretorios caminhos;
	static String sair;
	static BufferedReader br;

	/// Metodo para limpar a tela do console
	public static void clearConsole() {
		try {
			if (System.getProperty("os.name").contains("Windows")) {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} else {
				System.out.print("\033[H\033[2J");
				System.out.flush();
			}
		} catch (Exception ex) {
			// Tratar exceção, se necessário
		}
	}

	/// Função que criada para definir os diretorios necessários para guardar os
	/// arquivos
	public static void novoCaminho() {
		Diretorio = defineDiretorioArquivo();
		clearConsole();
		Diretorio1 = Diretorio.concat("\\\\cad-moto-nova.txt");
		Diretorio2 = Diretorio.concat("\\\\cad-moto-usada.txt");
		Diretorio3 = Diretorio.concat("\\\\cad-cliente.txt");
		Diretorio4 = Diretorio.concat("\\\\cad-vendedor.txt");
		Diretorio5 = Diretorio.concat("\\\\cad-vendas.txt");
		caminhos = new Diretorios(Diretorio1, Diretorio2, Diretorio3, Diretorio4, Diretorio5);
	}

	/// Getters para pegar os arquivos gerados e guardados na classe @Diretorios
	public static String getCaminho1() {
		return caminhos.getARQUIVO();
	}

	public static String getCaminho2() {
		return caminhos.getARQUIVO2();
	}

	public static String getCaminho3() {
		return caminhos.getARQUIVO3();
	}

	public static String getCaminho4() {
		return caminhos.getARQUIVO4();
	}

	public static String getCaminho5() {
		return caminhos.getARQUIVO5();
	}

	/// Metodo que será usado para definir qual será o diretorio dos arquivos

	public static String defineDiretorioArquivo() { 
		ler = new Scanner(System.in);
		System.out.print("Digite qual será o diretorio que vai armazenar os dados: ");
		String diretorioDoArquivo = ler.nextLine().replace("\\", "\\\\");
		System.out.print("Esté sera o caminho de armazenamento:" + diretorioDoArquivo);
		while ((diretorioDoArquivo == null)) {
			clearConsole();
			System.out.println("Não pode ser vazio!");
			diretorioDoArquivo = ler.nextLine().replace("\\", "\\\\");
		}
		return diretorioDoArquivo;

	}

	// Metodo que retorna um linha
	public static String linha() {
		return "-------------------------------------------------";
	}

	// Metodos para consultas utilizando o modolo @Consultas
	public static void consultarMotosNovas() throws IOException {
		String dados = Consultas.consultarDadosMotoNova();
		System.out.println(linha() + "\n5. Relatorio de Motos Novas:\n");
		System.out.println(dados);
		System.out.println("\nClique em qualquer tecla para sair");
		sair = ler.nextLine();
	}

	public static void consultarMotosUsadas() throws IOException {

		String dados = Consultas.consultarDadosMotoUsada();
		System.out.println(linha() + "\n6. Relatorio de Motos Usadas:\n");
		System.out.println(dados);
		System.out.println("\nClique em qualquer tecla para sair");
		sair = ler.nextLine();
	}

	public static void consultarMotos() throws IOException {
		String dados = Consultas.consultarDadosMotoNova();
		String dados2 = Consultas.consultarDadosMotoUsada();

		System.out.println(linha() + "\n7. Relatorio de Todas as motos:\n");
		System.out.println(dados);

		System.out.println(linha());
		System.out.println(dados2);

		System.out.println("\nClique em qualquer tecla para sair");
		sair = ler.nextLine();
	}

	public static void consultarCliente() throws IOException {

		String dados = Consultas.consultarClientes();
		System.out.println(linha() + "\n8. Relatorio de Clientes:\n");
		System.out.println(dados);
		System.out.println("\nClique em qualquer tecla para sair");
		sair = ler.nextLine();
	}

	public static void consultarVendedor() throws IOException {

		String dados = Consultas.consultarVendedor();
		System.out.println(linha() + "\n9. Relatorio de vendedores:\n");
		System.out.println(dados);
		System.out.println("\nClique em qualquer tecla para sair");
		sair = ler.nextLine();
	}

	public static void consultarVendas() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		String dados = Consultas.consultarVendas();
		System.out.println(linha() + "\n10. Relatorio de vendas:\n");
		System.out.println(dados);
		System.out.println("\nClique em qualquer tecla para sair");
		sair = br.readLine();
	}

	// Metodo para cadastro de uma moto nova

	public static void cadastroMoto() throws IOException {
		// String caminho1 = getCaminho1();
		// String caminho2 = getCaminho2();
		System.out.println(getCaminho1() + "\n" + getCaminho2());
		System.out.println("1. Cadastro de motos");
		System.out.println(linha());

		ler = new Scanner(System.in);
		// Loop para cadastro de múltiplas motos
		while (true) {
			String marca;
			// Leitura dos dados da moto
			System.out.print("Digite a marca da moto: ");
			marca = ler.nextLine();

			System.out.print("Digite o modelo da moto: ");
			String modelo = ler.nextLine();

			System.out.print("Digite a cor da moto: ");
			String cor = ler.nextLine();

			System.out.print("Digite o ano de fabricação da moto: ");
			int anoFab = ler.nextInt();
			while (!(anoFab >= 1000 && anoFab <= 2023)) {
				System.out.print("Ops! este ano não é válido, tente novamente: ");
				anoFab = ler.nextInt();
			}

			System.out.print("Digite quantos KM por hora a moto faz: ");
			double kmPorHora = ler.nextDouble();
			while (!(kmPorHora >= 0)) {
				System.out.print("Ops! o valor não pode ser negativo, tente novamente: ");
				kmPorHora = ler.nextDouble();
			}

			System.out.print("Digite o valor de venda da moto: ");
			double valorDaMoto = ler.nextDouble();
			while (!(valorDaMoto >= 0)) {
				System.out.print("Ops! o valor não pode ser negativo, tente novamente: ");
				valorDaMoto = ler.nextDouble();
			}
			clearConsole();
			// Define se a moto é usada ou é nova
			String usada;
			System.out.println("\nEssa moto e usada?S/N");
			usada = (String) ler.nextLine().toUpperCase();
			usada = (String) ler.nextLine().toUpperCase();

			while (!((usada.equals("S") || usada.equals("N")))) {
				clearConsole();
				System.out.print("Ops! valor diferente de S e N, tente novamente:");
				usada = (String) ler.nextLine().toUpperCase();

			}

			if (usada.equals("N")) {
				MotoNova novaMoto = new MotoNova(marca, modelo, cor, kmPorHora, valorDaMoto, anoFab, getCaminho1());
				novaMoto.inserirArquivo();
			} else if (usada.equals("S")) {
				clearConsole();
				System.out.println("Digite uma observação sobre historico da moto(maximo 300 caracteres): ");
				String historico = ler.nextLine();
				System.out.print("Digite quanto KM ja foram rodados: ");
				double kmRodado = ler.nextDouble();
				while (!(kmRodado > 0)) {
					clearConsole();
					System.out.print("Ops! o valor não pode ser zero ou negativo, tente novamente: ");
					kmRodado = ler.nextDouble();
				}
				System.out.println(linha());
				MotoUsada motoUsada = new MotoUsada(marca, modelo, cor, kmPorHora, valorDaMoto, kmRodado, anoFab,
						historico, getCaminho2());
				motoUsada.inserirArquivo();
				clearConsole();

			}

			// Decide se vai continuar cadastrando ou não

			System.out.println(linha());
			System.out.println("\nMoto incluída com sucesso!\n");
			System.out.println(linha());
			System.out.print("Deseja continuar cadastrando? (S/N) ");

			String op = (String) ler.nextLine().toUpperCase().replace(" ", "");

			while (!(op.equals("N") || op.equals("S"))) {
				clearConsole();
				System.out.print("Ops! você digitou um valor diferente de S e N, tente novamente: ");
				op = ler.nextLine().toUpperCase().replace(" ", "");
			}

			System.out.println(linha());

			// Se a resposta for "S", o loop continua e o cadastro de uma nova moto é
			// iniciado
			if (op == "S") {
				continue;
			} else if (op == "N") {
				System.out.println("\nClique em qualquer tecla para sair");
				sair = ler.nextLine();
				break;
			} else {
				/// Se a resposta não for nenhuma ele automaticamente para o laço e retorna ao
				/// menu
				break;
			}
		}
	}

	//// Cadastro de Clientes
	private static String ie, data_aniversario, status;
	private static String cpf_cnpj;
	private static String rg;

	private static void setIe() throws IOException {
		ie = br.readLine().replace(" ", "");
	}

	private static void setCpf_Cnpj(String cpfCnpj) {
		cpf_cnpj = cpfCnpj;
	}

	public static String getIe() {
		return (String) ie;
	}

	public static String getRg() {
		return (String) rg;
	}

	public static void setData_nascimento() throws IOException {
		System.out.println("Informe a data de aniversario(dia/mes/ano):");

		String verificaData = br.readLine();
		while (!(verificaData.length() == 10)) {
			System.out.println("Ops! essa data está em formato diferente de dia/mes/ano, tente novamete: ");
			verificaData = br.readLine();
		}
		data_aniversario = verificaData;
	}

	private static void setRg() throws IOException {
		System.out.print("Digite o seu RG(8 digitos numericos ou 0 - não informar ):");
		String verificaRg = br.readLine().toUpperCase();
		while (!(verificaRg.length() == 8 || verificaRg.equals("0"))) {
			System.out.print("Ops! valores diferentes de 8 digitos ou 0(não informar ), tente novamente:");
			verificaRg = br.readLine().toUpperCase();
		}
		rg = verificaRg;
	}

	public static void setCpf_cnpj() throws IOException {
		System.out.println("Defina se está cadastrando uma pessoa fisica ou jurifica(1 ou 2):");
		System.out.println("1.Pessoa fisica(CPF) \n2.Pessoa Juridica(CNPJ)");
		ler = new Scanner(System.in);
		br = new BufferedReader(new InputStreamReader(System.in));
		int op;
		String valor;
		do {
			op = (int) ler.nextInt();
		} while ((op == 1 && op == 2));

		if (op == 1) {

			System.out.print("Digite o CPF:");
			valor = br.readLine();
			while (!(valor.length() == 11)) {
				System.out.print("Ops! O cpf deve conter 11 digitos, Digite novamete:");
				valor = br.readLine();
			}
			setCpf_Cnpj(valor);

		} else if (op == 2) {

			System.out.print("Digite o CNPJ:");
			valor = br.readLine();

			while (!(valor.length() == 14)) {
				System.out.print("Ops! O CNPJ deve conter 14 digitos, Digite novamete:");
				valor = br.readLine();
			}

			setCpf_Cnpj(valor);

			System.out.print("Digite o IE(Numero/ISENTO):");
			setIe();

			while (!(getIe().length() == 9 || getIe().equals("ISENTO"))) {

				System.out.print("Ops! O IE deve conter 9 digitos ou deve ser ISENTO, Digite novamete:");
				setIe();

			}
		}

	}

	public static void setStatus() {
		System.out.print("informe a situcao desse cadastro:\n1.ativo\n2.inativo\nDigite aqui:");
		int op = ler.nextInt();
		while (!(op == 1 || op == 2)) {
			System.out.print("Ops!Valor diferente de 1 e 2, tente novamente: ");
			op = ler.nextInt();
		}
		if (op == 1) {
			status = "Ativo";
		} else if (op == 2) {
			status = "Inativo";
		}
	}

	public static void cadastroCliente() throws IOException {
		// String caminho1 = getCaminho1();
		// String caminho2 = getCaminho2();
		System.out.println(getCaminho3() + "\n" + getCaminho3());
		System.out.println("2. Cadastro de Cliente");
		System.out.println(linha());

		ler = new Scanner(System.in);
		// Loop para cadastro de múltiplas motos
		while (true) {
			String nome;
			// Leitura dos dados da moto
			System.out.print("Digite o nome do cliente: ");
			nome = (String) ler.nextLine();

			System.out.print("Digite o endereco do cliente: ");
			String endereco = (String) ler.nextLine();

			System.out.print("Digite a cidade do cliente: ");
			String cidade = (String) ler.nextLine();

			System.out.print("Digite o estado do cliente: ");
			String estado = (String) ler.nextLine();

			System.out.print("Digite o complemento do endereço: ");
			String complemento = (String) ler.nextLine();

			System.out.print("Digite o telefone de contato do cliente(9 digitos): ");
			int telefone = (int) ler.nextInt();
			while (telefone < 100000000 || telefone >= 1000000000) {
				System.out.print("ops, valor maior que 9 digitos tente novamente");
				telefone = (int) ler.nextInt();
			}

			clearConsole();
			setCpf_cnpj();
			setRg();
			setData_nascimento();
			setStatus();
			Cliente novoCliente = new Cliente(nome, estado, cidade, endereco, complemento, telefone, getCaminho3(),
					cpf_cnpj, ie, rg, data_aniversario, status);

			novoCliente.inserirArquivo();
			// Decide se vai continuar cadastrando ou não

			System.out.println(linha());
			System.out.println("\nCliente incluída com sucesso!\n");
			System.out.println(linha());
			System.out.print("Deseja continuar cadastrando? (S/N) ");

			String op = (String) br.readLine().toUpperCase().replace(" ", "");

			while (!(op.equals("N") || op.equals("S"))) {
				clearConsole();
				System.out.print("Ops! você digitou um valor diferente de S e N, tente novamente: ");
				op = br.readLine().toUpperCase().replace(" ", "");
			}

			System.out.println(linha());

			// Se a resposta for "S", o loop continua e o cadastro de uma nova moto é
			// iniciado
			if (op == "S") {
				continue;
			} else if (op == "N") {
				System.out.println("\nClique em qualquer tecla para sair");
				sair = br.readLine();
				break;
			} else {
				/// Se a resposta não for nenhuma ele automaticamente para o laço e retorna ao
				/// menu
				break;
			}
		}
	}

	/// Cadastro de vendedor
	public static void cadastroVendedor() throws IOException {
		// String caminho1 = getCaminho1();
		// String caminho2 = getCaminho2();
		System.out.println(getCaminho4() + "\n" + getCaminho4());
		System.out.println("3. Cadastro de Vendedor");
		System.out.println(linha());

		br = new BufferedReader(new InputStreamReader(System.in));
		ler = new Scanner(System.in);
		// Loop para cadastro de múltiplas motos
		while (true) {
			String nome;
			// Leitura dos dados da moto
			System.out.print("Digite o nome do Vendedor: ");
			nome = br.readLine();

			System.out.print("Digite o endereco do Vendedor: ");
			String endereco = br.readLine();

			System.out.print("Digite a cidade do Vendedor: ");
			String cidade = br.readLine();

			System.out.print("Digite o estado do Vendedor: ");
			String estado = br.readLine();

			System.out.print("Digite o complemento do endereço: ");
			String complemento = br.readLine();

			System.out.print("Digite o telefone de contato do Vendedor(9 digitos): ");
			int telefone = (int) ler.nextInt();
			while (telefone < 100000000 || telefone >= 1000000000) {
				System.out.print("ops, valor maior que 9 digitos tente novamente");
				telefone = (int) ler.nextInt();
			}

			clearConsole();
			setData_nascimento();
			setStatus();

			Vendedor novoVendedor = new Vendedor(nome, estado, cidade, endereco, complemento, telefone, getCaminho4(),
					data_aniversario, status);

			novoVendedor.inserirArquivo();
			// Decide se vai continuar cadastrando ou não

			System.out.println(linha());
			System.out.println("\nVendedor incluída com sucesso!\n");
			System.out.println(linha());
			System.out.print("Deseja continuar cadastrando? (S/N) ");

			String op = (String) br.readLine().toUpperCase().replace(" ", "");

			while (!(op.equals("N") || op.equals("S"))) {
				clearConsole();
				System.out.print("Ops! você digitou um valor diferente de S e N, tente novamente: ");
				op = br.readLine().toUpperCase().replace(" ", "");
			}

			System.out.println(linha());

			// Se a resposta for "S", o loop continua e o cadastro de uma nova moto é
			// iniciado
			if (op == "S") {
				continue;
			} else if (op == "N") {
				System.out.println("\nClique em qualquer tecla para sair");
				sair = br.readLine();
				break;
			} else {
				/// Se a resposta não for nenhuma ele automaticamente para o laço e retorna ao
				/// menu
				break;
			}
		}
	}
	//// Realizar Vendas

	private static int codigoVendedor, codigoCliente, quantidade;
	private static Double valorRecebidoMoto;
	private static Double valorTotal;
	private static String nomeCliente, codigoClienteString, codigoMoto, nomeVendedor, codigoVendedorString, cpfCnpj;

	private static void EscolherMotoNova(String codMoto) {
		Vendas novaVenda = new Vendas(getCaminho5());
		codigoMoto = codMoto; // Código da moto a ser pesquisada
		valorRecebidoMoto = novaVenda.obterValorDaMotoNova(codigoMoto);
		while(valorRecebidoMoto == null) {
			valorRecebidoMoto = novaVenda.obterValorDaMotoNova(codigoMoto);
		}
		if (valorRecebidoMoto != null) {
			// Faça o que for necessário com o valor da moto
			System.out.println("Valor da moto " + codigoMoto + ": " + valorRecebidoMoto);
		} else {
			
			System.out.println("Valor não é aceito!");
		}
	}

	private static void EscolherMotoUsada(String codMoto) {
		Vendas novaVenda = new Vendas(getCaminho5());
		codigoMoto = codMoto; // Código da moto a ser pesquisada
		valorRecebidoMoto = novaVenda.obterValorDaMotoUsada(codigoMoto);
		while(valorRecebidoMoto == null) {
			valorRecebidoMoto = novaVenda.obterValorDaMotoUsada(codigoMoto);
		}
		if (valorRecebidoMoto != null) {
			// Faça o que for necessário com o valor da moto
			System.out.println("Valor da moto " + codigoMoto + ": " + valorRecebidoMoto);
		} else {
			System.out.println("Moto não encontrada.");
		}
	}

	private static void EscolheVendedor(int codVendedor) {
		Vendas novaVenda = new Vendas(getCaminho5());
		codigoVendedor = codVendedor; // Código do vendedor a ser pesquisado
		String[] nomeECodigo = novaVenda.obterNomeEcodigoVendedor(codigoVendedor);
		if (nomeECodigo != null) {
			nomeVendedor = nomeECodigo[0];
			codigoVendedorString = nomeECodigo[1];
			// Faça o que for necessário com o nome e o código do vendedor
			System.out.println("Código do vendedor: " + codigoVendedorString);
			System.out.println("Nome do vendedor: " + nomeVendedor);

		} else {
			System.out.println("Vendedor não encontrado.");
		}
	}

	private static void EscolheCliente(int codCliente) {
		Vendas novaVenda = new Vendas(getCaminho5());
		codigoCliente = codCliente; // Código do cliente a ser pesquisado
		String[] codigoENome = novaVenda.obterCodigoENomeCliente(codigoCliente);
		if (codigoENome != null) {
			codigoClienteString = codigoENome[0];
			cpfCnpj = codigoENome[1];
			nomeCliente = codigoENome[2];
			// Faça o que for necessário com o código e o nome do cliente
			System.out.println("Código do cliente: " + codigoClienteString);
			System.out.println("CPF/CNPJ: " + cpfCnpj);
			System.out.println("Nome do cliente: " + nomeCliente);
		} else {
			System.out.println("Cliente não encontrado.");
		}
	}

	public static void RealizarNovaVenda() throws IOException {
		while (true) {

			System.out.println("\n" + linha());
			System.out.println(getCaminho5() + "\n" + getCaminho5());
			System.out.println("\n4. Realizar venda");
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("\n" + linha());

			System.out.print("Código do vendedor: ");
			int codVendedor = ler.nextInt();
			EscolheVendedor(codVendedor);

			System.out.print("\nCódigo do cliente: ");
			int codCliente = ler.nextInt();
			EscolheCliente(codCliente);

			System.out.print("Deseja vender uma moto nova ou usada?\n1. Nova\n2. Usada\nDigite sua opção aqui: ");
			int opcao = ler.nextInt();
			while (!(opcao == 1 || opcao == 2)) {
				System.out.print("Não entendi, digite novamente(1 ou 2):");
				opcao = ler.nextInt();
			}
			if (opcao == 1) {
				System.out.print("qual o chassi da moto escolhida: ");
				String codChassi = br.readLine();

				System.out.print("Digite a quantidade desejada: ");
				quantidade = ler.nextInt();
				while (quantidade <= 0) {
					System.out.print("Quantidade não pode ser menor que 0\nDigite a quantidade desejada novamente: ");
					quantidade = ler.nextInt();
				}

				EscolherMotoNova(codChassi);
			} else if (opcao == 2) {
				System.out.print("qual o chassi da moto escolhida: ");
				String codChassi = br.readLine();
				
				
				System.out.print("Digite a quantidade desejada: ");
				quantidade = ler.nextInt();
				while (quantidade <= 0) {
					System.out.print("Quantidade não pode ser menor que 0\nDigite a quantidade desejada novamente: ");
					quantidade = ler.nextInt();
				}
				EscolherMotoUsada(codChassi);
			}
			valorTotal = (Double) valorRecebidoMoto * quantidade;

			Vendas novaVenda = new Vendas(codVendedor, nomeVendedor, codCliente, nomeCliente, cpfCnpj, codigoMoto,
					valorRecebidoMoto, valorTotal, getCaminho5());
			novaVenda.inserirArquivo();
			int pedido = novaVenda.getCodigo();

			Cadastros.clearConsole();
			System.out.println("\n" + linha());
			System.out.println("Venda realisada com sucesso! Numero do pedido: " + pedido);
			System.out.println("\n" + linha());

			System.out.println("\nDeseja continuar (S/N)");
			String sair = br.readLine().toUpperCase();
			if (sair.equals("S")) {
				Cadastros.clearConsole();
				continue;
			} else if (sair.equals("N")) {
				Cadastros.clearConsole();
				break;
			} else {
				Cadastros.clearConsole();
				break;
			}

		}
	}

}
