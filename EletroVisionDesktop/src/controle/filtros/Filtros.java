package controle.filtros;

import com.jhlabs.image.*;
import java.awt.image.BufferedImage;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class Filtros {

    private BufferedImage bufferFiltro;

    public Filtros() {
    }

    //Contraste: entre 0.0 e 2.0
    public BufferedImage contraste(BufferedImage bufferNormal, Float intensidade, Float brightness) {
        ContrastFilter filtro = new ContrastFilter();
        filtro.setContrast(intensidade);
        filtro.setBrightness(brightness);
        return filtro.filter(bufferNormal, bufferFiltro);
    }

    //Angle: entre 0 e 360, transition: entre 0 e 1
    public BufferedImage dobrar(BufferedImage bufferNormal, Float angulo, Float transition) {
        CurlFilter filtro = new CurlFilter();
        filtro.setAngle(angulo);
        filtro.setTransition(transition);
        return filtro.filter(bufferNormal, bufferFiltro);
    }

    //setExposure: 0 a 5
    public BufferedImage exposicaoLuz(BufferedImage bufferNormal, Float exposicao) {
        ExposureFilter filtro = new ExposureFilter();
        filtro.setExposure(exposicao);
        return filtro.filter(bufferNormal, bufferFiltro);
    }

    //gain: 0 a 100, bias 0 a 100
    public BufferedImage adicao(BufferedImage bufferNormal, Integer adicao, Integer polarizacao) {
        GainFilter filtro = new GainFilter();
        filtro.setGain(adicao);
        filtro.setBias(polarizacao);
        return filtro.filter(bufferNormal, bufferFiltro);
    }

    //gamma: 0 a 3
    public BufferedImage gamma(BufferedImage bufferNormal, Float gamma) {
        GammaFilter filtro = new GammaFilter();
        filtro.setGamma(gamma);
        return filtro.filter(bufferNormal, bufferFiltro);
    }

    public BufferedImage escalaCinza(BufferedImage bufferNormal) {
        GrayscaleFilter filtro = new GrayscaleFilter();
        return filtro.filter(bufferNormal, bufferFiltro);
    }

    public BufferedImage hsba(BufferedImage bufferNormal, Float cor, Float saturacao, Float brilho) {
        HSBAdjustFilter filtro = new HSBAdjustFilter();
        filtro.setHFactor(cor);
        filtro.setSFactor(saturacao);
        filtro.setBFactor(brilho);
        return filtro.filter(bufferNormal, bufferFiltro);
    }

    public BufferedImage inverter(BufferedImage bufferNormal) {
        InvertFilter filtro = new InvertFilter();
        return filtro.filter(bufferNormal, bufferFiltro);
    }

    //todos os valores: entre 0 e 1.
    public BufferedImage niveis(BufferedImage bufferNormal, Float nivelAlto, Float nivelBaixo, Float nivelSaidaAlto, Float nivelSaidaBaixo) {
        LevelsFilter filtro = new LevelsFilter();
        filtro.setHighLevel(nivelAlto);
        filtro.setLowLevel(nivelBaixo);
        filtro.setHighOutputLevel(nivelSaidaAlto);
        filtro.setLowOutputLevel(nivelSaidaBaixo);
        return filtro.filter(bufferNormal, bufferFiltro);
    }

    //niveis: 1 a 100.
    public BufferedImage posterizar(BufferedImage bufferNormal, Integer niveis) {
        PosterizeFilter filtro = new PosterizeFilter();
        filtro.setNumLevels(niveis);
        return filtro.filter(bufferNormal, bufferFiltro);
    }

    //scala: 0 a 5
    public BufferedImage rescalar(BufferedImage bufferNormal, Float scala) {
        RescaleFilter filtro = new RescaleFilter();
        filtro.setScale(scala);
        return filtro.filter(bufferNormal, bufferFiltro);
    }

    public BufferedImage rgb(BufferedImage bufferNormal, Float r, Float g, Float b) {
        RGBAdjustFilter filtro = new RGBAdjustFilter();
        filtro.setRFactor(r);
        filtro.setGFactor(g);
        filtro.setBFactor(b);
        return filtro.filter(bufferNormal, bufferFiltro);
    }

    public BufferedImage solarizar(BufferedImage bufferNormal) {
        SolarizeFilter filtro = new SolarizeFilter();
        return filtro.filter(bufferNormal, bufferFiltro);
    }

    public BufferedImage thresholding(BufferedImage bufferNormal, Integer altoThresholding, Integer baixoThresholding) {
        ThresholdFilter filtro = new ThresholdFilter();
        filtro.setUpperThreshold(altoThresholding);
        filtro.setLowerThreshold(baixoThresholding);
        return filtro.filter(bufferNormal, bufferFiltro);
    }

    //escala: 1 a 100, borda 0 a 2
    public BufferedImage misturar(BufferedImage bufferNormal, Float escala, Integer borda) {
        DiffuseFilter filtro = new DiffuseFilter();
        filtro.setScale(escala);
        filtro.setEdgeAction(borda);
        return filtro.filter(bufferNormal, bufferFiltro);
    }

    //qtde: 0 a 100
    public BufferedImage vidro(BufferedImage bufferNormal, Integer qtde, Integer borda) {
        DisplaceFilter filtro = new DisplaceFilter();
        filtro.setAmount(qtde);
        filtro.setEdgeAction(borda);
        return filtro.filter(bufferNormal, bufferFiltro);
    }

    public BufferedImage rotacao(BufferedImage bufferNormal, Integer operacao) {
        FlipFilter filtro = new FlipFilter();
        filtro.setOperation(operacao);
        return filtro.filter(bufferNormal, bufferFiltro);
    }

    public BufferedImage marmore(BufferedImage bufferNormal, Float scala, Float qtde, Float turbulencia, Integer borda) {
        MarbleFilter filtro = new MarbleFilter();
        filtro.setXScale(scala);
        filtro.setAmount(qtde);
        filtro.setTurbulence(turbulencia);
        filtro.setEdgeAction(borda);
        return filtro.filter(bufferNormal, bufferFiltro);
    }

    public BufferedImage cromar(BufferedImage bufferNormal, Float softness, Float altura, Float qtde, Float exposicao) {
        ChromeFilter filtro = new ChromeFilter();
        filtro.setBumpSoftness(softness);
        filtro.setBumpHeight(altura);
        filtro.setAmount(qtde);
        filtro.setExposure(exposicao);
        return filtro.filter(bufferNormal, bufferFiltro);
    }

    public BufferedImage relevo(BufferedImage bufferNormal, Float angulo, Float elevacao, Float intesidade) {
        EmbossFilter filtro = new EmbossFilter();
        filtro.setEmboss(false);
        filtro.setAzimuth(angulo);
        filtro.setElevation(elevacao);
        filtro.setBumpHeight(intesidade);
        return filtro.filter(bufferNormal, bufferFiltro);
    }

    public BufferedImage sobel(BufferedImage bufferNormal) {
        EdgeFilter filtro = new EdgeFilter();
        return filtro.filter(bufferNormal, bufferFiltro);
    }

}
