import java.util.LinkedList;

public class Horista {
    String name;
    String endereco;
    double salario_hora;
    int id;

    LinkedList<Cartao_de_ponto> cartao_list = new LinkedList<>();

    Horista(String name, String endereco, double salario_hora, int id)
    {
        this.name = name;
        this.endereco = endereco;
        this.salario_hora = salario_hora;
        this.id = id;
    }
}
