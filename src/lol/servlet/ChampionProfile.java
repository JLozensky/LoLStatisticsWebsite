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

@WebServlet("/championprofile")
public class ChampionProfile extends HttpServlet {
	protected ChampionsDao championsDao;
	protected ItemDao itemDao;
	protected SummonerSpellsDao summonerSpellsDao;
	
	@Override
	public void init() throws ServletException {
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
        	messages.put("loggedIn", "false");
        } else {
        	messages.put("loggedIn", "true");
        }
        
        Champions champion;
        String stringChampionID = req.getParameter("id");
        if (stringChampionID == null || stringChampionID.trim().isEmpty()) {
            messages.put("success", "Please enter a valid champion ID.");
        } else {
            int championID = Integer.parseInt(stringChampionID);

        	// Retrieve , and store as a message.
        	try {
            	champion = championsDao.getChampionFromID(championID);
            	
            	List<Champions> top10BestChampions = championsDao.getBestChampionsToFightAgainst(champion);
            	List<Champions> top10WorstChampions = championsDao.getWorstChampionsToFightAgainst(champion);
            	List<Item> bestItems = itemDao.getBestItemsToUse(champion);
            	List<SummonerSpells> bestSpells = summonerSpellsDao.getBestSummonerSpells(champion);
            	
            	req.setAttribute("top10BestChampions", top10BestChampions);
            	req.setAttribute("top10WorstChampions", top10WorstChampions);
            	req.setAttribute("bestItems", bestItems);
            	req.setAttribute("bestSpells", bestSpells);

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