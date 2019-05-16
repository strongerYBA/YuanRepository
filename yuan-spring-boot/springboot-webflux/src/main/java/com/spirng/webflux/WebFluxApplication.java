package com.spirng.webflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * @ClassName WebFluxApplication
 * @Author Administrator
 * @Date 2019/5/13 21:34
 */
@SpringBootApplication
@RestController
public class WebFluxApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebFluxApplication.class,args);
    }
    @GetMapping("/mvc")
    public String mvc()
    {
        println("MVC");
        return "MVC";
    }

    @GetMapping("/mono")
    public Mono<String> mono()
    {
        println("MONO");
        return Mono.just("MONO");
    }

    @Bean
    public RouterFunction<ServerResponse> responseRouterFunction()
    {
//        return RouterFunctions.route(serverRequest -> {
//                    //判断请求是否匹配。
//                    URI  uri = serverRequest.uri();
//                    return  "/hello-world".equals(uri.getPath());
//                },
//                //绑定实现。
//                serverRequest -> {
//                    Mono<ServerResponse> mono = ServerResponse.status(HttpStatus.OK)
//                            .body(Mono.just("hello,world"),String.class);
//                    return mono;
//                });

        return route(GET("/hello-world"),this::helloWorld);
    }
    public Mono<ServerResponse> helloWorld(ServerRequest serverRequest)
    {
        println("helloWorld");
        return ServerResponse.status(HttpStatus.OK)
                .body(Mono.just("hello,world"),String.class);
    }
    private static  void println(String message)
    {
        System.out.println("["+Thread.currentThread().getName()+"] : "+message);
    }
}
