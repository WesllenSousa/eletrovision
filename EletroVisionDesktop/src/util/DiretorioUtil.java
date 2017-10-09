package util;

import recursos.internacionalizacao.MensagensSoltas;
import java.io.*;
import java.nio.channels.FileChannel;
import java.util.HashSet;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import recursos.instancias.InstanciasControle;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class DiretorioUtil {

    public static void criarDiretorioComArquivo(File arquivo) {
        if (arquivo.exists()) {
            if (InstanciasControle.getMensagens().confirmacao(MensagensSoltas.diretorioSubstituir())) {
                deletarDiretorio(arquivo);
            } else {
                return;
            }
        }
        arquivo.mkdirs();
    }

    public static void criarDiretorioComArquivoSemPerguntar(File arquivo) {
        if (arquivo.exists()) {
            deletarDiretorio(arquivo);
        }
        arquivo.mkdirs();
    }

    public static Boolean deletarDiretorioArquivo(File dirArq) {
        if (dirArq.isFile()) {
            return deletarArquivo(dirArq);
        } else if (dirArq.isDirectory()) {
            return deletarDiretorio(dirArq);
        }
        return false;
    }

    public static Boolean deletarDiretorio(File diretorio) {
        boolean result = true;
        if (diretorio.exists() && diretorio.isDirectory()) {
            File[] files = diretorio.listFiles();
            File file;
            for (int i = 0; i < files.length; i++) {
                file = files[i];
                if (file.isFile()) {
                    result = file.delete() && result;
                } else if (file.isDirectory()) {
                    result = deletarDiretorio(file) && result;
                }
            }
            result = diretorio.delete() && result;
        } else {
            result = false;
        }
        return result;
    }

    public static Boolean deletarArquivo(File file) {
        if (file.isFile()) {
            return file.delete();
        }
        return false;
    }

    public static Boolean deletarArquivosDiretorio(File diretorio) {
        boolean result = true;
        if (diretorio.exists() && diretorio.isDirectory()) {
            File[] files = diretorio.listFiles();
            File file;
            for (int i = 0; i < files.length; i++) {
                file = files[i];
                if (file.isFile()) {
                    result = file.delete() && result;
                } else if (file.isDirectory()) {
                    result = deletarDiretorio(file) && result;
                }
            }
        } else {
            result = false;
        }
        return result;
    }

    public static String extrairNomeArquivoDiretorio(String path) {
        String ArqDir = "";
        for (int i = (path.length() - 1); i >= 0; i--) {
            char caracter = path.charAt(i);
            if (caracter == '/' || caracter == '\\') {
                break;
            }
            ArqDir += caracter;
        }
        String r = "";
        for (int i = (ArqDir.length() - 1); i >= 0; i--) {
            char caracter = ArqDir.charAt(i);
            r += caracter;
        }
        return r;
    }

    public static HashSet<String> listarArquivosEDiretorio(File diretorio) {
        HashSet<String> hashSet = new HashSet<>();
        File[] arquivos = diretorio.listFiles();
        if (arquivos != null) {
            int length = arquivos.length;
            for (int i = 0; i < length; ++i) {
                File f = arquivos[i];
                if (f.isFile()) {
                    hashSet.add(f.getName());
                } else if (f.isDirectory()) {
                    hashSet.add(f.getName());
                }
            }
        }
        return hashSet;
    }

    public static HashSet<String> listarDiretorios(File diretorio) {
        HashSet<String> hashSet = new HashSet<>();
        File[] arquivos = diretorio.listFiles();
        if (arquivos != null) {
            int length = arquivos.length;
            for (int i = 0; i < length; ++i) {
                File f = arquivos[i];
                if (f.isDirectory()) {
                    hashSet.add(f.getName());
                }
            }
        }
        return hashSet;
    }

    public static HashSet<String> listarArquivos(File diretorio) {
        HashSet<String> hashSet = new HashSet<>();
        File[] arquivos = diretorio.listFiles();
        if (arquivos != null) {
            int length = arquivos.length;
            for (int i = 0; i < length; ++i) {
                File f = arquivos[i];
                if (f.isFile()) {
                    hashSet.add(f.getName());
                }
            }
        }
        return hashSet;
    }

    public static Boolean verificarDiretorioExiste(File file) {
        if (file.exists()) {
            return true;
        } else {
            return false;
        }
    }

    public static Boolean verificarSeArquivoDiretorioExiste(File file) {
        if (file.exists()) {
            if (InstanciasControle.getMensagens().confirmacao(MensagensSoltas.diretorioSubstituir())) {
                return true;
            } else {
                return false;
            }
        }
        return true;
    }

    public static TreeNode listarArquivosEDiretorioJTree(DefaultMutableTreeNode raiz, File diretorio) {
        File[] files = diretorio.listFiles();
        File file;
        for (int i = 0; i < files.length; i++) {
            file = files[i];
            if (file.isFile()) {
                DefaultMutableTreeNode filho = new DefaultMutableTreeNode(file.getName());
                filho.setAllowsChildren(false);
                raiz.add(filho);
            } else if (file.isDirectory()) {
                DefaultMutableTreeNode filho = new DefaultMutableTreeNode(file.getName());
                raiz.add(filho);
                listarArquivosEDiretorioJTree(filho, file);
            }
        }
        return raiz;
    }

    public static String extensaoArquivo(String arquivo) {
        return arquivo.substring(arquivo.lastIndexOf('.') + 1);
    }

    public static void copiarArquivo(String origem, String destino) {
        try {
            FileChannel o = new FileInputStream(new File(origem)).getChannel();
            FileChannel d = new FileOutputStream(new File(destino)).getChannel();
            d.transferFrom(o, 0, o.size());
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public static Integer contarArquivos(File diretorio) {
        Integer cont = 0;
        File[] arquivos = diretorio.listFiles();
        if (arquivos != null) {
            int length = arquivos.length;
            for (int i = 0; i < length; ++i) {
                File f = arquivos[i];
                if (f.isFile()) {
                    cont++;
                }
            }
        }
        return cont;
    }

    public static Boolean gravarArquivoTxt(String texto, File diretorio) {
        byte bytes[] = texto.getBytes(); 
        try (FileOutputStream local = new FileOutputStream(diretorio)) {
            local.write(bytes);
            return true;
        } catch (IOException ex) {
            return false;
        }   
    }
    
}
