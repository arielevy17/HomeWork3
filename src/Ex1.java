public class Ex1 {

    // פונקציה הבמחזירה אמת או שקר על האם מספר הוא מתחלף או לא
  public static boolean replacedNumber (int yourNumber){
      boolean didIsReplacedNumber=false;
      if (yourNumber<0){ //  וידוא שהמיספר חיובי
          System.out.println("your number must be a positive number! ");
          return false;
      }

      if ((yourNumber%10)%2==0){   //    בדיקה אם מתחיל ממספר זוגי באינדקס אי זוגי (ע"י האינדקס האחרון)
          for (int i=10,counter=1,j=1;((yourNumber%i)/j)>0;j=j*10,i=i*10,counter++){
            if (counter%2!=0){  //  בדיקה שבכל אינדקס אי זוגי יהיה מספר זוגי
              if ((((yourNumber%i)/j)%2)==0){
                  didIsReplacedNumber=true;
              }
              else {
                  System.out.println(false);
                  return false;
              }
            }
              if (counter%2==0){  // שבכל אינדקס זוגי יהיה מספר אי זוגי
                  if ((((yourNumber%i)/j)%2)!=0){
                      didIsReplacedNumber=true;
                  }
                  else {
                      System.out.println(false);
                      return false;
                  }

              }
          }
      }
      if ((yourNumber%10)%2!=0){ //   בדיקה אם מתחיל ממספר אי זוגי באינדקס אי זוגי (ע"י האינדקס האחרון)
          for (int i=10,counter=1,j=1;((yourNumber%i)/j)>0;i=i*10,j=j*10,counter++){
              if (counter%2!=0){  //בדיקה שבכל אינדקס אי זוגי יהיה מספר אי זוגי
                  if ((((yourNumber%i)/j)%2)!=0){
                      didIsReplacedNumber=true;
                  }
                  else {
                      System.out.println(false);
                      return false;
                  }
              }
              if (counter%2==0){  //שבכל אינדקס זוגי יהיה מספר זוגי
                  if ((((yourNumber%i)/j)%2)==0){
                      didIsReplacedNumber=true;
                  }
                  else {
                      System.out.println(false);
                      return false;
                  }

              }
          }
      }
      System.out.println(didIsReplacedNumber);
      return didIsReplacedNumber;
  }

  //   פונקציה המחזירה את האינדקס של המספר המתחלף הקטן ביותר

    public static int smallerReplacedIndex(int [] yourArrayNumber){
        int oldSumReplacedNumber=0;
      for (int i=0;i<yourArrayNumber.length;i++){  //   הצבה של המספר הגדול ביותר ב ככה תמיד סכום האיברים של מספר מתחלף יהיה קטן מהערך הראשון של oldSumReplacedNumber כי לא משנה איזה מספר יהיה oldSumReplacedNumber סכום האיברים קטן מערך המספר לדוגמא עם הספרות הגדולות ביותר(בתלת ספרתי): 999 ו 9+9+9=27
          if(yourArrayNumber[i]>oldSumReplacedNumber){
              oldSumReplacedNumber=yourArrayNumber[i];
          }
      }

      int howIsSmallerReplacedIndex =-1;
      int newSumReplacedNumber =0;
      for (int i=0;i<yourArrayNumber.length;i++) {
          if (replacedNumber(yourArrayNumber[i])) {
              for (int a = 10, j = 1; ((yourArrayNumber[i] % a) / j) > 0; j = j * 10, a = a * 10) {
                  newSumReplacedNumber = newSumReplacedNumber + (((yourArrayNumber[i]) % a) / j);
              }
              if (oldSumReplacedNumber > newSumReplacedNumber) {
                  howIsSmallerReplacedIndex = i;
                  System.out.println(howIsSmallerReplacedIndex);
                  oldSumReplacedNumber = newSumReplacedNumber;
              }
              newSumReplacedNumber = 0;
          }
      }
        System.out.println();
        System.out.println("the smaaler index in the array is: ["+howIsSmallerReplacedIndex+"]");
      return howIsSmallerReplacedIndex;
    }

    public static void main(String[] args) {
      int [] example={1234,234,200,98,2341,7,110,1211,123,98989};
    smallerReplacedIndex(example);

    }
}
