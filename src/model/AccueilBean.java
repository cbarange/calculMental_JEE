package model;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import bo.User;
import dal.DAOFactory;
import dal.UserDAOJDBC;

public class AccueilBean implements Serializable {
	
	private List<User> userList; 
	
	
	
	public AccueilBean() {}
	
	public List<User> getUserList( HttpServletRequest request ) {
		UserDAOJDBC dao = ( UserDAOJDBC ) DAOFactory.getUserDAO();
		List <User> users = null;
		try {
			users = dao.findAll();
			
			if ( users != null ) {
				HttpSession session = request.getSession( true );
				//TODO récupération et incrémentation du nombre de connexions
				session.setAttribute("userList", users);
				
			} else {
				
			}
		} catch ( SQLException e ) {
			System.out.println(e.getMessage());
		}
		return users;
	}
}
