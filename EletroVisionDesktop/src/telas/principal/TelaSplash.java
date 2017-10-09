package telas.principal;

import recursos.configuracoes.diretorios.caminhos.ArquivosImagens;
import recursos.configuracoes.sistema.ConfigCores;
import java.awt.Color;
import java.awt.Dimension;
import java.lang.reflect.InvocationTargetException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;

import recursos.internacionalizacao.MensagensSoltas;

/**
 *
 * @author Wesllen Sousa Lima 
 */
public class TelaSplash extends JWindow {
    
    private JProgressBar barraProgresso;

    public TelaSplash() {
        super();  
        setSize(460, 200);
        Dimension dim = getToolkit().getScreenSize();
        setLocation(dim.width / 2 - getWidth() / 2, dim.height / 2 - getHeight() / 2);
        
        getContentPane().setLayout(null);
        setBackground(ConfigCores.transparente());

        //componentes.
        JLabel logotipo = new JLabel(new ImageIcon(getClass().getResource(ArquivosImagens.logo_nome())));
        JLabel inicializacao = new JLabel(MensagensSoltas.comumInicializando());
        barraProgresso = new JProgressBar(0, 150);
        JLabel autor = new JLabel(MensagensSoltas.comumProduzidoPor());
        JLabel copyright = new JLabel(MensagensSoltas.comumDireitos());

        //bounds.
        logotipo.setBounds(5, 40, 450, 100);
        inicializacao.setBounds(5,150, 300, 20);
        barraProgresso.setBounds(0,170,460,10);
        autor.setBounds(3,175,400,30);
        copyright.setBounds(280, 175, 400, 30);

        //cores
        autor.setForeground(Color.DARK_GRAY);
        inicializacao.setForeground(Color.DARK_GRAY);
        
        barraProgresso.setBackground(ConfigCores.azul());
        barraProgresso.setForeground(ConfigCores.verde());
 
        //adiciona ao window.
        getContentPane().add(logotipo);
        getContentPane().add(inicializacao);
        getContentPane().add(barraProgresso);
        getContentPane().add(autor);
        getContentPane().add(copyright);
        
        setVisible(true);
    }
    
    public void atualizarBarraProgresso(Integer valor){
        barraProgresso.setValue(valor);
    }

    public void close() throws InterruptedException, InvocationTargetException {
        Runnable closerRunner = new Runnable() {
            @Override
            public void run() {
                setVisible(false);
                dispose();
            }
        };
        SwingUtilities.invokeAndWait(closerRunner);
    }
    
}
