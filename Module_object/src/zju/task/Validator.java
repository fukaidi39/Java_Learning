package zju.task;

/**
 * @Autor:godfu
 * @Date:2021/11/22-10:34
 */
class Validator {
    private Validator(){}
    public static boolean isEmail(String email){
        //判断email对象为空或者内容为空
        if(email == null || "".equals(email)){
            return false;
        }
        //定义正则表达式
        String regex = "\\w+@\\w+\\.\\w+(\\.cn)?";
        if(email.matches(regex)){
            return true;
        }else{
            return false;
        }
    }
    public static boolean isIp(String Ip){
        //判断IP内容为空
        if(Ip == null || "".equals(Ip)){
            return false;
        }
        String regex = "([12]?[0-9]?[0-9]\\.){3}[12]?[0-9]?[0-9]";
        if(Ip.matches(regex)){
            //Ip分隔后小于256
            String data[] = Ip.split("\\.");
            for (int x = 0; x < data.length ; x++) {
                if (Integer.parseInt(data[x]) > 255){
                    return false;
                }
            }
            return true;
        }else{
            return false;
        }
    }
}
