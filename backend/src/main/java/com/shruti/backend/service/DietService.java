package com.shruti.backend.service;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import com.shruti.backend.model.DietPlan;
import com.shruti.backend.model.DietRequest;

import lombok.Data;

@Service
@Data
public class DietService {
     private String Preference;
      private String goal;

    private final GeminiClient geminiClient; // assume this is your Gemini integration service

    public DietService(GeminiClient geminiClient) {
        this.geminiClient = geminiClient;
    }

    public DietPlan generateDietPlan(DietRequest request) {
        try {
            // Try Gemini API first
            DietPlan aiGeneratedPlan = geminiClient.getDietPlan(request);
            if (aiGeneratedPlan != null) {
                return aiGeneratedPlan;
            }
        } catch (Exception e) {
            System.out.println("Gemini failed or quota exceeded. Falling back to manual logic.");
        }

        // Fallback manual logic
        return generateManualDietPlan(request);
    }

    private DietPlan generateManualDietPlan(DietRequest request) {
        if ("weight_loss".equalsIgnoreCase(request.getGoal())) {
            return new DietPlan(
                    "Oatmeal with fruits",
                    "Grilled chicken salad (or chickpea salad for vegans)",
                    "Steamed veggies with brown rice",
                    Arrays.asList("Green tea", "Almonds")
            );
        } else if ("muscle_gain".equalsIgnoreCase(request.getGoal())) {
            return new DietPlan(
                    "Eggs & whole grain toast (or tofu scramble)",
                    "Chicken breast with quinoa (or lentils for vegans)",
                    "Fish with sweet potato (or beans with rice)",
                    Arrays.asList("Protein shake", "Peanut butter sandwich")
            );
        } else {
            return new DietPlan(
                    "Smoothie bowl",
                    "Balanced rice-dal-sabzi meal",
                    "Paneer curry with roti (or chicken curry with roti)",
                    Arrays.asList("Fruits", "Yogurt")
            );
        }
    }
}
