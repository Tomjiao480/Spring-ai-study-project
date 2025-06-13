package com.ningning0111.controller;

import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.StreamingChatClient;
import org.springframework.ai.chat.messages.Message;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DemoController {
    private final ChatClient  chatClient;
    private final StreamingChatClient streamingChatClient;

    //历史消息列表
    static List<Message> historyMessage = new ArrayList<>();

    public DemoController(ChatClient chatClient, StreamingChatClient streamingChatClient) {
        this.chatClient = chatClient;
        this.streamingChatClient = streamingChatClient;
    }

    @GetMapping("/demo/quickstart")
    public String demo(String prompt) {
//        new Prompt("prompt").getContents();
        String response = chatClient.call(prompt);

        return response;
    }
    @GetMapping("/demo/test")
    public String test(String prompt) {
        String response = "test";
        return response;
    }

    // 流式调用，将produces声明为文本事件滚动
    @GetMapping(value = "/demo/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> stream(String prompt) {

        return streamingChatClient.stream(prompt).flatMapSequential(Flux::just);
    }


}
