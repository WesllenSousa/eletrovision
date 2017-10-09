package telas.comuns.camera;

import recursos.configuracoes.diretorios.caminhos.ArquivosImagens;
import recursos.configuracoes.sistema.ConfigDispositivos;
import controle.mensagens.sistema.MontarMensagens;
import controle.openCV_javaCV_Pro.camera.ServidorCamera;
import entidades.configCamera.bean.*;
import entidades.configCamera.facade.ConfigCameraFacade;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.*;
import recursos.instancias.InstanciasControle;
import recursos.internacionalizacao.MensagensSoltas;
import telas.comuns.imagens.ImagemPanel;
import telas.principal.AtualizaTelas;
import util.FacadeException;
import util.FactoryFacade;
import util.ImagemUtil;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class InternalFrameCamera extends JInternalFrame implements ActionListener, MouseListener {
    
    private ServidorCamera servidorCamera; 

    private File arquivoImagem;
    private BufferedImage bufferedImage;
    private ImagemPanel imagemPanel;
    private JScrollPane scrollPane;
     
    private JMenuBar barraMenu;
    private JMenu camera, acoes, pessoas;
    private JCheckBoxMenuItem detectarObjeto, detectarFace, detectarCorpo, detectarOlhos, 
                              dispositivos, reconhecerFace, campanhia, movimento, ambienteStatico;
    private JMenuItem iniciarParar, aumentarTela, pausar, gravar, controle;
    private JRadioButtonMenuItem adaptarAmbiente, mudancaAmbiente;
    private ButtonGroup grupoMovimento;

    public InternalFrameCamera(ServidorCamera servidorCamera) {
        this.servidorCamera = servidorCamera;
        this.iniciar();        
    }
    
    public void pintarPanel(BufferedImage bufferedImage) {
        this.getImagePanel().setPreferredSize(new java.awt.Dimension(bufferedImage.getWidth(null), bufferedImage.getHeight(null)));
        this.getImagePanel().draw(bufferedImage);
    }

    public void exibirNoPainel() {
        this.carregarImagem();
        this.pintarPanel(this.getBufferedImage());
    }

    public void recarregar() {
        this.pintarPanel(this.getBufferedImage());
    }

    private void iniciar() {
        this.setImageFile(null);
        this.setBufferedImage(null);

        this.setImagePanel(new ImagemPanel());
        this.setScrollPane(new JScrollPane());

        this.getContentPane().setLayout(new java.awt.GridLayout());
        this.setClosable(false);
        this.setIconifiable(true);
        this.setMaximizable(false);
        this.setResizable(false);
        this.setAutoscrolls(true);
        this.setVisible(true);
        this.setSize(600, 500);
        
        grupoMovimento = new ButtonGroup();
        
        camera = new JMenu("Câmera");    
        camera.addMouseListener(this);
        camera.setMnemonic(KeyEvent.VK_C);
        
            iniciarParar = new JMenuItem("Iniciar");
            iniciarParar.addActionListener(this);
            iniciarParar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.ALT_MASK));
            camera.add(iniciarParar);
            
            pausar = new JMenuItem("Pausar");
            pausar.addActionListener(this);
            pausar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.ALT_MASK));
            camera.add(pausar);
            
            gravar = new JMenuItem("Gravar");
            gravar.addActionListener(this);
            gravar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.ALT_MASK));
            camera.add(gravar);
            
            aumentarTela = new JMenuItem("Aumentar Tela");
            aumentarTela.addActionListener(this);
            aumentarTela.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.ALT_MASK));
            camera.add(aumentarTela);
            
            camera.addSeparator();
            
            adaptarAmbiente = new JRadioButtonMenuItem("Adaptar ao Ambiente");
            adaptarAmbiente.addActionListener(this);
            adaptarAmbiente.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.ALT_MASK));
            camera.add(adaptarAmbiente);
            grupoMovimento.add(adaptarAmbiente);
            
            mudancaAmbiente = new JRadioButtonMenuItem("Detectar Mudança no Ambiente");
            mudancaAmbiente.addActionListener(this);
            mudancaAmbiente.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.ALT_MASK));
            camera.add(mudancaAmbiente);
            grupoMovimento.add(mudancaAmbiente); 
            
            if(servidorCamera.getCamera().getPorta() != null) {
                camera.addSeparator();
                controle = new JMenuItem("Controle");
                controle.addActionListener(this);
                controle.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.ALT_MASK));
                camera.add(controle);
            }
        
        acoes = new JMenu("Ações");    
        acoes.addMouseListener(this);
        acoes.setMnemonic(KeyEvent.VK_S); 
        
            movimento = new JCheckBoxMenuItem("Movimento");
            movimento.addActionListener(this);
            movimento.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.ALT_MASK));
            acoes.add(movimento);
            
            ambienteStatico = new JCheckBoxMenuItem("Ambiente stático");
            ambienteStatico.addActionListener(this);
            ambienteStatico.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.ALT_MASK));
            acoes.add(ambienteStatico);
            
            detectarObjeto = new JCheckBoxMenuItem("Detectar Objeto");
            detectarObjeto.addActionListener(this);
            detectarObjeto.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.ALT_MASK));
            acoes.add(detectarObjeto);
          
            dispositivos = new JCheckBoxMenuItem("Ativar Dispositivos");
            dispositivos.addActionListener(this);
            dispositivos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.ALT_MASK));
            acoes.add(dispositivos);
            
            campanhia = new JCheckBoxMenuItem("Campanhia");
            campanhia.addActionListener(this);
            campanhia.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.ALT_MASK));
            acoes.add(campanhia);  
            
        pessoas = new JMenu("Pessoas");    
        pessoas.addMouseListener(this);
        pessoas.setMnemonic(KeyEvent.VK_T); //sublinha a letra 'A' para ser usada pela tecla ALT.
        
            detectarCorpo = new JCheckBoxMenuItem("Detectar Corpo");
            detectarCorpo.addActionListener(this);
            detectarCorpo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.ALT_MASK));
            pessoas.add(detectarCorpo);
            
            detectarFace = new JCheckBoxMenuItem("Detectar Face");
            detectarFace.addActionListener(this);
            detectarFace.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.ALT_MASK));
            pessoas.add(detectarFace);
            
            detectarOlhos = new JCheckBoxMenuItem("Detectar Olhos");
            detectarOlhos.addActionListener(this);
            detectarOlhos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.ALT_MASK));
            pessoas.add(detectarOlhos);
            
            reconhecerFace = new JCheckBoxMenuItem("Reconhecer Face");
            reconhecerFace.addActionListener(this);
            reconhecerFace.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.ALT_MASK));
            pessoas.add(reconhecerFace);
            
        barraMenu = new JMenuBar();
        barraMenu.add(camera); 
        barraMenu.add(acoes);
        barraMenu.add(pessoas);
        setJMenuBar(barraMenu);
        
        this.addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            @Override
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            @Override
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                fecharFrame();
            }
            @Override
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            @Override
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            @Override
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            @Override
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            @Override
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        this.getScrollPane().setBackground(new java.awt.Color(153, 153, 255));
        this.getScrollPane().setBorder(new javax.swing.border.TitledBorder(null, null, javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 204)));
        this.getScrollPane().setPreferredSize(new java.awt.Dimension(769, 60));
        this.getScrollPane().setViewportView(this.getImagePanel());

        getContentPane().add(this.getScrollPane(), new java.awt.GridLayout());
        this.getImagePanel().setBackground(new java.awt.Color(153, 153, 153));

        this.setFrameIcon(new ImageIcon(getClass().getResource(ArquivosImagens.logo())));

        this.pack();
    }

    private void carregarImagem() {
        this.setBufferedImage(ImagemUtil.ler(this.getImageFile()));
    }
    
    public File getImageFile() {
        return arquivoImagem;
    }

    public void setImageFile(File imageFile) {
        this.arquivoImagem = imageFile;
    }

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    public void setBufferedImage(BufferedImage buffer) {
        this.bufferedImage = buffer;
    }

    public ImagemPanel getImagePanel() {
        return imagemPanel;
    }

    private void setImagePanel(ImagemPanel imagePanel) {
        this.imagemPanel = imagePanel;
    }

    private JScrollPane getScrollPane() {
        return scrollPane;
    }

    private void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    private void fecharFrame() {
        this.setBufferedImage(null);
        this.setImageFile(null);
        this.setImagePanel(null);
        this.setScrollPane(null);
        // chama o coletor de lixo
        System.gc();
    }

    public void setCamera() {        
        this.setName(servidorCamera.getCamera().getNome());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == iniciarParar){
            switch (iniciarParar.getText()) {
                case "Iniciar" : 
                    String identificacao;
                    if(servidorCamera.getCamera().getPorta() != null) {
                        identificacao = MontarMensagens.urlCameraConexao(servidorCamera.getCamera().getIdentificacao(), servidorCamera.getCamera().getPorta(), 
                                servidorCamera.getCamera().getUsuario(), servidorCamera.getCamera().getSenha()); 
                    } else { 
                        identificacao = servidorCamera.getCamera().getIdentificacao();
                    } 
                    if(servidorCamera.iniciarCamera(identificacao)) {
                        InstanciasControle.getIniciarCameras().iniciarCapturaIndividual(servidorCamera);
                        iniciarParar.setText("Parar");
                    }                     
                    break;
                case "Parar" : 
                    if(InstanciasControle.getMensagens().confirmacao(MensagensSoltas.comumPararCamera())) {
                        servidorCamera.setStatus(false);
                        iniciarParar.setText("Iniciar"); 
                        servidorCamera.setPause(false);
                        pausar.setText("Pausar");
                        limparPainel();
                    }
                    break;
            }          
        } else if (e.getSource() == pausar){
            if(pausar.getText().equals("Pausar")) {
                servidorCamera.setPause(true);
                pausar.setText("Resumir");
            } else {
                servidorCamera.setPause(false);
                pausar.setText("Pausar"); 
            }
        } else if (e.getSource() == aumentarTela){
            VisualizadorCamera dialog = new VisualizadorCamera(null, true, this, servidorCamera);
            dialog.setVisible(true);
        } else if (e.getSource() == gravar){
            if(gravar.getText().equals("Gravar")) { 
                if(ConfigDispositivos.getGravarVideo()) {
                    servidorCamera.getCamera().getConfigCamera().setGravar(EnumGravarConfigCamera.SIM);
                    gravar.setText("Gravando..."); 
                } else {
                    InstanciasControle.getMensagens().aviso(MensagensSoltas.comumDesativarGravacao()); 
                }
            } else {
                servidorCamera.getCamera().getConfigCamera().setGravar(EnumGravarConfigCamera.NAO);
                servidorCamera.pararGravacao();
                gravar.setText("Gravar"); 
            }
            alterarConfigCamera(servidorCamera.getCamera().getConfigCamera());
        } else if (e.getSource() == dispositivos){
            if(dispositivos.isSelected()) {
                servidorCamera.getCamera().getConfigCamera().setDispositivo(EnumDispositivoConfigCamera.SIM);
            } else {
                servidorCamera.getCamera().getConfigCamera().setDispositivo(EnumDispositivoConfigCamera.NAO);
            }
            alterarConfigCamera(servidorCamera.getCamera().getConfigCamera());
        } else if (e.getSource() == campanhia){
            if(campanhia.isSelected()) {
                servidorCamera.getCamera().getConfigCamera().setCampanhia(EnumCampanhiaConfigCamera.SIM);
            } else {
                servidorCamera.getCamera().getConfigCamera().setCampanhia(EnumCampanhiaConfigCamera.NAO);
            }
            alterarConfigCamera(servidorCamera.getCamera().getConfigCamera());
        } else if (e.getSource() == adaptarAmbiente){
            if(adaptarAmbiente.isSelected()) {
                servidorCamera.getCamera().getConfigCamera().setTipoProcessamento(EnumTipoProcessamentoConfigCamera.ADAPTAR_AMBIENTE);
            } 
            alterarConfigCamera(servidorCamera.getCamera().getConfigCamera());
        } else if (e.getSource() == mudancaAmbiente){
            if(mudancaAmbiente.isSelected()) {
                servidorCamera.getCamera().getConfigCamera().setTipoProcessamento(EnumTipoProcessamentoConfigCamera.AMBIENTE_STATICO);
                servidorCamera.verificarAmbienteStatico();
            } 
            alterarConfigCamera(servidorCamera.getCamera().getConfigCamera());
        } else if (e.getSource() == movimento){
            if(movimento.isSelected()) {
                servidorCamera.getCamera().getConfigCamera().setMovimento(EnumMovimentoConfigCamera.SIM);
            } else {
                servidorCamera.getCamera().getConfigCamera().setMovimento(EnumMovimentoConfigCamera.NAO);
            }
            alterarConfigCamera(servidorCamera.getCamera().getConfigCamera());
        } else if (e.getSource() == ambienteStatico){
            if(ambienteStatico.isSelected()) {
                servidorCamera.getCamera().getConfigCamera().setAmbienteStatico(EnumAmbienteStaticoConfigCamera.SIM);
            } else {
                servidorCamera.getCamera().getConfigCamera().setAmbienteStatico(EnumAmbienteStaticoConfigCamera.NAO);
            }
            alterarConfigCamera(servidorCamera.getCamera().getConfigCamera());
        } else if (e.getSource() == controle) {
            ControleMovimentacao dialog = new ControleMovimentacao(null, true, servidorCamera.getCamera());
            dialog.setVisible(true); 
        }
        //----------
        else if (e.getSource() == detectarCorpo){
            if(detectarCorpo.isSelected()) {
                servidorCamera.getCamera().getConfigCamera().setCorpo(EnumCorpoConfigCamera.SIM);
            } else {
                servidorCamera.getCamera().getConfigCamera().setCorpo(EnumCorpoConfigCamera.NAO);
            }
            alterarConfigCamera(servidorCamera.getCamera().getConfigCamera());
        } else if (e.getSource() == detectarFace){
            if(detectarFace.isSelected()) {
                servidorCamera.getCamera().getConfigCamera().setFace(EnumFaceConfigCamera.SIM);
            } else {
                servidorCamera.getCamera().getConfigCamera().setFace(EnumFaceConfigCamera.NAO);
            }
            alterarConfigCamera(servidorCamera.getCamera().getConfigCamera());
        } else if (e.getSource() == detectarObjeto){
            if(detectarObjeto.isSelected()) {
                servidorCamera.getCamera().getConfigCamera().setObjeto(EnumObjetoConfigCamera.SIM);
            } else {
                servidorCamera.getCamera().getConfigCamera().setObjeto(EnumObjetoConfigCamera.NAO);
            }
            alterarConfigCamera(servidorCamera.getCamera().getConfigCamera());
        } else if (e.getSource() == detectarOlhos){
            if(detectarOlhos.isSelected()) {
                servidorCamera.getCamera().getConfigCamera().setOlhos(EnumOlhosConfigCamera.SIM);
            } else {
                servidorCamera.getCamera().getConfigCamera().setOlhos(EnumOlhosConfigCamera.NAO);
            }
            alterarConfigCamera(servidorCamera.getCamera().getConfigCamera());
        } else if (e.getSource() == reconhecerFace){
            if(reconhecerFace.isSelected()) {
                servidorCamera.getCamera().getConfigCamera().setReconhecerFace(EnumReconhecerFaceConfigCamera.SIM);
            } else {
                servidorCamera.getCamera().getConfigCamera().setReconhecerFace(EnumReconhecerFaceConfigCamera.NAO);
            }
            alterarConfigCamera(servidorCamera.getCamera().getConfigCamera());
        }  
    }
    
    private void verificarMenuCameras() {
        if(servidorCamera.getStatus()) {
            iniciarParar.setText("Parar");
        } else {
            iniciarParar.setText("Iniciar");
            limparPainel();
        }
        if(servidorCamera.getPause()) {
            pausar.setText("Resumir");
        } else {
            pausar.setText("Pausar");
        }
        if(servidorCamera.getCamera().getConfigCamera().getTipoProcessamento() == EnumTipoProcessamentoConfigCamera.ADAPTAR_AMBIENTE) {
            adaptarAmbiente.setSelected(true);
        } else {
            mudancaAmbiente.setSelected(true);
        }   
    }
    
    private void verificarMenuAcoes() {   
        if(servidorCamera.getCamera().getConfigCamera().getMovimento() == EnumMovimentoConfigCamera.SIM) {
            movimento.setSelected(true);
        } else {
            movimento.setSelected(false);
        }
        if(servidorCamera.getCamera().getConfigCamera().getAmbienteStatico() == EnumAmbienteStaticoConfigCamera.SIM) {
            ambienteStatico.setSelected(true);
        } else {
            ambienteStatico.setSelected(false);
        } 
        if(servidorCamera.getCamera().getConfigCamera().getObjeto() == EnumObjetoConfigCamera.SIM) {
            detectarObjeto.setSelected(true);
        } else {
            detectarObjeto.setSelected(false);
        }
        if(servidorCamera.getCamera().getConfigCamera().getDispositivo() == EnumDispositivoConfigCamera.SIM) {
            dispositivos.setSelected(true); 
        } else {
            dispositivos.setSelected(false); 
        }
        if(servidorCamera.getCamera().getConfigCamera().getCampanhia() == EnumCampanhiaConfigCamera.SIM) {
            campanhia.setSelected(true); 
        } else {
            campanhia.setSelected(false); 
        }
        if(servidorCamera.getCamera().getConfigCamera().getGravar() == EnumGravarConfigCamera.SIM
                && ConfigDispositivos.getGravarVideo() && servidorCamera.getStatus()) {
            gravar.setText("Gravando...");
        } else {
            gravar.setText("Gravar");
        }  
    }
    
    private void verificaMenuProcessamento() {
        if(servidorCamera.getCamera().getConfigCamera().getCorpo() == EnumCorpoConfigCamera.SIM) {
            detectarCorpo.setSelected(true);
        } else {
            detectarCorpo.setSelected(false);
        }
        if(servidorCamera.getCamera().getConfigCamera().getFace() == EnumFaceConfigCamera.SIM) {
            detectarFace.setSelected(true);
        } else {
            detectarFace.setSelected(false);
        }
        if(servidorCamera.getCamera().getConfigCamera().getOlhos() == EnumOlhosConfigCamera.SIM) {
            detectarOlhos.setSelected(true);
        } else {
            detectarOlhos.setSelected(false);
        }
        if(servidorCamera.getCamera().getConfigCamera().getReconhecerFace() == EnumReconhecerFaceConfigCamera.SIM) {
            reconhecerFace.setSelected(true);
        } else {
            reconhecerFace.setSelected(false);
        }
    }
    
    private void limparPainel() {
        getImagePanel().draw(ImagemUtil.redimencionar(ImagemUtil.ler(ArquivosImagens.sistema_semImagem()), 
            ConfigDispositivos.getLargura(), ConfigDispositivos.getAltura())); 
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == camera){
            verificarMenuCameras();
        } else if (e.getSource() == acoes){
            verificarMenuAcoes();
        } else if (e.getSource() == pessoas){
            verificaMenuProcessamento();
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
    /*
     * BANCO DE DADOS
     */
    
    private void alterarConfigCamera(ConfigCameraBean configCamera) {
        ConfigCameraFacade configCameraFacade = FactoryFacade.getConfigCameraImpl();
        try {
            configCameraFacade.alterar(configCamera);
        } catch (FacadeException ex) {
        }
        AtualizaTelas.geralMapaDispositivos();
    }
    
}
