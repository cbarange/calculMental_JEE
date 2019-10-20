package model;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import bo.Calcul;
import bo.User;
import dal.DAOFactory;
import dal.UserDAOJDBC;

public class CalculBean implements Serializable {
	
	private List<User> userList; 
	private static final String FORM_FIELD_RESPONSE = "form-reponse";
	public static final String ATT_AUTH_SESSION = "isConntected";
	
	public CalculBean() {}
	
	public void setMaxScore(HttpServletRequest request,int score) {
		HttpSession session = request.getSession(true);
		if(((User)session.getAttribute(ATT_AUTH_SESSION)).getMaxScore()<score) {
			UserDAOJDBC dao = ( UserDAOJDBC ) DAOFactory.getUserDAO();
			try {
				dao.setMaxScore(((User)session.getAttribute(ATT_AUTH_SESSION)).getId(), score);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			User user=((User)session.getAttribute(ATT_AUTH_SESSION));
			user.setMaxScore(score);
		}
	}
	
	public boolean checkResponse(HttpServletRequest request) {
		String responseValue = request.getParameter( FORM_FIELD_RESPONSE );
		HttpSession session = request.getSession(true);
		Calcul calcul=(Calcul) session.getAttribute("calcul");
		if(responseValue.length()==0)
			return false;
		if(calcul.getResultat()==Double.parseDouble(responseValue))
			return true;
		return false;
	}
	
		
	public Calcul getCalcul( HttpServletRequest request ) {
		HttpSession session = request.getSession( true );
		Calcul calcul=new Calcul();
		session.setAttribute("calcul", calcul);
		return calcul;
	}
}
