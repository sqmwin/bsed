// package cn.bsed.filter;
//
// import org.springframework.web.filter.OncePerRequestFilter;
//
// import javax.servlet.*;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;
// import javax.servlet.http.HttpSession;
// import java.io.IOException;
//
// /**
//  * 登陆权限过滤器
//  *
//  * @author SQM
//  * @date 2018/1/18
//  * @version: 1.0
//  */
// public class CheckFilter extends OncePerRequestFilter {
//     private FilterConfig filterConfig;
//
//     @Override
//     protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//         HttpSession session = request.getSession(true);
//         if (session.getAttribute("user") != null) {
//             filterChain.doFilter(request, response);
//         } else {
//             ServletContext servletContext = filterConfig.getServletContext();
//             // setForwardURL(httpServletRequest);
//             servletContext.getRequestDispatcher("/admin/admin_login_page").forward(request, response);
//         }
//     }
// }
