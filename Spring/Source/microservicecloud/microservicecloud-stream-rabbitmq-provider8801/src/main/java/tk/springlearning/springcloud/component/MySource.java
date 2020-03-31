package tk.springlearning.springcloud.component;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface MySource {

    /**
     * Name of the output channel.
     */
    String OUTPUT = "myOutput";

    /**
     * @return output channel
     */
    @Output(OUTPUT)
    MessageChannel myOutput();

}
