package telas.principal;

import EletroVisionPortatil.TelaPrincipal;
import EletroVisionPortatil.dependencias.InstanciasPortatil;
import EletroVisionPortatil.dependencias.TelaClientesConectados;
import recursos.configuracoes.diretorios.caminhos.ArquivosImagens;
import recursos.configuracoes.sistema.ConfigDispositivos;
import recursos.configuracoes.sistema.ConfigGerais;
import recursos.configuracoes.sistema.ConfigMensagens;
import controle.controleAcesso.VerificaAutorizacao;
import controle.dispositivos.GerenciarAcionamento;
import controle.dispositivos.ManageDevice;
import recursos.configuracoes.bloqueio.ArquivoBloqueio;
import recursos.configuracoes.sistema.ConfigCores;
import recursos.internacionalizacao.MensagensSoltas;
import controle.redes.Cliente;
import controle.redes.Servidor;
import java.awt.Component;
import java.util.Calendar;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JToggleButton;
import recursos.instancias.InstanciasControle;
import telas.cadastros.*;
import telas.comuns.telas.EsperarCirculo;
import telas.comuns.templates.Cadastro;
import telas.comuns.templates.Relatorio;
import telas.comuns.templates.Configuracao;
import telas.ferramentas.*;
import telas.geral.*;
import entidades.acesso.bean.AcessoBean;
import entidades.acesso.facade.AcessoFacade;
import entidades.dispositivo.bean.EnumStatusDispositivo;
import entidades.mensagem.bean.EnumExibirMensagem;
import entidades.mensagem.bean.EnumLeituraMensagem;
import entidades.mensagem.bean.MensagemBean;
import entidades.mensagem.facade.MensagemFacade;
import entidades.moduloAcionamento.bean.ModuloAcionamentoBean;
import entidades.moduloAcionamento.facade.ModuloAcionamentoFacade;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import recursos.backup.Backup;
import recursos.constantes.ConstantesSistema;
import recursos.instancias.InstanciasTelas;
import telas.comuns.telas.CarregarBarraProgresso;
import telas.comuns.telas.ModuloAcionamentoConectar;
import telas.comuns.templates.Pesquisa;
import telas.geral.dependencias.VerMensagensLocais;
import telas.geral.dependencias.VincularAgendarTarefas;
import telas.pesquisas.*;
import telas.relatorios.*;
import util.*;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class Principal extends javax.swing.JFrame {

    private EsperarCirculo esperar;

    public Principal() {
        initComponents();
        setTitle(ConstantesSistema.NOME_SISTEMA + " - " + ConstantesSistema.VERSAO_SISTEMA);
        if (ConfigGerais.getTelaMaximizada()) {
            setExtendedState(MAXIMIZED_BOTH);
        } else {
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            setSize((int) (screenSize.getWidth() * 0.75f),
                    (int) (screenSize.getHeight() * 0.75f));
            setLocationRelativeTo(null);
        }

        setIconImage(new ImageIcon(getClass().getResource(ArquivosImagens.logo())).getImage());
        InstanciasTelas.setPrincipal(Principal.this);
        InstanciasControle.getGerenciarAudio().exeIniciar();

        dataHora.start();
        ajeitarMenu();
        exibirUsuarioLogado();

        ativarAcionamento();
        verificarExistenciaArquivosConfiguracoes();
        if (ConfigGerais.getStatus() && ConfigGerais.getServidorIniciarSistema()) {
            iniciaServidor();
        }

        verificarAgendamentoTarefas();
        verificarMensagens();
        verificarCameras();
        verificarDispositivos();
        verificarMovimentos();
        verificarPessoas();
        vericarRede();
        verificarAudio();

        lb_movimento.setBackground(ConfigCores.transparente());
        lb_pessoa.setBackground(ConfigCores.transparente());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dataHora = new org.netbeans.examples.lib.timerbean.Timer();
        mn_movimento = new javax.swing.JPopupMenu();
        mi_detectarMovimento = new javax.swing.JCheckBoxMenuItem();
        mi_alteracaoAmbiente = new javax.swing.JCheckBoxMenuItem();
        mi_detectarObjetos = new javax.swing.JCheckBoxMenuItem();
        mn_pessoas = new javax.swing.JPopupMenu();
        mi_detectarFaces = new javax.swing.JCheckBoxMenuItem();
        mi_detectarOlhos = new javax.swing.JCheckBoxMenuItem();
        mi_detectarCorpo = new javax.swing.JCheckBoxMenuItem();
        mi_reconhecerFace = new javax.swing.JCheckBoxMenuItem();
        mn_cameras = new javax.swing.JPopupMenu();
        mi_iniciarPararTodasCameras = new javax.swing.JMenuItem();
        mi_iniciarPararCamerasIndividual = new javax.swing.JMenuItem();
        mi_pausarCamera = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        mi_dispositivo = new javax.swing.JCheckBoxMenuItem();
        mi_campanhia = new javax.swing.JCheckBoxMenuItem();
        mi_gravar = new javax.swing.JCheckBoxMenuItem();
        mn_agendarTarefas = new javax.swing.JPopupMenu();
        mi_pararAgendarTarefas = new javax.swing.JMenuItem();
        mi_vincularAgendamento = new javax.swing.JMenuItem();
        mn_dispositivos = new javax.swing.JPopupMenu();
        mi_desativarAcionamentoDispositivos = new javax.swing.JMenuItem();
        mn_mensagens = new javax.swing.JPopupMenu();
        mi_desativarEnvioMensagens = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        mi_rede = new javax.swing.JRadioButtonMenuItem();
        mi_celular = new javax.swing.JRadioButtonMenuItem();
        mi_email = new javax.swing.JCheckBoxMenuItem();
        mn_rede = new javax.swing.JPopupMenu();
        mi_conectarDesconectar = new javax.swing.JMenuItem();
        mi_usuarios = new javax.swing.JMenuItem();
        mi_aplicacaoCliente = new javax.swing.JMenuItem();
        mn_audio = new javax.swing.JPopupMenu();
        mi_ativarAudioCameras = new javax.swing.JCheckBoxMenuItem();
        mi_ativarAudioSistema = new javax.swing.JCheckBoxMenuItem();
        grupoMensagens = new javax.swing.ButtonGroup();
        jPanel4 = new javax.swing.JPanel();
        lb_movimento = new javax.swing.JLabel();
        lb_agendarTarefas = new javax.swing.JLabel();
        lb_mensagens = new javax.swing.JLabel();
        lb_dispositivosEletricos = new javax.swing.JLabel();
        lb_cameras = new javax.swing.JLabel();
        lb_pessoa = new javax.swing.JLabel();
        lb_rede = new javax.swing.JLabel();
        lb_usuario = new javax.swing.JLabel();
        lb_audio = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        pn_menu = new javax.swing.JPanel();
        btt_geral = new javax.swing.JToggleButton();
        pn_geral = new javax.swing.JPanel();
        btt_visualizarCameras = new javax.swing.JToggleButton();
        btt_mapaDispositivos = new javax.swing.JToggleButton();
        btt_montarCenario = new javax.swing.JToggleButton();
        btt_agendarTarefas = new javax.swing.JToggleButton();
        btt_mensagens = new javax.swing.JToggleButton();
        btt_logAcoes = new javax.swing.JToggleButton();
        jSeparator5 = new javax.swing.JSeparator();
        btt_localizacaoGPS = new javax.swing.JToggleButton();
        btt_cadastros = new javax.swing.JToggleButton();
        pn_cadastros = new javax.swing.JPanel();
        btt_cadPessoas = new javax.swing.JToggleButton();
        btt_cadUsuario = new javax.swing.JToggleButton();
        btt_cadPredio = new javax.swing.JToggleButton();
        jSeparator1 = new javax.swing.JSeparator();
        btt_cadCamera = new javax.swing.JToggleButton();
        btt_cadModuloAcionamento = new javax.swing.JToggleButton();
        btt_cadDispositivoEletrico = new javax.swing.JToggleButton();
        btt_cadMarca = new javax.swing.JToggleButton();
        btt_cadArea = new javax.swing.JToggleButton();
        btt_relatorios = new javax.swing.JToggleButton();
        pn_relatorios = new javax.swing.JPanel();
        btt_relatPessoas = new javax.swing.JToggleButton();
        btt_relatPredio = new javax.swing.JToggleButton();
        btt_relatDispositivo = new javax.swing.JToggleButton();
        jSeparator2 = new javax.swing.JSeparator();
        btt_relatMensagens = new javax.swing.JToggleButton();
        btt_relatMovimentos = new javax.swing.JToggleButton();
        btt_relatAcionamento = new javax.swing.JToggleButton();
        jSeparator4 = new javax.swing.JSeparator();
        btt_relatAgendarTarefas = new javax.swing.JToggleButton();
        btt_relatLogAcoes = new javax.swing.JToggleButton();
        btt_configuracoes = new javax.swing.JToggleButton();
        pn_configuracoes = new javax.swing.JPanel();
        btt_ferramentasEditarImagens = new javax.swing.JToggleButton();
        btt_ferramentasOpcoes = new javax.swing.JToggleButton();
        btt_ferramentasDesenharMapas = new javax.swing.JToggleButton();
        btt_ferramentasVideos = new javax.swing.JToggleButton();
        btt_ajuda = new javax.swing.JToggleButton();
        pn_ajuda = new javax.swing.JPanel();
        btt_manual = new javax.swing.JToggleButton();
        btt_sobre = new javax.swing.JToggleButton();
        btt_pesquisa = new javax.swing.JToggleButton();
        pn_pesquisa = new javax.swing.JPanel();
        btt_pesqPessoas = new javax.swing.JToggleButton();
        btt_pesqUsuario = new javax.swing.JToggleButton();
        btt_pesqPredio = new javax.swing.JToggleButton();
        jSeparator3 = new javax.swing.JSeparator();
        btt_pesqCamera = new javax.swing.JToggleButton();
        btt_pesqModuloAcionamento = new javax.swing.JToggleButton();
        btt_pesqDispositivoEletrico = new javax.swing.JToggleButton();
        btt_pesqMarca = new javax.swing.JToggleButton();
        btt_pesqArea = new javax.swing.JToggleButton();
        tb_principal = new javax.swing.JTabbedPane();
        jXStatusBar1 = new org.jdesktop.swingx.JXStatusBar();
        lb_dataHora = new javax.swing.JLabel();
        lb_progresso = new javax.swing.JLabel();
        lb_usuarioLogado = new javax.swing.JLabel();

        dataHora.addTimerListener(new org.netbeans.examples.lib.timerbean.TimerListener() {
            public void onTime(java.awt.event.ActionEvent evt) {
                dataHoraOnTime(evt);
            }
        });

        mi_detectarMovimento.setText("Detectar Movimento");
        mi_detectarMovimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_detectarMovimentoActionPerformed(evt);
            }
        });
        mn_movimento.add(mi_detectarMovimento);

        mi_alteracaoAmbiente.setText("Detectar alteração no ambiente");
        mi_alteracaoAmbiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_alteracaoAmbienteActionPerformed(evt);
            }
        });
        mn_movimento.add(mi_alteracaoAmbiente);

        mi_detectarObjetos.setText("Detectar Objetos");
        mi_detectarObjetos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_detectarObjetosActionPerformed(evt);
            }
        });
        mn_movimento.add(mi_detectarObjetos);

        mi_detectarFaces.setText("Detectar Faces");
        mi_detectarFaces.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_detectarFacesActionPerformed(evt);
            }
        });
        mn_pessoas.add(mi_detectarFaces);

        mi_detectarOlhos.setText("Detectar Olhos");
        mi_detectarOlhos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_detectarOlhosActionPerformed(evt);
            }
        });
        mn_pessoas.add(mi_detectarOlhos);

        mi_detectarCorpo.setText("Detectar Corpo");
        mi_detectarCorpo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_detectarCorpoActionPerformed(evt);
            }
        });
        mn_pessoas.add(mi_detectarCorpo);

        mi_reconhecerFace.setText("Reconhecer Faces");
        mi_reconhecerFace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_reconhecerFaceActionPerformed(evt);
            }
        });
        mn_pessoas.add(mi_reconhecerFace);

        mi_iniciarPararTodasCameras.setText("Parar todas as câmeras");
        mi_iniciarPararTodasCameras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_iniciarPararTodasCamerasActionPerformed(evt);
            }
        });
        mn_cameras.add(mi_iniciarPararTodasCameras);

        mi_iniciarPararCamerasIndividual.setText("Iniciar câmeras individuais");
        mi_iniciarPararCamerasIndividual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_iniciarPararCamerasIndividualActionPerformed(evt);
            }
        });
        mn_cameras.add(mi_iniciarPararCamerasIndividual);

        mi_pausarCamera.setText("Pausar Cameras");
        mi_pausarCamera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_pausarCameraActionPerformed(evt);
            }
        });
        mn_cameras.add(mi_pausarCamera);
        mn_cameras.add(jSeparator9);

        mi_dispositivo.setText("Ativar dispositivos pelas câmeras");
        mi_dispositivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_dispositivoActionPerformed(evt);
            }
        });
        mn_cameras.add(mi_dispositivo);

        mi_campanhia.setText("Habilitar campanhia");
        mi_campanhia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_campanhiaActionPerformed(evt);
            }
        });
        mn_cameras.add(mi_campanhia);

        mi_gravar.setText("Gravar");
        mi_gravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_gravarActionPerformed(evt);
            }
        });
        mn_cameras.add(mi_gravar);

        mi_pararAgendarTarefas.setText("Iniciar Agendamento de Tarefas");
        mi_pararAgendarTarefas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_pararAgendarTarefasActionPerformed(evt);
            }
        });
        mn_agendarTarefas.add(mi_pararAgendarTarefas);

        mi_vincularAgendamento.setText("Vincular agendamentos");
        mi_vincularAgendamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_vincularAgendamentoActionPerformed(evt);
            }
        });
        mn_agendarTarefas.add(mi_vincularAgendamento);

        mn_dispositivos.setToolTipText("");

        mi_desativarAcionamentoDispositivos.setText("Conexão dos Módulos de Acionamento");
        mi_desativarAcionamentoDispositivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_desativarAcionamentoDispositivosActionPerformed(evt);
            }
        });
        mn_dispositivos.add(mi_desativarAcionamentoDispositivos);

        mi_desativarEnvioMensagens.setText("Desativar Envio de Mensagens");
        mi_desativarEnvioMensagens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_desativarEnvioMensagensActionPerformed(evt);
            }
        });
        mn_mensagens.add(mi_desativarEnvioMensagens);
        mn_mensagens.add(jSeparator7);

        grupoMensagens.add(mi_rede);
        mi_rede.setSelected(true);
        mi_rede.setText("Rede");
        mi_rede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_redeActionPerformed(evt);
            }
        });
        mn_mensagens.add(mi_rede);

        grupoMensagens.add(mi_celular);
        mi_celular.setText("Celular");
        mi_celular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_celularActionPerformed(evt);
            }
        });
        mn_mensagens.add(mi_celular);

        mi_email.setText("Email");
        mi_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_emailActionPerformed(evt);
            }
        });
        mn_mensagens.add(mi_email);

        mi_conectarDesconectar.setText("Conectar");
        mi_conectarDesconectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_conectarDesconectarActionPerformed(evt);
            }
        });
        mn_rede.add(mi_conectarDesconectar);

        mi_usuarios.setText("Usuários");
        mi_usuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_usuariosActionPerformed(evt);
            }
        });
        mn_rede.add(mi_usuarios);

        mi_aplicacaoCliente.setText("Eletron Vision Portátil");
        mi_aplicacaoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_aplicacaoClienteActionPerformed(evt);
            }
        });
        mn_rede.add(mi_aplicacaoCliente);

        mi_ativarAudioCameras.setText("Ativar áudio câmeras");
        mi_ativarAudioCameras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_ativarAudioCamerasActionPerformed(evt);
            }
        });
        mn_audio.add(mi_ativarAudioCameras);

        mi_ativarAudioSistema.setText("Ativar áudio sistema");
        mi_ativarAudioSistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_ativarAudioSistemaActionPerformed(evt);
            }
        });
        mn_audio.add(mi_ativarAudioSistema);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("ELETRO VISION - 1.0");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lb_movimento.setBackground(new java.awt.Color(51, 175, 233));
        lb_movimento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_movimento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/status/movInativo_32x32.png"))); // NOI18N
        lb_movimento.setToolTipText("Movimentos");
        lb_movimento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_movimentoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lb_movimentoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lb_movimentoMouseExited(evt);
            }
        });

        lb_agendarTarefas.setBackground(new java.awt.Color(255, 255, 255));
        lb_agendarTarefas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_agendarTarefas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/status/agendarInativo_32x32.png"))); // NOI18N
        lb_agendarTarefas.setToolTipText("Agendamentos de Tarefas");
        lb_agendarTarefas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_agendarTarefasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lb_agendarTarefasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lb_agendarTarefasMouseExited(evt);
            }
        });

        lb_mensagens.setBackground(new java.awt.Color(255, 255, 255));
        lb_mensagens.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_mensagens.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/status/mensagem_32x32.png"))); // NOI18N
        lb_mensagens.setToolTipText("Mensagens");
        lb_mensagens.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_mensagensMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lb_mensagensMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lb_mensagensMouseExited(evt);
            }
        });

        lb_dispositivosEletricos.setBackground(new java.awt.Color(255, 255, 255));
        lb_dispositivosEletricos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_dispositivosEletricos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/status/dispoDesligado_32x32.png"))); // NOI18N
        lb_dispositivosEletricos.setToolTipText("Dispositivos");
        lb_dispositivosEletricos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_dispositivosEletricosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lb_dispositivosEletricosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lb_dispositivosEletricosMouseExited(evt);
            }
        });

        lb_cameras.setBackground(new java.awt.Color(255, 255, 255));
        lb_cameras.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_cameras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/status/camerasDesligadas_32x32.png"))); // NOI18N
        lb_cameras.setToolTipText("Câmeras");
        lb_cameras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_camerasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lb_camerasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lb_camerasMouseExited(evt);
            }
        });

        lb_pessoa.setBackground(new java.awt.Color(116, 211, 135));
        lb_pessoa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_pessoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/status/pessoaInativa_32x32.png"))); // NOI18N
        lb_pessoa.setToolTipText("Detecção de Face, olhos e Corpo");
        lb_pessoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_pessoaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lb_pessoaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lb_pessoaMouseExited(evt);
            }
        });

        lb_rede.setBackground(new java.awt.Color(255, 255, 255));
        lb_rede.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_rede.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/status/desconectado_32x32.png"))); // NOI18N
        lb_rede.setToolTipText("Rede");
        lb_rede.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_redeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lb_redeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lb_redeMouseExited(evt);
            }
        });

        lb_usuario.setBackground(new java.awt.Color(255, 255, 255));
        lb_usuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/status/usuario_32x32.png"))); // NOI18N
        lb_usuario.setToolTipText("Trocar Usuário");
        lb_usuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_usuarioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lb_usuarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lb_usuarioMouseExited(evt);
            }
        });

        lb_audio.setBackground(new java.awt.Color(255, 255, 255));
        lb_audio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_audio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/status/audioCompleto_32x32.png"))); // NOI18N
        lb_audio.setToolTipText("Manipular Sons");
        lb_audio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_audioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lb_audioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lb_audioMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_movimento, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
            .addComponent(lb_pessoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lb_cameras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lb_dispositivosEletricos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lb_agendarTarefas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lb_mensagens, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lb_rede, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lb_usuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lb_audio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(lb_movimento)
                .addGap(4, 4, 4)
                .addComponent(lb_pessoa)
                .addGap(4, 4, 4)
                .addComponent(lb_cameras)
                .addGap(4, 4, 4)
                .addComponent(lb_dispositivosEletricos)
                .addGap(4, 4, 4)
                .addComponent(lb_agendarTarefas)
                .addGap(4, 4, 4)
                .addComponent(lb_mensagens, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb_rede, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb_audio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb_usuario)
                .addContainerGap(322, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/layout/logo_nome.png"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.setMaximumSize(new java.awt.Dimension(200, 200));
        jPanel2.setMinimumSize(new java.awt.Dimension(100, 100));

        btt_geral.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btt_geral.setText("Geral");
        btt_geral.setName("Geral"); // NOI18N
        btt_geral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btt_geralActionPerformed(evt);
            }
        });

        btt_visualizarCameras.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btt_visualizarCameras.setText("Visualizar Câmeras");
        btt_visualizarCameras.setName("Visualizar Câmeras"); // NOI18N
        btt_visualizarCameras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btt_visualizarCamerasActionPerformed(evt);
            }
        });

        btt_mapaDispositivos.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btt_mapaDispositivos.setText("Mapa Dispositivos");
        btt_mapaDispositivos.setName("Mapa Dispositivos"); // NOI18N
        btt_mapaDispositivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btt_mapaDispositivosActionPerformed(evt);
            }
        });

        btt_montarCenario.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btt_montarCenario.setText("Cenário");
        btt_montarCenario.setName("Cenário"); // NOI18N
        btt_montarCenario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btt_montarCenarioActionPerformed(evt);
            }
        });

        btt_agendarTarefas.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btt_agendarTarefas.setText("Agendar Tarefas");
        btt_agendarTarefas.setName("Agendar Tarefas"); // NOI18N
        btt_agendarTarefas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btt_agendarTarefasActionPerformed(evt);
            }
        });

        btt_mensagens.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btt_mensagens.setText("Mensagens");
        btt_mensagens.setName("Mensagens"); // NOI18N
        btt_mensagens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btt_mensagensActionPerformed(evt);
            }
        });

        btt_logAcoes.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btt_logAcoes.setText("Log de Ações");
        btt_logAcoes.setName("Log de Ações"); // NOI18N
        btt_logAcoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btt_logAcoesActionPerformed(evt);
            }
        });

        btt_localizacaoGPS.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btt_localizacaoGPS.setText("Localização GPS");
        btt_localizacaoGPS.setName("Localização GPS"); // NOI18N
        btt_localizacaoGPS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btt_localizacaoGPSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_geralLayout = new javax.swing.GroupLayout(pn_geral);
        pn_geral.setLayout(pn_geralLayout);
        pn_geralLayout.setHorizontalGroup(
            pn_geralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_geralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_geralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btt_mapaDispositivos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btt_visualizarCameras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btt_logAcoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btt_montarCenario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btt_agendarTarefas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btt_mensagens, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btt_localizacaoGPS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        pn_geralLayout.setVerticalGroup(
            pn_geralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_geralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btt_visualizarCameras)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btt_mapaDispositivos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btt_montarCenario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btt_localizacaoGPS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btt_mensagens)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btt_agendarTarefas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btt_logAcoes)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btt_cadastros.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btt_cadastros.setText("Cadastros");
        btt_cadastros.setName("Cadastros"); // NOI18N
        btt_cadastros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btt_cadastrosActionPerformed(evt);
            }
        });

        btt_cadPessoas.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btt_cadPessoas.setText("Pessoa");
        btt_cadPessoas.setName("Cadastrar Pessoas"); // NOI18N
        btt_cadPessoas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btt_cadPessoasActionPerformed(evt);
            }
        });

        btt_cadUsuario.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btt_cadUsuario.setText("Usuário");
        btt_cadUsuario.setName("Cadastrar Usuário"); // NOI18N
        btt_cadUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btt_cadUsuarioActionPerformed(evt);
            }
        });

        btt_cadPredio.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btt_cadPredio.setText("Prédio");
        btt_cadPredio.setName("Cadastrar Prédio"); // NOI18N
        btt_cadPredio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btt_cadPredioActionPerformed(evt);
            }
        });

        btt_cadCamera.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btt_cadCamera.setText("Câmera");
        btt_cadCamera.setName("Cadastrar Câmera"); // NOI18N
        btt_cadCamera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btt_cadCameraActionPerformed(evt);
            }
        });

        btt_cadModuloAcionamento.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btt_cadModuloAcionamento.setText("Módulo de Acionamento");
        btt_cadModuloAcionamento.setName("Cadastrar Módulo Acionamento"); // NOI18N
        btt_cadModuloAcionamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btt_cadModuloAcionamentoActionPerformed(evt);
            }
        });

        btt_cadDispositivoEletrico.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btt_cadDispositivoEletrico.setText("Dispositivo Elétrico");
        btt_cadDispositivoEletrico.setName("Cadastrar Dispositivo Elétrico"); // NOI18N
        btt_cadDispositivoEletrico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btt_cadDispositivoEletricoActionPerformed(evt);
            }
        });

        btt_cadMarca.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btt_cadMarca.setText("Marca");
        btt_cadMarca.setName("Cadastrar Marca"); // NOI18N
        btt_cadMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btt_cadMarcaActionPerformed(evt);
            }
        });

        btt_cadArea.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btt_cadArea.setText("Área");
        btt_cadArea.setName("Cadastrar Área"); // NOI18N
        btt_cadArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btt_cadAreaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_cadastrosLayout = new javax.swing.GroupLayout(pn_cadastros);
        pn_cadastros.setLayout(pn_cadastrosLayout);
        pn_cadastrosLayout.setHorizontalGroup(
            pn_cadastrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_cadastrosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_cadastrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btt_cadPessoas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btt_cadUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btt_cadPredio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btt_cadArea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btt_cadDispositivoEletrico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btt_cadCamera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btt_cadModuloAcionamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btt_cadMarca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        pn_cadastrosLayout.setVerticalGroup(
            pn_cadastrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_cadastrosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btt_cadPessoas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btt_cadUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btt_cadPredio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btt_cadArea)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btt_cadMarca)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(btt_cadCamera)
                .addGap(5, 5, 5)
                .addComponent(btt_cadModuloAcionamento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btt_cadDispositivoEletrico)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btt_cadDispositivoEletrico.getAccessibleContext().setAccessibleName("Cadastrar Dispositivo Elétrico");

        btt_relatorios.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btt_relatorios.setText("Relatórios");
        btt_relatorios.setName("Relatórios"); // NOI18N
        btt_relatorios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btt_relatoriosActionPerformed(evt);
            }
        });

        btt_relatPessoas.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btt_relatPessoas.setText("Pessoas");
        btt_relatPessoas.setName("Relatório Pessoas"); // NOI18N
        btt_relatPessoas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btt_relatPessoasActionPerformed(evt);
            }
        });

        btt_relatPredio.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btt_relatPredio.setText("Prédios");
        btt_relatPredio.setName("Relatório Prédio"); // NOI18N
        btt_relatPredio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btt_relatPredioActionPerformed(evt);
            }
        });

        btt_relatDispositivo.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btt_relatDispositivo.setText("Dispositivos");
        btt_relatDispositivo.setName("Relatório Dispositivos"); // NOI18N
        btt_relatDispositivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btt_relatDispositivoActionPerformed(evt);
            }
        });

        btt_relatMensagens.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btt_relatMensagens.setText("Mensagens");
        btt_relatMensagens.setName("Relatório Mensagens"); // NOI18N
        btt_relatMensagens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btt_relatMensagensActionPerformed(evt);
            }
        });

        btt_relatMovimentos.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btt_relatMovimentos.setText("Movimentos");
        btt_relatMovimentos.setName("Relatório Movimentos"); // NOI18N
        btt_relatMovimentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btt_relatMovimentosActionPerformed(evt);
            }
        });

        btt_relatAcionamento.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btt_relatAcionamento.setText("Acionamentos");
        btt_relatAcionamento.setName("Relatório Acionamentos"); // NOI18N
        btt_relatAcionamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btt_relatAcionamentoActionPerformed(evt);
            }
        });

        btt_relatAgendarTarefas.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btt_relatAgendarTarefas.setText("Agendamento de Tarefas");
        btt_relatAgendarTarefas.setName("Relatório Agendamento"); // NOI18N
        btt_relatAgendarTarefas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btt_relatAgendarTarefasActionPerformed(evt);
            }
        });

        btt_relatLogAcoes.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btt_relatLogAcoes.setText("Log de Ações");
        btt_relatLogAcoes.setName("Relatório Log de Ações"); // NOI18N
        btt_relatLogAcoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btt_relatLogAcoesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_relatoriosLayout = new javax.swing.GroupLayout(pn_relatorios);
        pn_relatorios.setLayout(pn_relatoriosLayout);
        pn_relatoriosLayout.setHorizontalGroup(
            pn_relatoriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addComponent(jSeparator4)
            .addGroup(pn_relatoriosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_relatoriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btt_relatPessoas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btt_relatPredio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btt_relatDispositivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btt_relatMensagens, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btt_relatMovimentos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btt_relatAcionamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btt_relatAgendarTarefas, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                    .addComponent(btt_relatLogAcoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pn_relatoriosLayout.setVerticalGroup(
            pn_relatoriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_relatoriosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btt_relatPessoas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btt_relatPredio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btt_relatDispositivo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btt_relatMensagens)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btt_relatMovimentos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btt_relatAcionamento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btt_relatAgendarTarefas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btt_relatLogAcoes)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btt_configuracoes.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btt_configuracoes.setText("Ferramentas");
        btt_configuracoes.setName("Configurações"); // NOI18N
        btt_configuracoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btt_configuracoesActionPerformed(evt);
            }
        });

        btt_ferramentasEditarImagens.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btt_ferramentasEditarImagens.setText("Editar Imagens");
        btt_ferramentasEditarImagens.setName("Editar Imagens"); // NOI18N
        btt_ferramentasEditarImagens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btt_ferramentasEditarImagensActionPerformed(evt);
            }
        });

        btt_ferramentasOpcoes.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btt_ferramentasOpcoes.setText("Opções");
        btt_ferramentasOpcoes.setName("Opções"); // NOI18N
        btt_ferramentasOpcoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btt_ferramentasOpcoesActionPerformed(evt);
            }
        });

        btt_ferramentasDesenharMapas.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btt_ferramentasDesenharMapas.setText("Desenhar Mapas");
        btt_ferramentasDesenharMapas.setName("Desenhar Mapas"); // NOI18N
        btt_ferramentasDesenharMapas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btt_ferramentasDesenharMapasActionPerformed(evt);
            }
        });

        btt_ferramentasVideos.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btt_ferramentasVideos.setText("Repredutor Videos");
        btt_ferramentasVideos.setName("Reprodutor Videos"); // NOI18N
        btt_ferramentasVideos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btt_ferramentasVideosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_configuracoesLayout = new javax.swing.GroupLayout(pn_configuracoes);
        pn_configuracoes.setLayout(pn_configuracoesLayout);
        pn_configuracoesLayout.setHorizontalGroup(
            pn_configuracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_configuracoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_configuracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btt_ferramentasEditarImagens, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btt_ferramentasVideos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btt_ferramentasDesenharMapas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btt_ferramentasOpcoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pn_configuracoesLayout.setVerticalGroup(
            pn_configuracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_configuracoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btt_ferramentasEditarImagens)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btt_ferramentasVideos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btt_ferramentasDesenharMapas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btt_ferramentasOpcoes)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btt_ajuda.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btt_ajuda.setText("Ajunda");
        btt_ajuda.setName("Ajuda"); // NOI18N
        btt_ajuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btt_ajudaActionPerformed(evt);
            }
        });

        btt_manual.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btt_manual.setText("Manual");
        btt_manual.setName("Manual"); // NOI18N
        btt_manual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btt_manualActionPerformed(evt);
            }
        });

        btt_sobre.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btt_sobre.setText("Sobre");
        btt_sobre.setName("Sobre"); // NOI18N
        btt_sobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btt_sobreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_ajudaLayout = new javax.swing.GroupLayout(pn_ajuda);
        pn_ajuda.setLayout(pn_ajudaLayout);
        pn_ajudaLayout.setHorizontalGroup(
            pn_ajudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_ajudaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_ajudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btt_sobre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btt_manual, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pn_ajudaLayout.setVerticalGroup(
            pn_ajudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_ajudaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btt_manual)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btt_sobre)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btt_pesquisa.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btt_pesquisa.setText("Pesquisas");
        btt_pesquisa.setName("Pesquisas"); // NOI18N
        btt_pesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btt_pesquisaActionPerformed(evt);
            }
        });

        btt_pesqPessoas.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btt_pesqPessoas.setText("Pessoa");
        btt_pesqPessoas.setName("Pesquisar Pessoas"); // NOI18N
        btt_pesqPessoas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btt_pesqPessoasActionPerformed(evt);
            }
        });

        btt_pesqUsuario.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btt_pesqUsuario.setText("Usuário");
        btt_pesqUsuario.setName("Pesquisar Usuário"); // NOI18N
        btt_pesqUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btt_pesqUsuarioActionPerformed(evt);
            }
        });

        btt_pesqPredio.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btt_pesqPredio.setText("Prédio");
        btt_pesqPredio.setName("Pesquisar Prédio"); // NOI18N
        btt_pesqPredio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btt_pesqPredioActionPerformed(evt);
            }
        });

        btt_pesqCamera.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btt_pesqCamera.setText("Câmera");
        btt_pesqCamera.setName("Pesquisar Câmera"); // NOI18N
        btt_pesqCamera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btt_pesqCameraActionPerformed(evt);
            }
        });

        btt_pesqModuloAcionamento.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btt_pesqModuloAcionamento.setText("Módulo de Acionamento");
        btt_pesqModuloAcionamento.setName("Pesquisar Módulo Acionamento"); // NOI18N
        btt_pesqModuloAcionamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btt_pesqModuloAcionamentoActionPerformed(evt);
            }
        });

        btt_pesqDispositivoEletrico.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btt_pesqDispositivoEletrico.setText("Dispositivo Elétrico");
        btt_pesqDispositivoEletrico.setName("Pesquisar Dispositivo Elétrico"); // NOI18N
        btt_pesqDispositivoEletrico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btt_pesqDispositivoEletricoActionPerformed(evt);
            }
        });

        btt_pesqMarca.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btt_pesqMarca.setText("Marca");
        btt_pesqMarca.setName("Pesquisar Marca"); // NOI18N
        btt_pesqMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btt_pesqMarcaActionPerformed(evt);
            }
        });

        btt_pesqArea.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btt_pesqArea.setText("Área");
        btt_pesqArea.setName("Pesquisar Área"); // NOI18N
        btt_pesqArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btt_pesqAreaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_pesquisaLayout = new javax.swing.GroupLayout(pn_pesquisa);
        pn_pesquisa.setLayout(pn_pesquisaLayout);
        pn_pesquisaLayout.setHorizontalGroup(
            pn_pesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(pn_pesquisaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_pesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btt_pesqPessoas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btt_pesqUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btt_pesqPredio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btt_pesqDispositivoEletrico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btt_pesqCamera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btt_pesqModuloAcionamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btt_pesqMarca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btt_pesqArea, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pn_pesquisaLayout.setVerticalGroup(
            pn_pesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_pesquisaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btt_pesqPessoas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btt_pesqUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btt_pesqPredio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btt_pesqArea)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btt_pesqMarca)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btt_pesqCamera)
                .addGap(5, 5, 5)
                .addComponent(btt_pesqModuloAcionamento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btt_pesqDispositivoEletrico)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pn_menuLayout = new javax.swing.GroupLayout(pn_menu);
        pn_menu.setLayout(pn_menuLayout);
        pn_menuLayout.setHorizontalGroup(
            pn_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btt_geral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btt_cadastros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btt_pesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btt_relatorios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btt_configuracoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btt_ajuda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pn_menuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pn_geral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pn_cadastros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pn_pesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pn_relatorios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pn_configuracoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pn_ajuda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pn_menuLayout.setVerticalGroup(
            pn_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_menuLayout.createSequentialGroup()
                .addComponent(btt_geral)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_geral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btt_cadastros)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_cadastros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btt_pesquisa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btt_relatorios)
                .addGap(3, 3, 3)
                .addComponent(pn_relatorios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btt_configuracoes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_configuracoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btt_ajuda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_ajuda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pn_menu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pn_menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jScrollPane1.setViewportView(jPanel2);

        tb_principal.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tb_principalStateChanged(evt);
            }
        });

        lb_dataHora.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        lb_dataHora.setText("Data/Hora:");

        lb_progresso.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N

        lb_usuarioLogado.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        lb_usuarioLogado.setText("Usuário: Wesllen Sousa Lima");

        javax.swing.GroupLayout jXStatusBar1Layout = new javax.swing.GroupLayout(jXStatusBar1);
        jXStatusBar1.setLayout(jXStatusBar1Layout);
        jXStatusBar1Layout.setHorizontalGroup(
            jXStatusBar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXStatusBar1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_progresso, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lb_usuarioLogado, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lb_dataHora, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        jXStatusBar1Layout.setVerticalGroup(
            jXStatusBar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXStatusBar1Layout.createSequentialGroup()
                .addGroup(jXStatusBar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_progresso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_dataHora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_usuarioLogado))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXStatusBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tb_principal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tb_principal))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jXStatusBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-1042)/2, (screenSize.height-745)/2, 1042, 745);
    }// </editor-fold>//GEN-END:initComponents

    private void btt_geralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btt_geralActionPerformed
        manipularMenu(btt_geral, pn_geral);
}//GEN-LAST:event_btt_geralActionPerformed

    private void btt_cadastrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btt_cadastrosActionPerformed
        manipularMenu(btt_cadastros, pn_cadastros);
}//GEN-LAST:event_btt_cadastrosActionPerformed

    private void btt_relatoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btt_relatoriosActionPerformed
        manipularMenu(btt_relatorios, pn_relatorios);
}//GEN-LAST:event_btt_relatoriosActionPerformed

    private void btt_configuracoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btt_configuracoesActionPerformed
        manipularMenu(btt_configuracoes, pn_configuracoes);
}//GEN-LAST:event_btt_configuracoesActionPerformed

    private void btt_cadPessoasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btt_cadPessoasActionPerformed
        if (VerificaAutorizacao.cadastro_pessoa) {
            informarProgresso(MensagensSoltas.principal_status_cadastrarPessoas());
            Cadastro cadastro = new Cadastro();
            JPanel panel = manipulaItemMenu(btt_cadPessoas, cadastro);
            if (panel != null) {
                executarSomAbrirJanela();
                cadastrarPessoa(cadastro);
            }
            limparProgresso();
        } else {
            VerificaAutorizacao.acessoNegado();
            btt_cadPessoas.setSelected(false);
        }
    }//GEN-LAST:event_btt_cadPessoasActionPerformed

    private void btt_cadUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btt_cadUsuarioActionPerformed
        if (VerificaAutorizacao.cadastro_usuario) {
            informarProgresso(MensagensSoltas.principal_status_cadastrarUsuarios());
            Cadastro cadastro = new Cadastro();
            JPanel panel = manipulaItemMenu(btt_cadUsuario, cadastro);
            if (panel != null) {
                executarSomAbrirJanela();
                cadastrarUsuario(cadastro);
            }
            limparProgresso();
        } else {
            VerificaAutorizacao.acessoNegado();
            btt_cadUsuario.setSelected(false);
        }
    }//GEN-LAST:event_btt_cadUsuarioActionPerformed

    private void btt_cadPredioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btt_cadPredioActionPerformed
        if (VerificaAutorizacao.cadastro_predio) {
            informarProgresso(MensagensSoltas.principal_status_cadastrarPredios());
            Cadastro cadastro = new Cadastro();
            JPanel panel = manipulaItemMenu(btt_cadPredio, cadastro);
            if (panel != null) {
                executarSomAbrirJanela();
                cadastrarPredio(cadastro);
            }
            limparProgresso();
        } else {
            VerificaAutorizacao.acessoNegado();
            btt_cadPredio.setSelected(false);
        }
    }//GEN-LAST:event_btt_cadPredioActionPerformed

    private void btt_cadCameraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btt_cadCameraActionPerformed
        if (VerificaAutorizacao.cadastro_camera) {
            informarProgresso(MensagensSoltas.principal_status_cadastrarCameras());
            Cadastro cadastro = new Cadastro();
            JPanel panel = manipulaItemMenu(btt_cadCamera, cadastro);
            if (panel != null) {
                executarSomAbrirJanela();
                cadastrarCamera(cadastro);
            }
            limparProgresso();
        } else {
            VerificaAutorizacao.acessoNegado();
            btt_cadCamera.setSelected(false);
        }
    }//GEN-LAST:event_btt_cadCameraActionPerformed

    private void btt_cadModuloAcionamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btt_cadModuloAcionamentoActionPerformed
        if (VerificaAutorizacao.cadastro_moduloAcionamento) {
            informarProgresso(MensagensSoltas.principal_status_cadastrarModuloAcionamento());
            Cadastro cadastro = new Cadastro();
            JPanel panel = manipulaItemMenu(btt_cadModuloAcionamento, cadastro);
            if (panel != null) {
                executarSomAbrirJanela();
                cadastrarModuloAcionamento(cadastro);
            }
            limparProgresso();
        } else {
            VerificaAutorizacao.acessoNegado();
            btt_cadModuloAcionamento.setSelected(false);
        }
    }//GEN-LAST:event_btt_cadModuloAcionamentoActionPerformed

    private void btt_cadDispositivoEletricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btt_cadDispositivoEletricoActionPerformed
        if (VerificaAutorizacao.cadastro_dispositivoEletrico) {
            informarProgresso(MensagensSoltas.principal_status_cadastrarDispositivosEletricos());
            Cadastro cadastro = new Cadastro();
            JPanel panel = manipulaItemMenu(btt_cadDispositivoEletrico, cadastro);
            if (panel != null) {
                executarSomAbrirJanela();
                cadastrarDispositivoEletrico(cadastro);
            }
            limparProgresso();
        } else {
            VerificaAutorizacao.acessoNegado();
            btt_cadDispositivoEletrico.setSelected(false);
        }
    }//GEN-LAST:event_btt_cadDispositivoEletricoActionPerformed

    private void btt_ajudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btt_ajudaActionPerformed
        manipularMenu(btt_ajuda, pn_ajuda);
    }//GEN-LAST:event_btt_ajudaActionPerformed

    private void btt_manualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btt_manualActionPerformed
        if (VerificaAutorizacao.ajuda_manual) {
            informarProgresso(MensagensSoltas.principal_status_manual());
            JPanel panel = manipulaItemMenu(btt_manual, new Manual());
            if (panel != null) {
                executarSomAbrirJanela();
                manual(panel);
            }
            limparProgresso();
        } else {
            VerificaAutorizacao.acessoNegado();
            btt_manual.setSelected(false);
        }
    }//GEN-LAST:event_btt_manualActionPerformed

    private void btt_sobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btt_sobreActionPerformed
        sobre();
    }//GEN-LAST:event_btt_sobreActionPerformed

    private void btt_relatPessoasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btt_relatPessoasActionPerformed
        if (VerificaAutorizacao.relatorio_pessoa) {
            informarProgresso(MensagensSoltas.principal_status_relatorioPessoas());
            Relatorio relatorio = new Relatorio();
            JPanel panel = manipulaItemMenu(btt_relatPessoas, relatorio);
            if (panel != null) {
                executarSomAbrirJanela();
                relatorioPessoas(relatorio);
            }
            limparProgresso();
        } else {
            VerificaAutorizacao.acessoNegado();
            btt_relatPessoas.setSelected(false);
        }
    }//GEN-LAST:event_btt_relatPessoasActionPerformed

    private void btt_relatPredioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btt_relatPredioActionPerformed
        if (VerificaAutorizacao.relatorio_predio) {
            informarProgresso(MensagensSoltas.principal_status_relatorioPredios());
            Relatorio relatorio = new Relatorio();
            JPanel panel = manipulaItemMenu(btt_relatPredio, relatorio);
            if (panel != null) {
                executarSomAbrirJanela();
                relatorioPredio(relatorio);
            }
            limparProgresso();
        } else {
            VerificaAutorizacao.acessoNegado();
            btt_relatPredio.setSelected(false);
        }
    }//GEN-LAST:event_btt_relatPredioActionPerformed

    private void btt_relatDispositivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btt_relatDispositivoActionPerformed
        if (VerificaAutorizacao.relatorio_dispositivo) {
            informarProgresso(MensagensSoltas.principal_status_relatorioDispositivos());
            Relatorio relatorio = new Relatorio();
            JPanel panel = manipulaItemMenu(btt_relatDispositivo, relatorio);
            if (panel != null) {
                executarSomAbrirJanela();
                relatorioDispositivos(relatorio);
            }
            limparProgresso();
        } else {
            VerificaAutorizacao.acessoNegado();
            btt_relatDispositivo.setSelected(false);
        }
    }//GEN-LAST:event_btt_relatDispositivoActionPerformed

    private void btt_ferramentasEditarImagensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btt_ferramentasEditarImagensActionPerformed
        if (VerificaAutorizacao.ferramentas_editarImagens) {
            informarProgresso(MensagensSoltas.principal_status_ferramentasEditarImagens());
            FerramentasEditarImagens editarImagens = new FerramentasEditarImagens();
            JPanel panel = manipulaItemMenu(btt_ferramentasEditarImagens, editarImagens);
            if (panel != null) {
                executarSomAbrirJanela();
                editarImagens(editarImagens);
            }
            limparProgresso();
        } else {
            VerificaAutorizacao.acessoNegado();
            btt_ferramentasEditarImagens.setSelected(false);
        }
    }//GEN-LAST:event_btt_ferramentasEditarImagensActionPerformed

    private void btt_ferramentasOpcoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btt_ferramentasOpcoesActionPerformed
        if (VerificaAutorizacao.ferramentas_opcoes) {
            informarProgresso(MensagensSoltas.principal_status_ferramentasOpcoes());
            Configuracao configuracao = new Configuracao();
            JPanel panel = manipulaItemMenu(btt_ferramentasOpcoes, configuracao);
            if (panel != null) {
                executarSomAbrirJanela();
                ferramentasOpcoes(configuracao);
            }
            limparProgresso();
        } else {
            VerificaAutorizacao.acessoNegado();
            btt_ferramentasOpcoes.setSelected(false);
        }
    }//GEN-LAST:event_btt_ferramentasOpcoesActionPerformed

    private void btt_relatMensagensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btt_relatMensagensActionPerformed
        if (VerificaAutorizacao.relatorio_mensagens) {
            informarProgresso(MensagensSoltas.principal_status_relatorioMensagens());
            Relatorio relatorio = new Relatorio();
            JPanel panel = manipulaItemMenu(btt_relatMensagens, relatorio);
            if (panel != null) {
                executarSomAbrirJanela();
                relatorioMensagens(relatorio);
            }
            limparProgresso();
        } else {
            VerificaAutorizacao.acessoNegado();
            btt_relatMensagens.setSelected(false);
        }
    }//GEN-LAST:event_btt_relatMensagensActionPerformed

    private void btt_relatMovimentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btt_relatMovimentosActionPerformed
        if (VerificaAutorizacao.relatorio_movimento) {
            informarProgresso(MensagensSoltas.principal_status_relatorioMovimentos());
            Relatorio relatorio = new Relatorio();
            JPanel panel = manipulaItemMenu(btt_relatMovimentos, relatorio);
            if (panel != null) {
                executarSomAbrirJanela();
                relatorioMovimento(relatorio);
            }
            limparProgresso();
        } else {
            VerificaAutorizacao.acessoNegado();
            btt_relatMovimentos.setSelected(false);
        }
    }//GEN-LAST:event_btt_relatMovimentosActionPerformed

    private void btt_visualizarCamerasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btt_visualizarCamerasActionPerformed
        if (VerificaAutorizacao.geral_visualizarCameras) {
            informarProgresso(MensagensSoltas.principal_status_visualizarCameras());
            GeralVisualizarCameras geralVisualizarCameras = new GeralVisualizarCameras();
            JPanel panel = manipulaItemMenu(btt_visualizarCameras, geralVisualizarCameras);
            if (panel != null) {
                executarSomAbrirJanela();
                visualizarCameras(geralVisualizarCameras);
            }
            limparProgresso();
        } else {
            VerificaAutorizacao.acessoNegado();
            btt_visualizarCameras.setSelected(false);
        }
    }//GEN-LAST:event_btt_visualizarCamerasActionPerformed

    private void btt_mapaDispositivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btt_mapaDispositivosActionPerformed
        if (VerificaAutorizacao.geral_mapaDispositivos) {
            informarProgresso(MensagensSoltas.principal_status_mapaDispositivos());
            GeralMapaDispositivos geralMapaDispositivos = new GeralMapaDispositivos();
            JPanel panel = manipulaItemMenu(btt_mapaDispositivos, geralMapaDispositivos);
            if (panel != null) {
                executarSomAbrirJanela();
                mapaDispositivos(geralMapaDispositivos);
            }
            limparProgresso();
        } else {
            VerificaAutorizacao.acessoNegado();
            btt_mapaDispositivos.setSelected(false);
        }
    }//GEN-LAST:event_btt_mapaDispositivosActionPerformed

    private void btt_montarCenarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btt_montarCenarioActionPerformed
        if (VerificaAutorizacao.geral_cenario) {
            informarProgresso(MensagensSoltas.principal_status_cenario());
            GeralCenario geralCenario = new GeralCenario();
            JPanel panel = manipulaItemMenu(btt_montarCenario, geralCenario);
            if (panel != null) {
                executarSomAbrirJanela();
                geralCenario(geralCenario);
            }
            limparProgresso();
        } else {
            VerificaAutorizacao.acessoNegado();
            btt_montarCenario.setSelected(false);
        }
    }//GEN-LAST:event_btt_montarCenarioActionPerformed

    private void btt_agendarTarefasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btt_agendarTarefasActionPerformed
        if (VerificaAutorizacao.geral_agendarTarefas) {
            informarProgresso(MensagensSoltas.principal_status_agendarTarefas());
            JPanel panel = manipulaItemMenu(btt_agendarTarefas, new GeralAgendarTarefas());
            if (panel != null) {
                executarSomAbrirJanela();
            }
            limparProgresso();
        } else {
            VerificaAutorizacao.acessoNegado();
            btt_agendarTarefas.setSelected(false);
        }
    }//GEN-LAST:event_btt_agendarTarefasActionPerformed

    private void dataHoraOnTime(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataHoraOnTime
        lb_dataHora.setText("Data/Hora: " + DataUtil.formataDataHHmmSS(Calendar.getInstance()));
    }//GEN-LAST:event_dataHoraOnTime

    private void tb_principalStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tb_principalStateChanged
        if (InstanciasControle.getTituloTab() != null) {
            tiraSelecaoToggleButtonPorName(InstanciasControle.getTituloTab());
            InstanciasControle.setTituloTab(null);
        }
}//GEN-LAST:event_tb_principalStateChanged

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        fecharTela();
    }//GEN-LAST:event_formWindowClosing

