import java.util.Scanner;

import javax.lang.model.util.ElementScanner6;
import javax.xml.validation.Validator;

import java.util.LinkedList;
import java.util.List;

public class Empregados {
    
    LinkedList<Horista> horista_list = new LinkedList<>();
    int quant_horista = 0;
    LinkedList<Assalariado> assalariado_list = new LinkedList<>();
    int quant_assalariado = 0;
    int id = 1;
    int id_sindicato = 1;

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
        double salario_hora, taxa_mensal_sindicato = 0;
        int sindicate, tipo_de_pag;
        boolean is_sindicate = false;

        System.out.println("O funcionário faz parte do sindicato?\n\n1) Sim\n2) Não\n");

        System.out.printf("-> ");
        sindicate = input.nextInt();
        input.nextLine();
        System.out.println();

        if(sindicate == 1)
        {
            is_sindicate = true;
            System.out.println("Qual o valor da taxa mensal do sindicato?\n");

            System.out.printf("-> ");
            taxa_mensal_sindicato = input.nextDouble();
            input.nextLine();
            System.out.println();
        }

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
        input.nextLine();
        System.out.println();

        System.out.printf("Qual o tipo de pagamento?\n\n1) Cheque pelos correios\n2) Cheque em mãos\n3) Depósito em conta bancária\n\n-> ");
        
        int escolha_pag = input.nextInt();

        System.out.printf("O ID do funcionário é %d\n", id);

        //System.out.printf("%s\n", name);

        Horista horis = new Horista(name, endereco, salario_hora, id, is_sindicate, escolha_pag);
        //System.out.printf("%s\n", horis.get_name());

        if(sindicate == 1)
        {
            horis.sindicate(id_sindicato, taxa_mensal_sindicato);
        }

        id++;
        id_sindicato++;

