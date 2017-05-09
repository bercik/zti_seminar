package example1;

public class Bank {
	public void transferMoney(int amount) {
		if (amount > 100) throw new RuntimeException("Przekroczono limit");
		System.out.println("Wykonanie przelewu na kwote: " + amount);
	}
}
