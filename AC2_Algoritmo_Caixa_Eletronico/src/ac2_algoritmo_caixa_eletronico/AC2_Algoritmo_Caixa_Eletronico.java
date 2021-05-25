package ac2_algoritmo_caixa_eletronico;

import java.util.Scanner;
public class AC2_Algoritmo_Caixa_Eletronico 
{
    public static void main(String[] args) 
    {
        Scanner ler = new Scanner(System.in);
        
        String cpf = "12345678900", cpfUser;
        long senha = 1020304, senhaUser; //"0" excluido, pq Java entende como se estivesse na base octal
        float saldo = 1000;
        int cont1 = 0;
        boolean cpf_valido = true;
        int opcao_menu;
        boolean opcao = false;
        float deposito;
        float saque;
        boolean auxMenu = false;
        int opcao_final;
        boolean reset = false;
        //Inicio
        while(reset == false){
            System.out.println("---------------------");
            System.out.println("     BEM VINDO!!     ");
            System.out.println("---------------------");
            System.out.println(" ");
            //Colhendo e Validando CPF
            System.out.print("Por favor digite seu CPF (apenas os numeros): ");
            while (cpf_valido == true){
                cpfUser = ler.next();
                if (cpf.equals(cpfUser)){ //Maneira de comparar Strings
                    //Validando senha
                    System.out.print("Senha: ");
                    senhaUser = ler.nextLong();
                    while (senha != senhaUser){ 
                        System.out.println("Senha Incorreta!");
                        cont1++;
                        if (cont1 > 2){
                            System.out.println("Limite de tentativas atingido!!");
                            System.out.println("Conta Bloqueada!");
                        System.exit(0); //comando pra encerrar o sistema
                        } else {
                            System.out.print("Digite a senha novamente: ");
                            senhaUser = ler.nextLong();
                        }
                    }
                    while (auxMenu == false) {
                        //Menu
                        System.out.println("---------------------");
                        System.out.println("        MENU         ");
                        System.out.println("---------------------");
                        System.out.println("1 - Saldo            ");
                        System.out.println("2 - Deposito         ");
                        System.out.println("3 - Saque            ");
                        System.out.println("4 - Sair             ");
                        System.out.println("---------------------");
                        while (opcao == false){
                            System.out.print("Opção: ");
                            opcao_menu = ler.nextInt();
                            if (opcao_menu >= 1 && opcao_menu <= 4){
                                switch (opcao_menu){
                                    case 1: //saldo
                                        System.out.println("Seu saldo é de: R$" + saldo);
                                        opcao = true;
                                        break;
                                    case 2: //Deposito
                                        System.out.print("Digite o valor do deposito: R$");
                                        deposito = ler.nextFloat();
                                        saldo = saldo + deposito;
                                        System.out.println("Saldo Atual: R$" + saldo);
                                        opcao = true;
                                        break;
                                    case 3: //Saque
                                        System.out.print("Digite o valor a ser retirado: R$");
                                        saque = ler.nextFloat();
                                        saldo = saldo - saque;
                                        System.out.println("Saldo Atual: R$" + saldo);
                                        opcao = true;
                                        break;
                                    case 4: //Sair
                                        System.out.println("Obrigado por utilizar nosso sistema.");
                                        opcao = true;
                                        break;
                                }
                            } else {
                                System.out.println("A opção digitada não existe!");
                                System.out.print("Digite novamente: ");
                            }
                        }
                        System.out.println("---------------------");
                        System.out.println("1 - Nova Operação    ");
                        System.out.println("2 - Sair             ");
                        System.out.println("---------------------");
                        System.out.print("Opção: ");
                        opcao_final = ler.nextInt();
                        switch (opcao_final){
                            case 1:
                                opcao = false;
                                System.out.println(" ");
                                break;
                            case 2:
                                auxMenu = true;
                                System.out.println(" ");
                                break;
                        }
                    }
                    auxMenu = false;
                    cpf_valido = false;
                    opcao = false;
                } else {
                    System.out.println("Tela de Acesso nao permitido!!"); //Saida caso CPF invalido
                    System.out.print("Digite o CPF corretamente: ");
                }
            }
            cpf_valido = true;
        }
    }
}
