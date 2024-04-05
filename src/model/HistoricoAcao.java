package model;
import enumerador.Acao;
import java.util.Date;

public class HistoricoAcao {
    private Date data;
    private Acao tipo;
    private double valorPretendido;
    private double valorReal;
    private String idUsuarioOrigem;
    private String idUsuarioDestino;
    private String observacao;

    public HistoricoAcao(Acao tipo, double valorPretendido, double valorReal, String idUsuarioOrigem,
                         String idUsuarioDestino, String observacao) {
        this.data = new Date();
        this.tipo = tipo;
        this.valorPretendido = valorPretendido;
        this.valorReal = valorReal;
        this.idUsuarioOrigem = idUsuarioOrigem;
        this.idUsuarioDestino = idUsuarioDestino;
        this.observacao = observacao;
    }

    public Date getData() {return data;}
    public Acao getTipo() {return tipo;}
    public double getValorPretendido() {return valorPretendido;}
    public double getValorReal() {return valorReal;}
    public String getIdUsuarioOrigem() {return idUsuarioOrigem;}
    public String getIdUsuarioDestino() {return idUsuarioDestino;}
    public String getObservacao() {return observacao;}

    @Override
    public String toString() {
        return "HistoricoAcao{" +
                "data=" + data +
                ", tipo=" + tipo +
                ", valorPretendido=" + valorPretendido +
                ", valorReal=" + valorReal +
                ", idUsuarioOrigem='" + idUsuarioOrigem + '\'' +
                ", idUsuarioDestino='" + idUsuarioDestino + '\'' +
                ", observacao='" + observacao + '\'' +
                '}';
    }
}