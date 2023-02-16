package br.inatel.cdg.nasa.MODEL;

public class Viagem
{
    private int planeta_idPlaneta;  // chave estrangeira
    private int nave_idNave;  // chave estrangeira
    private float distancia;
    private int mapa_idMapa; // chave estrangeira
    private int idViagem;

    // Getters e Setters
    public int getPlaneta_idPlaneta() {return planeta_idPlaneta;}
    public void setPlaneta_idPlaneta(int planeta_idPlaneta) {this.planeta_idPlaneta = planeta_idPlaneta;}
    public int getNave_idNave() {return nave_idNave;}
    public void setNave_idNave(int nave_idNave) {this.nave_idNave = nave_idNave;}
    public float getDistancia() {return distancia;}
    public void setDistancia(float distancia) {this.distancia = distancia;}
    public int getMapa_idMapa() {return mapa_idMapa;}
    public void setMapa_idMapa(int mapa_idMapa) {this.mapa_idMapa = mapa_idMapa;}
    public int getIdViagem() {return idViagem;}
    public void setIdViagem(int idViagem) {this.idViagem = idViagem;}
}
