package concessionaria;

import java.io.IOException;
import java.util.Scanner;

public class SistemaDeConcessionaria {
	private static String inicio;

	public static void main(String[] args) throws IOException {
		try (Scanner ler = new Scanner(System.in)) {
			boolean start = true;

			System.out.println(Cadastros.linha());
			System.out
					.println("\nAntes de iniciar, é necessário definir o diretório onde os dados serão armazenados!\n");
			System.out.println(Cadastros.linha());
			Cadastros.novoCaminho();

			while (start) {
				System.out.println("\n" + Cadastros.linha());
				System.out.println(Cadastros.getCaminho1());
				System.out.println(Cadastros.getCaminho2());
				System.out.println(Cadastros.getCaminho3());
				System.out.println(Cadastros.getCaminho4());
				System.out.println(Cadastros.getCaminho5());
				System.out.println(Cadastros.linha());
				System.out.print("\nDigite a tecla Enter para iniciar:");
				System.out.println("\n" + Cadastros.linha());
				inicio = ler.nextLine();

				Cadastros.clearConsole();
				System.out.println("\n" + Cadastros.linha());
				System.out.println("=== Menu principal ===");
				System.out.println("1. Cadastro de motos");
				System.out.println("2. Cadastro de clientes");
				System.out.println("3. Cadastro de vendedor");
				System.out.println("4. Realizar venda");
				System.out.println("5. Relatório de motos novas");
				System.out.println("6. Relatório de motos usadas");
				System.out.println("7. Relatório de todas as motos");
				System.out.println("8. Relatório de clientes");
				System.out.println("9. Relatório de vendedores");
				System.out.println("10. Relatório de vendas");
				System.out.println("11. Alterar caminho");
				System.out.println("12. Fechar");
				System.out.println(Cadastros.linha());
				System.out.print("\nDigite a opção desejada:");
				int opcao = ler.nextInt();
				while (opcao < 1 || opcao > 12) {
					System.out.print("\nOpção inválida, tente novamente: ");
					opcao = ler.nextInt();
				}
				Cadastros.clearConsole();
				switch (opcao) {
					case 1:
						Cadastros.cadastroMoto();
						break;
					case 2:
						Cadastros.cadastroCliente();
						break;
					case 3:
						Cadastros.cadastroVendedor();
						break;
					case 4:
						Cadastros.RealizarNovaVenda();
						break;
					case 5:
						Cadastros.consultarMotosNovas();
						break;
					case 6:
						Cadastros.consultarMotosUsadas();
						break;
					case 7:
						Cadastros.consultarMotos();
						break;
					case 8:
						Cadastros.consultarCliente();
						break;
					case 9:
						Cadastros.consultarVendedor();
						break;
					case 10:
						Cadastros.consultarVendas();
						break;
					case 11:
						Cadastros.novoCaminho();
						break;
					case 12:
						start = false;
						break;
					default:
						continue;
				}
			}
		}
	}
}
