import java.util.LinkedList;

public class Horista {
    String name;
    String endereco;
    double salario_hora, taxa_mensal_sindicato;
    int id, id_sindicato, escolha_pag;
    boolean is_sindicate;

    LinkedList<Cartao_de_ponto> cartao_list = new LinkedList<>();
    LinkedList<Taxa_de_servico> taxa_list = new LinkedList<>();

    Horista(String name, String endereco, double salario_hora, int id, boolean is_sindicate, int escolha_pag)
    {
        this.name = name;
        this.endereco = endereco;
        this.salario_hora = salario_hora;
        this.id = id;
        this.is_sindicate = is_sindicate;
        this.escolha_pag = escolha_pag;
    }

    void sindicate(int id_sindicato, double taxa_mensal_sindicato)
    {
        this.id_sindicato = id_sindicato;
        this.taxa_mensal_sindicato = taxa_mensal_sindicato;
    }
}
