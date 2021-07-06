import java.util.LinkedList;

public class Horista {
    
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
        //System.out.printf("%s\n", name);
        this.set_name(name);
        this.set_endereco(endereco);
        this.salario_hora = salario_hora;
        this.id = id;
        this.set_is_sind(is_sindicate);
        this.set_escolha_pag(escolha_pag);
    }
}
