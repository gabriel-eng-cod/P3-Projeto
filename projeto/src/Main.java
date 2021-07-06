import java.util.Scanner;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args){

        Empregados empregado = new Empregados();
        //Cartao_de_ponto cartao = new Cartao_de_ponto();

        Scanner input = new Scanner(System.in);

        System.out.println("Bem vindo à Folha de Pagamento");
        System.out.println("==============================");

        while(true)
        {
            System.out.println(" ____________________________________");
            System.out.println("|                                    |");
            System.out.println("|Escolha uma das opções abaixo:      |");
            System.out.println("|1) Adicionar um novo empregado      |");
            System.out.println("|2) Remover um empregado             |");
            System.out.println("|3) Lançar um cartão de ponto        |");
            System.out.println("|4) Lançar um resultado venda        |");
            System.out.println("|5) Lançar uma taxa de serviço       |");
            System.out.println("|6) Alterar detalhes de um empregado |");
            System.out.println("|7) Sair do sistema                  |");
            System.out.println("|8) Listar funcionários              |");
            System.out.println("|____________________________________|\n");

            System.out.printf("-> ");
            int chave = input.nextInt();
            input.nextLine();

            System.out.println();

            if(chave < 1 || chave > 8)
            {
                System.out.println("Insira uma opção válida");
            }
            else
            {
                if(chave == 1)
                {
                    empregado.add_empregado();
                    System.out.println("O funcionário foi adicionado com sucesso!\n");
                }
                else if(chave == 2)
                {
                    empregado.remove_empregado();
                    System.out.println("Funcionário removido com sucesso!\n");
                }
                else if(chave == 3)
                {
                    empregado.add_cartao_de_ponto();
                    System.out.println("Cartão de ponto adicionado com sucesso!\n");
                }
                else if(chave == 4)
                {
                    empregado.add_venda();
                    System.out.println("Venda adicionada com sucesso!\n");
                }
                else if(chave == 5)
                {
                    empregado.add_taxa_de_servico();
                    System.out.println("Taxa de serviço adicionada com sucesso!\n");
                }
                else if(chave == 6)
                {
                    empregado.alterar_info();
                }
                else if(chave == 8)
                {
                    empregado.listar_funcionarios();
                }
                else
                {
                    System.out.println("Tem certeza que deseja sair do sistema?\n\n1) Sair\n2) Continuar navegando\n");

                    System.out.printf("-> ");
                    int saida = input.nextInt();
                    System.out.println();

                    if(saida == 1)
                    {
                        System.out.println("Obrigado por utilizar nosso sistema!\n\n");
                        break;
                    }
                }
            }
        
        }

    }
}
