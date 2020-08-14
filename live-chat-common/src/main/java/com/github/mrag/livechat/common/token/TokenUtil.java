package com.github.mrag.livechat.common.token;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Token工具类
 *
 * @author Gmw
 */
public final class TokenUtil {
    private static final Logger log = LoggerFactory.getLogger(TokenUtil.class);
    private static ObjectMapper objectMapper = null;
    private static MACSigner signer = null;
    private static MACVerifier verifier = null;
    // SECRET_KEY 长度必须为256位，也就是32个字节，md5编码刚好匹配长度
    private static final String SECRET_KEY = DigestUtils.md5Hex("mrag.io");
    private static final JWSHeader COMMON_HEADER = new JWSHeader(JWSAlgorithm.HS256);

    static {
        try {
            signer = new MACSigner(SECRET_KEY);
            verifier = new MACVerifier(SECRET_KEY);

            // 初始化常规的objectMapper
            DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            JavaTimeModule module = new JavaTimeModule();
            module.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(f));
            module.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(f));
            objectMapper = new ObjectMapper().registerModule(module);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    /**
     * 生成jwt token
     *
     * @param payload 待序列化的payload
     * @return 序列化后的jwt字符串
     * @throws Exception payload序列化失败
     */
    public static String generateToken(TokenPayload payload) throws Exception {
        JWSObject jwsObject = new JWSObject(COMMON_HEADER,
                // JsonProcessingException payload序列化失败
                new Payload(objectMapper.writeValueAsString(payload)));
        try {
            jwsObject.sign(signer);
        } catch (JOSEException ignored) {
            // 不可能
        }
        return jwsObject.serialize();
    }

    /**
     * 解析 jwt token
     *
     * @param token jwt token
     * @param type  解析后的java类型
     * @param <R>   泛型
     * @return 解析后的对象
     * @throws Exception 解析异常
     */
    public static <R extends TokenPayload> R parseToken(String token, Class<R> type) throws Exception {
        // ParseException token解析失败
        JWSObject jwsObject = JWSObject.parse(token);
        if (jwsObject.verify(verifier)) {
            String json = jwsObject.getPayload().toString();
            // JsonProcessingException json解析失败
            return objectMapper.readValue(json, type);
        }
        throw new Exception("Failed to verify signature.");
    }

    /*
     * 测试一下jose-jwt的比较通用的功能。
     * 实际上我写的Authetication已经实现了这个功能，没必要修改
     *
     * @param args args

    public static void main(String[] args) {
        TokenPayload tokenPayload = new TokenPayload() {{
            setUserId(100);
            setLoginIp("127.0.0.1");
            setLoginDatetime(LocalDateTime.now());
            setTimeout(Constants.TIMEOUT_ON);
            setPlatform(Platform.BROWSER);
        }};
        try {
            Objects.requireNonNull(tokenPayload.getUserId());
            log.info("传入userId: {}, 生成token中...", tokenPayload.getUserId());

            // RSA signatures require a public and private RSA key pair, the public key
            // must be made known to the JWS recipient in order to verify the signatures
            RSAKey rsaJWK = new RSAKeyGenerator(2048)
                .keyID("123")
                .generate();
            RSAKey rsaPublicJWK = rsaJWK.toPublicJWK();

            // Create RSA-signer with the private key
            JWSSigner signer = new RSASSASigner(rsaJWK);

            // Prepare JWT with claims set
            JWTClaimsSet.Builder builder = new JWTClaimsSet.Builder()
                .claim("userId", tokenPayload.getUserId())
                .claim("ip", tokenPayload.getLoginIp())
                .claim("platform", tokenPayload.getPlatform())
                .claim("timeout", tokenPayload.getTimeout())
                .issuer("http://gmwenterprise.github.io/")
                .issueTime(new Date());
            JWTClaimsSet claimsSet;
            if (tokenPayload.timeout()) {
                long expirationMills = 500L; // System.currentTimeMillis() + Constants.DEFAULT_TOKEN_TIMEOUT * 60 * 1000;
                claimsSet = builder.expirationTime(new Date(expirationMills)).build();
            } else {
                claimsSet = builder.build();
            }

            SignedJWT signedJWT = new SignedJWT(
                new JWSHeader.Builder(JWSAlgorithm.RS256).keyID(rsaJWK.getKeyID()).build(),
                claimsSet
            );

            // Compute the RSA signature
            signedJWT.sign(signer);

            Thread.sleep(1000);

            String token = signedJWT.serialize();

            // On the consumer side, parse the JWS and verify its RSA signature
            signedJWT = SignedJWT.parse(token);

            JWSVerifier verifier = new RSASSAVerifier(rsaPublicJWK);
            assert signedJWT.verify(verifier);

            assert tokenPayload.getUserId().equals(signedJWT.getJWTClaimsSet().getClaim("userId"));
            assert "http://gmwenterprise.github.io/".equals(signedJWT.getJWTClaimsSet().getIssuer());

            System.out.println(signedJWT.getJWTClaimsSet());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}
