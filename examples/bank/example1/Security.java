package example1;

import java.util.Scanner;

public class Security {
	public void authorise() {
		if (isAuthorized) return;
		else {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Podaj haslo");
			String password = scanner.nextLine();
			if (password.equals("tajneHaslo")) {
				return;
			}
			else {
				throw new RuntimeException("Zle haslo");
			}
		}
	}
	
	private boolean isAuthorized = false;
}
