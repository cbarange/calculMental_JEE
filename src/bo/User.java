package bo;

import java.io.Serializable;

public class User implements Serializable {
	
	private String login;
	private String password;
	private int nbConnections;
	private int maxScore;
	private int id;
	
	public User() {}
	
	public User( String login, String password, int nbConnections ) {
		this.login = login;
		this.password = password;
		this.nbConnections = nbConnections;
	}
	
	public User( int id,String login,int maxScore) {
		this.id=id;
		this.login = login;
		this.maxScore=maxScore;
	}
	
	public int getMaxScore() {
		return maxScore;
	}

	public void setMaxScore(int maxScore) {
		this.maxScore = maxScore;
	}

	public String getLogin() {
		return login;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setLogin( String login ) {
		this.login = login;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword( String password ) {
		this.password = password;
	}
	
	public int getNbConnections() {
		return nbConnections;
	}
	
	public void setNbConnections( int nbConnections ) {
		this.nbConnections = nbConnections;
	}
}
