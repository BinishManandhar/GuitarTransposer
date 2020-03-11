package com.binish.guitartransposer;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.binish.guitartransposer.functionality.BackEnd;

public class MainPage extends AppCompatActivity {
    EditText chord1, chord2, chord3, chord4;
    EditText transpose;
    EditText transposedchord1, transposedchord2, transposedchord3, transposedchord4;
    Button minus, plus, transposebttn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);

        chord1 = findViewById(R.id.chord1);
        chord2 = findViewById(R.id.chord2);
        chord3 = findViewById(R.id.chord3);
        chord4 = findViewById(R.id.chord4);
        transpose = findViewById(R.id.transpose);
        transposedchord1 = findViewById(R.id.transposedchord1);
        transposedchord2 = findViewById(R.id.transposedchord2);
        transposedchord3 = findViewById(R.id.transposedchord3);
        transposedchord4 = findViewById(R.id.transposedchord4);
        minus = findViewById(R.id.minus);
        plus = findViewById(R.id.plus);
        transposebttn = findViewById(R.id.transposebttn);


        transpose.setText("0");
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String check = transpose.getText().toString();
                if (check == "0") {
                    Toast.makeText(MainPage.this, "You can't Transpose below 0", Toast.LENGTH_LONG).show();
                } else {
                    switch (check) {
                        case "1":
                            transpose.setText("0");
                            break;
                        case "2":
                            transpose.setText("1");
                            break;
                        case "3":
                            transpose.setText("2");
                            break;
                        case "4":
                            transpose.setText("3");
                            break;
                        case "5":
                            transpose.setText("4");
                            break;
                        case "6":
                            transpose.setText("5");
                            break;
                        case "7":
                            transpose.setText("6");
                            break;
                        case "8":
                            transpose.setText("7");
                            break;
                        case "9":
                            transpose.setText("8");
                            break;
                        case "10":
                            transpose.setText("9");
                            break;
                        case "11":
                            transpose.setText("10");
                            break;
                    }
                }
                //after setting the transpose

            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String check = transpose.getText().toString();
                if (check == "11") {
                    Toast.makeText(MainPage.this, "You can't Transpose above 11", Toast.LENGTH_LONG).show();
                } else {
                    switch (check) {
                        case "0":
                            transpose.setText("1");
                            break;
                        case "1":
                            transpose.setText("2");
                            break;
                        case "2":
                            transpose.setText("3");
                            break;
                        case "3":
                            transpose.setText("4");
                            break;
                        case "4":
                            transpose.setText("5");
                            break;
                        case "5":
                            transpose.setText("6");
                            break;
                        case "6":
                            transpose.setText("7");
                            break;
                        case "7":
                            transpose.setText("8");
                            break;
                        case "8":
                            transpose.setText("9");
                            break;
                        case "9":
                            transpose.setText("10");
                            break;
                        case "10":
                            transpose.setText("11");
                            break;
                    }
                }
            }
        });
        transposebttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String c1 = chord1.getText().toString();
                String c2 = chord2.getText().toString();
                String c3 = chord3.getText().toString();
                String c4 = chord4.getText().toString();
                int ch1, ch2, ch3, ch4,mirror1=0,mirror2=0,mirror3=0,mirror4=0;
                BackEnd object = new BackEnd();
                String check = transpose.getText().toString();
                if (c1.equalsIgnoreCase("") && c2.equalsIgnoreCase("") && c3.equalsIgnoreCase("") && c4.equalsIgnoreCase("")) {
                    Toast.makeText(MainPage.this, "You need to input atleast one chord", Toast.LENGTH_LONG).show();
                } else {
                    ch1 = object.convert(c1);
                    ch2 = object.convert(c2);
                    ch3 = object.convert(c3);
                    ch4 = object.convert(c4);
                    if(ch1>11)
                    {
                        mirror1=1;
                    }
                    else if (ch2>11)
                    {
                        mirror2=1;
                    }
                    else if (ch3>11)
                    {
                        mirror3=1;
                    }
                    else if (ch4>11)
                    {
                        mirror4=1;
                    }

                    if (check.equals("0")) {
                        ch1 = ch1 + 0;
                        c1 = object.convertBack(ch1);
                        ch2 = ch2 + 0;
                        c2 = object.convertBack(ch2);
                        ch3 = ch3 + 0;
                        c3 = object.convertBack(ch3);
                        ch4 = ch4 + 0;
                        c4 = object.convertBack(ch4);
                    } else if (check.equals("1")) {
                        ch1 = ch1 + 1;
                        c1 = object.convertBack(ch1);
                        ch2 = ch2 + 1;
                        c2 = object.convertBack(ch2);
                        ch3 = ch3 + 1;
                        c3 = object.convertBack(ch3);
                        ch4 = ch4 + 1;
                        c4 = object.convertBack(ch4);
                    } else if (check.equals("2")) {
                        ch1 = ch1 + 2;
                        c1 = object.convertBack(ch1);
                        ch2 = ch2 + 2;
                        c2 = object.convertBack(ch2);
                        ch3 = ch3 + 2;
                        c3 = object.convertBack(ch3);
                        ch4 = ch4 + 2;
                        c4 = object.convertBack(ch4);
                    } else if (check.equals("3")) {
                        ch1 = ch1 + 3;
                        c1 = object.convertBack(ch1);
                        ch2 = ch2 + 3;
                        c2 = object.convertBack(ch2);
                        ch3 = ch3 + 3;
                        c3 = object.convertBack(ch3);
                        ch4 = ch4 + 3;
                        c4 = object.convertBack(ch4);
                    } else if (check.equals("4")) {
                        ch1 = ch1 + 4;
                        c1 = object.convertBack(ch1);
                        ch2 = ch2 + 4;
                        c2 = object.convertBack(ch2);
                        ch3 = ch3 + 4;
                        c3 = object.convertBack(ch3);
                        ch4 = ch4 + 4;
                        c4 = object.convertBack(ch4);
                    } else if (check.equals("5")) {
                        ch1 = ch1 + 5;
                        c1 = object.convertBack(ch1);
                        ch2 = ch2 + 5;
                        c2 = object.convertBack(ch2);
                        ch3 = ch3 + 5;
                        c3 = object.convertBack(ch3);
                        ch4 = ch4 + 5;
                        c4 = object.convertBack(ch4);
                    } else if (check.equals("6")) {
                        ch1 = ch1 + 6;
                        c1 = object.convertBack(ch1);
                        ch2 = ch2 + 6;
                        c2 = object.convertBack(ch2);
                        ch3 = ch3 + 6;
                        c3 = object.convertBack(ch3);
                        ch4 = ch4 + 6;
                        c4 = object.convertBack(ch4);
                    } else if (check.equals("7")) {
                        ch1 = ch1 + 7;
                        c1 = object.convertBack(ch1);
                        ch2 = ch2 + 7;
                        c2 = object.convertBack(ch2);
                        ch3 = ch3 + 7;
                        c3 = object.convertBack(ch3);
                        ch4 = ch4 + 7;
                        c4 = object.convertBack(ch4);
                    } else if (check.equals("8")) {
                        ch1 = ch1 + 8;
                        c1 = object.convertBack(ch1);
                        ch2 = ch2 + 8;
                        c2 = object.convertBack(ch2);
                        ch3 = ch3 + 8;
                        c3 = object.convertBack(ch3);
                        ch4 = ch4 + 8;
                        c4 = object.convertBack(ch4);
                    } else if (check.equals("9")) {
                        ch1 = ch1 + 9;
                        c1 = object.convertBack(ch1);
                        ch2 = ch2 + 9;
                        c2 = object.convertBack(ch2);
                        ch3 = ch3 + 9;
                        c3 = object.convertBack(ch3);
                        ch4 = ch4 + 9;
                        c4 = object.convertBack(ch4);
                    } else if (check.equals("10")) {
                        ch1 = ch1 + 10;
                        c1 = object.convertBack(ch1);
                        ch2 = ch2 + 10;
                        c2 = object.convertBack(ch2);
                        ch3 = ch3 + 10;
                        c3 = object.convertBack(ch3);
                        ch4 = ch4 + 10;
                        c4 = object.convertBack(ch4);
                    } else if (check.equals("11")) {
                        ch1 = ch1 + 11;
                        c1 = object.convertBack(ch1);
                        ch2 = ch2 + 11;
                        c2 = object.convertBack(ch2);
                        ch3 = ch3 + 11;
                        c3 = object.convertBack(ch3);
                        ch4 = ch4 + 11;
                        c4 = object.convertBack(ch4);
                    }
                    if (mirror1==0 ) {
                        if (chord1.getText().length() > 2)
                            transposedchord1.setText(c1 + "m");
                        else
                            transposedchord1.setText(c1);
                    } else
                        transposedchord1.setText("");
                    if (mirror2==0) {
                        if (chord2.getText().length() > 2)
                            transposedchord2.setText(c2 + "m");
                        else
                            transposedchord2.setText(c2);
                    } else
                        transposedchord2.setText("");
                    if (mirror3==0) {
                        if (chord3.getText().length() > 2)
                            transposedchord3.setText(c3 + "m");
                        else
                            transposedchord3.setText(c3);
                    } else {
                        transposedchord3.setText("");
                    }
                    if (mirror4==0) {
                        if (chord4.getText().length() > 2)
                            transposedchord4.setText(c4 + "m");
                        else
                            transposedchord4.setText(c4);
                    } else {
                        transposedchord4.setText("");
                    }
                }
            }
        });
    }
    /*transposebttn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String c1 = chord1.getText().toString();
            String c2 = chord2.getText().toString();
            String c3 = chord3.getText().toString();
            String c4 = chord4.getText().toString();
            int ch1, ch2, ch3, ch4, mirror1 = 0, mirror2 = 0, mirror3 = 0, mirror4 = 0;
            BackEnd object = new BackEnd();
            try {
                int checkfrom = Integer.parseInt(transposefrom.getText().toString());
                int checkto = Integer.parseInt(transposeto.getText().toString());
                if (c1.equalsIgnoreCase("") && c2.equalsIgnoreCase("") && c3.equalsIgnoreCase("") && c4.equalsIgnoreCase("")) {
                    Toast.makeText(MainPageUpdated.this, "You need to input atleast one chord", Toast.LENGTH_LONG).show();
                } else if (checkfrom >= 0 && checkfrom <= 11 || checkto >= 0 && checkto <= 11) {
                    ch1 = object.convert(c1);
                    ch2 = object.convert(c2);
                    ch3 = object.convert(c3);
                    ch4 = object.convert(c4);
                    Log.i("tag", "Ch1:" + ch1);
                    Log.i("tag", "Ch2:" + ch2);
                    Log.i("tag", "Ch3:" + ch3);
                    if (ch1 > 11) {
                        mirror1 = 1;
                    }
                    if (ch2 > 11) {
                        mirror2 = 1;
                    }
                    if (ch3 > 11) {
                        mirror3 = 1;
                    }
                    if (ch4 > 11) {
                        mirror4 = 1;
                    }
                    if (checkto >= checkfrom) {
                        if ((checkto - checkfrom) == 0) {
                            ch1 = ch1 + 0;
                            c1 = object.convertBack(ch1);
                            ch2 = ch2 + 0;
                            c2 = object.convertBack(ch2);
                            ch3 = ch3 + 0;
                            c3 = object.convertBack(ch3);
                            ch4 = ch4 + 0;
                            c4 = object.convertBack(ch4);
                        } else if ((checkto - checkfrom) == 1) {
                            ch1 = ch1 + 1;
                            c1 = object.convertBack(ch1);
                            ch2 = ch2 + 1;
                            c2 = object.convertBack(ch2);
                            ch3 = ch3 + 1;
                            c3 = object.convertBack(ch3);
                            ch4 = ch4 + 1;
                            c4 = object.convertBack(ch4);
                        } else if ((checkto - checkfrom) == 2) {
                            ch1 = ch1 + 2;
                            c1 = object.convertBack(ch1);
                            ch2 = ch2 + 2;
                            c2 = object.convertBack(ch2);
                            ch3 = ch3 + 2;
                            c3 = object.convertBack(ch3);
                            ch4 = ch4 + 2;
                            c4 = object.convertBack(ch4);
                        } else if ((checkto - checkfrom) == 3) {
                            ch1 = ch1 + 3;
                            c1 = object.convertBack(ch1);
                            ch2 = ch2 + 3;
                            c2 = object.convertBack(ch2);
                            ch3 = ch3 + 3;
                            c3 = object.convertBack(ch3);
                            ch4 = ch4 + 3;
                            c4 = object.convertBack(ch4);
                        } else if ((checkto - checkfrom) == 4) {
                            ch1 = ch1 + 4;
                            c1 = object.convertBack(ch1);
                            ch2 = ch2 + 4;
                            c2 = object.convertBack(ch2);
                            ch3 = ch3 + 4;
                            c3 = object.convertBack(ch3);
                            ch4 = ch4 + 4;
                            c4 = object.convertBack(ch4);
                        } else if ((checkto - checkfrom) == 5) {
                            ch1 = ch1 + 5;
                            c1 = object.convertBack(ch1);
                            ch2 = ch2 + 5;
                            c2 = object.convertBack(ch2);
                            ch3 = ch3 + 5;
                            c3 = object.convertBack(ch3);
                            ch4 = ch4 + 5;
                            c4 = object.convertBack(ch4);
                        } else if ((checkto - checkfrom) == 6) {
                            ch1 = ch1 + 6;
                            c1 = object.convertBack(ch1);
                            ch2 = ch2 + 6;
                            c2 = object.convertBack(ch2);
                            ch3 = ch3 + 6;
                            c3 = object.convertBack(ch3);
                            ch4 = ch4 + 6;
                            c4 = object.convertBack(ch4);
                        } else if ((checkto - checkfrom) == 7) {
                            ch1 = ch1 + 7;
                            c1 = object.convertBack(ch1);
                            ch2 = ch2 + 7;
                            c2 = object.convertBack(ch2);
                            ch3 = ch3 + 7;
                            c3 = object.convertBack(ch3);
                            ch4 = ch4 + 7;
                            c4 = object.convertBack(ch4);
                        } else if ((checkto - checkfrom) == 8) {
                            ch1 = ch1 + 8;
                            c1 = object.convertBack(ch1);
                            ch2 = ch2 + 8;
                            c2 = object.convertBack(ch2);
                            ch3 = ch3 + 8;
                            c3 = object.convertBack(ch3);
                            ch4 = ch4 + 8;
                            c4 = object.convertBack(ch4);
                        } else if ((checkto - checkfrom) == 9) {
                            ch1 = ch1 + 9;
                            c1 = object.convertBack(ch1);
                            ch2 = ch2 + 9;
                            c2 = object.convertBack(ch2);
                            ch3 = ch3 + 9;
                            c3 = object.convertBack(ch3);
                            ch4 = ch4 + 9;
                            c4 = object.convertBack(ch4);
                        } else if ((checkto - checkfrom) == 10) {
                            ch1 = ch1 + 10;
                            c1 = object.convertBack(ch1);
                            ch2 = ch2 + 10;
                            c2 = object.convertBack(ch2);
                            ch3 = ch3 + 10;
                            c3 = object.convertBack(ch3);
                            ch4 = ch4 + 10;
                            c4 = object.convertBack(ch4);
                        } else if ((checkto - checkfrom) == 11) {
                            ch1 = ch1 + 11;
                            c1 = object.convertBack(ch1);
                            ch2 = ch2 + 11;
                            c2 = object.convertBack(ch2);
                            ch3 = ch3 + 11;
                            c3 = object.convertBack(ch3);
                            ch4 = ch4 + 11;
                            c4 = object.convertBack(ch4);
                        }
                    } else {
                        if ((checkfrom - checkto) == 0) {
                            ch1 = ch1 - 0;
                            c1 = object.convertBack(ch1);
                            ch2 = ch2 - 0;
                            c2 = object.convertBack(ch2);
                            ch3 = ch3 - 0;
                            c3 = object.convertBack(ch3);
                            ch4 = ch4 - 0;
                            c4 = object.convertBack(ch4);
                        } else if ((checkfrom - checkto) == 1) {
                            ch1 = ch1 - 1;
                            c1 = object.convertBack(ch1);
                            ch2 = ch2 - 1;
                            c2 = object.convertBack(ch2);
                            ch3 = ch3 - 1;
                            c3 = object.convertBack(ch3);
                            ch4 = ch4 - 1;
                            c4 = object.convertBack(ch4);
                        } else if ((checkfrom - checkto) == 2) {
                            ch1 = ch1 - 2;
                            c1 = object.convertBack(ch1);
                            ch2 = ch2 - 2;
                            c2 = object.convertBack(ch2);
                            ch3 = ch3 - 2;
                            c3 = object.convertBack(ch3);
                            ch4 = ch4 - 2;
                            c4 = object.convertBack(ch4);
                        } else if ((checkfrom - checkto) == 3) {
                            ch1 = ch1 - 3;
                            c1 = object.convertBack(ch1);
                            ch2 = ch2 - 3;
                            c2 = object.convertBack(ch2);
                            ch3 = ch3 - 3;
                            c3 = object.convertBack(ch3);
                            ch4 = ch4 - 3;
                            c4 = object.convertBack(ch4);
                        } else if ((checkfrom - checkto) == 4) {
                            ch1 = ch1 - 4;
                            c1 = object.convertBack(ch1);
                            ch2 = ch2 - 4;
                            c2 = object.convertBack(ch2);
                            ch3 = ch3 - 4;
                            c3 = object.convertBack(ch3);
                            ch4 = ch4 - 4;
                            c4 = object.convertBack(ch4);
                        } else if ((checkfrom - checkto) == 5) {
                            ch1 = ch1 - 5;
                            c1 = object.convertBack(ch1);
                            ch2 = ch2 - 5;
                            c2 = object.convertBack(ch2);
                            ch3 = ch3 - 5;
                            c3 = object.convertBack(ch3);
                            ch4 = ch4 - 5;
                            c4 = object.convertBack(ch4);
                        } else if ((checkfrom - checkto) == 6) {
                            ch1 = ch1 - 6;
                            c1 = object.convertBack(ch1);
                            ch2 = ch2 - 6;
                            c2 = object.convertBack(ch2);
                            ch3 = ch3 - 6;
                            c3 = object.convertBack(ch3);
                            ch4 = ch4 - 6;
                            c4 = object.convertBack(ch4);
                        } else if ((checkfrom - checkto) == 7) {
                            ch1 = ch1 - 7;
                            c1 = object.convertBack(ch1);
                            ch2 = ch2 - 7;
                            c2 = object.convertBack(ch2);
                            ch3 = ch3 - 7;
                            c3 = object.convertBack(ch3);
                            ch4 = ch4 - 7;
                            c4 = object.convertBack(ch4);
                        } else if ((checkfrom - checkto) == 8) {
                            ch1 = ch1 - 8;
                            c1 = object.convertBack(ch1);
                            ch2 = ch2 - 8;
                            c2 = object.convertBack(ch2);
                            ch3 = ch3 - 8;
                            c3 = object.convertBack(ch3);
                            ch4 = ch4 - 8;
                            c4 = object.convertBack(ch4);
                        } else if ((checkfrom - checkto) == 9) {
                            ch1 = ch1 - 9;
                            c1 = object.convertBack(ch1);
                            ch2 = ch2 - 9;
                            c2 = object.convertBack(ch2);
                            ch3 = ch3 - 9;
                            c3 = object.convertBack(ch3);
                            ch4 = ch4 - 9;
                            c4 = object.convertBack(ch4);
                        } else if ((checkfrom - checkto) == 10) {
                            ch1 = ch1 - 10;
                            c1 = object.convertBack(ch1);
                            ch2 = ch2 - 10;
                            c2 = object.convertBack(ch2);
                            ch3 = ch3 - 10;
                            c3 = object.convertBack(ch3);
                            ch4 = ch4 - 10;
                            c4 = object.convertBack(ch4);
                        } else if ((checkfrom - checkto) == 11) {
                            ch1 = ch1 - 11;
                            c1 = object.convertBack(ch1);
                            ch2 = ch2 - 11;
                            c2 = object.convertBack(ch2);
                            ch3 = ch3 - 11;
                            c3 = object.convertBack(ch3);
                            ch4 = ch4 - 11;
                            c4 = object.convertBack(ch4);
                        }
                    }
                    if (mirror1 == 0) {
                        if (chord1.getText().length() == 2 && chord1.getText().toString().substring(1, 2).equalsIgnoreCase("m"))
                            transposedchord1.setText(c1 + "m");
                        else if (chord1.getText().length() == 3)
                            transposedchord1.setText(c1 + "m");
                        else
                            transposedchord1.setText(c1);
                    } else {
                        transposedchord1.setText("");
                    }
                    if (mirror2 == 0) {
                        if (chord2.getText().length() == 2 && chord2.getText().toString().substring(1, 2).equalsIgnoreCase("m"))
                            transposedchord2.setText(c2 + "m");
                        else if (chord2.getText().length() == 3)
                            transposedchord2.setText(c2 + "m");
                        else
                            transposedchord2.setText(c2);
                    } else {
                        transposedchord2.setText("");
                    }
                    if (mirror3 == 0) {
                        if (chord3.getText().length() == 2 && chord3.getText().toString().substring(1, 2).equalsIgnoreCase("m"))
                            transposedchord3.setText(c3 + "m");
                        else if (chord3.getText().length() == 3)
                            transposedchord3.setText(c3 + "m");
                        else
                            transposedchord3.setText(c3);
                    } else {
                        transposedchord3.setText("");
                    }
                    if (mirror4 == 0) {
                        if (chord4.getText().length() == 2 && chord4.getText().toString().substring(1, 2).equalsIgnoreCase("m"))
                            transposedchord4.setText(c4 + "m");
                        else if (chord4.getText().length() == 3)
                            transposedchord4.setText(c4 + "m");
                        else
                            transposedchord4.setText(c4);
                    } else {
                        transposedchord4.setText("");
                    }
                } else {
                    transposefrom.setError("Input from 0 to 11");
                    transposeto.setError("Input from 0 to 11");
                    Toast.makeText(MainPageUpdated.this, "You need to fill both fields", Toast.LENGTH_SHORT).show();
                }
            } catch (NumberFormatException e) {
                transposefrom.setError("Input from 0 to 11");
                transposeto.setError("Input from 0 to 11");
                Toast.makeText(MainPageUpdated.this, "You need to fill both fields", Toast.LENGTH_LONG).show();
            }
        }

    })*/;
        /*capochangebttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String c1 = chord1.getText().toString();
//                String c2 = chord2.getText().toString();
//                String c3 = chord3.getText().toString();
//                String c4 = chord4.getText().toString();
//                int ch1, ch2, ch3, ch4, mirror1 = 0, mirror2 = 0, mirror3 = 0, mirror4 = 0;
//                BackEnd object = new BackEnd();
//                try {
//                    int checkfrom = Integer.parseInt(transposefrom.getText().toString());
//                    int checkto = Integer.parseInt(transposeto.getText().toString());
//                    if (c1.equalsIgnoreCase("") && c2.equalsIgnoreCase("") && c3.equalsIgnoreCase("") && c4.equalsIgnoreCase("")) {
//                        Toast.makeText(MainPageUpdated.this, "You need to input atleast one chord", Toast.LENGTH_LONG).show();
//                    } else if (checkfrom >= 0 && checkfrom <= 11 || checkto >= 0 && checkto <= 11) {
//                        ch1 = object.convert(c1);
//                        ch2 = object.convert(c2);
//                        ch3 = object.convert(c3);
//                        ch4 = object.convert(c4);
//                        if (ch1 > 11) {
//                            mirror1 = 1;
//                        }
//                        if (ch2 > 11) {
//                            mirror2 = 1;
//                        }
//                        if (ch3 > 11) {
//                            mirror3 = 1;
//                        }
//                        if (ch4 > 11) {
//                            mirror4 = 1;
//                        }
//                        if (checkto >= checkfrom) {
//                            if ((checkto - checkfrom) == 0) {
//                                ch1 = ch1 - 0;
//                                c1 = object.convertBack(ch1);
//                                ch2 = ch2 - 0;
//                                c2 = object.convertBack(ch2);
//                                ch3 = ch3 - 0;
//                                c3 = object.convertBack(ch3);
//                                ch4 = ch4 - 0;
//                                c4 = object.convertBack(ch4);
//                            } else if ((checkto - checkfrom) == 1) {
//                                ch1 = ch1 - 1;
//                                c1 = object.convertBack(ch1);
//                                ch2 = ch2 - 1;
//                                c2 = object.convertBack(ch2);
//                                ch3 = ch3 - 1;
//                                c3 = object.convertBack(ch3);
//                                ch4 = ch4 - 1;
//                                c4 = object.convertBack(ch4);
//                            } else if ((checkto - checkfrom) == 2) {
//                                ch1 = ch1 - 2;
//                                c1 = object.convertBack(ch1);
//                                ch2 = ch2 - 2;
//                                c2 = object.convertBack(ch2);
//                                ch3 = ch3 - 2;
//                                c3 = object.convertBack(ch3);
//                                ch4 = ch4 - 2;
//                                c4 = object.convertBack(ch4);
//                            } else if ((checkto - checkfrom) == 3) {
//                                ch1 = ch1 - 3;
//                                c1 = object.convertBack(ch1);
//                                ch2 = ch2 - 3;
//                                c2 = object.convertBack(ch2);
//                                ch3 = ch3 - 3;
//                                c3 = object.convertBack(ch3);
//                                ch4 = ch4 - 3;
//                                c4 = object.convertBack(ch4);
//                            } else if ((checkto - checkfrom) == 4) {
//                                ch1 = ch1 - 4;
//                                c1 = object.convertBack(ch1);
//                                ch2 = ch2 - 4;
//                                c2 = object.convertBack(ch2);
//                                ch3 = ch3 - 4;
//                                c3 = object.convertBack(ch3);
//                                ch4 = ch4 - 4;
//                                c4 = object.convertBack(ch4);
//                            } else if ((checkto - checkfrom) == 5) {
//                                ch1 = ch1 - 5;
//                                c1 = object.convertBack(ch1);
//                                ch2 = ch2 - 5;
//                                c2 = object.convertBack(ch2);
//                                ch3 = ch3 - 5;
//                                c3 = object.convertBack(ch3);
//                                ch4 = ch4 - 5;
//                                c4 = object.convertBack(ch4);
//                            } else if ((checkto - checkfrom) == 6) {
//                                ch1 = ch1 - 6;
//                                c1 = object.convertBack(ch1);
//                                ch2 = ch2 - 6;
//                                c2 = object.convertBack(ch2);
//                                ch3 = ch3 - 6;
//                                c3 = object.convertBack(ch3);
//                                ch4 = ch4 - 6;
//                                c4 = object.convertBack(ch4);
//                            } else if ((checkto - checkfrom) == 7) {
//                                ch1 = ch1 - 7;
//                                c1 = object.convertBack(ch1);
//                                ch2 = ch2 - 7;
//                                c2 = object.convertBack(ch2);
//                                ch3 = ch3 - 7;
//                                c3 = object.convertBack(ch3);
//                                ch4 = ch4 - 7;
//                                c4 = object.convertBack(ch4);
//                            } else if ((checkto - checkfrom) == 8) {
//                                ch1 = ch1 - 8;
//                                c1 = object.convertBack(ch1);
//                                ch2 = ch2 - 8;
//                                c2 = object.convertBack(ch2);
//                                ch3 = ch3 - 8;
//                                c3 = object.convertBack(ch3);
//                                ch4 = ch4 - 8;
//                                c4 = object.convertBack(ch4);
//                            } else if ((checkto - checkfrom) == 9) {
//                                ch1 = ch1 - 9;
//                                c1 = object.convertBack(ch1);
//                                ch2 = ch2 - 9;
//                                c2 = object.convertBack(ch2);
//                                ch3 = ch3 - 9;
//                                c3 = object.convertBack(ch3);
//                                ch4 = ch4 - 9;
//                                c4 = object.convertBack(ch4);
//                            } else if ((checkto - checkfrom) == 10) {
//                                ch1 = ch1 - 10;
//                                c1 = object.convertBack(ch1);
//                                ch2 = ch2 - 10;
//                                c2 = object.convertBack(ch2);
//                                ch3 = ch3 - 10;
//                                c3 = object.convertBack(ch3);
//                                ch4 = ch4 - 10;
//                                c4 = object.convertBack(ch4);
//                            } else if ((checkto - checkfrom) == 11) {
//                                ch1 = ch1 - 11;
//                                c1 = object.convertBack(ch1);
//                                ch2 = ch2 - 11;
//                                c2 = object.convertBack(ch2);
//                                ch3 = ch3 - 11;
//                                c3 = object.convertBack(ch3);
//                                ch4 = ch4 - 11;
//                                c4 = object.convertBack(ch4);
//                            }
//                        } else {
//                            if ((checkfrom - checkto) == 0) {
//                                ch1 = ch1 + 0;
//                                c1 = object.convertBack(ch1);
//                                ch2 = ch2 + 0;
//                                c2 = object.convertBack(ch2);
//                                ch3 = ch3 + 0;
//                                c3 = object.convertBack(ch3);
//                                ch4 = ch4 + 0;
//                                c4 = object.convertBack(ch4);
//                            } else if ((checkfrom - checkto) == 1) {
//                                ch1 = ch1 + 1;
//                                c1 = object.convertBack(ch1);
//                                ch2 = ch2 + 1;
//                                c2 = object.convertBack(ch2);
//                                ch3 = ch3 + 1;
//                                c3 = object.convertBack(ch3);
//                                ch4 = ch4 + 1;
//                                c4 = object.convertBack(ch4);
//                            } else if ((checkfrom - checkto) == 2) {
//                                ch1 = ch1 + 2;
//                                c1 = object.convertBack(ch1);
//                                ch2 = ch2 + 2;
//                                c2 = object.convertBack(ch2);
//                                ch3 = ch3 + 2;
//                                c3 = object.convertBack(ch3);
//                                ch4 = ch4 + 2;
//                                c4 = object.convertBack(ch4);
//                            } else if ((checkfrom - checkto) == 3) {
//                                ch1 = ch1 + 3;
//                                c1 = object.convertBack(ch1);
//                                ch2 = ch2 + 3;
//                                c2 = object.convertBack(ch2);
//                                ch3 = ch3 + 3;
//                                c3 = object.convertBack(ch3);
//                                ch4 = ch4 + 3;
//                                c4 = object.convertBack(ch4);
//                            } else if ((checkfrom - checkto) == 4) {
//                                ch1 = ch1 + 4;
//                                c1 = object.convertBack(ch1);
//                                ch2 = ch2 + 4;
//                                c2 = object.convertBack(ch2);
//                                ch3 = ch3 + 4;
//                                c3 = object.convertBack(ch3);
//                                ch4 = ch4 + 4;
//                                c4 = object.convertBack(ch4);
//                            } else if ((checkfrom - checkto) == 5) {
//                                ch1 = ch1 + 5;
//                                c1 = object.convertBack(ch1);
//                                ch2 = ch2 + 5;
//                                c2 = object.convertBack(ch2);
//                                ch3 = ch3 + 5;
//                                c3 = object.convertBack(ch3);
//                                ch4 = ch4 + 5;
//                                c4 = object.convertBack(ch4);
//                            } else if ((checkfrom - checkto) == 6) {
//                                ch1 = ch1 + 6;
//                                c1 = object.convertBack(ch1);
//                                ch2 = ch2 + 6;
//                                c2 = object.convertBack(ch2);
//                                ch3 = ch3 + 6;
//                                c3 = object.convertBack(ch3);
//                                ch4 = ch4 + 6;
//                                c4 = object.convertBack(ch4);
//                            } else if ((checkfrom - checkto) == 7) {
//                                ch1 = ch1 + 7;
//                                c1 = object.convertBack(ch1);
//                                ch2 = ch2 + 7;
//                                c2 = object.convertBack(ch2);
//                                ch3 = ch3 + 7;
//                                c3 = object.convertBack(ch3);
//                                ch4 = ch4 + 7;
//                                c4 = object.convertBack(ch4);
//                            } else if ((checkfrom - checkto) == 8) {
//                                ch1 = ch1 + 8;
//                                c1 = object.convertBack(ch1);
//                                ch2 = ch2 + 8;
//                                c2 = object.convertBack(ch2);
//                                ch3 = ch3 + 8;
//                                c3 = object.convertBack(ch3);
//                                ch4 = ch4 + 8;
//                                c4 = object.convertBack(ch4);
//                            } else if ((checkfrom - checkto) == 9) {
//                                ch1 = ch1 + 9;
//                                c1 = object.convertBack(ch1);
//                                ch2 = ch2 + 9;
//                                c2 = object.convertBack(ch2);
//                                ch3 = ch3 + 9;
//                                c3 = object.convertBack(ch3);
//                                ch4 = ch4 + 9;
//                                c4 = object.convertBack(ch4);
//                            } else if ((checkfrom - checkto) == 10) {
//                                ch1 = ch1 + 10;
//                                c1 = object.convertBack(ch1);
//                                ch2 = ch2 + 10;
//                                c2 = object.convertBack(ch2);
//                                ch3 = ch3 + 10;
//                                c3 = object.convertBack(ch3);
//                                ch4 = ch4 + 10;
//                                c4 = object.convertBack(ch4);
//                            } else if ((checkfrom - checkto) == 11) {
//                                ch1 = ch1 + 11;
//                                c1 = object.convertBack(ch1);
//                                ch2 = ch2 + 11;
//                                c2 = object.convertBack(ch2);
//                                ch3 = ch3 + 11;
//                                c3 = object.convertBack(ch3);
//                                ch4 = ch4 + 11;
//                                c4 = object.convertBack(ch4);
//                            }
//                        }
//                        if (mirror1 == 0) {
//                            if (chord1.getText().length() == 2 && chord1.getText().toString().substring(1, 2).equalsIgnoreCase("m"))
//                                transposedchord1.setText(c1 + "m");
//                            else if (chord1.getText().length() == 3)
//                                transposedchord1.setText(c1 + "m");
//                            else
//                                transposedchord1.setText(c1);
//                        } else
//                            transposedchord1.setText("");
//                        if (mirror2 == 0) {
//                            if (chord2.getText().length() == 2 && chord2.getText().toString().substring(1, 2).equalsIgnoreCase("m"))
//                                transposedchord2.setText(c2 + "m");
//                            else if (chord2.getText().length() == 3)
//                                transposedchord2.setText(c2 + "m");
//                            else
//                                transposedchord2.setText(c2);
//                        } else
//                            transposedchord2.setText("");
//                        if (mirror3 == 0) {
//                            if (chord3.getText().length() == 2 && chord3.getText().toString().substring(1, 2).equalsIgnoreCase("m"))
//                                transposedchord3.setText(c3 + "m");
//                            else if (chord3.getText().length() == 3)
//                                transposedchord3.setText(c3 + "m");
//                            else
//                                transposedchord3.setText(c3);
//                        } else {
//                            transposedchord3.setText("");
//                        }
//                        if (mirror4 == 0) {
//                            if (chord4.getText().length() == 2 && chord4.getText().toString().substring(1, 2).equalsIgnoreCase("m"))
//                                transposedchord4.setText(c4 + "m");
//                            else if (chord4.getText().length() == 3)
//                                transposedchord4.setText(c4 + "m");
//                            else
//                                transposedchord4.setText(c4);
//                        } else {
//                            transposedchord4.setText("");
//                        }
//                    } else {
//                        transposefrom.setError("Input from 0 to 11");
//                        transposeto.setError("Input from 0 to 11");
//                        Toast.makeText(MainPageUpdated.this, "You need to fill both fields", Toast.LENGTH_SHORT).show();
//                    }
//                } catch (NumberFormatException e) {
//                    transposefrom.setError("Input from 0 to 11");
//                    transposeto.setError("Input from 0 to 11");
//                    Toast.makeText(MainPageUpdated.this, "You need to fill both fields", Toast.LENGTH_LONG).show();
//                }
            }
        });
    }*/
}
