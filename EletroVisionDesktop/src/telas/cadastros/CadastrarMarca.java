package telas.cadastros;

import recursos.configuracoes.diretorios.caminhos.ArquivosHTML;
import entidades.marca.bean.EnumDeletadoMarca;
import entidades.marca.bean.MarcaBean;
import entidades.marca.facade.MarcaFacade;
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
 * @author Wesllen Sousa Lima, Hendrio Luis
 */
public class CadastrarMarca extends javax.swing.JPanel {

    public CadastrarMarca() {
        initComponents();
        nomeiaTela();
    }
    
    private void nomeiaTela() {
        lb_codigo.setText(MensagensTelas.cad_codigo());
        lb_nome.setText(MensagensTelas.cad_nome());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lb_nome = new javax.swing.JLabel();
        tf_nome = new javax.swing.JTextField();
        tf_codigo = new javax.swing.JTextField();
        lb_codigo = new javax.swing.JLabel();

        lb_nome.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lb_nome.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_nome.setText("Nome:*");

        tf_nome.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        tf_codigo.setEditable(false);
        tf_codigo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        lb_codigo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lb_codigo.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_codigo.setText("Código:*");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lb_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_nome, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lb_codigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_codigo, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_codigo)
                    .addComponent(tf_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_nome)
                    .addComponent(tf_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_codigo;
    private javax.swing.JLabel lb_nome;
    private javax.swing.JTextField tf_codigo;
    private javax.swing.JTextField tf_nome;
    // End of variables declaration//GEN-END:variables

    private Boolean verificaMarcaExiste() {
        for (MarcaBean marca : listarMarcaOrdenadaPorCodigo()) {
            if (!tf_codigo.getText().equals(marca.getCodigo().toString())) {
                if (marca.getNome().equals(tf_nome.getText().toUpperCase())) {
                    return true;
                }
            }
        }
        return false;
    }

    private Boolean validaCampos() {
        if (Validacao.verificaStringVazia(tf_nome.getText())) {
            tf_nome.requestFocus();
            InstanciasControle.getMensagens().aviso(MensagensSoltas.cadComumNomeVazio());
            return false;
        } else if (verificaMarcaExiste()) {
            tf_nome.requestFocus();
            tf_nome.setText("");
            InstanciasControle.getMensagens().aviso(MensagensSoltas.cadComumNomeExiste());
            return false;
        }
        return true;
    }

    private MarcaBean populaMarca() {
        MarcaBean marca = new MarcaBean();

        if (!tf_codigo.getText().equals("")) {
            marca.setCodigo(Integer.parseInt(tf_codigo.getText()));
        }
        marca.setNome(tf_nome.getText().toUpperCase());
        marca.setDeletado(EnumDeletadoMarca.NAO);
        
        return marca;
    }

    public void preencheCampos(MarcaBean marca) {
        tf_codigo.setText(marca.getCodigo().toString());
        tf_nome.setText(marca.getNome());
    }

    private void limparCampos() {
        SwingUtil.limparCamposJTextField(jPanel2);

    }

    public void salvar() {
        if (validaCampos()) {
            if (inserirMarca(populaMarca()) != null) {
                InstanciasControle.getGerenciarAudio().exeSalvar();
                InstanciasControle.getMensagens().sucesso(MensagensSoltas.cadMarcaSalvar());
                if (tf_codigo.getText().equals("")) {
                    limparCampos();
                }
                AtualizaTelas.pesquisarMarca();
                AtualizaTelas.cadastrarCamera();
                AtualizaTelas.cadastrarModuloAcionamento();
                AtualizaTelas.cadastrarDispositivoEletrico();
            }
        }
    }
    
    public void ajuda() {
        Manual manual = new Manual(ArquivosHTML.cadastros()+ArquivosHTML.marca());
        SwingUtil.adicionarTabComBotaoFechar(InstanciasTelas.getPrincipal().tb_principal, "Ajuda", manual); 
    }
    
    /*
     * BANCO DE DADOS
     */
    
    private ArrayList<MarcaBean> listarMarcaOrdenadaPorCodigo() {
        MarcaFacade marcaFacade = FactoryFacade.getMarcaImpl();
        try {
            return marcaFacade.listarMarcaOrdenadaPorCodigo();
        } catch (FacadeException ex) {
        }
        return null;
    }
    
    private MarcaBean inserirMarca(MarcaBean marca) {
        MarcaFacade marcaFacade = FactoryFacade.getMarcaImpl();
        try {
            return marcaFacade.insereOuAltera(marca);
        } catch (FacadeException ex) {
        }
        return null;
    }
    
}
