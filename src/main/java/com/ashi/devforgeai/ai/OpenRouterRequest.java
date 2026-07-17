package com.ashi.devforgeai.ai;

import java.util.List;

public record OpenRouterRequest(
        String model,
        List<Message> messages
) {
}