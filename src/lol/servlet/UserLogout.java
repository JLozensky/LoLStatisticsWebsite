package lol.servlet;


import lol.dal.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/userlogout")
public class UserLogout extends HttpServlet {
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
        messages.put("submitted", "true");
        
        HttpSession session = req.getSession();  
        session.invalidate();
        
        messages.put("result", "You've been logged out!");        
        req.getRequestDispatcher("/UserLogout.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);
        messages.put("submitted", "false");

        
        req.getRequestDispatcher("/UserLogout.jsp").forward(req, resp);
    }
}
