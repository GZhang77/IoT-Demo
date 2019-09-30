package com.iot.sensor.security;

import com.iot.sensor.Constant.TokenConstant;
import com.iot.sensor.Util.UrlUtil;
import com.iot.sensor.model.User;
import com.iot.sensor.security.UserAuthentication.UserAuthentication;
import com.iot.sensor.service.UserService;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.naming.NoPermissionException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import io.jsonwebtoken.Claims;

public class JwtAuthFilter extends OncePerRequestFilter {

    @Autowired
    private UserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        try {
            String jwt = getJwtFromRequest(request);
            String requestUri = request.getRequestURI();

            if(UrlUtil.isAuthUrl(requestUri) || UrlUtil.isSaveUrl(requestUri)) {

            } else {
                if(jwt == null)
                    throw new NoPermissionException();
                Long userId = getUserIdFromJWT(jwt);
                User user = userService.get(userId);
                if (user == null)
                    throw new NoPermissionException();

                UserAuthentication auth = new UserAuthentication();
                auth.setAuthenticated(true);
                auth.setUser(user);
                SecurityContextHolder.getContext().setAuthentication(auth);
            }

            filterChain.doFilter(request, response);
        } catch (NoPermissionException e) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("You are trying to access resource that not allowed.");
            response.getWriter().flush();
            response.getWriter().close();
        }
    }

    private String getJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring("Bearer ".length());
        }
        return null;
    }

    public Long getUserIdFromJWT(String token) {

        Claims claims = Jwts.parser()
                .setSigningKey(TokenConstant.tokenSecret)
                .parseClaimsJws(token)
                .getBody();

        return Long.parseLong(claims.getSubject());
    }

}
