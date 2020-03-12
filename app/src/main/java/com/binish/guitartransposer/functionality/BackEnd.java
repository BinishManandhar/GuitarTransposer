package com.binish.guitartransposer.functionality;

import android.util.Log;

public class BackEnd {
    String a, bb, b, c, dd, d, eb, e, f, gb, g, ab;
    private int dummy;

    public int convert(String mainchord) {
        String chord;
        if (mainchord.length() > 2) {
            //Log.i("tag", "Length" + mainchord.length());
            String rootChord = mainchord.substring(0, 2);
            chord = rootChord;
            Log.i("tag", "Chord:" + chord);
        }
        else if(mainchord.length()==2 && (mainchord.substring(1,2)).equalsIgnoreCase("m")) {
            chord=mainchord.substring(0,1);
            //Log.i("tag", "Chord:" + chord);
        }
        else {
            chord = mainchord;
            //Log.i("tag", "Chord:" + chord);
        }
        if (chord.equalsIgnoreCase("A")) {
            dummy = 0;
            return dummy;
        } else if (chord.equalsIgnoreCase("A#") || chord.equalsIgnoreCase("Bb")) {
            dummy = 1;
            return dummy;
        } else if (chord.equalsIgnoreCase("B")) {
            dummy = 2;
            return dummy;
        } else if (chord.equalsIgnoreCase("C")) {
            dummy = 3;
            return dummy;
        } else if (chord.equalsIgnoreCase("C#") || chord.equalsIgnoreCase("Db")) {
            dummy = 4;
            return dummy;
        } else if (chord.equalsIgnoreCase("D")) {
            dummy = 5;
            return dummy;
        } else if (chord.equalsIgnoreCase("D#") || chord.equalsIgnoreCase("Eb")) {
            dummy = 6;
            return dummy;
        } else if (chord.equalsIgnoreCase("E")) {
            dummy = 7;
            return dummy;
        } else if (chord.equalsIgnoreCase("F")) {
            dummy = 8;
            return dummy;
        } else if (chord.equalsIgnoreCase("F#") || chord.equalsIgnoreCase("Gb")) {
            dummy = 9;
            return dummy;
        } else if (chord.equalsIgnoreCase("G")) {
            dummy = 10;
            return dummy;
        } else if (chord.equalsIgnoreCase("G#") || chord.equalsIgnoreCase("Ab")) {
            dummy = 11;
            return dummy;
        } else if (chord.equalsIgnoreCase("")) {
            //Log.i("tag", "Empty");
            return 12;
        } else
            return 13;

    }

    public String convertBack(Integer dummy) {
        if (dummy == 0 || dummy == 12 || dummy == -12)
            return "A";
        else if (dummy == 1 || dummy == 13 || dummy == -11)
            return "A#/Bb";
        else if (dummy == 2 || dummy == 14 || dummy == -10)
            return "B";
        else if (dummy == 3 || dummy == 15 || dummy == -9)
            return "C";
        else if (dummy == 4 || dummy == 16 || dummy == -8)
            return "C#/Db";
        else if (dummy == 5 || dummy == 17 || dummy == -7)
            return "D";
        else if (dummy == 6 || dummy == 18 || dummy == -6)
            return "D#/Eb";
        else if (dummy == 7 || dummy == 19 || dummy == -5)
            return "E";
        else if (dummy == 8 || dummy == 20 || dummy == -4)
            return "F";
        else if (dummy == 9 || dummy == 21 || dummy == -3)
            return "F#/Gb";
        else if (dummy == 10 || dummy == 22 || dummy == -2)
            return "G";
        else if (dummy == 11 || dummy == 23 || dummy == -1)
            return "G#/Ab";
        else
            return "Invalid";
    }

    /*  <item>A</item> 0
        <item>A#/Bb</item> 1
        <item>Am</item> 2
        <item>A#m</item> 3
        <item>B</item> 4
        <item>Bm</item> 5
        <item>C</item> 6
        <item>C#/Db</item> 7
        <item>Cm</item> 8
        <item>C#m</item> 9
        <item>D</item> 10
        <item>D#/Eb</item> 11
        <item>Dm</item> 12
        <item>D#m</item> 13
        <item>E</item> 14
        <item>Em</item> 15
        <item>F</item> 16
        <item>F#/Gb</item> 17
        <item>Fm</item> 18
        <item>F#m</item> 19
        <item>G</item> 20
        <item>G#/Ab</item> 21
        <item>Gm</item> 22
        <item>G#m</item> 23
        */

    public int convertBackInteger(Integer dummy) {
        if (dummy == 0 || dummy == 12 || dummy == -12)
            return 0;
        else if (dummy == 1 || dummy == 13 || dummy == -11)
            return 1;
        else if (dummy == 2 || dummy == 14 || dummy == -10)
            return 4;
        else if (dummy == 3 || dummy == 15 || dummy == -9)
            return 6;
        else if (dummy == 4 || dummy == 16 || dummy == -8)
            return 7;
        else if (dummy == 5 || dummy == 17 || dummy == -7)
            return 10;
        else if (dummy == 6 || dummy == 18 || dummy == -6)
            return 11;
        else if (dummy == 7 || dummy == 19 || dummy == -5)
            return 14;
        else if (dummy == 8 || dummy == 20 || dummy == -4)
            return 16;
        else if (dummy == 9 || dummy == 21 || dummy == -3)
            return 17;
        else if (dummy == 10 || dummy == 22 || dummy == -2)
            return 20;
        else if (dummy == 11 || dummy == 23 || dummy == -1)
            return 21;
        else
            return 0;
    }
}
