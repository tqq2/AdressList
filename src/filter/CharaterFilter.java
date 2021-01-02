package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

/**
 * 设置请求和响应编码
 *
 */
@WebFilter(
		filterName="CharaterFilter",
		initParams={@WebInitParam(name="encode",value="utf-8")},
		urlPatterns={"/*"}
		)
public class CharaterFilter implements Filter {
	private String encode;
	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(encode);
		response.setCharacterEncoding(encode);
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		encode = arg0.getInitParameter("encode");
	}

}
