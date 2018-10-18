package com.example.a1144091759.pr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements Comunicacion.OnMessage{

    Comunicacion com;
    boolean turno;

    Button b1, b2,b3,b4,b5,b6,b7,b8,b9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        turno = false;
        com = new Comunicacion();
        com.setObserver(this);
        com.start();

        b1 = findViewById(R.id.btn1);
        b2 = findViewById(R.id.btn2);
        b3 = findViewById(R.id.btn3);
        b4 = findViewById(R.id.btn4);
        b5 = findViewById(R.id.btn5);
        b6 = findViewById(R.id.btn6);
        b7 = findViewById(R.id.btn7);
        b8 = findViewById(R.id.btn8);
        b9 = findViewById(R.id.btn9);

        if(turno){
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(b1.getText().toString().equals("")) {
                        com.enviar("0,0,2");
                        b1.setText("X");
                        turno=false;
                    }
                }
            });

            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(b2.getText().toString().equals("")) {
                        com.enviar("0,1,2");
                        b1.setText("X");
                        turno=false;
                    }
                }
            });

            b3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(b3.getText().toString().equals("")) {
                        com.enviar("0,2,2");
                        b1.setText("X");
                        turno=false;
                    }
                }
            });




            b4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(b4.getText().toString().equals("")) {
                        com.enviar("1,0,2");
                        b1.setText("X");
                        turno=false;
                    }
                }
            });

            b5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(b5.getText().toString().equals("")) {
                        com.enviar("1,1,2");
                        b1.setText("X");
                        turno=false;
                    }
                }
            });

            b6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(b6.getText().toString().equals("")) {
                        com.enviar("1,2,2");
                        b1.setText("X");
                        turno=false;
                    }
                }
            });




            b7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(b7.getText().toString().equals("")) {
                        com.enviar("2,0,2");
                        b1.setText("X");
                        turno=false;
                    }
                }
            });

            b8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(b8.getText().toString().equals("")) {
                        com.enviar("2,1,2");
                        b1.setText("X");
                        turno=false;
                    }
                }
            });

            b9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(b9.getText().toString().equals("")) {
                        com.enviar("2,2,2");
                        b1.setText("X");
                        turno=false;
                    }
                }
            });
        }
    }

    @Override
    public void recibido(final String j) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                String[] partes = j.split(",");
                int vx = Integer.parseInt(partes[0]); // 0
                int vy = Integer.parseInt(partes[1]); // 0
                int vj = Integer.parseInt(partes[2]); // 1

                switch (vx){
                    case 0:
                        switch (vy){
                            case 0:
                                b1.setText("O");
                                break;

                            case 1:
                                b2.setText("O");
                                break;

                            case 2:
                                b3.setText("O");
                                break;
                        }
                        break;

                    case 1:
                        switch (vy){
                            case 0:
                                b4.setText("O");
                                break;

                            case 1:
                                b5.setText("O");
                                break;

                            case 2:
                                b6.setText("O");
                                break;
                        }
                        break;

                    case 3:
                        switch (vy){
                            case 0:
                                b7.setText("O");
                                break;

                            case 1:
                                b8.setText("O");
                                break;

                            case 2:
                                b9.setText("O");
                                break;
                        }
                        break;
                }

                turno=true;
            }
        });
    }
}
