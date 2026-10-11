import java.text.DateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Empresa {
    private String nome;
    private LocalDate dataNascimento;
    private double salario;
    private String tipoContrato;
    private int idade;

    public Empresa(String nome, String dataNascimento, double salario, String tipoContrato) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        this.nome = nome;
        this.dataNascimento = LocalDate.parse(dataNascimento,formato);
        this.salario = salario;
        this.tipoContrato = tipoContrato;
        this.idade = Period.between(this.dataNascimento,LocalDate.now()).getYears();

    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "________________________________\nNome teste para identificar facilmente:"+getNome()+"\n" +
                "Idade: "+getIdade()+
                "\nData de nascimento: "+getDataNascimento()
                +"\nTipo de contrato: "+getTipoContrato()
                +"\nSalário: "+String.format(Locale.of("pt","BR"), "%.2f", getSalario());
    }
}
