package example1;

public class Bank {
	public Bank(String owner) {
		_owner = owner;
	}
	public void transferMoney(int amount) {
		if (amount > 100) throw new RuntimeException("Przekroczono limit");
		System.out.println("Wykonanie przelewu na kwote: " + amount);
	}
	
	public String getOwner() {
		return _owner;
	}
	
	private String _owner;
}
