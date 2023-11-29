package usuarios;

public class Usuario {

	private String nome;
	private String telefone;
	private String cpf;
	
	
	public Usuario(String nome, String telefone, String cpf) {
		this.nome = nome;
		this.telefone = telefone;
		this.cpf = cpf;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	
}
