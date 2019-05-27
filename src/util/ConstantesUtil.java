/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.File;

/**
 *
 * @author gusteinhoefel
 */
public interface ConstantesUtil {
    
    interface VERSAO {
        String BIBLIOTECA = "1.01.00";
        String BIBLIOTECA_DEV = "1.01.30 - Demo2";
    }
    
    String NOME_BIBLIOTECA = "Biblioteca Exemplo";
    String CAMINHO_SAIDA = new File("").getAbsolutePath()+ File.separator;
    
}
