package controllers.filters;

import utils.ServletsUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "AuthorizationFilter", urlPatterns = {"/users", "/messages", "/follow", "/unFollow", "/deleteTweet", "/addMessage"})
public class AuthorizationFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {

        String userLoginFromSession = ServletsUtils.getUserLoginFromSession((HttpServletRequest) req);
        if (userLoginFromSession == null) {
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
            return;
        }
        filterChain.doFilter(req, resp);
    }

    @Override
    public void destroy() {

    }


}
