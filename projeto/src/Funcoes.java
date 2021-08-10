import java.time.LocalDate;
import java.util.Calendar;
import java.util.Scanner;
import java.util.LinkedList;

public class Funcoes implements Cloneable{
    
    LinkedList<Horista> horista_list = new LinkedList<>();
    //LinkedList<Horista> horista_list_aux = new LinkedList<>();
    int quant_horista = 0;

    LinkedList<Assalariado> assalariado_list = new LinkedList<>();
    LinkedList<Assalariado> assalariado_list_aux = new LinkedList<>();
    int quant_assalariado = 0;

    Agenda_Pagamento agenda = new Agenda_Pagamento();

    Historico auxiliares = new Historico();

    int id = 1;
    int id_sindicato = 2;

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

            auxiliares.adicionado = chave;

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
        String name, metodo_pag;
        String endereco;
        double salario_hora, taxa_mensal_sindicato = 0;
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

        System.out.printf("Qual o forma de pagamento que o funcionário irá receber?\n\n");

        agenda.listar();

        System.out.println("\n->");

        int escolha_agenda = input.nextInt();
        input.nextLine();

        int i;

        for(i = 0; i < agenda.formas_pagamento.size(); i++)
        {
            if(escolha_agenda == i+1)
            {
                break;
            }
        }

        metodo_pag = agenda.formas_pagamento.get(i);

        System.out.printf("Qual o tipo de pagamento?\n\n1) Cheque pelos correios\n2) Cheque em mãos\n3) Depósito em conta bancária\n\n-> ");
        
        int escolha_pag = input.nextInt();

        System.out.printf("O ID do funcionário é %d\n", id);

        Horista horis = new Horista(name, endereco, salario_hora, id, is_sindicate, escolha_pag, metodo_pag);

        if(sindicate == 1)
        {
            horis.sindicate(id_sindicato, taxa_mensal_sindicato);
        }

        id++;
        id_sindicato++;

