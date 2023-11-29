package usuarios;

public class Cliente extends Usuario{

	private int saldo;
	
	public Cliente(String nome, String telefone, String cpf, int saldo) {
		super(nome, telefone, cpf);
		this.saldo = saldo;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}
	
}
