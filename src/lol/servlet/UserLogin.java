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

@WebServlet("/userlogin")
public class UserLogin extends HttpServlet {
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
        // Provide a title and render the JSP.
        messages.put("title", "User Login");        
        req.getRequestDispatcher("/UserLogin.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);
        messages.put("submitted", "true");
        
        boolean validUser = false;
        boolean validPassword = false;
                
        Users user;
    	try {
        	user = userDao.getUserFromUserName(req.getParameter("username"));
        	if (user != null) {
        		validUser = true;
        		
        		if (user.getPassword().equals(req.getParameter("password"))) {
        			validPassword = true;
        			HttpSession session = req.getSession();  
        	        session.setAttribute("username", req.getParameter("username"));
        		}
        	}
        } catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
        }
        
    	if (!validUser || !validPassword) {
    		messages.put("result", "Incorrect username or password");
    		req.getRequestDispatcher("/UserLogin.jsp").forward(req, resp);
    		// set user attribute here
    	} else {
    		resp.sendRedirect(req.getContextPath() + "/userprofile");
    	}
    }
}
