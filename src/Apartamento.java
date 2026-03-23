import java.time.LocalDate;

public class Apartamento extends Imovel{
    private Integer qtdQuartos;
    private Integer qtdSuites;
    private Integer qtdSalas;
    private Integer qtdSalasJantar;
    private Integer qtdVagasGaragem;
    private Double area;
    private Boolean mobiliado;
    private Integer andar;
    private Double valorCondominio;
    private Boolean portaria24h;
    private String detalhes;

    public Apartamento(LocalDate dataContrucao, Status status, Endereco endereco, Double valorSugerido, Integer qtdQuartos, Integer qtdSuites, Integer qtdSalas, Integer qtdSalasJantar, Integer qtdVagasGaragem, Double area, Boolean mobiliado,
                       Integer andar, Double valorCondominio, Boolean portaria24h, String detalhes) {
        super(dataContrucao, status, endereco, valorSugerido);
        this.qtdQuartos = qtdQuartos;
        this.qtdSuites = qtdSuites;
        this.qtdSalas = qtdSalas;
        this.qtdSalasJantar = qtdSalasJantar;
        this.qtdVagasGaragem = qtdVagasGaragem;
        this.area = area;
        this.mobiliado = mobiliado;
        this.andar = andar;
        this.valorCondominio = valorCondominio;
        this.portaria24h = portaria24h;
        this.detalhes = detalhes;
    }

    @Override
    public String categoria(){
return "Apartamento";
    }
    @Override
    public String detalhes(){
        return "Quartos: " + qtdQuartos + "\nSuítes: " + qtdSuites +
                "\nSalas: " + qtdSalas + "\nSalas de Jantar: " + qtdSalasJantar +
                "\nGaragem: " + qtdVagasGaragem + " vagas \nÁrea: " + area + "m2" +
                " \nArmário Embutido: " + (mobiliado ? "Sim" : "Não") +
                " \nAndar: " + andar +
                " \nCondomínio: R$ " + String.format("%.2f", valorCondominio) +
                " \nPortaria 24h: " + (portaria24h ? "Sim" : "Não") +
                " \ndetalhes: " + detalhes;
    }

    public Integer getQtdQuartos() {
        return qtdQuartos;
    }

    public void setQtdQuartos(Integer qtdQuartos) {
        this.qtdQuartos = qtdQuartos;
    }

    public Integer getQtdSuites() {
        return qtdSuites;
    }

    public void setQtdSuites(Integer qtdSuites) {
        this.qtdSuites = qtdSuites;
    }

    public Integer getQtdSalas() {
        return qtdSalas;
    }

    public void setQtdSalas(Integer qtdSalas) {
        this.qtdSalas = qtdSalas;
    }

    public Integer getQtdSalasJantar() {
        return qtdSalasJantar;
    }

    public void setQtdSalasJantar(Integer qtdSalasJantar) {
        this.qtdSalasJantar = qtdSalasJantar;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Integer getQtdVagasGaragem() {
        return qtdVagasGaragem;
    }

    public void setQtdVagasGaragem(Integer qtdVagasGaragem) {
        this.qtdVagasGaragem = qtdVagasGaragem;
    }

    public Boolean getMobiliado() {
        return mobiliado;
    }

    public void setMobiliado(Boolean mobiliado) {
        this.mobiliado = mobiliado;
    }

    public Integer getAndar() {
        return andar;
    }

    public void setAndar(Integer andar) {
        this.andar = andar;
    }

    public Boolean getPortaria24h() {
        return portaria24h;
    }

    public void setPortaria24h(Boolean portaria24h) {
        this.portaria24h = portaria24h;
    }

    public Double getValorCondominio() {
        return valorCondominio;
    }

    public void setValorCondominio(Double valorCondominio) {
        this.valorCondominio = valorCondominio;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }
}
