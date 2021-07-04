import java.util.Scanner;
import java.util.LinkedList;
import java.util.List;

public class Empregados {
    
    LinkedList<Horista> horista_list = new LinkedList<>();
    int quant_horista = 0;
    LinkedList<Assalariado> assalariado_list = new LinkedList<>();
    int quant_assalariado = 0;
    int id = 1;

    Scanner input = new Scanner(System.in);

    void add_empregado()
    {

        while(true)
        {
            System.out.println("Selecione o tipo de empregado que deseja adicionar");
            System.out.println("==================================================\n");
            System.out.println("1) Horista");
            System.out.println("2) Assalariado\n");

            System.out.printf("-> ");
            int chave = input.nextInt();
            input.nextLine();

            System.out.println();

            if(chave != 1 && chave != 2)
            {
                System.out.println("Escolha uma opção válida!");
            }
            else
            {
                if(chave == 1)
                {
                    add_horista();
                    quant_horista++;
                    break;
                }
                else
                {
                    add_assalariado();
                    quant_assalariado++;
                    break;
                }
            }
        }
    }

    void add_horista()
    {
        String name;
        String endereco;
        double salario_hora;


        System.out.printf("Digite o nome: ");

        name = input.nextLine();

        System.out.println();
        //input.nextLine();

        System.out.printf("Digite o endereço: ");

        endereco = input.nextLine();

        System.out.println();
        //input.nextLine();

        System.out.printf("Digite o salário do funcionário horista: ");

        salario_hora = input.nextDouble();

        System.out.println();
        //input.nextLine();

        //String id_horista = UUID.randomUUID().toString();

        System.out.printf("O ID do funcionário é %d\n", id);

        Horista horis = new Horista(name, endereco, salario_hora, id);

        id++;

        horista_list.add(horis);
    }

    void add_assalariado()
    {
        String name;
        String endereco;
        double salario_assalariado;
        int comissionado;
        double comissao = -1;

        System.out.printf("Digite o nome: ");

        name = input.nextLine();
        //input.nextLine();
        System.out.println();

        System.out.printf("Digite o endereço: ");

        endereco = input.nextLine();
        System.out.println();
        //input.nextLine();

        System.out.printf("Digite o salário do funcionário assalariado: ");

        salario_assalariado = input.nextDouble();
        System.out.println();
        //input.nextLine();

        System.out.println("O funcionário em questão recebe comissão?\n1) Sim\n2) Não\n");

        System.out.printf("-> ");
        comissionado = input.nextInt();
        input.nextLine();
        System.out.println();

        if(comissionado == 1)
        {
            System.out.printf("Digite a comissão do funcionário assalariado: ");
            comissao = input.nextDouble();
            input.nextLine();
            System.out.println();
        }

        //String id_assalariado = UUID.randomUUID().toString();

        System.out.printf("O ID do funcionário é %d\n", id);

        Assalariado assal = new Assalariado(name, endereco, salario_assalariado, comissionado, comissao, id);

        id++;

        assalariado_list.add(assal);
    }

