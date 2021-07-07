import java.util.LinkedList;
import java.util.Scanner;

public class Assalariado {

    Scanner input = new Scanner(System.in);

    String name;
    String endereco;
    double salario_assalariado, comissao = 0, taxa_mensal_sindicato;
    int id, id_sindicato, escolha_pag;
    int comissionado;
    boolean is_sindicate;

    LinkedList<Resultado_venda> venda_list = new LinkedList<>();
    LinkedList<Taxa_de_servico> taxa_list = new LinkedList<>();

    Assalariado(String name, String endereco, double salario_assalariado, int comissionado, double comissao, int id, boolean is_sindicate, int escolha_pag)
    {
        this.name = name;
        this.endereco = endereco;
        this.salario_assalariado = salario_assalariado;
        this.id = id;
        this.comissao = comissao;
        this.comissionado = comissionado;
        this.is_sindicate = is_sindicate;
        this.escolha_pag = escolha_pag;
    }

    void sindicate(int id_sindicato, double taxa_mensal_sindicato)
    {
        this.id_sindicato = id_sindicato;
        this.taxa_mensal_sindicato = taxa_mensal_sindicato;
    }

    public void alterar_nome(Assalariado aux)
    {
        System.out.printf("Digite um novo nome: ");

        String new_name = input.nextLine();

        aux.name = new_name;
    }

    public void alterar_endereco(Assalariado aux)
    {
        System.out.printf("Digite um novo endereço: ");

        String new_endereco = input.nextLine();

        aux.endereco = new_endereco;
    }

    public void alterar_meth_pag(Assalariado aux)
    {
        int meth = input.nextInt();

        aux.escolha_pag = meth;
    }

    public void alterar_is_sind(Assalariado aux)
    {
        if(aux.is_sindicate)
        {
            aux.is_sindicate = false;
        }
        else
        {
            aux.is_sindicate = true;

            System.out.printf("Qual a taxa mensal do sindicato?\n\n-> ");
                            
            double taxa_mensal_sindicato = input.nextDouble();

            aux.taxa_mensal_sindicato = taxa_mensal_sindicato;
        }
    }

    public void alterar_id_sind(Assalariado aux)
    {
        System.out.printf("Digite o novo ID do funcionário no sindicato:\n\n-> ");
        int id_sind = input.nextInt();

        aux.id_sindicato = id_sind;
    }

    public void alterar_taxa(Assalariado aux)
    {
        System.out.printf("Digite a nova taxa sindical: ");
        double new_taxa = input.nextDouble();

        aux.taxa_mensal_sindicato = new_taxa;
    }
}
