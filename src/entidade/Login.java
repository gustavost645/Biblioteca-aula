/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidade;

/**
 * @brief Classe Login
 * @author Gustavo.Steinhoefel
 * @date   19/03/2019
 */
public class Login {
    
    private Integer id;
    private String nome;
    private String login;
    private String password;
    private int status;
    private int del;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        return "Login{" + "id=" + id + ", nome=" + nome + ", login=" + login + ", password=" + password + ", status=" + status + ", del=" + del + '}';
    }

}
