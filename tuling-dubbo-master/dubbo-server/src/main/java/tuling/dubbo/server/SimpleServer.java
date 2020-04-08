package tuling.dubbo.server;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import tuling.dubbo.server.impl.UserServiceImpl;

import java.io.IOException;

/**跟 rmi 写法有类似
 * @author Tommy
 * Created by Tommy on 2018/11/20
 **/
public class SimpleServer {

    public void openServer(int port) {
        // 构建应用
        ApplicationConfig config = new ApplicationConfig();
        config.setName("simple-app");

        // 通信协议--默认是 20880
        ProtocolConfig protocolConfig = new ProtocolConfig("dubbo", port);
        protocolConfig.setThreads(200);
        /** 1.构建 服务的配置 ServiceConfig 类，通过它把我们的服务 暴露出去，消费放用 ReferenceConfig 配置调用 **/
        ServiceConfig<UserService> serviceConfig = new ServiceConfig();
        serviceConfig.setApplication(config);
        serviceConfig.setProtocol(protocolConfig);
        /** 2.必须要设置一个注册中心，可以设为空 **/
        serviceConfig.setRegistry(new RegistryConfig("zookeeper://192.168.0.147:2181"));

        serviceConfig.setInterface(UserService.class);/**3. 设置对应要暴露出去的接口  UserService **/
        UserServiceImpl ref = new UserServiceImpl();
        serviceConfig.setRef(ref);/** 4.设置要暴露的接口的实现 **/
        //开始提供服务  开张做生意
        serviceConfig.export();/**5. **/
        System.out.println("服务已开启!端口:"+serviceConfig.getExportedUrls().get(0).getPort());
        ref.setPort(serviceConfig.getExportedUrls().get(0).getPort());
    }

    public static void main(String[] args) throws IOException {
        new SimpleServer().openServer(-1);
        System.in.read();
    }
}
