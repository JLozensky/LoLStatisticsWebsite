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


@WebServlet("/userupdate")
public class UserUpdate extends HttpServlet {
	
	protected UserDao userDao;
	
	@Override
	public void init() throws ServletException {
		userDao = UserDao.getInstance();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        // Retrieve user and validate.
        String sn = req.getParameter("summonername");
        if (sn == null || sn.trim().isEmpty()) {
            messages.put("success", "Please enter a valid summoner name.");
        } else {
        	try {
        		Users user = userDao.getUserFromSummonerName(sn);
        		if(user == null) {
        			messages.put("success", "User does not exist.");
        		}
        		req.setAttribute("User", user);
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

        // Retrieve user and validate.
        String sn = req.getParameter("summonername");
        if (sn == null || sn.trim().isEmpty()) {
            messages.put("success", "Please enter a valid summoner name.");
        } else {
        	try {
        		Users user = userDao.getUserFromSummonerName(sn);
        		if(user == null) {
        			messages.put("success", "User does not exist. No update to perform.");
        		} else {
        			String newLastName = req.getParameter("lastname");
        			String newSummonerName = req.getParameter("summonername");
        			String newFirstName = req.getParameter("firstname");
        			
        			if (newLastName == null || newLastName.trim().isEmpty()) {
        	            messages.put("success", "Please enter a valid last name.");
        	        } else if (newSummonerName == null || newSummonerName.trim().isEmpty()) {
        	        	messages.put("success", "Please enter a valid summoner name.");
        	        } else if (newFirstName == null || newFirstName.trim().isEmpty()) {
        	        	messages.put("success", "Please enter a valid first name.");
        	        	
        	        } else {
        	        	
        	        	user = userDao.updateLastName(user, newLastName);
        	        	user = userDao.updateSummonerName(user, newSummonerName);
        	        	user = userDao.updateFirstName(user, newFirstName);
        	        	messages.put("success", "Successfully updated " + sn);
        	        	
        	        }
        		

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
