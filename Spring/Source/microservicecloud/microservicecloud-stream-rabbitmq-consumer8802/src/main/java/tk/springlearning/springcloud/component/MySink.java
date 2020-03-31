package tk.springlearning.springcloud.component;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.SubscribableChannel;

public interface MySink {
    /**
     * Input channel name.
     */
    String INPUT = "myInput";

    /**
     * @return input channel.
     */
    @Input(INPUT)
    SubscribableChannel myInput();
}
