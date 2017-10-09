
package telas;

import controle.configuracoes.diretorios.caminhos.ArquivosImagens;
import controle.mensagens.Mensagens;
import controle.redes.dependencias.ConstantesRedes;
import java.awt.Component;
import javax.swing.*;
import recursos.InstanciasPortatil;
import telas.dependencias.EsperarCirculo;
import telas.dependencias.TelaClientesConectados;
import telas.dependencias.TelaLogin;
import util.SwingUtil;

/**
 *
 * @author Wesllen
 */
public class TelaPrincipal extends javax.swing.JFrame {
    
    private EsperarCirculo carregamento;

    public TelaPrincipal() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource(ArquivosImagens.logo())).getImage());
        InstanciasPortatil.setTelaPrincipal(TelaPrincipal.this);
        
        Mensagens mensagens = new Mensagens();
        InstanciasPortatil.setMensagens(mensagens);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tb_barra = new javax.swing.JToolBar();
        bt_mensagem = new javax.swing.JToggleButton();
        bt_cenario = new javax.swing.JToggleButton();
        bt_camera = new javax.swing.JToggleButton();
        bt_dispositivos = new javax.swing.JToggleButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        bt_ultimaFoto = new javax.swing.JButton();
        tb_pane = new javax.swing.JTabbedPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mi_conectar = new javax.swing.JMenuItem();
        mi_usuariosConectados = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mi_mensagens = new javax.swing.JMenuItem();
        mi_cenarios = new javax.swing.JMenuItem();
        mi_cameras = new javax.swing.JMenuItem();
        mi_dispositivos = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        mi_sobre = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Eletro Vision Portátil");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        tb_barra.setFloatable(false);
        tb_barra.setRollover(true);

        bt_mensagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/mensagens_36.png"))); // NOI18N
        bt_mensagem.setToolTipText("Mensagens");
        bt_mensagem.setFocusable(false);
        bt_mensagem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bt_mensagem.setName("Mensagens"); // NOI18N
        bt_mensagem.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bt_mensagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_mensagemActionPerformed(evt);
            }
        });
        tb_barra.add(bt_mensagem);

        bt_cenario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/cenario_36.png"))); // NOI18N
        bt_cenario.setToolTipText("Cenários");
        bt_cenario.setFocusable(false);
        bt_cenario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bt_cenario.setName("Cenário"); // NOI18N
        bt_cenario.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bt_cenario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cenarioActionPerformed(evt);
            }
        });
        tb_barra.add(bt_cenario);

        bt_camera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/camera_36.png"))); // NOI18N
        bt_camera.setToolTipText("Câmeras");
        bt_camera.setFocusable(false);
        bt_camera.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bt_camera.setName("Câmeras"); // NOI18N
        bt_camera.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bt_camera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cameraActionPerformed(evt);
            }
        });
        tb_barra.add(bt_camera);

        bt_dispositivos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/dispositivo_36.png"))); // NOI18N
        bt_dispositivos.setToolTipText("Dispositivos");
        bt_dispositivos.setFocusable(false);
        bt_dispositivos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bt_dispositivos.setName("Dispositivos"); // NOI18N
        bt_dispositivos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bt_dispositivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_dispositivosActionPerformed(evt);
            }
        });
        tb_barra.add(bt_dispositivos);
        tb_barra.add(jSeparator1);

        bt_ultimaFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/ultima_foto_36.png"))); // NOI18N
        bt_ultimaFoto.setFocusable(false);
        bt_ultimaFoto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bt_ultimaFoto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bt_ultimaFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_ultimaFotoActionPerformed(evt);
            }
        });
        tb_barra.add(bt_ultimaFoto);

        tb_pane.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tb_paneStateChanged(evt);
            }
        });

        jMenu1.setText("Servidor");

        mi_conectar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK));
        mi_conectar.setText("Conectar");
        mi_conectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_conectarActionPerformed(evt);
            }
        });
        jMenu1.add(mi_conectar);

        mi_usuariosConectados.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.ALT_MASK));
        mi_usuariosConectados.setText("Usuários conectados");
        mi_usuariosConectados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_usuariosConectadosActionPerformed(evt);
            }
        });
        jMenu1.add(mi_usuariosConectados);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Módulos");

        mi_mensagens.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK));
        mi_mensagens.setText("Mensagens");
        mi_mensagens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_mensagensActionPerformed(evt);
            }
        });
        jMenu2.add(mi_mensagens);

        mi_cenarios.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.ALT_MASK));
        mi_cenarios.setText("Cenários");
        mi_cenarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_cenariosActionPerformed(evt);
            }
        });
        jMenu2.add(mi_cenarios);

        mi_cameras.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        mi_cameras.setText("Câmeras");
        mi_cameras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_camerasActionPerformed(evt);
            }
        });
        jMenu2.add(mi_cameras);

        mi_dispositivos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.ALT_MASK));
        mi_dispositivos.setText("Dispositivos");
        mi_dispositivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_dispositivosActionPerformed(evt);
            }
        });
        jMenu2.add(mi_dispositivos);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Ajuda");

        mi_sobre.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK));
        mi_sobre.setText("Sobre");
        mi_sobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_sobreActionPerformed(evt);
            }
        });
        jMenu3.add(mi_sobre);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tb_barra, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
            .addComponent(tb_pane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(tb_barra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tb_pane, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-416)/2, (screenSize.height-538)/2, 416, 538);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_mensagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_mensagemActionPerformed
        abrirTelaMensagens();
    }//GEN-LAST:event_bt_mensagemActionPerformed

    private void bt_cenarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cenarioActionPerformed
        abrirTelaCenario();
    }//GEN-LAST:event_bt_cenarioActionPerformed

    private void bt_cameraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cameraActionPerformed
        abrirTelaCameras();
    }//GEN-LAST:event_bt_cameraActionPerformed

    private void bt_dispositivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_dispositivosActionPerformed
        abrirTelaDispositivos();
    }//GEN-LAST:event_bt_dispositivosActionPerformed

    private void mi_mensagensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_mensagensActionPerformed
        if(bt_mensagem.isSelected()) {
            bt_mensagem.setSelected(false);
        } else {
            bt_mensagem.setSelected(true);
        }
        abrirTelaMensagens();
    }//GEN-LAST:event_mi_mensagensActionPerformed

    private void mi_cenariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_cenariosActionPerformed
        if(bt_cenario.isSelected()) {
            bt_cenario.setSelected(false);
        } else {
            bt_cenario.setSelected(true);
        }
        abrirTelaCenario();   
    }//GEN-LAST:event_mi_cenariosActionPerformed

    private void mi_camerasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_camerasActionPerformed
        if(bt_camera.isSelected()) {
            bt_camera.setSelected(false);
        } else {
            bt_camera.setSelected(true);
        }
        abrirTelaCameras();
    }//GEN-LAST:event_mi_camerasActionPerformed

    private void mi_dispositivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_dispositivosActionPerformed
        if(bt_dispositivos.isSelected()) {
            bt_dispositivos.setSelected(false);
        } else {
            bt_dispositivos.setSelected(true);
        }
        abrirTelaDispositivos(); 
    }//GEN-LAST:event_mi_dispositivosActionPerformed

    private void mi_conectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_conectarActionPerformed
        conectar();
    }//GEN-LAST:event_mi_conectarActionPerformed

    private void mi_usuariosConectadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_usuariosConectadosActionPerformed
        usuariosConectados();
    }//GEN-LAST:event_mi_usuariosConectadosActionPerformed

    private void tb_paneStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tb_paneStateChanged
        if(InstanciasPortatil.getTituloTab() != null){
            tiraSelecaoToggleButtonPorName(InstanciasPortatil.getTituloTab());
            InstanciasPortatil.setTituloTab(null);
        }
    }//GEN-LAST:event_tb_paneStateChanged

    private void mi_sobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_sobreActionPerformed
        sobre();
    }//GEN-LAST:event_mi_sobreActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        fechar();
    }//GEN-LAST:event_formWindowClosing

    private void bt_ultimaFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_ultimaFotoActionPerformed
        tirarUltimaFoto();
    }//GEN-LAST:event_bt_ultimaFotoActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton bt_camera;
    private javax.swing.JToggleButton bt_cenario;
    private javax.swing.JToggleButton bt_dispositivos;
    private javax.swing.JToggleButton bt_mensagem;
    private javax.swing.JButton bt_ultimaFoto;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JMenuItem mi_cameras;
    private javax.swing.JMenuItem mi_cenarios;
    public static javax.swing.JMenuItem mi_conectar;
    private javax.swing.JMenuItem mi_dispositivos;
    private javax.swing.JMenuItem mi_mensagens;
    private javax.swing.JMenuItem mi_sobre;
    private javax.swing.JMenuItem mi_usuariosConectados;
    private javax.swing.JToolBar tb_barra;
    public javax.swing.JTabbedPane tb_pane;
    // End of variables declaration//GEN-END:variables

    private JPanel manipulaItemMenu(JToggleButton tb, JPanel painel){
        if(tb.isSelected()){
            verificaConexao();
            return SwingUtil.adicionarTabComBotaoFechar(tb_pane, tb.getName(), painel);
        } else {
            switch (tb.getName()) {
                case "Mensagens":
                    InstanciasPortatil.setTelaMensagens(null);
                    break;
                case "Dispositivos":
                    InstanciasPortatil.setTelaDispositivos(null);
                    break;
            }
            SwingUtil.fechaTabbedPanePeloTitulo(tb_pane, tb.getName());
        }   
        return null;
    }
    
    private void tiraSelecaoToggleButtonPorName(String name){
        Component[] components1 = tb_barra.getComponents();
        for(int i = 0; i < components1.length; i++){
            if(components1[i] instanceof JToggleButton){
                JToggleButton toggleButton = (JToggleButton) components1[i];
                if(toggleButton.getName().equals(name)){      
                    toggleButton.setSelected(false);
                }
            }
        }
    }
    
    private void abrirTelaMensagens() {  
        TelaMensagens painel = new TelaMensagens();
        InstanciasPortatil.setTelaMensagens(painel);
        manipulaItemMenu(bt_mensagem, painel);
    }
    
    private void abrirTelaCenario() {
        TelaCenario painel = new TelaCenario();
        if(bt_cenario.isSelected()) {
            painel.solicitarCenarios();
        }
        InstanciasPortatil.setTelaCenario(painel);
        manipulaItemMenu(bt_cenario, painel);
    }
    
    private void abrirTelaCameras() {
        TelaCameras painel = new TelaCameras();
        if(bt_camera.isSelected()) {
            painel.solicitarCameras();
        }
        InstanciasPortatil.setTelaCameras(painel);
        manipulaItemMenu(bt_camera, painel);
    }
    
    private void abrirTelaDispositivos() {
        TelaDispositivos painel = new TelaDispositivos();
        if(bt_dispositivos.isSelected()) {
            painel.solicitarDispositivos();
        }
        InstanciasPortatil.setTelaDispositivos(painel);
        manipulaItemMenu(bt_dispositivos, painel);
    }

    private void conectar() {
        if(InstanciasPortatil.getCliente() == null) {
            TelaLogin dialog = new TelaLogin(null, true);
            dialog.setVisible(true);
        } else {
            if(InstanciasPortatil.getMensagens().confirmacao("Deseja realmente desconectar?")) {
                InstanciasPortatil.getCliente().fecharConexao();
                InstanciasPortatil.setCliente(null);
                InstanciasPortatil.getMensagens().sucesso("Desconectado!");
                mi_conectar.setText("Conectar");
            }
        }
    }

    private void usuariosConectados() {
        verificaConexao();
        TelaClientesConectados dialog = new TelaClientesConectados(this, false);
        dialog.setVisible(true);
    }
    
    private void sobre() {
        Sobre sobre = new Sobre(this, true);
        sobre.setVisible(true);
    }
    
    private void verificaConexao() {
        if(InstanciasPortatil.getCliente() == null) {
            InstanciasPortatil.getMensagens().aviso("Você não está conectado!");
        }
    }

    private void fechar() {
        if(InstanciasPortatil.getMensagens().confirmacao("Deseja realmente fechar?")) {
            if(InstanciasPortatil.getCliente() != null) {
                InstanciasPortatil.getCliente().fecharConexao();
            }
            System.exit(0); 
        }
    }
    
    private void tirarUltimaFoto() {
        verificaConexao();
        if(InstanciasPortatil.getCliente() != null) {
            esperar();
            InstanciasPortatil.getCliente().enviarDados(ConstantesRedes.CS_TIRAR_ULTIMA_FOTO);
        }
    }
    
    private void esperar() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                carregamento = new EsperarCirculo(null, true);
                carregamento.setVisible(true);
            }
        });
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
        }
    }
    
    public void fecharCarregamento() {
        if(carregamento != null) {
            carregamento.dispose();
        }
    }

}
