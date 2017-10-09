package telas.cadastros;

import recursos.configuracoes.diretorios.caminhos.ArquivosHTML;
import entidades.camera.bean.CameraBean;
import entidades.camera.facade.CameraFacade;
import entidades.dispositivo.bean.EnumDeletadoDispositivo;
import entidades.dispositivo.bean.EnumStatusDispositivo;
import entidades.dispositivoEletrico.bean.DispositivoEletricoBean;
import entidades.dispositivoEletrico.facade.DispositivoEletricoFacade;
import entidades.marca.bean.MarcaBean;
import entidades.marca.facade.MarcaFacade;
import entidades.moduloAcionamento.bean.ModuloAcionamentoBean;
import entidades.moduloAcionamento.facade.ModuloAcionamentoFacade;
import java.util.ArrayList;
import recursos.instancias.InstanciasControle;
import recursos.instancias.InstanciasTelas;
import recursos.internacionalizacao.MensagensSoltas;
import recursos.internacionalizacao.MensagensTelas;
import telas.principal.AtualizaTelas;
import telas.principal.Manual;
import util.FacadeException;
import util.FactoryFacade;
import util.SwingUtil;
import util.Validacao;

/**
 *
 * @author Wesllen Sousa Lima,Hendrio Luis
 */
public class CadastrarModuloAcionamento extends javax.swing.JPanel {

    public CadastrarModuloAcionamento() {
        initComponents();
        nomeiaTela();
        InstanciasTelas.setCadastrarModuloAcionamento(CadastrarModuloAcionamento.this);

        preencherComboMarca();
    }

