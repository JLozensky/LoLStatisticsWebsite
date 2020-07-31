package lol.servlet;

import lol.dal.*;
import lol.model.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.annotation.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/userprofile")
public class UserProfile extends HttpServlet {
	protected UserDao userDao;
	protected ChampionsDao championsDao;
	protected ItemDao itemDao;
	protected SummonerSpellsDao summonerSpellsDao;
	
	@Override
	public void init() throws ServletException {
		userDao = UserDao.getInstance();
		championsDao = ChampionsDao.getInstance();
		itemDao = ItemDao.getInstance();
		summonerSpellsDao = SummonerSpellsDao.getInstance();
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
        	messages.put("error", "You're not logged in!");
        	messages.put("showError", "true");
        } else {
        	// Retrieve , and store as a message.
        	try {
        		
            	Users user = userDao.getUserFromUserName(username);
            	
            	List<Champions> top10BestChampions = championsDao.getBestChampionsToFightAgainst(user);
            	List<Champions> top10WorstChampions = championsDao.getWorstChampionsToFightAgainst(user);
            	List<Item> bestItems = itemDao.getBestItemsToUse(user);
            	List<SummonerSpells> bestSpells = summonerSpellsDao.getBestSummonerSpells(user);
            	
            	req.setAttribute("top10BestChampions", top10BestChampions);
            	req.setAttribute("top10WorstChampions", top10WorstChampions);
            	req.setAttribute("bestItems", bestItems);
            	req.setAttribute("bestSpells", bestSpells);
            	
            	req.setAttribute("user", user);
            } catch (SQLException e) {
    			e.printStackTrace();
    			throw new IOException(e);
            }
        }

        req.getRequestDispatcher("/UserProfile.jsp").forward(req, resp);
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);
        messages.put("isError", "false");

        req.getRequestDispatcher("/UserProfile.jsp").forward(req, resp);
	}
}