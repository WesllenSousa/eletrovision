
package telas.geral.dependencias;

import controle.LogAcoes.SalvarLogAcoes;
import recursos.configuracoes.diretorios.ManipularArquivoProperties;
import recursos.configuracoes.diretorios.caminhos.ArquivosConfiguracao;
import recursos.configuracoes.diretorios.caminhos.ArquivosImagens;
import recursos.configuracoes.sistema.ConfigCores;
import recursos.configuracoes.sistema.ConfigDispositivos;
import controle.dispositivos.AcionarDispositivo;
import entidades.acionamento.bean.AcionamentoBean;
import entidades.acionamento.bean.EnumTipoAcionamento;
import entidades.acionamento.bean.EnumLigarDesligarAcionamento;
import entidades.acionamento.bean.EnumStatusAcionamento;
import entidades.acionamento.facade.AcionamentoFacade;
import entidades.camera.bean.CameraBean;
import entidades.dispositivoEletrico.bean.DispositivoEletricoBean;
import entidades.dispositivoEletrico.bean.EnumLigarDesligarDispositivoEletrico;
import entidades.dispositivoEletrico.facade.DispositivoEletricoFacade;
import entidades.itemAcionamento.bean.ItemAcionamentoBean;
import entidades.itemAcionamento.facade.ItemAcionamentoFacade;
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
import telas.geral.GeralCenario;
import telas.principal.AnimacaoPrincipal;
import telas.principal.AtualizaTelas;
import util.FacadeException;
import util.FactoryFacade;
import util.ImagemUtil;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class PainelCenario extends JPanel implements MouseListener{
    
    private SalvarLogAcoes salvarLogAcoes;
    private GeralCenario cenario;
    private AcionamentoBean acionamento;  
    private BufferedImage bufferedImage;
        
    public PainelCenario(GeralCenario cenario, AcionamentoBean acionamento) {
        this.cenario = cenario;
        addMouseListener(PainelCenario.this);
        setBorder(new EtchedBorder (EtchedBorder.LOWERED));
        corNormal();
        this.acionamento = acionamento;
        salvarLogAcoes = new SalvarLogAcoes();
        analizarEstadoCenario();
    }
    
    private void corNormal() {
        setBackground(ConfigCores.cinzaClaro()); //cinza claro
    }
    
    private void corInativo() {
        setBackground(ConfigCores.vermelhoClaro());//vermelho claro
    }
    
    private void corLigado() {
        setBackground(ConfigCores.verdeClaro()); //verde claro
    }
    
    public void ativarDesativar(){
        if(cenario.mi_ativarDesativar.getText().equals("Ativar")) {
            corNormal();
            acionamento.setStatus(EnumStatusAcionamento.ATIVO);
        } else {
            corInativo();
            acionamento.setStatus(EnumStatusAcionamento.INATIVO);
        }
        alterarAcionamento(acionamento);
    }
    
    public void ligarDesligar(){
        if(cenario.mi_ligarDesligar.getText().equals("Ligar")) {
            if(ConfigDispositivos.getStatus() && ConfigDispositivos.getAtivarAcionamento()
                    && acionamento.getStatus() == EnumStatusAcionamento.ATIVO) {
                for(ItemAcionamentoBean item : listarItemAcionamentoPorAcionamento(acionamento)) {
                    AcionarDispositivo.ligarDispositivo(item.getDispositivoEletrico());  
                }
                acionamento.setLigarDesligar(EnumLigarDesligarAcionamento.LIGADO);
                corLigado();
                animarDispositivo();
            } else {
                InstanciasControle.getMensagens().aviso(MensagensSoltas.gerCenarioConfigAcionamento());
            }
        } else {    
            for(ItemAcionamentoBean item : listarItemAcionamentoPorAcionamento(acionamento)) {
                AcionarDispositivo.desligarDispositivo(item.getDispositivoEletrico()); 
            }
            corNormal();
            acionamento.setLigarDesligar(EnumLigarDesligarAcionamento.DESLIGADO);
            pesquisarDispositivosLigados();
        }
        alterarAcionamento(acionamento);
        AtualizaTelas.geralMapaDispositivos();
        salvarLogAcoes.salvarAcionamento(acionamento, InstanciasControle.getUsuarioLogado().getPessoa(), EnumRedeLogAcoes.NAO);
    }
    
    public void tipo(){
        if(cenario.mi_nenhumAcionamento.isSelected()) {
            acionamento.setTipo(EnumTipoAcionamento.NENHUM_ACIONAMENTO);
        } else if(cenario.mi_controleAutomatico.isSelected()) {
            acionamento.setTipo(EnumTipoAcionamento.CONTROLE_AUTOMATICO);
        } else if(cenario.mi_detectarPessoas.isSelected()) {
            acionamento.setTipo(EnumTipoAcionamento.DETECTAR_PESSOAS);
        } else if(cenario.mi_reconhecerFaces.isSelected()) {
            acionamento.setTipo(EnumTipoAcionamento.RECONHECER_FACES);
        } else if(cenario.mi_alarme.isSelected()) {
            acionamento.setTipo(EnumTipoAcionamento.ALARME);
        }
        alterarAcionamento(acionamento);
    }
    
//======================================================================

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON3){
            analizarMenuCenario();
            cenario.acionamentoSelecionado = acionamento;
            cenario.mn_popupCenario.show(e.getComponent(), e.getX(), e.getY());
        } else if(e.getButton() == MouseEvent.BUTTON1) {
            analizarMenuCenario();
            ligarDesligar();
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
        setBorder(new EtchedBorder (EtchedBorder.LOWERED));
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
    
//======================================================================
    
    private void analizarEstadoCenario() {
        String descricao = "NOME: "+acionamento.getNome()+", DISPOSITIVOS: ";
        for(ItemAcionamentoBean bean : listarItemAcionamentoPorAcionamento(acionamento)) {
            descricao += bean.getDispositivoEletrico()+"; ";
        }
        if(!acionamento.getCameras().isEmpty()) {
            descricao += " CAMERAS: ";
        }
        for(CameraBean camera : acionamento.getCameras()) {
            descricao += camera+"; ";
        }
        setToolTipText(descricao);
        
        analizarMenuCenario();
        if(cenario.mi_ativarDesativar.getText().equals("Ativar")) {
            corInativo();
        } else {
            corNormal();
            if(cenario.mi_ligarDesligar.getText().equals("Ligar")) {
                corNormal();
            } else {
                corLigado();
            }
        } 
        bufferedImage = ImagemUtil.ler(ArquivosImagens.diretorio_cenario()+File.separator+acionamento.getFoto());
        repaint();
    }
    
    private void analizarMenuCenario(){
        if(acionamento.getStatus() == EnumStatusAcionamento.INATIVO){ //vermelho claro: desativado      
            cenario.mi_ativarDesativar.setText("Ativar");
            cenario.mi_ligarDesligar.setEnabled(false);
        } else {
            cenario.mi_ativarDesativar.setText("Desativar");
            cenario.mi_ligarDesligar.setEnabled(true);
        }
        if(acionamento.getLigarDesligar()== EnumLigarDesligarAcionamento.LIGADO){
            cenario.mi_ligarDesligar.setText("Desligar");
            cenario.mi_ativarDesativar.setEnabled(false);
            cenario.mi_editar.setEnabled(false);
        } else {
            cenario.mi_ligarDesligar.setText("Ligar");
            cenario.mi_ativarDesativar.setEnabled(true);
            cenario.mi_editar.setEnabled(true);
        }
        if(acionamento.getTipo() == EnumTipoAcionamento.NENHUM_ACIONAMENTO) {
            cenario.mi_nenhumAcionamento.setSelected(true);
        } else if(acionamento.getTipo() == EnumTipoAcionamento.CONTROLE_AUTOMATICO) {
            cenario.mi_controleAutomatico.setSelected(true);
        } else if(acionamento.getTipo() == EnumTipoAcionamento.DETECTAR_PESSOAS) {
            cenario.mi_detectarPessoas.setSelected(true);
        } else if(acionamento.getTipo() == EnumTipoAcionamento.RECONHECER_FACES) {
            cenario.mi_reconhecerFaces.setSelected(true);
        } else if(acionamento.getTipo() == EnumTipoAcionamento.ALARME) {
            cenario.mi_alarme.setSelected(true);
        }
    }
    
    public void salvarLocalizacao(Integer x, Integer y) {
        if(x != 0 && y != 0) {
            if(acionamento != null) {
                cenario.getProps().setProperty("Cenario_"+acionamento.getCodigo(), "("+x+","+y+")");
            } 
            ManipularArquivoProperties.salvarConfiguracao(cenario.getProps(), ArquivosConfiguracao.pixels(), "Configuração dos pixels");
        }
    }
     
    private void animarDispositivo() {
        AnimacaoPrincipal animacaoPrincipal = new AnimacaoPrincipal(4);
        Thread thread = new Thread(animacaoPrincipal);
        thread.start();
    }
    
    private void pesquisarDispositivosLigados() {
        Boolean status = false;
        for(DispositivoEletricoBean bean : listarDispositivosEletricos()) {
            if(bean.getLigarDesligar() == EnumLigarDesligarDispositivoEletrico.LIGADO) {
                status = true;
                break;
            }
        }
        if(!status) {
            InstanciasTelas.getPrincipal().lb_dispositivosEletricos.setIcon(new ImageIcon(getClass().getResource(ArquivosImagens.principal_dispositivosDesligados())));
        } 
    }
    
    /*
     * BANCO DE DADOS
     */
    
    private void alterarAcionamento(AcionamentoBean acionamento) {    
        AcionamentoFacade acionamentoFacade = FactoryFacade.getAcionamentoImpl();
        try {
            acionamentoFacade.alterar(acionamento);
        } catch (FacadeException ex) {
        }
    }
    
    private ArrayList<ItemAcionamentoBean> listarItemAcionamentoPorAcionamento(AcionamentoBean acionamento) {
        ItemAcionamentoFacade itemAcionamentoFacade = FactoryFacade.getItemAcionamentoImpl();
        try {
            return itemAcionamentoFacade.listarItemAcionamentoPorAcionamento(acionamento);
        } catch (FacadeException ex) {
        }
        return null;
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
