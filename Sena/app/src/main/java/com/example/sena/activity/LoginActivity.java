package com.example.sena.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.sena.R;

public class LoginActivity extends AppCompatActivity {
    private EditText etEmail, etDocumento;

    // CREDENCIALES ESTÁTICAS DE PRUEBA
    private static final String CORRECT_EMAIL = "jcasadiegos@gmail.com";
    private static final String CORRECT_DOCUMENTO = "1064837999";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login); // Usaremos activity_login.xml

        etEmail = findViewById(R.id.et_username);     // Para el email
        etDocumento = findViewById(R.id.et_password); // Para el documento
        Button btnLogin = findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(v -> attemptLogin());
    }

    private void attemptLogin() {
        String email = etEmail.getText().toString();
        String documento = etDocumento.getText().toString();

        // 1. Verificación Estática
        if (email.equals(CORRECT_EMAIL) && documento.equals(CORRECT_DOCUMENTO)) {
            // Login Exitoso
            Toast.makeText(LoginActivity.this, "Login Exitoso", Toast.LENGTH_SHORT).show();

            // Navegar a la lista de productos
            Intent intent = new Intent(LoginActivity.this, ProductListActivity.class);
            startActivity(intent);
            finish();
        } else {
            // Login Fallido
            Toast.makeText(LoginActivity.this, "Email o Documento incorrectos", Toast.LENGTH_LONG).show();
        }
    }
}
