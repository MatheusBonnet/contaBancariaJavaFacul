package matheusBonnet.com.github;

public class Programa {

	public static void main(String[] args) {

		Conta conta1 = new Conta("123456", "Joao da Silva", 800.00, "PF");
		conta1.deposito(100.0);
		conta1.saque(10000.00);
		
		
		System.out.println("Saldo:" + conta1.getSaldo()); 

	}

}
