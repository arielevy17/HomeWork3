import java.util.Random;
import java.util.Scanner;

public class Ex9 {
    //  פונקציה הבודקת את ניחוש המשתמש:
    public static boolean checkingUserCode(int [] userGuess){
       boolean isUserCodeProper=false;
       int [] allPasswordCharOption={1,2,3,4,5,6};
       int counter=0;
       if (userGuess.length==4){  // אם אורך הסיסמה היא 4
           for (int i=0;i<userGuess.length;i++){ // אם המספרים הינם בין 1-6
               for (int j=0;j<allPasswordCharOption.length;j++){
                   if (userGuess[i]==allPasswordCharOption[j]){
                       counter++;
                       break;
                   }
               }
           }
           if (counter==4){
               return true;
           }
       }
       return isUserCodeProper;
    }

    //  מתודה הבודקת אם בניחוש כל מספר מופיע רק פעם אחת
public static boolean onlyOneTimeChar(int [] userGuess) {
    boolean isOnlyOneTimeChar = true;
    for (int i = 0; i < userGuess.length; i++) {
        for (int j=i+1;j<userGuess.length;j++){
           if (userGuess[i]==userGuess[j]){
               return false;
           }
        }
    }
    return isOnlyOneTimeChar;
}

//  מתודה שמחזירה כמה ניחושים מדויקים
public static int accurateGuesses(int [] randomPassword,int [] userPassword){   //    לשנות את counter למינהם למתודה הזו>0
int accurateGuessesCounter=0;
for (int i=0;i<randomPassword.length;i++){
        if (userPassword[i]==randomPassword[i]){
            accurateGuessesCounter++;
    }
}
return accurateGuessesCounter;
}

//  פונקציה שמחזירה כמה ניחושים חלקיים יש
public static int partialGuesses(int [] randomPassword, int [] userPassword){
        int helfGuessesCounter=0;
        for (int i=0; i<userPassword.length;i++){
            for (int j=0;j<randomPassword.length;j++){
                if (userPassword[i]==randomPassword[j] && i!=j){
                    helfGuessesCounter++;
                    break;
                }
            }
        }
        return helfGuessesCounter;
}

//   פונקצית המשחק עצמו
public static void passwordGuessingGame() {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    int[] lotteryCode = new int[4];
    System.out.println("Welcome to the guessing game.\n" +
     "Instructions: You must guess a 4-digit secret code.\n" +
     "The code contains digits between 1-6, and each number exists in the code only once.\n" +
      "The number of attempts depends on the degree of difficulty of your choice. When at the end of each turn we will remind you how many attempts you have left.\n" +
            "At the end of each turn you will know if your answer included accurate guesses (accurate guessing is - when you correctly guessed the organ and its position in the code),\n"+
            "Or partial (partial guess is - when you correctly guessed an organ that appears in the code but not in its correct position).\n"+
            "Highlights:\n" +
     "-Your guess should be a 4-digit code when each of the digits is between 1-6.\n" +
       "- You must enter each character only once. If you enter a character more than once, you will lose two attempts from the amount of attempts given to you, each time.\n" +
    "** If you choose the surprising route, you will not be told how many attempts are left after each turn.\n" +
      "\n" +
      "Good luck!!");
    System.out.println();
    for (int i = 0; i < lotteryCode.length; i++) { // בחירת קוד רנדומלי ע"י המערכת
        lotteryCode[i] = random.nextInt(7 - 1) + 1;
    }
    while (!onlyOneTimeChar(lotteryCode)) { // אם הוגרל מספר פעמיים יוגרל מספר חדש
        for (int i = 0; i < lotteryCode.length; i++) {
            lotteryCode[i] = random.nextInt(7 - 1) + 1;
        }
    }
    System.out.println("Here are different levels of difficulty:\n" +
            "Easy rank: 20 opportunities\n" +
            "Medium grade: 15 opportunities\n" +
            "Difficulty: 10 opportunities\n" +
            "Surprising track: The number of opportunities is drawn between the values 5-25.\n" +
            "\n" +
            "Please select the desired difficulty level:\n" +
            "For the easy route, press: 1\n" +
            "For the intermediate route, press: 2\n" +
            "For the hard track, press: 3\n" +
            "For the surprising route tap: 4");
    int difficultyLevel = scanner.nextInt();  //  הזנת דרגת קושי
    while (difficultyLevel < 1 || difficultyLevel > 4) {   //  וידוא שנבחרה דרגת קושי נכונה
        System.out.println("The difficulty level must be between 1-4");
        difficultyLevel = scanner.nextInt();
    }
    int numberOfGuessesLeft = 0;
    if (difficultyLevel == 1) {
        numberOfGuessesLeft = 20;
    } else if (difficultyLevel == 2) {
        numberOfGuessesLeft = 15;
    } else if (difficultyLevel == 3) {
        numberOfGuessesLeft = 10;
    } else if (difficultyLevel == 4) { //***** למה
        numberOfGuessesLeft = random.nextInt(26 - 5) + 5;
    }
    int[] userGuess = new int[4];
    for (int j = 0; j< lotteryCode.length; j++){
        System.out.print((lotteryCode[j])+"  ");
    }
    int a=0; // מספר הניסיונות
    while (numberOfGuessesLeft>0) {
        a++;
        System.out.println("Please enter your guess:");
        for (int i = 0; i < userGuess.length; i++) {   //  הזנת ניחוש מהמשתמש
            userGuess[i] = scanner.nextInt();
        }
        if (!onlyOneTimeChar(userGuess)) { // במידה והניחוש מכיל בתוכו את אותה ספרה יותר מפעם אחת
            numberOfGuessesLeft = numberOfGuessesLeft - 1;
            System.out.println("You entered the same number more then one time !!!\n" +
                    "Note, this mistake cost you two points!");
            while (!onlyOneTimeChar(userGuess)|| !checkingUserCode(userGuess)) {  //  במידה והניחוש מכיל בתוכו את אותה ספרה יותר מפעם אחת או קלט לא תקין
                System.out.println("Please enter a new guess:");
                for (int i = 0; i < userGuess.length; i++) {
                    userGuess[i] = scanner.nextInt();
                }
            }
        }
        int notOnlyOneTimeChar=0;
        while (!checkingUserCode(userGuess)|| !onlyOneTimeChar(userGuess)) {  //  במידה ויש יותר מ4 מספרים בניחוש או שהספרות לא בין 1-6
            System.out.println("Your guess is not like the instructions ,Please enter a new guess:");
            for (int i = 0; i < userGuess.length; i++) {
                userGuess[i] = scanner.nextInt();
            }
            if (!onlyOneTimeChar(userGuess)){ //  בדיקה אם כאשר ביקשנו להקליד שוב סיסמא הוקשו 2 תוים זהים ע"מ להוריד לו 2 ניחושים
                notOnlyOneTimeChar++;
            }
        }
        if (notOnlyOneTimeChar>0){
            System.out.println("You entered the same number more then one time !!!\n" +
                    "Note, this mistake cost you two points!");
            numberOfGuessesLeft=numberOfGuessesLeft-1;
        }
        if (accurateGuesses(lotteryCode,userGuess)==4){
            System.out.println("congratulations you have won !!!\n" +
                    "You guessed the right number after " + a + " guesses !!");
            break;
        }
        if (accurateGuesses(lotteryCode,userGuess)!=0){ //  כמה ניחושים מדוייקים היו
            System.out.println("Your guess included "+accurateGuesses(lotteryCode,userGuess)+" accurate guesses!");
        }
        if (partialGuesses(lotteryCode,userGuess)!=0){  // כמה ניחושים חלקיים היו
            System.out.println("Your guess included "+ partialGuesses(lotteryCode,userGuess)+" Partial guesses!");
        }
        numberOfGuessesLeft = numberOfGuessesLeft - 1;
        if (difficultyLevel != 4 && numberOfGuessesLeft>=0) { // במידה והמשתמש ניחש נכון
            System.out.println("You have " + numberOfGuessesLeft + "  guesses left");
        }
    }
    if (numberOfGuessesLeft<=0){
        System.out.println("unfortunately you lost!\n" +
                "The code you should have guessed is: ");
        //     פקודת הדפסת אברי המערך-ע"מ שניתן יהיה לראות שהערך המוחזר נכון
        for (int j = 0; j< lotteryCode.length; j++){
            System.out.print((lotteryCode[j])+"  ");
        }
    }
}


    public static void main(String[] args) {
        passwordGuessingGame();
    }
}
