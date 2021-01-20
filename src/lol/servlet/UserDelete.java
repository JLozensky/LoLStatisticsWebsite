
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

@WebServlet("/userdelete")
public class UserDelete extends HttpServlet {
	
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
        
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        if (username == null || username.trim().isEmpty()) {
        	messages.put("loggedIn", "false");
        } else {
            messages.put("loggedIn", "true");
            try {
	        	Users user = userDao.getUserFromUserName(username);
	        	req.setAttribute("user", user);
	        } catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        }
        
        req.getRequestDispatcher("/UserDelete.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);
    	messages.put("loggedIn", "false");
        messages.put("submitted", "true");

        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        if (username == null || username.trim().isEmpty()) {
        	messages.put("error", "You're not logged in!");
        	messages.put("showError", "true");
        } else {
	        try {
	        	messages.put("showResult", "true");
	        	Users user = userDao.getUserFromUserName(username);
	        	user = userDao.delete(user);
	        	// Update the message.
		        if (user == null) {
		            messages.put("result", "Successfully deleted " + username);
		            messages.put("resultType", "alert-success");
		            session.invalidate();
		        } else {
		        	messages.put("result", "An error occurred while trying to delete " + username);
		        	messages.put("resultType", "alert-danger");
		        }
	        } catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        }

        
        req.getRequestDispatcher("/UserDelete.jsp").forward(req, resp);
    }

}