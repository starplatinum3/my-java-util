
//import  com.atguigu.springboot.dao;

public class Employee {
    private Boolean is=false;

    public Boolean getIs() {
        return is;
    }
}

class TestEmployee{
    public static void main(String[] args) {
        System.out.println(new Employee().getIs());
    }
}
