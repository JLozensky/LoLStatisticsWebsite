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

@WebServlet("/finditems")
public class FindItems extends HttpServlet {
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

        List<Item> items = new ArrayList<Item>();    
        String itemName = req.getParameter("itemName");

        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        if (username == null || username.trim().isEmpty()) {
        	messages.put("loggedIn", "false");
        } else {
        	messages.put("loggedIn", "true");
        }
        
    	// Retrieve , and store as a message.
    	try {
    		items = itemDao.getDistinctItems(itemName);
            req.setAttribute("items", items);

        } catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
        }
        
    	if (itemName == null || itemName.trim().isEmpty()) {
        	messages.put("success", "Displaying all items");
        	items.clear();
    	} else {
        	messages.put("success", "Displaying results for item name '" + itemName + "'");
    	}
    	
    	messages.put("noresults", "false");
        
        
        req.getRequestDispatcher("/FindItems.jsp").forward(req, resp);
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
        	messages.put("loggedIn", "false");
        } else {
        	messages.put("loggedIn", "true");
        }
        
        String itemName = req.getParameter("itemName");
        List<Item> items = new ArrayList<Item>();

    	try {
    		items = itemDao.getDistinctItems(itemName);
    		if (items.size() == 0) {
        		messages.put("noresults", "true");
        	}
            req.setAttribute("items", items);

        } catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
        }
        
    	if (itemName == null || itemName.trim().isEmpty()) {
        	messages.put("success", "Displaying all items");
    	} else {
        	messages.put("success", "Displaying results for item name '" + itemName + "'");
    	}
        
        req.getRequestDispatcher("/FindItems.jsp").forward(req, resp);
    	
    }
}