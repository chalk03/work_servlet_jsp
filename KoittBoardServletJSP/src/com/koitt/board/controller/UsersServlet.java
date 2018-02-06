package com.koitt.board.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koitt.board.model.Command;
import com.koitt.board.model.users.JoinCommand;
import com.koitt.board.model.users.ListCommand;
import com.koitt.board.model.users.LoginCommand;

public class UsersServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doProcess(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doProcess(req, resp);
	}

	private void doProcess(HttpServletRequest req, HttpServletResponse resp) { 

		try {
			req.setCharacterEncoding("UTF-8");

			String cmd = req.getParameter("cmd");

			if (cmd == null || cmd.trim().length() == 0) {
				cmd = "CMD_LIST";
			}

			String page = null;
			Command command = null;

			switch (cmd) {
			
				case "CMD_LIST":
				command = new ListCommand();
				page = command.execute(req, resp);
				break;
				
				case "CMD_JOIN":
				command = new JoinCommand();
				page = command.execute(req, resp);
				break;
				
				case "CMD_LOGIN":
				command = new LoginCommand();
				page = command.execute(req, resp);
				break;
			}
			
			RequestDispatcher rd = req.getRequestDispatcher(page);
			rd.forward(req, resp);
		}
		catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
