import java.time.LocalDate;

public class Terreno extends Imovel{

    private Double areaM2;
    private Double largura;
    private Double comprimento;
    private Boolean possuiAcliveDeclive;

    public Terreno(LocalDate dataContrucao, Status status, Endereco endereco,
                   Double valorSugerido, Double valorReal, Double areaM2, Double largura, Double comprimento, Boolean possuiAcliveDeclive) {

        super(dataContrucao, status, endereco, valorSugerido);
        this.areaM2 = areaM2;
        this.largura = largura;
        this.comprimento = comprimento;
        this.possuiAcliveDeclive = possuiAcliveDeclive;
    }

    public Double getAreaM2() {
        return areaM2;
    }
    public void setAreaM2(Double areaM2) {
        this.areaM2 = areaM2;
    }
    public Double getLargura() {
        return largura;
    }
    public void setLargura(Double largura) {
        this.largura = largura;
    }
    public Double getComprimento() {
        return comprimento;
    }
    public void setComprimento(Double comprimento) {
        this.comprimento = comprimento;
    }
    public Boolean getPossuiAcliveDeclive() {
        return possuiAcliveDeclive;
    }
    public void setPossuiAcliveDeclive(Boolean possuiAcliveDeclive) {
        this.possuiAcliveDeclive = possuiAcliveDeclive;
    }
    @Override
    public String categoria() {
return "Terreno";
    }
    @Override
    public String detalhes() {
        return "Area: " +"m2 / Largura: "+largura+"m / Comprimento: " + comprimento+
"m / Aclive/Declive: " + (possuiAcliveDeclive ? "Sim" : "Não");
    }



}
