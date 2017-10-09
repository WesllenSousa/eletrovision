package telas.comuns.html;

import java.awt.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.io.*;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.SwingUtilities;
import javax.swing.text.*;
import javax.swing.event.*;
import recursos.internacionalizacao.MensagensErro;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class HtmlPane extends JScrollPane implements HyperlinkListener {

    private JEditorPane html;

    public HtmlPane(String index) {
        try {
            File file = new File(index);
            String fileAbsolutePath = file.getAbsolutePath();
            fileAbsolutePath = "file:" + fileAbsolutePath;
            html = new JEditorPane(fileAbsolutePath);
            html.setEditable(false);
            html.addHyperlinkListener(HtmlPane.this);

            JViewport vp = getViewport();
            vp.add(html); 
            revalidate();
        } catch (MalformedURLException e) {
            MensagensErro.comumHtml(e);
        } catch (IOException e) {
            MensagensErro.comumHtml(e);
        }
    }

    @Override
    public void hyperlinkUpdate(HyperlinkEvent e) {
        if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
            linkActivated(e.getURL());
        }
    }

    protected void linkActivated(URL u) {
        Cursor c = html.getCursor();
        Cursor waitCursor = Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR);
        html.setCursor(waitCursor);
        SwingUtilities.invokeLater(new PageLoader(u, c));
    }

    class PageLoader implements Runnable {
        PageLoader(URL u, Cursor c) {
            url = u;
            cursor = c;
        }
        
        @Override
        public void run() {
            if (url == null) {
                html.setCursor(cursor);
                Container parent = html.getParent();
                parent.repaint();
            } else {
                Document doc = html.getDocument();
                try {
                    html.setPage(url);
                } catch (IOException ioe) {
                    html.setDocument(doc);
                    getToolkit().beep();
                } finally {
                    url = null;
                    SwingUtilities.invokeLater(this);
                }
            }
        }
        URL url;
        Cursor cursor;
    }
    
}
