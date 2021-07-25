import java.util.LinkedList;
import java.util.Scanner;

public class Assalariado extends Empregado{

    Scanner input = new Scanner(System.in);
    
    LinkedList<Resultado_venda> venda_list = new LinkedList<>();

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
}
