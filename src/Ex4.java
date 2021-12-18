public class Ex4 {

    // פונקציה שבודקת האם מערך הוא מערך מלא
public static boolean messyFullArray(int [] yourArray){
    boolean isItFullArray=false;
    int lowestNumber=yourArray[0];
    for (int i=0;i<yourArray.length;i++){
        if(yourArray[i]<lowestNumber){ // מציאת המספר המינימלי
            lowestNumber=yourArray[i];
        }
        for (int j=i+1;j<yourArray.length;j++){ // בדיקה שהמספר מופיעה רק פעם אחת
            if(yourArray[i]==yourArray[j]){
                System.out.println("false");
                return false;
            }
        }
    }
    int fullArrayCounter=1;
    for (int i=0;i<yourArray.length;i++){ // בדיקה האם קיים איבר הגדול ב1 מהאיבר הנ"ל
        if (lowestNumber+1==yourArray[i]){
            fullArrayCounter++;
            lowestNumber=lowestNumber+1;
            i=-1;
        }
    }
    if (fullArrayCounter==yourArray.length){
        isItFullArray=true;
    }
    System.out.println(isItFullArray);
    return isItFullArray;
  }

  // פונקציה הבודקת האם מערך הוא מלא למערך מסודר בסדר יורד ושיש בו כל איבר פעם אחת
 public static  boolean arrangedFullArray(int [] yourArray){
     boolean isItArrangedFullArray=true;
     for (int i=0;i<yourArray.length-1;i++){
         if (yourArray[i]-1 != yourArray[i+1]){
             System.out.println("false");
             return false;
         }
     }
     System.out.println("true");
    return isItArrangedFullArray;
 }

    public static void main(String[] args) {
        int [] example1 = {10,8,5,3,2,1,4,6,7,9};
        int [] example2= {35,34,33,32,31,30,29};
        messyFullArray(example1);
        arrangedFullArray(example2);
    }

}
