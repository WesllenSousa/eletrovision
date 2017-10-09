/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package recursos.configuracoes.xml;

import recursos.configuracoes.diretorios.caminhos.ArquivosConfiguracao;
import recursos.internacionalizacao.MensagensErro;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import recursos.instancias.InstanciasControle;

/**
 *
 * @author wesllen
 */
public class ManipulaDocumentoXML {
    
    private DocumentBuilderFactory documentBuilderFactory = null;
    private DocumentBuilder documentBuilder = null;
    
    public ManipulaDocumentoXML(){
        try {
            documentBuilderFactory = DocumentBuilderFactory.newInstance();
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException ex) {
            MensagensErro.xmlDocumento(ex);
        }
    }
    
    public Document obterDocumentoXML(File caminho){
        try {
            return documentBuilder.parse(caminho);
        } catch (SAXException | IOException ex) {
            MensagensErro.xmlCarregar(ex);
        }
        return null;
    }
    
    public void gravarXML(Document doc) {
        try {
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new FileOutputStream(ArquivosConfiguracao.hibernate()));
            TransformerFactory transFactory = TransformerFactory.newInstance();
            Transformer transformer = transFactory.newTransformer();
            transformer.transform(source, result);
            
            InstanciasControle.getMensagens().sucesso("Arquivo xml salvo com sucesso!");
        } catch (FileNotFoundException | TransformerException ex) {
            MensagensErro.xmlGravar(ex);
        }
    } 
    
}
