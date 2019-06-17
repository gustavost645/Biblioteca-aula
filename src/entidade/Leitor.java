/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import dao.EmprestimoDAO;
import java.util.Date;
import util.LoggerUtil;

/**
 *
 * @author gusteinhoefel
 */
public class Leitor {

    private int id;
    private String nome;
    private String num_cgc;
    private String endereco;
    private Cidade Cidade;
    private int tipo;         //Categoria
    private Date dt_nscimento;
    private Date data_registro;
    private String matricula;
    private String turma;
    private String turno;
    private int limite_livros;
    private String email;
    private int status;
    private int del;
    
    private boolean selecionado;

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
        this.nome = nome.toUpperCase();
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco.toUpperCase();
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
        this.matricula = matricula.toUpperCase();
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma.toUpperCase();
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno.toUpperCase();
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

    public String getNum_cgc() {
        return num_cgc;
    }

    public void setNum_cgc(String num_cgc) {
        this.num_cgc = num_cgc.replace(".","").replaceAll("-","");
    }

    public boolean isSelecionado() {
        return selecionado;
    }

    public void setSelecionado(boolean selecionado) {
        this.selecionado = selecionado;
    }

    public boolean verificaLivrosPendentes() {
        boolean check = false;
        try {
            EmprestimoDAO dao = new EmprestimoDAO();
            if (dao.listarPendencias(this.id).isEmpty()) {
                check = true;
            }
        } catch (Exception ex) {
            LoggerUtil.log(Leitor.class, ex.getMessage());
        }
        return check;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email.toUpperCase();
    }

    public Date getData_registro() {
        return data_registro;
    }

    public void setData_registro(Date data_registro) {
        this.data_registro = data_registro;
    }

    @Override
    public String toString() {
        return "Leitor{" + "id=" + id + ", nome=" + nome + ", num_cgc=" + num_cgc + ", endereco=" + endereco + ", Cidade=" + Cidade + ", tipo=" + tipo + ", dt_nscimento=" + dt_nscimento + ", data_registro=" + data_registro + ", matricula=" + matricula + ", turma=" + turma + ", turno=" + turno + ", limite_livros=" + limite_livros + ", email=" + email + ", status=" + status + ", del=" + del + ", selecionado=" + selecionado + '}';
    }
    
    
    
}
