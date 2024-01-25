import java.util.Scanner;

public class Greetings {
    String inputName = "";
    String greeting = "Hello ";
    String shouting = " AND HELLO ";

    String[] shouts;
    String[] greetings;

    Greetings(){
        handleInput();
        greetingGenerator();
        System.out.println(shouting);
        System.out.println(greeting+shouting);

    }

    public void handleInput(){
        Scanner scn = new Scanner(System.in);
        inputName = scn.nextLine();
    }

    public void printGreeting(String userInput, boolean isLast){
        if(!isLast) greeting += userInput +", ";
        else greeting += userInput;
    }

    public void lastName(String input, boolean isShout){
        if(isShout) shouting+="and ";
        else greeting += "and ";
    }
    public boolean allUppercase(String input) {
        return input.equals(input.toUpperCase());
    }


    public void greetingGenerator(){

        if(inputName.equals("")){
            greeting = "Hello, my friend";
            return;
        }

        if(inputName.charAt(0)!='['){
            if(allUppercase(inputName)) {checkShout(inputName,true,1); return;}
            printGreeting(inputName,true);
            return;
        }

        if(inputName.charAt(inputName.length()-1)!=']'){ System.out.println("It seems you entered something wrong"); return;}

        inputName = inputName.substring(1,inputName.length()-1);

        String[] inputElements = inputName.split("\",\\s\"");

        inputElements[0] = inputElements[0].substring(1);

        inputElements[inputElements.length-1] = inputElements[inputElements.length-1].substring(0,inputElements[inputElements.length-1].length()-1);

        boolean isLast = false;

        for(int i=0;i<inputElements.length;i++){

            String[] newS = inputElements[i].split(",\\s");


                for (String s : newS){
                    System.out.println("\n this is s string:"+s);
                }


//            if(i==inputElements.length-1){
//                lastName(inputElements[i],allUppercase(inputElements[i]));
//                isLast = true;
//            }
//
            System.out.println("test: "+inputElements[i]);
//
//           if(allUppercase(inputElements[i])) checkShout(inputElements[i],isLast);
//           else printGreeting(inputElements[i],isLast);
        }


    }

    public void checkShout(String inputGreeting, boolean isLast, int option){
        System.out.println("this is inside checkshout"+inputGreeting);

        if(!isLast) shouting += inputGreeting+", ";
        else shouting += inputGreeting;
    }


}
