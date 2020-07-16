//package lol.servlet;
//
//
//import lol.dal.*;
//import lol.model.*;
//
//import java.io.IOException;
//import java.sql.SQLException;
//import java.text.DateFormat;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.servlet.annotation.*;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//
//
//
//
//@WebServlet("/playercreate") 
//public class PlayerCreate {
//	
//	protected ParticipantIdentityDao pid;
//	
//	@Override
//	public void inti() throws ServletException {
//		pid = ParticipantIdentity.getInstance();
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
//        	String firstName = req.getParameter("firstname");
//        	String lastName = req.getParameter("lastname");
//        	String SummonerName = req.getParameter("SummonerName");
//        	
//        	try {
//	        	// Exercise: parse the input for StatusLevel.
//	        	ParticipantIdentity player = new ParticipantIdentity(SummonerName, firstName, lastName);
//	        	player = pid.create(player);
//	        	messages.put("success", "Successfully created " + SummonerName);
//	        } catch (SQLException e) {
//				e.printStackTrace();
//				throw new IOException(e);
//	        }
//   
//        
//        req.getRequestDispatcher("/PlayerCreate.jsp").forward(req, resp);
//        }
//	
//	
//	
//	}
//
//}
