package com.nikhil.couch_backend.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FirebaseConfig {

    @PostConstruct
    public void init() throws Exception {

        String firebaseConfig = System.getenv("FIREBASE_CONFIG");

        if (firebaseConfig == null) {
            throw new RuntimeException("FIREBASE_CONFIG not set");
        }

        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(
                        new java.io.ByteArrayInputStream(firebaseConfig.getBytes())
                ))
                .build();

        if (FirebaseApp.getApps().isEmpty()) {
            FirebaseApp.initializeApp(options);
        }
    }
}