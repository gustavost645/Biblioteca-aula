/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * @brief Classe Livro
 * @author Gustavo.Steinhoefel
 * @date   20/05/2019
 */
public class Livro {
    
    private int     id;
    private String  titulo;
    private String  codbarras;
    private String  subtitulo;
    private String  isbn;
    private int     volume;
    private int     anoEdicao;
    private int     edicao;
    private String  tombo;
    private String  cdu;
    private String  cdd;
    private String  cutter;
    private Editora editora;
    private ClassLiteraria classLiteraria;
    private Colecao colecao;
    private Date    data_aquisicao;
    private int  status;//esta locado ou não
    private int     del;
    private List<Assunto> assunto;
    private List<Autor> autor;
    private boolean selecionado = false;//para ajudar na tabela  
    private String numLivros;
    private String numEmprestimos;
    
    public Livro() {
        this.id = 0;
        this.del = 0;
        this.autor = new ArrayList<>();
        this.assunto = new ArrayList<>();
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo.toUpperCase();
    }

    public String getCodbarras() {
        return codbarras;
    }

    public void setCodbarras(String codbarras) {
        this.codbarras = codbarras.toUpperCase();
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo.toUpperCase();
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn.toUpperCase();
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getAnoEdicao() {
        return anoEdicao;
    }

    public void setAnoEdicao(int anoEdicao) {
        this.anoEdicao = anoEdicao;
    }

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    public String getTombo() {
        return tombo;
    }

    public void setTombo(String tombo) {
        this.tombo = tombo.toUpperCase();
    }

    public String getCdu() {
        return cdu;
    }

    public void setCdu(String cdu) {
        this.cdu = cdu.toUpperCase();
    }

    public String getCdd() {
        return cdd;
    }

    public void setCdd(String cdd) {
        this.cdd = cdd.toUpperCase();
    }

    public String getCutter() {
        return cutter;
    }

    public void setCutter(String cutter) {
        this.cutter = cutter.toUpperCase();
    }

    public Date getData_aquisicao() {
        return data_aquisicao;
    }

    public void setData_aquisicao(Date data_aquisicao) {
        this.data_aquisicao = data_aquisicao;
    }

    public int getDel() {
        return del;
    }

    public void setDel(int del) {
        this.del = del;
    }

    public boolean getSelecionado() {
        return selecionado;
    }

    public void setSelecionado(boolean selecionado) {
        this.selecionado = selecionado;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    public ClassLiteraria getClassLiteraria() {
        return classLiteraria;
    }

    public void setClassLiteraria(ClassLiteraria classLiteraria) {
        this.classLiteraria = classLiteraria;
    }

    public List<Assunto> getAssunto() {
        return assunto;
    }

    public void setAssunto(List<Assunto> assunto) {
        this.assunto = assunto;
    }

    public List<Autor> getAutor() {
        return autor;
    }

    public void setAutor(List<Autor> autor) {
        this.autor = autor;
    }
    
    public void addAutor(Autor itemAutor) {
        autor.add(itemAutor);
    }
    
    public void addAssunto(Assunto itemAssunto) {
        assunto.add(itemAssunto);
    }

    public Colecao getColecao() {
        return colecao;
    }

    public void setColecao(Colecao colecao) {
        this.colecao = colecao;
    }

    @Override
    public String toString() {
        return "Livro{" + "id=" + id + ", titulo=" + titulo + ", codbarras=" + codbarras + ", subtitulo=" + subtitulo + ", isbn=" + isbn + ", volume=" + volume + ", anoEdicao=" + anoEdicao + ", edicao=" + edicao + ", tombo=" + tombo + ", cdu=" + cdu + ", cdd=" + cdd + ", cutter=" + cutter + ", editora=" + editora + ", classLiteraria=" + classLiteraria + ", colecao=" + colecao + ", data_aquisicao=" + data_aquisicao + ", status=" + status + ", del=" + del + ", assunto=" + assunto + ", autor=" + autor + ", selecionado=" + selecionado + ", numLivros=" + numLivros + ", numEmprestimos=" + numEmprestimos + '}';
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getNumLivros() {
        return numLivros;
    }

    public void setNumLivros(String numLivros) {
        this.numLivros = numLivros;
    }

    public String getNumEmprestimos() {
        return numEmprestimos;
    }

    public void setNumEmprestimos(String numEmprestimos) {
        this.numEmprestimos = numEmprestimos;
    }

    
    
    
}
