package Projeto;

public class Cliente {

	private static int counter = 1;
	
	private String nome;
	private String cpf;/*cpf string pois, nao iremos validar*/
	private String email;
	
	/*contrutor*/
	public Cliente(String nome, String cpf, String email) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		counter+= 1; /*recebe toda vez que for criado um cliente*/
	}

	/*get e set*/
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	/*metodo toString*/
	public String toString() {
		return"\nNome: "   + this.getNome() +
			  "\ncpf: "    + this.getCpf()  +
			  "\nemail: "  + this.getEmail();
	}
	
}
