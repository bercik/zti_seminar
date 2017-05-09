package example1;

public class Agent {
	public void delegateMoneyTransfer(int amount) {
		Bank bank = new Bank();
		bank.transferMoney(amount);
	}

}
