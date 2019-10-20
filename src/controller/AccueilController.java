package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.User;
import model.AccueilBean;
import model.CalculBean;
import model.LoginBean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet( name = "accueilController", urlPatterns = {"/accueil"}, loadOnStartup = 1 )
public class AccueilController extends HttpServlet {
	
	private static final String ACCUEIL_JSP = "/jsp/accueil.jsp";
	//private static final String CALCUL_JSP = "/jsp/calcul.jsp";
	private static final Logger LOGGER = Logger.getLogger( AccueilController.class.getName() );
	private static final String PAGE_LOGIN_JSP = "/login";
	
	public AccueilController() {
		LOGGER.log( Level.INFO, "Constructeur AccueilController!" );
	}
	
	@Override
	public void init() throws ServletException {
		LOGGER.log( Level.INFO, "Je suis dans le init de AccueilController!" );
		super.init();
	}
	
	@Override
	public void destroy() {
		LOGGER.log( Level.INFO, "Je suis dans le destroy de AccueilController!" );
		super.destroy();
	}
	
	@Override
	protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		LOGGER.log( Level.INFO, "Je suis dans le GET de AccueilController!" );
		HttpSession session = request.getSession( true );
		LoginBean modelLogin = new LoginBean();
        if(modelLogin.isConnected(request)){
        	AccueilBean model=new AccueilBean();
        	List<User> dataSession = null;	
        	session.setAttribute("nbQuestionJoue", 0);
        	session.setAttribute("nbQuestionCorrecte", 0);
        	model.getUserList(request);
        	request.getRequestDispatcher( ACCUEIL_JSP ).forward( request, response );
        }else {
        	request.getRequestDispatcher(PAGE_LOGIN_JSP).forward(request, response);
        }
	}
	
	@Override
	protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		LOGGER.log( Level.INFO, "Je suis dans le POST !" );
		doGet(request,response);
	}
	
	@Override
	protected void doDelete( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		LOGGER.log( Level.INFO, "Je suis dans le DELETE !" );
	}
}
