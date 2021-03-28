package com.techno.college.auth.config;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTTokenUtil implements Serializable{
	private static final long serialVersionUID = 5580304588065793484L;
	private static final long JWT_TOKEN_VALIDITY = 5*60*60;
	
	@Value("${jwt.secret}")
	private String secret;
	
	//retrieve user name from jwt token
	public String getUserNamefromToken(String token){
		return getClaimFromToken(token, Claims::getSubject);
	}
	
	public Date getExpirationDateFromToken(String token){
		return getClaimFromToken(token, Claims::getExpiration);
	}
	
	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver){
		Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}
	public Claims getAllClaimsFromToken(String token){
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	}
	
	//if token is expired?
	private Boolean isTokenExpired(String token){
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}
	
	//generate token for user
	public String generateToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<>();
		return doGenerateToken(claims, userDetails.getUsername());
	}	
	
	private String doGenerateToken(Map<String, Object> claims, String subject) {

		return Jwts.builder()
				.setClaims(claims)
				.setSubject(subject)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
				.signWith(SignatureAlgorithm.HS512, secret)
				.compact();
	}
	
	//validate token
		public Boolean validateToken(String token, UserDetails userDetails) {
			final String username = getUserNamefromToken(token);
			return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
		}
}
