import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int opcao;
        double valor;
        int conta;
        String dados;
        boolean transacao=true;
        int tipoConta;
        Scanner scanner =new Scanner(System.in);
        Cliente cli1 = new Cliente();
        System.out.println("Digite o nome do Titular da Conta:");
        cli1.setNome(scanner.next());

        

        List<Conta> contas = new ArrayList<Conta>();

        

        while(transacao){
            System.out.println("Escolha a opção que deseja: \n1. Depositar \n2. Transferir \n3. Sacar  \n4. Imprimir Extrato  \n5. Criar nova conta" + //
                                "\n6. Exibir todas as contas \n7. Sair");
            opcao=scanner.nextInt();
            Conta cc = new ContaCorrente(cli1);
            Conta cp = new ContaPoupanca(cli1);
            
            contas.add(cp);
        switch (opcao) {
            case 1:
            System.out.println("Qual conta deseja depositar: \n 1. Conta Corrente \n 2. Conta Poupança \n 3. Voltar");
            conta=scanner.nextInt();
            if(conta==1){
                System.out.println("Qual valor deseja depositar?");
                valor=scanner.nextDouble();
                cc.depositar(valor);
                System.out.println("Valor depositado, seu saldo atual é: "+cc.getSaldo());  
                
            }else if(conta==2){
            System.out.println("Qual valor deseja depositar: ");
            valor=scanner.nextDouble();
            cp.depositar(valor);
            System.out.println("Valor depositado, seu saldo atual é: "+cp.getSaldo()); 
            } else{
                opcao=0;
                System.out.println("Voltando ao Menu Principal");
            }
            
            break;
            case 2:
            System.out.println("Selecione a opção: 1. Transferir da conta Corrente para Poupança \n 2. Tranferir da Conta Poupança para conta corrente \n 3. Transferir da Conta Poupança para outros \n 4. Transferir da Conta Corrente para outros");
            conta=scanner.nextInt();
            if(conta==1){
                System.out.println("Qual valor deseja transferir ?");
                valor=scanner.nextDouble();
                cc.tranferir(valor, cp);
                System.out.println("Valor transferido para conta Poupança: "+cc.getSaldo());
                break;
            }else if(conta==2){
                System.out.println("Qual valor deseja transferir ?");
                valor=scanner.nextDouble();
                cp.tranferir(valor, cc);
                System.out.println("Valor transferido para conta Poupança: "+cp.getSaldo());
                break;
            }else if (conta ==3){
                System.out.println("Digite os dados da conta que deseja transferir"); 
                dados=scanner.next();
                System.out.println("Qual valor deseja transferir ?"); 
                valor=scanner.nextDouble();
                cp.sacar(valor);
                System.out.println("Valor tranferido para conta"+dados+"\n Valor transferido:"+valor);
                break;
            }else if (conta ==4){
                System.out.println("Digite os dados da conta que deseja transferir"); 
                dados=scanner.next();
                System.out.println("Qual valor deseja transferir ?"); 
                valor=scanner.nextDouble();
                cc.sacar(valor);
                System.out.println("Valor tranferido para conta"+dados+"\n Valor transferido:"+valor);
                break;
            }
            case 3:
            System.out.println("Qual conta deseja sacar: 1. Conta Corrente \n 2. Conta Poupança");
            conta=scanner.nextInt();
            if(conta==1){
                System.out.println("Qual valor deseja sacar?");
                valor=scanner.nextDouble();
                cc.sacar(valor);
                System.out.println("Valor sacado da Conta Corrente, seu saldo atual é: "+cc.getSaldo());
                break;
            }else if(conta==2){
            System.out.println("Qual valor deseja depositar: ");
            valor=scanner.nextDouble();
            cp.sacar(valor);
            System.out.println("Valor sacado da Conta Poupança, seu saldo atual é: "+cc.getSaldo());
                break;
            }else{
                System.out.println("Digite uma opção válida. ");
                break;
            }
            case 4: 
            cc.imprimirExtrato();
            cp.imprimirExtrato();
            break;
            case 5:
            System.out.println("Qual conta deseja criar: \n1.Conta Poupança \n2.Conta Corrente");
            tipoConta=scanner.nextInt();
            if(tipoConta==1){
                contas.add(cp);
                System.out.println("Conta Poupança criada com sucesso ");
            }else if (tipoConta==2){
                contas.add(cc);
                System.out.println("Conta Corrente criada com sucesso ");
            }else{
                System.out.println("Digite uma opção valida");
                break;
            }
            break;
            case 6:
            
              System.out.println(contas);
            
            break;
            case 7: 
            System.out.println("Opção Sair selecionada, Até breve ! ");
            transacao=false;
            break; 

            default:
            System.out.println("Digite uma opção válida. ");
            break;
        }
        
    }
    scanner.close();




    }
}
