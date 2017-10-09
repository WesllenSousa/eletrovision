
package recursos.internacionalizacao;

import java.io.PrintWriter;
import java.io.StringWriter;
import telas.comuns.telas.Erro;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class MensagensErro {
    
/*-----------------MAIN-------------------------------------------------------*/
    
    public static void lookAndFeel(Exception ex) {
        mensagem("Erro ao carregar LookAndFeel!\n", obterErroCompleto(ex));
    }
    
    public static void raiz(Exception ex) {
        mensagem("Erro ao obter raiz!\n", obterErroCompleto(ex));
    }
    
    public static void main(Exception ex) {
        mensagem("Erro ao chamar main!\n", obterErroCompleto(ex));
    }
    
/*-----------------AUDIO------------------------------------------------------*/
    
    public static void audio(Exception ex) {
        mensagem("Erro ao executar aúdio: \n", obterErroCompleto(ex));
    }
    
/* -----------------------CONFIGURAÇÕES---------------------------------------*/
    
    public static void arquivosPropertiesSalvar(Exception ex) {
        mensagem("Erro ao salvar arquivo de configuração!\n", obterErroCompleto(ex));
    }
    
    public static void arquivosPropertiesLer(Exception ex) {
        mensagem("Erro ao ler arquivo de configuração!\n", obterErroCompleto(ex));
    }
    
    public static void xmlDocumento(Exception ex) {
        mensagem("Erro ao criar documento xml!\n", obterErroCompleto(ex));
    }
    
    public static void xmlCarregar(Exception ex) {
        mensagem("Erro ao carregar documento xml!\n", obterErroCompleto(ex));
    }
    
    public static void xmlGravar(Exception ex) {
        mensagem("Erro ao gravar documento xml!\n", obterErroCompleto(ex));
    }
    
 /* -----------------------EXPIÃO---------------------------------------------*/
    
    public static void expiaoIniciar(Exception ex) {
        mensagem("Erro ao iniciar o Expião!\n", obterErroCompleto(ex));
    }
    
/* -----------------------MENSAGENS-------------------------------------------*/
    
    public static void serialToGsmEnviar(Exception ex) {
        mensagem("Erro ao enviar Mensagem - possíveis causas: \n"
                + " 1) Verificar se o modem está conectado. \n"
                + " 2) Verificar se a porta do modem está configurada corretamente.\n", obterErroCompleto(ex));
    }
    
    public static void serialToGsmFechar(Exception ex) {
        mensagem("Erro ao fechar Fluxo de entrada!\n", obterErroCompleto(ex));
    }
    
    public static void emailOrigem(Exception ex) {
        mensagem("Erro configurar origem do email!\n", obterErroCompleto(ex));
    }
    
    public static void emailDestino(Exception ex) {
        mensagem("Erro configurar destino do email!\n", obterErroCompleto(ex));
    }
    
    public static void emailAnexo(Exception ex) {
        mensagem("Erro ao anexar arquivo no email!\n", obterErroCompleto(ex));
    }
    
    public static void emailHtml(Exception ex) {
        mensagem("Erro ao montar HTML no email!\n", obterErroCompleto(ex));
    }
    
/* ------------------------CÂMERAS--------------------------------------------*/
    
    public static void cameraGravar(Exception ex) {
        mensagem("Erro ao iniciar gravação!\n", obterErroCompleto(ex));
    }
    
    public static void cameraParar(Exception ex) {
        mensagem("Erro ao parar câmera!\n", obterErroCompleto(ex));
    }
    
    public static void cameraIniciar(Exception ex) {
        mensagem("Erro ao iniciar câmera!\n", obterErroCompleto(ex));
    }
    
    public static void cameraPararGravacao(Exception ex) {
        mensagem("Erro ao parar gravação!\n", obterErroCompleto(ex));
    }
    
    public static void cameraProcessarGravacao(Exception ex) {
        mensagem("Erro ao gravar, CODEC inválido!\n", obterErroCompleto(ex));
    }
    
    public static void detectarCorpo(Exception ex) {
        mensagem("Erro ao detectar Corpo!\n", obterErroCompleto(ex));
    }
    
    public static void detectarFace(Exception ex) {
        mensagem("Erro ao detectar Face!\n", obterErroCompleto(ex));
    }
    
    public static void detectarObjeto(Exception ex) {
        mensagem("Erro ao detectar objeto!\n", obterErroCompleto(ex));
    }
    
    public static void detectarOlhos(Exception ex) {
        mensagem("Erro ao detectar olhos!\n", obterErroCompleto(ex));
    }
    
 /* -----------------------VÍDEOS---------------------------------------------*/
    
    public static void videoIniciar(Exception ex) {
        mensagem("Erro ao iniciar vídeo!\n", obterErroCompleto(ex));
    }
    
    public static void videoParar(Exception ex) {
        mensagem("Erro ao parar vídeo!\n", obterErroCompleto(ex));
    }
    
 /* --------------------SHEDULER AGENDAR TAREFAS------------------------------*/
    
    public static void shedulerExecutarTarefas(Exception ex) {
        mensagem("Erro ao executar tarefas do sistema!\n", obterErroCompleto(ex));
    }
    
    public static void shedulerJob(Exception ex) {
        mensagem("Erro Sheduler Job!\n", obterErroCompleto(ex));
    }
    
    public static void shedulerReiniciar(Exception ex) {
        mensagem("Erro ao reiniciar a sheduler!\n", obterErroCompleto(ex));
    }
    
 /* --------------------REDES-------------------------------------------------*/
    
    public static void redeConfigurar(Exception ex) {
        mensagem("Erro ao configurar EntradaSaida!\n", obterErroCompleto(ex));
    }
    
    public static void redeProcessar(Exception ex) {
        mensagem("Erro ao processar mensagem!\n", obterErroCompleto(ex));
    }
    
    public static void redeFechar(Exception ex) {
        mensagem("Erro ao fechar conexão!\n", obterErroCompleto(ex));
    }
    
    public static void redeEnviarDados(Exception ex) {
        mensagem("Erro ao enviar dados!\n", obterErroCompleto(ex));
    }
    
/* ------------------RECURSOS-------------------------------------------------*/
    
    public static void backupPGdump(Exception ex) {
        mensagem("Erro ao executar PG DUMP!\n", obterErroCompleto(ex));
    }
    
/* ------------------UTIL-----------------------------------------------------*/
    
    public static void conexaoJDBCconectar(Exception ex) {
        mensagem("Erro na conexão JDBC!\n", obterErroCompleto(ex));
    }
    
    public static void conexaoJDBCfechar(Exception ex) {
        mensagem("Erro ao fechar conexão JDBC!\n", obterErroCompleto(ex));
    }
    
    public static void conexaoJDBCsql(Exception ex) {
        mensagem("Erro ao executar sql JDBC!\n", obterErroCompleto(ex));
    }
    
    public static void criptografiaAlgoritmo(Exception ex) {
        mensagem("Erro ao carregar algoritmo de criptografia!\n", obterErroCompleto(ex));
    }
    
    public static void imagemUtilErro(Exception ex) {
        mensagem("ImagemUtil\n", obterErroCompleto(ex));
    }
    
    public static void redeUtilErro(Exception ex) {
        mensagem("Erro ao recuperar IP da rede!\n", obterErroCompleto(ex));
    }
    
    public static void redeMac(Exception ex) {
        mensagem("Erro ao obter endereço mac da máquina!\n", obterErroCompleto(ex));
    }
    
/* ------------------TELAS COMUNS---------------------------------------------*/
    
    public static void comumHtml(Exception ex) {
        mensagem("Erro ao carregar HTML!\n", obterErroCompleto(ex));
    }
    
/* ------------------RELATORIOS-----------------------------------------------*/
    
    public static void relatPessoa(Exception ex) {
        mensagem("Erro ao gerar relatório de pessoa!\n", obterErroCompleto(ex));
    }
    
    public static void relatMensagem(Exception ex) {
        mensagem("Erro ao gerar relatório de mensagem!\n", obterErroCompleto(ex));
    }
    
    public static void relatPredio(Exception ex) {
        mensagem("Erro ao gerar relatório do Prédio!\n", obterErroCompleto(ex));
    }
    
    public static void relatMovimentos(Exception ex) {
        mensagem("Erro ao gerar relatório de Movimentos!\n", obterErroCompleto(ex));
    }
    
    public static void relatDispositivos(Exception ex) {
        mensagem("Erro ao gerar relatório de Dispositivos!\n", obterErroCompleto(ex));
    }
    
    public static void relatAgendamento(Exception ex) {
        mensagem("Erro ao gerar relatório de Agendamento de Tarefas!\n", obterErroCompleto(ex));
    }
    
    public static void relatlogAcoes(Exception ex) {
        mensagem("Erro ao gerar relatório de Log de Ações!\n", obterErroCompleto(ex));
    }
    
/*----------------------------------------------------------------------------*/
    
    private static String obterErroCompleto(Exception ex) {
        String erro = ex.toString()+"\n";
        StringWriter sw = new StringWriter();
        new Throwable("").printStackTrace(new PrintWriter(sw));
        erro += sw.toString();
        return erro;
    }
    
    private static void mensagem(final String titulo, final String detalhe) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Erro dialog = new Erro(null, true, titulo, detalhe); 
                dialog.setVisible(true); 
            }
        }).start();       
    }
    
}
