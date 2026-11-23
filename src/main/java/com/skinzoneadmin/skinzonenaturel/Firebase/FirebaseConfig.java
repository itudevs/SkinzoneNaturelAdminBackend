package com.skinzoneadmin.skinzonenaturel.Firebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.io.IOException;

/**
 * Class to read configured service account credentials for Authentication
 */
@Configuration
public class FirebaseConfig {
 @Bean
    public FirebaseApp firebaseApp() throws IOException {
     GoogleCredentials credentials =
             GoogleCredentials.getApplicationDefault();

     System.out.println("ADC credentials loaded: " +
             credentials.getClass().getSimpleName());
     //Holds Configuration need to connect to account
     FirebaseOptions options=FirebaseOptions.builder().setCredentials(
             GoogleCredentials.getApplicationDefault()
     )
             .setProjectId(
                     System.getenv("FIREBASE_PROJECT_ID")
             ).build();
     //initialization of the application
     if(FirebaseApp.getApps().isEmpty()) {
         return  FirebaseApp.initializeApp(options);
     }
     return FirebaseApp.getInstance();
 }
}
