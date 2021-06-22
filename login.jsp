<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet" href="./pages/static/main.css" />
<title>Customer System</title>
</head>
<body>
	<div class="tldesign-login">
		<div class="tldesign-login-header">
			<div class="header-title">Training</div>
		</div>
		<div class="tldesign-login-content">
			<div>Login</div>
			<div class="form-login">
				<div class="form-title" style="color: #3366ff">LOGIN</div>
				<div class="form">
					<div class="log login faild" id="status">
						<%
							if (request.getParameter("error") != null) {
								out.print("<p style='color:red'>ユーザーIDまたはパスワードが不正です。 </p>");
							}
						%>

					</div>
					<form id="formlogin" action="./loginServlet" method="post">

						<div class="form-group">
							<div class="text-label">
								<label>User Id:</label>
							</div>
							<%
								String username = (String) session.getAttribute("tendangnhap");
								if (username == null) {
									username = "";
								}
							%>
							<div class="text-input">
								<input class="text-field" type="text" name="txtusername"
									id="txtusername" value="<%=username%>" />
							</div>
						</div>
						<div class="form-group">
							<div class="text-label">
								<label>Password:</label>
							</div>
							<div class="text-input">
								<%
									String password = (String) session.getAttribute("matkhau");
									if (password == null) {
										password = "";
									}
								%>
								<input class="text-field" type="password" id="txtpassword"
									name="txtpassword" value="<%=password%>"
									onfocus='this.value = ""' />
							</div>
						</div>
						<div style="display: flex;">
							<button type="submit" class="btn-custom submit"
								style="margin-right: 5%;">Login</button>

						</div>
					</form>

					<button id="clear" class="btn-custom clear"
						style="margin-left: 5%;">Clear</button>

				</div>
			</div>
		</div>
		<div class="tldesign-login-footer">
			<div class="footer">Copyright (c) 2000 - 2008 FUJINET, ALL
				Rights Reserved</div>
		</div>
	</div>
	<script src="./pages/static/main.js"></script>
</body>
</html>
