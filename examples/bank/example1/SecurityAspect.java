package example1;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SecurityAspect {
	private Security security = new Security();
	
	@Pointcut("call( * Bank.transferMoney(..))")
	public void authorize() {
		
	}
	
	@Before("authorize()")
	public void beforeAuthorise() {
		System.out.println("Autoryzacja");
		security.authorise();
	}
}
