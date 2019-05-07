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
public enum LeitorEnum {

    MASC("2","Masculino"),
    FEM("1","Feminino");

    private final String codigo;
    private final String nome;

    LeitorEnum(String codigo,String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }
    
    public String getNome() {
        return nome;
    }

    public static LeitorEnum getByCodigo(String codigo) {
        for (LeitorEnum e : values()) {
            if (e.codigo.equals(codigo)) return e;
        }
        throw new IllegalArgumentException();
    }
}
