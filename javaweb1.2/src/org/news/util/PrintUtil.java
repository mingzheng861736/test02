package org.news.util;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import com.alibaba.fastjson.*;
public class PrintUtil {
	private static void print(String msg, HttpServletResponse response) {
		PrintWriter out = null;
		try {
			if (response != null) {
				out = response.getWriter();
				out.print(msg);
				out.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}
	public static void write(ReturnResult returnresult, HttpServletResponse response) {
		String msg = JSON.toJSONString(returnresult);
		
		print(msg, response);
	}
	public static void write(ReturnResult returnresult, HttpServletResponse response, String dateFormat) {
		String msg = JSON.toJSONStringWithDateFormat(returnresult, dateFormat);
		print(msg, response);
	}
}
