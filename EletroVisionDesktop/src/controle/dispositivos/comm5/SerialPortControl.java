
package controle.dispositivos.comm5;

import com.sun.jna.Library;

/**
 *
 * @author Wesllen Sousa Lima
 */
public interface SerialPortControl extends Library{
    
    /// IMPORTA: void RemoteSerialPort_init(int autoevent)
    /// Inicializa DLL. Deve ser chamado antes de qualquer outra função, preferencialmente na inicialização.
    /// Se autoevent for verdadeiro, a biblioteca utilizará Hooks para chamar periodicamente processEvents().
    /// Caso contrário, será necessário chamar a função processEvents() periodicamente para poder
    /// usar notificações (callbacks). 
    public void RemoteSerialPort_init(Integer autevent);
    
    /// IMPORTA: void* RemoteSerialPort_create( )  
    /// Cria um handle para uma porta serial remota. 
    /// Este handle é usado para referenciar esta instância nas outras funções da biblioteca.
    /// O handle criado deve ser destruído com destroy() para liberar os recursos.
    /// Obs. Para cada instância, ou seja, objeto gerado a partir desta classe é único e independe dos 
    /// outros objetos criados a partir da estância desta classe.
    /// De modo que, com esta classe, é possível conectar-se com multiplas portas de forma independente e
    /// simultânea.
    public Integer RemoteSerialPort_create();
    
    /// IMPORTA: void	RemoteSerialPort_destroy (void *handle)
    /// Destrói handle para porta serial remota.
    public void RemoteSerialPort_destroy(Integer handle);
    
    /// IMPORTA: int RemoteSerialPort_connect(void *handle, const char *host, unsigned short port)
    /// Abre uma conexão com uma porta serial remota especificada por host e port.
    /// Os parâmetros host e port são específicos para cada handle e são armazenados internamente.
    /// Isto permite chamar connect2() para conexões subsequentes à mesma porta,
    /// seja por desconexão voluntária ou não. 
    /// Outra maneira é através criação de multiplas estâncias desta classe. Onde cada objeto terá o
    /// seu próprio handle de conexão remota.
    public Integer RemoteSerialPort_connect(Integer handle, String IP, Integer port);
    
    /// IMPORTA: int RemoteSerialPort_waitForConnected(void *handle, unsigned int timeout)
    /// Aguarda conexão: ((-1) - Infinito, (0) - Desliga, (20) Recomendado).
    public Integer RemoteSerialPort_waitForConnected(Integer impl, Short timeout);
    
    /// IMPORTA: int RemoteSerialPort_isConnected (void *handle)
    /// Retorna um número diferente de zero, caso exista uma conexão estabelecida para o handle,
    /// e zero "0" caso não exista conexão uma estabelecida com o handle.
    public Integer RemoteSerialPort_isConnected(Integer impl);
    
    /// IMPORTA: void RemoteSerialPort_disconnect (void *handle)    
    /// Desconecta do servidor a conexão estabelecida com o handle específicado.
    public void RemoteSerialPort_disconnect(Integer impl);
    
    /// IMPORTA: int RemoteSerialPort_write(void *handle, char *data, int maxSize)
    /// Envia dados pela conexão remota.
    public Integer RemoteSerialPort_write(Integer impl, byte[] data, Integer maxsize);
    
    /// IMPORTA: RemoteSerialPort_waitForBytesWritten(void* handle)
    /// Aguarda que os dados sejão enviados.
    /// Este método deve ser executado após os método write.
    public Integer RemoteSerialPort_waitForBytesWritten(Integer handle, Integer maxTime);
    
    /// IMPORTA: int RemoteSerialPort_read(void* handle, char* data, int maxSize)
    /// Na dll original em C++, o método RemoteSerialPort_read(void* handle, char* data, int maxSize), 
    /// armazena no ponteiro "data" e fornece o tamanho maximo "maxSize".
    /// O método read(IntPtr impl), desta classe, lê os dados da porta serial, armazenando no ponteiro data.
    /// Retorna o bytes lidos. Esta função não bloqueia, e retorna imediatamente.
    public Integer RemoteSerialPort_read(Integer impl, Byte[] data, Integer maxsize);
    
    /// IMPORTA: int RemoteSerialPort_waitForReadyRead(void *handle, int maxTime)
    /// Aguarda até que dados estejam disponíveis para leitura na porta serial, 
    /// com um timeout maxTime em millisegundos. Se maxTime for -1, a função ignora o timeout. 
    public Integer RemoteSerialPort_waitForReadyRead(Integer handle, Integer maxTime);
    
    ///  IMPORTA: void RemoteSerialPort_processEvents() 
    /// Esta função deve ser chamada periodicamente para poder usar notificações de eventos.
    /// Se o sistema de notificação de eventos (callbacks) não for utilizado, não é preciso chamar esta função.
    public void RemoteSerialPort_processEvents();
    
