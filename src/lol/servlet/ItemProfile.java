package lol.servlet;

import lol.dal.*;
import lol.model.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.annotation.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/itemprofile")
public class ItemProfile extends HttpServlet {
	protected ItemDao itemDao;
	
	@Override
	public void init() throws ServletException {
		itemDao = ItemDao.getInstance();
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
        }
        
        String itemIdString = req.getParameter("id");
        if (itemIdString == null || itemIdString.trim().isEmpty()) {
            messages.put("success", "Please enter a valid item ID.");
        } else {
            int itemId = Integer.parseInt(itemIdString);

        	// Retrieve , and store as a message.
        	try {
            	Item item = itemDao.getItemFromID(itemId);
            	req.setAttribute("item", item);
            } catch (SQLException e) {
    			e.printStackTrace();
    			throw new IOException(e);
            }
        }
        
        req.getRequestDispatcher("/ItemProfile.jsp").forward(req, resp);
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);
        //Just render the JSP.   
        req.getRequestDispatcher("/ItemProfile.jsp").forward(req, resp);
	}
}