        horista_list.add(horis);
        //horista_list_aux.add(horis);
        auxiliares.horis = horis;
    }

    void add_assalariado()
    {
        String name;
        String metodo_pag;
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

        System.out.printf("\nQual o forma de pagamento que o funcionário irá receber?\n\n");

        agenda.listar();

        System.out.printf("\n-> ");

        int escolha_agenda = input.nextInt();
        input.nextLine();

        int i;

        for(i = 0; i < agenda.formas_pagamento.size(); i++)
        {
            if(escolha_agenda == i+1)
            {
                break;
            }
        }

        metodo_pag = agenda.formas_pagamento.get(i);

        System.out.printf("Qual o tipo de pagamento?\n\n1) Cheque pelos correios\n2) Cheque em mãos\n3) Depósito em conta bancária\n\n-> ");
        
        int escolha_pag = input.nextInt();

        System.out.printf("O ID do funcionário é %d\n", id);

        Assalariado assal = new Assalariado(name, endereco, salario_assalariado, comissionado, comissao, id, is_sindicate, escolha_pag, metodo_pag);

        id++;

        if(sindicate == 1)
        {
            assal.sindicate(id_sindicato, taxa_mensal_sindicato);
        }

        id_sindicato++;

        assalariado_list.add(assal);
        assalariado_list_aux.add(assal);
        auxiliares.assal = assal;
    }

    void listar_funcionarios()
    {
        System.out.println("Funcionários que trabalham como horistas:\n");

        if(horista_list.size() == 0)
        {
            System.out.println("Vazio");
        }
        else
        {
            for (int i = 0; i < horista_list.size(); i++) 
            {
                Horista funcionario = horista_list.get(i);

                System.out.printf("Nome: %s\n", funcionario.name);
                System.out.printf("Endereço: %s\n", funcionario.endereco);
                System.out.printf("Salário: %.2f\n", funcionario.salario_hora);
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

        if(assalariado_list.size() == 0)
        {
            System.out.println("Vazio");
        }
        else
        {
            for (int i = 0; i < assalariado_list.size(); i++) 
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
    }

    void remove_empregado()
    {
        System.out.println("Que tipo de funcionário será removido?\n\n1) Horista\n2) Assalariado\n");

        System.out.printf("-> ");
        int escolha = input.nextInt();
        input.nextLine();
        System.out.println();

        auxiliares.removido = escolha;

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
                    auxiliares.horis = funcionario;
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
                    auxiliares.assal = funcionario;
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

        auxiliares.id_card = id;

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
            if(horista.id == id)
            {
                horista.cartao_list.add(card);
                break;
            }    
        }

        auxiliares.card = card;
    }
    
    void add_venda()
    {
        System.out.printf("Digite o id do funcionário ao qual deseja adicionar uma venda: ");

        int id = input.nextInt();
        input.nextLine();

        auxiliares.id_venda = id;

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

        auxiliares.sale = venda;
    }

    void add_taxa_de_servico()
    {
        System.out.printf("Digite o id do funcionário ao qual deseja adicionar uma taxa de serviço: ");

        int id = input.nextInt();
        input.nextLine();

        auxiliares.id_taxa = id;

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
            if(horista.id == id)
            {
                horista.taxa_list.add(taxa_de_servico);
                auxiliares.taxa_assalariado = taxa_de_servico;
                return;
            }    
        }

        for (Assalariado assalariado : assalariado_list) 
        {
            if(assalariado.id == id)
            {
                assalariado.taxa_list.add(taxa_de_servico);
                auxiliares.taxa_horista = taxa_de_servico;
                return;
            }    
        }
    }

    void alterar_info() //throws CloneNotSupportedException
    {
        System.out.printf("Qual o id do empregado que você deseja alterar os dados? ");

        System.out.printf("-> ");
        int id = input.nextInt();
        
        auxiliares.id_alteracao = id;

        System.out.println();

        for (Horista horista : horista_list) 
        {
            if(horista.id == id)
            {
                //auxiliares.horis = horista;
                auxiliares.horis_ou_assal = 1;
                System.out.printf("O ID informado pertence ao funcionário %s.\n\n", horista.name);
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

                auxiliares.escolha_alteracao = escolha;

                System.out.println();

                alterar(escolha, id, 1);
                id++;
                return;
            }    
        }

        for (Assalariado assalariado : assalariado_list) 
        {
            if(assalariado.id == id)
            {
                auxiliares.assal = assalariado;
                auxiliares.horis_ou_assal = 2;
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

                auxiliares.escolha_alteracao = escolha;

                System.out.println();

                alterar(escolha, id, 2);
                id++;
                return;
            }    
        }
    }

    void alterar(int escolha, int id, int hor_ou_ass) //último parâmetro verifica se o funcio. é horista ou assalariado
    {
        if(hor_ou_ass == 1)
        {
            for(Horista horista : horista_list)
            {
                if(horista.id == id)
                {
                    if(escolha == 1)
                    {
                        System.out.printf("O nome do funcionário é %s.\n", horista.name);

                        auxiliares.nome = horista.name;

                        horista.alterar_nome(horista);

                        auxiliares.nome_alterado = horista.name;

                        System.out.printf("\nAlteração realizada com sucesso\n\n");
                    }
                    else if(escolha == 2)
                    {
                        System.out.printf("O endereço do funcionário é %s.\n", horista.endereco);

                        auxiliares.endereco = horista.endereco;

                        horista.alterar_endereco(horista);

                        auxiliares.endereco_alterado = horista.endereco;

                        System.out.printf("\nAlteração realizada com sucesso\n\n");
                    }
                    else if(escolha == 3)
                    {
                        auxiliares.horis = horista;
                        System.out.printf("O funcionário é horista e passará a ser assalariado.\n\n");
                        System.out.printf("O funcionário receberá comissão?\n1) Sim\n2) Não\n\n-> ");

                        int comi = input.nextInt();

                        double valor_comissao = 0;

                        if(comi == 1)
                        {
                            System.out.printf("Qual o valor da comissão?\n\n-> ");

                            valor_comissao = input.nextDouble();
                        }
                        
                        System.out.printf("Digite o salário do funcionário assalariado\n\n-> ");

                        double salario_assalariado = input.nextDouble();

                        Assalariado novo = new Assalariado(horista.name, horista.endereco, salario_assalariado, comi, valor_comissao, horista.id, horista.is_sindicate, horista.escolha_pag, horista.metodo_pag);
                        
                        if(horista.is_sindicate)
                        {
                            novo.sindicate(horista.id_sindicato, horista.taxa_mensal_sindicato);
                        }

                        //id++;

                        id_sindicato++;

                        assalariado_list.add(novo);
                        
                        quant_assalariado++;
                        

                        for(int k = 0; k < quant_horista; k++)
                        {
                            Assalariado assalariado = assalariado_list.get(k);

                            if(assalariado.id == novo.id)
                            {
                                for(Taxa_de_servico taxa : horista.taxa_list)
                                {
                                    novo.taxa_list.add(taxa);
                                }
                            }
                        }

                        auxiliares.assal = novo;

                        for (int j = 0; j < quant_horista; j++)
                        {
                            Horista func = horista_list.get(j);

                            if(func.id == id)
                            {
                                System.out.printf("ENTREI NESSA PORRA");
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
                        auxiliares.escolha_pag = horista.escolha_pag;
                        if(horista.escolha_pag == 1)
                        {
                            System.out.printf("Cheque pelos correios\n\n");
                            System.out.printf("Qual o novo método de pagamento?\n2) Cheque em mãos\n3) Depósito em conta bancária\n");
                        }
                        else if(horista.escolha_pag == 2)
                        {
                            System.out.printf("Cheque em mãos\n\n");
                            System.out.printf("Qual o novo método de pagamento?\n1) Cheque pelos correios\n3) Depósito em conta bancária\n");
                        }
                        else
                        {
                            System.out.printf("Depósito pelos correios\n\n");
                            System.out.printf("Qual o novo método de pagamento?\n1) Cheque pelos correios\n3) Cheque em mãos\n");
                        }

                        horista.alterar_meth_pag(horista);

                        auxiliares.escolha_pag_alterada = horista.escolha_pag;

                        System.out.printf("\nAlteração realizada com sucesso\n\n");
                    }
                    else if(escolha == 5)
                    {
                        auxiliares.is_sindicate = horista.is_sindicate;

                        if(horista.is_sindicate)
                        {
                            System.out.printf("O funcionário pertencia ao sindicato e agora não pertence mais.\n");
                            horista.alterar_is_sind(horista);
                        }
                        else
                        {
                            System.out.printf("O funcionário não pertencia ao sindicato e agora pertence.\n");
                            horista.alterar_is_sind(horista);
                            id_sindicato++;
                        }

                        auxiliares.is_sindicate_alterado = horista.is_sindicate;

                        System.out.printf("\nAlteração realizada com sucesso\n\n");
                    }
                    else if(escolha == 6)
                    {
                        auxiliares.id_sindicato = horista.id_sindicato;
                        System.out.printf("O ID do funcionário no sindicato é %d.\n", horista.id_sindicato);
                        horista.alterar_id_sind(horista);
                        auxiliares.id_sindicato_alterado = horista.id_sindicato;
                        System.out.printf("\nAlteração realizada com sucesso\n\n");
                    }
                    else
                    {
                        auxiliares.taxa_sindical = horista.taxa_mensal_sindicato;
                        System.out.printf("A taxa mensal do funcionário no sindicato é %.2f.\n", horista.taxa_mensal_sindicato);
                        horista.alterar_taxa(horista);
                        auxiliares.taxa_sindical_alterada = horista.taxa_mensal_sindicato;
                        System.out.printf("\nAlteração realizada com sucesso\n\n");
                    }

                    break;
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
                        auxiliares.nome = assalariado.name;
                        System.out.printf("O nome do funcionário é %s.\n", assalariado.name);
                        
                        assalariado.alterar_nome(assalariado);

                        auxiliares.nome_alterado = assalariado.name;

                        System.out.printf("\nAlteração realizada com sucesso\n\n");
                    }
                    else if(escolha == 2)
                    {
                        auxiliares.endereco = assalariado.endereco;
                        System.out.printf("O endereço do funcionário é %s.\n", assalariado.endereco);

                        assalariado.alterar_endereco(assalariado);

                        auxiliares.endereco_alterado = assalariado.endereco;

                        System.out.printf("\nAlteração realizada com sucesso\n\n");
                    }
                    else if(escolha == 3)
                    {
                        auxiliares.assal = assalariado;
                        System.out.printf("O funcionário é assalariado e passará a ser horista.\n");

                        System.out.printf("Digite o salário do funcionário horista\n\n-> ");

                        double salario_horista = input.nextDouble();

                        Horista novo = new Horista(assalariado.name, assalariado.endereco, salario_horista, assalariado.id, assalariado.is_sindicate, assalariado.escolha_pag, assalariado.metodo_pag);
                        
                        if(assalariado.is_sindicate)
                        {
                            novo.sindicate(assalariado.id_sindicato, assalariado.taxa_mensal_sindicato);
                        }

                        //id++;
                        id_sindicato++;

                        horista_list.add(novo);
                        
                        quant_horista++;
                        
                        for(int k = 0; k < quant_horista; k++)
                        {
                            Horista horista = horista_list.get(k);

                            if(horista.id == novo.id)
                            {
                                for(Taxa_de_servico taxa : assalariado.taxa_list)
                                {
                                    novo.taxa_list.add(taxa);
                                }
                                break;
                            }
                        }

                        auxiliares.horis = novo;

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
                        auxiliares.escolha_pag = assalariado.escolha_pag;
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

                        auxiliares.escolha_pag_alterada = assalariado.escolha_pag;

                        assalariado.alterar_meth_pag(assalariado);

                        System.out.printf("\nAlteração realizada com sucesso\n\n");
                    }
                    else if(escolha == 5)
                    {
                        auxiliares.is_sindicate = assalariado.is_sindicate;
                        if(assalariado.is_sindicate)
                        {
                            System.out.printf("O funcionário pertencia ao sindicato e agora não pertence mais.\n");
                            assalariado.alterar_is_sind(assalariado);
                        }
                        else
                        {
                            System.out.printf("O funcionário não pertencia ao sindicato e agora pertence.\n");
                            assalariado.alterar_is_sind(assalariado);
                            id_sindicato++;
                        }

                        auxiliares.is_sindicate_alterado = assalariado.is_sindicate;

                        System.out.printf("\nAlteração realizada com sucesso\n\n");
                    }
                    else if(escolha == 6)
                    {
                        auxiliares.id_sindicato = assalariado.id_sindicato;
                        System.out.printf("O ID do funcionário no sindicato é %d.\n", assalariado.id_sindicato);
                        assalariado.alterar_id_sind(assalariado);
                        auxiliares.id_sindicato_alterado = assalariado.id_sindicato;
                        System.out.printf("\nAlteração realizada com sucesso\n\n");
                    }
                    else
                    {
                        auxiliares.taxa_sindical = assalariado.taxa_mensal_sindicato;
                        System.out.printf("A taxa mensal do funcionário no sindicato é %.2f.\n", assalariado.taxa_mensal_sindicato);
                        assalariado.alterar_taxa(assalariado);
                        auxiliares.taxa_sindical_alterada = assalariado.taxa_mensal_sindicato;
                        System.out.printf("\nAlteração realizada com sucesso\n\n");
                    }

                    break;
                }
            }
        }
    }

    void criar_nova_agenda()
    {
        agenda.criar_nova_agenda();
    }

    void rodar_folha()
    {
        LocalDate data = LocalDate.now();
        Calendar calendario = Calendar.getInstance();

        String dia_atual = data.getDayOfWeek().name();

        if(dia_atual == "MONDAY")
        {
            dia_atual = "Segunda";
        }
        else if(dia_atual == "TUESDAY")
        {
            dia_atual = "Terça";
        }
        else if(dia_atual == "WEDNESDAY")
        {
            dia_atual = "Quarta";
        }
        else if(dia_atual == "THURSDAY")
        {
            dia_atual = "Terça";
        }
        else if(dia_atual == "FRIDAY")
        {
            dia_atual = "Sexta";
        }

        int semana_atual = calendario.get(Calendar.WEEK_OF_MONTH);
        int dia = data.getDayOfMonth();

        System.out.printf("Funcionários Horistas que devem ser pagos hoje:\n\n");

        String pagamento;
        double salario;

        for (Horista horista : horista_list) 
        {
            pagamento = horista.metodo_pag;

            salario = 0;

            for (Cartao_de_ponto card : horista.cartao_list) 
            {
                if(card.horas_trabalhadas > 8)
                {
                    salario += 8 * horista.salario_hora;
                    salario += (card.horas_trabalhadas - 8) * (0.0015*horista.salario_hora + horista.salario_hora);
                }
                else
                {
                    salario += (card.horas_trabalhadas)*horista.salario_hora;
                }
            }

            if(horista.is_sindicate)
            {
                salario -= horista.taxa_mensal_sindicato;

                for (Taxa_de_servico taxas : horista.taxa_list) 
                {
                    salario -= taxas.valor;
                }
            }

            if(pagamento.contains(dia_atual))
            {
                if(pagamento.contains("1"))
                {
                    System.out.printf("Nome: %s\n", horista.name);

                    System.out.printf("A receber: %.2f\n\n", salario);
                }
                else if(pagamento.contains("2"))
                {
                    if(semana_atual == 2 || semana_atual == 4)
                    {
                        System.out.printf("Nome: %s\n", horista.name);

                        System.out.printf("A receber: %.2f\n\n", salario);
                    }
                }
            }
        }

        System.out.printf("Funcionários Assalariados que devem ser pagos hoje:\n\n");

        for (Assalariado assalariado : assalariado_list) 
        {
            pagamento = assalariado.metodo_pag;

            salario = 0;
            double comissao;

            salario += assalariado.salario_assalariado;

            if(assalariado.comissionado == 1)
            {
                comissao = (assalariado.comissao)/100;

                for (Resultado_venda vendas : assalariado.venda_list)
                {
                    salario += (vendas.valor_do_produto)*comissao;
                }
            }

            if(assalariado.is_sindicate)
            {
                salario -= assalariado.taxa_mensal_sindicato;

                for (Taxa_de_servico taxas : assalariado.taxa_list) 
                {
                    salario -= taxas.valor;
                }
            }

            if(assalariado.comissionado == 1)
            {
                if(pagamento.contains(dia_atual))
                {
                    if(pagamento.contains("1"))
                    {
                        System.out.printf("Nome: %s\n", assalariado.name);

                        System.out.printf("A receber: %.2f\n\n", salario);
                    }
                    else if(pagamento.contains("2"))
                    {
                        if(semana_atual == 2 || semana_atual == 4)
                        {
                            System.out.printf("Nome: %s\n", assalariado.name);

                            System.out.printf("A receber: %.2f\n\n", salario);
                        }
                    }
                }
            }
            else
            {
                if(pagamento.contains("Mensal"))
                {
                    if(pagamento.contains("$"))
                    {
                        if(dia == 30)
                        {
                            System.out.printf("Nome: %s\n", assalariado.name);

                            System.out.printf("A receber: %.2f\n\n", salario);
                        }
                    }
                    else
                    {
                        char numero = pagamento.charAt(7);
                        int aux = Character.getNumericValue(numero);

                        if(dia == aux)
                        {
                            System.out.printf("Nome: %s\n", assalariado.name);

                            System.out.printf("A receber: %.2f\n\n", salario);
                        }
                    }
                }
            }
        }
    }
}