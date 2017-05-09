package example1;

public aspect SecurityAspect {
	private Security security = new Security();
	
	pointcut authorize() : call( * Bank.transferMoney(..));
	
	before() : authorize() {
		System.out.println("Autoryzacja");
		security.authorise();
	}
}
