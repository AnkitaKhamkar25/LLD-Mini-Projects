package Models;

public class MenuItem {
    private String code;
    private String name;
    private int price;
    public MenuItem(String code,String name,int price){
        this.code=code;
        this.name=name;
        this.price=price;
    }
    public  String getCode(){
        return code;
    }
    public String getName(){
        return name;
    }
    public int getPrice(){
        return price;
    }
   public void setCode(String c){
        code=c;
    }
   public void setName(String n){
        name=n;
    }
    public void setPrice(int p){
       price=p;
    }

}