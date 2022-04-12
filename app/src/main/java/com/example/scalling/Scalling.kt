package com.example.scalling

class Scalling {

    public fun ScallingFun(mainNum:Float,nOneMin: Float, nTwoMax: Float, sOneMin: Float, sTwoMax:Float): Float{
        var result = 0.0f
        var temp = 0.0f;
        temp=((sTwoMax-sOneMin)/(nTwoMax-nOneMin));
        result=(mainNum-nOneMin)*temp+sOneMin;
        if(result>sTwoMax){
            result=sTwoMax
        }
        return result
    }
}