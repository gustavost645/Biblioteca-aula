/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import apoio.ConexaoBD;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JDialog;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 * @brief Classe GeradorRelatorio
 * @author Gustavo.Steinhoefel
 * @date 18/05/2019
 */
public class GeradorRelatorio {

    private final Connection conexao;
    private final Toolkit tk = Toolkit.getDefaultToolkit();
    private final Dimension d = tk.getScreenSize();
    private final JFrame frame;

     
    public GeradorRelatorio(javax.swing.JFrame aThis) {
        this.conexao = ConexaoBD.getInstance().getConnection();
        this.frame = aThis;
    }


    public void visualizar(String jasper, HashMap<String, Object> parametros, String saida, String titulo) {

        try {

            //caminho relativo do relatório dentro do pacote  
            //String a = "";

            //lê o arquivo dentro do pacote  
            //mecessário caso gere um JAR para distribuir  
            //InputStream in = getClass().getResourceAsStream(jasper); 

            JDialog viewer = new JDialog(frame, titulo, true);

            //Pega a Resolução do Video  
            viewer.setSize(d.width, d.height);
            viewer.setLocationRelativeTo(null);

            //Deixar true pois da problema no relatorio caso deixado false  
            viewer.setResizable(true);
                      
            
            JasperPrint jasperPrint = JasperFillManager.fillReport(getClass().getResourceAsStream(jasper), parametros, conexao);
            JasperViewer jrViewer = new JasperViewer(jasperPrint, true);

            //Adicionando o relatorio no Jdialog  
            viewer.getContentPane().add(jrViewer.getContentPane());

            //Deixar True para exibir a tela no sistema  
            viewer.setVisible(true);

        } catch (JRException e) {
            LoggerUtil.log(GeradorRelatorio.class, e.getMessage());
            throw new RuntimeException("Erro ao gerar relatório", e);
        }
    }
    
    public void visualizar(String jasper, HashMap<String, Object> parametros,ArrayList lista, String saida, String titulo) {

        try {

            //caminho relativo do relatório dentro do pacote  
            //String a = "";

            //lê o arquivo dentro do pacote  
            //mecessário caso gere um JAR para distribuir  
            //InputStream in = this.getClass().getResourceAsStream(a);  
            JDialog viewer = new JDialog(frame, titulo, true);

            //Pega a Resolução do Video  
            viewer.setSize(d.width, d.height);
            viewer.setLocationRelativeTo(null);

            //Deixar true pois da problema no relatorio caso deixado false  
            viewer.setResizable(true);
            JRBeanCollectionDataSource dados  = new JRBeanCollectionDataSource(lista, true);
            JasperPrint jasperPrint = JasperFillManager.fillReport(getClass().getResourceAsStream(jasper), parametros, dados);
            JasperViewer jrViewer = new JasperViewer(jasperPrint, true);

            //Adicionando o relatorio no Jdialog  
            viewer.getContentPane().add(jrViewer.getContentPane());

            //Deixar True para exibir a tela no sistema  
            viewer.setVisible(true);

        } catch (JRException e) {
            throw new RuntimeException("Erro ao gerar relatório", e);
        }
    }

    public void geraPDF(String jrxml, Map<String, Object> parametros, OutputStream saida, String titulo) {
        /*
            // compila jrxml em memoria
            JasperReport jasper = JasperCompileManager.compileReport(jrxml);

            // preenche relatorio
            JasperPrint print = JasperFillManager.fillReport(jasper, parametros, this.conexao);

            // exporta para pdf
            JRExporter exporter = new JRPdfExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, saida);

            exporter.exportReport();*/
        throw new RuntimeException("Erro ao gerar relatório");
    }
}
