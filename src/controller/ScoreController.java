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

@WebServlet( name = "scoreController", urlPatterns = {"/score"}, loadOnStartup = 1 )
public class ScoreController extends HttpServlet {
	private static final String PAGE_HOME_JSP = "/accueil";
	private static final String PAGE_LOGIN_JSP = "/login";
	private static final String SCORE_JSP = "/jsp/score.jsp";
	private static final Logger LOGGER = Logger.getLogger( ScoreController.class.getName() );
	
	
	public ScoreController() {
		LOGGER.log( Level.INFO, "Constructeur ScoreController!" );
	}
	
	@Override
	public void init() throws ServletException {
		LOGGER.log( Level.INFO, "Je suis dans le init de ScoreController!" );
		super.init();
	}
	
	@Override
	public void destroy() {
		LOGGER.log( Level.INFO, "Je suis dans le destroy de ScoreController!" );
		super.destroy();
	}
	
	@Override
	protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		LOGGER.log( Level.INFO, "Je suis dans le GET de ScoreController!" );
		HttpSession session = request.getSession( true );
		LoginBean modelLogin = new LoginBean();
        if(modelLogin.isConnected(request)){
        	
			request.getRequestDispatcher(SCORE_JSP).forward( request, response );
        }
        else {
            request.getRequestDispatcher(PAGE_LOGIN_JSP).forward(request, response);
        }
	}
	
	@Override
	protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		LOGGER.log( Level.INFO, "Je suis dans le POST ScoreController!" );
	}
	
	@Override
	protected void doDelete( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		LOGGER.log( Level.INFO, "Je suis dans le DELETE !" );
	}
}
