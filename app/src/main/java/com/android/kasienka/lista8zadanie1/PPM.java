package com.android.kasienka.lista8zadanie1;

public class PPM {


    public double BHmethod(double mass, double height, double age, String choiceGender){
        double result;
        if(choiceGender.equals("kobieta")){
            result=655.1+(9.563*mass)+(1.85*height)-(4.676*age);
        } else {
            result=66.5+(13.75*mass)+(5.003*height)-(6.775*age);
        }
        return result;
    }

    public double Mmethod(double mass, double height, double age, String choiceGender){
        double result;
        if(choiceGender.equals("kobieta")){
            result=(10*mass)+(6.25*height)-(5*age)-161;
        } else{
            result=(10*mass)+(6.25*height)-(5*age)+5;
        }
        return result;
    }

}
