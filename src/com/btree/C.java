package com.btree;

/**
 * Created by Nikhilesh.Soni on 13-08-2017.
 */
public  class C  {
    private final int a;

    public C() {
        a=1;
    }

    public String printB(int a) {
//        super.printB();
        return null;
    }

//    @Override
    public void printBB() {
     /*   C.this.printB();
         int sa=10;
        Runnable ga=new Runnable(){

            @Override
            public void run() {
                System.out.println(a);
                System.out.println(sa);
            }
        };
        System.out.println(a);
        System.out.println("CC");
        System.out.println("CC"+Thread.currentThread().getName());*/
        // super.printBB();
        System.out.println("CC");
        C.this.printBB();
    }

    public static void main(String[] args) {
        C c = new C(){};
//        c.printB();
    }
}
