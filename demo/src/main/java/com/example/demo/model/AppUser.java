package com.example.demo.model;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class AppUser implements UserDetails{
	
	@Id
	private String id;
	private String name;
	private String username;
	private String email;
	private String password;
	private Long phoneNo;
	private UserAddress adress;
	
	private AppUserRole appUserRole;
	private Boolean locked;
	private Boolean enabled;
	
	
	

	

	@Override
	public int hashCode() {
		return Objects.hash(adress, appUserRole, email, enabled, id, locked, name, password, phoneNo, username);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AppUser other = (AppUser) obj;
		return Objects.equals(adress, other.adress) && appUserRole == other.appUserRole
				&& Objects.equals(email, other.email) && Objects.equals(enabled, other.enabled)
				&& Objects.equals(id, other.id) && Objects.equals(locked, other.locked)
				&& Objects.equals(name, other.name) && Objects.equals(password, other.password)
				&& Objects.equals(phoneNo, other.phoneNo) && Objects.equals(username, other.username);
	}


	public AppUser() {
		super();
	}

	
	public AppUser(String name, String username, String email, String password, Long phoneNo, UserAddress adress,
			AppUserRole appUserRole, Boolean locked, Boolean enabled) {
		super();
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.phoneNo = phoneNo;
		this.adress = adress;
		this.appUserRole = appUserRole;
		this.locked = locked;
		this.enabled = enabled;
	}

	public AppUser(String id, String name, String username, String email, String password, Long phoneNo,
			UserAddress adress, AppUserRole appUserRole, Boolean locked, Boolean enabled) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.phoneNo = phoneNo;
		this.adress = adress;
		this.appUserRole = appUserRole;
		this.locked = locked;
		this.enabled = enabled;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public AppUserRole getAppUserRole() {
		return appUserRole;
	}

	public void setAppUserRole(AppUserRole appUserRole) {
		this.appUserRole = appUserRole;
	}

	public Boolean getLocked() {
		return locked;
	}

	public void setLocked(Boolean locked) {
		this.locked = locked;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public UserAddress getAdress() {
		return adress;
	}

	public void setAdress(UserAddress adress) {
		this.adress = adress;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority authority=new SimpleGrantedAuthority(appUserRole.name());
		return Collections.singletonList(authority);
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return !locked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return enabled;
	}

}
