package model;

public class UserModel {
	
	private String m_login;
	
	private String m_pwd;
	
	private String m_lastname;
	
	private String m_surename;
	
	private String m_role;

	public UserModel(String login, String pwd) {
		m_login = login;
		m_pwd = pwd;
		
		m_lastname = "Doe";
		m_surename = "John";
		m_role = "Admin";
	}
	
	public String toString() {
		return "Lastname: " + m_lastname + "\nSurename: " + m_surename + 
				"\nSLogin: " + m_login + "\nPassword: " + m_pwd + "\nRole: " + m_role ;
	}
	
	public String getLogin() {
		return m_login;
	}
}
