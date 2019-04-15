package br.com.hypolito.TestBEXS.model;

import java.util.Objects;

public class Rota {

    private String origem;
    private String destino;
    private Double valor;

    public Rota(String origem, String destino, String valor) {
        this.origem = origem;
        this.destino = destino;
        this.valor = Double.valueOf(valor);
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Rota{" +
                "origem='" + origem + '\'' +
                ", destino='" + destino + '\'' +
                ", valor=" + valor +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rota)) return false;
        Rota rota = (Rota) o;
        return Objects.equals(getOrigem(), rota.getOrigem()) &&
                Objects.equals(getDestino(), rota.getDestino()) &&
                Objects.equals(getValor(), rota.getValor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrigem(), getDestino(), getValor());
    }
}
