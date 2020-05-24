package lambda.grammer;

import org.junit.Test;

public class FunctionParams {

    /**
     * 使用 function 转大写
     */
    @Test
    public void testFunctionParams(){
        String originalStr = "hello world";
        //转大写
        String toUpperStr = stringHandler(originalStr, (str)-> str.toUpperCase());
        System.out.println(toUpperStr);

        //截取
        String cutStr = stringHandler(originalStr, (str)-> str.substring(1,2));
        System.out.println(cutStr) ;
    }

    public String stringHandler(String str, MyStringFunction stringFunction){
        return stringFunction.changeString(str);
    }
}
