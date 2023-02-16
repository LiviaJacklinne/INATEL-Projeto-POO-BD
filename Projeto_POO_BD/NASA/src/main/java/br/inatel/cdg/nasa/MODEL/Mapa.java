package br.inatel.cdg.nasa.MODEL;

public class Mapa
{
    // Atributos
    protected  int idMapa;
    protected String titulo;
    protected String orientacoes;
    protected int obstaculos;

    // Getters e Setters
    public int getIdMapa() {return idMapa;}
    public void setIdMapa(int idMapa) {this.idMapa = idMapa;}
    public String getTitulo() {return titulo;}
    public void setTitulo(String titulo) {this.titulo = titulo;}
    public String getOrientacoes() {return orientacoes;}
    public void setOrientacoes(String orientacoes) {this.orientacoes = orientacoes;}
    public int getObstaculos() {return obstaculos;}
    public void setObstaculos(int obstaculos) {this.obstaculos = obstaculos;}

}
