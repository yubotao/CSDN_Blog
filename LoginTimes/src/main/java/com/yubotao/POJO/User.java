package com.yubotao.POJO;

public class User {
    private Long id;

    private String username;

    private String password;

    private Integer wrongtimes;

    private Long lastlogin;
    
    private Integer locked;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getWrongtimes() {
        return wrongtimes;
    }

    public void setWrongtimes(Integer wrongtimes) {
        this.wrongtimes = wrongtimes;
    }

    public Long getLastlogin() {
        return lastlogin;
    }

    public void setLastlogin(Long lastlogin) {
        this.lastlogin = lastlogin;
    }

	public Integer getLocked() {
		return locked;
	}

	public void setLocked(Integer locked) {
		this.locked = locked;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", wrongtimes=" + wrongtimes
				+ ", lastlogin=" + lastlogin + ", locked=" + locked + "]";
	}

	
    
}