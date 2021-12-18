public class Ex3 {
    // פונקציה המחזירה פירוק לגורמים
    public static int [] factorization(int yourNumber){
        int indexArrayNumber=0;
        int [] largestIndexesArray=new int[yourNumber]; //  הגודל של האיברים הראשונים לא יוכל להיות אף פעם כמו גודל המספר עצמו. כי המספר הראשוני המינימלי שכפולותיו יוצרות מספר הוא 2.
        for (int i=2;i<=yourNumber;i++){
          if (yourNumber%i==0 && yourNumber>0){ // המספר מתחלק בI שהוא הראשוני הקטן ביותר
              largestIndexesArray[indexArrayNumber]=i; // האיבר הראשון במשתנה העזר שווה לI
              indexArrayNumber++;
              yourNumber=yourNumber/i; // המספר החדש שיבדק הוא המספר שנותר מהחלוקה במספר הראשוני שנמצא
              i=1; //  תתחיל לבדוק את הראשונים מהקטן ביותר (2)
          }
        }
        int [] arrayFactors = new int[indexArrayNumber]; // גודל המערך החדש
            for (int i = 0; i < indexArrayNumber; i++) { // השמת האינדקסים מאוישים במערך הניסויני במערך החדש
                arrayFactors[i] = largestIndexesArray[i];
            }
//     פקודת הדפסת אברי המערך-ע"מ שניתן יהיה לראות שהערך המוחזר נכון
        for (int j = 0; j< arrayFactors.length; j++){
            System.out.print((arrayFactors[j])+"  ");
        }
        System.out.println();
        return arrayFactors;
    }

    public static void main(String[] args) {
        factorization(1000000);
    }
}
