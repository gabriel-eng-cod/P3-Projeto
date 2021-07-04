import java.util.LinkedList;

public class Assalariado {
    String name;
    String endereco;
    double salario_assalariado;
    double comissao = 0;
    int id;
    int comissionado;

    LinkedList<Resultado_venda> venda_list = new LinkedList<>();

    Assalariado(String name, String endereco, double salario_assalariado, int comissionado, double comissao, int id)
    {
        this.name = name;
        this.endereco = endereco;
        this.salario_assalariado = salario_assalariado;
        this.id = id;
        this.comissao = comissao;
        this.comissionado = comissionado;
    }
}