private void btt_cadMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btt_cadMarcaActionPerformed
    if (VerificaAutorizacao.cadastro_marca) {
        informarProgresso(MensagensSoltas.principal_status_cadastrarMarca());
        Cadastro cadastro = new Cadastro();
        JPanel panel = manipulaItemMenu(btt_cadMarca, cadastro);
        if (panel != null) {
            executarSomAbrirJanela();
            cadastrarMarca(cadastro);
        }
        limparProgresso();
    } else {
        VerificaAutorizacao.acessoNegado();
        btt_cadMarca.setSelected(false);
    }
}//GEN-LAST:event_btt_cadMarcaActionPerformed

private void btt_ferramentasDesenharMapasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btt_ferramentasDesenharMapasActionPerformed
    if (VerificaAutorizacao.ferramentas_desenharMapas) {
        informarProgresso(MensagensSoltas.principal_status_ferramentasDesenharMapas());
        FerramentasDesenhar ferramentasDesenharMapas = new FerramentasDesenhar();
        JPanel panel = manipulaItemMenu(btt_ferramentasDesenharMapas, ferramentasDesenharMapas);
        if (panel != null) {
            executarSomAbrirJanela();
            esperarTelas();
            ferramentasDesenharMapas.iniciarPaintVazio();
        }
        limparProgresso();
    } else {
        VerificaAutorizacao.acessoNegado();
        btt_ferramentasDesenharMapas.setSelected(false);
    }
}//GEN-LAST:event_btt_ferramentasDesenharMapasActionPerformed

