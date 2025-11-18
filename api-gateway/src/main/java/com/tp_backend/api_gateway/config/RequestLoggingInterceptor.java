package com.tp_backend.api_gateway.config;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class RequestLoggingInterceptor implements HandlerInterceptor {

    // filtro pre (antes de enviar petición al microservicio)
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        System.out.println(
                "\n[API-GATEWAY] >>> Nueva petición" +
                "\nMétodo: " + request.getMethod() +
                "\nPath: " + request.getRequestURI() +
                "\nTimestamp: " + System.currentTimeMillis()
        );

        return true;
    }

    // filtro post (después de recibir respuesta del microservicio)
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

        System.out.println(
                "\n[API-GATEWAY] <<< Respuesta completada" +
                "\nStatus: " + response.getStatus() +
                "\nPath: " + request.getRequestURI() +
                "\n"
        );
    }
}