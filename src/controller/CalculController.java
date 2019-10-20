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

@WebServlet( name = "calculController", urlPatterns = {"/calcul"}, loadOnStartup = 1 )
public class CalculController extends HttpServlet {
	private static final String PAGE_HOME_JSP = "/accueil";
	private static final String PAGE_SCORE_JSP = "/score";
	private static final String PAGE_LOGIN_JSP = "/login";
	private static final String CALCUL_JSP = "/jsp/calcul.jsp";
	private static final int NB_QUESTION_MAX =10;
	private static final Logger LOGGER = Logger.getLogger( CalculController.class.getName() );
	
	
	public CalculController() {
		LOGGER.log( Level.INFO, "Constructeur AccueilController!" );
	}
	
	@Override
	public void init() throws ServletException {
		LOGGER.log( Level.INFO, "Je suis dans le init de CalculController!" );
		super.init();
	}
	
	@Override
	public void destroy() {
		LOGGER.log( Level.INFO, "Je suis dans le destroy de CalculController!" );
		super.destroy();
	}
	
	@Override
	protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		LOGGER.log( Level.INFO, "Je suis dans le GET de CalculController!" );
		HttpSession session = request.getSession( true );
		LoginBean modelLogin = new LoginBean();
        if(modelLogin.isConnected(request)){
        	CalculBean model=new CalculBean();
			model.getCalcul(request);
			request.getRequestDispatcher(CALCUL_JSP).forward( request, response );
        }
        else {
            request.getRequestDispatcher(PAGE_LOGIN_JSP).forward(request, response);
        }
	}
	
	@Override
	protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		LOGGER.log( Level.INFO, "Je suis dans le POST CalculController!" );
		HttpSession session = request.getSession( true );
		CalculBean model = new CalculBean();
		boolean responseIsCorrecte=model.checkResponse( request );
		if(responseIsCorrecte)
			session.setAttribute("nbQuestionCorrecte",((int) session.getAttribute("nbQuestionCorrecte"))+1);
		session.setAttribute("nbQuestionJoue",((int) session.getAttribute("nbQuestionJoue"))+1);
		if(((int)session.getAttribute("nbQuestionJoue"))>=NB_QUESTION_MAX) {
			model.setMaxScore(request, (int) session.getAttribute("nbQuestionCorrecte"));
			response.sendRedirect( request.getContextPath()+PAGE_SCORE_JSP );
		}else
			doGet( request, response );
	}
	
	@Override
	protected void doDelete( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		LOGGER.log( Level.INFO, "Je suis dans le DELETE !" );
	}
}
