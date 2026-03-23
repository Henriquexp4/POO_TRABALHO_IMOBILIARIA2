import java.time.LocalDate;

public class Aluguel extends Transacao{
    private Double valorAluguel;
    private LocalDate dataVencimento;
    private Integer duracaoMeses;

    public Aluguel(Double comissaoFuncionario, Double comissaoImobiliaria, TipoTransacao formaPagamento,
                   Funcionario funcionario, ClienteUsuario clienteUsuario, Imovel imovel, Double valorAluguel,
                   Integer duracaoMeses) {
        super(comissaoFuncionario, comissaoImobiliaria, formaPagamento, funcionario, clienteUsuario, imovel);
        this.valorAluguel = valorAluguel;
        this.dataVencimento = LocalDate.now().plusMonths(duracaoMeses);
        this.duracaoMeses = duracaoMeses;
    }
    @Override
    public String tipoTransacao(){
        return "Aluguel";
    }

    public Double getValorAluguel() {
        return valorAluguel;
    }

    public void setValorAluguel(Double valorAluguel) {
        this.valorAluguel = valorAluguel;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Integer getDuracaoMeses() {
        return duracaoMeses;
    }

    public void setDuracaoMeses(Integer duracaoMeses) {
        this.duracaoMeses = duracaoMeses;
    }

    @Override
    public String toString() {
        return "Aluguel{" +
                "valorAluguel=" + valorAluguel +
                ", dataVencimento=" + dataVencimento +
                ", duracaoMeses=" + duracaoMeses +
                ", imovel=" + imovel +
                ", clienteUsuario=" + clienteUsuario +
                ", funcionario=" + funcionario +
                ", formaPagamento=" + formaPagamento +
                ", dataTransacao=" + dataTransacao +
                ", comissaoImobiliaria=" + comissaoImobiliaria +
                ", comissaoFuncionario=" + comissaoFuncionario +
                '}';
    }
}
