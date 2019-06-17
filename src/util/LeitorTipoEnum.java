/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author gusteinhoefel
 */
public enum LeitorTipoEnum {

    ESTUDANTE   ("0", "Estudante"),
    PROFESSOR   ("1", "Professor"),
    PROFISSIONAL("2", "Profissional");

    private final String codigoTipo;
    private final String nomeTipo;
    
    
    LeitorTipoEnum(String codigoTipo, String nomeTipo) {
        this.codigoTipo = codigoTipo;
        this.nomeTipo = nomeTipo;
    }

    public String getCodigoTipo() {
        return codigoTipo;
    }

    public String getNomeTipo() {
        return nomeTipo.toUpperCase();
    }

    public static LeitorTipoEnum getByCodigoTipo(String codigo) {
        for (LeitorTipoEnum e : values()) {
            if (e.codigoTipo.equals(codigo)) {
                return e;
            }
        }
        throw new IllegalArgumentException();
    }

    

}
