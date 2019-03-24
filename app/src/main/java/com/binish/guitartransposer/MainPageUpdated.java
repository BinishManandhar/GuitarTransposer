package com.binish.guitartransposer;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AndroidException;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainPageUpdated extends AppCompatActivity implements View.OnClickListener {
    Spinner chord1, chord2, chord3, chord4;
    EditText transposefrom, transposeto;
    EditText transposedchord1, transposedchord2, transposedchord3, transposedchord4;
    Button transposebttn, capochangebttn, fromPlus, fromMinus, toPlus, toMinus;
    String whichBttn="null";
    boolean capoClicked = false;
    boolean transposeClicked = false;
    boolean whichClicked=false;

    int from = 0;
    int to=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page_updated);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        chord1 = findViewById(R.id.chord1);
        chord2 = findViewById(R.id.chord2);
        chord3 = findViewById(R.id.chord3);
        chord4 = findViewById(R.id.chord4);
        transposefrom = findViewById(R.id.transposefrom);
        transposeto = findViewById(R.id.transposeto);
        transposedchord1 = findViewById(R.id.transposedchord1);
        transposedchord2 = findViewById(R.id.transposedchord2);
        transposedchord3 = findViewById(R.id.transposedchord3);
        transposedchord4 = findViewById(R.id.transposedchord4);
        transposebttn = findViewById(R.id.transposebttn);
        capochangebttn = findViewById(R.id.capochangebttn);
        fromPlus = findViewById(R.id.fromplus);
        fromMinus = findViewById(R.id.fromminus);
        toPlus = findViewById(R.id.toplus);
        toMinus = findViewById(R.id.tominus);


        transposefrom.setText(String.valueOf(from));
        transposeto.setText(String.valueOf(to));

    //----------------------------------------------------------------------------------------------------------//
        fromMinus.setOnClickListener(this);
        toMinus.setOnClickListener(this);
        fromPlus.setOnClickListener(this);
        toPlus.setOnClickListener(this);
        capochangebttn.setOnClickListener(this);
        transposebttn.setOnClickListener(this);
        chord1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(whichBttn.equals("capo"))
                    capoChange();
                else if(whichBttn.equals("transpose"))
                    transposeChange();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        chord2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(whichBttn.equals("capo"))
                    capoChange();
                else if(whichBttn.equals("transpose"))
                    transposeChange();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        chord3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(whichBttn.equals("capo"))
                    capoChange();
                else if(whichBttn.equals("transpose"))
                    transposeChange();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        chord4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(whichBttn.equals("capo"))
                    capoChange();
                else if(whichBttn.equals("transpose"))
                    transposeChange();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    //--------------------------------------------------------------------------------------------------------//

        ArrayAdapter<String> arrayChord1 = new ArrayAdapter<>(this,R.layout.chords_item, getResources().getStringArray(R.array.chords));
        arrayChord1.setDropDownViewResource(R.layout.chord_items);
        chord1.setAdapter(arrayChord1);

        ArrayAdapter<String> arrayChord2 = new ArrayAdapter<>(this,R.layout.chords_item, getResources().getStringArray(R.array.chords));
        arrayChord2.setDropDownViewResource(R.layout.chord_items);
        chord2.setAdapter(arrayChord2);
        chord2.setSelection(3);

        ArrayAdapter<String> arrayChord3 = new ArrayAdapter<>(this,R.layout.chords_item, getResources().getStringArray(R.array.chords));
        arrayChord3.setDropDownViewResource(R.layout.chord_items);
        chord3.setAdapter(arrayChord3);
        chord3.setSelection(5);

        ArrayAdapter<String> arrayChord4 = new ArrayAdapter<>(this,R.layout.chords_item, getResources().getStringArray(R.array.chords));
        arrayChord4.setDropDownViewResource(R.layout.chord_items);
        chord4.setAdapter(arrayChord4);
        chord4.setSelection(8);

    }

    public void capoChange() {
        String c1 = chord1.getSelectedItem().toString();
        String c2 = chord2.getSelectedItem().toString();
        String c3 = chord3.getSelectedItem().toString();
        String c4 = chord4.getSelectedItem().toString();
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
                        ch1 = ch1 - 0;
                        c1 = object.convertBack(ch1);
                        ch2 = ch2 - 0;
                        c2 = object.convertBack(ch2);
                        ch3 = ch3 - 0;
                        c3 = object.convertBack(ch3);
                        ch4 = ch4 - 0;
                        c4 = object.convertBack(ch4);
                    } else if ((checkto - checkfrom) == 1) {
                        ch1 = ch1 - 1;
                        c1 = object.convertBack(ch1);
                        ch2 = ch2 - 1;
                        c2 = object.convertBack(ch2);
                        ch3 = ch3 - 1;
                        c3 = object.convertBack(ch3);
                        ch4 = ch4 - 1;
                        c4 = object.convertBack(ch4);
                    } else if ((checkto - checkfrom) == 2) {
                        ch1 = ch1 - 2;
                        c1 = object.convertBack(ch1);
                        ch2 = ch2 - 2;
                        c2 = object.convertBack(ch2);
                        ch3 = ch3 - 2;
                        c3 = object.convertBack(ch3);
                        ch4 = ch4 - 2;
                        c4 = object.convertBack(ch4);
                    } else if ((checkto - checkfrom) == 3) {
                        ch1 = ch1 - 3;
                        c1 = object.convertBack(ch1);
                        ch2 = ch2 - 3;
                        c2 = object.convertBack(ch2);
                        ch3 = ch3 - 3;
                        c3 = object.convertBack(ch3);
                        ch4 = ch4 - 3;
                        c4 = object.convertBack(ch4);
                    } else if ((checkto - checkfrom) == 4) {
                        ch1 = ch1 - 4;
                        c1 = object.convertBack(ch1);
                        ch2 = ch2 - 4;
                        c2 = object.convertBack(ch2);
                        ch3 = ch3 - 4;
                        c3 = object.convertBack(ch3);
                        ch4 = ch4 - 4;
                        c4 = object.convertBack(ch4);
                    } else if ((checkto - checkfrom) == 5) {
                        ch1 = ch1 - 5;
                        c1 = object.convertBack(ch1);
                        ch2 = ch2 - 5;
                        c2 = object.convertBack(ch2);
                        ch3 = ch3 - 5;
                        c3 = object.convertBack(ch3);
                        ch4 = ch4 - 5;
                        c4 = object.convertBack(ch4);
                    } else if ((checkto - checkfrom) == 6) {
                        ch1 = ch1 - 6;
                        c1 = object.convertBack(ch1);
                        ch2 = ch2 - 6;
                        c2 = object.convertBack(ch2);
                        ch3 = ch3 - 6;
                        c3 = object.convertBack(ch3);
                        ch4 = ch4 - 6;
                        c4 = object.convertBack(ch4);
                    } else if ((checkto - checkfrom) == 7) {
                        ch1 = ch1 - 7;
                        c1 = object.convertBack(ch1);
                        ch2 = ch2 - 7;
                        c2 = object.convertBack(ch2);
                        ch3 = ch3 - 7;
                        c3 = object.convertBack(ch3);
                        ch4 = ch4 - 7;
                        c4 = object.convertBack(ch4);
                    } else if ((checkto - checkfrom) == 8) {
                        ch1 = ch1 - 8;
                        c1 = object.convertBack(ch1);
                        ch2 = ch2 - 8;
                        c2 = object.convertBack(ch2);
                        ch3 = ch3 - 8;
                        c3 = object.convertBack(ch3);
                        ch4 = ch4 - 8;
                        c4 = object.convertBack(ch4);
                    } else if ((checkto - checkfrom) == 9) {
                        ch1 = ch1 - 9;
                        c1 = object.convertBack(ch1);
                        ch2 = ch2 - 9;
                        c2 = object.convertBack(ch2);
                        ch3 = ch3 - 9;
                        c3 = object.convertBack(ch3);
                        ch4 = ch4 - 9;
                        c4 = object.convertBack(ch4);
                    } else if ((checkto - checkfrom) == 10) {
                        ch1 = ch1 - 10;
                        c1 = object.convertBack(ch1);
                        ch2 = ch2 - 10;
                        c2 = object.convertBack(ch2);
                        ch3 = ch3 - 10;
                        c3 = object.convertBack(ch3);
                        ch4 = ch4 - 10;
                        c4 = object.convertBack(ch4);
                    } else if ((checkto - checkfrom) == 11) {
                        ch1 = ch1 - 11;
                        c1 = object.convertBack(ch1);
                        ch2 = ch2 - 11;
                        c2 = object.convertBack(ch2);
                        ch3 = ch3 - 11;
                        c3 = object.convertBack(ch3);
                        ch4 = ch4 - 11;
                        c4 = object.convertBack(ch4);
                    }
                } else {
                    if ((checkfrom - checkto) == 0) {
                        ch1 = ch1 + 0;
                        c1 = object.convertBack(ch1);
                        ch2 = ch2 + 0;
                        c2 = object.convertBack(ch2);
                        ch3 = ch3 + 0;
                        c3 = object.convertBack(ch3);
                        ch4 = ch4 + 0;
                        c4 = object.convertBack(ch4);
                    } else if ((checkfrom - checkto) == 1) {
                        ch1 = ch1 + 1;
                        c1 = object.convertBack(ch1);
                        ch2 = ch2 + 1;
                        c2 = object.convertBack(ch2);
                        ch3 = ch3 + 1;
                        c3 = object.convertBack(ch3);
                        ch4 = ch4 + 1;
                        c4 = object.convertBack(ch4);
                    } else if ((checkfrom - checkto) == 2) {
                        ch1 = ch1 + 2;
                        c1 = object.convertBack(ch1);
                        ch2 = ch2 + 2;
                        c2 = object.convertBack(ch2);
                        ch3 = ch3 + 2;
                        c3 = object.convertBack(ch3);
                        ch4 = ch4 + 2;
                        c4 = object.convertBack(ch4);
                    } else if ((checkfrom - checkto) == 3) {
                        ch1 = ch1 + 3;
                        c1 = object.convertBack(ch1);
                        ch2 = ch2 + 3;
                        c2 = object.convertBack(ch2);
                        ch3 = ch3 + 3;
                        c3 = object.convertBack(ch3);
                        ch4 = ch4 + 3;
                        c4 = object.convertBack(ch4);
                    } else if ((checkfrom - checkto) == 4) {
                        ch1 = ch1 + 4;
                        c1 = object.convertBack(ch1);
                        ch2 = ch2 + 4;
                        c2 = object.convertBack(ch2);
                        ch3 = ch3 + 4;
                        c3 = object.convertBack(ch3);
                        ch4 = ch4 + 4;
                        c4 = object.convertBack(ch4);
                    } else if ((checkfrom - checkto) == 5) {
                        ch1 = ch1 + 5;
                        c1 = object.convertBack(ch1);
                        ch2 = ch2 + 5;
                        c2 = object.convertBack(ch2);
                        ch3 = ch3 + 5;
                        c3 = object.convertBack(ch3);
                        ch4 = ch4 + 5;
                        c4 = object.convertBack(ch4);
                    } else if ((checkfrom - checkto) == 6) {
                        ch1 = ch1 + 6;
                        c1 = object.convertBack(ch1);
                        ch2 = ch2 + 6;
                        c2 = object.convertBack(ch2);
                        ch3 = ch3 + 6;
                        c3 = object.convertBack(ch3);
                        ch4 = ch4 + 6;
                        c4 = object.convertBack(ch4);
                    } else if ((checkfrom - checkto) == 7) {
                        ch1 = ch1 + 7;
                        c1 = object.convertBack(ch1);
                        ch2 = ch2 + 7;
                        c2 = object.convertBack(ch2);
                        ch3 = ch3 + 7;
                        c3 = object.convertBack(ch3);
                        ch4 = ch4 + 7;
                        c4 = object.convertBack(ch4);
                    } else if ((checkfrom - checkto) == 8) {
                        ch1 = ch1 + 8;
                        c1 = object.convertBack(ch1);
                        ch2 = ch2 + 8;
                        c2 = object.convertBack(ch2);
                        ch3 = ch3 + 8;
                        c3 = object.convertBack(ch3);
                        ch4 = ch4 + 8;
                        c4 = object.convertBack(ch4);
                    } else if ((checkfrom - checkto) == 9) {
                        ch1 = ch1 + 9;
                        c1 = object.convertBack(ch1);
                        ch2 = ch2 + 9;
                        c2 = object.convertBack(ch2);
                        ch3 = ch3 + 9;
                        c3 = object.convertBack(ch3);
                        ch4 = ch4 + 9;
                        c4 = object.convertBack(ch4);
                    } else if ((checkfrom - checkto) == 10) {
                        ch1 = ch1 + 10;
                        c1 = object.convertBack(ch1);
                        ch2 = ch2 + 10;
                        c2 = object.convertBack(ch2);
                        ch3 = ch3 + 10;
                        c3 = object.convertBack(ch3);
                        ch4 = ch4 + 10;
                        c4 = object.convertBack(ch4);
                    } else if ((checkfrom - checkto) == 11) {
                        ch1 = ch1 + 11;
                        c1 = object.convertBack(ch1);
                        ch2 = ch2 + 11;
                        c2 = object.convertBack(ch2);
                        ch3 = ch3 + 11;
                        c3 = object.convertBack(ch3);
                        ch4 = ch4 + 11;
                        c4 = object.convertBack(ch4);
                    }
                }
                if (mirror1 == 0) {
                    if (chord1.getSelectedItem().toString().length() == 2 && chord1.getSelectedItem().toString().substring(1, 2).equalsIgnoreCase("m"))
                        transposedchord1.setText(c1 + "m");
                    else if (chord1.getSelectedItem().toString().length() == 3)
                        transposedchord1.setText(c1 + "m");
                    else
                        transposedchord1.setText(c1);
                } else
                    transposedchord1.setText("");
                if (mirror2 == 0) {
                    if (chord2.getSelectedItem().toString().length() == 2 && chord2.getSelectedItem().toString().substring(1, 2).equalsIgnoreCase("m"))
                        transposedchord2.setText(c2 + "m");
                    else if (chord2.getSelectedItem().toString().length() == 3)
                        transposedchord2.setText(c2 + "m");
                    else
                        transposedchord2.setText(c2);
                } else
                    transposedchord2.setText("");
                if (mirror3 == 0) {
                    if (chord3.getSelectedItem().toString().length() == 2 && chord3.getSelectedItem().toString().substring(1, 2).equalsIgnoreCase("m"))
                        transposedchord3.setText(c3 + "m");
                    else if (chord3.getSelectedItem().toString().length() == 3)
                        transposedchord3.setText(c3 + "m");
                    else
                        transposedchord3.setText(c3);
                } else {
                    transposedchord3.setText("");
                }
                if (mirror4 == 0) {
                    if (chord4.getSelectedItem().toString().length() == 2 && chord4.getSelectedItem().toString().substring(1, 2).equalsIgnoreCase("m"))
                        transposedchord4.setText(c4 + "m");
                    else if (chord4.getSelectedItem().toString().length() == 3)
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

    public void transposeChange() {
        String c1 = chord1.getSelectedItem().toString();
        String c2 = chord2.getSelectedItem().toString();
        String c3 = chord3.getSelectedItem().toString();
        String c4 = chord4.getSelectedItem().toString();
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
                    if (chord1.getSelectedItem().toString().length() == 2 && chord1.getSelectedItem().toString().substring(1, 2).equalsIgnoreCase("m"))
                        transposedchord1.setText(c1 + "m");
                    else if (chord1.getSelectedItem().toString().length() == 3)
                        transposedchord1.setText(c1 + "m");
                    else
                        transposedchord1.setText(c1);
                } else {
                    transposedchord1.setText("");
                }
                if (mirror2 == 0) {
                    if (chord2.getSelectedItem().toString().length() == 2 && chord2.getSelectedItem().toString().substring(1, 2).equalsIgnoreCase("m"))
                        transposedchord2.setText(c2 + "m");
                    else if (chord2.getSelectedItem().toString().length() == 3)
                        transposedchord2.setText(c2 + "m");
                    else
                        transposedchord2.setText(c2);
                } else {
                    transposedchord2.setText("");
                }
                if (mirror3 == 0) {
                    if (chord3.getSelectedItem().toString().length() == 2 && chord3.getSelectedItem().toString().substring(1, 2).equalsIgnoreCase("m"))
                        transposedchord3.setText(c3 + "m");
                    else if (chord3.getSelectedItem().toString().length() == 3)
                        transposedchord3.setText(c3 + "m");
                    else
                        transposedchord3.setText(c3);
                } else {
                    transposedchord3.setText("");
                }
                if (mirror4 == 0) {
                    if (chord4.getSelectedItem().toString().length() == 2 && chord4.getSelectedItem().toString().substring(1, 2).equalsIgnoreCase("m"))
                        transposedchord4.setText(c4 + "m");
                    else if (chord4.getSelectedItem().toString().length() == 3)
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fromplus:
                if(from>=0&&from<=10) {
                    from++;
                    transposefrom.setText(String.valueOf(from));
                }
                if(capoClicked || transposeClicked) {
                    if (whichBttn.equals("capo"))
                        capoChange();
                    else if (whichBttn.equals("transpose"))
                        transposeChange();
                }
                break;
            case R.id.fromminus:
                if(from<=11&&from>0) {
                    from--;
                    transposefrom.setText(String.valueOf(from));
                }
                if(capoClicked || transposeClicked) {
                    if (whichBttn.equals("capo"))
                        capoChange();
                    else if (whichBttn.equals("transpose"))
                        transposeChange();
                }
                break;
            case R.id.toplus:
                if(to>=0&&to<=10) {
                    to++;
                    transposeto.setText(String.valueOf(to));
                }
                if(capoClicked || transposeClicked) {
                    if (whichBttn.equals("capo"))
                        capoChange();
                    else if (whichBttn.equals("transpose"))
                        transposeChange();
                }
                break;
            case R.id.tominus:
                if(to<=11&&to>0) {
                    to--;
                    transposeto.setText(String.valueOf(to));
                }
                if(capoClicked || transposeClicked) {
                    if (whichBttn.equals("capo"))
                        capoChange();
                    else if (whichBttn.equals("transpose"))
                        transposeChange();
                }
                break;
            case R.id.capochangebttn:
                if(whichBttn.equalsIgnoreCase("transpose")){
                    transposebttn.setBackground(getResources().getDrawable(R.drawable.btn_selector));
                    transposeClicked = false;
//                    transposebttn.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                }
                if(!whichClicked)
                    whichBttn = "capo";
                else
                    whichBttn = "null";

                if (!capoClicked&& !transposeClicked) {
                    capochangebttn.setBackground(getResources().getDrawable(R.drawable.btn_selected));
                    capoClicked = true;
                    capochangebttn.setTextColor(getResources().getColor(R.color.textColor));
                    capoChange();
                } else {
                    capochangebttn.setBackground(getResources().getDrawable(R.drawable.btn_selector));
                    capoClicked = false;
//                    capochangebttn.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                }
                break;
            case R.id.transposebttn:
                if(whichBttn.equalsIgnoreCase("capo")){
                    capochangebttn.setBackground(getResources().getDrawable(R.drawable.btn_selector));
                    capoClicked = false;
//                    capochangebttn.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                }
                if(!whichClicked){
                    whichBttn = "transpose";
                }
                else
                    whichBttn = "null";

                if (!transposeClicked && !capoClicked) {
                    transposebttn.setBackground(getResources().getDrawable(R.drawable.btn_selected));
                    transposeClicked = true;
                    transposebttn.setTextColor(getResources().getColor(R.color.textColor));
                    transposeChange();
                } else {
                    transposebttn.setBackground(getResources().getDrawable(R.drawable.btn_selector));
                    transposeClicked = false;
//                    transposebttn.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                }
                break;
        }
    }

}
