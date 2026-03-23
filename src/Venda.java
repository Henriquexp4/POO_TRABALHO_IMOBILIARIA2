import java.time.LocalDate;

public class Venda extends Transacao{

    private Double valorVenda;

    public Venda(Double comissaoFuncionario, Double comissaoImobiliaria, TipoTransacao formaPagamento, Funcionario funcionario,
                 ClienteUsuario clienteUsuario, Imovel imovel, Double valorVenda) {
        super(comissaoFuncionario, comissaoImobiliaria, formaPagamento, funcionario, clienteUsuario, imovel);
        this.valorVenda = valorVenda;
    }
@Override
    public String tipoTransacao() {
return "Venda";
}

    public Double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(Double valorVenda) {
        this.valorVenda = valorVenda;
    }

    @Override
    public String toString() {
        return "Venda{" +
                "valorVenda=" + valorVenda +
                ", clienteUsuario=" + clienteUsuario +
                ", imovel=" + imovel +
                ", funcionario=" + funcionario +
                ", formaPagamento=" + formaPagamento +
                ", dataTransacao=" + dataTransacao +
                ", comissaoImobiliaria=" + comissaoImobiliaria +
                ", comissaoFuncionario=" + comissaoFuncionario +
                '}';
    }
}
