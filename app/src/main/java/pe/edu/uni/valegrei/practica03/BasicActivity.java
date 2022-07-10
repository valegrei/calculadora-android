package pe.edu.uni.valegrei.practica03;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BasicActivity extends AppCompatActivity {

    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    Button btnCE, btnC, btnEliminarDigito, btnMas, btnMenos, btnMultiplicar, btnDividir, btnIgual;
    TextView tvStack, tvDigito;

    Integer numA, numB;
    StringBuilder numeroActual;
    StringBuilder stack;
    int MAX_DIGITS = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);

        setTitle(R.string.txt_basica);

        tvStack = findViewById(R.id.tv_stack);
        tvDigito = findViewById(R.id.tv_digitos);
        btn0 = findViewById(R.id.button_0);
        btn1 = findViewById(R.id.button_1);
        btn2 = findViewById(R.id.button_2);
        btn3 = findViewById(R.id.button_3);
        btn4 = findViewById(R.id.button_4);
        btn5 = findViewById(R.id.button_5);
        btn6 = findViewById(R.id.button_6);
        btn7 = findViewById(R.id.button_7);
        btn8 = findViewById(R.id.button_8);
        btn9 = findViewById(R.id.button_9);
        btnCE = findViewById(R.id.button_ce);
        btnC = findViewById(R.id.button_c);
        btnEliminarDigito = findViewById(R.id.button_eliminar);
        btnMas = findViewById(R.id.button_mas);
        btnMenos = findViewById(R.id.button_menos);
        btnMultiplicar = findViewById(R.id.button_multiplicar);
        btnDividir = findViewById(R.id.button_dividir);
        btnIgual = findViewById(R.id.button_igual);

        btn0.setOnClickListener(v -> agregarDigito(0));
        btn1.setOnClickListener(v -> agregarDigito(1));
        btn2.setOnClickListener(v -> agregarDigito(2));
        btn3.setOnClickListener(v -> agregarDigito(3));
        btn4.setOnClickListener(v -> agregarDigito(4));
        btn5.setOnClickListener(v -> agregarDigito(5));
        btn6.setOnClickListener(v -> agregarDigito(6));
        btn7.setOnClickListener(v -> agregarDigito(7));
        btn8.setOnClickListener(v -> agregarDigito(8));
        btn9.setOnClickListener(v -> agregarDigito(9));
        btnC.setOnClickListener(v -> limpiarDigitos());
        btnEliminarDigito.setOnClickListener(v -> eliminarDigito());

        numeroActual = new StringBuilder();
        stack = new StringBuilder();
        numA=null;
        numB=null;

    }

    private void agregarDigito(int numero) {
        if (numeroActual.length() < MAX_DIGITS) {
            numeroActual.append(numero);
            tvDigito.setText(numeroActual.toString());
        }
    }

    private void limpiarDigitos() {
        numeroActual = new StringBuilder();
        tvDigito.setText(numeroActual.toString());
    }

    private void eliminarDigito() {
        if (numeroActual.length() > 0)
            numeroActual.setLength(numeroActual.length() - 1);
        tvDigito.setText(numeroActual.toString());
    }

    private Integer convertirNumero(){
        if(numeroActual.length()>0){
            return Integer.valueOf(numeroActual.toString());
        }
        return null;
    }

    private void clickSumar(){
        if(numeroActual.length()>0){
            numA=convertirNumero();
        }
    }

    private void clickMenos(){
        if(numeroActual.length()>0){
            numA=convertirNumero();
        }
    }
    private void clickMultiplicar(){
        if(numeroActual.length()>0){
            numA=convertirNumero();
        }
    }
    private void clickDividir(){
        if(numeroActual.length()>0){
            numA=convertirNumero();
        }
    }
}