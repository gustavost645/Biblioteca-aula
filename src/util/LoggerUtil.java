/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @brief Classe LoggerUtil
 * @author Gustavo.Steinhoefel
 * @date 17/05/2019
 */
public class LoggerUtil {

    private static final Logger LOGGER = Logger.getLogger("");

    static {
        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tD-%1$tT][%2$1s]%5$s %n");
    }

    public static void log(Class classe, String msg) {
        LOGGER.logp(Level.INFO, classe.getName(), null, msg);
    }
    
}
