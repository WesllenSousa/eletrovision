
package telas.relatorios;

import entidades.movimento.bean.MovimentoBean;
import entidades.movimento.facade.MovimentoFacade;
import java.util.ArrayList;
import java.util.Calendar;
import telas.relatorios.dependencias.GeradorRelatorios;
import util.FacadeException;
import util.FactoryFacade;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class RelatorioMovimento extends javax.swing.JPanel {
    
    private GeradorRelatorios geradorRelatorios;
    private MovimentoFacade movimentoFacade;
    
    private Integer codigo;
    private Calendar dataInicio, dataFim;
    
    public RelatorioMovimento() {
        initComponents();
        instanciaClasses();
        pn_entreDatas.setVisible(false);
    }
    
    private void instanciaClasses(){
        if(geradorRelatorios == null){
            geradorRelatorios = new GeradorRelatorios();
        }
        if(movimentoFacade == null){
            movimentoFacade = FactoryFacade.getMovimentoImpl();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoMovimentos = new javax.swing.ButtonGroup();
        grupoOpcoesMovimentos = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        rb_todosMovimentos = new javax.swing.JRadioButton();
        rb_movimentosAgrupadosCamera = new javax.swing.JRadioButton();
        rb_movimentosAgrupadosMensagem = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        rb_movimentos = new javax.swing.JRadioButton();
        rb_entreDatas = new javax.swing.JRadioButton();
        pn_entreDatas = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        tf_dataIni = new net.sf.nachocalendar.components.DateField();
        jLabel6 = new javax.swing.JLabel();
        tf_dataFim = new net.sf.nachocalendar.components.DateField();

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Movimentos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 12))); // NOI18N

        grupoMovimentos.add(rb_todosMovimentos);
        rb_todosMovimentos.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rb_todosMovimentos.setSelected(true);
        rb_todosMovimentos.setText("Movimentos");

        grupoMovimentos.add(rb_movimentosAgrupadosCamera);
        rb_movimentosAgrupadosCamera.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rb_movimentosAgrupadosCamera.setText("Movimentos Agrupados por Camera");

        grupoMovimentos.add(rb_movimentosAgrupadosMensagem);
        rb_movimentosAgrupadosMensagem.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rb_movimentosAgrupadosMensagem.setText("Movimentos Agrupados por Mensagem");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rb_todosMovimentos)
                    .addComponent(rb_movimentosAgrupadosCamera)
                    .addComponent(rb_movimentosAgrupadosMensagem))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(rb_todosMovimentos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rb_movimentosAgrupadosCamera)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rb_movimentosAgrupadosMensagem)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Opções Movimentos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 12))); // NOI18N

        grupoOpcoesMovimentos.add(rb_movimentos);
        rb_movimentos.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rb_movimentos.setSelected(true);
        rb_movimentos.setText("Todos os Movimentos");

        grupoOpcoesMovimentos.add(rb_entreDatas);
        rb_entreDatas.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rb_entreDatas.setText("Entres as Datas");
        rb_entreDatas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_entreDatasActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Entre:");

        tf_dataIni.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("e");

        tf_dataFim.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        javax.swing.GroupLayout pn_entreDatasLayout = new javax.swing.GroupLayout(pn_entreDatas);
        pn_entreDatas.setLayout(pn_entreDatasLayout);
        pn_entreDatasLayout.setHorizontalGroup(
            pn_entreDatasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_entreDatasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_entreDatasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_entreDatasLayout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jLabel6))
                    .addComponent(tf_dataIni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(tf_dataFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pn_entreDatasLayout.setVerticalGroup(
            pn_entreDatasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_entreDatasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_entreDatasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(tf_dataIni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(tf_dataFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pn_entreDatas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rb_movimentos)
                            .addComponent(rb_entreDatas))
                        .addContainerGap(61, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(rb_movimentos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_entreDatas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_entreDatas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(24, Short.MAX_VALUE))
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

    private void rb_entreDatasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_entreDatasActionPerformed
        // TODO add your handling code here:
        if(rb_entreDatas.isEnabled()){
            pn_entreDatas.setVisible(true);
        } else {
            pn_entreDatas.setVisible(false);
        }
    }//GEN-LAST:event_rb_entreDatasActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup grupoMovimentos;
    private javax.swing.ButtonGroup grupoOpcoesMovimentos;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pn_entreDatas;
    private javax.swing.JRadioButton rb_entreDatas;
    private javax.swing.JRadioButton rb_movimentos;
    private javax.swing.JRadioButton rb_movimentosAgrupadosCamera;
    private javax.swing.JRadioButton rb_movimentosAgrupadosMensagem;
    private javax.swing.JRadioButton rb_todosMovimentos;
    private net.sf.nachocalendar.components.DateField tf_dataFim;
    private net.sf.nachocalendar.components.DateField tf_dataIni;
    // End of variables declaration//GEN-END:variables

    public void verificaOpcoes(){
        codigo = null; dataFim = null; dataInicio = null;
        
    }
    
    public void exibir(){
        if(rb_todosMovimentos.isSelected()){
            verificaOpcoes();
            geradorRelatorios.gerarRelatorioMovimento(listarMovimentoCriteria(codigo, 
                     dataInicio, dataFim), "Relatório de Movimentos");
        }else if(rb_movimentosAgrupadosCamera.isSelected()){
            
        }else if (rb_movimentosAgrupadosMensagem.isSelected()){
            
        }
    }
    
    private ArrayList<MovimentoBean> listarMovimentoOrdenadoPorData(){
        try {
            return movimentoFacade.listarMovimentoOrdenadoPorData();
        } catch (FacadeException ex) {
          
        }
        return null;
    }
    
    private ArrayList<MovimentoBean> listarMovimentoCriteria(Integer codigo,
            Calendar dataInicio, Calendar dataFim){
        try {
            return movimentoFacade.listarMovimentoCriteria(codigo, dataInicio, dataFim);
        } catch (FacadeException ex) {         
        }
        return null;
    }
    
}
