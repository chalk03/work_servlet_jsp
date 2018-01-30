package example;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * p.208
 */

public class MakeCookieServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		resp.setCharacterEncoding("utf-8");

		// "최범균" 문자열을 URL 형식으로 변경하는데 utf-8 인코딩을 사용하겠다는 뜻
		String encodeName = URLEncoder.encode("최범균", "utf-8");
		
		// 쿠키 객체 생성 > name이라는 key에 encodeName 값을 저장
		Cookie cookie = new Cookie("name", encodeName);
		cookie.setMaxAge(60 * 60 * 1000);
		
		// 만든 쿠키를 쿠키 목록에  추가
		resp.addCookie(cookie);

		PrintWriter out = resp.getWriter();
		out.println(cookie.getName());
		
		// 쿠키의 값을 가져온다.
		out.println(" 쿠키의 값 = " + cookie.getValue());

		out.flush();
		out.close();
	}
}
