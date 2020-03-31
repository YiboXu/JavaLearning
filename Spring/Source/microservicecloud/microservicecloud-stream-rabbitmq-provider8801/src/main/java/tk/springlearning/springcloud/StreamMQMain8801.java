package tk.springlearning.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Cloud Stream是一个事件驱动的框架，通过消息驱动各个微服务执行各自的业务逻辑。 并且它通过Binder将各种message中间件更抽象化，使得我们可以使用
 * 统一的方法来发送接收不同消息中间件中的消息.
 *
 * 一. 消息发送端口
 * 1. 修改pom，添加对应消息中间件的starter， 比如RabbitMQ， spring-cloud-starter-stream-rabbit， Kafka, spring-cloud-starter-stream-kafka
 * 2. 修改application.yml
 * spring:
 *   application:
 *     name: microservicecloud-stream-provider
 *   cloud:
 *     stream:
 *       binders: # 在此处配置要绑定的rabbitMQ的服务信息, 对应BindingServiceProperties.class里面的字段
 *         defaultRabbit: # 表示定义的名称(自定义)，用于binding的整合
 *           type: rabbit # 消息中间件类型
 *           environment: # 设置rabbitMQ的相关环境配置
 *             spring:
 *               rabbitmq:
 *                 host: localhost
 *                 port: 5672
 *                 username: guest
 *                 password: guest
 *       bindings: # 服务的整合处理
 *         myOutput: # 这个名字是一个通道的名称(自定义),
 *                   # ******注意这里的名字需要和绑定的channel名字对应，也就是@EnableBinding(MySource.class)里MySource.OUTPUT的值一样******
 *           destination: studyExchange # 表示要使用的exchange名称定义(需要和接收端microservicebloud-stream-rabbitmq-consumer8802里application.yml里面保持一致)
 *           content-type: application/json # 设置消息类型，本次为json，文本则设为text/plain
 *           binder: defaultRabbit # 设置要绑定的消息服务的具体设置
 *
 *  3. 在发送消息的Controller上进行绑定，将application.yml里面配置的bindings里的MessageChannel(myOutput)和destination(studyExchange)也就是Queue进行绑定
 *     有2个地方需要匹配：
 *     - @EnableBinding(MySource.class)里面MySource.class定义了MessageChannel在Spring容器中的Bean ID, 也就是@Output("...")里面的值,
 *       这个值一定要和application.yml里面bindings下面定义的通道名字一致，也就是@Output("myOutput")匹配 bindings.myOutput
 *     - Application.yml里面定义的bindings.myOutput.destination(queue name)需要和接收端保持一致bindings.myInput.destination
 *
 * 二，消息接收
 * 1. 修改pom，添加对应消息中间件的starter， 比如RabbitMQ， spring-cloud-starter-stream-rabbit， Kafka, spring-cloud-starter-stream-kafka
 * 2. 修改application.yml （注意，如果需要避免多个微服务重复接收一个消息，需要加上group， 参看其注释）
 * spring:
 *   application:
 *     name: microservicecloud-stream-provider
 *   cloud:
 *     stream:
 *       binders: # 在此处配置要绑定的rabbitMQ的服务信息, 对应BindingServiceProperties.class里面的字段
 *         defaultRabbit: # 表示定义的名称(自定义)，用于binding的整合
 *           type: rabbit # 消息中间件类型
 *           environment: # 设置rabbitMQ的相关环境配置
 *             spring:
 *               rabbitmq:
 *                 host: localhost
 *                 port: 5672
 *                 username: guest
 *                 password: guest
 *       bindings: # 服务的整合处理
 *         myInput: # 这个名字是一个通道的名称(自定义),
 *                   # ******注意这里的名字需要和绑定的channel名字对应，也就是@EnableBinding(MySink.class)里MySink.INPUT的值一样******
 *           destination: studyExchange # 表示要使用的exchange名称定义(需要和发送端microservicebloud-stream-rabbitmq-consumer8801里application.yml里面保持一致)
 *           content-type: application/json # 设置消息类型，本次为json，文本则设为text/plain
 *           binder: defaultRabbit # 设置要绑定的消息服务的具体设置
 *           group: spectrumrpcA # 不同的组存在重复消费，相同的组之间竞争消费。 (对应MQ里面的queue)
 *                               # 加上group之后，还会自动进行消息持久化，就是说如果消费端意外down机，重启后会自动读取未处理过的消息来处理
 *                               # 如果不加上group,就没有消息持久化，那么消费端down机后 到 重启服务可用这段时间的消息就会丢失
 *                               # 所以group在这里解决了消息重复消费和消息丢失的问题
 *
 *  3. 在接收消息的Controller上进行绑定，将application.yml里面配置的bindings里的MessageChannel(myInput)和destination(studyExchange)也就是Queue进行绑定
 *     有2个地方需要匹配：
 *     - @EnableBinding(MySink.class)里面MySink.class定义了MessageChannel在Spring容器中的Bean ID, 也就是@Input("...")里面的值,
 *       这个值一定要和application.yml里面bindings下面定义的通道名字一致，也就是@Input("myInput")匹配 bindings.myInput
 *     - Application.yml里面定义的bindings.myInput.destination(queue name)需要和消息发送端保持一致bindings.myOutput.destination
 *
 *  三. 消息转发
 * 1. 修改pom，添加对应消息中间件的starter， 比如RabbitMQ， spring-cloud-starter-stream-rabbit， Kafka, spring-cloud-starter-stream-kafka
 * 2. 修改application.yml （注意，如果需要避免多个微服务重复接收一个消息，需要加上group， 参看其注释）
 * spring:
 *   application:
 *     name: microservicecloud-stream-consumer_trans
 *   cloud:
 *     stream:
 *       binders: # 在此处配置要绑定的rabbitMQ的服务信息 (BindingServiceProperties.class)
 *         defaultRabbit: # 表示定义的名称(自定义)，用于binding的整合
 *           type: rabbit # 消息中间件类型
 *           environment: # 设置rabbitMQ的相关环境配置
 *             spring:
 *               rabbitmq:
 *                 host: localhost
 *                 port: 5672
 *                 username: guest
 *                 password: guest
 *       bindings: # 服务的整合处理
 *         myInput1: # 这个名字是一个通道的名称(自定义)
 *           destination: studyExchange # 表示要使用的exchange名称定义(需要和microservicebloud-stream-rabbitmq-provider8801里application.yml里面保持一致)
 *           content-type: application/json # 设置消息类型，本次为json，文本则设为text/plain
 *           binder: defaultRabbit # 设置要绑定的消息服务的具体设置
 *           group: spectrumrpcA # 不同的组存在重复消费，相同的组之间竞争消费。(对应MQ里面的queue)
 *                               # 加上group之后，还会自动进行消息持久化，就是说如果消费端意外down机，重启后会自动读取未处理过的消息来处理
 *                               # 如果不加上group,就没有消息持久化，那么消费端down机后 到 重启服务可用这段时间的消息就会丢失
 *                               # 所以group在这里解决了消息重复消费和消息丢失的问题
 *         myOutput1: # 这个名字是一个通道的名称(自定义)
 *             destination: studyExchangeTrans # 表示要使用的exchange名称定义(需要和下游微服务microservicebloud-stream-rabbitmq-provider8804里application.yml里面保持一致)
 *             content-type: application/json # 设置消息类型，本次为json，文本则设为text/plain
 *             binder: defaultRabbit # 设置要绑定的消息服务的具体设置
 *
 *  3. 在转发消息的Controller上进行绑定，@EnableBinding(MyProcessor.class)
 *     将application.yml里面配置的bindings里的MessageChannel(myInput1)和destination(studyExchange)也就是Queue进行绑定(上游的queue)
 *     还将application.yml里面配置的bindings里的MessageChannel(myOutput1)和destination(studyExchangeTrans)也就是Queue进行绑定(下游的queue)
 *     有4个地方需要匹配：
 *     - @EnableBinding(MyProcessor.class)里面MyProcess.class定义了2个MessageChannel在Spring容器中的Bean ID, 也就是@Input("...")和@Output("...")
 *       这个值一定要和application.yml里面bindings下面定义的通道名字一致，也就是@Input("myInput1")匹配 bindings.myInput1,
 *       还有@Input("myOutput1")匹配 bindings.myOutput1
 *     - Application.yml里面定义的bindings.myInput1.destination(queue name)需要和消息发送端保持一致bindings.myOutput2.destination
 *     - Application.yml里面定义的bindings.myOutput1.destination(queue name)需要和接收端保持一致bindings.myInput2.destination
 *
 * 四. 样例说明
 * microservicecloud-stream-rabbitmq-provider8801 消息发送端
 * microservicecloud-stream-rabbitmq-consumer8802 消息接收端， 接收8801的消息
 * microservicecloud-stream-rabbitmq-consumer8803 消息转发端，接收8801的消息，处理后，发送到下游8804处理
 * microservicecloud-stream-rabbitmq-consumer8804 消息接收端， 接收8803的消息
 */
@SpringBootApplication
public class StreamMQMain8801 {
    public static void main(String[] args) {
        SpringApplication.run(StreamMQMain8801.class,args);
    }
}
