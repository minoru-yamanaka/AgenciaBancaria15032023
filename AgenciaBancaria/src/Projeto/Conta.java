package Projeto;

import utilitario.Util;

public class Conta {

	private int numeroConta;
	private Cliente cliente;
	private Double saldo = 0.0;
	
	private static int contadorDeContas = 1;

	
	public Conta(Cliente cliente) {
		this.numeroConta = contadorDeContas;
		this.cliente = cliente;
		//this.saldo = saldo;
		contadorDeContas +=1;
	}
	
	

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
	public String toString(){
		return    " ________"  +
				"\n|Conta:  | " + this.getNumeroConta()               + 
				"\n|Nome:   | " + this.cliente.getNome()              + 
				"\n|Cpf:    | " + this.cliente.getCpf () 		   	 + 
				"\n|Email:  | " + this.cliente.getEmail()			 + 
				"\n|Saldo:  | " + Util.doubletoString(this.getSaldo())+ 
				"\n|________| "                                       + 
				"\n";
	}
	
	//implementacao 
	
	public void depositar(Double valor) {
		if(valor > 0) {
			setSaldo(getSaldo() + valor);
			System.out.println(" _________________________________");
			System.out.println("|                                 |");
			System.out.println("| Depósito realizado com sucesso! |");
			System.out.println("|_________________________________|");
		}else {
			System.out.println(" ______________________________________");
			System.out.println("|                                      |");
			System.out.println("| Não é possível realizar o depósito ! |");
			System.out.println("|______________________________________|");
		}
	}
	public void sacar(Double valor) {
		/*Se valor for maior que 0 e saldo for maior que valor */
		if (valor > 0 && this.getSaldo() >= valor ){
			setSaldo(getSaldo() - valor);
			System.out.println(" ______________________________");
			System.out.println("|                              |");
			System.out.println("| Saque realizado com sucesso! |");
			System.out.println("|_________ ____________________|");
			System.out.println("");
		}else {
			System.out.println(" __________________________________");
			System.out.println("|                                  |");
			System.out.println("| Não é possível realizar o Saque! |");
			System.out.println("|__________________________________|");
		}
	}
	
	public void transferir(Conta contaParaDeposito, Double valor) {
		if (valor > 0 && this.getSaldo() >= valor ){
			setSaldo(getSaldo() - valor);
			
			contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor;
			System.out.println(" ______________________________________");
			System.out.println("|                                      |");
			System.out.println("| Transferência realizado com sucesso! |");
			System.out.println("|______________________________________|");
		}else{
			System.out.println(" __________________________________________");
			System.out.println("|                                          |");
			System.out.println("| Não é possível realizar a Transferência! |");
			System.out.println("|__________________________________________|");
		}
	}
}