private void btt_mensagensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btt_mensagensActionPerformed
    if (VerificaAutorizacao.geral_mensagens) {
        informarProgresso(MensagensSoltas.principal_status_mensagens());
        JPanel panel = manipulaItemMenu(btt_mensagens, new GeralMensagens());
        if (panel != null) {
            executarSomAbrirJanela();
        }
        limparProgresso();
    } else {
        VerificaAutorizacao.acessoNegado();
        btt_mensagens.setSelected(false);
    }
}//GEN-LAST:event_btt_mensagensActionPerformed

private void btt_relatAcionamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btt_relatAcionamentoActionPerformed
    if (VerificaAutorizacao.relatorio_acionamento) {
        informarProgresso(MensagensSoltas.principal_status_relatorioAcionamento());
        Relatorio relatorio = new Relatorio();
        JPanel panel = manipulaItemMenu(btt_relatAcionamento, relatorio);
        if (panel != null) {
            executarSomAbrirJanela();
            relatorioAcionamento(relatorio);
        }
        limparProgresso();
    } else {
        VerificaAutorizacao.acessoNegado();
        btt_mensagens.setSelected(false);
    }
}//GEN-LAST:event_btt_relatAcionamentoActionPerformed

private void btt_pesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btt_pesquisaActionPerformed
    manipularMenu(btt_pesquisa, pn_pesquisa);
}//GEN-LAST:event_btt_pesquisaActionPerformed

