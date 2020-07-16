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


@WebServlet("/playerupdate")
public class PlayerUpdate extends HttpServlet {
	
	protected ParticipantsDao pid;
	
	@Override
	public void init() throws ServletException {
		pid = ParticipantsDao.getInstance();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        // Retrieve user and validate.
        String id = req.getParameter("accountId");
        if (id == null || id.trim().isEmpty()) {
            messages.put("success", "Please enter a valid AccountId.");
        } else {
        	int accountId = Integer.parseInt(id);
        	try {
        		ParticipantIdentity player = pid.getParticipantFromId(accountId);
        		if(player == null) {
        			messages.put("success", "Player does not exist.");
        		}
        		req.setAttribute("Player", player);
        	} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        }
        
        req.getRequestDispatcher("/PlayerUpdate.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        // Retrieve user and validate.
        String id = req.getParameter("accountId");
        if (id == null || id.trim().isEmpty()) {
            messages.put("success", "Please enter a valid AccountId.");
        } else {
        	int accountId = Integer.parseInt(id);
        	try {
        		ParticipantIdentity player = pid.getParticipantFromId(accountId);
        		if(player == null) {
        			messages.put("success", "Player does not exist. No update to perform.");
        		} else {
        			String newLastName = req.getParameter("lastname");
        			if (newLastName == null || newLastName.trim().isEmpty()) {
        	            messages.put("success", "Please enter a valid LastName.");
        	        } else {
        	        	player= pid.updateParticipantSummonerName(player, newLastName);
        	        	messages.put("success", "Successfully updated " + accountId);
        	        }
        		}
        		req.setAttribute("player", player);
        	} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        }
        
        req.getRequestDispatcher("/UserUpdate.jsp").forward(req, resp);
    }
}
