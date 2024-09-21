package cn.foxkiar.server.config;

import cn.foxkiar.server.endpoint.TestEndpoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@Configuration
public class WebSocketConfig {

    @Bean
    public ServerEndpointExporter serverEndpointExporter (){
        ServerEndpointExporter exporter = new ServerEndpointExporter();
        // 手动注册 WebSocket 端点
        exporter.setAnnotatedEndpointClasses(TestEndpoint.class);
        return exporter;
    }
}