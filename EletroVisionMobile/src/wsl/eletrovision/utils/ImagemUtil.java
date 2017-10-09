package wsl.eletrovision.utils;

import java.io.*;

public class ImagemUtil {

    public static byte[] imagemParaByte(String arquivo) {
        FileInputStream fileInputStream = null;
        byte[] bytes = null;
        try {
            File file = new File(arquivo);
            fileInputStream = new FileInputStream(file);
            int tamanho = (int) (file.length() + 1);
            bytes = new byte[tamanho];
            fileInputStream.read(bytes);     
        } catch (IOException ex) {
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException ex) {
            }
        }
        return bytes;
    }
    
    public static byte[] lerBytesImagem(InputStream in) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len;
        while ((len = in.read(buffer)) > 0) {
            bos.write(buffer, 0, len);
        }
        byte[] bytes = bos.toByteArray();
        return bytes;
    }
    
    public void receberSalvarImagemRede(ObjectInputStream entrada, String arquivo) {
        FileOutputStream file = null;
        try {
            byte[] bytes = new byte[1024];
            DataInputStream data = new DataInputStream(entrada);
            file = new FileOutputStream(arquivo);
            int leitura = data.read(bytes);
            while(leitura != -1) {
                if(leitura != -2) {
                    file.write(bytes, 0, leitura);
                }
                leitura = data.read(bytes);
            }
        } catch (IOException ex) {
        } finally {
            try {
                file.close();
            } catch (IOException ex) {
            }
        }
    }
    
    public void enviarLerImagemRede(ObjectOutputStream saida, String arquivo) {
        FileInputStream file = null;
        try {
            byte[] bytes = new byte[1024];
            file = new FileInputStream(arquivo);
            DataInputStream data = new DataInputStream(file);
            int leitura = data.read(bytes);
            while(leitura != -1) {
                if(leitura != -2) {
                    saida.write(bytes, 0, leitura);
                }
                leitura = data.read(bytes);
            }
        } catch (IOException ex) {
        } finally {
            try {
                file.close();
            } catch (IOException ex) {
            }
        }
    }
    
}
