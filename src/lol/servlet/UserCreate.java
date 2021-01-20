package lol.servlet;


import lol.dal.*;
import lol.model.*;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/usercreate") 
public class UserCreate extends HttpServlet {
	
	protected UserDao userDao;
	protected SummonerDao summonerDao;
	
	@Override
	public void init() throws ServletException {
		userDao = UserDao.getInstance();
		summonerDao = SummonerDao.getInstance();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);
        //Just render the JSP.   
        req.getRequestDispatcher("/UserCreate.jsp").forward(req, resp);
	}

	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);
        
        boolean success = false;
        messages.put("submitted", "true");

        StringBuilder sb = new StringBuilder();
    	// Create the User.
    	String userName = req.getParameter("username");
    	String password = req.getParameter("password");
    	String firstName = req.getParameter("firstname");
    	String lastName = req.getParameter("lastname");
    	String email = req.getParameter("email");
    	String summonerName = req.getParameter("summonername");
        	
    	try {
    		// check that the summoner name is valid
    		Summoner summoner = summonerDao.getSummonerFromSummonerName(summonerName);
    		if (summoner != null) {
    			
    			messages.put("summonerNameIsValid", "true");
    			
    			// check that the user doesn't already exist 
    			if (userDao.getUserFromUserName(userName) != null) {
        			messages.put("userAlreadyExists", "true");
    			} else {
        			messages.put("userAlreadyExists", "false");
        			
        			// check that there isn't another user connected to this summoner 
        			if (userDao.getUserFromSummoner(summoner) != null) {
            			messages.put("userAlreadyConnectedToSummoner", "true");
        			} else {
            			messages.put("userAlreadyConnectedToSummoner", "false");
            			
            			// we can create the user and link it to this summoner
            			Users user = new Users(summoner, userName, password, firstName, lastName, email);
                		user = userDao.create(user);
                		
                		HttpSession session = req.getSession();
                    	session.setAttribute("username", user.getUsername());
                    	
                		req.setAttribute("user", user);
                		
                		success = true;
        			}
    			}
            	
        		
            	
    		} else {
    			messages.put("summonerNameIsValid", "false");
    		}
        } catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
        }
        
        if (success) {
        	
    		resp.sendRedirect(req.getContextPath() + "/userprofile");
        } else {
        	req.getRequestDispatcher("/UserCreate.jsp").forward(req, resp);
        }
	}
}
