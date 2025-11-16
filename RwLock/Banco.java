public class Banco {
    public synchronized boolean saque(Conta conta, double valor) {
       double novoSaldo = conta.debitarValor(valor);
        if (novoSaldo == -1)
            return false;
        System.out.println(Thread.currentThread().getName() + " sacou R$ "+valor+". Saldo após saque: R$ "+novoSaldo);
        return true;
    }
}
