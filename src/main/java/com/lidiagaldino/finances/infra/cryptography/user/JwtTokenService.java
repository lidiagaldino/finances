package com.lidiagaldino.finances.infra.cryptography.user;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Component;

import com.lidiagaldino.finances.domain.entities.User;
import com.lidiagaldino.finances.domain.interfaces.Session;

@Component
public class JwtTokenService implements Session {
  @Value("${jwt.secret}")
  private String secretKey;

  @Value("${jwt.expiration}")
  private long expirationTime;
  private final JwtEncoder jwtEncoder;

  public JwtTokenService(JwtEncoder jwtEncoder) {
    this.jwtEncoder = jwtEncoder;
  }

  @Override
  public String generateToken(User user) {
    var now = Instant.now();
    var claims = JwtClaimsSet.builder()
                .issuer("finances")
                .subject(user.getId().toString())
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expirationTime))
                .build();
    var jwtValue = jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    return jwtValue;
  }

  // @Override
  // public String getUsernameFromToken(String token) {
  //   // TODO Auto-generated method stub
  //   throw new UnsupportedOperationException("Unimplemented method 'getUsernameFromToken'");
  // }
}
