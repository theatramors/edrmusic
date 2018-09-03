package amors.security;

import org.springframework.security.core.*;
import org.springframework.security.web.authentication.*;
import org.springframework.security.web.util.matcher.*;
import org.springframework.stereotype.*;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

@Component
public class JwtAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
    protected JwtAuthenticationFilter(RequestMatcher requiresAuthenticationRequestMatcher) {
        super(requiresAuthenticationRequestMatcher);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {
        return null;
    }
}
