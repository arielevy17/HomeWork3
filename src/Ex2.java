public class Ex2 {
    // פונקציה שמחזירה סכום מספרים
    public  static int sumOfDigits(int aNumber){
       int resultSumOfDigits =0;
        for (int i=10,j=1;((aNumber%i)/j)>0;i=i*10,j=j*10) {
            resultSumOfDigits = resultSumOfDigits + ((aNumber % i) / j);
        }
        return resultSumOfDigits;
    }



    // פונקציה שבודקת מהו האינדקס של איבר במערך שבו רמת הקירבה לאברי מערך השני היא הגבוה ביותר

    public static int biggerProximityLevel(int [] arr1, int [] arr2){
        int indexOfBiggerProximityLevel =0;
        int brotherCounter=0;
        int newBrotherCounter=0;
    for (int i=0;i<arr1.length;i++){  // לולאה שמחזירה את רמת הקירבה
        for (int j=0; j< arr2.length;j++){
            if (sumOfDigits(arr1[i]) == sumOfDigits(arr2[j])){
                newBrotherCounter++;
            }
        }

        if (newBrotherCounter>brotherCounter){ //  בדיקה האם האיבר ברמת קירבה גדולה יותר מהקודם ובמידה וכן מזין את האינקס כאינדקס עם  רמת הקירבה הגדולה ביותר
            indexOfBiggerProximityLevel =i;
            brotherCounter=newBrotherCounter;
        }

        newBrotherCounter=0;
    }
        System.out.println("the index of bigger proximity level is: ");
        return indexOfBiggerProximityLevel;
    }

    public static void main(String[] args) {
        int [] arr1={65,811,9,2,66,9};
        int [] arr2={335,12,11,333,2,444,93,156};
        System.out.println(biggerProximityLevel(arr1,arr2));
    }
}