        horista_list.add(horis);
    }

    void add_assalariado()
    {
        String name;
        String endereco;
        double salario_assalariado, taxa_mensal_sindicato = 0;
        int comissionado;
        double comissao = -1;
        int sindicate;
        boolean is_sindicate = false;

        System.out.println("O funcionário faz parte do sindicato?\n\n1) Sim\n2) Não\n");

        System.out.printf("-> ");
        sindicate = input.nextInt();
        input.nextLine();
        System.out.println();

        if(sindicate == 1)
        {
            is_sindicate = true;
            System.out.println("Qual o valor da taxa mensal do sindicato?\n");

            System.out.printf("-> ");
            taxa_mensal_sindicato = input.nextDouble();
            input.nextLine();

            System.out.println();
        }

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

        System.out.println("O funcionário em questão recebe comissão?\n\n1) Sim\n2) Não\n");

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

        System.out.printf("Qual o tipo de pagamento?\n\n1) Cheque pelos correios\n2) Cheque em mãos\n3) Depósito em conta bancária\n\n-> ");
        
        int escolha_pag = input.nextInt();

        System.out.printf("O ID do funcionário é %d\n", id);

        Assalariado assal = new Assalariado(name, endereco, salario_assalariado, comissionado, comissao, id, is_sindicate, escolha_pag);

        id++;

        if(sindicate == 1)
        {
            assal.sindicate(id_sindicato, taxa_mensal_sindicato);
        }

        id_sindicato++;

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

                System.out.printf("Nome: %s\n", funcionario.get_name());
                System.out.printf("Endereço: %s\n", funcionario.get_endereco());
                System.out.printf("Salário: %.2f\n", funcionario.get_salario_hora());
                System.out.printf("ID do funcionário: %s\n", funcionario.get_id());
                System.out.printf("Tipo de pagamento: ");
                if(funcionario.get_escolha_pag() == 1)
                {
                    System.out.printf("Cheque pelos correios\n");
                }
                else if(funcionario.get_escolha_pag() == 2)
                {
                    System.out.printf("Cheque em mãos\n");
                }
                else
                {
                    System.out.printf("Depósito em conta bancária\n");
                }
                System.out.println();

                if(funcionario.get_is_sind())
                {
                    System.out.printf("O funcionário faz parte do sindicato\n");
                    System.out.printf("Taxa mensal do sindicato: %.2f\n", funcionario.get_tx_mensal_sind());
                    System.out.printf("ID do funcionário no sindicato: %d\n\n", funcionario.get_id_sind());
                    System.out.println();
                    System.out.printf("Taxas de serviço do funcionário:\n\n");

                    for(Taxa_de_servico taxa : funcionario.taxa_list)
                    {
                        System.out.printf("Descrição da taxa: %s\n", taxa.descricao);
                        System.out.printf("Valor da taxa: %.2f\n", taxa.valor);
                        System.out.println();
                    }
                }
                else
                {
                    System.out.printf("O funcionário não faz parte do sindicato\n\n");
                }

                System.out.printf("Cartões de pontos do funcionário %s:\n", funcionario.get_name());
                
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
                System.out.printf("ID do funcionário: %s\n", funcionario.id);
                System.out.printf("Tipo de pagamento: ");
                if(funcionario.escolha_pag == 1)
                {
                    System.out.printf("Cheque pelos correios\n");
                }
                else if(funcionario.escolha_pag == 2)
                {
                    System.out.printf("Cheque em mãos\n");
                }
                else
                {
                    System.out.printf("Depósito em conta bancária\n");
                }

                System.out.println();

                if(funcionario.is_sindicate)
                {
                    System.out.printf("O funcionário faz parte do sindicato\n");
                    System.out.printf("Taxa mensal do sindicato: %.2f\n", funcionario.taxa_mensal_sindicato);
                    System.out.printf("ID do funcionário no sindicato: %d\n\n", funcionario.id_sindicato);
                    System.out.println();
                    System.out.printf("Taxas de serviço do funcionário:\n\n");

                    for(Taxa_de_servico taxa : funcionario.taxa_list)
                    {
                        System.out.printf("Descrição da taxa: %s\n", taxa.descricao);
                        System.out.printf("Valor da taxa: %.2f\n", taxa.valor);
                        System.out.println();
                    }
                }
                else
                {
                    System.out.printf("O funcionário não faz parte do sindicato\n\n");
                }

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
                if(funcionario.get_id() == chave)
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

        System.out.println();

        Cartao_de_ponto card = new Cartao_de_ponto(in, out, date);

        for (Horista horista : horista_list) 
        {
            if(horista.get_id() == id)
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

        System.out.println();

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

    void add_taxa_de_servico()
    {
        System.out.printf("Digite o id do funcionário ao qual deseja adicionar uma taxa de serviço: ");

        int id = input.nextInt();
        input.nextLine();

        System.out.println();

        System.out.printf("Descrição para a taxa de serviço:\n\n");

        System.out.printf("-> ");

        String descricao = input.nextLine();
        //input.nextLine();
        System.out.println();

        System.out.printf("Qual o valor da taxa? ");

        double taxa = input.nextDouble();
        input.nextLine();

        System.out.println();

        Taxa_de_servico taxa_de_servico = new Taxa_de_servico(taxa, descricao);

        for (Horista horista : horista_list) 
        {
            if(horista.get_id() == id)
            {
                horista.taxa_list.add(taxa_de_servico);
                return;
            }    
        }

        for (Assalariado assalariado : assalariado_list) 
        {
            if(assalariado.id == id)
            {
                assalariado.taxa_list.add(taxa_de_servico);
                return;
            }    
        }
    }

    void alterar_info()
    {
        System.out.printf("Qual o id do empregado que você deseja alterar os dados? ");

        System.out.printf("-> ");
        int id = input.nextInt();

        System.out.println();

        for (Horista horista : horista_list) 
        {
            if(horista.get_id() == id)
            {
                System.out.printf("O ID informado pertence ao funcionário %s.\n\n", horista.get_name());
                System.out.printf("Qual dado você deseja alterar?\n\n");
                System.out.printf("1) Nome\n");
                System.out.printf("2) Endereço\n");
                System.out.printf("3) Tipo de empregado\n");
                System.out.printf("4) Método de pagamento\n");
                System.out.printf("5) Presença no sindicato\n");
                System.out.printf("6) ID no sindicato\n");
                System.out.printf("7) Taxa sindical\n\n");

                System.out.printf("-> ");
                int escolha = input.nextInt();

                System.out.println();

                alterar(escolha, id, 1);
                return;
            }    
        }

        for (Assalariado assalariado : assalariado_list) 
        {
            if(assalariado.id == id)
            {
                System.out.printf("O ID informado pertence ao funcionário %s.\n\n", assalariado.name);
                System.out.printf("Qual dado você deseja alterar?\n\n");
                System.out.printf("1) Nome\n");
                System.out.printf("2) Endereço\n");
                System.out.printf("3) Tipo de empregado\n");
                System.out.printf("4) Método de pagamento\n");
                System.out.printf("5) Presença no sindicato\n");
                System.out.printf("6) ID no sindicato\n");
                System.out.printf("7) Taxa sindical\n\n");

                System.out.printf("-> ");
                int escolha = input.nextInt();

                System.out.println();

                alterar(escolha, id, 2);
                return;
            }    
        }
    }

    void alterar(int escolha, int id, int hor_ou_ass) //último parâmetro verifica se o funcio. é horista ou assalariado
    {
        //int id_aux;
        if(hor_ou_ass == 1)
        {
            for(int i = 0; i < quant_horista; i++)
            {
                Horista horista = horista_list.get(i);

                if(horista.get_id() == id)
                {
                    if(escolha == 1)
                    {
                        System.out.printf("O nome do funcionário é %s.\n", horista.get_name());

                        horista.alterar_nome(horista_list.get(i));

                        System.out.printf("\nAlteração realizada com sucesso\n\n");
                    }
                    else if(escolha == 2)
                    {
                        System.out.printf("O endereço do funcionário é %s.\n", horista.get_endereco());
                        System.out.printf("Digite um novo endereço: ");

                        horista.alterar_endereco(horista_list.get(i));

                        System.out.printf("\nAlteração realizada com sucesso\n\n");
                    }
                    else if(escolha == 3)
                    {
                        System.out.printf("O funcionário é horista e passará a ser assalariado.\n");
                        System.out.printf("O funcionário receberá comissão?\n1) Sim\n2) Não\n\n-> ");

                        int comi = input.nextInt();

                        if(comi == 1)
                        {
                            System.out.printf("Qual o valor da comissão?\n\n-> ");

                            double valor = input.nextDouble();

                            System.out.printf("Digite o salário do funcionário assalariado\n\n-> ");

                            double salario_assalariado = input.nextDouble();

                            Assalariado assal = new Assalariado(horista.get_name(), horista.get_endereco(), salario_assalariado, 1, valor, horista.get_id(), horista.get_is_sind(), horista.get_escolha_pag());
                            
                            assalariado_list.add(assal);
                        }
                        else
                        {
                            System.out.printf("Digite o salário do funcionário assalariado\n\n-> ");

                            double salario_assalariado = input.nextDouble();

                            Assalariado assal = new Assalariado(horista.get_name(), horista.get_endereco(), salario_assalariado, 2, -1, horista.get_id(), horista.get_is_sind(), horista.get_escolha_pag());
                        
                            assalariado_list.add(assal);
                        }

                        for (int j = 0; j < quant_horista; j++)
                        {
                            Horista func = horista_list.get(i);

                            if(func.get_id() == id)
                            {
                                horista_list.remove(func);
                                quant_horista--;
                                break;
                            }
                        }

                        System.out.printf("\nAlteração realizada com sucesso\n\n");

                    }
                    else if(escolha == 4)
                    {
                        System.out.printf("O método de pagamento do funcionário é ");
                        if(horista.get_escolha_pag() == 1)
                        {
                            System.out.printf("Cheque pelos correios\n\n");
                            System.out.printf("Qual o novo método de pagamento?\n2) Cheque em mãos\n3) Depósito em conta bancária\n");
                        }
                        else if(horista.get_escolha_pag() == 2)
                        {
                            System.out.printf("Cheque em mãos\n\n");
                            System.out.printf("Qual o novo método de pagamento?\n1) Cheque pelos correios\n3) Depósito em conta bancária\n");
                        }
                        else
                        {
                            System.out.printf("Depósito pelos correios\n\n");
                            System.out.printf("Qual o novo método de pagamento?\n1) Cheque pelos correios\n3) Cheque em mãos\n");
                        }

                        horista.alterar_meth_pag(horista_list.get(i));

                        System.out.printf("\nAlteração realizada com sucesso\n\n");
                    }
                    else if(escolha == 5)
                    {
                        if(horista.get_is_sind())
                        {
                            System.out.printf("O funcionário pertencia ao sindicato e agora não pertence mais.\n");
                            horista.alterar_is_sind(horista_list.get(i));
                        }
                        else
                        {
                            System.out.printf("O funcionário não pertencia ao sindicato e agora pertence.\n");
                            horista.alterar_is_sind(horista_list.get(i));
                            id_sindicato++;
                        }

                        System.out.printf("\nAlteração realizada com sucesso\n\n");
                    }
                    else if(escolha == 6)
                    {
                        System.out.printf("O ID do funcionário no sindicato é %d.\n", horista.get_id_sind());
                        horista.alterar_id_sind(horista_list.get(i));
                        System.out.printf("\nAlteração realizada com sucesso\n\n");
                    }
                    else
                    {
                        System.out.printf("A taxa mensal do funcionário no sindicato é %.2f.\n", horista.get_tx_mensal_sind());
                        horista.alterar_taxa(horista_list.get(i));
                        System.out.printf("\nAlteração realizada com sucesso\n\n");
                    }
                }
            }       

        }
        else
        {
            for(Assalariado assalariado : assalariado_list)
            {
                if(assalariado.id == id)
                {
                    if(escolha == 1)
                    {
                        System.out.printf("O nome do funcionário é %s.\n", assalariado.name);
                        System.out.printf("Digite um novo nome: ");

                        String new_name = input.nextLine();

                        assalariado.name = new_name;

                        System.out.printf("\nAlteração realizada com sucesso\n\n");
                    }
                    else if(escolha == 2)
                    {
                        System.out.printf("O endereço do funcionário é %s.\n", assalariado.endereco);
                        System.out.printf("Digite um novo endereço: ");

                        String new_endereco = input.nextLine();

                        assalariado.endereco = new_endereco;

                        System.out.printf("\nAlteração realizada com sucesso\n\n");
                    }
                    else if(escolha == 3)
                    {
                        System.out.printf("O funcionário é assalariado e passará a ser horista.\n");

                        System.out.printf("Digite o salário do funcionário horista\n\n-> ");

                        double salario_horista = input.nextDouble();

                        Horista horis = new Horista(assalariado.name, assalariado.endereco, salario_horista, id, assalariado.is_sindicate, assalariado.escolha_pag);
                            
                        horista_list.add(horis);
                    

                        for (Assalariado funcionario : assalariado_list)
                        {
                            if(funcionario.id == id)
                            {
                                assalariado_list.remove(funcionario);
                                quant_assalariado--;
                                break;
                            }
                        }

                        System.out.printf("\nAlteração realizada com sucesso\n\n");

                    }
                    else if(escolha == 4)
                    {
                        System.out.printf("O método de pagamento do funcionário é ");
                        if(assalariado.escolha_pag == 1)
                        {
                            System.out.printf("Cheque pelos correios\n\n");
                            System.out.printf("Qual o novo método de pagamento?\n2) Cheque em mãos\n3) Depósito em conta bancária\n");
                        }
                        else if(assalariado.escolha_pag == 2)
                        {
                            System.out.printf("Cheque em mãos\n\n");
                            System.out.printf("Qual o novo método de pagamento?\n1) Cheque pelos correios\n3) Depósito em conta bancária\n");
                        }
                        else
                        {
                            System.out.printf("Depósito pelos correios\n\n");
                            System.out.printf("Qual o novo método de pagamento?\n1) Cheque pelos correios\n3) Cheque em mãos\n");
                        }

                        int new_meth = input.nextInt();

                        assalariado.escolha_pag = new_meth;

                        System.out.printf("\nAlteração realizada com sucesso\n\n");
                    }
                    else if(escolha == 5)
                    {
                        if(assalariado.is_sindicate)
                        {
                            System.out.printf("O funcionário pertencia ao sindicato e agora não pertence mais.\n");
                            assalariado.is_sindicate = false;
                        }
                        else
                        {
                            System.out.printf("O funcionário não pertencia ao sindicato e agora pertence.\n");
                            assalariado.is_sindicate = true;

                            System.out.printf("Qual a taxa mensal do sindicato?\n\n-> ");
                            
                            double taxa_mensal_sindicato = input.nextDouble();

                            assalariado.sindicate(id_sindicato, taxa_mensal_sindicato);
                            id_sindicato++;
                        }

                        System.out.printf("\nAlteração realizada com sucesso\n\n");
                    }
                    else if(escolha == 6)
                    {
                        System.out.printf("O ID do funcionário no sindicato é %d.\n", assalariado.id_sindicato);
                        System.out.printf("Digite o novo ID: ");
                        int new_id = input.nextInt();
                        assalariado.id_sindicato = new_id;
                        System.out.printf("\nAlteração realizada com sucesso\n\n");
                    }
                    else
                    {
                        System.out.printf("A taxa mensal do funcionário no sindicato é %.2f.\n", assalariado.taxa_mensal_sindicato);
                        System.out.printf("Digite a nova taxa sindical: ");
                        double new_taxa = input.nextDouble();
                        assalariado.taxa_mensal_sindicato = new_taxa;
                        System.out.printf("\nAlteração realizada com sucesso\n\n");
                    }
                }
            }
        }
        
    }
}
