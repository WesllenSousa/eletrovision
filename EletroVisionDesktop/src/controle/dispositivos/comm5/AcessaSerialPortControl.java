
/// A sequência de conexão é:
/// 1) init();
/// 2) impl = create(); 
/// 3) connect(IntPtr impl, String IP, String porta);
/// 4) waitForConnected(IntPtr impl, ushort timeout);
/// 5) isConnected(IntPtr impl);
/// Para escrever: 
/// 6) isConnected(IntPtr impl);
/// 7) b) writeString(IntPtr impl, String mensagem);
///    c) writeByte(IntPtr impl, byte[] mensagem);
/// Para Ler: 
/// 8) isConnected(IntPtr impl);
/// 9) read(IntPtr impl);
/// 10)waitForReadyRead(IntPtr impl);
/// Para desconectar e destruir o handle:
/// 11)isConnected(IntPtr impl);
/// 12)disconnect(IntPtr impl)
/// 13)isConnected(IntPtr impl);
/// 14) destroy(IntPtr impl);

package controle.dispositivos.comm5;

import com.sun.jna.Native;
import recursos.configuracoes.diretorios.caminhos.ArquivosConfiguracao;
import recursos.instancias.InstanciasControle;
import recursos.internacionalizacao.MensagensSoltas;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class AcessaSerialPortControl {
    
    private byte[] buffer;
    private SerialPortControl dll;
    private Integer impl;
    
    public AcessaSerialPortControl(){
        try {
            dll = (SerialPortControl) Native.loadLibrary(ArquivosConfiguracao.serialPortControl().getAbsolutePath(), SerialPortControl.class);
            buffer = new byte[256];
        } catch (UnsatisfiedLinkError ex) {
            InstanciasControle.getMensagens().bug(MensagensSoltas.conexaoErroModuloAcionamento(ex.toString()));
        } 
    }
    
    public void init(){
        dll.RemoteSerialPort_init(1);
    }
    
    public Integer create(){
        return dll.RemoteSerialPort_create();
    }
    
    public void destroy(){
        dll.RemoteSerialPort_destroy(impl);
    }
    
    public Integer connect(String IP, Integer porta){
        return dll.RemoteSerialPort_connect(impl, IP, porta);
    }
    
    public Integer waitForConnected(Short timeout){
        return dll.RemoteSerialPort_waitForConnected(impl, timeout);
    }
    
    public Integer isConnected(){
        return dll.RemoteSerialPort_isConnected(impl);
    }
    
    public void disconnect(){
        dll.RemoteSerialPort_disconnect(impl);
    }
    
    public void writeString(String mensagem){
        buffer = mensagem.getBytes();
        dll.RemoteSerialPort_write(impl, buffer, buffer.length);
    }
    
    public Integer waitForBytesWritten(Integer maxTime){
        return dll.RemoteSerialPort_waitForBytesWritten(impl, maxTime);
    }
    
//---------------------------------------------------------------------    

    public Integer getImpl() {
        return impl;
    }

    public void setImpl(Integer impl) {
        this.impl = impl;
    }
    
}
