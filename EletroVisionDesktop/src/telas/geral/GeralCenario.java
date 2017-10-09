
package telas.geral;

import recursos.configuracoes.diretorios.ManipularArquivoProperties;
import recursos.configuracoes.diretorios.caminhos.ArquivosConfiguracao;
import recursos.configuracoes.diretorios.caminhos.ArquivosHTML;
import recursos.configuracoes.diretorios.caminhos.ArquivosImagens;
import recursos.configuracoes.sistema.ConfigDispositivos;
import recursos.configuracoes.sistema.ConfigMapa;
import telas.geral.dependencias.CadEditarCenario;
import telas.geral.dependencias.PainelCenario;
import entidades.acionamento.bean.AcionamentoBean;
import entidades.acionamento.bean.EnumDeletadoAcionamento;
import entidades.acionamento.facade.AcionamentoFacade;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Properties;
import javax.swing.JPanel;
import recursos.constantes.ConstantesSistema;
import recursos.instancias.InstanciasControle;
import recursos.instancias.InstanciasTelas;
import recursos.internacionalizacao.MensagensSoltas;
import telas.comuns.eventos.ArrastaComponentes;
import telas.comuns.imagens.ImagemPanel;
import telas.geral.dependencias.VincularAgendarTarefas;
import telas.principal.Manual;
import util.ArquivosUtil;
import util.FacadeException;
import util.FactoryFacade;
import util.ImagemUtil;
import util.SwingUtil;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class GeralCenario extends javax.swing.JPanel {

    public AcionamentoBean acionamentoSelecionado;
    private Integer larguraCenario, alturaCenario;
    private Integer localX, localY;
    private Properties props;
    
    public GeralCenario() {
        initComponents();
        InstanciasTelas.setGeralCenario(GeralCenario.this);
        
        lerArquivoMapas();
        configuraLocalizacao();
        configuraTamanho();
        carregaImagemCenario();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mn_popupCenario = new javax.swing.JPopupMenu();
        mi_ligarDesligar = new javax.swing.JMenuItem();
        mi_editar = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        mi_ativarDesativar = new javax.swing.JMenuItem();
        mi_excluir = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        m_tipoAcionamento = new javax.swing.JMenu();
        mi_nenhumAcionamento = new javax.swing.JRadioButtonMenuItem();
        mi_controleAutomatico = new javax.swing.JRadioButtonMenuItem();
        mi_alarme = new javax.swing.JRadioButtonMenuItem();
        mi_detectarPessoas = new javax.swing.JRadioButtonMenuItem();
        mi_reconhecerFaces = new javax.swing.JRadioButtonMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        mi_agendarTarefa = new javax.swing.JMenuItem();
        grupoTipo = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        bt_zoomMenos = new javax.swing.JButton();
        bt_zoomMais = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        bt_ajuda = new javax.swing.JButton();
        scroll = new javax.swing.JScrollPane();
        pn_imagem = new javax.swing.JPanel();
        pn_cenario = new org.jdesktop.swingx.JXPanel();

        mn_popupCenario.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        mi_ligarDesligar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        mi_ligarDesligar.setText("Ligar");
        mi_ligarDesligar.setToolTipText("");
        mi_ligarDesligar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_ligarDesligarActionPerformed(evt);
            }
        });
        mn_popupCenario.add(mi_ligarDesligar);

        mi_editar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        mi_editar.setText("Editar");
        mi_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_editarActionPerformed(evt);
            }
        });
        mn_popupCenario.add(mi_editar);
        mn_popupCenario.add(jSeparator2);

        mi_ativarDesativar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        mi_ativarDesativar.setText("Desativar");
        mi_ativarDesativar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_ativarDesativarActionPerformed(evt);
            }
        });
        mn_popupCenario.add(mi_ativarDesativar);

        mi_excluir.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        mi_excluir.setText("Excluir");
        mi_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_excluirActionPerformed(evt);
            }
        });
        mn_popupCenario.add(mi_excluir);
        mn_popupCenario.add(jSeparator3);

        m_tipoAcionamento.setText("Tipo de Acionamento");
        m_tipoAcionamento.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        grupoTipo.add(mi_nenhumAcionamento);
        mi_nenhumAcionamento.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        mi_nenhumAcionamento.setText("Nenhum Acionamento");
        mi_nenhumAcionamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_nenhumAcionamentoActionPerformed(evt);
            }
        });
        m_tipoAcionamento.add(mi_nenhumAcionamento);

        grupoTipo.add(mi_controleAutomatico);
        mi_controleAutomatico.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        mi_controleAutomatico.setText("Controle automático");
        mi_controleAutomatico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_controleAutomaticoActionPerformed(evt);
            }
        });
        m_tipoAcionamento.add(mi_controleAutomatico);

        grupoTipo.add(mi_alarme);
        mi_alarme.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        mi_alarme.setText("Alarme");
        mi_alarme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_alarmeActionPerformed(evt);
            }
        });
        m_tipoAcionamento.add(mi_alarme);

        grupoTipo.add(mi_detectarPessoas);
        mi_detectarPessoas.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        mi_detectarPessoas.setSelected(true);
        mi_detectarPessoas.setText("Detectar pessoas");
        mi_detectarPessoas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_detectarPessoasActionPerformed(evt);
            }
        });
        m_tipoAcionamento.add(mi_detectarPessoas);

        grupoTipo.add(mi_reconhecerFaces);
        mi_reconhecerFaces.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        mi_reconhecerFaces.setText("Reconhecer faces");
        mi_reconhecerFaces.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_reconhecerFacesActionPerformed(evt);
            }
        });
        m_tipoAcionamento.add(mi_reconhecerFaces);

        mn_popupCenario.add(m_tipoAcionamento);
        mn_popupCenario.add(jSeparator4);

        mi_agendarTarefa.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        mi_agendarTarefa.setText("Agendar Tarefa");
        mi_agendarTarefa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_agendarTarefaActionPerformed(evt);
            }
        });
        mn_popupCenario.add(mi_agendarTarefa);

        jPanel1.setBackground(new java.awt.Color(76, 158, 92));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/acoes/adicionar_22x22.png"))); // NOI18N
        jButton1.setToolTipText("Adionar Cenário");
        jButton1.setOpaque(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/visualizacao/ladoLado_22x22.png"))); // NOI18N
        jButton2.setToolTipText("Orgazizar Lado a Lado");
        jButton2.setOpaque(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        bt_zoomMenos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/acoes/zomMenos_22x22.png"))); // NOI18N
        bt_zoomMenos.setToolTipText("DiminuirZoom");
        bt_zoomMenos.setOpaque(false);
        bt_zoomMenos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_zoomMenosActionPerformed(evt);
            }
        });

        bt_zoomMais.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/acoes/zomMais_22x22.png"))); // NOI18N
        bt_zoomMais.setToolTipText("Aumentar Zoom");
        bt_zoomMais.setOpaque(false);
        bt_zoomMais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_zoomMaisActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);

        bt_ajuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/acoes/ajuda_22x22.png"))); // NOI18N
        bt_ajuda.setToolTipText("Ajuda");
        bt_ajuda.setOpaque(false);
        bt_ajuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_ajudaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_zoomMais, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_zoomMenos, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bt_ajuda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bt_zoomMais, bt_zoomMenos, jButton1, jButton2});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator5)
            .addComponent(bt_zoomMenos)
            .addComponent(bt_zoomMais)
            .addComponent(jButton2)
            .addComponent(jButton1)
            .addComponent(bt_ajuda)
        );

        pn_cenario.setAlpha(0.8F);

        javax.swing.GroupLayout pn_cenarioLayout = new javax.swing.GroupLayout(pn_cenario);
        pn_cenario.setLayout(pn_cenarioLayout);
        pn_cenarioLayout.setHorizontalGroup(
            pn_cenarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 559, Short.MAX_VALUE)
        );
        pn_cenarioLayout.setVerticalGroup(
            pn_cenarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 342, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pn_imagemLayout = new javax.swing.GroupLayout(pn_imagem);
        pn_imagem.setLayout(pn_imagemLayout);
        pn_imagemLayout.setHorizontalGroup(
            pn_imagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pn_cenario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pn_imagemLayout.setVerticalGroup(
            pn_imagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pn_cenario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        scroll.setViewportView(pn_imagem);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(scroll)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scroll))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        abrirCadEditarCenario(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        organizar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void bt_zoomMenosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_zoomMenosActionPerformed
        alterarTamanho(larguraCenario-10, alturaCenario-10);
        verificarBotoesZoom();
    }//GEN-LAST:event_bt_zoomMenosActionPerformed

    private void bt_zoomMaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_zoomMaisActionPerformed
        alterarTamanho(larguraCenario+10, alturaCenario+10);
        verificarBotoesZoom();
    }//GEN-LAST:event_bt_zoomMaisActionPerformed

    private void mi_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_editarActionPerformed
        abrirCadEditarCenario(1);
    }//GEN-LAST:event_mi_editarActionPerformed

    private void mi_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_excluirActionPerformed
        if(InstanciasControle.getMensagens().confirmacao(MensagensSoltas.gerCenarioExcluir())){
            removerCenario();
        }
    }//GEN-LAST:event_mi_excluirActionPerformed

    private void mi_ativarDesativarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_ativarDesativarActionPerformed
        ativarDesativar();
    }//GEN-LAST:event_mi_ativarDesativarActionPerformed

    private void mi_ligarDesligarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_ligarDesligarActionPerformed
        ligarDesligar();
    }//GEN-LAST:event_mi_ligarDesligarActionPerformed

