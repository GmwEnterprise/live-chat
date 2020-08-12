package com.github.mrag.livechat.rest.filter;

import com.github.mrag.livechat.common.Encryption;
import org.apache.commons.io.IOUtils;

import javax.servlet.FilterChain;
import javax.servlet.ReadListener;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * 请求体解码过滤器
 *
 * @author Gmw
 */
@WebFilter(urlPatterns = "/*")
public class EncryptionFilter extends HttpFilter {

    /*
     * 过滤器的路径匹配规则：去掉context-path、单星号表示范围匹配，双星号无效
     */

    @Override
    public void init() throws ServletException {
        System.out.println("filter init");
        super.init();
    }

    @Override
    protected void doFilter(HttpServletRequest request,
                            HttpServletResponse response,
                            FilterChain chain) throws IOException, ServletException {
        super.doFilter(new BodyReaderHttpServletRequestWrapper(request), response, chain);
    }

    /**
     * 封装request以实现多次读取InputStream
     */
    private static class BodyReaderHttpServletRequestWrapper extends HttpServletRequestWrapper {
        private final byte[] bodyBytes;

        public BodyReaderHttpServletRequestWrapper(HttpServletRequest request) throws IOException {
            super(request);
            String encryptedBody = IOUtils.toString(request.getInputStream(), StandardCharsets.UTF_8);

            // 在封装wrapper的过程中完成解码
            boolean useEncryption = "true".equals(request.getHeader("use-encryption"));
            boolean isJsonBody = "application/json".equals(request.getHeader("content-type"));
            if (useEncryption && isJsonBody && encryptedBody != null) {
                String realBody = Encryption.aesDecrypt(encryptedBody, Encryption.AES_KEY);
                this.bodyBytes = realBody.getBytes();
            } else {
                this.bodyBytes = encryptedBody == null ? null : encryptedBody.getBytes();
            }
        }

        @Override
        public BufferedReader getReader() throws IOException {
            return new BufferedReader(new InputStreamReader(getInputStream()));
        }

        @Override
        public ServletInputStream getInputStream() throws IOException {
            ByteArrayInputStream in = new ByteArrayInputStream(bodyBytes);
            return new ServletInputStream() {
                @Override
                public boolean isFinished() {
                    return false;
                }

                @Override
                public boolean isReady() {
                    return false;
                }

                @Override
                public void setReadListener(ReadListener listener) {
                }

                @Override
                public int read() throws IOException {
                    return in.read();
                }
            };
        }
    }
}
