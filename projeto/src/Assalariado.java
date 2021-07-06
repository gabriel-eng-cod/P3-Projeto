import java.util.LinkedList;

public class Assalariado {
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
}
