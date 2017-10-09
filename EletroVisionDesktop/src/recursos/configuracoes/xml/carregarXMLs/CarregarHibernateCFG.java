/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package recursos.configuracoes.xml.carregarXMLs;

import recursos.configuracoes.sistema.ConfigConexaoBanco;
import recursos.configuracoes.diretorios.caminhos.ArquivosConfiguracao;
import recursos.configuracoes.xml.ManipulaDocumentoXML;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;       
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import recursos.instancias.InstanciasControle;
import recursos.internacionalizacao.MensagensSoltas;

/**
 *
 * @author wesllen
 */
public class CarregarHibernateCFG {
    
    private ManipulaDocumentoXML manipulaDocumentoXML = null;
    private Document doc = null;
    private String senha;
    
    public CarregarHibernateCFG(String senha){
        this.senha = senha;
        manipulaDocumentoXML = new ManipulaDocumentoXML(); 
        doc = manipulaDocumentoXML.obterDocumentoXML(ArquivosConfiguracao.hibernate());     
        if(doc != null){
            Element elementoRaiz = doc.getDocumentElement();
            NodeList nos = elementoRaiz.getElementsByTagName("property");

            percorreNos(nos);
            manipulaDocumentoXML.gravarXML(doc);
            try {
                ajeitarDocType();
            } catch (FileNotFoundException ex) {       
                System.out.println(ex);
            } catch (IOException ex) {
                System.out.println(ex);
            }
        } else {
            InstanciasControle.getMensagens().bug(MensagensSoltas.comumHibernateCFG());
        }
    }
    
    private void percorreNos(NodeList nos){
        for (int i = 0; i < nos.getLength(); i++) {
            Element elementoVelho = (Element) nos.item(i);
            Attr nomeAtributo = elementoVelho.getAttributeNode("name");
            Node valorVelho = nos.item(i).getFirstChild();
            
            alteraPropriedades(elementoVelho, nomeAtributo, valorVelho);
        }
    }
    
    private void trocaValores(Element elemento, Node valorNovo, Node valorVelho){
        elemento.replaceChild(valorNovo, valorVelho);
    }
    
    private void alteraPropriedades(Element elementoVelho, Attr nomeAtributo, Node valorVelho){
        if (nomeAtributo.getNodeValue().equals("hibernate.connection.url")) {
            String url = "jdbc:"+ConfigConexaoBanco.getBanco()+"://"+ConfigConexaoBanco.getHost()+":"+ConfigConexaoBanco.getPorta()
                    +"/" + ConfigConexaoBanco.getNomeBanco();           
            Node valorNovo = valorVelho;
            valorNovo.setNodeValue(url);
            trocaValores(elementoVelho, valorNovo, valorVelho);                          
        } else if(nomeAtributo.getNodeValue().equals("hibernate.connection.username")){
            Node valorNovo = valorVelho;
            valorNovo.setNodeValue(ConfigConexaoBanco.getUsuario());
            trocaValores(elementoVelho, valorNovo, valorVelho);                      
        } else if(nomeAtributo.getNodeValue().equals("hibernate.connection.password")){
            Node valorNovo = valorVelho;
            valorNovo.setNodeValue(senha);
            trocaValores(elementoVelho, valorNovo, valorVelho); 
        }
    }

    private void ajeitarDocType() throws FileNotFoundException, IOException {
        String documento = "";
        File file = ArquivosConfiguracao.hibernate();
        
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);

        String linha = null;
        Integer cont = 0;
        while((linha = buffer.readLine()) != null){
            if(cont > 0){
                documento += linha+"\n";
            }
            cont++;
        }
        buffer.close();
        reader.close();   
    
        FileWriter write = new FileWriter(file);
        PrintWriter print = new PrintWriter(write);
        
        print.println("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
        print.println("<!DOCTYPE hibernate-configuration PUBLIC \"-//Hibernate/Hibernate"
            + " Configuration DTD 3.0//EN\" \"http://hibernate.sourceforge.net/hibernate-configuration-3.0.dtd\">");
        print.println("<hibernate-configuration>");
        print.println(documento);
        
        print.close();
        write.close();
    }
    
}
