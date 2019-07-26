package com.visa.auth.entity;

import java.io.Serializable;
import java.util.Arrays;

import org.springframework.data.redis.core.RedisHash;
/**
 * 
 * @author banup
 *
 */
@RedisHash("users")
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1;
	private String id;
	private String email;
	private String password;
	private String[] roles;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String[] getRoles() {
		return roles;
	}
	public void setRoles(String[] roles) {
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + email + ", password=" + password + ", roles="
				+ Arrays.toString(roles) + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}
}
