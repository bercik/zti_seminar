package example1;

public class Main {
	public static void main(String[] args) {
		Bank bank = new Bank();
		bank.transferMoney(100);
		
		Agent agent = new Agent();
		agent.delegateMoneyTransfer(200);
	}
}