    /// IMPORTA: int  RemoteSerialPort_setBaudRate(void *handle, int baud) 
    /// Altera a velocidade de comunicação da porta serial remota com o dispositivo serial.
    public void RemoteSerialPort_setBaudRate(Integer handle, Integer baud);
    
    /// IMPORTA: int RemoteSerialPort_setDataBits (void *handle, int bits) 
    /// Altera o número de bits de dados usado para comunicar com o dispositivo serial. 
    public void RemoteSerialPort_setDataBits(Integer handle, Integer bits);
    
    /// IMPORTA: void  RemoteSerialPort_finalize ()      
    /// Finaliza DLL. Deve ser chamado antes de descarregar a DLL, 
    /// para liberar recursos usados pela biblioteca.
    /// Pode ser executado com a finalização do aplicativo para liberar memória.
    public void RemoteSerialPort_finalize();
    
    /// IMPORTA: int RemoteSerialPort_connect2(void *handle)
    /// Cria um handle para uma segunda porta serial remota.
    /// O handle é usado para referenciar esta instancia nas outras funções da biblioteca. 
    /// Esta função permite definir no momento da criação o endereço e porta TCP da porta serial.
    /// O handle criado deve ser destruido com RemoteSerialPort_destroy() para liberar os recursos. 
    /// Obs.: Não é aconselhavel utilizar este método. 
    /// É possivel obter o mesmo efeito, de multiplas conexões,
    /// apenas estanciando o método connect(IntPtr impl, String IP, String porta).
    public Integer RemoteSerialPort_connect2(Integer handle);
    
    /// IMPORTA: int RemoteSerialPort_bytesAvailable(void *handle)
    /// Retorna o número de bytes, aguardando no buffer, de recebimento para leitura. 
    public Integer RemoteSerialPort_bytesAvailable(Integer handle);
    
    /// IMPORTA: int RemoteSerialPort_baudRate (void *handle)
    /// Retorna a velocidade atual de comunicação, baudrate
    ///a da porta serial remota, com o dispositivo serial.
    public Integer RemoteSerialPort_baudRate(Integer handle);
    
    /// IMPORTA: int RemoteSerialPort_stopBits (void *handle) 
    /// Retorna o número de bits de parada usado para comunicar com o dispositivo serial. 
    public Integer RemoteSerialPort_stopBits(Integer handle);
    
    /// IMPORTA: int RemoteSerialPort_setStopBits (void *handle, int bits)
    /// Altera o número de bits de parada usado para comunicar com o dispositivo serial. 
    public void RemoteSerialPort_setStopBits(Integer handle, Integer bits);
    
    /// IMPORTA: int  RemoteSerialPort_parity(void *handle)
    /// Retorna o tipo de paridade usada para comunicar com o dispositivo serial (0 - Nenhuma, 1 - Par, 2 - Ímpar). 
    public Integer RemoteSerialPort_parity(Integer handle);
    
    /// IMPORTA: int RemoteSerialPort_setParity (void *handle, int parity)
    /// Altera o tipo de paridade usada para comunicar com o dispositivo serial (0 - Nenhuma, 1 - Par, 2 - Ímpar). 
    public void RemoteSerialPort_setParity(Integer handle, Integer parity);
    
    /// IMPORTA: int RemoteSerialPort_flowControl(void *handle)
    /// Retorna o tipo de controle de fluxo usado para comunicar com o dispositivo serial. 
    /// (0 Nenhum, 1 Xon/Xoff, 2 Hardware).
    public Integer RemoteSerialPort_flowControl(Integer handle);
    
    /// IMPORTA: int RemoteSerialPort_setFlowControl (void *handle, int flowControl) 
    /// Altera o tipo de controle de fluxo usado para comunicar com o dispositivo serial. 
    public Integer RemoteSerialPort_setFlowControl(Integer handle, Integer flowControl);
    
    /// IMPORTA: void RemoteSerialPort_setRTS (void *handle, int enable)
    /// Ativa ou desativa o sinal RTS.
    /// Observação: Pode não ser suportado em todos os produtos. 
    /// (0 - disable, 1 - enable)
    public void RemoteSerialPort_setRTS(Integer handle, Integer estado);
    
    /// IMPORTA: void RemoteSerialPort_setDTR (void *handle, int enable)
    /// Ativa ou desativa o sinal DTR (0 - disable, 1 - enable).
    /// Observação: Pode não ser suportado em todos os produtos. 
    public void RemoteSerialPort_setDTR(Integer handle, Integer estado);
    
    /// IMPORTA: int RemoteSerialPort_lineStatus (void *handle) 
    ///Obtém o status das linhas de controle da porta serial, representados por um mapa de bits.
    ///Observação: Algumas linhas de sinal podem não ser suportados em todos os produtos.
    public Integer RemoteSerialPort_lineStatus(Integer handle);
    
}
