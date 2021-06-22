package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import source.AccountDAO;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userid = request.getParameter("txtusername");
		String password = request.getParameter("txtpassword");

		boolean isValid = AccountDAO.checkLogin(userid, password);

		if (isValid) {
			//thiet lap gia tri trong session
			session.setAttribute("tendangnhap", userid);

			RequestDispatcher dispatcher = request.getRequestDispatcher("Search.jsp");
			dispatcher.forward(request, response);
		} else {
			session.setAttribute("tendangnhap", userid);
			session.setAttribute("matkhau", password);
			response.sendRedirect(request.getContextPath() + "/login.jsp?error=0");
		}

	}
}
