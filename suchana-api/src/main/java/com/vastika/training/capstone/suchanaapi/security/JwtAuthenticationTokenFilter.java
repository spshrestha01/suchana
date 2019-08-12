package com.vastika.training.capstone.suchanaapi.security;

import com.vastika.training.capstone.suchanaapi.security.exceptions.JwtTokenMissingException;
import com.vastika.training.capstone.suchanaapi.security.models.JwtAuthenticationToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class JwtAuthenticationTokenFilter extends AbstractAuthenticationProcessingFilter {

    private static final int HEADER_LENGTH = 7;

    private static final List<RequestMatcher> PATHS = Arrays.asList(
            new AntPathRequestMatcher("/categories/**", HttpMethod.POST.name()),
            new AntPathRequestMatcher("/categories/**", HttpMethod.PUT.name()),
            new AntPathRequestMatcher("/tags/**", HttpMethod.GET.name()),
            new AntPathRequestMatcher("/tags/**", HttpMethod.POST.name()),
            new AntPathRequestMatcher("/tags/**", HttpMethod.PUT.name()),
            new AntPathRequestMatcher("/tags/**", HttpMethod.DELETE.name()),
            new AntPathRequestMatcher("/authors/**", HttpMethod.GET.name()),
            new AntPathRequestMatcher("/authors/**", HttpMethod.POST.name()),
            new AntPathRequestMatcher("/authors/**", HttpMethod.PUT.name()),
            new AntPathRequestMatcher("/authors/**", HttpMethod.DELETE.name())
    );

    public JwtAuthenticationTokenFilter() {
        super(new OrRequestMatcher(PATHS));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        String header = request.getHeader("Authorization");
        String authToken;

        if (header != null && header.startsWith("Bearer ")) {
            authToken = header.substring(HEADER_LENGTH);
        } else {
            throw new JwtTokenMissingException("No JWT token found in request headers");
        }

        JwtAuthenticationToken authRequest = new JwtAuthenticationToken(authToken);

        return getAuthenticationManager().authenticate(authRequest);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult)
            throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);
         log.info("Authenticated User: {}", authResult.getPrincipal());
         chain.doFilter(request, response);

    }
}
