package com.shruti.backend.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

@Service
public class GeminiService {

    private final String GEMINI_API_KEY = "YOUR_GEMINI_API_KEY";
    private final String GEMINI_API_URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-pro:generateContent?key=" + GEMINI_API_KEY;

    public String getDietPlanFromGemini(String requestText) {
        try {
            RestTemplate restTemplate = new RestTemplate();

            String requestBody = "{ \"contents\": [{ \"parts\":[{\"text\":\"" + requestText + "\"}]}]}";

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

            ResponseEntity<String> response = restTemplate.exchange(
                    GEMINI_API_URL, HttpMethod.POST, entity, String.class);

            return response.getBody(); // (later you can parse JSON response to extract only text)
        } catch (Exception e) {
            System.out.println("Gemini call failed: " + e.getMessage());
            return null; // return null so fallback can trigger
        }
    }
}
