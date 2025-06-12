package com.ningning0111.controller;

import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private final ChatClient  chatClient;
    public DemoController(ChatClient chatClient) {
        this.chatClient = chatClient;
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
}
