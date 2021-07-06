import java.util.LinkedList;
import java.util.LinkedList;
import java.util.Scanner;

public class Horista {
    
    Scanner input = new Scanner(System.in);

    private String name;
    private String endereco;
    private double salario_hora, taxa_mensal_sindicato;
    private int id, id_sindicato, escolha_pag;
    private boolean is_sindicate;

    public LinkedList<Cartao_de_ponto> cartao_list = new LinkedList<>();
    public LinkedList<Taxa_de_servico> taxa_list = new LinkedList<>();

    public String get_name()
    {
        return name;
    }

    public String get_endereco()
    {
        return endereco;
    }

    public double get_salario_hora()
    {
        return salario_hora;
    }

    public double get_tx_mensal_sind()
    {
        return taxa_mensal_sindicato;
    }

    public int get_id()
    {
        return id;
    }

    public int get_id_sind()
    {
        return id_sindicato;
    }

    public int get_escolha_pag()
    {
        return escolha_pag;
    }

    public boolean get_is_sind()
    {
        return is_sindicate;
    }

    public void sindicate(int id_sindicato, double taxa_mensal_sindicato)
    {
        this.set_id_sind(id_sindicato);
        this.set_tx_mensal_sind(taxa_mensal_sindicato);
    }

    public void set_name(String new_name)
    {
        this.name = new_name;
    }

    public void set_endereco(String new_end)
    {
        this.endereco = new_end;
    }

    public void set_salario_hora(double sal)
    {
        this.salario_hora = sal;
    }

    public void set_id(int id)
    {
        this.id = id;
    }

    public void set_escolha_pag(int new_escolha_pag)
    {
        this.escolha_pag = new_escolha_pag;
    }

    public void set_is_sind(boolean new_is_sind)
    {
        this.is_sindicate = new_is_sind;
    }

    public void set_id_sind(int new_id_sind)
    {
        this.id_sindicato = new_id_sind;
    }

    public void set_tx_mensal_sind(double new_tx_mensal_sind)
    {
        this.taxa_mensal_sindicato = new_tx_mensal_sind;
    }

    public Horista(String name, String endereco, double salario_hora, int id, boolean is_sindicate, int escolha_pag)
    {
        this.set_name(name);
        this.set_endereco(endereco);
        this.set_salario_hora(salario_hora);
        this.set_id(id);
        this.set_is_sind(is_sindicate);
        this.set_escolha_pag(escolha_pag);
    }

    public void alterar_nome(Horista aux)
    {
        System.out.printf("Digite um novo nome: ");

        String new_name = input.nextLine();

        aux.name = new_name;
    }

    public void alterar_endereco(Horista aux)
    {
        System.out.printf("Digite um novo endereço: ");

        String new_endereco = input.nextLine();

        aux.endereco = new_endereco;
    }

    public void alterar_meth_pag(Horista aux)
    {
        int meth = input.nextInt();

        aux.escolha_pag = meth;
    }

    public void alterar_is_sind(Horista aux)
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

    public void alterar_id_sind(Horista aux)
    {
        System.out.printf("Digite o novo ID do funcionário no sindicato:\n\n-> ");
        int id_sind = input.nextInt();

        aux.id_sindicato = id_sind;
    }

    public void alterar_taxa(Horista aux)
    {
        System.out.printf("Digite a nova taxa sindical: ");
        double new_taxa = input.nextDouble();

        aux.taxa_mensal_sindicato = new_taxa;
    }
}
