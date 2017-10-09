package controle.dispositivos;

import entidades.dispositivoEletrico.bean.DispositivoEletricoBean;
import entidades.dispositivoEletrico.bean.EnumDuracaoDispositivoEletrico;
import entidades.dispositivoEletrico.bean.EnumLigarDesligarDispositivoEletrico;
import entidades.dispositivoEletrico.facade.DispositivoEletricoFacade;
import recursos.instancias.InstanciasControle;
import telas.principal.AtualizaTelas;
import util.FacadeException;
import util.FactoryFacade;

/**
 *
 * @author Wesllen
 */
public class AcionarDispositivo {

    public static Boolean ligarDispositivo(DispositivoEletricoBean dp) {
        if (InstanciasControle.getGerenciarAcionamentos() != null) {
            for (GerenciarAcionamento modulo : InstanciasControle.getGerenciarAcionamentos()) {
                if (dp.getModuloAcionamento().getCodigo() == modulo.getGerente().getModuloAcionamento().getCodigo()) {
                    return ligar(modulo, dp);
                }
            }
        }
        return false;
    }

    private static Boolean ligar(GerenciarAcionamento modulo, DispositivoEletricoBean dp) {
        if (dp.getLigarDesligar() == EnumLigarDesligarDispositivoEletrico.DESLIGADO) {
            if (dp.getDuracao() == EnumDuracaoDispositivoEletrico.PERMANENTE) {
                if (modulo.getGerente().turnOn(Integer.parseInt(dp.getIdentificacao()))) {
                    dp.setLigarDesligar(EnumLigarDesligarDispositivoEletrico.LIGADO);
                    alterarDispositivoEletrico(dp);
                    AtualizaTelas.geralMapaDispositivos();
                    return true;
                }
            } else if (dp.getDuracao() == EnumDuracaoDispositivoEletrico.CURTO) {
                modulo.getGerente().turnOn(Integer.parseInt(dp.getIdentificacao()));
                modulo.getGerente().waitShort();
                modulo.getGerente().turnOff(Integer.parseInt(dp.getIdentificacao()));
                return true;
            }
        }
        return false;
    }

    public static Boolean desligarDispositivo(DispositivoEletricoBean dp) {
        if (InstanciasControle.getGerenciarAcionamentos() != null) {
            for (GerenciarAcionamento modulo : InstanciasControle.getGerenciarAcionamentos()) {
                if (dp.getModuloAcionamento().getCodigo() == modulo.getGerente().getModuloAcionamento().getCodigo()) {
                    return desligar(modulo, dp);
                }
            }
        }
        return false;
    }

    private static Boolean desligar(GerenciarAcionamento modulo, DispositivoEletricoBean dispositivoEletrico) {
        if (dispositivoEletrico.getLigarDesligar() == EnumLigarDesligarDispositivoEletrico.LIGADO) {
            if (modulo.getGerente().turnOff(Integer.parseInt(dispositivoEletrico.getIdentificacao()))) {
                dispositivoEletrico.setLigarDesligar(EnumLigarDesligarDispositivoEletrico.DESLIGADO);
                alterarDispositivoEletrico(dispositivoEletrico);
                AtualizaTelas.geralMapaDispositivos();
                return true;
            }
        }
        return false;
    }

    private static void alterarDispositivoEletrico(DispositivoEletricoBean bean) {
        DispositivoEletricoFacade dispositivoEletricoFacade = FactoryFacade.getDispositivoEletricoImpl();
        try {
            dispositivoEletricoFacade.alterar(bean);
        } catch (FacadeException ex) {
        }
    }

}
