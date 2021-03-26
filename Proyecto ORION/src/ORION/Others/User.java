package ORION.Others;

import java.util.List;

public class User {
    private String name, CURP, password;
    private int age;
    private double height, weigth, imc;
    private List<Sick> sicks;

    public User(String name, String CURP, String password, int age, double height, double weigth, List<Sick> sicks) {
        this.name = name;
        this.CURP = CURP;
        this.password = password;
        this.age = age;
        this.height = height;
        this.weigth = weigth;
        this.sicks = sicks;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getCURP() {
        return CURP;
    }
    public void setCURP(String CURP) {
        this.CURP = CURP;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeigth() {
        return weigth;
    }
    public void setWeigth(double weigth) {
        this.weigth = weigth;
    }

    public List<Sick> getSicks() {
        return sicks;
    }
    public void setSicks(List<Sick> sicks) {
        this.sicks = sicks;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void imcCalculate(){
        this.imc = getWeigth()/(Math.pow(getHeight(),2));
    }
    public double getImc(){
        return imc;
    }
}
