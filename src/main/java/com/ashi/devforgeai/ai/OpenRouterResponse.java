package com.ashi.devforgeai.ai;

import java.util.List;

public record OpenRouterResponse(
        List<Choice> choices
) {
}