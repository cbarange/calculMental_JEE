package model;

import bo.User;
import dal.DAOFactory;
import dal.UserDAOJDBC;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.sql.SQLException;

public class RegisterBean implements Serializable {
	
	private static final String FORM_FIELD_LOGIN = "form-login";
	private static final String FORM_FIELD_PWD = "form-pwd";
	public static final String ATT_AUTH_SESSION = "isConntected";
	
	private String login;
	private String pwd;

	
	public RegisterBean() {}
	

	
}
