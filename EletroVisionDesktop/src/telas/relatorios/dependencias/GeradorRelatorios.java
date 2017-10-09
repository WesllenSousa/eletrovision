package telas.relatorios.dependencias;

import recursos.configuracoes.diretorios.caminhos.ArquivosImagens;
import recursos.configuracoes.diretorios.caminhos.ArquivosRelatorios;
import entidades.acionamento.bean.AcionamentoBean;
import entidades.agendarTarefas.bean.AgendarTarefasBean;
import entidades.dispositivo.bean.DispositivoBean;
import entidades.logAcoes.bean.LogAcoesBean;
import entidades.mensagem.bean.MensagemBean;
import entidades.movimento.bean.MovimentoBean;
import entidades.pessoa.bean.PessoaBean;
import entidades.predio.bean.PredioBean;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;
import recursos.instancias.InstanciasTelas;
import recursos.internacionalizacao.MensagensErro;
import util.SwingUtil;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class GeradorRelatorios {

    public void gerarRelatorioPessoa(List<PessoaBean> pessoas, String titulo) {
        try {
            Map parametros = new HashMap();
            parametros.put("diretorio", ArquivosImagens.diretorio_cadastros());
            InputStream is = new FileInputStream(new File(ArquivosRelatorios.pessoa()));
            JasperPrint jp = JasperFillManager.fillReport(is, parametros, new JRBeanCollectionDataSource(pessoas));
            JRViewer jr = new JRViewer(jp);
            abrirAba(jr, titulo);
        } catch (FileNotFoundException | JRException ex) {
            MensagensErro.relatPessoa(ex);
        }
    }

    public void gerarRelatorioMensagem(List<MensagemBean> mensagens, String titulo) {
        try {
            Map parametros = new HashMap();
            parametros.put("diretorio", ArquivosImagens.diretorio_cadastros());
            InputStream is = new FileInputStream(new File(ArquivosRelatorios.mensagem()));
            JasperPrint jp = JasperFillManager.fillReport(is, parametros, new JRBeanCollectionDataSource(mensagens));
            JRViewer jr = new JRViewer(jp);
            abrirAba(jr, titulo);
        } catch (FileNotFoundException | JRException ex) {
            MensagensErro.relatMensagem(ex);
        }
    }

    public void gerarRelatorioAcionamento(List<AcionamentoBean> acionamentos, String titulo) {
        try {
            Map parametros = new HashMap();
            parametros.put("diretorio", ArquivosImagens.diretorio_cenario());
            InputStream is = new FileInputStream(new File(ArquivosRelatorios.acionamento()));
            JasperPrint jp = JasperFillManager.fillReport(is, parametros, new JRBeanCollectionDataSource(acionamentos));
            JRViewer jr = new JRViewer(jp);
            abrirAba(jr, titulo);
        } catch (FileNotFoundException | JRException ex) {
            MensagensErro.relatMensagem(ex);
        }
    }

    public void gerarRelatorioPredio(List<PredioBean> predios, String titulo) {
        try {
            Map parametros = new HashMap();
            parametros.put("diretorio", ArquivosImagens.diretorio_cadastros());
            InputStream is = new FileInputStream(new File(ArquivosRelatorios.predio()));
            JasperPrint jp = JasperFillManager.fillReport(is, parametros, new JRBeanCollectionDataSource(predios));
            JRViewer jr = new JRViewer(jp);
            abrirAba(jr, titulo);
        } catch (JRException | FileNotFoundException ex) {
            MensagensErro.relatPredio(ex);
        }
    }

    public void gerarRelatorioMovimento(List<MovimentoBean> movimentos, String titulo) {
        try {
            Map parametros = new HashMap();
            parametros.put("diretorio", ArquivosImagens.diretorio_cenario());
            InputStream is = new FileInputStream(new File(ArquivosRelatorios.movimento()));
            JasperPrint jp = JasperFillManager.fillReport(is, parametros, new JRBeanCollectionDataSource(movimentos));
            JRViewer jr = new JRViewer(jp);
            abrirAba(jr, titulo);
        } catch (FileNotFoundException | JRException ex) {
            MensagensErro.relatMovimentos(ex);
        }
    }

    public void gerarRelatorioDispositivo(List<DispositivoBean> dispositivos, String titulo) {
        try {
            Map parametros = new HashMap();
            parametros.put("diretorio", ArquivosImagens.diretorio_cenario());
            InputStream is = new FileInputStream(new File(ArquivosRelatorios.dispositivo()));
            JasperPrint jp = JasperFillManager.fillReport(is, parametros, new JRBeanCollectionDataSource(dispositivos));
            JRViewer jr = new JRViewer(jp);
            abrirAba(jr, titulo);
        } catch (FileNotFoundException | JRException ex) {
            MensagensErro.relatDispositivos(ex);
        }
    }

    public void gerarRelatorioAgendarTarefas(List<AgendarTarefasBean> dispositivos, String titulo) {
        try {
            Map parametros = new HashMap();
            parametros.put("diretorio", ArquivosImagens.diretorio_cenario());
            InputStream is = new FileInputStream(new File(ArquivosRelatorios.agendarTarefas()));
            JasperPrint jp = JasperFillManager.fillReport(is, parametros, new JRBeanCollectionDataSource(dispositivos));
            JRViewer jr = new JRViewer(jp);
            abrirAba(jr, titulo);
        } catch (FileNotFoundException | JRException ex) {
            MensagensErro.relatAgendamento(ex);
        }
    }

    public void gerarRelatorioLogAcoes(List<LogAcoesBean> dispositivos, String titulo) {
        try {
            Map parametros = new HashMap();
            parametros.put("diretorio", ArquivosImagens.diretorio_cenario());
            InputStream is = new FileInputStream(new File(ArquivosRelatorios.logAcoes()));
            JasperPrint jp = JasperFillManager.fillReport(is, parametros, new JRBeanCollectionDataSource(dispositivos));
            JRViewer jr = new JRViewer(jp);
            abrirAba(jr, titulo);
        } catch (FileNotFoundException | JRException ex) {
            MensagensErro.relatlogAcoes(ex);
        }
    }

    private void abrirAba(JRViewer jr, String titulo) {
        SwingUtil.adicionarTabComBotaoFechar(InstanciasTelas.getPrincipal().tb_principal, titulo, jr);
    }
    
}
