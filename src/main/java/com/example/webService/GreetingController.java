package com.example.webService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private final AtomicLong counter = new AtomicLong();

    //�����ʼ�
    @RequestMapping("/send")
    public String sending(@RequestParam String address,
                         @RequestParam(value = "topic",defaultValue = "���") String topic,
                         @RequestParam(value = "information",defaultValue = "����Gean�ģ����")String information) throws UnsupportedEncodingException {
        Send s = new Send(counter.incrementAndGet(),
                address,topic,information);
        return s.sendMail();
    }

    //��֤����
    @RequestMapping("/varify")
    public String varifying(@RequestParam String address){
        varifyMailAddress v = new varifyMailAddress(address);
        String result = v.varify();
        return result;
    }
}
