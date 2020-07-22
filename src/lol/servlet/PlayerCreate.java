//package lol.servlet;
//
//
//import lol.model.*;
//
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.servlet.annotation.*;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@WebServlet("/playercreate") 
//public class PlayerCreate extends HttpServlet {
//	
//	protected ParticipantsDao pid;
//	
//	@Override
//	public void init() throws ServletException {
//		pid = ParticipantsDao.getInstance();
//	}
//	
//	@Override
//	public void doGet(HttpServletRequest req, HttpServletResponse resp)
//			throws ServletException, IOException {
//		// Map for storing messages.
//        Map<String, String> messages = new HashMap<String, String>();
//        req.setAttribute("messages", messages);
//        //Just render the JSP.   
//        req.getRequestDispatcher("/PlayerCreate.jsp").forward(req, resp);
//	}
//	
//	@Override
//    public void doPost(HttpServletRequest req, HttpServletResponse resp)
//    		throws ServletException, IOException {
//        // Map for storing messages.
//        Map<String, String> messages = new HashMap<String, String>();
//        req.setAttribute("messages", messages);
//
//        // Retrieve and validate name.
//        String id = req.getParameter("accountId");
//        if (id == null || id.trim().isEmpty()) {
//            messages.put("success", "Invalid AccountId");
//        } else {
//        	// Create the Player.
//        	String accountId = id;
//        	String player = req.getParameter("player");
//        	String firstName = req.getParameter("firstName");
//        	String lastName = req.getParameter("lastName");
//        	String summonerName = req.getParameter("summonerName");
//        	String summonerId = req.getParameter("summonerId");
//        	
//        	try {
//	        	Summoner summoner = 
//	        			new Summoner(accountId,
//	        					firstName, lastName, player, summonerName, summonerId, 
//	        					"", "", "", -1L);
//	        	summoner = pid.create(summoner);
//	        	messages.put("success", "Successfully created " + accountId);
//	        } catch (SQLException e) {
//				e.printStackTrace();
//				throw new IOException(e);
//	        }
//          
//        req.getRequestDispatcher("/PlayerCreate.jsp").forward(req, resp);
//        }
//	}
//
//}
