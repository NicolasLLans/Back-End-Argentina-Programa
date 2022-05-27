package com.Porfolio.AP.security.jwt;

import com.Porfolio.AP.security.entity.UsuarioPrincipal;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class JwtProvaider {
    
        private final static Logger logger = LoggerFactory.getLogger(JwtProvaider.class);

        @Value("${jwt.secret}")
        private String secret;
        
        @Value("${jwt.expiration}")
        private int expiration;
        
        public String generateToken(Authentication authentication){
            UsuarioPrincipal usuarioPrincipal = (UsuarioPrincipal) authentication.getPrincipal();
            return Jwts.builder().setSubject(usuarioPrincipal.getUsername())
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(new Date()
                    .getTime() + expiration * 1000))
                    .signWith(SignatureAlgorithm.HS512,secret).compact();
        }
        
        public String getNombreUsuarioFromToken(String token){
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
        }
        
        public boolean validateToken(String token){
            try{
                Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
                return true;
            }catch(MalformedJwtException excep){
                logger.error("token mal formado");
            }catch(UnsupportedJwtException excep){
                logger.error("token no soportado");
            }catch(ExpiredJwtException excep){
                logger.error("token expirado");
            }catch(IllegalArgumentException excep){
                logger.error("token vacio");
            }catch(SignatureException excep){
                logger.error("falló la firma");
            }
            return false;
        }

}
