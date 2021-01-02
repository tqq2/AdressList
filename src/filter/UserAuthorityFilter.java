//package filter;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.annotation.WebInitParam;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
///**
// * 访问权限过滤器
// *
// */
////urlPatterns 过滤器拦截的url
//@WebFilter(
//        urlPatterns = { "/addresslist.jsp","/userslist.jsp","/update.jsp","/add.jsp" ,"/export.jsp","/Admupdate.jsp","/Admadd.jsp"},
//        initParams = { @WebInitParam(name = "loginPage", value = "login.jsp") },
//        dispatcherTypes = { DispatcherType.REQUEST, DispatcherType.FORWARD })
//public class UserAuthorityFilter implements Filter {
//
//    private String loginPage = "login.jsp";
//
//    public UserAuthorityFilter() {
//
//    }
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//
//        // 获取当请求被拦截时转向的页面
//        loginPage = filterConfig.getInitParameter("loginPage");
//        if (null == loginPage) {
//            loginPage = "login.jsp";
//        }
//    }
//
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//
//        //业务逻辑
//        HttpServletRequest req = (HttpServletRequest) servletRequest;
//        HttpServletResponse resp = (HttpServletResponse) servletResponse;
//        HttpSession session = req.getSession();
//        // 判断被拦截的请求用户是否处于登录状态
//        if (session.getAttribute("user") == null) {
//            // 获取被拦截的请求地址及参数
//            String requestPath = req.getRequestURI();
//            if (req.getQueryString() != null) {
//                requestPath += "?" + req.getQueryString();
//            }
//            // 将请求地址保存到request对象中转发到登录页面
//            req.setAttribute("requestPath", requestPath);
//            servletRequest.getRequestDispatcher( "/" + loginPage)
//                    .forward(servletRequest, servletResponse);
//            return;
//        } else {
//            //将当前拦截的请求放行，让请求继续访问他要访问的资源
//            filterChain.doFilter(servletRequest, servletResponse);
//        }
//    }
//
//    @Override
//    public void destroy() {
//        this.loginPage = null;
//
//    }
//}
