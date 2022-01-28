
public abstract class Conta implements IConta {
	

	private static final int BANCO_PADRAO = 260;
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;
	private static final double CPMF = 0.0025d;

	protected int banco;
	protected int agencia;
	protected int numero;
	protected double saldo;
	protected double cpmf;
	protected Cliente cliente;

	public Conta(Cliente cliente) {
		this.banco = Conta.BANCO_PADRAO;
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}

	@Override
	public void sacar(double valor) {
		this.saldo -= valor;
	}

	@Override
	public void depositar(double valor) {
		this.saldo += valor;
	}

	@Override
	public void transferir(double valor, Conta contaDestino) {
		this.sacar(valor);
		
//	    Verifica a Titularidade da conta de destino e caso sejam diferentes há a cobrança de CPMF na conta originária da transação.
//      OBS. Verificação por nome dps Titulares para simplificação do exercício.		
		if (this.cliente.getNome() != contaDestino.cliente.getNome()) {
			contaDestino.depositar(valor);
			this.sacar(valor*CPMF);
			this.cpmf += (valor*CPMF);
		}
		else contaDestino.depositar(valor);
	}

	public int getBanco() {
		return banco;
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Banco: %d", this.banco));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
		System.out.println(String.format("CPMF: (%.2f)", this.cpmf));
	}
}
