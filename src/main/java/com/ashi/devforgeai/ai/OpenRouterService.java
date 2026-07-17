package com.ashi.devforgeai.ai;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;
import java.util.List;

@Service
public class OpenRouterService {

    private final RestClient restClient;

    @Value("${openrouter.api.key}")
    private String apiKey;

    @Value("${openrouter.url}")
    private String url;

    @Value("${openrouter.model}")
    private String model;

    public OpenRouterService(RestClient restClient) {
        this.restClient = restClient;
    }


    public String reviewCode(String language,String code) {

    Message systemMessage = new Message(
            "system",
            """
            You are DevForge AI, an expert AI Code Reviewer and Senior Java Developer.

            Your job is to review the submitted source code and help developers improve it.

            Analyze the code based on:

            - Correctness
            - Code Quality
            - Readability
            - Performance
            - Best Practices
            - Security
            - Maintainability

            Return your response in the following format:

            ## Overall Rating
            Give a score out of 10.

            ## Strengths
            Mention what is good in the code.

            ## Issues Found
            Explain every issue clearly.

            ## Suggested Improvements
            Suggest industry-standard improvements.

            ## Improved Code
            Rewrite the code only if major improvements are required.

            Explain everything in beginner-friendly language.
            """
    );

    Message userMessage = new Message(
        "user",
        """
        Language: %s

        Review the following code:

        %s
        """.formatted(language, code)
    );

    OpenRouterRequest request = new OpenRouterRequest(
            model,
            List.of(systemMessage, userMessage)
    );

    try {

        OpenRouterResponse response = restClient.post()
                .uri(url)
                .header("Authorization", "Bearer " + apiKey)
                .header("Content-Type", "application/json")
                .body(request)
                .retrieve()
                .body(OpenRouterResponse.class);

        if (response == null ||
                response.choices() == null ||
                response.choices().isEmpty()) {

            throw new RuntimeException("Empty response received from AI.");
        }

        return response.choices().get(0).message().content();

    } catch (RestClientException e) {

        throw new RuntimeException("Unable to connect to AI service.", e);

    }
}
}