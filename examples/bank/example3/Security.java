package example1;

import java.util.Scanner;

public class Security {
	public Security(String password)
	{
		_password = password;
	}
	public void authorise() {
		if (isAuthorized) return;
		else {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Podaj haslo");
			String password = scanner.nextLine();
			if (password.equals(_password)) {
				isAuthorized = true;
				return;
			}
			else {
				throw new RuntimeException("Zle haslo");
			}
		}
	}
	
	private String _password;
	private boolean isAuthorized = false;
}
