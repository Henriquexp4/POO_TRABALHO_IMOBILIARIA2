import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Sistema {

    private List<Imovel> imoveis;
    private List<Funcionario> funcionarios;
    private List<Transacao> transacoes;
    private List<ClientePropietario> propietarios;
    private List<ClienteUsuario> usuarios;

    public Sistema(){
        this.imoveis =  new ArrayList<>();
        this.funcionarios = new ArrayList<>();
        this.propietarios = new ArrayList<>();
        this.transacoes =  new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    void cadastroProprietario(ClientePropietario p){
        propietarios.add(p);
        IO.println("Propietario: " + p.getNome() + "cadastrado com sucesso no sistema!");
    }
    void imovelDoPropietario(ClientePropietario p, Imovel i) {
        i.adicionarPropietario(p);
        p.adicionarImovel(i);
        IO.println("O imovel de ID numero " + i.getId() + " foi assciado ao nosso Cliente Propietario -> " + p.getNome());
    }
    void cadastroImovel(Imovel i) {
        imoveis.add(i);
        IO.println("O Imovel de ID numero "+i.getId() + " foi cadastrado com sucesso no sistema!");
    }
    void cadastroUsuario(ClienteUsuario u) {
        usuarios.add(u);
        IO.println("Cliente Usuario: "+u.getNome()+", cadstrado com sucesso no sistema!");

    }
    void cadastrarFuncionario(Funcionario f) {
        funcionarios.add(f);
        IO.println("Funcionario "+f.getNome()+" cadastrado com sucesso no sistema!");
    }




    public Venda fazerVenda(Double comissaoFuncionario, Double comissaoImobiliaria, LocalDate dataTransacao, TipoTransacao formaPagamento, Funcionario funcionario,
                            ClienteUsuario clienteUsuario, Imovel i, Double valorVenda) {
        if (i.getStatus() != Status.DISPONIVEL_VENDA) {
            throw new IllegalStateException("Imóvel de numero "+i.getId()+ "não disponivel para venda");
        }
        Double calcularComissaoImobiliaria = valorVenda * comissaoImobiliaria/100.0;
        Double calcularComissaoFuncionario = valorVenda * comissaoFuncionario/100.0;

        Venda venda = new Venda (comissaoFuncionario, comissaoImobiliaria, formaPagamento, funcionario, clienteUsuario, i, valorVenda);

            i.setStatus(Status.VENDIDO);
            i.setValorReal(valorVenda);
            i.setValorImobiliaria(calcularComissaoImobiliaria);
            i.setDataTransacao(LocalDate.now());

            funcionario.adicionarTransacao(venda);
            transacoes.add(venda);
            IO.println("O Funcionario "+funcionario.getNome()+" realizou uma nova venda! de um "+ venda.imovel.categoria());
            return venda;
    }
    public Aluguel fazerAluguel(Double comissaoFuncionario, Double comissaoImobiliaria, TipoTransacao formaPagamento,
                                Funcionario funcionario, ClienteUsuario locatario, Imovel i, Double valorAluguel, Integer duracaoMeses ) {
        if (i.getStatus() != Status.DISPONIVEL_LOCACAO) {
            throw new IllegalStateException("Imovel ID numero " + i.getId()+" não está disponivel para locação!.");
        }
        if (!locatario.aptoAlugar()) {
            throw new IllegalStateException("Cliente " + locatario.getNome() + " não possui fiador e indicações para locação!.");
        }
        Double calcularComissaoImobiliaria = valorAluguel*comissaoImobiliaria/100.0;
        Double calcularComissaoFuncionario = valorAluguel*comissaoFuncionario/100.0;

        Aluguel aluguel = new Aluguel (comissaoFuncionario, comissaoImobiliaria, formaPagamento, funcionario, locatario, i, valorAluguel, duracaoMeses);
        i.setStatus(Status.LOCADO);
        i.setValorReal(valorAluguel);
        i.setValorImobiliaria(calcularComissaoImobiliaria);
        i.setDataTransacao(LocalDate.now());

        funcionario.adicionarTransacao(aluguel);
        transacoes.add(aluguel);
        IO.println(aluguel.imovel.categoria()+"Alugado com sucesso pelo sistema!");
        return aluguel;
    }
    public List<Imovel> imoveisDIsponiveisVenda(){
        return imoveis.stream().filter (i -> i.getStatus() == Status.DISPONIVEL_VENDA).collect(Collectors.toList());
    }
    public List<Imovel> imoveisDisponiveisAluguel() {
        return imoveis.stream().filter(i -> i.getStatus() == Status.DISPONIVEL_LOCACAO).collect(Collectors.toList());
    }
    public List<Imovel> imoveisCategoria(String categoria) {
        return imoveis.stream().filter(i -> i.categoria().equalsIgnoreCase(categoria)).collect(Collectors.toList());
    }
    public List<Transacao> transacoesFuncionario(Funcionario funcionario) {
        return transacoes.stream().filter(t -> t.getFuncionario().getCpf().equals(funcionario.getCpf())).collect(Collectors.toList());
    }
    void todosImoveis(){
        if(imoveis.isEmpty()) {
            IO.println("Sem imoveis cadastrados.");
            return;
        }
        imoveis.forEach(i ->{
            IO.println(i);
            IO.println(" Detalhes: "+ i.detalhes());
            IO.println (" Endereço: "+ i.getEndereco());
        });
    }
    void todasTransacoes(){
        if (transacoes.isEmpty()) {
            IO.println("Não há transações.");
            return;
        }
        transacoes.forEach(IO::println);
    }

    public List<Imovel> getImoveis() {
        return imoveis;
    }

    public void setImoveis(List<Imovel> imoveis) {
        this.imoveis = imoveis;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    public void setTransacoes(List<Transacao> transacoes) {
        this.transacoes = transacoes;
    }

    public List<ClientePropietario> getPropietarios() {
        return propietarios;
    }

    public void setPropietarios(List<ClientePropietario> propietarios) {
        this.propietarios = propietarios;
    }

    public List<ClienteUsuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<ClienteUsuario> usuarios) {
        this.usuarios = usuarios;
    }
}
