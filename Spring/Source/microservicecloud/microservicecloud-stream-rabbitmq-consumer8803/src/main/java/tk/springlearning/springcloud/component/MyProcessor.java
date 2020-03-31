package tk.springlearning.springcloud.component;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface MyProcessor {
    /**
     * Input channel name.
     */
    String INPUT = "myInput1";
    String OUTPUT = "myOutput1";

    /**
     * @return input channel.
     */
    @Input(INPUT)
    SubscribableChannel myInput1();

    /**
     * @return output channel
     */
    @Output(OUTPUT)
    MessageChannel myOutput1();
}
