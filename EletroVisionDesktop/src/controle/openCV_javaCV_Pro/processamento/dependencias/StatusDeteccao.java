
package controle.openCV_javaCV_Pro.processamento.dependencias;

import recursos.configuracoes.sistema.ConfigDispositivos;
import java.awt.image.BufferedImage;
import util.DataUtil;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class StatusDeteccao {
    
    private Long inicioProcessamento = 0l;
    private Long fimProcessamento = 0l;
    private Long inicioControleAutomatico = 0l;
    private Long fimControleAutomatico = 0l;
    private Long inicioGravacao = 0l;
    private Long fimGravacao = 0l;
    
    private BufferedImage imagemSalvar = null;
    private Integer objetoCorpo = -1;
    private Integer qtdePessoas = 0;
    private Integer qtdeObjetos = 0;
    private Boolean detectado = false;
    private Boolean mandarMensagem = true;
    private String faceReconhecida;
    
    private Boolean detectadoObjeto = false;
    private Boolean detectadoFace = false;
    private Boolean detectadoOlhos = false;
    private Boolean detectadoCorpo = false;
    
    public void setInicioProcessamento(Long inicio) {
        this.inicioProcessamento = inicio;
    }

    public void setInicioControleAutomatico(Long inicioControleAutomatico) {
        this.inicioControleAutomatico = inicioControleAutomatico;
    }

    public void setInicioGravacao(Long inicioGravacao) {
        this.inicioGravacao = inicioGravacao;
    }
    
    public BufferedImage getImagemSalvar() {
        return imagemSalvar;
    }

    public void setImagemSalvar(BufferedImage imagemSalvar) {
        this.imagemSalvar = imagemSalvar;
    }

    public Integer getObjetoCorpo() {
        return objetoCorpo;
    }

    public void setObjetoCorpo(Integer deteccao) {
        this.objetoCorpo = deteccao;
    }

    public Boolean getDetectado() {
        return detectado;
    }

    public void setDetectado(Boolean detectado) {
        this.detectado = detectado;
    }

    public Integer getQtdeObjetos() {
        return qtdeObjetos;
    }

    public void setQtdeObjetos(Integer qtdeObjetos) {
        this.qtdeObjetos = qtdeObjetos;
    }

    public Integer getQtdePessoas() {
        return qtdePessoas;
    }

    public void setQtdePessoas(Integer qtdePessoas) {
        this.qtdePessoas = qtdePessoas;
    }

    public Boolean getMandarMensagem() {
        return mandarMensagem;
    }

    public void setMandarMensagem(Boolean mandarMensagem) {
        this.mandarMensagem = mandarMensagem;
    }

    public String getFaceReconhecida() {
        return faceReconhecida;
    }

    public void setFaceReconhecida(String faceReconhecida) {
        this.faceReconhecida = faceReconhecida;
    }

    public Long getFimProcessamento() {
        return fimProcessamento;
    }

    public void setFimProcessamento(Long fimProcessamento) {
        this.fimProcessamento = fimProcessamento;
    }

    public Long getFimControleAutomatico() {
        return fimControleAutomatico;
    }

    public void setFimControleAutomatico(Long fimControleAutomatico) {
        this.fimControleAutomatico = fimControleAutomatico;
    }

    public Long getFimGravacao() {
        return fimGravacao;
    }

    public void setFimGravacao(Long fimGravacao) {
        this.fimGravacao = fimGravacao;
    }

    public Boolean getDetectadoObjeto() {
        return detectadoObjeto;
    }

    public void setDetectadoObjeto(Boolean detectadoObjeto) {
        this.detectadoObjeto = detectadoObjeto;
    }

    public Boolean getDetectadoFace() {
        return detectadoFace;
    }

    public void setDetectadoFace(Boolean detectadoFace) {
        this.detectadoFace = detectadoFace;
    }

    public Boolean getDetectadoOlhos() {
        return detectadoOlhos;
    }

    public void setDetectadoOlhos(Boolean detectadoOlhos) {
        this.detectadoOlhos = detectadoOlhos;
    }

    public Boolean getDetectadoCorpo() {
        return detectadoCorpo;
    }

    public void setDetectadoCorpo(Boolean detectadoCorpo) {
        this.detectadoCorpo = detectadoCorpo;
    }  
       
//==============================TEMPOS=========================================
    
    public Boolean verificaTempoExecucaoProcessamento() {
        fimProcessamento = System.currentTimeMillis();
        Float segundo = DataUtil.milisegundoParaSegundo(inicioProcessamento, fimProcessamento);
        if(segundo >= ConfigDispositivos.getIntervaloProcessamento()){
            inicioProcessamento = -1000l;
            return true;
        } else {
            return false;
        }
    }
    
    public Boolean verificaTempoControleAutomatico() {
        fimControleAutomatico = System.currentTimeMillis();
        Integer minuto = DataUtil.milisegundoParaMinuto(inicioControleAutomatico, fimControleAutomatico);
        if(minuto >= ConfigDispositivos.getTempoControleAutomatico()){
            inicioControleAutomatico = System.currentTimeMillis();
            return true;
        } else {
            return false;
        }
    }
    
    public Boolean verificaTempoGravacao() {
        fimGravacao = System.currentTimeMillis();
        Float segundo = DataUtil.milisegundoParaSegundo(inicioGravacao, fimGravacao);
        if(segundo >= ConfigDispositivos.getIntervaloProcessamento()+5){
            inicioGravacao = -1000l;
            return true;
        } else {
            return false;
        }
    }
    
}
