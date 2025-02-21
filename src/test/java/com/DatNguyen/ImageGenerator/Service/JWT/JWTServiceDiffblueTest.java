package com.DatNguyen.ImageGenerator.Service.JWT;

import com.DatNguyen.ImageGenerator.Entity.Users;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {JWTService.class})
@ExtendWith(SpringExtension.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
class JWTServiceDiffblueTest {
    @Autowired
    private JWTService jWTService;

    /**
     * Test {@link JWTService#extractClaim(String, Function)}.
     * <ul>
     *   <li>When {@code ABC123}.</li>
     * </ul>
     * <p>
     * Method under test: {@link JWTService#extractClaim(String, Function)}
     */
    @Test
    @DisplayName("Test extractClaim(String, Function); when 'ABC123'")
    @Disabled("TODO: Complete this test")
    @Tag("MaintainedByDiffblue")
    void testExtractClaim_whenAbc123() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   io.jsonwebtoken.security.WeakKeyException: The specified key byte array is 136 bits which is not secure enough for any JWT HMAC-SHA algorithm.  The JWT JWA Specification (RFC 7518, Section 3.2) states that keys used with HMAC-SHA algorithms MUST have a size >= 256 bits (the key size must be greater than or equal to the hash output size).  Consider using the io.jsonwebtoken.security.Keys#secretKeyFor(SignatureAlgorithm) method to create a key guaranteed to be secure enough for your preferred HMAC-SHA algorithm.  See https://tools.ietf.org/html/rfc7518#section-3.2 for more information.
        //       at io.jsonwebtoken.security.Keys.hmacShaKeyFor(Keys.java:96)
        //       at com.DatNguyen.ImageGenerator.Service.JWT.JWTService.getSignInKey(JWTService.java:24)
        //       at com.DatNguyen.ImageGenerator.Service.JWT.JWTService.extractAllClaims(JWTService.java:30)
        //       at com.DatNguyen.ImageGenerator.Service.JWT.JWTService.extractClaim(JWTService.java:38)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange and Act
        jWTService.extractClaim("ABC123", null);
    }

    /**
     * Test {@link JWTService#extractEmail(String)}.
     * <p>
     * Method under test: {@link JWTService#extractEmail(String)}
     */
    @Test
    @DisplayName("Test extractEmail(String)")
    @Disabled("TODO: Complete this test")
    @Tag("MaintainedByDiffblue")
    void testExtractEmail() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   io.jsonwebtoken.security.WeakKeyException: The specified key byte array is 136 bits which is not secure enough for any JWT HMAC-SHA algorithm.  The JWT JWA Specification (RFC 7518, Section 3.2) states that keys used with HMAC-SHA algorithms MUST have a size >= 256 bits (the key size must be greater than or equal to the hash output size).  Consider using the io.jsonwebtoken.security.Keys#secretKeyFor(SignatureAlgorithm) method to create a key guaranteed to be secure enough for your preferred HMAC-SHA algorithm.  See https://tools.ietf.org/html/rfc7518#section-3.2 for more information.
        //       at io.jsonwebtoken.security.Keys.hmacShaKeyFor(Keys.java:96)
        //       at com.DatNguyen.ImageGenerator.Service.JWT.JWTService.getSignInKey(JWTService.java:24)
        //       at com.DatNguyen.ImageGenerator.Service.JWT.JWTService.extractAllClaims(JWTService.java:30)
        //       at com.DatNguyen.ImageGenerator.Service.JWT.JWTService.extractClaim(JWTService.java:38)
        //       at com.DatNguyen.ImageGenerator.Service.JWT.JWTService.extractEmail(JWTService.java:44)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange and Act
        jWTService.extractEmail("ABC123");
    }

    /**
     * Test {@link JWTService#tokenGenerator(Map, UserDetails, long)} with {@code extraClaims}, {@code userDetails}, {@code time}.
     * <ul>
     *   <li>When {@link HashMap#HashMap()}.</li>
     * </ul>
     * <p>
     * Method under test: {@link JWTService#tokenGenerator(Map, UserDetails, long)}
     */
    @Test
    @DisplayName("Test tokenGenerator(Map, UserDetails, long) with 'extraClaims', 'userDetails', 'time'; when HashMap()")
    @Disabled("TODO: Complete this test")
    @Tag("MaintainedByDiffblue")
    void testTokenGeneratorWithExtraClaimsUserDetailsTime_whenHashMap() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   io.jsonwebtoken.security.WeakKeyException: The specified key byte array is 136 bits which is not secure enough for any JWT HMAC-SHA algorithm.  The JWT JWA Specification (RFC 7518, Section 3.2) states that keys used with HMAC-SHA algorithms MUST have a size >= 256 bits (the key size must be greater than or equal to the hash output size).  Consider using the io.jsonwebtoken.security.Keys#secretKeyFor(SignatureAlgorithm) method to create a key guaranteed to be secure enough for your preferred HMAC-SHA algorithm.  See https://tools.ietf.org/html/rfc7518#section-3.2 for more information.
        //       at io.jsonwebtoken.security.Keys.hmacShaKeyFor(Keys.java:96)
        //       at com.DatNguyen.ImageGenerator.Service.JWT.JWTService.getSignInKey(JWTService.java:24)
        //       at com.DatNguyen.ImageGenerator.Service.JWT.JWTService.tokenGenerator(JWTService.java:56)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        HashMap<String, Object> extraClaims = new HashMap<>();

        // Act
        jWTService.tokenGenerator(extraClaims, new Users(), 10L);
    }

    /**
     * Test {@link JWTService#tokenGenerator(UserDetails, long)} with {@code userDetails}, {@code time}.
     * <ul>
     *   <li>When {@link Users#Users()}.</li>
     * </ul>
     * <p>
     * Method under test: {@link JWTService#tokenGenerator(UserDetails, long)}
     */
    @Test
    @DisplayName("Test tokenGenerator(UserDetails, long) with 'userDetails', 'time'; when Users()")
    @Disabled("TODO: Complete this test")
    @Tag("MaintainedByDiffblue")
    void testTokenGeneratorWithUserDetailsTime_whenUsers() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   io.jsonwebtoken.security.WeakKeyException: The specified key byte array is 136 bits which is not secure enough for any JWT HMAC-SHA algorithm.  The JWT JWA Specification (RFC 7518, Section 3.2) states that keys used with HMAC-SHA algorithms MUST have a size >= 256 bits (the key size must be greater than or equal to the hash output size).  Consider using the io.jsonwebtoken.security.Keys#secretKeyFor(SignatureAlgorithm) method to create a key guaranteed to be secure enough for your preferred HMAC-SHA algorithm.  See https://tools.ietf.org/html/rfc7518#section-3.2 for more information.
        //       at io.jsonwebtoken.security.Keys.hmacShaKeyFor(Keys.java:96)
        //       at com.DatNguyen.ImageGenerator.Service.JWT.JWTService.getSignInKey(JWTService.java:24)
        //       at com.DatNguyen.ImageGenerator.Service.JWT.JWTService.tokenGenerator(JWTService.java:56)
        //       at com.DatNguyen.ImageGenerator.Service.JWT.JWTService.tokenGenerator(JWTService.java:61)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange and Act
        jWTService.tokenGenerator(new Users(), 10L);
    }

    /**
     * Test {@link JWTService#extractExpiration(String)}.
     * <p>
     * Method under test: {@link JWTService#extractExpiration(String)}
     */
    @Test
    @DisplayName("Test extractExpiration(String)")
    @Disabled("TODO: Complete this test")
    @Tag("MaintainedByDiffblue")
    void testExtractExpiration() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   io.jsonwebtoken.security.WeakKeyException: The specified key byte array is 136 bits which is not secure enough for any JWT HMAC-SHA algorithm.  The JWT JWA Specification (RFC 7518, Section 3.2) states that keys used with HMAC-SHA algorithms MUST have a size >= 256 bits (the key size must be greater than or equal to the hash output size).  Consider using the io.jsonwebtoken.security.Keys#secretKeyFor(SignatureAlgorithm) method to create a key guaranteed to be secure enough for your preferred HMAC-SHA algorithm.  See https://tools.ietf.org/html/rfc7518#section-3.2 for more information.
        //       at io.jsonwebtoken.security.Keys.hmacShaKeyFor(Keys.java:96)
        //       at com.DatNguyen.ImageGenerator.Service.JWT.JWTService.getSignInKey(JWTService.java:24)
        //       at com.DatNguyen.ImageGenerator.Service.JWT.JWTService.extractAllClaims(JWTService.java:30)
        //       at com.DatNguyen.ImageGenerator.Service.JWT.JWTService.extractClaim(JWTService.java:38)
        //       at com.DatNguyen.ImageGenerator.Service.JWT.JWTService.extractExpiration(JWTService.java:66)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange and Act
        jWTService.extractExpiration("ABC123");
    }

    /**
     * Test {@link JWTService#isExpiredToken(String)}.
     * <p>
     * Method under test: {@link JWTService#isExpiredToken(String)}
     */
    @Test
    @DisplayName("Test isExpiredToken(String)")
    @Disabled("TODO: Complete this test")
    @Tag("MaintainedByDiffblue")
    void testIsExpiredToken() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   io.jsonwebtoken.security.WeakKeyException: The specified key byte array is 136 bits which is not secure enough for any JWT HMAC-SHA algorithm.  The JWT JWA Specification (RFC 7518, Section 3.2) states that keys used with HMAC-SHA algorithms MUST have a size >= 256 bits (the key size must be greater than or equal to the hash output size).  Consider using the io.jsonwebtoken.security.Keys#secretKeyFor(SignatureAlgorithm) method to create a key guaranteed to be secure enough for your preferred HMAC-SHA algorithm.  See https://tools.ietf.org/html/rfc7518#section-3.2 for more information.
        //       at io.jsonwebtoken.security.Keys.hmacShaKeyFor(Keys.java:96)
        //       at com.DatNguyen.ImageGenerator.Service.JWT.JWTService.getSignInKey(JWTService.java:24)
        //       at com.DatNguyen.ImageGenerator.Service.JWT.JWTService.extractAllClaims(JWTService.java:30)
        //       at com.DatNguyen.ImageGenerator.Service.JWT.JWTService.extractClaim(JWTService.java:38)
        //       at com.DatNguyen.ImageGenerator.Service.JWT.JWTService.extractExpiration(JWTService.java:66)
        //       at com.DatNguyen.ImageGenerator.Service.JWT.JWTService.isExpiredToken(JWTService.java:71)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange and Act
        jWTService.isExpiredToken("ABC123");
    }

    /**
     * Test {@link JWTService#isTokenValidate(String, UserDetails)}.
     * <p>
     * Method under test: {@link JWTService#isTokenValidate(String, UserDetails)}
     */
    @Test
    @DisplayName("Test isTokenValidate(String, UserDetails)")
    @Disabled("TODO: Complete this test")
    @Tag("MaintainedByDiffblue")
    void testIsTokenValidate() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   io.jsonwebtoken.security.WeakKeyException: The specified key byte array is 136 bits which is not secure enough for any JWT HMAC-SHA algorithm.  The JWT JWA Specification (RFC 7518, Section 3.2) states that keys used with HMAC-SHA algorithms MUST have a size >= 256 bits (the key size must be greater than or equal to the hash output size).  Consider using the io.jsonwebtoken.security.Keys#secretKeyFor(SignatureAlgorithm) method to create a key guaranteed to be secure enough for your preferred HMAC-SHA algorithm.  See https://tools.ietf.org/html/rfc7518#section-3.2 for more information.
        //       at io.jsonwebtoken.security.Keys.hmacShaKeyFor(Keys.java:96)
        //       at com.DatNguyen.ImageGenerator.Service.JWT.JWTService.getSignInKey(JWTService.java:24)
        //       at com.DatNguyen.ImageGenerator.Service.JWT.JWTService.extractAllClaims(JWTService.java:30)
        //       at com.DatNguyen.ImageGenerator.Service.JWT.JWTService.extractClaim(JWTService.java:38)
        //       at com.DatNguyen.ImageGenerator.Service.JWT.JWTService.extractEmail(JWTService.java:44)
        //       at com.DatNguyen.ImageGenerator.Service.JWT.JWTService.isTokenValidate(JWTService.java:76)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange and Act
        jWTService.isTokenValidate("ABC123", new Users());
    }
}