private void btt_pesqPessoasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btt_pesqPessoasActionPerformed
    if (VerificaAutorizacao.pesquisar_pessoa) {
        informarProgresso(MensagensSoltas.principal_status_pesquisarPessoas());
        Pesquisa pesquisa = new Pesquisa();
        JPanel panel = manipulaItemMenu(btt_pesqPessoas, pesquisa);
        if (panel != null) {
            executarSomAbrirJanela();
            pesquisarPessoa(pesquisa);
        }
        limparProgresso();
    } else {
        VerificaAutorizacao.acessoNegado();
        btt_pesqPessoas.setSelected(false);
    }
}//GEN-LAST:event_btt_pesqPessoasActionPerformed

private void btt_pesqUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btt_pesqUsuarioActionPerformed
    if (VerificaAutorizacao.pesquisar_usuario) {
        informarProgresso(MensagensSoltas.principal_status_pesquisarUsuarios());
        Pesquisa pesquisa = new Pesquisa();
        JPanel panel = manipulaItemMenu(btt_pesqUsuario, pesquisa);
        if (panel != null) {
            executarSomAbrirJanela();
            pesquisarUsuario(pesquisa);
        }
        limparProgresso();
    } else {
        VerificaAutorizacao.acessoNegado();
        btt_pesqUsuario.setSelected(false);
    }
}//GEN-LAST:event_btt_pesqUsuarioActionPerformed

private void btt_pesqPredioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btt_pesqPredioActionPerformed
    if (VerificaAutorizacao.pesquisar_predio) {
        informarProgresso(MensagensSoltas.principal_status_pesquisarPredio());
        Pesquisa pesquisa = new Pesquisa();
        JPanel panel = manipulaItemMenu(btt_pesqPredio, pesquisa);
        if (panel != null) {
            executarSomAbrirJanela();
            pesquisarPredio(pesquisa);
        }
        limparProgresso();
    } else {
        VerificaAutorizacao.acessoNegado();
        btt_pesqPredio.setSelected(false);
    }
}//GEN-LAST:event_btt_pesqPredioActionPerformed

private void btt_pesqCameraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btt_pesqCameraActionPerformed
    if (VerificaAutorizacao.pesquisar_camera) {
        informarProgresso(MensagensSoltas.principal_status_pesquisarCamera());
        Pesquisa pesquisa = new Pesquisa();
        JPanel panel = manipulaItemMenu(btt_pesqCamera, pesquisa);
        if (panel != null) {
            executarSomAbrirJanela();
            pesquisarCamera(pesquisa);
        }
        limparProgresso();
    } else {
        VerificaAutorizacao.acessoNegado();
        btt_pesqCamera.setSelected(false);
    }
}//GEN-LAST:event_btt_pesqCameraActionPerformed

private void btt_pesqModuloAcionamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btt_pesqModuloAcionamentoActionPerformed
    if (VerificaAutorizacao.pesquisar_moduloAcionamento) {
        informarProgresso(MensagensSoltas.principal_status_pesquisarModuloAcionamento());
        Pesquisa pesquisa = new Pesquisa();
        JPanel panel = manipulaItemMenu(btt_pesqModuloAcionamento, pesquisa);
        if (panel != null) {
            executarSomAbrirJanela();
            pesquisarModuloAcionamento(pesquisa);
        }
        limparProgresso();
    } else {
        VerificaAutorizacao.acessoNegado();
        btt_pesqModuloAcionamento.setSelected(false);
    }
}//GEN-LAST:event_btt_pesqModuloAcionamentoActionPerformed

