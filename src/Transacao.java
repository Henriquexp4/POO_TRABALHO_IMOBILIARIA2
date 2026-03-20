import java.time.LocalDate;

public abstract class Transacao {
    private static int contadorContrato  = 1;


    private int numeroContrato;
    protected Imovel imovel;
    protected ClienteUsuario clienteUsuario;
    protected Funcionario funcionario;
    protected TipoTransacao formaPagamento;
    protected LocalDate dataTransacao;
    protected Double comissaoImobiliaria;
    protected Double comissaoFuncionario;

    public Transacao( Double comissaoFuncionario, Double comissaoImobiliaria,
                     LocalDate dataTransacao, TipoTransacao formaPagamento,
                     Funcionario funcionario, ClienteUsuario clienteUsuario, Imovel imovel) {
        this.numeroContrato = contadorContrato++;
        this.comissaoFuncionario = comissaoFuncionario;
        this.comissaoImobiliaria = comissaoImobiliaria;
        this.dataTransacao = LocalDate.now();
        this.formaPagamento = formaPagamento;
        this.funcionario = funcionario;
        this.clienteUsuario = clienteUsuario;
        this.imovel = imovel;
    }

    public static int getContadorContrato() {
        return contadorContrato;
    }
    public static void setContadorContrato(int contadorContrato) {
        Transacao.contadorContrato = contadorContrato;
    }
    public int getNumeroContrato() {
        return numeroContrato;
    }
    public void setNumeroContrato(int numeroContrato) {
        this.numeroContrato = numeroContrato;
    }
    public Imovel getImovel() {
        return imovel;
    }
    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }
    public ClienteUsuario getClienteUsuario() {
        return clienteUsuario;
    }
    public void setClienteUsuario(ClienteUsuario clienteUsuario) {
        this.clienteUsuario = clienteUsuario;
    }
    public Funcionario getFuncionario() {
        return funcionario;
    }
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    public TipoTransacao getFormaPagamento() {
        return formaPagamento;
    }
    public void setFormaPagamento(TipoTransacao formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
    public LocalDate getDataTransacao() {
        return dataTransacao;
    }
    public void setDataTransacao(LocalDate dataTransacao) {
        this.dataTransacao = dataTransacao;
    }
    public Double getComissaoFuncionario() {
        return comissaoFuncionario;
    }
    public void setComissaoFuncionario(Double comissaoFuncionario) {
        this.comissaoFuncionario = comissaoFuncionario;
    }
    public Double getComissaoImobiliaria() {
        return comissaoImobiliaria;
    }
    public void setComissaoImobiliaria(Double comissaoImobiliaria) {
        this.comissaoImobiliaria = comissaoImobiliaria;
    }

}
