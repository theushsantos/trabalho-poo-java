package concessionaria;

public class Diretorios{
	private final String ARQUIVO;
	private final String ARQUIVO2;
	private final String ARQUIVO3;
	private final String ARQUIVO4;
	private final String ARQUIVO5;

	public Diretorios(String caminho, String caminho2, String caminho3,String caminho4,String caminho5) {
		this.ARQUIVO = caminho;
		this.ARQUIVO2 = caminho2;
		this.ARQUIVO3 = caminho3;
		this.ARQUIVO4 = caminho4;
		this.ARQUIVO5 = caminho5;
	}

	public String getARQUIVO() {
		return this.ARQUIVO;
	}

	public String getARQUIVO2() {
		return this.ARQUIVO2;
	}
	public String getARQUIVO3() {
		return this.ARQUIVO3;
	}
	public String getARQUIVO4() {
		return this.ARQUIVO4;
	}
	public String getARQUIVO5() {
		return this.ARQUIVO5;
	}

}
