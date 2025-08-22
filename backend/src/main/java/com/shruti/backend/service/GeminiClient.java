package com.shruti.backend.service;
import com.shruti.backend.model.DietPlan;
import com.shruti.backend.model.DietRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;
import org.json.JSONObject;
//import org.json.JSONArray;

@Service
public class GeminiClient {

    private static final String API_KEY = "YOUR_GEMINI_API_KEY";
    private static final String API_URL = "https://generativelanguage.googleapis.com/v1/models/gemini-pro:generateContent?key=" + API_KEY;

    public DietPlan getDietPlan(DietRequest request) {
        try {
            RestTemplate restTemplate = new RestTemplate();

            // Create the request prompt for Gemini
            String prompt = "Give me a " + request.getPreference() + " diet plan for " + request.getGoal();

            JSONObject json = new JSONObject();
            json.put("contents", new org.json.JSONArray()
                    .put(new JSONObject()
                            .put("parts", new org.json.JSONArray()
                                    .put(new JSONObject().put("text", prompt)))));

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<String> entity = new HttpEntity<>(json.toString(), headers);

            ResponseEntity<String> response = restTemplate.exchange(
                    API_URL, HttpMethod.POST, entity, String.class);

            String body = response.getBody();
            return new DietPlan(body, "Lunch TBD", "Dinner TBD", java.util.Arrays.asList("Snacks TBD"));
        } catch (Exception e) {
            System.out.println("Error calling Gemini API: " + e.getMessage());
            return null; // Let DietService handle fallback
        }
    }
}
