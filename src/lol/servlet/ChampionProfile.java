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

@WebServlet("/championprofile")
public class ChampionProfile extends HttpServlet {
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

        Champions champion;
        
        String stringChampionID = req.getParameter("id");
        if (stringChampionID == null || stringChampionID.trim().isEmpty()) {
            messages.put("success", "Please enter a valid champion ID.");
        } else {
            int championID = Integer.parseInt(stringChampionID);

        	// Retrieve , and store as a message.
        	try {
            	champion = championsDao.getChampionFromID(championID);
            	req.setAttribute("champion", champion);
            } catch (SQLException e) {
    			e.printStackTrace();
    			throw new IOException(e);
            }
        	
        }
        
        req.getRequestDispatcher("/ChampionProfile.jsp").forward(req, resp);
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);
        //Just render the JSP.   
        req.getRequestDispatcher("/ChampionProfile.jsp").forward(req, resp);
	}
}