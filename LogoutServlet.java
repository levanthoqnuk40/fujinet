package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");

		PrintWriter pw = resp.getWriter();
		try {
			// lay ve session hien tai
			HttpSession session = req.getSession();
			// huy session
			session.invalidate();
			// quay ve form dang nhap
			RequestDispatcher dispatch = getServletContext().getRequestDispatcher("/login.jsp");
			dispatch.forward(req, resp);
		} finally {
			pw.close();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
