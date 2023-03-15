package Projeto;

import java.util.ArrayList;
import java.util.Scanner;

public class AgenciaBancaria {
	static Scanner input = new Scanner(System.in);
	static ArrayList<Conta> contas;
	
	public static void main(String[] args) {
		contas = new ArrayList<Conta>();
		operacoes();
	}
	
	public static void operacoes() {
		System.out.println("                                            ");
		System.out.println(" ___________________________________    ");
		System.out.println("|         NOSSA AGÊNCIA             |   ");
		System.out.println("|   SELECIONE A OPERAÇÃO DESEJADA   |   ");
		System.out.println("|¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨|	");
		System.out.println("| OPÇÃO 1 - CRIAR CONTA             |   ");
		System.out.println("| OPÇÃO 2 - DEPOSITAR               |   ");
		System.out.println("| OPÇÃO 3 - SAQUE                   |   ");
		System.out.println("| OPÇÃO 4 - TRANSFERÊNCIA           | 	");
		System.out.println("| OPÇÃO 5 - LISTA DE CONTAS         |	");
		System.out.println("| OPÇÃO 6 - SAIR                    |	");
		System.out.println("|¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨|	");
		System.out.println("|https://github.com/minoru-yamanaka |	");
		System.out.println("|___________________________________|   ");
		
		
		int operacao = input.nextInt();
		
		switch(operacao){
		case 1:
			criarConta();
			break;
		case 2:
			depositar();
			break;
		case 3:
			sacar();
			break;
		case 4:
			transferir();
			break;
		case 5:
			listar();
			break;
		case 6:
			System.out.println(" ___________ ");
			System.out.println("|           |");
			System.out.println("| Obrigado! |");
			System.out.println("|___________|");
			System.exit(0);
			break;
		default:
			System.out.println("Opção inváliada!");
			operacoes();
			break;
		}
	}
	
		public static void criarConta() {
			System.out.println(" _______________ ");
			System.out.println("|               |");
			System.out.println("|Insira o nome: |");
			System.out.println("|_______________|");
			System.out.println("\n ");
			String nome = input.next();
			
			System.out.println(" _______________ ");
			System.out.println("|               |");
			System.out.println("|Insira o Cpf:  |");
			System.out.println("|_______________|");
			System.out.println("\n");
			String cpf = input.next();
			
			System.out.println(" _______________ ");
			System.out.println("|               |");
			System.out.println("|Insira o Email:|");
			System.out.println("|_______________|");
			System.out.println("\n ");
			String email = input.next();
			
			Cliente cliente = new Cliente (nome, cpf, email);
			
			Conta conta = new Conta(cliente);
			
			contas.add(conta);
			System.out.println(" __________________________ ");
			System.out.println("|                          |");
			System.out.println("| Conta criada com sucesso!|");
			System.out.println("|__________________________|");
			System.out.println("");
			
			operacoes();
			 
		}
		
			private static Conta findConta(int numeroConta) {
				Conta conta = null;
				if(contas.size()> 0 ){
					//for(conta.getNumeroConta(): contas) {
					for(Conta c: contas) {
						if(c.getNumeroConta() == numeroConta) {
						conta = c ;
					} 
				}
			}
				return conta;	
	}
			

			public static void depositar() {
				System.out.println(" _________________________ ");
				System.out.println("|                         |");
				System.out.println("| Número da conta:        |");
				System.out.println("|_________________________|");
				int numeroConta = input.nextInt();
				
				Conta conta = findConta(numeroConta);
			if(conta != null) {
				System.out.println(" _____________________________");
				System.out.println("|                             |");
				System.out.println("| Qual valor deseja depositar |");
				System.out.println("|_____________________________|");
				Double valorDeposito = input.nextDouble();
				conta.depositar(valorDeposito);
				System.out.println(" _______________________________");
				System.out.println("|                               |");
				System.out.println("| Valor depositado com sucesso !|");
				System.out.println("|_______________________________|");
				
			}else {
				System.out.println(" _______________________________");
				System.out.println("|                               |");
				System.out.println("| Conta não foi encontrada !    |");
				System.out.println("|_______________________________|");
			}
			operacoes();
		}
			
		public static void sacar() {
			System.out.println(" _____________________________");
			System.out.println("|                             |");
			System.out.println("| Número da conta:            |");
			System.out.println("|_____________________________|");
			int numeroConta = input.nextInt();
			Conta conta = findConta(numeroConta);
			
			if(conta != null) {
				System.out.println(" _____________________________");
				System.out.println("|                             |");
				System.out.println("| Qual valor deseja sacar?    |");
				System.out.println("|_____________________________|");
				Double valorSaque = input.nextDouble();
				conta.sacar(valorSaque);
				//System.out.println("Valor sacado com sucesso!");
			}else {
				System.out.println(" _____________________________");
				System.out.println("|                             |");
				System.out.println("| Conta não foi encontrada !  |");
				System.out.println("|_____________________________|");
			}
			operacoes();	
		}
		public static void transferir() {
			System.out.println(" _____________________________");
			System.out.println("|                             |");
			System.out.println("| Número da conta Remetente:  |");
			System.out.println("|_____________________________|");
			
			int numeroContaRemetente = input.nextInt();
			
			Conta contaRemetente = findConta(numeroContaRemetente);
			
			if(contaRemetente != null) {
				System.out.println(" ______________________________");
				System.out.println("|                              |");
				System.out.println("| Número da conta Destinatário:|");
				System.out.println("|______________________________|");
				int numeroContaDestinatario = input.nextInt();
				
				Conta contaDestinatario = findConta(numeroContaDestinatario);
				
				if(contaDestinatario != null) {
					System.out.println(" ______________________________");
					System.out.println("|                              |");
					System.out.println("| Valor da transferência:      |");
					System.out.println("|______________________________|");
				Double valor = input.nextDouble();
				
				contaRemetente.transferir(contaDestinatario, valor);
			}else {
				System.out.println(" __________________________________________");
				System.out.println("|                                          |");
				System.out.println("| A conta para depósito não foi encontrada:|");
				System.out.println("|__________________________________________|");
			}
		}else {
			System.out.println(" _____________________________________________");
			System.out.println("|                                             |");
			System.out.println("| Conta para transferência não foi encontrada:|");
			System.out.println("|_____________________________________________|");
		}
			operacoes();
	}
		public static void listar() {
			if(contas.size() > 0) {
				for(Conta conta: contas) {
				System.out.println(conta);
			}
				}else {
					System.out.println(" _____________________________");
					System.out.println("|                             |");
					System.out.println("| Não há contas cadastradas!  |");
					System.out.println("|_____________________________|");
			}
			operacoes();
		}
	
		
}
	
