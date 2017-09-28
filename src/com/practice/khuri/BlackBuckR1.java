package com.practice.khuri;

/**
 * Created by Nikhilesh.Soni on 27-09-2017.
 */
public class BlackBuckR1 {
    public static void main(String[] args) {
        int mat[][] =new int[][]{{ 0, 0, 0, 0, 0, 1, 1, 1, 1},{0,0,0,0,0,0,1,1},{
                0, 0, 0, 1, 1, 1, 1, 1, 1},
        {0, 0, 0, 0, 0, 0, 0, 0, 1}};
        BlackBuckR1 t = new BlackBuckR1();
        t.rowIndex(mat);
        System.out.println(rowN);
    }

     static int rowN=0;
    public int rowIndex(int [][]mat){
        returnMid(mat,0,0,mat[0].length);
        return rowN;
    }

    public int rowNum(int row, int[][]mat,int mid){
        for(int i=row;i<mat.length;i++){
            if(mat[i][mid]==0)
            return i;
        }
        return row;
    }

    private void returnMid(int[][] mat, int row,int start,int end){
        int[] r = mat[row];
        if(start==end){
            rowN= row;
            return;
        }
        if(end-start==1){
            if(r[end]==0){
                rowN=row;
            } else{
                rowN=rowNum(row,mat,end);
            }
            return;
        }
        //some processing

    // int start=0, end=r.length;
    int mid=(start+end)/2;
    if(r[mid]==0){
        //someprocessing
        mid = (mid+end)/2;
        returnMid(mat,row,mid,end);
    } else{
        // other processing
        row=rowNum(row,mat,mid);
        returnMid(mat,row,start,mid);
        mid=(start+mid)/2;
    }
}
}
