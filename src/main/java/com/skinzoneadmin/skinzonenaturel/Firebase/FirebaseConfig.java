
package com.skinzoneadmin.skinzonenaturel.Firebase;

import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class FirebaseConfig {

    @Bean
    public FirebaseApp firebaseApp() throws IOException {

        if (!FirebaseApp.getApps().isEmpty()) {
            return FirebaseApp.getInstance();
        }

        // Load Application Default Credentials once
        GoogleCredentials credentials =
                GoogleCredentials.getApplicationDefault();

        String projectId = System.getenv("FIREBASE_PROJECT_ID");

        if (projectId == null || projectId.isBlank()) {
            throw new IllegalStateException(
                    "FIREBASE_PROJECT_ID environment variable is missing"
            );
        }

        System.out.println("ADC credentials loaded: "
                + credentials.getClass().getSimpleName());

        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(credentials)
                .setProjectId(projectId)

                // Explicitly use the transport from our successful test
                .setHttpTransport(new NetHttpTransport())

                .build();

        return FirebaseApp.initializeApp(options);
    }
}