    void listar_funcionarios()
    {
        System.out.println("Funcionários que trabalham como horistas:\n");

        if(quant_horista == 0)
        {
            System.out.println("Vazio");
        }
        else
        {
            for (int i = 0; i < quant_horista; i++) 
            {
                Horista funcionario = horista_list.get(i);

                System.out.printf("Nome: %s\n", funcionario.name);
                System.out.printf("Endereço: %s\n", funcionario.endereco);
                System.out.printf("Salário: %.2f\n", funcionario.salario_hora);
                System.out.printf("ID do funcionário: %s\n\n", funcionario.id);
                System.out.printf("Cartões de pontos do funcionário %s:\n", funcionario.name);
                
                for(Cartao_de_ponto card : funcionario.cartao_list)
                {
                    System.out.printf("Data: %s\n", card.data);
                    System.out.printf("Hora de entrada: %dh\n", card.in);
                    System.out.printf("Hora de saída: %dh\n", card.out);
                    System.out.printf("Horas trabalhadas no dia: %d horas\n", card.horas_trabalhadas);
                    System.out.println();
                }

                System.out.println("===========================");
            }
        }

        System.out.println();

        System.out.println("Funcionários que trabalham como assalariados:\n");

        if(quant_assalariado == 0)
        {
            System.out.println("Vazio");
        }
        else
        {
            for (int i = 0; i < quant_assalariado; i++) 
            {
                Assalariado funcionario = assalariado_list.get(i);

                System.out.printf("Nome: %s\n", funcionario.name);
                System.out.printf("Endereço: %s\n", funcionario.endereco);
                System.out.printf("Salário: %.2f\n", funcionario.salario_assalariado);
                if(funcionario.comissionado == 1)
                {
                    System.out.printf("Comissao: %.2f\n", funcionario.comissao);
                }
                else
                {
                    System.out.printf("O funcionário não possui comissão\n");
                }
                System.out.printf("ID do funcionário: %s\n\n", funcionario.id);
                System.out.printf("Vendas do funcionário %s:\n", funcionario.name);

                for(Resultado_venda vendas : funcionario.venda_list)
                {
                    System.out.printf("Data: %s\n", vendas.date);
                    System.out.printf("Produto vendido: %s\n", vendas.produto);
                    System.out.printf("Valor do produto: %s\n", vendas.valor_do_produto);
                    System.out.println();
                }

                System.out.println("===========================");
            }
        }
        

        System.out.println();
        //Iterator i = horista_list.iterator();
    }

    void remove_empregado()
    {
        System.out.println("Que tipo de funcionário será removido?\n\n1) Horista\n2) Assalariado\n");

        System.out.printf("-> ");
        int escolha = input.nextInt();
        input.nextLine();
        System.out.println();

        System.out.println("Digite o id do funcionário que deseja remover\n");

        System.out.printf("-> ");
        int chave = input.nextInt();
        System.out.println();
        //input.nextLine();

        if(escolha == 1)
        {
            for (Horista funcionario : horista_list)
            {
                if(funcionario.id == chave)
                {
                    horista_list.remove(funcionario);
                    quant_horista--;
                    break;
                }
            }
        }
        else
        {
            for (Assalariado funcionario : assalariado_list) 
            {
                if(funcionario.id == chave)
                {
                    assalariado_list.remove(funcionario);
                    quant_assalariado--;
                    break;
                }
            }
        }
    }

    void add_cartao_de_ponto()
    {
        System.out.printf("Digite o id do funcionário ao qual deseja adicionar um cartão: ");

        int id = input.nextInt();
        input.nextLine();

        System.out.printf("Digite a data do dia trabalhado (DD/MM/AA): ");

        String date = input.nextLine();

        System.out.printf("Digite a hora de entrada (24h): ");
        
        int in = input.nextInt();

        System.out.printf("Digite a hora de saída (24h): ");
        
        int out = input.nextInt();

        Cartao_de_ponto card = new Cartao_de_ponto(in, out, date);

        for (Horista horista : horista_list) 
        {
            if(horista.id == id)
            {
                horista.cartao_list.add(card);
                break;
            }    
        }
        
    }
    
    void add_venda()
    {
        System.out.printf("Digite o id do funcionário ao qual deseja adicionar uma venda: ");

        int id = input.nextInt();
        input.nextLine();

        System.out.printf("Digite a data da venda (DD/MM/AA): ");

        String date = input.nextLine();

        System.out.printf("Digite o nome do produto vendido: ");
        
        String produto = input.nextLine();

        System.out.printf("Digite o valor do produto vendido: ");
        
        double valor = input.nextDouble();

        Resultado_venda venda = new Resultado_venda(produto, valor, date);

        for (Assalariado assalariado : assalariado_list) 
        {
            if(assalariado.id == id)
            {
                assalariado.venda_list.add(venda);
                break;
            }    
        }
    }
}
