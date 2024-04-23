import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) throws Exception {
        Scanner terminal = new Scanner(System.in);
        
        System.out.println("Por favor, digite o seu nome !");
		String nomeCliente = terminal.nextLine();
        System.out.println("Por favor, digite o número da Agência !");
		String agencia = terminal.nextLine();
        System.out.println("Por favor, digite o número da Conta !");
		int numero=terminal.nextInt();
        System.out.println("Por favor, digite o seu saldo !");
        double saldo=terminal.nextDouble();
        System.out.println( "Olá "+nomeCliente+", obrigado por criar uma conta em nosso banco, sua agência é "+agencia+", conta "+numero+" e seu saldo "+saldo+" já está disponível para saque");
      }
}
