import java.util.LinkedList;
import java.util.Scanner;

public class Agenda_Pagamento 
{
    Scanner input = new Scanner(System.in);
    LinkedList<String> formas_pagamento = new LinkedList<>();
    
    Agenda_Pagamento()
    {
        this.formas_pagamento.add("Semanal 1 Sexta"); //1
        this.formas_pagamento.add("Mensal $"); //2
        this.formas_pagamento.add("Semanal 2 Sexta"); //3
    }

    void listar()
    {
        int i = 1;
        for (String string : formas_pagamento) 
        {
            System.out.printf("%d) %s\n", i, string);
            i += 1;
        }
    }

    void criar_nova_agenda()
    {
        String nova;

        System.out.printf("O pagamento na nova agenda será realizado semanal ou mensalmente?\n\n1) Semanalmente\n2) Mensalmente\n\n");

        int escolha = input.nextInt();

        if(escolha == 1)
        {
            nova = "Semanal";

            System.out.printf("\nA cada quantas semanas será realizado o pagamento?\n\n");

            int semanas = input.nextInt();

            while(semanas < 1 || semanas > 5)
            {
                System.out.println("Respota inválida! Tente novamente!\n");
                System.out.printf("A cada quantas semanas será realizado o pagamento?\n\n");
                semanas = input.nextInt();
            }

            String str1 = Integer.toString(semanas);

            nova += " ";
            nova += str1;

            System.out.printf("\nEm qual dia da semana será realizado o pagamento?\n\n");
            System.out.println("1) Segunda-feira");
            System.out.println("2) Terça-feira");
            System.out.println("3) Quarta-feira");
            System.out.println("4) Quinta-feira");
            System.out.println("5) Sexta-feira\n");

            int dia = input.nextInt();

            while(dia < 1 || dia > 5)
            {
                System.out.println("\nRespota inválida! Tente novamente!\n");
                System.out.printf("Em qual dia da semana será realizado o pagamento?\n\n");
                System.out.println("1) Segunda-feira");
                System.out.println("2) Terça-feira");
                System.out.println("3) Quarta-feira");
                System.out.println("4) Quinta-feira");
                System.out.println("5) Sexta-feira\n");
                dia = input.nextInt();
            }

            if(dia == 1)
            {
                nova += " Segunda";
            }
            else if(dia == 2)
            {
                nova += " Terça";
            }
            else if(dia == 3)
            {
                nova += " Quarta";
            }
            else if(dia == 4)
            {
                nova += " Quinta";
            }
            else if(dia == 5)
            {
                nova += " Sexta";
            }

            System.out.printf("\nA agenda '%s' foi criada\n", nova);

            formas_pagamento.add(nova);
        }
        else
        {
            nova = "Mensal";

            System.out.printf("\nEm que dia do mês será realizado o pagamento?\n\n");

            int data = input.nextInt();

            while(data < 1 || data > 30)
            {
                System.out.println("\nRespota inválida! Tente novamente!\n");
                System.out.printf("Em que dia do mês será realizado o pagamento?\n\n");
                data = input.nextInt();
            }

            String str = Integer.toString(data);

            nova += " ";
            nova += str;

            formas_pagamento.add(nova);
        }

    }
}
