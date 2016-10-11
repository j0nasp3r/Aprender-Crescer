/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.aprendercrescer.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author j0nas
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByIdusuario", query = "SELECT u FROM Usuario u WHERE u.idusuario = :idusuario"),
    @NamedQuery(name = "Usuario.findByIdgrupo", query = "SELECT u FROM Usuario u WHERE u.idgrupo = :idgrupo"),
    @NamedQuery(name = "Usuario.findByLogin", query = "SELECT u FROM Usuario u WHERE u.login = :login"),
    @NamedQuery(name = "Usuario.findBySenhausuario", query = "SELECT u FROM Usuario u WHERE u.senhausuario = :senhausuario"),
    @NamedQuery(name = "Usuario.findByNomeusuario", query = "SELECT u FROM Usuario u WHERE u.nomeusuario = :nomeusuario"),
    @NamedQuery(name = "Usuario.findByDtalteracao", query = "SELECT u FROM Usuario u WHERE u.dtalteracao = :dtalteracao"),
    @NamedQuery(name = "Usuario.findByFlaginativo", query = "SELECT u FROM Usuario u WHERE u.flaginativo = :flaginativo")})
public class Usuario extends AbstractModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idusuario")
    private Integer idusuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idgrupo")
    private int idgrupo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "login")
    private String login;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "senhausuario")
    private String senhausuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "nomeusuario")
    private String nomeusuario;
    @Column(name = "dtalteracao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtalteracao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "flaginativo")
    private String flaginativo;

    public Usuario() {
    }

    public Usuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public Usuario(Integer idusuario, int idgrupo, String login, String senhausuario, String nomeusuario, String flaginativo) {
        this.idusuario = idusuario;
        this.idgrupo = idgrupo;
        this.login = login;
        this.senhausuario = senhausuario;
        this.nomeusuario = nomeusuario;
        this.flaginativo = flaginativo;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public int getIdgrupo() {
        return idgrupo;
    }

    public void setIdgrupo(int idgrupo) {
        this.idgrupo = idgrupo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenhausuario() {
        return senhausuario;
    }

    public void setSenhausuario(String senhausuario) {
        this.senhausuario = senhausuario;
    }

    public String getNomeusuario() {
        return nomeusuario;
    }

    public void setNomeusuario(String nomeusuario) {
        this.nomeusuario = nomeusuario;
    }

    public Date getDtalteracao() {
        return dtalteracao;
    }

    public void setDtalteracao(Date dtalteracao) {
        this.dtalteracao = dtalteracao;
    }

    public String getFlaginativo() {
        return flaginativo;
    }

    public void setFlaginativo(String flaginativo) {
        this.flaginativo = flaginativo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idusuario != null ? idusuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idusuario == null && other.idusuario != null) || (this.idusuario != null && !this.idusuario.equals(other.idusuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.senai.aprendercrescer.model.banco.Usuario[ idusuario=" + idusuario + " ]";
    }

    @Override
    public boolean isNew() {
        if (idusuario == null){
            return true;
        }else{
            return false;
        }
    }
    
}
