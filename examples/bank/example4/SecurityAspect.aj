package example1;

public aspect SecurityAspect {
	private Security clientSecurity = new Security("klient1");
	private Security agentSecurity = new Security("agent1");
	
	pointcut authorizeClient() : call( * Bank.transferMoney(..)) && within (Main);
	
	pointcut authorizeAgent() : call( * Bank.transferMoney(..)) && within (Agent);
	
	before() : authorizeClient() {
		System.out.println("Autoryzacja klienta");
		clientSecurity.authorise();
	}
	
	before() : authorizeAgent() {
		System.out.println("Autoryzacja agenta");
		agentSecurity.authorise();
	}
	
	after() throwing(RuntimeException ex): authorizeAgent() {
			System.out.println("Przekroczono limit");
			agentSecurity.unauthorise();
	}
}
