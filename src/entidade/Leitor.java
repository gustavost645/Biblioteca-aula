/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.util.Date;

/**
 *
 * @author gusteinhoefel
 */
public class Leitor {

    private int id;
    private String nome;
    private String endereco;
    private Cidade Cidade;
    private int tipo;
    private Date dt_nscimento;
    private String matricula;
    private String turma;
    private String turno;
    private int limite_livros;
    private int status;
    private int del;

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Cidade getCidade() {
        return Cidade;
    }

    public void setCidade(Cidade Cidade) {
        this.Cidade = Cidade;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public Date getDt_nscimento() {
        return dt_nscimento;
    }

    public void setDt_nscimento(Date dt_nscimento) {
        this.dt_nscimento = dt_nscimento;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public int getLimite_livros() {
        return limite_livros;
    }

    public void setLimite_livros(int limite_livros) {
        this.limite_livros = limite_livros;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getDel() {
        return del;
    }

    public void setDel(int del) {
        this.del = del;
    }

    @Override
    public String toString() {
        return "Leitor{" + "id=" + id + ", nome=" + nome + ", endereco=" + endereco + ", Cidade=" + Cidade + ", tipo=" + tipo + ", dt_nscimento=" + dt_nscimento + ", matricula=" + matricula + ", turma=" + turma + ", turno=" + turno + ", limite_livros=" + limite_livros + ", status=" + status + ", del=" + del + '}';
    }
    
}
