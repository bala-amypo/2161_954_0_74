package com.example.demo.entity;
public class Studententity{
    private int id;
    private String name;
    private String email;
    public studententity(){

    }
    public Studentity(int id,String name,String email){
        this.id=id;
        this.name=name;
        this.email=email;
    }
    public int geltd(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getname(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }
}