    private void nomeiaTela() {
        lb_codigo.setText(MensagensTelas.cad_codigo());
        lb_nome.setText(MensagensTelas.cad_nome());
        lb_ip.setText(MensagensTelas.cad_ip());
        lb_porta.setText(MensagensTelas.cad_porta());
        lb_marca.setText(MensagensTelas.cad_marca());
        lb_qtdeSaidas.setText(MensagensTelas.cad_qtdeSaida());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        pn_campos = new javax.swing.JPanel();
        tf_nome = new javax.swing.JTextField();
        lb_nome = new javax.swing.JLabel();
        tf_identificacao = new javax.swing.JTextField();
        lb_ip = new javax.swing.JLabel();
        lb_marca = new javax.swing.JLabel();
        cb_marca = new javax.swing.JComboBox();
        lb_qtdeSaidas = new javax.swing.JLabel();
        tf_qtdeSaidas = new javax.swing.JTextField();
        lb_porta = new javax.swing.JLabel();
        tf_porta = new javax.swing.JTextField();
        lb_codigo = new javax.swing.JLabel();
        tf_codigo = new javax.swing.JTextField();

        tf_nome.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        lb_nome.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lb_nome.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_nome.setText("Nome:*");

        tf_identificacao.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        lb_ip.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lb_ip.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_ip.setText("Identificacao:*");

        lb_marca.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lb_marca.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_marca.setText("Marca:*");

        cb_marca.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cb_marca.setToolTipText("Selecione uma Marca");

        lb_qtdeSaidas.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lb_qtdeSaidas.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_qtdeSaidas.setText("Qtde Saídas:*");

        lb_porta.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lb_porta.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_porta.setText("Porta:*");

        lb_codigo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lb_codigo.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_codigo.setText("Codigo:*");

        tf_codigo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tf_codigo.setEnabled(false);

        javax.swing.GroupLayout pn_camposLayout = new javax.swing.GroupLayout(pn_campos);
        pn_campos.setLayout(pn_camposLayout);
        pn_camposLayout.setHorizontalGroup(
            pn_camposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_camposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_camposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_camposLayout.createSequentialGroup()
                        .addGroup(pn_camposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lb_qtdeSaidas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                            .addComponent(lb_marca, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_porta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(pn_camposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cb_marca, 0, 217, Short.MAX_VALUE)
                            .addComponent(tf_qtdeSaidas)
                            .addComponent(tf_porta, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(pn_camposLayout.createSequentialGroup()
                        .addGroup(pn_camposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lb_codigo, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                            .addComponent(lb_ip, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_nome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(pn_camposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_nome)
                            .addComponent(tf_codigo)
                            .addComponent(tf_identificacao))))
                .addContainerGap())
        );
        pn_camposLayout.setVerticalGroup(
            pn_camposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_camposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_camposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_codigo)
                    .addComponent(tf_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_camposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_nome)
                    .addComponent(tf_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_camposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_ip)
                    .addComponent(tf_identificacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_camposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_porta)
                    .addComponent(tf_porta, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_camposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_marca)
                    .addComponent(cb_marca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_camposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_qtdeSaidas)
                    .addComponent(tf_qtdeSaidas, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pn_campos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pn_campos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cb_marca;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_codigo;
    private javax.swing.JLabel lb_ip;
    private javax.swing.JLabel lb_marca;
    private javax.swing.JLabel lb_nome;
    private javax.swing.JLabel lb_porta;
    private javax.swing.JLabel lb_qtdeSaidas;
    private javax.swing.JPanel pn_campos;
    private javax.swing.JTextField tf_codigo;
    private javax.swing.JTextField tf_identificacao;
    private javax.swing.JTextField tf_nome;
    private javax.swing.JTextField tf_porta;
    private javax.swing.JTextField tf_qtdeSaidas;
    // End of variables declaration//GEN-END:variables

    private void preencherComboMarca() {
        cb_marca.removeAllItems();
        cb_marca.addItem(MensagensTelas.cad_selecionarMarca());
        for (MarcaBean marca : listaMarcas()) {
            cb_marca.addItem(marca);
        }
    }

    ///////////METODOS DE VERIFICAÇÃO//////////////////////////////////////////
    private Boolean verificaNomeExiste() {
        for (ModuloAcionamentoBean modulo : listaModuloAcionamentoOrdenadoPorCodigo()) {
            if (!tf_codigo.getText().equals(modulo.getCodigo().toString())) {
                if (tf_nome.getText().toUpperCase().equals(modulo.getNome())) {
                    return true;
                }
            }
        }
        return false;
    }

    private Boolean verificaNomeIgualCamera() {
        for (CameraBean camera : listaCameraOrdenadaPorCodigo()) {
            if (!tf_codigo.getText().equals(camera.getCodigo().toString())) {
                if (tf_nome.getText().toUpperCase().equals(camera.getNome())) {
                    return true;
                }
            }
        }
        return false;
    }

    private Boolean verificaNomeIgualDispositivoEletrico() {
        for (DispositivoEletricoBean dispositivo : listaDispositivoEletricoOrdenadoPorCodigo()) {
            if (!tf_codigo.getText().equals(dispositivo.getCodigo().toString())) {
                if (tf_nome.getText().toUpperCase().equals(dispositivo.getNome())) {
                    return true;
                }
            }
        }
        return false;
    }

    private Boolean verificaIPExiste() {
        for (ModuloAcionamentoBean modulo : listaModuloAcionamentoOrdenadoPorCodigo()) {
            if (!tf_codigo.getText().equals(modulo.getCodigo().toString())) {
                if (tf_identificacao.getText().equals(modulo.getIdentificacao())) {
                    return true;
                }
            }
        }
        return false;
    }
    ///////////FIM METODOS DE VERIFICAÇÃO//////////////////////////////////////////

    private Boolean validaCampos() {
        if (Validacao.verificaStringVazia(tf_nome.getText())) {
            tf_nome.requestFocus();
            InstanciasControle.getMensagens().aviso(MensagensSoltas.cadComumNomeVazio());
            return false;
        } else if (verificaNomeExiste()) {
            tf_nome.requestFocus();
            tf_nome.setText("");
            InstanciasControle.getMensagens().aviso(MensagensSoltas.cadComumNomeExiste());
            return false;
        } else if (verificaNomeIgualCamera()) {
            tf_nome.requestFocus();
            tf_nome.setText("");
            InstanciasControle.getMensagens().aviso(MensagensSoltas.cadComumNomeCamera());
            return false;
        } else if (verificaNomeIgualDispositivoEletrico()) {
            tf_nome.requestFocus();
            tf_nome.setText("");
            InstanciasControle.getMensagens().aviso(MensagensSoltas.cadComumNomeDispositivoEletrico());
            return false;
        } else if (Validacao.verificaStringVazia(tf_identificacao.getText())) {
            tf_identificacao.requestFocus();
            InstanciasControle.getMensagens().aviso(MensagensSoltas.cadModuloAcionamentoIpVazio());
            return false;
        } else if (verificaIPExiste()) {
            tf_identificacao.requestFocus();
            tf_identificacao.setText("");
            InstanciasControle.getMensagens().aviso(MensagensSoltas.cadModuloAcionamentoIpExiste());
            return false;
        } else if (cb_marca.getSelectedIndex() == 0) {
            cb_marca.requestFocus();
            InstanciasControle.getMensagens().aviso(MensagensSoltas.cadComumMarca());
            return false;
        } else if (Validacao.verificaStringVazia(tf_qtdeSaidas.getText())) {
            tf_qtdeSaidas.requestFocus();
            InstanciasControle.getMensagens().aviso(MensagensSoltas.cadModuloAcionamentoQtdeSaidaVazio());
            return false;
        } else if (!Validacao.verificaNumeroInteger(tf_qtdeSaidas.getText())) {
            tf_qtdeSaidas.requestFocus();
            InstanciasControle.getMensagens().aviso(MensagensSoltas.cadModuloAcionamentoQtdeSaidaNumero());
            return false;
        } else if (Validacao.verificaNumeroNegativo(tf_qtdeSaidas.getText())) {
            tf_qtdeSaidas.requestFocus();
            InstanciasControle.getMensagens().aviso(MensagensSoltas.cadModuloAcionamentoQtdeSaidaInvalido());
            return false;
        } else if (Validacao.verificaStringVazia(tf_porta.getText())) {
            tf_qtdeSaidas.requestFocus();
            InstanciasControle.getMensagens().aviso(MensagensSoltas.cadModuloAcionamentoPortaVazia());
            return false;
        } else if (!Validacao.verificaNumeroInteger(tf_porta.getText())) {
            tf_qtdeSaidas.requestFocus();
            InstanciasControle.getMensagens().aviso(MensagensSoltas.cadModuloAcionamentoPortaNumero());
            return false;
        } else if (Validacao.verificaNumeroNegativo(tf_porta.getText())) {
            tf_qtdeSaidas.requestFocus();
            InstanciasControle.getMensagens().aviso(MensagensSoltas.cadModuloAcionamentoPortaInvalida());
            return false;
        }

        return true;
    }

    private void limparCampos() {
        SwingUtil.limparCamposJTextField(pn_campos);
        cb_marca.setSelectedIndex(0);
    }

    public void preencheCampos(ModuloAcionamentoBean modulo) {
        tf_codigo.setText(modulo.getCodigo().toString());
        tf_nome.setText(modulo.getNome());
        tf_identificacao.setText(modulo.getIdentificacao());
        SwingUtil.selecionaItemCombo(modulo.getMarcaBean(), cb_marca);
        tf_qtdeSaidas.setText(modulo.getQtdeSaida().toString());
        tf_porta.setText(modulo.getPorta().toString());
    }

    //////////////////////////////////////////////////////////////////////////
    private ModuloAcionamentoBean populaModuloAcionamento() {
        ModuloAcionamentoBean moduloAcionamento = new ModuloAcionamentoBean();

        if (!tf_codigo.getText().equals("")) {
            moduloAcionamento.setCodigo(Integer.parseInt(tf_codigo.getText()));
        }
        moduloAcionamento.setNome(tf_nome.getText().toUpperCase());
        moduloAcionamento.setDeletado(EnumDeletadoDispositivo.NAO);
        moduloAcionamento.setIdentificacao(tf_identificacao.getText().toUpperCase());
        moduloAcionamento.setMarcaBean((MarcaBean) cb_marca.getSelectedItem());
        moduloAcionamento.setQtdeSaida(Integer.parseInt(tf_qtdeSaidas.getText()));
        moduloAcionamento.setStatus(EnumStatusDispositivo.ATIVO);
        moduloAcionamento.setPorta(Integer.parseInt(tf_porta.getText()));

        return moduloAcionamento;
    }

    public void salvar() {
        if (validaCampos()) {
            if (inserirModuloAcionamento(populaModuloAcionamento()) != null) {
                InstanciasControle.getGerenciarAudio().exeSalvar();
                InstanciasControle.getMensagens().sucesso(MensagensSoltas.cadModuloAcionamentoSalvar());
                if (tf_codigo.getText().equals("")) {
                    limparCampos();
                }
                AtualizaTelas.pesquisarModuloAcionamento();
                AtualizaTelas.cadastrarDispositivoEletrico();
            }
        }
    }

    public void atualizarTela() {
        preencherComboMarca();
    }

    public void ajuda() {
        Manual manual = new Manual(ArquivosHTML.cadastros() + ArquivosHTML.moduloAcionamento());
        SwingUtil.adicionarTabComBotaoFechar(InstanciasTelas.getPrincipal().tb_principal, "Ajuda", manual);
    }

    /*
     * BANCO DE DADOS
     */
    private ArrayList<ModuloAcionamentoBean> listaModuloAcionamentoOrdenadoPorCodigo() {
        ModuloAcionamentoFacade moduloAcionamentoFacade = FactoryFacade.getModuloAcionamentoImpl();
        try {
            return moduloAcionamentoFacade.listarModuloAcionamentoOrdenadaPorCodigo();
        } catch (FacadeException ex) {
        }
        return null;
    }

    private ArrayList<CameraBean> listaCameraOrdenadaPorCodigo() {
        CameraFacade cameraFacade = FactoryFacade.getCameraImpl();
        try {
            return cameraFacade.listarCameraOrdenadaPorCodigo();
        } catch (FacadeException ex) {
        }
        return null;
    }

    private ArrayList<DispositivoEletricoBean> listaDispositivoEletricoOrdenadoPorCodigo() {
        DispositivoEletricoFacade dispositivoEletricoFacade = FactoryFacade.getDispositivoEletricoImpl();
        try {
            return dispositivoEletricoFacade.listarDispositivoEletricoOrdenadaPorCodigo();
        } catch (FacadeException ex) {
        }
        return null;
    }

    private ArrayList<MarcaBean> listaMarcas() {
        MarcaFacade marcaFacade = FactoryFacade.getMarcaImpl();
        try {
            return (ArrayList<MarcaBean>) marcaFacade.listarMarcaOrdenadaPorCodigo();
        } catch (FacadeException ex) {
        }
        return null;
    }

    private ModuloAcionamentoBean inserirModuloAcionamento(ModuloAcionamentoBean modulo) {
        ModuloAcionamentoFacade moduloAcionamentoFacade = FactoryFacade.getModuloAcionamentoImpl();
        try {
            return moduloAcionamentoFacade.insereOuAltera(modulo);
        } catch (FacadeException ex) {
        }
        return null;
    }

}
