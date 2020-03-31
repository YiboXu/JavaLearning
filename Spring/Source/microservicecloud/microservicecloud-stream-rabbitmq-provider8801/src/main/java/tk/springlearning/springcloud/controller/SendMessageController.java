package tk.springlearning.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.springlearning.springcloud.service.IMessageProvider;

@RestController
public class SendMessageController {

    @Autowired
    private IMessageProvider messageProvider;

    @RequestMapping("/sendMessage")
    public String sendMessage(){
        return messageProvider.send();
    }
}
