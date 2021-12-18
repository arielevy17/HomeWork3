public class Ex5 {

    // פונקציה שמחזירה את התו הכי נפוץ
public static char mostCommonChar(String yourWord){
   char whichCharMostCommon =' ';
   int leastCounter=0;
   int newCounter=0;
   for (int i=0;i<yourWord.length();i++) {
       for (int j = 0; j < yourWord.length(); j++) {
           if (yourWord.charAt(i) ==yourWord.charAt(j)){
               newCounter++;
           }

       }
       if (newCounter>leastCounter){
           whichCharMostCommon =yourWord.charAt(i);
       }
       leastCounter=newCounter;
       newCounter=0;
   }

    return whichCharMostCommon;
}

// פונקציה שמחזירה את התו השני הכי נפוץ
    public static char secondCommonChar (String yourWord){
        int newCounter=0;
        int secondBiggerCounter =0;
        int firstBiggerCounter =0;
        char whichCharSecondCommon =' ';
        int firsBiggerCounterIndex;
        int secondBiggerCounterIndex =0;
        for (int i=0;i<yourWord.length();i++) {
            for (int j = 0; j < yourWord.length(); j++) {
                if (yourWord.charAt(i) ==yourWord.charAt(j)){
                    newCounter++;
                }

            }
            if (newCounter > firstBiggerCounter) {
                firsBiggerCounterIndex =i;
                secondBiggerCounter = firstBiggerCounter;
                firstBiggerCounter = newCounter;
                whichCharSecondCommon =yourWord.charAt(secondBiggerCounterIndex);
                secondBiggerCounterIndex = firsBiggerCounterIndex;
            }
            else if(newCounter > secondBiggerCounter && newCounter != firstBiggerCounter){
                secondBiggerCounter =newCounter;
                whichCharSecondCommon =yourWord.charAt(i);
            }
            newCounter=0;
        }

        return whichCharSecondCommon;
    }

    // פונקציה שמחליפה את המספר הכי נפוץ במספר השני הכי נפוץ
 public static String replaceFirstCommonInSecond(String yourWord){
    String wordWhitChangeFirstCommonInSecond="";
    for (int i=0;i<yourWord.length();i++){
        if (yourWord.charAt(i)==mostCommonChar(yourWord)){
            wordWhitChangeFirstCommonInSecond=wordWhitChangeFirstCommonInSecond+secondCommonChar(yourWord);
        }
        else {
            wordWhitChangeFirstCommonInSecond=wordWhitChangeFirstCommonInSecond+yourWord.charAt(i);
        }
    }
     System.out.println(wordWhitChangeFirstCommonInSecond);
    return wordWhitChangeFirstCommonInSecond;
 }

    public static void main(String[] args) {
        replaceFirstCommonInSecond("Unbelievable");
    }
}
