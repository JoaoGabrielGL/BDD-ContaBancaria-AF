/**
 * @author João Gabriel
 * @version 1.0
 * @since release
 */

import static org.junit.Assert.assertEquals;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Conta {
	
	public double Atual;
	
	/**
	 * Metodo que informara o valor do saldo do cliente especial
	 * 
	 * @param valor = valor do saldo em conta
	 * @throws Throwable excecão lançada 
	 */
	
	@Given("^Um cliente especial com saldo atual de -(\\d+) reais$")
	public void um_cliente_especial_com_saldo_atual_de_reais(int valor) throws Throwable {
	    this.Atual=-valor;
	    throw new PendingException();
	}
	
	/**
	 * metodo que ira acionar a atividade de saque da conta do cliente especial, conforme valor informado pelo cliente
	 *  
	 * @param Saque = valor do saque efetuado 
	 * @throws Throwable excecão lançada 
	 */
	
	 @When("^for solicitado um saque no valor de (\\d+) reais$")
	 public void for_solicitado_um_saque_no_valor_de_reais(int Saque) throws Throwable {
		 if (Saque <= Math.abs(Atual)) {
			Atual -= Saque;  
		 }
	 throw new PendingException();
	}
	 
	 /**
	  * metodo que ira receber o valor do saque informado e posteriormente atualizar o valor do saldo do cliente especial
	  * 
	  * @param novoSaldo = saldo atualizado do cliente especial apos o saque realizado 
	  * @throws Throwable excecão lançada
	  */
	 
	@Then("^deve efetuar o saque e atualizar o saldo da conta para -(\\d+) reais$")
	public void deve_efetuar_o_saque_e_atualizar_o_saldo_da_conta_para_reais(int novoSaldo) throws Throwable {
		assertEquals(-novoSaldo, Atual);
    throw new PendingException();
	}
	
	/**
	 * Metodo que informara o valor do saldo do cliente comum
	 * 
	 * @param valor2 = valor do saldo em conta
	 * @throws Throwable excecão lançada 
	 */

	@Given("^Um cliente comum com saldo atual de -(\\d+) reais$")
	public void um_cliente_comum_com_saldo_atual_de_reais(int valor2) throws Throwable {
		this.Atual=-valor2;
	throw new PendingException();
	}
	
	/**
	 * metodo que ira acionar a atividade de saque da conta do cliente comum, conforme valor informado pelo cliente
	 *  
	 * @param Saque2 = valor do saque efetuado 
	 * @throws Throwable excecão lançada 
	 */

	@When("^solicitar um saque de (\\d+) reais$")
	public void solicitar_um_saque_de_reais(int Saque2) throws Throwable {
		if (Saque2 <= Math.abs(Atual)) {
			Atual -= Saque2;}
    throw new PendingException();
	}
	
	 /**
	  * metodo que ira receber o valor do saque informado e posteriormente atualizar o valor do saldo do cliente comum
	  * 
	  * @param novoSaldo = saldo atualizado do cliente especial apos o saque realizado 
	  * @throws Throwable excecão lançada
	  */	
	
	@Then("^não deve efetuar o saque e deve retornar a mensagem Saldo Insuficiente$")
	public void não_deve_efetuar_o_saque_e_deve_retornar_a_mensagem_Saldo_Insuficiente(int novoSaldo2) throws Throwable {
		this.Atual=-novoSaldo2;
		throw new PendingException();
	}
	}