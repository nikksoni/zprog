package com.btree;

/**
 * Created by Nikhilesh.Soni on 22-09-2017.
 */

public class DivisionToElipson {

    public static void main(String[] args){
        int epsilon = 3;

        double d1 = 2.223456;
        double d2 = 2.1;

        System.out.println(d1/d2);
        DoubleWithEpsilon doubleWithEpsilon = new DoubleWithEpsilon(epsilon);

        DoubleWithEpsilon result = doubleWithEpsilon.divid(d1, d2);

        System.out.println(result);

    }

}

class DoubleWithEpsilon{
    int epsilon;
    int whole;
    int fraction;

    public DoubleWithEpsilon(int epsilon){
        this.epsilon = epsilon;
    }

    public DoubleWithEpsilon(int epsilon, double doubleNumber){
        this.epsilon = epsilon;
        if(doubleNumber<1){
            this.whole=0;
        }else{
            this.whole = (int) doubleNumber;
        }

        int powerE=1;
        for(int i=0; i<epsilon; i++){
            powerE = powerE*10;
        }
        int powerE1 = powerE*10;

        double tempDouble = doubleNumber-this.whole; //get the fraction from double.

        int tempInt0 = (int)(tempDouble*powerE);  //get the fist epsilon digits from fraction.
        int tempInt1 = (int)(tempDouble*powerE1); // get the fist epsilon+1 digits from fraction.
        int tempInt = tempInt1-tempInt0*10;       //get last digit of tempInt1.

        if(tempInt<5){                            //Round fraction of original double based on tempInt
            this.fraction = tempInt0;
        }else{
            this.fraction = tempInt0+1;
        }

        if(this.fraction>=powerE){
            this.fraction = 0;
            this.whole = this.whole+1;
        }
    }

    public DoubleWithEpsilon divid(double d1, double d2){

        DoubleWithEpsilon doubleWithEpsilon = new DoubleWithEpsilon(this.epsilon, d1/d2);

        return doubleWithEpsilon;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(this.whole).append(".");
        if(this.fraction<10){
            sb.append("00").append(this.fraction);
        }else if(this.fraction<100){
            sb.append("0").append(this.fraction);
        }else{
            sb.append(this.fraction);
        }

        return sb.toString();
    }


}