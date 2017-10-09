package telas.cadastros;

import recursos.configuracoes.diretorios.caminhos.ArquivosHTML;
import entidades.area.bean.AreaBean;
import entidades.area.bean.EnumDeletadoArea;
import entidades.area.facade.AreaFacade;
import entidades.predio.bean.PredioBean;
import entidades.predio.facade.PredioFacade;
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
 * @author Hendrio Luis
 */
public class CadastrarArea extends javax.swing.JPanel {

    public CadastrarArea() {
        initComponents();
        nomeiaTela();
        InstanciasTelas.setCadastrarArea(CadastrarArea.this);

        preencherComboPredio();
    }

    private void nomeiaTela() {
        lb_codigo.setText(MensagensTelas.cad_codigo());
        lb_nome.setText(MensagensTelas.cad_nome());
        lb_predio.setText(MensagensTelas.cad_predio());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        pn_campos = new javax.swing.JPanel();
        lb_nome = new javax.swing.JLabel();
        tf_nome = new javax.swing.JTextField();
        lb_predio = new javax.swing.JLabel();
        cb_predio = new javax.swing.JComboBox();
        lb_codigo = new javax.swing.JLabel();
        tf_codigo = new javax.swing.JTextField();

        lb_nome.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lb_nome.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_nome.setText("Nome:*");

        tf_nome.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        lb_predio.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lb_predio.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_predio.setText("Prédio:*");

        cb_predio.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cb_predio.setToolTipText("Selecione um Tipo");

        lb_codigo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lb_codigo.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_codigo.setText("Código:*");

        tf_codigo.setEditable(false);
        tf_codigo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        javax.swing.GroupLayout pn_camposLayout = new javax.swing.GroupLayout(pn_campos);
        pn_campos.setLayout(pn_camposLayout);
        pn_camposLayout.setHorizontalGroup(
            pn_camposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_camposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_camposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lb_codigo, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                    .addComponent(lb_predio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_nome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_camposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cb_predio, 0, 230, Short.MAX_VALUE)
                    .addComponent(tf_nome)
                    .addComponent(tf_codigo))
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
                    .addComponent(lb_predio)
                    .addComponent(cb_predio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pn_campos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pn_campos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
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
    private javax.swing.JComboBox cb_predio;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_codigo;
    private javax.swing.JLabel lb_nome;
    private javax.swing.JLabel lb_predio;
    private javax.swing.JPanel pn_campos;
    private javax.swing.JTextField tf_codigo;
    private javax.swing.JTextField tf_nome;
    // End of variables declaration//GEN-END:variables

    private Boolean verificaAreaExiste() {
        for (AreaBean area : listaAreaOrdenadaPorCodigo()) {
            if (!tf_codigo.getText().equals(area.getCodigo().toString())) {
                if (area.getNome().equals(tf_nome.getText().toUpperCase())) {
                    return true;
                }
            }
        }
        return false;
    }

    private void preencherComboPredio() {
        cb_predio.removeAllItems();
        cb_predio.addItem(MensagensTelas.cad_selecionarPredio());
        for (PredioBean predio : listarPredios()) {
            cb_predio.addItem(predio);
        }
    }

    private Boolean validaCampos() {
        if (Validacao.verificaStringVazia(tf_nome.getText())) {
            tf_nome.requestFocus();
            InstanciasControle.getMensagens().aviso(MensagensSoltas.cadComumNomeVazio());
            return false;
        } else if (verificaAreaExiste()) {
            tf_nome.requestFocus();
            tf_nome.setText("");
            InstanciasControle.getMensagens().aviso(MensagensSoltas.cadComumNomeExiste());
            return false;
        } else if (cb_predio.getSelectedIndex() == 0) {
            cb_predio.requestFocus();
            InstanciasControle.getMensagens().aviso(MensagensSoltas.cadAreaPredio());
            return false;
        }

        return true;
    }

    private AreaBean popularArea() {
        AreaBean area = new AreaBean();

        if (!tf_codigo.getText().equals("")) {
            area.setCodigo(Integer.parseInt(tf_codigo.getText()));
        }
        area.setDeletado(EnumDeletadoArea.NAO);
        area.setNome(tf_nome.getText().toUpperCase());
        area.setPredio((PredioBean) cb_predio.getSelectedItem());

        return area;
    }

    private void limparCampos() {
        SwingUtil.limparCamposJTextField(pn_campos);
        cb_predio.setSelectedIndex(0);
    }

    public void preencheCampos(AreaBean area) {
        tf_codigo.setText(area.getCodigo().toString());
        tf_nome.setText(area.getNome());

        SwingUtil.selecionaItemCombo(area.getPredio(), cb_predio);
    }

    public void salvar() {
        if (validaCampos()) {
            if (inserirArea(popularArea()) != null) {
                InstanciasControle.getGerenciarAudio().exeSalvar();
                InstanciasControle.getMensagens().sucesso(MensagensSoltas.cadAreaSalvar());
                if (tf_codigo.getText().equals("")) {
                    limparCampos();
                }
                AtualizaTelas.pesquisarArea();
            }
        }
    }

    public void atualizarTela() {
        preencherComboPredio();
    }
    
    public void ajuda() {
        Manual manual = new Manual(ArquivosHTML.cadastros()+ArquivosHTML.area());
        SwingUtil.adicionarTabComBotaoFechar(InstanciasTelas.getPrincipal().tb_principal, "Ajuda", manual); 
    }

    /*
     * BANCO DE DADOS
     */
    
    private AreaBean inserirArea(AreaBean area) {
        AreaFacade areaFacade = FactoryFacade.getAreaImpl();
        try {
            return areaFacade.insereOuAltera(area);
        } catch (FacadeException ex) {
        }
        return null;
    }

    private ArrayList<AreaBean> listaAreaOrdenadaPorCodigo() {
        AreaFacade areaFacade = FactoryFacade.getAreaImpl();
        try {
            return areaFacade.listarAreaOrdenadaPorCodigo();
        } catch (FacadeException ex) {
        }
        return null;
    }

    private ArrayList<PredioBean> listarPredios() {
        PredioFacade predioFacade = FactoryFacade.getPredioImpl();
        try {
            return (ArrayList<PredioBean>) predioFacade.listar();
        } catch (FacadeException ex) {
        }
        return null;
    }
    
}
