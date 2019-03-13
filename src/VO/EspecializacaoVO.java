package VO;
public class EspecializacaoVO {
    
    private int espeCod;
    private int espCod;
    private int medCod;
    private String espAnoEspecializacao;

    public EspecializacaoVO() {
    }

    public EspecializacaoVO(int espeCod, int espCod, int medCod, String espAnoEspecializacao) {
        this.espeCod = espeCod;
        this.espCod = espCod;
        this.medCod = medCod;
        this.espAnoEspecializacao = espAnoEspecializacao;
    }

    public int getEspeCod() {
        return espeCod;
    }

    public void setEspeCod(int espeCod) {
        this.espeCod = espeCod;
    }

    public int getEspCod() {
        return espCod;
    }

    public void setEspCod(int espCod) {
        this.espCod = espCod;
    }

    public int getMedCod() {
        return medCod;
    }

    public void setMedCod(int medCod) {
        this.medCod = medCod;
    }

    public String getEspAnoEspecializacao() {
        return espAnoEspecializacao;
    }

    public void setEspAnoEspecializacao(String espAnoEspecializacao) {
        this.espAnoEspecializacao = espAnoEspecializacao;
    }

    
}
