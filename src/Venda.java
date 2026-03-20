import java.time.LocalDate;

public class Venda extends Transacao{

    public Venda(Double comissaoFuncionario, Double comissaoImobiliaria, LocalDate dataTransacao,
                 TipoTransacao formaPagamento, Funcionario funcionario,
                 ClienteUsuario clienteUsuario, Imovel imovel) {
        super(comissaoFuncionario, comissaoImobiliaria, dataTransacao, formaPagamento, funcionario, clienteUsuario, imovel);
    }
}