private void btt_pesqDispositivoEletricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btt_pesqDispositivoEletricoActionPerformed
    if (VerificaAutorizacao.pesquisar_dispositivoEletrico) {
        informarProgresso(MensagensSoltas.principal_status_pesquisarDispositivoEletrico());
        Pesquisa pesquisa = new Pesquisa();
        JPanel panel = manipulaItemMenu(btt_pesqDispositivoEletrico, pesquisa);
        if (panel != null) {
            executarSomAbrirJanela();
            pesquisarDispositivoEletrico(pesquisa);
        }
        limparProgresso();
    } else {
        VerificaAutorizacao.acessoNegado();
        btt_pesqDispositivoEletrico.setSelected(false);
    }
}//GEN-LAST:event_btt_pesqDispositivoEletricoActionPerformed

private void btt_pesqMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btt_pesqMarcaActionPerformed
    if (VerificaAutorizacao.pesquisar_marca) {
        informarProgresso(MensagensSoltas.principal_status_pesquisarMarcas());
        Pesquisa pesquisa = new Pesquisa();
        JPanel panel = manipulaItemMenu(btt_pesqMarca, pesquisa);
        if (panel != null) {
            executarSomAbrirJanela();
            pesquisarMarca(pesquisa);
        }
        limparProgresso();
    } else {
        VerificaAutorizacao.acessoNegado();
        btt_pesqMarca.setSelected(false);
    }
}//GEN-LAST:event_btt_pesqMarcaActionPerformed

private void btt_logAcoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btt_logAcoesActionPerformed
    if (VerificaAutorizacao.geral_logAcoes) {
        informarProgresso(MensagensSoltas.principal_status_logAcoes());
        JPanel panel = manipulaItemMenu(btt_logAcoes, new GeralLogAcoes());
        if (panel != null) {
            executarSomAbrirJanela();
        }
        limparProgresso();
    } else {
        VerificaAutorizacao.acessoNegado();
        btt_mensagens.setSelected(false);
    }
}//GEN-LAST:event_btt_logAcoesActionPerformed

private void lb_camerasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_camerasMouseClicked
    verificarCameras();
    mn_cameras.show(evt.getComponent(), evt.getX(), evt.getY());
}//GEN-LAST:event_lb_camerasMouseClicked

private void lb_movimentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_movimentoMouseClicked
    verificarMovimentos();
    mn_movimento.show(evt.getComponent(), evt.getX(), evt.getY());
}//GEN-LAST:event_lb_movimentoMouseClicked

private void lb_pessoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_pessoaMouseClicked
    verificarPessoas();
    mn_pessoas.show(evt.getComponent(), evt.getX(), evt.getY());
}//GEN-LAST:event_lb_pessoaMouseClicked

private void lb_dispositivosEletricosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_dispositivosEletricosMouseClicked
    verificarDispositivos();
    mn_dispositivos.show(evt.getComponent(), evt.getX(), evt.getY());
}//GEN-LAST:event_lb_dispositivosEletricosMouseClicked

private void lb_agendarTarefasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_agendarTarefasMouseClicked
    verificarAgendamentoTarefas();
    mn_agendarTarefas.show(evt.getComponent(), evt.getX(), evt.getY());
}//GEN-LAST:event_lb_agendarTarefasMouseClicked

private void lb_mensagensMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_mensagensMouseClicked
    verificarMensagens();
    mn_mensagens.show(evt.getComponent(), evt.getX(), evt.getY());
}//GEN-LAST:event_lb_mensagensMouseClicked

private void mi_detectarFacesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_detectarFacesActionPerformed
    if (mi_detectarFaces.isSelected()) {
        ConfigDispositivos.setDetectarFace(true);
    } else {
        ConfigDispositivos.setDetectarFace(false);
    }
}//GEN-LAST:event_mi_detectarFacesActionPerformed

private void mi_detectarOlhosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_detectarOlhosActionPerformed
    if (mi_detectarOlhos.isSelected()) {
        ConfigDispositivos.setDetectarOlhos(true);
    } else {
        ConfigDispositivos.setDetectarOlhos(false);
    }
}//GEN-LAST:event_mi_detectarOlhosActionPerformed

private void mi_detectarCorpoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_detectarCorpoActionPerformed
    if (mi_detectarCorpo.isSelected()) {
        ConfigDispositivos.setDetectarCorpo(true);
    } else {
        ConfigDispositivos.setDetectarCorpo(false);
    }
}//GEN-LAST:event_mi_detectarCorpoActionPerformed

private void mi_iniciarPararTodasCamerasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_iniciarPararTodasCamerasActionPerformed
    if (verificarInicioCameras()) {
        if (InstanciasControle.getMensagens().confirmacao(MensagensSoltas.principalPararCameras())) {
            InstanciasControle.getIniciarCameras().pararCaptura();
            AtualizaTelas.geralVisualizarCameras();
            verificarCameras();
        }
    }
}//GEN-LAST:event_mi_iniciarPararTodasCamerasActionPerformed

private void mi_pausarCameraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_pausarCameraActionPerformed
    if (InstanciasControle.getIniciarCameras().getStatus()) {
        if (InstanciasControle.getIniciarCameras().getPausa()) {
            InstanciasControle.getIniciarCameras().pausarCameras(false);
        } else {
            InstanciasControle.getIniciarCameras().pausarCameras(true);
        }
    } else {
        InstanciasControle.getMensagens().aviso(MensagensSoltas.principalCamerasNaoIniciadas());
    }
}//GEN-LAST:event_mi_pausarCameraActionPerformed

private void mi_desativarEnvioMensagensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_desativarEnvioMensagensActionPerformed
    if (ConfigMensagens.getAtivarEnvioMensagens()) {
        ConfigMensagens.setAtivarEnvioMensagens(false);
    } else {
        ConfigMensagens.setAtivarEnvioMensagens(true);
    }
}//GEN-LAST:event_mi_desativarEnvioMensagensActionPerformed

private void btt_ferramentasVideosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btt_ferramentasVideosActionPerformed
    if (VerificaAutorizacao.ferramentas_reprodutorVideos) {
        informarProgresso(MensagensSoltas.principal_status_reprodutorVideos());
        FerramentasReprodVideos reprodutorVideos = new FerramentasReprodVideos();
        JPanel panel = manipulaItemMenu(btt_ferramentasVideos, reprodutorVideos);
        if (panel != null) {
            executarSomAbrirJanela();
            editarVideos(reprodutorVideos);
        }
        limparProgresso();
    } else {
        VerificaAutorizacao.acessoNegado();
        btt_ferramentasEditarImagens.setSelected(false);
    }
}//GEN-LAST:event_btt_ferramentasVideosActionPerformed

private void mi_detectarObjetosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_detectarObjetosActionPerformed
    if (ConfigDispositivos.getDetectarObjeto()) {
        ConfigDispositivos.setDetectarObjeto(false);
    } else {
        ConfigDispositivos.setDetectarObjeto(true);
    }
}//GEN-LAST:event_mi_detectarObjetosActionPerformed

private void btt_cadAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btt_cadAreaActionPerformed
    if (VerificaAutorizacao.cadastro_area) {
        informarProgresso(MensagensSoltas.principal_status_cadastrarAreas());
        Cadastro cadastro = new Cadastro();
        JPanel panel = manipulaItemMenu(btt_cadArea, cadastro);
        if (panel != null) {
            executarSomAbrirJanela();
            cadastrarArea(cadastro);
        }
        limparProgresso();
    } else {
        VerificaAutorizacao.acessoNegado();
        btt_cadArea.setSelected(false);
    }
}//GEN-LAST:event_btt_cadAreaActionPerformed