private void mi_agendarTarefaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_agendarTarefaActionPerformed
        agendarTarefa();
}//GEN-LAST:event_mi_agendarTarefaActionPerformed

    private void mi_controleAutomaticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_controleAutomaticoActionPerformed
        tipo();
    }//GEN-LAST:event_mi_controleAutomaticoActionPerformed

    private void mi_detectarPessoasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_detectarPessoasActionPerformed
        tipo();
    }//GEN-LAST:event_mi_detectarPessoasActionPerformed

    private void mi_reconhecerFacesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_reconhecerFacesActionPerformed
        tipo();
    }//GEN-LAST:event_mi_reconhecerFacesActionPerformed

    private void mi_nenhumAcionamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_nenhumAcionamentoActionPerformed
        tipo();
    }//GEN-LAST:event_mi_nenhumAcionamentoActionPerformed

    private void mi_alarmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_alarmeActionPerformed
        tipo();
    }//GEN-LAST:event_mi_alarmeActionPerformed

    private void bt_ajudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_ajudaActionPerformed
        ajuda();
    }//GEN-LAST:event_bt_ajudaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_ajuda;
    private javax.swing.JButton bt_zoomMais;
    private javax.swing.JButton bt_zoomMenos;
    private javax.swing.ButtonGroup grupoTipo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JMenu m_tipoAcionamento;
    private javax.swing.JMenuItem mi_agendarTarefa;
    public javax.swing.JRadioButtonMenuItem mi_alarme;
    public javax.swing.JMenuItem mi_ativarDesativar;
    public javax.swing.JRadioButtonMenuItem mi_controleAutomatico;
    public javax.swing.JRadioButtonMenuItem mi_detectarPessoas;
    public javax.swing.JMenuItem mi_editar;
    private javax.swing.JMenuItem mi_excluir;
    public javax.swing.JMenuItem mi_ligarDesligar;
    public javax.swing.JRadioButtonMenuItem mi_nenhumAcionamento;
    public javax.swing.JRadioButtonMenuItem mi_reconhecerFaces;
    public javax.swing.JPopupMenu mn_popupCenario;
    private org.jdesktop.swingx.JXPanel pn_cenario;
    private javax.swing.JPanel pn_imagem;
    private javax.swing.JScrollPane scroll;
    // End of variables declaration//GEN-END:variables

    private void lerArquivoMapas() {
        props = ManipularArquivoProperties.lerConfiguracao(ArquivosConfiguracao.pixels());
        if (props != null) {
            ConfigMapa.setStatus(true);
            String mapa = props.getProperty("mapaCenarios");
            ConfigMapa.setMapaCenarios(mapa);
        } else { 
            props = new Properties();
            ConfigDispositivos.setStatus(false);
        }
    }
    
    private void carregaImagemCenario() {
        BufferedImage bufferedImage;
        if (ConfigMapa.getMapaCenarios() != null) {
            bufferedImage = ImagemUtil.ler(ArquivosImagens.diretorio_mapas() + File.separator + ConfigMapa.getMapaCenarios());
        } else {
            bufferedImage = ImagemUtil.ler(ArquivosImagens.sistema_semImagem());
        }
        ImagemPanel imagemPanel = new ImagemPanel();
        imagemPanel.setSize(bufferedImage.getWidth(), bufferedImage.getHeight());

        Dimension dimension = new Dimension(bufferedImage.getWidth(), bufferedImage.getHeight());
        pn_cenario.setPreferredSize(dimension);
        pn_imagem.setPreferredSize(dimension);

        imagemPanel.draw(bufferedImage);
        pn_imagem.add(imagemPanel);
        pn_imagem.repaint();
        pn_cenario.repaint();
        scroll.repaint();
    }
    
    /*
     *  ===============TELA==============================================
     */
    
    private void verificarBotoesZoom(){
        if(larguraCenario <= 100){
            bt_zoomMais.setEnabled(true);
        } else {
            bt_zoomMais.setEnabled(false);
        }
        if(larguraCenario >= 50){
            bt_zoomMenos.setEnabled(true);
        } else {
            bt_zoomMenos.setEnabled(false);
        }
    }
    
    private void configuraLocalizacao(){
        localX = 10;
        localY = 10;
    }
    
    private void configuraTamanho(){
        larguraCenario = 50;
        alturaCenario = 50;
    }
    
    private void organizar(){
        Integer x = localX, y = localY;
        Double larguraTotal = pn_cenario.getSize().getWidth();
        Component[] components = pn_cenario.getComponents();
        for(int i = 0; i < components.length; i++){
            JPanel cenario = (JPanel) components[i];
            if((x+larguraCenario) >= larguraTotal){
                x = localX;
                y += alturaCenario + localY;
            }
            cenario.setLocation(x, y);
            x += larguraCenario + localX;
        }
        pn_cenario.repaint();
    }
    
    private void alterarTamanho(Integer largura, Integer altura){
        larguraCenario = largura;
        alturaCenario = altura;
        Component[] components = pn_cenario.getComponents();
        for(int i = 0; i < components.length; i++){
            JPanel cenario = (JPanel) components[i];
            cenario.setSize(larguraCenario, alturaCenario);
        }
    }
    
    public void ativarDesativar(){
        Component[] components = pn_cenario.getComponents();
        for(int i = 0; i < components.length; i++){
            PainelCenario cenario = (PainelCenario) components[i];
            if (cenario.getName().equals(acionamentoSelecionado.getNome())) {
                cenario.ativarDesativar();
            }
        }
    }
    
    private void ligarDesligar(){
        Component[] components = pn_cenario.getComponents();
        for(int i = 0; i < components.length; i++){
            PainelCenario cenario = (PainelCenario) components[i];
            if (cenario.getName().equals(acionamentoSelecionado.getNome())) {
                cenario.ligarDesligar();
            }
        }
    }
    
    private void tipo(){
        Component[] components = pn_cenario.getComponents();
        for(int i = 0; i < components.length; i++){
            PainelCenario cenario = (PainelCenario) components[i];
            if (cenario.getName().equals(acionamentoSelecionado.getNome())) {
                cenario.tipo();
            }
        }
    }
    
    private void removerCenario() {
        Component[] components = pn_cenario.getComponents();
        for(int i = 0; i < components.length; i++){
            JPanel cenario = (JPanel) components[i];
            if(cenario.getName().equals(acionamentoSelecionado.getNome())){
                deletarAcionamento(acionamentoSelecionado);
                pn_cenario.remove(i);
                break;
            }
        }
        pn_cenario.repaint();
    }
    
 /*
 *  ===============BANCO DE DADOS=========================================
 */
    
    private ArrayList<AcionamentoBean> listarAcionamentos() {
        AcionamentoFacade acionamentoFacade = FactoryFacade.getAcionamentoImpl();
        try {
            return acionamentoFacade.listarAcionamentoNaoDeletado();
        } catch (FacadeException ex) {
        }
        return null;
    }
    
    private void deletarAcionamento(AcionamentoBean acionamento) {
        AcionamentoFacade acionamentoFacade = FactoryFacade.getAcionamentoImpl();
        try {
            acionamento.setDeletado(EnumDeletadoAcionamento.SIM);
            acionamentoFacade.alterar(acionamento);
        } catch (FacadeException ex) {
        } 
    }
    
 /*
 *  ===============REGRA DE NEGOCIO=========================================
 */
    
    public void carregarCenarios() {
        pn_cenario.removeAll();
        for(AcionamentoBean acionamento : listarAcionamentos()) {
            PainelCenario cenario = new PainelCenario(this, acionamento);
            cenario.setName(acionamento.getNome());
            cenario.setSize(larguraCenario, alturaCenario);
            if(props != null) {
                cenario.setLocation(verificaLocalizacaoCenario(acionamento));
            }
            ArrastaComponentes arrastaComponentes = new ArrastaComponentes(cenario);
            cenario.addMouseListener(arrastaComponentes);
            cenario.addMouseMotionListener(arrastaComponentes);
            pn_cenario.add(cenario);
        }
    }
    
    public void adionaCenario(AcionamentoBean acionamento){
        acionamentoSelecionado = acionamento;
        PainelCenario cenario = new PainelCenario(this, acionamento);
        cenario.setName(acionamento.getNome());
        cenario.setSize(larguraCenario, alturaCenario);
        cenario.setLocation(0, 0); 
        ArrastaComponentes arrastaComponentes = new ArrastaComponentes();
        cenario.addMouseListener(arrastaComponentes);
        cenario.addMouseMotionListener(arrastaComponentes);
        pn_cenario.add(cenario);
    }
    
    private Point verificaLocalizacaoCenario(AcionamentoBean acionamento) {
        if(props != null) {
            String codigo = acionamento.getCodigo().toString();
            String coordenadas = props.getProperty("Cenario_" + codigo);
            return ArquivosUtil.retornaLocalizacaoPixels(coordenadas);
        }
        return null;
    }

    public Properties getProps() {
        return props;
    }
    
    private void abrirCadEditarCenario(Integer i) {
        CadEditarCenario editarCenario = new CadEditarCenario(null, true, this, i);
        editarCenario.setVisible(true);
    }
    
    private void agendarTarefa() {
        VincularAgendarTarefas dialog = new VincularAgendarTarefas(null, true, ConstantesSistema.VINCULO_CENARIO, acionamentoSelecionado);
        dialog.setVisible(true); 
    }
    
    public void atualizarTela() {
        carregarCenarios();
        pn_cenario.repaint();
    }
    
    private void ajuda() {
        Manual manual = new Manual(ArquivosHTML.geral()+ArquivosHTML.cenarios());
        SwingUtil.adicionarTabComBotaoFechar(InstanciasTelas.getPrincipal().tb_principal, "Ajuda", manual); 
    }
    
}
