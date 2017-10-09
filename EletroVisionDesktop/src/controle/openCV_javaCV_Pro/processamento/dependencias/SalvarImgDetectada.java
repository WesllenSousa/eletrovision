
package controle.openCV_javaCV_Pro.processamento.dependencias;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Calendar;
import util.DataUtil;
import util.DiretorioUtil;
import util.ImagemUtil;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class SalvarImgDetectada {
    
    private static String diretorioParcial;
    
    public String salvarImagem(BufferedImage imagem, String diretorio){
        String dir = criarDiretorios(diretorio).getAbsolutePath();       
        String nomeImagem = diretorioParcial+System.currentTimeMillis()+".png";
        File arquivo = new File(dir+File.separator+System.currentTimeMillis()+".png");
        ImagemUtil.salvar(imagem, arquivo);
        return nomeImagem;
    }
    
    public String salvarImagem(Image imagem, String diretorio) {
        String dir = criarDiretorios(diretorio).getAbsolutePath();   
        String nomeImagem = diretorioParcial+System.currentTimeMillis()+".png";
        File arquivo = new File(dir+File.separator+System.currentTimeMillis()+".png");
        ImagemUtil.salvar(ImagemUtil.imageParaBufferedImage(imagem, Boolean.TRUE), arquivo);
        return nomeImagem;
    }
    
    public File criarDiretorios(String diretorio) {
        String s_ano = DataUtil.formataAno(Calendar.getInstance());
        File ano = new File(diretorio+File.separator+s_ano);
        if(!DiretorioUtil.verificarDiretorioExiste(ano)){
            DiretorioUtil.criarDiretorioComArquivo(ano);
        }
        String s_mes = DataUtil.formataMes(Calendar.getInstance());
        File mes = new File(ano.getAbsolutePath()+File.separator+s_mes);
        if(!DiretorioUtil.verificarDiretorioExiste(mes)){
            DiretorioUtil.criarDiretorioComArquivo(mes);
        }
        String s_dia = DataUtil.formataDia(Calendar.getInstance());
        File dia = new File(mes.getAbsolutePath()+File.separator+s_dia); 
        if(!DiretorioUtil.verificarDiretorioExiste(dia)){
            DiretorioUtil.criarDiretorioComArquivo(dia);
        }
        String s_horaMinuto = DataUtil.formataHora(Calendar.getInstance())+"-00";
        File horaMinuto = new File(dia.getAbsolutePath()+File.separator+s_horaMinuto); 
        if(!DiretorioUtil.verificarDiretorioExiste(horaMinuto)){
            DiretorioUtil.criarDiretorioComArquivo(horaMinuto);
        }
        diretorioParcial = File.separator+s_ano+File.separator+s_mes+File.separator+s_dia+File.separator+s_horaMinuto+File.separator;
        return horaMinuto;
    }
    
}
