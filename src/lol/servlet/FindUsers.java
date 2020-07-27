package lol.servlet;

import lol.model.*;
import lol.dal.*;
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


@WebServlet("/findusers")
public class FindUsers extends HttpServlet {
	
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

        Users user = null;
        /*

        String sn = req.getParameter("summonername");
        if (sn == null || sn.trim().isEmpty()) {
            messages.put("success", "Please enter a valid starting string for the summoner name.");
        } else {
        	try {
        		user = userDao.getUserFromSummonerName(sn);
            } catch (SQLException e) {
    			e.printStackTrace();
    			throw new IOException(e);
            }
        	messages.put("success", "Displaying results with " + sn);

        }*/
        req.setAttribute("user", user);
        
        req.getRequestDispatcher("/FindUser.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        Users user = null;
        Summoner summoner = null;
        /*
        String sn = req.getParameter("summonername");
        if (sn == null || sn.trim().isEmpty()) {
            messages.put("success", "Please enter a valid summoner name.");
        } else {
        	try {
        		user = userDao.getUserFromSummonerName(sn);
        		if (user == null) {
        			messages.put("success", "User not registered, not data to display");
        		} else {
        			summoner = userDao.getUserDetail(sn);
        			messages.put("success", "Displaying results for " + sn);
        		}
            } catch (SQLException e) {
    			e.printStackTrace();
    			throw new IOException(e);
            }
        }*/
        req.setAttribute("user", summoner);
        
        req.getRequestDispatcher("/FindUser.jsp").forward(req, resp);
    }
}
