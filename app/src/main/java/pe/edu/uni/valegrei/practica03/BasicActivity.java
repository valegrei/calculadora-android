package pe.edu.uni.valegrei.practica03;

import static pe.edu.uni.valegrei.practica03.Operaciones.OP_DIVIDIR;
import static pe.edu.uni.valegrei.practica03.Operaciones.OP_MULTIPLICAR;
import static pe.edu.uni.valegrei.practica03.Operaciones.OP_RESTA;
import static pe.edu.uni.valegrei.practica03.Operaciones.OP_SUMA;
import static pe.edu.uni.valegrei.practica03.Operaciones.getOperadorSimbolo;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class BasicActivity extends AppCompatActivity {

    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    Button btnCE, btnC, btnEliminarDigito, btnMas, btnMenos, btnMultiplicar, btnDividir, btnIgual;
    TextView tvNum1, tvNum2, tvOp, tvNumRes, tvDigito;
    LinearLayout calc_layout;

    private Long num1, num2, numRes;
    private StringBuilder numeroActual;
    private static final int MAX_DIGITS = 10;
    private int op_operador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);

        setTitle(R.string.txt_basica);

        calc_layout = findViewById(R.id.calc_layout);
        tvNum1 = findViewById(R.id.tv_num_1);
        tvNum2 = findViewById(R.id.tv_num_2);
        tvOp = findViewById(R.id.tv_op);
        tvNumRes = findViewById(R.id.tv_num_res);
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
        btnC.setOnClickListener(v -> limpiarTodo());
        btnCE.setOnClickListener(v -> limpiarDigitos());
        btnEliminarDigito.setOnClickListener(v -> eliminarDigito());
        btnMas.setOnClickListener(v -> clickOperador(OP_SUMA));
        btnMenos.setOnClickListener(v -> clickOperador(OP_RESTA));
        btnMultiplicar.setOnClickListener(v -> clickOperador(OP_MULTIPLICAR));
        btnDividir.setOnClickListener(v -> clickOperador(OP_DIVIDIR));
        btnIgual.setOnClickListener(v -> clickIgual());
        limpiarTodo();
    }

    private void agregarDigito(int numero) {
        if (numeroActual.length() < MAX_DIGITS) {
            if (numeroActual.length() == 1 && numeroActual.toString().equals("0"))
                numeroActual.setLength(numeroActual.length() - 1);
            numeroActual.append(numero);
            tvDigito.setText(numeroActual.toString());
        }
    }

    private void limpiarTodo() {
        limpiarDigitos();
        limpiarStack();
    }

    private void limpiarDigitos() {
        numeroActual = new StringBuilder("0");
        tvDigito.setText(numeroActual.toString());
    }

    private void limpiarStack() {
        num1 = null;
        num2 = null;
        numRes = null;
        op_operador = 0;
        tvNum1.setText(null);
        tvNum2.setText(null);
        tvOp.setText(null);
        tvNumRes.setText(null);
    }

    private void eliminarDigito() {
        if (numeroActual.length() > 0)
            numeroActual.setLength(numeroActual.length() - 1);
        if (numeroActual.length() == 0)
            numeroActual.append(0);
        tvDigito.setText(numeroActual.toString());
    }

    private Long convertirNumero() {
        return Long.valueOf(numeroActual.toString());
    }

    private void clickOperador(int operador) {
        if (num1 == null) {
            num1 = convertirNumero();
            tvNum1.setText(String.valueOf(num1));
            tvNum2.setText(null);
            tvNumRes.setText(null);
        }
        op_operador = operador;
        tvOp.setText(getOperadorSimbolo(operador));
        limpiarDigitos();
    }

    private void clickIgual() {
        if (num1 != null && op_operador != 0) {
            num2 = convertirNumero();
            try {
                numRes = Operaciones.operar(num1, num2, op_operador);
                tvNum2.setText(String.valueOf(num2));
                tvNumRes.setText(String.valueOf(numRes));
                limpiarDigitos();

                //reinicia
                num1 = null;
                num2 = null;
                numRes = null;
                op_operador = 0;
            } catch (Operaciones.DivisionEntreCeroException e) {
                mostrarErrorSnackBar(e.getMessage());
                num2 = null;
                numRes = null;
            }
        }
    }

    private void mostrarErrorSnackBar(String errorMsg) {
        Snackbar.make(calc_layout, errorMsg, Snackbar.LENGTH_INDEFINITE).setAction(R.string.ok, v -> {
        }).show();
    }


}