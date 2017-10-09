package telas.relatorios;

import entidades.acionamento.bean.EnumDeletadoAcionamento;
import entidades.acionamento.bean.EnumLigarDesligarAcionamento;
import entidades.area.facade.AreaFacade;
import entidades.dispositivo.bean.DispositivoBean;
import entidades.dispositivo.bean.EnumDeletadoDispositivo;
import entidades.dispositivo.facade.DispositivoFacade;
import entidades.dispositivoEletrico.bean.EnumLigarDesligarDispositivoEletrico;
import entidades.marca.facade.MarcaFacade;
import entidades.moduloAcionamento.bean.ModuloAcionamentoBean;
import entidades.moduloAcionamento.facade.ModuloAcionamentoFacade;
import java.util.ArrayList;
import telas.relatorios.dependencias.GeradorRelatorios;
import util.FacadeException;
import util.FactoryFacade;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class RelatorioDispositivos extends javax.swing.JPanel {

    private AreaFacade areaFacade;
    private MarcaFacade marcaFacade;
    private ModuloAcionamentoFacade acionamentoFacade;
    private GeradorRelatorios geradorRelatorios;
    private DispositivoFacade dispositivoFacade;
    private Integer codigo = null;
    private EnumLigarDesligarDispositivoEletrico statusDispositivo = null;
    private EnumLigarDesligarAcionamento statusAcionamento = null;
    private EnumDeletadoDispositivo deletadoDispositivo = null;
    private EnumDeletadoAcionamento deletadoAcionamento = null;

    public RelatorioDispositivos() {
        initComponents();
        instanciaClasses();

        preencherComboDispositivo();
        preencheComboModulo();
    }

    private void instanciaClasses() {
        if (geradorRelatorios == null) {
            geradorRelatorios = new GeradorRelatorios();
        }
        if (acionamentoFacade == null) {
            acionamentoFacade = FactoryFacade.getModuloAcionamentoImpl();
        }
        if (areaFacade == null) {
            areaFacade = FactoryFacade.getAreaImpl();
        }
        if (dispositivoFacade == null) {
            dispositivoFacade = FactoryFacade.getDispositivoImpl();
        }
        if (marcaFacade == null) {
            marcaFacade = FactoryFacade.getMarcaImpl();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoDispositivos = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        rb_Cameras = new javax.swing.JRadioButton();
        rb_predioAreaCameras = new javax.swing.JRadioButton();
        rb_configCameras = new javax.swing.JRadioButton();
        rb_marcaCameras = new javax.swing.JRadioButton();
        rb_dispositivoEletrico = new javax.swing.JRadioButton();
        rb_AreaDispositivoEletrico = new javax.swing.JRadioButton();
        rb_marcaDispositivoEletrico = new javax.swing.JRadioButton();
        rb_moduloAcionamento = new javax.swing.JRadioButton();
        rb_marcaModuloAcionamento = new javax.swing.JRadioButton();
        rb_dispositivosEletricosModuloAcionamento = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cb_dispositivos = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        cb_statusDispositivo = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        cb_deletadoDispositivos = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cb_modulos = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        cb_statusModulo = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        cb_deletadoModulos = new javax.swing.JComboBox();

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dispositivos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 14))); // NOI18N

        grupoDispositivos.add(rb_Cameras);
        rb_Cameras.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rb_Cameras.setSelected(true);
        rb_Cameras.setText("Cameras");

        grupoDispositivos.add(rb_predioAreaCameras);
        rb_predioAreaCameras.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rb_predioAreaCameras.setText("Prédio e Área das Cameras");

        grupoDispositivos.add(rb_configCameras);
        rb_configCameras.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rb_configCameras.setText("Configuração das Cameras");

        grupoDispositivos.add(rb_marcaCameras);
        rb_marcaCameras.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rb_marcaCameras.setText("Marca das Cameras");

        grupoDispositivos.add(rb_dispositivoEletrico);
        rb_dispositivoEletrico.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rb_dispositivoEletrico.setText("Dispositivo Elétrico");

        grupoDispositivos.add(rb_AreaDispositivoEletrico);
        rb_AreaDispositivoEletrico.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rb_AreaDispositivoEletrico.setText("Área dos Dispositivos Elétricos");

        grupoDispositivos.add(rb_marcaDispositivoEletrico);
        rb_marcaDispositivoEletrico.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rb_marcaDispositivoEletrico.setText("Marca dos Dispositivos Elétricos");

        grupoDispositivos.add(rb_moduloAcionamento);
        rb_moduloAcionamento.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rb_moduloAcionamento.setText("Módulo de Acionamento");

        grupoDispositivos.add(rb_marcaModuloAcionamento);
        rb_marcaModuloAcionamento.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rb_marcaModuloAcionamento.setText("Marca dos Módulos de Acionamento");

        grupoDispositivos.add(rb_dispositivosEletricosModuloAcionamento);
        rb_dispositivosEletricosModuloAcionamento.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rb_dispositivosEletricosModuloAcionamento.setText("Dispositivos Elétricos dos Módulos de Acionamento");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rb_Cameras)
                    .addComponent(rb_predioAreaCameras)
                    .addComponent(rb_configCameras)
                    .addComponent(rb_marcaCameras)
                    .addComponent(rb_dispositivoEletrico)
                    .addComponent(rb_AreaDispositivoEletrico)
                    .addComponent(rb_marcaDispositivoEletrico)
                    .addComponent(rb_moduloAcionamento)
                    .addComponent(rb_marcaModuloAcionamento)
                    .addComponent(rb_dispositivosEletricosModuloAcionamento))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rb_Cameras)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_configCameras)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_predioAreaCameras)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_marcaCameras)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_dispositivoEletrico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_AreaDispositivoEletrico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_marcaDispositivoEletrico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_moduloAcionamento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_marcaModuloAcionamento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_dispositivosEletricosModuloAcionamento)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Opção dos Dispositivos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 14))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel1.setText("Dispositivos:");

        cb_dispositivos.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel4.setText("Status:");

        cb_statusDispositivo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "todos", "Ativado", "Desativado", " " }));

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel5.setText("Deletado?:");

        cb_deletadoDispositivos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "todos", "Deletado", "Não Deletado", " ", " " }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel1)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(cb_statusDispositivo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cb_deletadoDispositivos, 0, 131, Short.MAX_VALUE)
                    .addComponent(cb_dispositivos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cb_dispositivos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_statusDispositivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(3, 3, 3)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_deletadoDispositivos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Opções Módulos de Acionamento ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 14))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel3.setText("Módulos:");

        cb_modulos.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel2.setText("Status:");

        cb_statusModulo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "todos", "Ligado", "Desligado", " " }));

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel6.setText("Deletado?:");

        cb_deletadoModulos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "todos", "Deletado", "Não Deletado", " ", " " }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cb_modulos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cb_statusModulo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cb_deletadoModulos, 0, 136, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cb_modulos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cb_statusModulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_deletadoModulos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(0, 23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cb_deletadoDispositivos;
    private javax.swing.JComboBox cb_deletadoModulos;
    private javax.swing.JComboBox cb_dispositivos;
    private javax.swing.JComboBox cb_modulos;
    private javax.swing.JComboBox cb_statusDispositivo;
    private javax.swing.JComboBox cb_statusModulo;
    private javax.swing.ButtonGroup grupoDispositivos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rb_AreaDispositivoEletrico;
    private javax.swing.JRadioButton rb_Cameras;
    private javax.swing.JRadioButton rb_configCameras;
    private javax.swing.JRadioButton rb_dispositivoEletrico;
    private javax.swing.JRadioButton rb_dispositivosEletricosModuloAcionamento;
    private javax.swing.JRadioButton rb_marcaCameras;
    private javax.swing.JRadioButton rb_marcaDispositivoEletrico;
    private javax.swing.JRadioButton rb_marcaModuloAcionamento;
    private javax.swing.JRadioButton rb_moduloAcionamento;
    private javax.swing.JRadioButton rb_predioAreaCameras;
    // End of variables declaration//GEN-END:variables

    private void preencherComboDispositivo() {
        cb_dispositivos.addItem("todos");

        //for (DispositivoBean dispositivo : listarDispositivosOrdenadoPorNome()) {
            //cb_dispositivos.addItem(dispositivo);
        //}
    }

    private void preencheComboModulo() {
        cb_modulos.addItem("todos");

        for (ModuloAcionamentoBean modulo : listarModuloAcionamentoPorCodigo()) {
            cb_modulos.addItem(modulo);
        }
    }

    private void verifcaOpcoes() {
        codigo = null;
        deletadoAcionamento = null;
        deletadoDispositivo = null;
        statusAcionamento = null;
        deletadoAcionamento = null;

        if (cb_dispositivos.getSelectedIndex() != 0) {
            codigo = ((DispositivoBean) cb_dispositivos.getSelectedItem()).getCodigo();
        }

        if (cb_statusDispositivo.getSelectedIndex() != 0) {
            if (cb_statusDispositivo.getSelectedIndex() == 1) {
                statusDispositivo = EnumLigarDesligarDispositivoEletrico.LIGADO;
            } else if (cb_statusDispositivo.getSelectedIndex() == 2) {
                statusDispositivo = EnumLigarDesligarDispositivoEletrico.LIGADO;
            }
        }

        if (cb_deletadoDispositivos.getSelectedIndex() != 0) {
            if (cb_deletadoDispositivos.getSelectedIndex() == 1) {
                deletadoDispositivo = EnumDeletadoDispositivo.SIM;
            } else if (cb_deletadoDispositivos.getSelectedIndex() == 2) {
                deletadoDispositivo = EnumDeletadoDispositivo.NAO;
            }
        }

        if (cb_modulos.getSelectedIndex() != 0) {
            acionamentoFacade = (ModuloAcionamentoFacade) cb_modulos.getSelectedItem();
        }

        if (cb_statusModulo.getSelectedIndex() != 0) {
            if (cb_statusModulo.getSelectedIndex() == 1) {
                statusAcionamento = EnumLigarDesligarAcionamento.LIGADO;
            } else if (cb_statusModulo.getSelectedIndex() == 2) {
                statusAcionamento = EnumLigarDesligarAcionamento.DESLIGADO;
            }
        }

        if (cb_deletadoModulos.getSelectedIndex() != 0) {
            if (cb_deletadoModulos.getSelectedIndex() == 1) {
                deletadoAcionamento = EnumDeletadoAcionamento.SIM;
            } else if (cb_deletadoModulos.getSelectedIndex() == 2) {
                deletadoAcionamento = EnumDeletadoAcionamento.NAO;
            }
        }
    }

    public void exibir() {
        if (rb_Cameras.isSelected()) {
            verifcaOpcoes();
        } else if (rb_configCameras.isSelected()) {
        } else if (rb_predioAreaCameras.isSelected()) {
        } else if (rb_marcaCameras.isSelected()) {
        } else if (rb_dispositivoEletrico.isSelected()) {
        } else if (rb_AreaDispositivoEletrico.isSelected()) {
        } else if (rb_marcaDispositivoEletrico.isSelected()) {
        } else if (rb_moduloAcionamento.isSelected()) {
        } else if (rb_marcaModuloAcionamento.isSelected()) {
        } else if (rb_dispositivosEletricosModuloAcionamento.isSelected()) {
        }
    }

    private ArrayList<ModuloAcionamentoBean> listarModuloAcionamentoPorCodigo() {
        try {
            return acionamentoFacade.listarModuloAcionamentoOrdenadaPorCodigo();
        } catch (FacadeException ex) {
        }
        return null;
    }
    
}
