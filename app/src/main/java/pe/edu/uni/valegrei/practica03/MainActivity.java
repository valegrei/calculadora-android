package pe.edu.uni.valegrei.practica03;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnCalcular;
    RadioButton rbBasica, rbCientifica, rbProgramador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalcular = findViewById(R.id.btn_calcular);
        rbBasica = findViewById(R.id.rb_basica);
        rbCientifica = findViewById(R.id.rb_cientifica);
        rbProgramador = findViewById(R.id.rb_programador);

        btnCalcular.setOnClickListener(v -> comprobarOpciones());
    }

    private void comprobarOpciones() {
        //Comprueba si botones estan seleccionados
        if (!rbBasica.isChecked() && !rbCientifica.isChecked() && !rbProgramador.isChecked()) {
            mostrarFaltaSeleccionar();
            return;
        }
        if (rbBasica.isChecked()) {
            irCalcBasica();
        }
        if (rbCientifica.isChecked()) {
            mostrarEnConstrucción(getString(R.string.txt_cientifica));
        }
        if (rbProgramador.isChecked()) {
            mostrarEnConstrucción(getString(R.string.txt_programador));
        }
    }

    private void irCalcBasica() {
        Intent intent = new Intent(this, BasicActivity.class);
        startActivity(intent);
    }

    private void mostrarFaltaSeleccionar() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.title_validar);
        builder.setMessage(R.string.msg_validar);
        builder.setCancelable(true);
        builder.setPositiveButton(R.string.yes, (dialog, which) -> {
            dialog.dismiss();
        });
        builder.create().show();
    }

    private void mostrarEnConstrucción(String tipo) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.title_construccion);
        builder.setMessage(getString(R.string.msg_construccion, tipo));
        builder.setCancelable(false);
        builder.setPositiveButton(R.string.yes, (dialog, which) -> dialog.dismiss());
        builder.setNegativeButton(R.string.no,(dialog, which) -> {
            //Salir del aplicativo
            moveTaskToBack(true);
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
        });
        builder.create().show();
    }
}