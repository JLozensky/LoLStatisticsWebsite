package lol.servlet;

import lol.dal.*;
import lol.model.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/userupdate")
public class UserUpdate extends HttpServlet {
	
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

        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        if (username == null || username.trim().isEmpty()) {
        	messages.put("result", "You're not logged in!");
        	messages.put("showError", "true");
        } else {
        	// Retrieve , and store as a message.
        	try {
        		
            	Users user = userDao.getUserFromUserName(username);
            	req.setAttribute("user", user);
            } catch (SQLException e) {
    			e.printStackTrace();
    			throw new IOException(e);
            }
        }
        
        req.getRequestDispatcher("/UserUpdate.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        if (username == null || username.trim().isEmpty()) {
        	messages.put("result", "You're not logged in!");
        	messages.put("showError", "true");
        } else {
        	// Retrieve , and store as a message.
        	
        	try {
    			Users user = userDao.getUserFromUserName(username);

        		messages.put("showResult", "true");
        		
            	String newLastName = req.getParameter("lastname");
    			String newSummonerName = req.getParameter("summonername");
    			String newFirstName = req.getParameter("firstname");
    			String newPassword = req.getParameter("password");
    			String newEmail = req.getParameter("email");
    			
        		// check that the new summoner name is valid
        		Summoner summoner = summonerDao.getSummonerFromSummonerName(newSummonerName);
        		if (summoner == null) {
        			messages.put("resultType", "alert-danger");
        			messages.put("result", "The specified summoner does not exist!");
        		} else {
        			
        			user = userDao.updateLastName(user, newLastName);
    	        	user = userDao.updateSummoner(user, summoner);
    	        	user = userDao.updateFirstName(user, newFirstName);
    	        	user = userDao.updateEmail(user, newEmail);
    	        	user = userDao.updatePassword(user, newPassword);
        			messages.put("resultType", "alert-success");
        			messages.put("result", "Successfully updated");

        		}
            	req.setAttribute("user", user);

            	
            } catch (SQLException e) {
    			e.printStackTrace();
    			throw new IOException(e);
            }
        }
        
       
        
        req.getRequestDispatcher("/UserUpdate.jsp").forward(req, resp);
    }
}
