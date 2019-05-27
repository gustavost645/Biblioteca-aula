/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidade;

import java.util.Date;

/**
 * @brief Classe Emprestimo
 * @author Gustavo.Steinhoefel
 * @date   20/05/2019
 */
public class Emprestimo {
    private int id;
    private int  id_livro;
    private Date dataemprestimo;
    private Date datavencimento;
    private Date datachegada;
    private int id_leitor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataemprestimo() {
        return dataemprestimo;
    }

    public void setDataemprestimo(Date dataemprestimo) {
        this.dataemprestimo = dataemprestimo;
    }

    public Date getDatavencimento() {
        return datavencimento;
    }

    public void setDatavencimento(Date datavencimento) {
        this.datavencimento = datavencimento;
    }

    public Date getDatachegada() {
        return datachegada;
    }

    public void setDatachegada(Date datachegada) {
        this.datachegada = datachegada;
    }

    public int getId_leitor() {
        return id_leitor;
    }

    public void setId_leitor(int id_leitor) {
        this.id_leitor = id_leitor;
    }

    public int getId_livro() {
        return id_livro;
    }

    public void setId_livro(int id_livro) {
        this.id_livro = id_livro;
    }
    
   @Override
    public String toString() {
        return "Emprestimo{" + "id=" + id + ", id_livro=" + id_livro + ", dataemprestimo=" + dataemprestimo + ", datavencimento=" + datavencimento + ", datachegada=" + datachegada + ", id_leitor=" + id_leitor + '}';
    } 
    
}
