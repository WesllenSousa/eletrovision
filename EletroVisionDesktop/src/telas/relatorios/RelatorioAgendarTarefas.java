package telas.relatorios;

import entidades.agendarTarefas.bean.AgendarTarefasBean;
import entidades.agendarTarefas.bean.EnumDeletadoAgendarTarefas;
import entidades.agendarTarefas.bean.EnumStatusAgendarTarefas;
import entidades.agendarTarefas.bean.EnumTipoVinculoAgendarTarefas;
import entidades.agendarTarefas.facade.AgendarTarefasFacade;
import java.util.ArrayList;
import telas.relatorios.dependencias.GeradorRelatorios;
import util.FacadeException;
import util.FactoryFacade;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class RelatorioAgendarTarefas extends javax.swing.JPanel {

    private GeradorRelatorios geradorRelatorios;
    private AgendarTarefasFacade tarefasFacade;
    private Integer codigo = null;
    private EnumStatusAgendarTarefas status = null;
    private EnumTipoVinculoAgendarTarefas tipo;
    private EnumDeletadoAgendarTarefas deletado;

    public RelatorioAgendarTarefas() {
        initComponents();
        instanciaClasses();
        preencheComboAgendamento();
    }

    private void instanciaClasses() {
        if (geradorRelatorios == null) {
            geradorRelatorios = new GeradorRelatorios();
        }
        if (tarefasFacade == null) {
            tarefasFacade = FactoryFacade.getAgendarTarefasFacadeImpl();
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoAgendamento = new javax.swing.ButtonGroup();
        grupoOpcoesAgendamento = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        rb_agentamentoTodos = new javax.swing.JRadioButton();
        rb_agendamentoCamera = new javax.swing.JRadioButton();
        rb_AgendamentoCenario = new javax.swing.JRadioButton();
        rb_AgendamentoMensagem = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cb_agendamento = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        rb_deletado = new javax.swing.JRadioButton();
        rb_naoDeletado = new javax.swing.JRadioButton();
        cb_status = new javax.swing.JComboBox();
        cb_tipo = new javax.swing.JComboBox();

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Agendar Tarefas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 14))); // NOI18N

        grupoAgendamento.add(rb_agentamentoTodos);
        rb_agentamentoTodos.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rb_agentamentoTodos.setSelected(true);
        rb_agentamentoTodos.setText("Agendamentos");

        grupoAgendamento.add(rb_agendamentoCamera);
        rb_agendamentoCamera.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rb_agendamentoCamera.setText("Agendamento da Camera");

        grupoAgendamento.add(rb_AgendamentoCenario);
        rb_AgendamentoCenario.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rb_AgendamentoCenario.setText("Agendamento do Cenário");

        grupoAgendamento.add(rb_AgendamentoMensagem);
        rb_AgendamentoMensagem.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rb_AgendamentoMensagem.setText("Agendamento das Mensagens");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rb_agentamentoTodos)
                    .addComponent(rb_agendamentoCamera)
                    .addComponent(rb_AgendamentoCenario)
                    .addComponent(rb_AgendamentoMensagem))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(rb_agentamentoTodos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rb_agendamentoCamera)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rb_AgendamentoCenario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rb_AgendamentoMensagem)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Opções Agendar Tarefas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 14))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel1.setText("Agendamento: ");

        cb_agendamento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel2.setText("Status:");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel3.setText("Tipo de Vinculo:");

        grupoOpcoesAgendamento.add(rb_deletado);
        rb_deletado.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rb_deletado.setText("Deletado");

        grupoOpcoesAgendamento.add(rb_naoDeletado);
        rb_naoDeletado.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rb_naoDeletado.setSelected(true);
        rb_naoDeletado.setText("Não Deletado");

        cb_status.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "todos", "Ativo", "Inativo", " " }));

        cb_tipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "todos", "Mensagem", "Acionamento", "Camera", " " }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(rb_deletado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rb_naoDeletado))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel1))
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cb_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb_status, 0, 130, Short.MAX_VALUE)
                            .addComponent(cb_agendamento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cb_agendamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cb_status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cb_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rb_deletado)
                    .addComponent(rb_naoDeletado))
                .addContainerGap(95, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
    private javax.swing.JComboBox cb_agendamento;
    private javax.swing.JComboBox cb_status;
    private javax.swing.JComboBox cb_tipo;
    private javax.swing.ButtonGroup grupoAgendamento;
    private javax.swing.ButtonGroup grupoOpcoesAgendamento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rb_AgendamentoCenario;
    private javax.swing.JRadioButton rb_AgendamentoMensagem;
    private javax.swing.JRadioButton rb_agendamentoCamera;
    private javax.swing.JRadioButton rb_agentamentoTodos;
    private javax.swing.JRadioButton rb_deletado;
    private javax.swing.JRadioButton rb_naoDeletado;
    // End of variables declaration//GEN-END:variables

    private void preencheComboAgendamento() {
        cb_agendamento.removeAllItems();
        cb_agendamento.addItem("todos");
        for (AgendarTarefasBean agenda : listarAgendarTarefasNaoDeletado()) {
            cb_agendamento.addItem(agenda);
        }
    }

    private void verificaOpcoes() {
        codigo = null;
        status = null;
        deletado = null;
        tipo = null;

        if (cb_agendamento.getSelectedIndex() != 0) {
            codigo = ((AgendarTarefasBean) cb_agendamento.getSelectedItem()).getCodigo();
        }

        if (cb_status.getSelectedIndex() != 0) {
            if (cb_status.getSelectedIndex() == 1) {
                status = EnumStatusAgendarTarefas.ATIVO;
            } else if (cb_status.getSelectedIndex() == 2) {
                status = EnumStatusAgendarTarefas.INATIVO;
            }
        }

        if (cb_tipo.getSelectedIndex() != 0) {
            if (cb_tipo.getSelectedIndex() == 1) {
                tipo = EnumTipoVinculoAgendarTarefas.MENSAGEM;
            } else if (cb_tipo.getSelectedIndex() == 2) {
                tipo = EnumTipoVinculoAgendarTarefas.ACIONAMENTO;
            } else if (cb_tipo.getSelectedIndex() == 3) {
                tipo = EnumTipoVinculoAgendarTarefas.CAMERA;
            }
        }

        if (rb_deletado.isSelected()) {
            deletado = EnumDeletadoAgendarTarefas.SIM;
        } else if (rb_naoDeletado.isSelected()) {
            deletado = EnumDeletadoAgendarTarefas.NAO;
        }
    }

    public void exibir() {
        if (rb_agentamentoTodos.isSelected()) {
            verificaOpcoes();
            geradorRelatorios.gerarRelatorioAgendarTarefas(listarAgendarTarefasCriteria(codigo, status, tipo, deletado),
                    "Relatorio Agendar Tarefas");
        } else if (rb_agendamentoCamera.isSelected()) {
        } else if (rb_AgendamentoMensagem.isSelected()) {
        } else if (rb_AgendamentoMensagem.isSelected()) {
        }
    }

    private ArrayList<AgendarTarefasBean> listarAgendarTarefasNaoDeletado() {
        try {
            return tarefasFacade.listarAgendarTarefasNaoDeletado();
        } catch (FacadeException ex) {
        }
        return null;
    }
    
    private ArrayList<AgendarTarefasBean> listarAgendarTarefasCriteria(Integer codigo,
                    EnumStatusAgendarTarefas status, EnumTipoVinculoAgendarTarefas tipo,
                    EnumDeletadoAgendarTarefas deletado){
        try {
            return tarefasFacade.listarAgendarTarefasCriteria(codigo, status, tipo, deletado);
        } catch (FacadeException ex) {
        }
        return null;
    }
}