private void btt_pesqAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btt_pesqAreaActionPerformed
    if (VerificaAutorizacao.pesquisar_area) {
        informarProgresso(MensagensSoltas.principal_status_pesquisarAreas());
        Pesquisa pesquisa = new Pesquisa();
        JPanel panel = manipulaItemMenu(btt_pesqArea, pesquisa);
        if (panel != null) {
            executarSomAbrirJanela();
            pesquisarArea(pesquisa);
        }
        limparProgresso();
    } else {
        VerificaAutorizacao.acessoNegado();
        btt_pesqArea.setSelected(false);
    }
}//GEN-LAST:event_btt_pesqAreaActionPerformed

    private void lb_redeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_redeMouseClicked
        vericarRede();
        mn_rede.show(evt.getComponent(), evt.getX(), evt.getY());
    }//GEN-LAST:event_lb_redeMouseClicked

    private void mi_conectarDesconectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_conectarDesconectarActionPerformed
        if (mi_conectarDesconectar.getText().equals("Conectar")) {
            iniciaServidor();
        } else {
            InstanciasPortatil.getServidor().fechaConexao();
        }
    }//GEN-LAST:event_mi_conectarDesconectarActionPerformed

    private void mi_usuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_usuariosActionPerformed
        if (InstanciasPortatil.getServidor() != null) {
            TelaClientesConectados dialog = new TelaClientesConectados(this, false);
            dialog.setVisible(true);
        } else {
            InstanciasControle.getMensagens().aviso(MensagensSoltas.principalServidorDesconectado());
        }
    }//GEN-LAST:event_mi_usuariosActionPerformed

    private void mi_pararAgendarTarefasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_pararAgendarTarefasActionPerformed
        switch (mi_pararAgendarTarefas.getText()) {
            case "Iniciar Agendamento de Tarefas":
                ConfigGerais.setAtivarAgendarTarefas(true);
                InstanciasControle.getShedulerAgendarTarefas().iniciar();
                break;
            case "Parar Agendamento de Tarefas":
                ConfigGerais.setAtivarAgendarTarefas(false);
                InstanciasControle.getShedulerAgendarTarefas().parar();
                break;
        }
    }//GEN-LAST:event_mi_pararAgendarTarefasActionPerformed

    private void mi_desativarAcionamentoDispositivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_desativarAcionamentoDispositivosActionPerformed
        ModuloAcionamentoConectar dialog = new ModuloAcionamentoConectar(this, true);
        dialog.setVisible(true);
    }//GEN-LAST:event_mi_desativarAcionamentoDispositivosActionPerformed

    private void mi_aplicacaoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_aplicacaoClienteActionPerformed
        if (InstanciasPortatil.getServidor() != null) {
            TelaPrincipal dialog = new TelaPrincipal();
            dialog.setVisible(true);
        } else {
            InstanciasControle.getMensagens().aviso(MensagensSoltas.principalServidorDesconectado());
        }
    }//GEN-LAST:event_mi_aplicacaoClienteActionPerformed

    private void lb_usuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_usuarioMouseClicked
        if (InstanciasControle.getMensagens().confirmacao(MensagensSoltas.principalTrocarUsuarios())) {
            InstanciasControle.setUsuarioLogado(null);
            VerificaAutorizacao.semPermissoes();
            if (InstanciasPortatil.getCliente() != null) {
                InstanciasPortatil.getCliente().fecharConexao();
            }
            Login login = new Login(this, true);
            login.setVisible(true);
        }
    }//GEN-LAST:event_lb_usuarioMouseClicked

    private void btt_relatAgendarTarefasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btt_relatAgendarTarefasActionPerformed
        if (VerificaAutorizacao.relatorio_agendarTarefas) {
            informarProgresso(MensagensSoltas.principal_status_relatorioAgendarTarefas());
            Relatorio relatorio = new Relatorio();
            JPanel panel = manipulaItemMenu(btt_relatAgendarTarefas, relatorio);
            if (panel != null) {
                executarSomAbrirJanela();
                relatorioAgendarTarefas(relatorio);
            }
            limparProgresso();
        } else {
            VerificaAutorizacao.acessoNegado();
            btt_agendarTarefas.setSelected(false);
        }
    }//GEN-LAST:event_btt_relatAgendarTarefasActionPerformed

    private void btt_relatLogAcoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btt_relatLogAcoesActionPerformed
        if (VerificaAutorizacao.relatorio_logAcoes) {
            informarProgresso(MensagensSoltas.principal_status_relatoriologAcoes());
            Relatorio relatorio = new Relatorio();
            JPanel panel = manipulaItemMenu(btt_relatLogAcoes, relatorio);
            if (panel != null) {
                executarSomAbrirJanela();
                relatorioLogAcoes(relatorio);
            }
            limparProgresso();
        } else {
            VerificaAutorizacao.acessoNegado();
            btt_logAcoes.setSelected(false);
        }
    }//GEN-LAST:event_btt_relatLogAcoesActionPerformed

    private void mi_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_emailActionPerformed
        if (mi_email.isSelected()) {
            ConfigMensagens.setAtivarEnvioEmail(true);
        } else {
            ConfigMensagens.setAtivarEnvioEmail(false);
        }
    }//GEN-LAST:event_mi_emailActionPerformed

    private void lb_movimentoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_movimentoMouseEntered
        lb_movimento.setOpaque(true);
        lb_movimento.setBackground(ConfigCores.azul());
    }//GEN-LAST:event_lb_movimentoMouseEntered

    private void lb_movimentoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_movimentoMouseExited
        lb_movimento.setOpaque(false);
        lb_movimento.setBackground(ConfigCores.branco());
    }//GEN-LAST:event_lb_movimentoMouseExited

    private void lb_pessoaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_pessoaMouseEntered
        lb_pessoa.setOpaque(true);
        lb_pessoa.setBackground(ConfigCores.verde());
    }//GEN-LAST:event_lb_pessoaMouseEntered

    private void lb_pessoaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_pessoaMouseExited
        lb_pessoa.setOpaque(false);
        lb_pessoa.setBackground(ConfigCores.branco());
    }//GEN-LAST:event_lb_pessoaMouseExited

    private void lb_camerasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_camerasMouseEntered
        lb_cameras.setOpaque(true);
        lb_cameras.setBackground(ConfigCores.azul());
    }//GEN-LAST:event_lb_camerasMouseEntered

    private void lb_camerasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_camerasMouseExited
        lb_cameras.setOpaque(false);
        lb_cameras.setBackground(ConfigCores.branco());
    }//GEN-LAST:event_lb_camerasMouseExited

    private void lb_dispositivosEletricosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_dispositivosEletricosMouseEntered
        lb_dispositivosEletricos.setOpaque(true);
        lb_dispositivosEletricos.setBackground(ConfigCores.verde());
    }//GEN-LAST:event_lb_dispositivosEletricosMouseEntered

    private void lb_dispositivosEletricosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_dispositivosEletricosMouseExited
        lb_dispositivosEletricos.setOpaque(false);
        lb_dispositivosEletricos.setBackground(ConfigCores.branco());
    }//GEN-LAST:event_lb_dispositivosEletricosMouseExited

    private void lb_agendarTarefasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_agendarTarefasMouseEntered
        lb_agendarTarefas.setOpaque(true);
        lb_agendarTarefas.setBackground(ConfigCores.azul());
    }//GEN-LAST:event_lb_agendarTarefasMouseEntered

    private void lb_agendarTarefasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_agendarTarefasMouseExited
        lb_agendarTarefas.setOpaque(false);
        lb_agendarTarefas.setBackground(ConfigCores.branco());
    }//GEN-LAST:event_lb_agendarTarefasMouseExited

    private void lb_mensagensMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_mensagensMouseEntered
        lb_mensagens.setOpaque(true);
        lb_mensagens.setBackground(ConfigCores.verde());
    }//GEN-LAST:event_lb_mensagensMouseEntered

    private void lb_mensagensMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_mensagensMouseExited
        lb_mensagens.setOpaque(false);
        lb_mensagens.setBackground(ConfigCores.branco());
    }//GEN-LAST:event_lb_mensagensMouseExited

    private void lb_redeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_redeMouseEntered
        lb_rede.setOpaque(true);
        lb_rede.setBackground(ConfigCores.azul());
    }//GEN-LAST:event_lb_redeMouseEntered

    private void lb_redeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_redeMouseExited
        lb_rede.setOpaque(false);
        lb_rede.setBackground(ConfigCores.branco());
    }//GEN-LAST:event_lb_redeMouseExited

    private void lb_usuarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_usuarioMouseEntered
        lb_usuario.setOpaque(true);
        lb_usuario.setBackground(ConfigCores.azul());
    }//GEN-LAST:event_lb_usuarioMouseEntered

    private void lb_usuarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_usuarioMouseExited
        lb_usuario.setOpaque(false);
        lb_usuario.setBackground(ConfigCores.branco());
    }//GEN-LAST:event_lb_usuarioMouseExited

    private void mi_dispositivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_dispositivoActionPerformed
        if (mi_dispositivo.isSelected()) {
            ConfigDispositivos.setAtivarDispositivosCamera(true);
        } else {
            ConfigDispositivos.setAtivarDispositivosCamera(false);
        }
    }//GEN-LAST:event_mi_dispositivoActionPerformed

    private void mi_gravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_gravarActionPerformed
        if (mi_gravar.isSelected()) {
            ConfigDispositivos.setGravarVideo(true);
        } else {
            ConfigDispositivos.setGravarVideo(false);
        }
    }//GEN-LAST:event_mi_gravarActionPerformed

    private void mi_vincularAgendamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_vincularAgendamentoActionPerformed
        VincularAgendarTarefas dialog = new VincularAgendarTarefas(this, true);
        dialog.setVisible(true);
    }//GEN-LAST:event_mi_vincularAgendamentoActionPerformed

    private void btt_localizacaoGPSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btt_localizacaoGPSActionPerformed
        if (VerificaAutorizacao.geral_localizacaoGPS) {
            informarProgresso(MensagensSoltas.principal_status_localizacaoGps());
            GeralLocalizacaoGps mapaGps = new GeralLocalizacaoGps();
            JPanel panel = manipulaItemMenu(btt_localizacaoGPS, mapaGps);
            if (panel != null) {
                executarSomAbrirJanela();
            }
            limparProgresso();
        } else {
            VerificaAutorizacao.acessoNegado();
            btt_localizacaoGPS.setSelected(false);
        }
    }//GEN-LAST:event_btt_localizacaoGPSActionPerformed

    private void mi_reconhecerFaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_reconhecerFaceActionPerformed
        if (mi_reconhecerFace.isSelected()) {
            ConfigDispositivos.setReconhecerFaces(true);
        } else {
            ConfigDispositivos.setReconhecerFaces(false);
        }
    }//GEN-LAST:event_mi_reconhecerFaceActionPerformed

    private void lb_audioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_audioMouseClicked
        verificarAudio();
        mn_audio.show(evt.getComponent(), evt.getX(), evt.getY());
    }//GEN-LAST:event_lb_audioMouseClicked

    private void lb_audioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_audioMouseEntered
        lb_audio.setOpaque(true);
        lb_audio.setBackground(ConfigCores.verde());
    }//GEN-LAST:event_lb_audioMouseEntered

    private void lb_audioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_audioMouseExited
        lb_audio.setOpaque(false);
        lb_audio.setBackground(ConfigCores.branco());
    }//GEN-LAST:event_lb_audioMouseExited

    private void mi_ativarAudioCamerasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_ativarAudioCamerasActionPerformed
        if (mi_ativarAudioCameras.isSelected()) {
            ConfigGerais.setAtivarSomCamera(true);
        } else {
            ConfigGerais.setAtivarSomCamera(false);
        }
    }//GEN-LAST:event_mi_ativarAudioCamerasActionPerformed

    private void mi_ativarAudioSistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_ativarAudioSistemaActionPerformed
        if (mi_ativarAudioSistema.isSelected()) {
            ConfigGerais.setAtivarSomSistema(true);
        } else {
            ConfigGerais.setAtivarSomSistema(false);
        }
    }//GEN-LAST:event_mi_ativarAudioSistemaActionPerformed

    private void mi_detectarMovimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_detectarMovimentoActionPerformed
        if (ConfigDispositivos.getMovimento()) {
            ConfigDispositivos.setMovimento(false);
        } else {
            ConfigDispositivos.setMovimento(true);
        }
    }//GEN-LAST:event_mi_detectarMovimentoActionPerformed

    private void mi_alteracaoAmbienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_alteracaoAmbienteActionPerformed
        if (ConfigDispositivos.getAlteracaoAmbiente()) {
            ConfigDispositivos.setAlteracaoAmbiente(false);
        } else {
            ConfigDispositivos.setAlteracaoAmbiente(true);
        }
    }//GEN-LAST:event_mi_alteracaoAmbienteActionPerformed

    private void mi_iniciarPararCamerasIndividualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_iniciarPararCamerasIndividualActionPerformed
        if (ConfigGerais.getServico() == 1) {
            InstanciasControle.getIniciarCameras().prepararCamerasIndividuais();
            if (InstanciasTelas.getGeralVisualizarCameras() != null) {
                AtualizaTelas.geralVisualizarCameras();
            } else {
                InstanciasControle.getMensagens().sucesso(MensagensSoltas.principalCamerasPreparadas());
            }
        } else {
            InstanciasControle.getMensagens().aviso(MensagensSoltas.principalServico());
        }
    }//GEN-LAST:event_mi_iniciarPararCamerasIndividualActionPerformed

    private void mi_redeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_redeActionPerformed
        if (mi_rede.isSelected()) {
            ConfigMensagens.setAtivarEnvioRede(true);
            ConfigMensagens.setAtivarEnvioCelular(false);
        } else {
            ConfigMensagens.setAtivarEnvioRede(false);
            ConfigMensagens.setAtivarEnvioCelular(true);
        }
    }//GEN-LAST:event_mi_redeActionPerformed

    private void mi_celularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_celularActionPerformed
        if (mi_celular.isSelected()) {
            ConfigMensagens.setAtivarEnvioCelular(true);
            ConfigMensagens.setAtivarEnvioRede(false);
        } else {
            ConfigMensagens.setAtivarEnvioCelular(false);
            ConfigMensagens.setAtivarEnvioRede(true);
        }
    }//GEN-LAST:event_mi_celularActionPerformed

    private void mi_campanhiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_campanhiaActionPerformed
        if (mi_campanhia.isSelected()) {
            ConfigDispositivos.setCampanhia(true);
        } else {
            ConfigDispositivos.setCampanhia(false);
        }
    }//GEN-LAST:event_mi_campanhiaActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btt_agendarTarefas;
    private javax.swing.JToggleButton btt_ajuda;
    private javax.swing.JToggleButton btt_cadArea;
    private javax.swing.JToggleButton btt_cadCamera;
    private javax.swing.JToggleButton btt_cadDispositivoEletrico;
    private javax.swing.JToggleButton btt_cadMarca;
    private javax.swing.JToggleButton btt_cadModuloAcionamento;
    private javax.swing.JToggleButton btt_cadPessoas;
    private javax.swing.JToggleButton btt_cadPredio;
    private javax.swing.JToggleButton btt_cadUsuario;
    private javax.swing.JToggleButton btt_cadastros;
    private javax.swing.JToggleButton btt_configuracoes;
    private javax.swing.JToggleButton btt_ferramentasDesenharMapas;
    private javax.swing.JToggleButton btt_ferramentasEditarImagens;
    private javax.swing.JToggleButton btt_ferramentasOpcoes;
    private javax.swing.JToggleButton btt_ferramentasVideos;
    private javax.swing.JToggleButton btt_geral;
    private javax.swing.JToggleButton btt_localizacaoGPS;
    private javax.swing.JToggleButton btt_logAcoes;
    private javax.swing.JToggleButton btt_manual;
    private javax.swing.JToggleButton btt_mapaDispositivos;
    private javax.swing.JToggleButton btt_mensagens;
    private javax.swing.JToggleButton btt_montarCenario;
    private javax.swing.JToggleButton btt_pesqArea;
    private javax.swing.JToggleButton btt_pesqCamera;
    private javax.swing.JToggleButton btt_pesqDispositivoEletrico;
    private javax.swing.JToggleButton btt_pesqMarca;
    private javax.swing.JToggleButton btt_pesqModuloAcionamento;
    private javax.swing.JToggleButton btt_pesqPessoas;
    private javax.swing.JToggleButton btt_pesqPredio;
    private javax.swing.JToggleButton btt_pesqUsuario;
    private javax.swing.JToggleButton btt_pesquisa;
    private javax.swing.JToggleButton btt_relatAcionamento;
    private javax.swing.JToggleButton btt_relatAgendarTarefas;
    private javax.swing.JToggleButton btt_relatDispositivo;
    private javax.swing.JToggleButton btt_relatLogAcoes;
    private javax.swing.JToggleButton btt_relatMensagens;
    private javax.swing.JToggleButton btt_relatMovimentos;
    private javax.swing.JToggleButton btt_relatPessoas;
    private javax.swing.JToggleButton btt_relatPredio;
    private javax.swing.JToggleButton btt_relatorios;
    private javax.swing.JToggleButton btt_sobre;
    private javax.swing.JToggleButton btt_visualizarCameras;
    private org.netbeans.examples.lib.timerbean.Timer dataHora;
    private javax.swing.ButtonGroup grupoMensagens;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    private org.jdesktop.swingx.JXStatusBar jXStatusBar1;
    public javax.swing.JLabel lb_agendarTarefas;
    public javax.swing.JLabel lb_audio;
    public javax.swing.JLabel lb_cameras;
    private javax.swing.JLabel lb_dataHora;
    public javax.swing.JLabel lb_dispositivosEletricos;
    public javax.swing.JLabel lb_mensagens;
    public javax.swing.JLabel lb_movimento;
    public javax.swing.JLabel lb_pessoa;
    private javax.swing.JLabel lb_progresso;
    public javax.swing.JLabel lb_rede;
    public javax.swing.JLabel lb_usuario;
    private javax.swing.JLabel lb_usuarioLogado;
    private javax.swing.JCheckBoxMenuItem mi_alteracaoAmbiente;
    private javax.swing.JMenuItem mi_aplicacaoCliente;
    private javax.swing.JCheckBoxMenuItem mi_ativarAudioCameras;
    private javax.swing.JCheckBoxMenuItem mi_ativarAudioSistema;
    private javax.swing.JCheckBoxMenuItem mi_campanhia;
    private javax.swing.JRadioButtonMenuItem mi_celular;
    private javax.swing.JMenuItem mi_conectarDesconectar;
    private javax.swing.JMenuItem mi_desativarAcionamentoDispositivos;
    private javax.swing.JMenuItem mi_desativarEnvioMensagens;
    private javax.swing.JCheckBoxMenuItem mi_detectarCorpo;
    private javax.swing.JCheckBoxMenuItem mi_detectarFaces;
    private javax.swing.JCheckBoxMenuItem mi_detectarMovimento;
    private javax.swing.JCheckBoxMenuItem mi_detectarObjetos;
    private javax.swing.JCheckBoxMenuItem mi_detectarOlhos;
    private javax.swing.JCheckBoxMenuItem mi_dispositivo;
    private javax.swing.JCheckBoxMenuItem mi_email;
    private javax.swing.JCheckBoxMenuItem mi_gravar;
    private javax.swing.JMenuItem mi_iniciarPararCamerasIndividual;
    private javax.swing.JMenuItem mi_iniciarPararTodasCameras;
    private javax.swing.JMenuItem mi_pararAgendarTarefas;
    private javax.swing.JMenuItem mi_pausarCamera;
    private javax.swing.JCheckBoxMenuItem mi_reconhecerFace;
    private javax.swing.JRadioButtonMenuItem mi_rede;
    private javax.swing.JMenuItem mi_usuarios;
    private javax.swing.JMenuItem mi_vincularAgendamento;
    private javax.swing.JPopupMenu mn_agendarTarefas;
    private javax.swing.JPopupMenu mn_audio;
    private javax.swing.JPopupMenu mn_cameras;
    private javax.swing.JPopupMenu mn_dispositivos;
    private javax.swing.JPopupMenu mn_mensagens;
    private javax.swing.JPopupMenu mn_movimento;
    private javax.swing.JPopupMenu mn_pessoas;
    private javax.swing.JPopupMenu mn_rede;
    private javax.swing.JPanel pn_ajuda;
    private javax.swing.JPanel pn_cadastros;
    private javax.swing.JPanel pn_configuracoes;
    private javax.swing.JPanel pn_geral;
    private javax.swing.JPanel pn_menu;
    private javax.swing.JPanel pn_pesquisa;
    private javax.swing.JPanel pn_relatorios;
    public javax.swing.JTabbedPane tb_principal;
    // End of variables declaration//GEN-END:variables

    /*
     *    BARRA ESQUERDA
     */
    private Boolean verificarInicioCameras() {
        if (!InstanciasControle.getIniciarCameras().getStatus()) {
            if (ConfigGerais.getServico() == 1) {
                CarregarBarraProgresso progresso = new CarregarBarraProgresso(this, true, 0);
                progresso.setVisible(true);
                AtualizaTelas.geralVisualizarCameras();
                return false;
            } else {
                InstanciasControle.getMensagens().aviso(MensagensSoltas.principalServico());
                return false;
            }
        } else {
            return true;
        }
    }

    private void verificarMovimentos() {
        if (!InstanciasControle.getIniciarCameras().getServidoresCameras().isEmpty()
                && InstanciasControle.getIniciarCameras().getStatus()) {
            lb_movimento.setIcon(new ImageIcon(getClass().getResource(ArquivosImagens.principal_movAtivo())));
        } else {
            lb_movimento.setIcon(new ImageIcon(getClass().getResource(ArquivosImagens.principal_movInativo())));
        }
        if (ConfigDispositivos.getStatus()) {
            if (ConfigDispositivos.getDetectarObjeto()) {
                mi_detectarObjetos.setSelected(true);
            } else {
                mi_detectarObjetos.setSelected(false);
            }
            if (ConfigDispositivos.getMovimento()) {
                mi_detectarMovimento.setSelected(true);
            } else {
                mi_detectarMovimento.setSelected(false);
            }
            if (ConfigDispositivos.getAlteracaoAmbiente()) {
                mi_alteracaoAmbiente.setSelected(true);
            } else {
                mi_alteracaoAmbiente.setSelected(false);
            }
        }
    }

    private void verificarPessoas() {
        if (!InstanciasControle.getIniciarCameras().getServidoresCameras().isEmpty()
                && InstanciasControle.getIniciarCameras().getStatus()) {
            if (ConfigDispositivos.getDetectarFace() || ConfigDispositivos.getDetectarOlhos() || ConfigDispositivos.getDetectarCorpo()) {
                lb_pessoa.setIcon(new ImageIcon(getClass().getResource(ArquivosImagens.principal_pessoaAnimar())));
            } else {
                lb_pessoa.setIcon(new ImageIcon(getClass().getResource(ArquivosImagens.principal_pessoaInativa())));
            }
        } else {
            lb_pessoa.setIcon(new ImageIcon(getClass().getResource(ArquivosImagens.principal_pessoaInativa())));
        }
        if (ConfigDispositivos.getStatus()) {
            if (ConfigDispositivos.getDetectarFace()) {
                mi_detectarFaces.setSelected(true);
            } else {
                mi_detectarFaces.setSelected(false);
            }
            if (ConfigDispositivos.getDetectarOlhos()) {
                mi_detectarOlhos.setSelected(true);
            } else {
                mi_detectarOlhos.setSelected(false);
            }
            if (ConfigDispositivos.getDetectarCorpo()) {
                mi_detectarCorpo.setSelected(true);
            } else {
                mi_detectarCorpo.setSelected(false);
            }
            if (ConfigDispositivos.getReconhecerFaces()) {
                mi_reconhecerFace.setSelected(true);
            } else {
                mi_reconhecerFace.setSelected(false);
            }
        }
    }

    private void verificarAgendamentoTarefas() {
        if (ConfigGerais.getStatus() && ConfigGerais.getAtivarAgendarTarefas()) {
            mi_pararAgendarTarefas.setText("Parar Agendamento de Tarefas");
            lb_agendarTarefas.setIcon(new ImageIcon(getClass().getResource(ArquivosImagens.principal_agendarAtivo())));
        } else {
            mi_pararAgendarTarefas.setText("Iniciar Agendamento de Tarefas");
            lb_agendarTarefas.setIcon(new ImageIcon(getClass().getResource(ArquivosImagens.principal_agendarInativo())));
        }
    }

    private void verificarDispositivos() {
    }

    private void verificarCameras() {
        if (InstanciasControle.getIniciarCameras().getStatus()) {
            if (InstanciasControle.getIniciarCameras().getServidoresCameras().isEmpty()) {
                lb_cameras.setIcon(new ImageIcon(getClass().getResource(ArquivosImagens.principal_camerasDesligadas())));
                InstanciasControle.getMensagens().aviso(MensagensSoltas.principalEncontrarCameras());
            } else {
                lb_cameras.setIcon(new ImageIcon(getClass().getResource(ArquivosImagens.principal_camerasLigadas())));
            }
            if (!InstanciasControle.getIniciarCameras().getStatus()) {
                lb_cameras.setIcon(new ImageIcon(getClass().getResource(ArquivosImagens.principal_camerasDesligadas())));
                mi_iniciarPararTodasCameras.setText("Iniciar todas as câmeras");
                mi_iniciarPararCamerasIndividual.setEnabled(true);
            } else {
                mi_iniciarPararTodasCameras.setText("Parar todas as câmeras");
                mi_iniciarPararCamerasIndividual.setEnabled(false);
            }
            mi_pausarCamera.setEnabled(true);
            if (InstanciasControle.getIniciarCameras().getPausa()) {
                mi_pausarCamera.setText("Resumir");
            } else {
                mi_pausarCamera.setText("Pausar");
            }
        } else {
            lb_cameras.setIcon(new ImageIcon(getClass().getResource(ArquivosImagens.principal_camerasDesligadas())));
            mi_pausarCamera.setText("Pausar");
            mi_pausarCamera.setEnabled(false);
            if (InstanciasControle.getIniciarCameras().getServidoresCameras().isEmpty()) {
                mi_iniciarPararTodasCameras.setText("Iniciar todas as câmeras");
                mi_iniciarPararCamerasIndividual.setEnabled(true);
            } else {
                if (InstanciasControle.getIniciarCameras().getStatus()) {
                    mi_iniciarPararTodasCameras.setText("Parar todas as câmeras");
                } else {
                    mi_iniciarPararTodasCameras.setText("Iniciar todas as câmeras");
                }
                mi_iniciarPararCamerasIndividual.setEnabled(false);
            }
        }
        if (ConfigDispositivos.getStatus()) {
            if (ConfigDispositivos.getAtivarDispositivosCamera()) {
                mi_dispositivo.setSelected(true);
            } else {
                mi_dispositivo.setSelected(false);
            }
            if (ConfigDispositivos.getCampanhia()) {
                mi_campanhia.setSelected(true);
            } else {
                mi_campanhia.setSelected(false);
            }
            if (ConfigDispositivos.getGravarVideo()) {
                mi_gravar.setSelected(true);
            } else {
                mi_gravar.setSelected(false);
            }
        }
    }

    private void verificarMensagens() {
        if (ConfigMensagens.getStatus()) {
            if (ConfigMensagens.getAtivarEnvioMensagens()) {
                mi_desativarEnvioMensagens.setText("Desativar mensagens");
            } else {
                mi_desativarEnvioMensagens.setText("Ativar mensagens");
            }
            if (ConfigMensagens.getAtivarEnvioCelular()) {
                mi_celular.setSelected(true);
            }
            if (ConfigMensagens.getAtivarEnvioRede()) {
                mi_rede.setSelected(true);
            }
            if (ConfigMensagens.getAtivarEnvioEmail()) {
                mi_email.setSelected(true);
            } else {
                mi_email.setSelected(false);
            }
        }
    }

    private void vericarRede() {
        if (InstanciasPortatil.getServidor() != null && InstanciasPortatil.getServidor().getStatusConexao()) {
            lb_rede.setIcon(new ImageIcon(getClass().getResource(ArquivosImagens.principal_redeConectada())));
            mi_conectarDesconectar.setText("Desconectar");
        } else {
            lb_rede.setIcon(new ImageIcon(getClass().getResource(ArquivosImagens.principal_redeDesconectada())));
            mi_conectarDesconectar.setText("Conectar");
        }
    }

    private void verificarAudio() {
        if (ConfigGerais.getStatus()) {
            if (ConfigGerais.getAtivarSomCamera()) {
                mi_ativarAudioCameras.setSelected(true);
            } else {
                mi_ativarAudioCameras.setSelected(false);
            }
            if (ConfigGerais.getAtivarSomSistema()) {
                mi_ativarAudioSistema.setSelected(true);
            } else {
                mi_ativarAudioSistema.setSelected(false);
            }
            if (mi_ativarAudioCameras.isSelected() && mi_ativarAudioSistema.isSelected()) {
                lb_audio.setIcon(new ImageIcon(getClass().getResource(ArquivosImagens.principal_audioCompleto())));
            } else if (mi_ativarAudioCameras.isSelected() || mi_ativarAudioSistema.isSelected()) {
                lb_audio.setIcon(new ImageIcon(getClass().getResource(ArquivosImagens.principal_audioIncompleto())));
            } else if (!mi_ativarAudioCameras.isSelected() && !mi_ativarAudioSistema.isSelected()) {
                lb_audio.setIcon(new ImageIcon(getClass().getResource(ArquivosImagens.principal_semAudio())));
            }
        }
    }

    /*
     * Métodos Gerais
     */
    public void exibirUsuarioLogado() {
        if (InstanciasControle.getUsuarioLogado() != null) {
            lb_usuarioLogado.setText("Usuário: " + InstanciasControle.getUsuarioLogado().getPessoa().toString());
        }
    }

    private void verificarExistenciaArquivosConfiguracoes() {
        if (!ConfigGerais.getStatus()) {
            InstanciasControle.getMensagens().aviso(MensagensSoltas.principalConfigGerais());
        }
        if (!ConfigDispositivos.getStatus()) {
            InstanciasControle.getMensagens().aviso(MensagensSoltas.principalConfigDispositivos());
        }
        if (!ConfigMensagens.getStatus()) {
            InstanciasControle.getMensagens().aviso(MensagensSoltas.principalConfigMensagens());
        }
    }

    private void executarSomAbrirJanela() {
        InstanciasControle.getGerenciarAudio().exeAbrirJanela();
    }

    private void manipularMenu(JToggleButton tb, JPanel panel) {
        if (tb.isSelected()) {
            panel.setVisible(true);
        } else {
            panel.setVisible(false);
            fecharConjuntoTabbedPane(panel, tb_principal);
        }
    }

    private JPanel manipulaItemMenu(JToggleButton tb, JPanel painel) {
        if (tb.isSelected()) {
            return SwingUtil.adicionarTabComBotaoFechar(tb_principal, tb.getName(), painel);
        } else {
            SwingUtil.fechaTabbedPanePeloTitulo(tb_principal, tb.getName());
        }
        return null;
    }

    private void ajeitarMenu() {
        pn_geral.setVisible(false);
        pn_cadastros.setVisible(false);
        pn_pesquisa.setVisible(false);
        pn_configuracoes.setVisible(false);
        pn_relatorios.setVisible(false);
        pn_ajuda.setVisible(false);
    }

    private void fecharConjuntoTabbedPane(JPanel panel, JTabbedPane tabbedPane) {
        Component[] components = panel.getComponents();
        for (int j = 0; j < components.length; j++) {
            JToggleButton toggleButton;
            if (components[j] instanceof JToggleButton) {
                toggleButton = (JToggleButton) components[j];
                for (int i = 0; i < tabbedPane.getTabCount(); i++) {
                    String t = tabbedPane.getTitleAt(i);
                    if (toggleButton.getName().equals(t)) {
                        toggleButton.setSelected(false);
                        tabbedPane.remove(i);
                    }
                }
            }
        }
    }

    private void tiraSelecaoToggleButtonPorName(String name) {
        Component[] components1 = pn_menu.getComponents();
        for (int i = 0; i < components1.length; i++) {
            if (components1[i] instanceof JPanel) {
                JPanel painel = (JPanel) components1[i];
                Component[] components2 = painel.getComponents();
                for (int j = 0; j < components2.length; j++) {
                    if (components2[j] instanceof JToggleButton) {
                        JToggleButton toggleButton = (JToggleButton) components2[j];
                        if (toggleButton.getName().equals(name)) {
                            toggleButton.setSelected(false);
                        }
                    }
                }
            }
        }
    }

    public void redimencionarPainelCadastro(JPanel painel, Cadastro cadastro) {
        Integer x = Math.round(Float.parseFloat((cadastro.pn_principal.getSize().getWidth() - 1) + ""));
        Integer y = Math.round(Float.parseFloat((cadastro.pn_principal.getSize().getHeight() - 1) + ""));
        painel.setSize(x, y);
    }

    public void redimencionarPainelPesquisa(JPanel painel, Pesquisa pesquisa) {
        Integer x = Math.round(Float.parseFloat((pesquisa.pn_principal.getSize().getWidth() - 1) + ""));
        Integer y = Math.round(Float.parseFloat((pesquisa.pn_principal.getSize().getHeight() - 1) + ""));
        painel.setSize(x, y);
    }

    public void redimencionarPainelRelatorio(JPanel painel, Relatorio relatorio) {
        Integer x = Math.round(Float.parseFloat((relatorio.pn_principal.getSize().getWidth() - 1) + ""));
        Integer y = Math.round(Float.parseFloat((relatorio.pn_principal.getSize().getHeight() - 1) + ""));
        painel.setSize(x, y);
    }

    public void redimencionarPainelConfiguracao(JPanel painel, Configuracao configuracao) {
        Integer x = Math.round(Float.parseFloat((configuracao.pn_principal.getSize().getWidth() - 1) + ""));
        Integer y = Math.round(Float.parseFloat((configuracao.pn_principal.getSize().getHeight() - 1) + ""));
        painel.setSize(x, y);
    }

    public void esperarTelas() {
        esperar = new EsperarCirculo(this, true, 1);
        esperar.setVisible(true);
    }

    public void informarProgresso(String texto) {
        lb_progresso.setText(texto);
    }

    public void limparProgresso() {
        lb_progresso.setText("");
    }

    private void fecharTela() {
        if (InstanciasControle.getMensagens().confirmacao(MensagensSoltas.principalFecharSistema())) {
            verificaServidor();
            verificarAcesso();
            verificarMensagensLocais();
            ArquivoBloqueio.fecharSistema();
            pararCameras();
            verificaBackup();
            desativarAcionamento();
            System.exit(0);
        }
    }

    private void verificaServidor() {
        if (InstanciasPortatil.getServidor() != null) {
            InstanciasPortatil.getServidor().fechaConexao();
        }
    }

    private void verificarAcesso() {
        AcessoBean acesso = InstanciasControle.getAcesso();
        if (acesso != null) {
            acesso.setDataHoraFim(Calendar.getInstance());
        }
        alterarAcesso(acesso);
    }

    private void verificarMensagensLocais() {
        for (MensagemBean mensagem : listarMensagensLocais()) {
            if (InstanciasControle.getUsuarioLogado().getPessoa().getCodigo() == mensagem.getDestino().getCodigo()) {
                if (mensagem.getExibir() == EnumExibirMensagem.SAIR_SISTEMA && mensagem.getLeitura() == EnumLeituraMensagem.NAO) {
                    VerMensagensLocais dialog = new VerMensagensLocais(null, true, mensagem);
                    dialog.setVisible(true);
                }
            }
        }
    }

    private void pararCameras() {
        if (InstanciasControle.getIniciarCameras() != null && InstanciasControle.getIniciarCameras().getStatus()) {
            InstanciasControle.getIniciarCameras().pararCaptura();
        }
    }

    private void verificaBackup() {
        Backup.executaBackUp();
    }

    /*
     * Geral
     */
    private void visualizarCameras(GeralVisualizarCameras geralVisualizarCameras) {
        geralVisualizarCameras.iniciarVisualizacao();
    }

    private void mapaDispositivos(GeralMapaDispositivos geralMapaDispositivos) {
        esperarTelas();
        geralMapaDispositivos.carregaMapaDispositivos();
    }

    private void geralCenario(GeralCenario geralCenario) {
        esperarTelas();
        geralCenario.carregarCenarios();
    }

    /*
     * Cadastros
     */
    private void cadastrarPessoa(Cadastro cadastro) {
        esperarTelas();
        CadastrarPessoa pessoa = new CadastrarPessoa();
        redimencionarPainelCadastro(pessoa, cadastro);
        cadastro.pn_principal.add(pessoa);
        cadastro.verificaInstancias(pessoa);
    }

    private void cadastrarUsuario(Cadastro cadastro) {
        esperarTelas();
        CadastrarUsuario usuario = new CadastrarUsuario();
        redimencionarPainelCadastro(usuario, cadastro);
        cadastro.pn_principal.add(usuario);
        cadastro.verificaInstancias(usuario);
    }

    private void cadastrarPredio(Cadastro cadastro) {
        esperarTelas();
        CadastrarPredio predio = new CadastrarPredio();
        redimencionarPainelCadastro(predio, cadastro);
        cadastro.pn_principal.add(predio);
        cadastro.verificaInstancias(predio);
    }

    private void cadastrarArea(Cadastro cadastro) {
        esperarTelas();
        CadastrarArea area = new CadastrarArea();
        redimencionarPainelCadastro(area, cadastro);
        cadastro.pn_principal.add(area);
        cadastro.verificaInstancias(area);
    }

    private void cadastrarMarca(Cadastro cadastro) {
        esperarTelas();
        CadastrarMarca marca = new CadastrarMarca();
        redimencionarPainelCadastro(marca, cadastro);
        cadastro.pn_principal.add(marca);
        cadastro.verificaInstancias(marca);
    }

    private void cadastrarCamera(Cadastro cadastro) {
        esperarTelas();
        CadastrarCamera camera = new CadastrarCamera();
        redimencionarPainelCadastro(camera, cadastro);
        cadastro.pn_principal.add(camera);
        cadastro.verificaInstancias(camera);
    }

    private void cadastrarModuloAcionamento(Cadastro cadastro) {
        esperarTelas();
        CadastrarModuloAcionamento moduloAcionamento = new CadastrarModuloAcionamento();
        redimencionarPainelCadastro(moduloAcionamento, cadastro);
        cadastro.pn_principal.add(moduloAcionamento);
        cadastro.verificaInstancias(moduloAcionamento);
    }

    private void cadastrarDispositivoEletrico(Cadastro cadastro) {
        esperarTelas();
        CadastrarDispositivoEletrico dispositivoEletrico = new CadastrarDispositivoEletrico();
        redimencionarPainelCadastro(dispositivoEletrico, cadastro);
        cadastro.pn_principal.add(dispositivoEletrico);
        cadastro.verificaInstancias(dispositivoEletrico);
    }

    /*
     * Pesquisas
     */
    private void pesquisarPessoa(Pesquisa pesquisa) {
        esperarTelas();
        PesquisarPessoa pessoa = new PesquisarPessoa();
        redimencionarPainelPesquisa(pessoa, pesquisa);
        pesquisa.pn_principal.add(pessoa);
        pesquisa.verificaInstancias(pessoa);
    }

    private void pesquisarUsuario(Pesquisa pesquisa) {
        esperarTelas();
        PesquisarUsuario usuario = new PesquisarUsuario();
        redimencionarPainelPesquisa(usuario, pesquisa);
        pesquisa.pn_principal.add(usuario);
        pesquisa.verificaInstancias(usuario);
    }

    private void pesquisarPredio(Pesquisa pesquisa) {
        esperarTelas();
        PesquisarPredio predio = new PesquisarPredio();
        redimencionarPainelPesquisa(predio, pesquisa);
        pesquisa.pn_principal.add(predio);
        pesquisa.verificaInstancias(predio);
    }

    private void pesquisarArea(Pesquisa pesquisa) {
        esperarTelas();
        PesquisarArea area = new PesquisarArea();
        redimencionarPainelPesquisa(area, pesquisa);
        pesquisa.pn_principal.add(area);
        pesquisa.verificaInstancias(area);
    }

    private void pesquisarMarca(Pesquisa pesquisa) {
        esperarTelas();
        PesquisarMarca marca = new PesquisarMarca();
        redimencionarPainelPesquisa(marca, pesquisa);
        pesquisa.pn_principal.add(marca);
        pesquisa.verificaInstancias(marca);
    }

    private void pesquisarCamera(Pesquisa pesquisa) {
        esperarTelas();
        PesquisarCamera camera = new PesquisarCamera();
        redimencionarPainelPesquisa(camera, pesquisa);
        pesquisa.pn_principal.add(camera);
        pesquisa.verificaInstancias(camera);
    }

    private void pesquisarModuloAcionamento(Pesquisa pesquisa) {
        esperarTelas();
        PesquisarModuloAcionamento moduloAcionamento = new PesquisarModuloAcionamento();
        redimencionarPainelPesquisa(moduloAcionamento, pesquisa);
        pesquisa.pn_principal.add(moduloAcionamento);
        pesquisa.verificaInstancias(moduloAcionamento);
    }

    private void pesquisarDispositivoEletrico(Pesquisa pesquisa) {
        esperarTelas();
        PesquisarDispositivoEletrico dispositivoEletrico = new PesquisarDispositivoEletrico();
        redimencionarPainelPesquisa(dispositivoEletrico, pesquisa);
        pesquisa.pn_principal.add(dispositivoEletrico);
        pesquisa.verificaInstancias(dispositivoEletrico);
    }

    /*
     * Relatorios Movimentos
     */
    private void relatorioDispositivos(Relatorio relatorio) {
        esperarTelas();
        RelatorioDispositivos relatorioDispositivos = new RelatorioDispositivos();
        redimencionarPainelRelatorio(relatorioDispositivos, relatorio);
        relatorio.pn_principal.add(relatorioDispositivos);
        relatorio.verificaInstancias(relatorioDispositivos);
    }

    private void relatorioMensagens(Relatorio relatorio) {
        esperarTelas();
        RelatorioMensagens relatorioMensagens = new RelatorioMensagens();
        redimencionarPainelRelatorio(relatorioMensagens, relatorio);
        relatorio.pn_principal.add(relatorioMensagens);
        relatorio.verificaInstancias(relatorioMensagens);
    }

    private void relatorioMovimento(Relatorio relatorio) {
        esperarTelas();
        RelatorioMovimento relatorioMovimento = new RelatorioMovimento();
        redimencionarPainelRelatorio(relatorioMovimento, relatorio);
        relatorio.pn_principal.add(relatorioMovimento);
        relatorio.verificaInstancias(relatorioMovimento);
    }

    private void relatorioPessoas(Relatorio relatorio) {
        esperarTelas();
        RelatorioPessoas relatorioPessoas = new RelatorioPessoas();
        redimencionarPainelRelatorio(relatorioPessoas, relatorio);
        relatorio.pn_principal.add(relatorioPessoas);
        relatorio.verificaInstancias(relatorioPessoas);
    }

    private void relatorioPredio(Relatorio relatorio) {
        esperarTelas();
        RelatorioPredio relatorioPredio = new RelatorioPredio();
        redimencionarPainelRelatorio(relatorioPredio, relatorio);
        relatorio.pn_principal.add(relatorioPredio);
        relatorio.verificaInstancias(relatorioPredio);
    }

    private void relatorioAcionamento(Relatorio relatorio) {
        esperarTelas();
        RelatorioAcionamento relatorioAcionamento = new RelatorioAcionamento();
        redimencionarPainelRelatorio(relatorioAcionamento, relatorio);
        relatorio.pn_principal.add(relatorioAcionamento);
        relatorio.verificaInstancias(relatorioAcionamento);
    }

    private void relatorioAgendarTarefas(Relatorio relatorio) {
        esperarTelas();
        RelatorioAgendarTarefas agendarTarefas = new RelatorioAgendarTarefas();
        redimencionarPainelRelatorio(agendarTarefas, relatorio);
        relatorio.pn_principal.add(agendarTarefas);
        relatorio.verificaInstancias(agendarTarefas);
    }

    private void relatorioLogAcoes(Relatorio relatorio) {
        esperarTelas();
        RelatorioLogAcoes logAcoes = new RelatorioLogAcoes();
        redimencionarPainelRelatorio(logAcoes, relatorio);
        relatorio.pn_principal.add(logAcoes);
        relatorio.verificaInstancias(logAcoes);
    }

    /*
     * Ferramentas
     */
    private void editarImagens(FerramentasEditarImagens editarImagens) {
        if (InstanciasControle.getIniciarCameras() != null) {
            if (InstanciasControle.getIniciarCameras().getStatus()) {
                lb_movimento.setIcon(new ImageIcon(getClass().getResource(ArquivosImagens.principal_movAtivo())));
                lb_pessoa.setIcon(new ImageIcon(getClass().getResource(ArquivosImagens.principal_pessoaAnimar())));
            } else {
                lb_movimento.setIcon(new ImageIcon(getClass().getResource(ArquivosImagens.principal_movInativo())));
                lb_pessoa.setIcon(new ImageIcon(getClass().getResource(ArquivosImagens.principal_pessoaInativa())));
            }
        }
    }

    private void editarVideos(FerramentasReprodVideos reprodutorVideos) {
    }

    private void ferramentasOpcoes(Configuracao configuracao) {
        esperarTelas();
        FerramentasOpcoes opcoes = new FerramentasOpcoes();
        redimencionarPainelConfiguracao(opcoes, configuracao);
        configuracao.pn_principal.add(opcoes);
        configuracao.verificaInstancias(opcoes);
    }

    /*
     * Ajuda
     */
    private void manual(JPanel painel) {
    }

    private void sobre() {
        if (btt_sobre.isSelected()) {
            Sobre sobre = new Sobre(this, true);
            sobre.setVisible(true);
        }
    }

    /*
     * Outros
     */
    private void ativarAcionamento() {
        if (ConfigDispositivos.getStatus() && ConfigDispositivos.getAtivarAcionamento()) {
            ArrayList<GerenciarAcionamento> lista = new ArrayList<>();
            for (ModuloAcionamentoBean bean : listarModulosAcionamentoNaoDeletado()) {
                if (bean.getStatus() == EnumStatusDispositivo.ATIVO) {
                    GerenciarAcionamento gerenciarAcionamento = new GerenciarAcionamento(bean);
                    if (gerenciarAcionamento.isConnected()) {
                        lista.add(gerenciarAcionamento);
                    }
                }
            }
            InstanciasControle.setGerenciarAcionamentos(lista);
        }
    }

    private void desativarAcionamento() {
        if (InstanciasControle.getGerenciarAcionamentos() != null) {
            for (GerenciarAcionamento gerenciarAcionamento : InstanciasControle.getGerenciarAcionamentos()) {
                gerenciarAcionamento.getGerente().disconnect();
            }
            InstanciasControle.setGerenciarAcionamentos(null);
        }
    }

    public void iniciaServidor() {
        if (InstanciasControle.getUsuarioLogado() != null) {
            if (InstanciasPortatil.getServidor() == null) {
                Servidor servidor = new Servidor();
                Thread thread = new Thread(servidor);
                thread.start();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                }
            }
            if (InstanciasPortatil.getCliente() == null) {
                Cliente cliente = new Cliente("localhost",
                        InstanciasControle.getUsuarioLogado().getLogin(),
                        InstanciasControle.getUsuarioLogado().getSenha());
                Thread thread2 = new Thread(cliente);
                thread2.start();
                InstanciasPortatil.setCliente(cliente);
                InstanciasPortatil.setMensagens(InstanciasControle.getMensagens());
            }
        }
    }

    /*
     * BANCO DE DADOS
     */
    private void alterarAcesso(AcessoBean acesso) {
        AcessoFacade acessoFacade = FactoryFacade.getAcessoFacadeImpl();
        try {
            acessoFacade.alterar(acesso);
        } catch (FacadeException ex) {
        }
    }

    private ArrayList<MensagemBean> listarMensagensLocais() {
        MensagemFacade mensagemFacade = FactoryFacade.getMensagemImpl();
        try {
            return mensagemFacade.listarMensagensLocal();
        } catch (FacadeException ex) {
        }
        return null;
    }

    private ArrayList<ModuloAcionamentoBean> listarModulosAcionamentoNaoDeletado() {
        ModuloAcionamentoFacade moduloAcionamentoFacade = FactoryFacade.getModuloAcionamentoImpl();
        try {
            return moduloAcionamentoFacade.listarModuloAcionamentoNaoDeletado();
        } catch (FacadeException ex) {
        }
        return null;
    }

}
