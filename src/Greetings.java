import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Greetings {
    String inputName;
    String greeting;
    String shouting;

    int triesCounter = 0;

    ArrayList<String> shouts;
    ArrayList<String> greetings;

    Greetings(){
        programController();
    }

    public void programController(){
        int testCases = 1;
        Scanner scn = new Scanner(System.in);
        try {
            System.out.println("Please enter number of test cases");
            testCases = scn.nextInt();
        }
        catch (InputMismatchException e){
            if(triesCounter==10){ System.out.println("Aborting Now..."); System.exit(0);}
            System.out.println("Please enter a numeric number of Test Cases, program will abort after "+(10-triesCounter)+" tries");
            triesCounter++;
            programController();
        }
        while(testCases>0){
            testCases--;
            reset();
            handleInput();
            greetingGenerator();
            createGreeting();
            createShout();
            System.out.println(greeting);
            if(shouts.size()!=0) System.out.println(" AND "+shouting);
            System.out.println("----------------");
        }
    }

    public void reset(){
        greetings = new ArrayList<>();
        shouts = new ArrayList<>();
        shouting = "";
        greeting = "";
        inputName = "";
    }

    public void createGreeting(){
        if(greetings.size()<=0) return;
        greeting = "Hello";
        for(int i=0;i<greetings.size();i++){
            if(i==0){
                greeting += " " + greetings.get(i);
                continue;
            }
            if(i==greetings.size()-1 && greetings.size()>1){
                greeting += ", and " + greetings.get(i);
                continue;
            }
            greeting += ", "+greetings.get(i);
        }
        greeting += ".";
    }

    public void createShout(){
        if(shouts.size()<=0) return;
        shouting = "HELLO";
        for(int i=0;i<shouts.size();i++){
            if(i==0){
                shouting += " "+shouts.get(i);
                continue;
            }
            if(i==shouts.size()-1 && shouts.size()>1){
                shouting += ", AND "+shouts.get(i);
                continue;
            }
            shouting += "," + shouts.get(i);
        }
    }

    public void handleInput(){
        Scanner scn = new Scanner(System.in);
            System.out.println("Please enter your input");
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
            greetings.add("my friend");
            greeting = "Hello, my friend";
            return;
        }

        if(inputName.charAt(0)!='['){
            if(allUppercase(inputName)) {shouts.add(inputName); return;}
            greetings.add(inputName);
            return;
        }

        if(inputName.charAt(inputName.length()-1)!=']'){ System.out.println("It seems you entered something wrong"); return;}

        inputName = inputName.substring(1,inputName.length()-1);

        String[] inputElements = inputName.split("\",\\s*\"");

        inputElements[0] = inputElements[0].substring(1);

        inputElements[inputElements.length-1] = inputElements[inputElements.length-1].substring(0,inputElements[inputElements.length-1].length()-1);


        for(int i=0;i<inputElements.length;i++){

            if(inputElements[i].contains("\\\"")){
                inputElements[i] = inputElements[i].substring(2,inputElements[i].length()-2);
                greetings.add(inputElements[i]);
                continue;
            }

//            System.out.println("test: "+inputElements[i]);

            String[] newS = inputElements[i].split(",\\s*");

            if(newS.length>1){
                    for(int j=0;j<newS.length;j++){
                        if(allUppercase(newS[j])){
                            shouts.add(newS[j]);
                        }
                        else{
                            greetings.add(newS[j]);
                        }
                    }
                continue;
            }

            if(allUppercase(inputElements[i])){
                shouts.add(inputElements[i]);
            }
            else{
                greetings.add(inputElements[i]);
            }

        }

    }

}
