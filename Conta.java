package matheusBonnet.com.github;

import java.text.NumberFormat;

public class Conta {

	private String tipoConta;
	private String nome;
	private Double saldo;
	private String numeroConta;
	
	private Integer contadorDeSaques = 0;
	
	public Conta(String tipoConta, String nome, Double saldo, String numeroConta) {		
		this.tipoConta = tipoConta;
		this.nome = nome;
		this.saldo = saldo;
		this.numeroConta = numeroConta;
	}
	
	public void saque(Double saque) {
		if (saque > saldo) {
			System.out.println("Nao permitido saque maior que o valor da conta de " +  getSaldoContaFormatado());			
		}else {
			saldo = saldo - saque;
			if(contadorDeSaques > 3) {
				if(this.tipoConta.equalsIgnoreCase("pj")) {
					Double taxaPj = saldo * 0.02;
					saldo = saldo - (saque- taxaPj);
				}
				Double taxaPf = saldo * 0.01;
				saldo = saldo - (saque - taxaPf);
			}
		 contadorDeSaques++;
		}
	}
	
	public void deposito(Double valor) {
		if(tipoConta.equalsIgnoreCase("pj")) {
			valor -= valor * 0.02;
		} else {
			valor -= valor * 0.01;
		}
		saldo = saldo + valor;
	}
	
	private String getSaldoContaFormatado() {
		NumberFormat numberFormat =  NumberFormat.getCurrencyInstance();
		String moneyString = numberFormat.format(saldo);
		return moneyString;
	}
	
	public void imprimeExtrato() {
		System.out.println(nome + " tem R$" + getSaldoContaFormatado() + " na conta.");
	}

	public String getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}

	public String getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}


}

