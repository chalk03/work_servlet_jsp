package example;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteCookieServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
		Cookie[] cookies = req.getCookies();
		if(cookies != null && cookies.length > 0) {
			for(int i = 0; i<cookies.length; i++) {
				
				// key가 name인 쿠키를 찾는다.
				if(cookies[i].getName().equals("name")) {
					// 해당 쿠키값을 지운다.
					Cookie cookie = new Cookie("name", "");
					
					// 해당 쿠키의 생존기간을 0으로 설정한다.
					cookie.setMaxAge(0);
					
					// 다시 클라이언트에 해당 쿠키를 전달한다.
					resp.addCookie(cookie);
				}
			}
		}
	}
}
