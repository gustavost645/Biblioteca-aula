/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.util.Date;
import java.util.List;

/**
 * @brief Classe Emprestimo
 * @author Gustavo.Steinhoefel
 * @date 20/05/2019
 */
public class Emprestimo {

    private int id;
    private int id_livro;
    private Date dataemprestimo;
    private Date datavencimento;
    private Date datachegada;
    private int id_leitor;
    private int num_renova;
    private Leitor leitor;
    private List<Livro> livro;

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

    

    public Leitor getLeitor() {
        return leitor;
    }

    public void setLeitor(Leitor leitor) {
        this.leitor = leitor;
    }

    @Override
    public String toString() {
        return "Emprestimo{" + "id=" + id + ", id_livro=" + id_livro + ", dataemprestimo=" + dataemprestimo + ", datavencimento=" + datavencimento + ", datachegada=" + datachegada + ", id_leitor=" + id_leitor + ", leitor=" + leitor + ", livro=" + livro + '}';
    }

    

    public List<Livro> getLivro() {
        return livro;
    }

    public void setLivro(List<Livro> livro) {
        this.livro = livro;
    }

    public int getNum_renova() {
        return num_renova;
    }

    public void setNum_renova(int num_renova) {
        this.num_renova = num_renova;
    }

  
}
