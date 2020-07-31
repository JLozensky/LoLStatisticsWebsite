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

@WebServlet("/findchampions")
public class FindChampions extends HttpServlet {
	protected ChampionsDao championsDao;
	
	@Override
	public void init() throws ServletException {
		championsDao = ChampionsDao.getInstance();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        List<Champions> champions = new ArrayList<Champions>();
        
        String championName = req.getParameter("championName");

        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        if (username == null || username.trim().isEmpty()) {
        	messages.put("loggedIn", "false");
        } else {
        	messages.put("loggedIn", "true");
        }
        
    	// Retrieve , and store as a message.
    	try {
        	champions = championsDao.getChampionsFromName(championName);
        } catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
        }
        
    	if (championName == null || championName.trim().isEmpty()) {
        	messages.put("success", "Displaying all champions");
    	} else {
        	messages.put("success", "Displaying results for champion name '" + championName + "'");
    	}
        
        req.setAttribute("champions", champions);
        
        req.getRequestDispatcher("/FindChampions.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        List<Champions> champions = new ArrayList<Champions>();
        
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        if (username == null || username.trim().isEmpty()) {
        	messages.put("loggedIn", "false");
        } else {
        	messages.put("loggedIn", "true");
        }
        
        // Retrieve and validate seasonId.
        // isWin and seasonId are retrieved from the form POST submission. By default, it
        // is populated by the URL query string (in FindChampions.jsp).
        String championName = req.getParameter("championName");
    	try {
        	champions = championsDao.getChampionsFromName(championName);
        } catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
        }
        
    	if (championName == null || championName.trim().isEmpty()) {
        	messages.put("success", "Displaying all champions");
    	} else {
        	messages.put("success", "Displaying results for champion name '" + championName + "'");
    	}
    	
    	if (champions.size() == 0) {
    		messages.put("noresults", "true");
    	}
        req.setAttribute("champions", champions);
        
        req.getRequestDispatcher("/FindChampions.jsp").forward(req, resp);
    }
}