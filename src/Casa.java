import java.time.LocalDate;

public class Casa extends Imovel{
    private Integer qtdQuartos;
    private Integer qtdSuites;
    private Integer qtdSalas;
    private Integer qtdSalasJantar;
    private Integer qtdVagaGaragem;
    private Double area;
    private Boolean mobiliado;
    private String descricao;

    public Casa(LocalDate dataContrucao, Status status, Endereco endereco, Double valorSugerido, Integer qtdQuartos, Integer qtdSuites, Integer qtdSalas, Integer qtdSalasJantar, Integer qtdVagaGaragem,
                Double area, Boolean mobiliado, String descricao) {
        super(dataContrucao, status, endereco, valorSugerido);
        this.qtdQuartos = qtdQuartos;
        this.qtdSuites = qtdSuites;
        this.qtdSalas = qtdSalas;
        this.qtdSalasJantar = qtdSalasJantar;
        this.qtdVagaGaragem = qtdVagaGaragem;
        this.area = area;
        this.mobiliado = mobiliado;
        this.descricao = descricao;
    }
@Override
    public String categoria(){
        return "Casa";
}
@Override
    public String detalhes(){
        return "Quartos: " + qtdQuartos + "\nSuítes: " + qtdSuites +
                "\nSalas : " + qtdSalas + "\nSalas de Jantar: " + qtdSalasJantar +
                "\nGaragem: " + qtdVagaGaragem + " vagas \nÁrea: " + area + "m2" +
                "\nMobiliado: " + (mobiliado ? "Sim" : "Não") +
                 "\ndescrição: " + descricao;
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

    public Integer getQtdVagaGaragem() {
        return qtdVagaGaragem;
    }

    public void setQtdVagaGaragem(Integer qtdVagaGaragem) {
        this.qtdVagaGaragem = qtdVagaGaragem;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Boolean getMobiliado() {
        return mobiliado;
    }

    public void setMobiliado(Boolean mobiliado) {
        this.mobiliado = mobiliado;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
