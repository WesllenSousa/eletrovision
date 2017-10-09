/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle.dispositivos;

import entidades.moduloAcionamento.bean.ModuloAcionamentoBean;

/**
 *
 * @author Wesllen Sousa
 */
public interface ManageDevice {
    
    public void init();
    public void connect();
    public void disconnect();
    public Boolean turnOn(Integer porta);
    public Boolean turnOff(Integer porta);
    public void waitShort();
    public Boolean isConnected();
    public ModuloAcionamentoBean getModuloAcionamento();
            
}
