package com.example.jnisemo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import java.lang.StringBuilder;public class MainActivity extends AppCompatActivity {

    static {
        System.loadLibrary("native-lib");
    }

    public native String helloFromJNI();
    public native int factorial(int n);
    public native String reverseString(String s);
    public native int sumArray(int[] values);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvHello = findViewById(R.id.tvHello);
        TextView tvFact = findViewById(R.id.tvFact);
        TextView tvReverse = findViewById(R.id.tvReverse);
        TextView tvArray = findViewById(R.id.tvArray);

        // --- EXÉCUTION DES TESTS (Étape 10) ---

        // Test 1 : Bonjour
        tvHello.setText(helloFromJNI());

        // Test Factorielle (Normal, Négatif, Dépassement)
        StringBuilder factResults = new StringBuilder();
        factResults.append("Fact(10) = ").append(factorial(10)).append("\n"); // 3628800
        factResults.append("Fact(-5) = ").append(factorial(-5)).append("\n"); // -1
        factResults.append("Fact(20) = ").append(factorial(20));             // -2
        tvFact.setText(factResults.toString());

        // Test Texte (Normal et Vide)
        StringBuilder textResults = new StringBuilder();
        textResults.append("Inversé: ").append(reverseString("JNI is powerful!")).append("\n");
        textResults.append("Vide: '").append(reverseString("")).append("'");
        tvReverse.setText(textResults.toString());

        // Test Tableau (Normal et Vide)
        StringBuilder arrayResults = new StringBuilder();
        int[] numbers = {10, 20, 30, 40, 50};
        arrayResults.append("Somme {10...50} = ").append(sumArray(numbers)).append("\n");
        arrayResults.append("Somme {} = ").append(sumArray(new int[]{}));
        tvArray.setText(arrayResults.toString());
    }
}