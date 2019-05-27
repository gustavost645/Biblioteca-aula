/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

/**
 * @brief Classe Item
 * @author Gustavo.Steinhoefel
 * @date   20/05/2019
 */
public class Item {
    
    private int    id;
    private String codigo_barras;
    private Double valor_livro;
    private String data_aquisicao;
    private int    cod_id_livro;
    private int    status;
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo_barras() {
        return codigo_barras;
    }

    public void setCodigo_barras(String codigo_barras) {
        this.codigo_barras = codigo_barras;
    }

    public Double getValor_livro() {
        return valor_livro;
    }

    public void setValor_livro(Double valor_livro) {
        this.valor_livro = valor_livro;
    }

    public String getData_aquisicao() {
        return data_aquisicao;
    }

    public void setData_aquisicao(String Data_aquisicao) {
        this.data_aquisicao = Data_aquisicao;
    }

    public int getCod_id_livro() {
        return cod_id_livro;
    }

    public void setCod_id_livro(int cod_id_livro) {
        this.cod_id_livro = cod_id_livro;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Item{" + "id=" + id + ", codigo_barras=" + codigo_barras + ", valor_livro=" + valor_livro + ", data_aquisicao=" + data_aquisicao + ", cod_id_livro=" + cod_id_livro + ", status=" + status + '}';
    }


}
