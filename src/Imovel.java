import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Imovel {

    private Status status;
    protected LocalDate dataContrucao;
    protected LocalDate dataTransacao;
    protected Endereco endereco;
    protected Double valorSugerido;
    protected Double valorReal;
    protected Double valorImobiliaria;
    protected List<ClientePropietario> propietarios;
    private Integer id;
    private static int contador = 0;
    protected LocalDate dataLiberacao;

    public Imovel(LocalDate dataContrucao, Status status, Endereco endereco, Double valorSugerido) {
        this.dataLiberacao = LocalDate.now();
        this.dataContrucao = dataContrucao;
        this.status = status;
        this.propietarios = new ArrayList<>();
        this.endereco = endereco;
        this.valorSugerido = valorSugerido;
        this.id = contador++;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    public LocalDate getDataContrucao() {
        return dataContrucao;
    }
    public void setDataContrucao(LocalDate dataContrucao) {
        this.dataContrucao = dataContrucao;
    }
    public LocalDate getDataTransacao() {
        return dataTransacao;
    }
    public void setDataTransacao(LocalDate dataTransacao) {
        this.dataTransacao = dataTransacao;
    }
    public Endereco getEndereco() {
        return endereco;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    public Double getValorSugerido() {
        return valorSugerido;
    }
    public void setValorSugerido(Double valorSugerido) {
        this.valorSugerido = valorSugerido;
    }
    public Double getValorReal() {
        return valorReal;
    }
    public void setValorReal(Double valorReal) {
        this.valorReal = valorReal;
    }
    public Double getValorImobiliaria() {
        return valorImobiliaria;
    }
    public void setValorImobiliaria(Double valorImobiliaria) {
        this.valorImobiliaria = valorImobiliaria;
    }
    public List<ClientePropietario> getPropietarios() {
        return propietarios;
    }
    public void setPropietarios(List<ClientePropietario> propietarios) {
        this.propietarios = propietarios;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public static int getContador() {
        return contador;
    }
    public static void setContador(int contador) {
        Imovel.contador = contador;
    }
    public LocalDate getDataLiberacao() {
        return dataLiberacao;
    }
    public void setDataLiberacao(LocalDate dataLiberacao) {
        this.dataLiberacao = dataLiberacao;
    }

    void adicionarPropietario(ClientePropietario p){
        this.propietarios.add(p);
    }
    public abstract String categoria();
    public abstract String detalhes();

    public boolean estaDisponivel(){
return status == Status.DISPONIVEL_VENDA || status == Status.DISPONIVEL_LOCACAO;
    }


}
