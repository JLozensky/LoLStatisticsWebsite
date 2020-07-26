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

@WebServlet("/usercreate") 
public class UserCreate extends HttpServlet {
	
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
        //Just render the JSP.   
        req.getRequestDispatcher("/UserCreate.jsp").forward(req, resp);
	}

	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        // Retrieve and validate name.
        String id = req.getParameter("summonername");
        if (id == null || id.trim().isEmpty()) {
            messages.put("success", "Invalid summonername");
        } else {
        	// Create the Player.
        	String firstName = req.getParameter("firstname");
        	String lastName = req.getParameter("lastname");
        	String summonerName = req.getParameter("summonername");
        	
        	try {
        		Users user = new Users(summonerName, firstName, lastName);
        		user = userDao.create(user);
        		messages.put("success", "Successfully created " + summonerName);
        		
	        } catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
          
        req.getRequestDispatcher("/UserCreate.jsp").forward(req, resp);
        }
	}

}
