package com.binish.guitartransposer.functionality

import com.shawnlin.numberpicker.NumberPicker

class CapoChange {
    fun capoChange(c1Item: Int, checkfrom: Int, checkto: Int): Int {
        var ch1: Int = c1Item
        var mirror1 = 0
        var mirror2 = 0
        var mirror3 = 0
        var mirror4 = 0
        try {
            if (checkfrom >= 0 && checkfrom <= 11 || checkto >= 0 && checkto <= 11) {
                if (ch1 > 11) {
                    mirror1 = 1
                }
                if (checkto >= checkfrom) {
                    if (checkto - checkfrom == 0) {
                        ch1 = ch1 - 0
                        
                    } else if (checkto - checkfrom == 1) {
                        ch1 = ch1 - 1
                        
                    } else if (checkto - checkfrom == 2) {
                        ch1 = ch1 - 2

                    } else if (checkto - checkfrom == 3) {
                        ch1 = ch1 - 3

                    
                    } else if (checkto - checkfrom == 4) {
                        ch1 = ch1 - 4
                     

                    } else if (checkto - checkfrom == 5) {
                        ch1 = ch1 - 5
                     

                    } else if (checkto - checkfrom == 6) {
                        ch1 = ch1 - 6
                     

                    } else if (checkto - checkfrom == 7) {
                        ch1 = ch1 - 7

                      
                    } else if (checkto - checkfrom == 8) {
                        ch1 = ch1 - 8
                       

                    
                    } else if (checkto - checkfrom == 9) {
                        ch1 = ch1 - 9

                    } else if (checkto - checkfrom == 10) {
                        ch1 = ch1 - 10

                    
                    } else if (checkto - checkfrom == 11) {
                        ch1 = ch1 - 11
                       

                    }
                } else {
                    if (checkfrom - checkto == 0) {
                        ch1 = ch1 + 0
                       

                    } else if (checkfrom - checkto == 1) {
                        ch1 = ch1 + 1
                       

                    
                    } else if (checkfrom - checkto == 2) {
                        ch1 = ch1 + 2

                    } else if (checkfrom - checkto == 3) {
                        ch1 = ch1 + 3

                    
                    } else if (checkfrom - checkto == 4) {
                        ch1 = ch1 + 4

                    
                    } else if (checkfrom - checkto == 5) {
                        ch1 = ch1 + 5

                    
                    } else if (checkfrom - checkto == 6) {
                        ch1 = ch1 + 6

                    
                    } else if (checkfrom - checkto == 7) {
                        ch1 = ch1 + 7

                    
                    } else if (checkfrom - checkto == 8) {
                        ch1 = ch1 + 8

                    
                    } else if (checkfrom - checkto == 9) {
                        ch1 = ch1 + 9

                    
                    } else if (checkfrom - checkto == 10) {
                        ch1 = ch1 + 10

                    
                    } else if (checkfrom - checkto == 11) {
                        ch1 = ch1 + 11
                    
                    }
                }
            }
        } catch (e: NumberFormatException) {
            e.stackTrace
        }
        return ch1
    }
}