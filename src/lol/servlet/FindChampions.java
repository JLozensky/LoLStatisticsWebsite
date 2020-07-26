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
        req.setAttribute("champions", champions);
        
        req.getRequestDispatcher("/FindChampions.jsp").forward(req, resp);
    }
}

/**
 * FindUsers is the primary entry point into the application.
 * 
 * Note the logic for doGet() and doPost() are almost identical. However, there is a difference:
 * doGet() handles the http GET request. This method is called when you put in the /findusers
 * URL in the browser.
 * doPost() handles the http POST request. This method is called after you click the submit button.
 * 
 * To run:
 * 1. Run the SQL script to recreate your database schema: http://goo.gl/86a11H.
 * 2. Insert test data. You can do this by running blog.tools.Inserter (right click,
 *    Run As > JavaApplication.
 *    Notice that this is similar to Runner.java in our JDBC example.
 * 3. Run the Tomcat server at localhost.
 * 4. Point your browser to http://localhost:8080/BlogApplication/findusers.
 */
