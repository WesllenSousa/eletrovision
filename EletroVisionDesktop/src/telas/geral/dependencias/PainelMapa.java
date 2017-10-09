package telas.geral.dependencias;

import controle.LogAcoes.SalvarLogAcoes;
import recursos.configuracoes.diretorios.ManipularArquivoProperties;
import recursos.configuracoes.diretorios.caminhos.ArquivosConfiguracao;
import recursos.configuracoes.diretorios.caminhos.ArquivosImagens;
import recursos.configuracoes.sistema.ConfigCores;
import recursos.configuracoes.sistema.ConfigDispositivos;
import controle.dispositivos.AcionarDispositivo;
import entidades.camera.bean.CameraBean;
import entidades.camera.facade.CameraFacade;
import entidades.configCamera.bean.*;
import entidades.configCamera.facade.ConfigCameraFacade;
import entidades.dispositivo.bean.EnumStatusDispositivo;
import entidades.dispositivoEletrico.bean.DispositivoEletricoBean;
import entidades.dispositivoEletrico.bean.EnumDuracaoDispositivoEletrico;
import entidades.dispositivoEletrico.bean.EnumLigarDesligarDispositivoEletrico;
import entidades.dispositivoEletrico.facade.DispositivoEletricoFacade;
import entidades.logAcoes.bean.EnumRedeLogAcoes;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import recursos.instancias.InstanciasControle;
import recursos.instancias.InstanciasTelas;
import recursos.internacionalizacao.MensagensSoltas;
import telas.geral.GeralMapaDispositivos;
import telas.principal.AnimacaoPrincipal;
import util.FacadeException;
import util.FactoryFacade;
import util.ImagemUtil;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class PainelMapa extends JPanel implements MouseListener {

    private GeralMapaDispositivos mapaDispositivos;
    private CameraBean camera;
    private DispositivoEletricoBean dispositivoEletrico;
    private SalvarLogAcoes salvarLogAcoes;
    private BufferedImage bufferedImage;

    public PainelMapa(GeralMapaDispositivos mapaDispositivos, Object object) {
        addMouseListener(PainelMapa.this);
        verificarInstancia(object);
        setBorder(new EtchedBorder(EtchedBorder.LOWERED));
        this.mapaDispositivos = mapaDispositivos;
        salvarLogAcoes = new SalvarLogAcoes();
        analizarEstadoPainelMapa();
    }

    private void corDispositivo() {
        setBackground(ConfigCores.azul());
    }

    private void corCamera() {
        setBackground(ConfigCores.amarelo());
    }

    private void corInativo() {
        setBackground(ConfigCores.vermelhoClaro());
    }

    private void corLigado() {
        setBackground(ConfigCores.verdeClaro());
    }

    public void ativarDesativarCamera() {
        if (mapaDispositivos.mi_ativarDesativarC.getText().equals("Ativar")) {
            camera.setStatus(EnumStatusDispositivo.ATIVO);
            corCamera();
        } else {
            camera.setStatus(EnumStatusDispositivo.INATIVO);
            corInativo();
        }
        alterarCamera(camera);
    }

    public void adaptarAmbiente() {
        if (mapaDispositivos.mi_adaptarAmbiente.isSelected()) {
            camera.getConfigCamera().setTipoProcessamento(EnumTipoProcessamentoConfigCamera.ADAPTAR_AMBIENTE);
        }
        alterarConfigCamera(camera.getConfigCamera());
    }

    public void mudancaAmbiente() {
        if (mapaDispositivos.mi_mudancaAmbiente.isSelected()) {
            camera.getConfigCamera().setTipoProcessamento(EnumTipoProcessamentoConfigCamera.AMBIENTE_STATICO);
        }
        alterarConfigCamera(camera.getConfigCamera());
    }

    public void movimento() {
        if (mapaDispositivos.mi_movimento.isSelected()) {
            camera.getConfigCamera().setMovimento(EnumMovimentoConfigCamera.SIM);
        } else {
            camera.getConfigCamera().setMovimento(EnumMovimentoConfigCamera.NAO);
        }
        alterarConfigCamera(camera.getConfigCamera());
    }

    public void ambienteStatico() {
        if (mapaDispositivos.mi_ambienteStatico.isSelected()) {
            camera.getConfigCamera().setAmbienteStatico(EnumAmbienteStaticoConfigCamera.SIM);
        } else {
            camera.getConfigCamera().setAmbienteStatico(EnumAmbienteStaticoConfigCamera.NAO);
        }
        alterarConfigCamera(camera.getConfigCamera());
    }

    public void detectarObjeto() {
        if (mapaDispositivos.mi_detectarObjeto.isSelected()) {
            camera.getConfigCamera().setObjeto(EnumObjetoConfigCamera.SIM);
        } else {
            camera.getConfigCamera().setObjeto(EnumObjetoConfigCamera.NAO);
        }
        alterarConfigCamera(camera.getConfigCamera());
    }

    public void detectarFace() {
        if (mapaDispositivos.mi_detectarFace.isSelected()) {
            camera.getConfigCamera().setFace(EnumFaceConfigCamera.SIM);
        } else {
            camera.getConfigCamera().setFace(EnumFaceConfigCamera.NAO);
        }
        alterarConfigCamera(camera.getConfigCamera());
    }

    public void reconhecerFace() {
        if (mapaDispositivos.mi_reconhecerFace.isSelected()) {
            camera.getConfigCamera().setReconhecerFace(EnumReconhecerFaceConfigCamera.SIM);
        } else {
            camera.getConfigCamera().setReconhecerFace(EnumReconhecerFaceConfigCamera.NAO);
        }
        alterarConfigCamera(camera.getConfigCamera());
    }

    public void detectarOlho() {
        if (mapaDispositivos.mi_detectarOlho.isSelected()) {
            camera.getConfigCamera().setOlhos(EnumOlhosConfigCamera.SIM);
        } else {
            camera.getConfigCamera().setOlhos(EnumOlhosConfigCamera.NAO);
        }
        alterarConfigCamera(camera.getConfigCamera());
    }

    public void detectarCorpo() {
        if (mapaDispositivos.mi_detectarCorpo.isSelected()) {
            camera.getConfigCamera().setCorpo(EnumCorpoConfigCamera.SIM);
        } else {
            camera.getConfigCamera().setCorpo(EnumCorpoConfigCamera.NAO);
        }
        alterarConfigCamera(camera.getConfigCamera());
    }

    public void campanhia() {
        if (mapaDispositivos.mi_campanhia.isSelected()) {
            camera.getConfigCamera().setCampanhia(EnumCampanhiaConfigCamera.SIM);
        } else {
            camera.getConfigCamera().setCampanhia(EnumCampanhiaConfigCamera.NAO);
        }
        alterarConfigCamera(camera.getConfigCamera());
    }

    public void dispositivos() {
        if (mapaDispositivos.mi_dispositivos.isSelected()) {
            camera.getConfigCamera().setDispositivo(EnumDispositivoConfigCamera.SIM);
        } else {
            camera.getConfigCamera().setDispositivo(EnumDispositivoConfigCamera.NAO);
        }
        alterarConfigCamera(camera.getConfigCamera());
    }

    public void gravar() {
        if (mapaDispositivos.mi_gravar.isSelected()) {
            camera.getConfigCamera().setGravar(EnumGravarConfigCamera.SIM);
        } else {
            camera.getConfigCamera().setGravar(EnumGravarConfigCamera.NAO);
        }
        alterarConfigCamera(camera.getConfigCamera());
    }

    public void ativarDesativarDispositivoEletrico() {
        if (mapaDispositivos.mi_ativarDesativarD.getText().equals("Ativar")) {
            dispositivoEletrico.setStatus(EnumStatusDispositivo.ATIVO);
            corDispositivo();
        } else {
            dispositivoEletrico.setStatus(EnumStatusDispositivo.INATIVO);
            corInativo();
        }
        alterarDispositivoEletrico(dispositivoEletrico);
    }

    public void ligarDesligarDispositivoEletrico() {
        if (mapaDispositivos.mi_ligarDesligar.getText().equals("Ligar")) {
            if (ConfigDispositivos.getStatus() && ConfigDispositivos.getAtivarAcionamento()) {
                if (AcionarDispositivo.ligarDispositivo(dispositivoEletrico)) {
                    if (dispositivoEletrico.getDuracao() == EnumDuracaoDispositivoEletrico.PERMANENTE) {
                        corLigado();
                    }
                    animarDispositivo();
                } else {
                    InstanciasControle.getMensagens().aviso(MensagensSoltas.gerDispositivosErroAcionar());
                }
            } else {
                InstanciasControle.getMensagens().aviso(MensagensSoltas.gerCenarioConfigAcionamento());
            }
        } else if (AcionarDispositivo.desligarDispositivo(dispositivoEletrico)) {
            corDispositivo();
        } else {
            InstanciasControle.getMensagens().aviso(MensagensSoltas.gerDispositivosErroAcionar());
        }
        salvarLogAcoes.salvarDispositivoEletrico(dispositivoEletrico, InstanciasControle.getUsuarioLogado().getPessoa(), EnumRedeLogAcoes.NAO);
        pesquisarDispositivosLigados();
    }

//======================================================================
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON3) {
            if (camera != null) {
                analisarMenuCamera();
                mapaDispositivos.cameraSelecionada = camera;
                mapaDispositivos.mn_camera.show(e.getComponent(), e.getX(), e.getY());
            } else if (dispositivoEletrico != null) {
                analizarMenuDispositivoEletrico();
                mapaDispositivos.dispositivoEletricoSelecionado = dispositivoEletrico;
                mapaDispositivos.mn_dispositivoEletrico.show(e.getComponent(), e.getX(), e.getY());
            }
        } else if (e.getButton() == MouseEvent.BUTTON1) {
            if (camera != null) {
                mapaDispositivos.cameraSelecionada = camera;
                mapaDispositivos.visualizarCamera();
            } else if (dispositivoEletrico != null) {
                if (dispositivoEletrico.getStatus() == EnumStatusDispositivo.ATIVO) {
                    analizarMenuDispositivoEletrico();
                    ligarDesligarDispositivoEletrico();
                } else {
                    InstanciasControle.getMensagens().aviso(MensagensSoltas.gerDispositivosDesativado());
                }
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (bufferedImage != null) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2.drawImage(bufferedImage, 10, 10, bufferedImage.getWidth(), bufferedImage.getHeight(), this);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        setBorder(new BevelBorder(BevelBorder.RAISED));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        setBorder(new EtchedBorder(EtchedBorder.LOWERED));
    }

//======================================================================
    public CameraBean getCamera() {
        return camera;
    }

    public DispositivoEletricoBean getDispositivoEletrico() {
        return dispositivoEletrico;
    }

    private void verificarInstancia(Object object) {
        if (object instanceof CameraBean) {
            camera = (CameraBean) object;
            corCamera();
        } else if (object instanceof DispositivoEletricoBean) {
            dispositivoEletrico = (DispositivoEletricoBean) object;
            corDispositivo();
        }
    }

    private void analizarEstadoPainelMapa() {
        if (camera != null) {
            setToolTipText(camera.getIdentificacao() + " - " + camera.getNome());
            bufferedImage = ImagemUtil.ler(ArquivosImagens.diretorio_cameras() + File.separator + camera.getFoto());
            analisarMenuCamera();
            if (mapaDispositivos.mi_ativarDesativarC.getText().equals("Ativar")) {
                corInativo();
            } else {
                corCamera();
            }
        } else if (dispositivoEletrico != null) {
            setToolTipText(dispositivoEletrico.getNome());
            bufferedImage = ImagemUtil.ler(ArquivosImagens.diretorio_dispositivos() + File.separator + dispositivoEletrico.getFoto());
            analizarMenuDispositivoEletrico();
            if (mapaDispositivos.mi_ativarDesativarD.getText().equals("Ativar")) {
                corInativo();
            } else if (mapaDispositivos.mi_ligarDesligar.getText().equals("Desligar")) {
                corLigado();
            } else {
                corDispositivo();
            }
        }
        repaint();
    }

    private void analisarMenuCamera() {
        if (camera.getConfigCamera().getTipoProcessamento() == EnumTipoProcessamentoConfigCamera.ADAPTAR_AMBIENTE) {
            mapaDispositivos.mi_adaptarAmbiente.setSelected(true);
        } else {
            mapaDispositivos.mi_mudancaAmbiente.setSelected(true);
        }
        if (camera.getStatus() == EnumStatusDispositivo.ATIVO) {
            mapaDispositivos.mi_ativarDesativarC.setText("Desativar");
        } else {
            mapaDispositivos.mi_ativarDesativarC.setText("Ativar");
        }
        if (camera.getConfigCamera().getMovimento() == EnumMovimentoConfigCamera.SIM) {
            mapaDispositivos.mi_movimento.setSelected(true);
        } else {
            mapaDispositivos.mi_movimento.setSelected(false);
        }
        if (camera.getConfigCamera().getAmbienteStatico() == EnumAmbienteStaticoConfigCamera.SIM) {
            mapaDispositivos.mi_ambienteStatico.setSelected(true);
        } else {
            mapaDispositivos.mi_ambienteStatico.setSelected(false);
        }
        if (camera.getConfigCamera().getFace() == EnumFaceConfigCamera.SIM) {
            mapaDispositivos.mi_detectarFace.setSelected(true);
        } else {
            mapaDispositivos.mi_detectarFace.setSelected(false);
        }
        if (camera.getConfigCamera().getReconhecerFace() == EnumReconhecerFaceConfigCamera.SIM) {
            mapaDispositivos.mi_reconhecerFace.setSelected(true);
        } else {
            mapaDispositivos.mi_reconhecerFace.setSelected(false);
        }
        if (camera.getConfigCamera().getObjeto() == EnumObjetoConfigCamera.SIM) {
            mapaDispositivos.mi_detectarObjeto.setSelected(true);
        } else {
            mapaDispositivos.mi_detectarObjeto.setSelected(false);
        }
        if (camera.getConfigCamera().getOlhos() == EnumOlhosConfigCamera.SIM) {
            mapaDispositivos.mi_detectarOlho.setSelected(true);
        } else {
            mapaDispositivos.mi_detectarOlho.setSelected(false);
        }
        if (camera.getConfigCamera().getCorpo() == EnumCorpoConfigCamera.SIM) {
            mapaDispositivos.mi_detectarCorpo.setSelected(true);
        } else {
            mapaDispositivos.mi_detectarCorpo.setSelected(false);
        }
        if (camera.getConfigCamera().getCampanhia() == EnumCampanhiaConfigCamera.SIM) {
            mapaDispositivos.mi_campanhia.setSelected(true);
        } else {
            mapaDispositivos.mi_campanhia.setSelected(false);
        }
        if (camera.getConfigCamera().getGravar() == EnumGravarConfigCamera.SIM) {
            mapaDispositivos.mi_gravar.setSelected(true);
        } else {
            mapaDispositivos.mi_gravar.setSelected(false);
        }
        if (camera.getConfigCamera().getDispositivo() == EnumDispositivoConfigCamera.SIM) {
            mapaDispositivos.mi_dispositivos.setSelected(true);
        } else {
            mapaDispositivos.mi_dispositivos.setSelected(false);
        }
    }

    private void analizarMenuDispositivoEletrico() {
        if (dispositivoEletrico.getStatus() == EnumStatusDispositivo.ATIVO) {
            mapaDispositivos.mi_ativarDesativarD.setText("Desativar");
            mapaDispositivos.mi_ligarDesligar.setEnabled(true);
        } else {
            mapaDispositivos.mi_ativarDesativarD.setText("Ativar");
            mapaDispositivos.mi_ligarDesligar.setEnabled(false);
        }
        if (dispositivoEletrico.getLigarDesligar() == EnumLigarDesligarDispositivoEletrico.LIGADO) {
            mapaDispositivos.mi_ligarDesligar.setText("Desligar");
            mapaDispositivos.mi_ativarDesativarD.setEnabled(false);
        } else {
            mapaDispositivos.mi_ligarDesligar.setText("Ligar");
            mapaDispositivos.mi_ativarDesativarD.setEnabled(true);
        }
        if (dispositivoEletrico.getLigarDesligar() == EnumLigarDesligarDispositivoEletrico.LIGADO
                && dispositivoEletrico.getStatus() == EnumStatusDispositivo.INATIVO) {
            mapaDispositivos.mi_ativarDesativarD.setEnabled(true);
        }
    }

    public void salvarLocalizacao(Integer x, Integer y) {
        if (x != 0 && y != 0) {
            if (camera != null) {
                mapaDispositivos.getProps().setProperty("Camera_" + camera.getCodigo(), "(" + x + "," + y + ")");
            } else if (dispositivoEletrico != null) {
                mapaDispositivos.getProps().setProperty("DispositivoEletrico_" + dispositivoEletrico.getCodigo(), "(" + x + "," + y + ")");
            }
            ManipularArquivoProperties.salvarConfiguracao(mapaDispositivos.getProps(), ArquivosConfiguracao.pixels(), "Configuração dos pixels");
        }
    }

    private void animarDispositivo() {
        AnimacaoPrincipal animacaoPrincipal = new AnimacaoPrincipal(4);
        Thread thread = new Thread(animacaoPrincipal);
        thread.start();
    }

    private void pesquisarDispositivosLigados() {
        Boolean status = false;
        for (DispositivoEletricoBean bean : listarDispositivosEletricos()) {
            if (bean.getLigarDesligar() == EnumLigarDesligarDispositivoEletrico.LIGADO) {
                status = true;
                break;
            }
        }
        if (!status) {
            InstanciasTelas.getPrincipal().lb_dispositivosEletricos.setIcon(new ImageIcon(
                    getClass().getResource(ArquivosImagens.principal_dispositivosDesligados())));
        }
    }

    /*
     * BANCO DE DADOS
     */
    private void alterarCamera(CameraBean camera) {
        CameraFacade cameraFacade = FactoryFacade.getCameraImpl();
        try {
            cameraFacade.alterar(camera);
        } catch (FacadeException ex) {
        }
    }

    private void alterarConfigCamera(ConfigCameraBean configCamera) {
        ConfigCameraFacade configCameraFacade = FactoryFacade.getConfigCameraImpl();
        try {
            configCameraFacade.alterar(configCamera);
        } catch (FacadeException ex) {
        }
    }

    private void alterarDispositivoEletrico(DispositivoEletricoBean dispositivoEletrico) {
        DispositivoEletricoFacade dispositivoEletricoFacade = FactoryFacade.getDispositivoEletricoImpl();
        try {
            dispositivoEletricoFacade.alterar(dispositivoEletrico);
        } catch (FacadeException ex) {
        }
    }

    private ArrayList<DispositivoEletricoBean> listarDispositivosEletricos() {
        DispositivoEletricoFacade dispositivoEletricoFacade = FactoryFacade.getDispositivoEletricoImpl();
        try {
            return (ArrayList<DispositivoEletricoBean>) dispositivoEletricoFacade.listar();
        } catch (FacadeException ex) {
        }
        return null;
    }

}
