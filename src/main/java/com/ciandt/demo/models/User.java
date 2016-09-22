package com.ciandt.demo.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author vnaraujo
 */
@Entity
@Table(name = "users", catalog = "security", schema = "", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "login" }) })

public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Integer id;
	@Column(name = "name", nullable = false, length = 50)
	private String name;
	@Column(name = "login", nullable = false, length = 12)
	private String login;
	@Column(name = "password", nullable = false, length = 32)
	private String password;
	@Column(name = "active", nullable = false)
	private Boolean active;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
	private List<UserRole> userRoleList;

	public User() {
	}

	public User(Integer id) {
		this.id = id;
	}

	public User(Integer id, String name, String login, String password) {
		this.id = id;
		this.name = name;
		this.login = login;
		this.password = password;
	}

	public User(User user) {
		this.id = user.id;
		this.name = user.name;
		this.login = user.login;
		this.password = user.password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	@XmlTransient
	public List<UserRole> getUserRoleList() {
		return userRoleList;
	}

	public void setUserRoleList(List<UserRole> userRoleList) {
		this.userRoleList = userRoleList;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof User)) {
			return false;
		}
		User other = (User) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "newpackage.Users[ id=" + id + " ]";
	}

}
