package imobiliaria;

public class Imovel {

	private String cidade,
				   estado,
				   rua,
				   nume;
	private boolean isPredio;
	private int tamanho;
	private int preco_aluguel, preco_compre;


	public Imovel(String cidade, String estado, String rua, String nume, boolean isPredio, int tamanho, int preco_a, int preco_c) {
		super();
		this.cidade = cidade;
		this.estado = estado;
		this.rua = rua;
		this.nume = nume;
		this.isPredio = isPredio;
		this.tamanho = tamanho;
		this.preco_aluguel = preco_a;
		this.preco_compre = preco_c;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public boolean getIsPredio() {
		return isPredio;
	}

	public void setIsPredio(boolean isPredio) {
		this.isPredio = isPredio;
	}

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public int getPreco_aluguel() {
		return preco_aluguel;
	}

	public void setPreco_aluguel(int preco_aluguel) {
		this.preco_aluguel = preco_aluguel;
	}

	public int getPreco_compre() {
		return preco_compre;
	}

	public void setPreco_compre(int preco_compre) {
		this.preco_compre = preco_compre;
	}

	public void setPredio(boolean isPredio) {
		this.isPredio = isPredio;
	}
	
	
	
	
	
}
