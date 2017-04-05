package ohtu;

public class Submission {
    private String student_number;
    private Integer week;
    private Integer hours;
    private Boolean a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12,
            a13, a14, a15, a16, a17, a18, a19, a20, a21;

    public String getStudent_number() {
        return student_number;
    }

    public void setStudent_number(String student_number) {
        this.student_number = student_number;
    }
    
    public Integer getHours() {
        return hours;
    }
    
    public Integer getTotalDone() {
        Integer t = 0;
        
        if (a1 != null && a1) { t ++; }
        if (a2 != null && a2) { t ++; }
        if (a3 != null && a3) { t ++; }
        if (a4 != null && a4) { t ++; }
        if (a5 != null && a5) { t ++; }
        if (a6 != null && a6) { t ++; }
        if (a7 != null && a7) { t ++; }
        if (a8 != null && a8) { t ++; }
        if (a9 != null && a9) { t ++; }
        if (a10 != null && a10) { t ++; }
        if (a11 != null && a11) { t ++; }
        if (a12 != null && a12) { t ++; }
        if (a13 != null && a13) { t ++; }
        if (a14 != null && a14) { t ++; }
        if (a15 != null && a15) { t ++; }
        if (a16 != null && a16) { t ++; }
        if (a17 != null && a17) { t ++; }
        if (a18 != null && a18) { t ++; }
        if (a19 != null && a19) { t ++; }
        if (a20 != null && a20) { t ++; }
        if (a21 != null && a21) { t ++; } 

        return t;
    }

    @Override
    public String toString() {
        String r = "";
        r = "viikko " + week + ": tehtyjä tehtäviä yhteensä: " 
            + getTotalDone() + ", aikaa kului " + hours 
            + " tuntia, tehdyt tehtävät:";
        
        if (a1 != null && a1) { r = r + " 1"; }
        if (a2 != null && a2) { r = r + " 2"; }
        if (a3 != null && a3) { r = r + " 3"; }
        if (a4 != null && a4) { r = r + " 4"; }
        if (a5 != null && a5) { r = r + " 5"; }
        if (a6 != null && a6) { r = r + " 6"; }
        if (a7 != null && a7) { r = r + " 7"; }
        if (a8 != null && a8) { r = r + " 8"; }
        if (a9 != null && a9) { r = r + " 9"; }
        if (a10 != null && a10) { r = r + " 10"; }
        if (a11 != null && a11) { r = r + " 11"; }
        if (a12 != null && a12) { r = r + " 12"; }
        if (a13 != null && a13) { r = r + " 13"; }
        if (a14 != null && a14) { r = r + " 14"; }
        if (a15 != null && a15) { r = r + " 15"; }
        if (a16 != null && a16) { r = r + " 16"; }
        if (a17 != null && a17) { r = r + " 17"; }
        if (a18 != null && a18) { r = r + " 18"; }
        if (a19 != null && a19) { r = r + " 19"; }
        if (a20 != null && a20) { r = r + " 20"; }
        if (a21 != null && a21) { r = r + " 21"; }
        
        return r;

    }
    
}
