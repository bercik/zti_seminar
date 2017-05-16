package example1;

public aspect SecurityAspect {
	private Security clientSecurity = new Security("klient1");
	private Security agentSecurity = new Security("agent1");

	pointcut authorize(Bank bank, int amount) : call( * Bank.transferMoney(int)) && args(amount) && target(bank);

	before(Bank bank, int amount) : authorize(bank, amount) {
		System.out.println("Autoryzacja: " + bank.getOwner() + " na kwotę: " + amount);
		if (bank.getOwner().equals("klient")) clientSecurity.authorise();
		else if (bank.getOwner().equals("agent")) agentSecurity.authorise();
		else throw new RuntimeException("Nieznany klient");
	}

	void around(Bank bank, int amount) : authorize(bank, amount) {
		try{
			proceed(bank, amount);
		}
		catch (RuntimeException ex) {
			System.out.println("Przekroczono limit");
			agentSecurity.unauthorise();
		}
	}
}
