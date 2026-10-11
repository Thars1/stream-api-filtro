import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        List<Empresa> funcionarios = new ArrayList<>();
        funcionarios.add(new Empresa("Teste 1A","03/11/1975",3000,"PJ"));
        funcionarios.add(new Empresa("Teste 3","06/07/2007", 7000, "CLT"));
        funcionarios.add(new Empresa("Teste 3","25/10/2006", 4000, "CLT"));
        funcionarios.add(new Empresa("Teste 1B", "25/10/1984", 2500, "PJ"));
        funcionarios.add(new Empresa("Teste fica de fora", "25/10/1984",4000,"PJ"));
        funcionarios.add(new Empresa("Teste fica de fora ", "25/10/1984",4000,"PJ"));
        funcionarios.add(new Empresa("Teste fica de fora ","25/10/1974",4000,"PJ"));
        funcionarios.add(new Empresa("Teste fica de fora", "25/10/1984",4000,"PJ"));
        funcionarios.add(new Empresa("Teste fica de fora ", "25/10/1984",100000,"PJ"));
        funcionarios.add(new Empresa("Teste fica de fora ","25/10/1974",4000,"PJ"));
        funcionarios.add(new Empresa("Teste 3","06/07/2007", 10000, "CLT"));
        funcionarios.add(new Empresa("Teste 3","25/10/2006", 20000, "CLT"));
        funcionarios.add(new Empresa("Teste 3","06/07/2007", 10000, "CLT"));
        funcionarios.add(new Empresa("Teste 3","25/10/2006", 20000, "CLT"));
        funcionarios.add(new Empresa("Teste 3","06/07/2007", 10000, "CLT"));
        funcionarios.add(new Empresa("Teste 3","25/10/2006", 20500, "CLT"));
        funcionarios.add(new Empresa("Teste 3","25/10/2006", 20000, "CLT"));
        funcionarios.add(new Empresa("Teste 3","06/07/2007", 10000, "CLT"));
        funcionarios.add(new Empresa("Teste 3","25/10/2006", 20000, "CLT"));
        funcionarios.add(new Empresa("Teste 3","06/07/2007", 10000, "CLT"));
        funcionarios.add(new Empresa("Teste 3","25/10/2006", 20000, "CLT"));
        funcionarios.add(new Empresa("Teste 3","25/10/2006", 20000, "CLT"));
        funcionarios.add(new Empresa("Teste 3","06/07/2007", 10000, "CLT"));
        funcionarios.add(new Empresa("Teste 3","25/10/2006", 20100, "CLT"));
        funcionarios.add(new Empresa("Teste 3","06/07/2007", 10000, "CLT"));
        funcionarios.add(new Empresa("Teste 3","25/10/2006", 20000, "CLT"));
        funcionarios.add(new Empresa("Teste 3","25/10/2006", 20000, "CLT"));
        funcionarios.add(new Empresa("Teste 3","06/07/2007", 10000, "CLT"));
        funcionarios.add(new Empresa("Teste 3","25/10/2006", 70000, "CLT"));
        funcionarios.add(new Empresa("Teste 3","06/07/2007", 10000, "CLT"));
        funcionarios.add(new Empresa("Teste 3","25/10/2006", 40000, "CLT"));
        funcionarios.add(new Empresa("Teste 3","25/10/2006", 20000, "CLT"));
        funcionarios.add(new Empresa("Teste 3","06/07/2007", 10000, "CLT"));
        funcionarios.add(new Empresa("Teste 3","25/10/2006", 1000, "CLT"));
        funcionarios.add(new Empresa("Teste 3","06/07/2007", 10000, "CLT"));
        funcionarios.add(new Empresa("Teste 3","25/10/2006", 20000, "CLT"));
        funcionarios.add(new Empresa("Teste 3","25/10/2006", 20000, "CLT"));
        funcionarios.add(new Empresa("Teste 3","25/10/2006", 50000, "CLT"));
        funcionarios.add(new Empresa("Teste 3","25/10/2006", 20000, "CLT"));
        funcionarios.add(new Empresa("Teste 3","25/10/2006", 20000, "CLT"));
        funcionarios.add(new Empresa("Não deve aparecer","25/10/2006", 100000, "PJ"));






        filtroPorSalarioNascimento(funcionarios);
        List<Integer> listaNumeros = new ArrayList<>();
        listaNumeros.add(1);
        listaNumeros.add(2);
        listaNumeros.add(4);
        listaNumeros.add(3);
        listaNumeros.add(2);
        System.out.println("-------------------");
        System.out.println("A lista de pares somada é: "+somarListaDePares(listaNumeros));

        maioresSalarios(funcionarios);


    }


    public static void maioresSalarios(List<Empresa> funcionarios){
        System.out.println();

        funcionarios.stream().
                filter(funcionario ->funcionario.getIdade()<25).filter(f -> f.getTipoContrato().equals("CLT")).
                sorted(Comparator.comparing(Empresa::getSalario).reversed()).
                limit(30).forEach(s -> System.out.println("Nome:"+s.getNome()+" Idade: "+s.getIdade()+" Salário: "
                        +s.getSalario()+" Contrato: "+s.getTipoContrato()));
    }
    public static int somarListaDePares(List<Integer> list){
        System.out.println("Utilzando o método 2 ");
        IntStream soma = list.stream().mapToInt(Integer::intValue)
                .filter(n -> n%2==0);
        return soma.sum();
    }
    public static void filtroPorSalarioNascimento(List<Empresa> funcionarios){
        System.out.println("Utilzando o método 1 ");
       funcionarios.stream().filter(f ->
                Year.from(f.getDataNascimento()).isAfter(Year.of(1974)) &&
                Year.from(f.getDataNascimento()).isBefore(Year.of(1986)) &&
                        f.getSalario() <=3000).forEach(System.out::println);

    }
}
