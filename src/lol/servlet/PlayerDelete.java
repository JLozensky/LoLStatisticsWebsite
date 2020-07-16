
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

@WebServlet("/playerdelete")
public class PlayerDelete extends HttpServlet {
	
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
        //Just render the JSP.   
        req.getRequestDispatcher("/PlayerDelete.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        // Retrieve and validate name.
        String id = req.getParameter("accountId");
        if (id == null || id.trim().isEmpty()) {
            messages.put("title", "Invalid accountId");
            messages.put("disableSubmit", "true");
        } else {
        	int accountId = Integer.parseInt(id);
        	// Delete the BlogUser.
	        ParticipantIdentity player = new ParticipantIdentity(accountId);
	        try {
	        	player = pid.delete(player);
	        	// Update the message.
		        if (player == null) {
		            messages.put("title", "Successfully deleted " + accountId);
		            messages.put("disableSubmit", "true");
		        } else {
		        	messages.put("title", "Failed to delete " + accountId);
		        	messages.put("disableSubmit", "false");
		        }
	        } catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        }
        
        req.getRequestDispatcher("/PlayerDelete.jsp").forward(req, resp);
    }

}