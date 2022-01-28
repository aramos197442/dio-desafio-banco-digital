
public class Main {

	public static void main(String[] args) {
/*
 *      Cria cliente Alexandre
 */
		Cliente cliente = new Cliente();
		cliente.setNome("Alexandre");

/*
 *      Cria cliente Cristiane		
 */
		Cliente outroCliente = new Cliente();
		outroCliente.setNome("Cristiane");
		
/*
 *      Cria contas CC e Poupança para Alexandre
 */
		Conta cc = new ContaCorrente(cliente);
		Conta poupanca = new ContaPoupanca(cliente);
		
/*
*       Cria conta CC Cristiane
*/
		Conta outraCC = new ContaCorrente(outroCliente);
		

/*
 *      Deposita $ 1.000,00 para CC de Alexandre e imprime um extrato		
 */
		cc.depositar(1000);
		cc.imprimirExtrato();
		
/*
 *      Transfere $100,00 para conta Poupança de mesma titularidade
 */
		cc.transferir(100, poupanca);
		
/*
 *      Transfere $200,00 para CC de outra titularidade ocasionando cobrança de CPMF
 */
		cc.transferir(200, outraCC);
		
/*
 *      Imprime extratos de todas as contas
 */
		cc.imprimirExtrato();
		poupanca.imprimirExtrato();
		
		outraCC.imprimirExtrato();
	}
}

/*
 * OBS. FINAIS: O ideal seria a verificação de Titularidade por um documento oficial mas para simplificação foi usado 
 * o Nome do Titular.
 * 
 */
