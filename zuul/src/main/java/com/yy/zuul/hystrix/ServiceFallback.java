package com.yy.zuul.hystrix;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author: youyu  工号：S37565
 * 后端出现异常时，可以预设为我们想要返回的信息，熔断器
 * 继承fallbackProvider接口，加入spring管理
 * CREATED_DATE: 2018/7/19 16:43
 */
@Component
public class ServiceFallback implements FallbackProvider {
    @Override
    public String getRoute() {
//        此处可指定具体的服务名，例如"hystrix-feign"，当指定为"*"时，表示全部的服务都要熔断处理
        return "*";
    }

    public ClientHttpResponse fallbackResponse() {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return 200;
            }

            @Override
            public String getStatusText() throws IOException {
                return "ok";
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() throws IOException {
                //此处返回要展示的信息，
                return new ByteArrayInputStream("The server is unable".getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders httpHeaders = new HttpHeaders();
                httpHeaders.setContentType(MediaType.APPLICATION_JSON);
                return httpHeaders;
            }

        };
    }
    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause){
        if (cause != null && cause.getCause() != null){
            String reason = cause.getCause().getMessage();
            System.out.println("Excption {}"+ reason);
        }
        return fallbackResponse();
    }
}
