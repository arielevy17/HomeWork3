public class Ex7 {
    //  פונקציה הבודקת האם הפונקציה היא ריבועית ובתבנית של: ax^2+bx+c=0
    public static boolean formatTester(String yourEquation){
    boolean properFormat=false;
     int correctCounter=0;
     char[] allNumbers= {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',};

     //  בדיקה שהתבנית נכונה כאשר A=1

        if (yourEquation.charAt(0) == 'x' &&  yourEquation.charAt(4)!='x') { // בדיקת שאר התבנית
            if (yourEquation.charAt(1) == '^' && yourEquation.charAt(2) == '2' && (yourEquation.charAt(3) == '+' || yourEquation.charAt(3) == '-') && yourEquation.charAt(5) == 'x' && (yourEquation.charAt(6) == '+' || yourEquation.charAt(6) == '-') && yourEquation.charAt(8) == '=' && yourEquation.charAt(9) == '0') {
                correctCounter = 1;
                for (int i = 0; i < allNumbers.length; i++) {  // בדיקה שמדובר במספר בa,b,c
                    if (yourEquation.charAt(4) == allNumbers[i]){
                        correctCounter++;
                    }
                    if (yourEquation.charAt(7) == allNumbers[i]){
                        correctCounter++;
                    }
                }
                if (correctCounter == 3) {
                    return true;
                }
            }
        }

     //  כשיש מינוס x בהתחלה
   else if (yourEquation.charAt(0)=='-'&& yourEquation.charAt(1)=='x' && yourEquation.charAt(5)!='x') {  // בדיקת שאר התבנית
            if (yourEquation.charAt(2) == '^' && yourEquation.charAt(3) == '2' && (yourEquation.charAt(4) == '+' || yourEquation.charAt(4) == '-') && yourEquation.charAt(6) == 'x' && (yourEquation.charAt(7) == '+' || yourEquation.charAt(7) == '-') && yourEquation.charAt(9) == '=' && yourEquation.charAt(10) == '0') {
                correctCounter = 1;
                for (int i = 0; i < allNumbers.length; i++) {  // בדיקת B,C
                    if (yourEquation.charAt(5) == allNumbers[i]) {
                        correctCounter++;
                    }
                    if (yourEquation.charAt(8) == allNumbers[i]){
                        correctCounter++;
                    }
                }
                if (correctCounter == 3) {
                    return true;
                }
            }
        }

        // כשיש מינוס בהתחלה
        else if (yourEquation.charAt(0)=='-' && yourEquation.charAt(5)!='x' && yourEquation.charAt(6)!='x') {  // בדיקת שאר התבנית
            if (yourEquation.charAt(2) == 'x' && yourEquation.charAt(3) == '^' && yourEquation.charAt(4) == '2' && (yourEquation.charAt(5) == '+' || yourEquation.charAt(5) == '-') && yourEquation.charAt(7) == 'x' && (yourEquation.charAt(8) == '+' || yourEquation.charAt(8) == '-') && yourEquation.charAt(10) == '=' && yourEquation.charAt(11) == '0') {
                for (int i = 0; i < allNumbers.length; i++) {
                    if (yourEquation.charAt(1) == allNumbers[i]){
                        correctCounter++;
                    }
                    if (yourEquation.charAt(6) == allNumbers[i]){
                        correctCounter++;
                    }
                   if (yourEquation.charAt(9) == allNumbers[i]){
                       correctCounter++;
                   }
                }
                if (correctCounter == 3) {
                    return true;
                }
            }
        }

 //     כאשר B=1

        else if (yourEquation.charAt(0)!='-'&& yourEquation.charAt(5)=='x' && (yourEquation.charAt(4)=='+'||yourEquation.charAt(4) =='-' )) {
            if (yourEquation.charAt(1) == 'x' && yourEquation.charAt(2) == '^' && yourEquation.charAt(3) == '2'  && (yourEquation.charAt(6) == '+' || yourEquation.charAt(6) == '-') && yourEquation.charAt(8) == '=' && yourEquation.charAt(9) == '0') {
                correctCounter = 1;
                for (int i = 0; i < allNumbers.length; i++) {
                    if (yourEquation.charAt(0) == allNumbers[i]){
                        correctCounter++;
                    }
                    if (yourEquation.charAt(7) == allNumbers[i]){
                        correctCounter++;
                    }
                }
                if (correctCounter == 3) {
                    return true;
                }
            }
        }

        // A= x וגם B=x
        else if (yourEquation.charAt(4)=='x' && yourEquation.charAt(0)=='x') {
            if (yourEquation.charAt(1) == '^' && yourEquation.charAt(2) == '2' && (yourEquation.charAt(3) == '+' || yourEquation.charAt(3) == '-') && (yourEquation.charAt(5) == '+' || yourEquation.charAt(5) == '-') && yourEquation.charAt(7) == '=' && yourEquation.charAt(8) == '0') {
                correctCounter = 2;
                for (int i = 0; i < allNumbers.length; i++) {
                    if (yourEquation.charAt(8) == allNumbers[i]) {
                        correctCounter++;
                    }
                }
                if (correctCounter == 3) {
                    return true;
                }
            }
        }

        //  a=-x וגם b=x
        else if (yourEquation.charAt(0)=='-'&& yourEquation.charAt(1)=='x' && yourEquation.charAt(5)=='x') {  // בדיקת שאר התבנית
                if (yourEquation.charAt(2) == '^' && yourEquation.charAt(3) == '2' && (yourEquation.charAt(4) == '+' || yourEquation.charAt(4) == '-') && (yourEquation.charAt(6) == '+' || yourEquation.charAt(6) == '-') && yourEquation.charAt(8) == '=' && yourEquation.charAt(9) == '0') {
                    correctCounter = 2;
                    for (int i = 0; i < allNumbers.length; i++) {  // בדיקת C
                        if (yourEquation.charAt(7) == allNumbers[i]) {
                            correctCounter++;
                        }
                    }
                    if (correctCounter == 3) {
                        return true;
                    }
                }
            }

        //  כשמתחיל במינוס וB=1
    else if (yourEquation.charAt(0)=='-' && yourEquation.charAt(6)=='x'){
        if (yourEquation.charAt(2) =='x' && yourEquation.charAt(3)=='^' && yourEquation.charAt(4)=='2' && (yourEquation.charAt(5) == '+' || yourEquation.charAt(5) == '-') &&  yourEquation.charAt(10) =='0'&& ( yourEquation.charAt(7) == '+' || yourEquation.charAt(7)=='-') && yourEquation.charAt(9)=='=' ) {
           correctCounter=1;
            for (int i = 0; i < allNumbers.length; i++) {
                if (yourEquation.charAt(1) == allNumbers[i]){
                    correctCounter++;
                }
                if (yourEquation.charAt(8) == allNumbers[i]){
                    correctCounter++;
                }
            }
            if (correctCounter == 3) {
                return true;
            }
        }
    }

     //    כאשר אין מקרים חריגים של מינוס בהתחלה או 1x
        else {
                if (yourEquation.charAt(1) == 'x' && yourEquation.charAt(2) == '^' && yourEquation.charAt(3) == '2' && (yourEquation.charAt(4) == '+' || yourEquation.charAt(4) == '-') && yourEquation.charAt(6) == 'x' && (yourEquation.charAt(7) == '+' || yourEquation.charAt(7) == '-') && yourEquation.charAt(9) == '=' && yourEquation.charAt(10) == '0') {
                    for (int i = 0; i < allNumbers.length; i++) {
                        if (yourEquation.charAt(0) == allNumbers[i]){
                            correctCounter++;
                        }
                        if (yourEquation.charAt(5) == allNumbers[i]){
                            correctCounter++;
                        }
                        if (yourEquation.charAt(8) == allNumbers[i]) {
                            correctCounter++;
                        }
                    }
                    if (correctCounter == 3) {
                        return true;
                    }
                }
            }
        System.out.println("The template you entered in the equation,does not match the requested template.");
        return properFormat;
    }

    //  פונקציה הפותרת מדפיסה את תוצאות המשוואה ריבועית
    public static void quadraticEquation(int a,int b,int c){
        int d=b*b-(4*a*c);
        double squareD=Math.sqrt(d);
        if (d<0){
            System.out.println("Math Error! there is no solution");
        }
        else if (d>0){
            System.out.println("your solution are:"+ "\n"+"1: "+ (-b+squareD)/(2*a) +"   - and -   2: " + (-b-squareD)/(2*a));
        }
        else {
            System.out.println("your solution is: "+ (-b)/(2*a));
        }
    }


    //  פונקציה המחלצת a b c מהסטרינג ומדפיסה את התשובה למישוואה הריבועית
    public static void yourLetters(String yourEquation) {
        if (formatTester(yourEquation)) {
            char[] arrayEquationLetters = new char[3];
            String stringFromArrayA = "";
            String stringFromArrayB = "";
            String stringFromArrayC = "";
            int askieTableHelp = '0';
            int a = 0;
            int b = 0;
            int c = 0;
            int arrayIndex = 0;
            for (int i = 0; arrayIndex < 2; i++) {
                //  מציאת מקדם a
                if (arrayIndex == 0) {
                    if (yourEquation.charAt(i) == 'x') {  //  במידה וa =1 בהתחלה
                        arrayEquationLetters[arrayIndex] = '1';
                        stringFromArrayA = stringFromArrayA + arrayEquationLetters[arrayIndex];
                        a = stringFromArrayA.charAt(0) - askieTableHelp;
                    } else if (yourEquation.charAt(i) == '-' && yourEquation.charAt(i + 1) == 'x') { //  a=-1
                        arrayEquationLetters[arrayIndex] = '1';
                        stringFromArrayA = stringFromArrayA + arrayEquationLetters[arrayIndex];
                        a = (stringFromArrayA.charAt(0) - askieTableHelp) * -1;
                        i++; //  על מנת שהi הבאה לא יתייחס לx של a
                    } else if (yourEquation.charAt(i) == '-' && yourEquation.charAt(i + 1) != 'x') { //  a= מינוס מספר ממשי
                        arrayEquationLetters[arrayIndex] = yourEquation.charAt(i + 1);
                        stringFromArrayA = stringFromArrayA + arrayEquationLetters[arrayIndex];
                        a = (stringFromArrayA.charAt(0) - askieTableHelp) * -1;
                        i = i + 2;      //  על מנת שהi הבאה לא יתייחס לx של a

                    } else {         // a = מספר טיבעי
                        arrayEquationLetters[arrayIndex] = yourEquation.charAt(i);
                        stringFromArrayA = stringFromArrayA + arrayEquationLetters[arrayIndex];
                        a = (stringFromArrayA.charAt(0) - askieTableHelp);
                        i++;   //  על מנת שהi הבאה לא יתייחס לx של a
                    }
                    arrayIndex++;
                } else {  //   נמצא את b (האינדקס הוא 2)
                    if (yourEquation.charAt(i) == 'x') {
                        if (yourEquation.charAt(i - 1) == '-') {  // כאשר b=-1
                            arrayEquationLetters[arrayIndex] = '1';
                            stringFromArrayB = stringFromArrayB + arrayEquationLetters[arrayIndex];
                            b = (stringFromArrayB.charAt(0) - askieTableHelp) * -1;

                        } else if (yourEquation.charAt(i - 1) == '+') {  // כאשר b=1
                            arrayEquationLetters[arrayIndex] = '1';
                            stringFromArrayB = stringFromArrayB + arrayEquationLetters[arrayIndex];
                            b = (stringFromArrayB.charAt(0) - askieTableHelp);

                        } else { // b = מספר ממשי
                            if (yourEquation.charAt(i - 2) == '-') {
                                arrayEquationLetters[arrayIndex] = yourEquation.charAt(i - 1);
                                stringFromArrayB = stringFromArrayB + arrayEquationLetters[arrayIndex];
                                b = (stringFromArrayB.charAt(0) - askieTableHelp) * -1;

                            } else {
                                arrayEquationLetters[arrayIndex] = yourEquation.charAt(i - 1);
                                stringFromArrayB = stringFromArrayB + arrayEquationLetters[arrayIndex];
                                b = (stringFromArrayB.charAt(0) - askieTableHelp);
                            }
                        }
                        arrayIndex++;
                    }
                }
            }

            // מציאת מקדם c
            if (yourEquation.charAt(yourEquation.length() - 4) == '-') { //   כאשר c הוא מינוס
                arrayEquationLetters[arrayIndex] = (yourEquation.charAt(yourEquation.length() - 3));
                stringFromArrayC = stringFromArrayC + arrayEquationLetters[arrayIndex];
                c = (stringFromArrayC.charAt(0) - askieTableHelp) * -1;
            }
            else {
                arrayEquationLetters[arrayIndex] = yourEquation.charAt(yourEquation.length() - 3);
                stringFromArrayC = stringFromArrayC + arrayEquationLetters[arrayIndex];
                c = (stringFromArrayC.charAt(0) - askieTableHelp);
            }

            System.out.println("a= " + a);
            System.out.println("b= " + b);
            System.out.println("c= " + c);

            quadraticEquation(a, b, c);
        }


    }
    public static void main(String[] args) {
       yourLetters("-x^2+8x+4=0");
    }
}

