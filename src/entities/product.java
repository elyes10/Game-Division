/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author LENOVO
 */
public class product {
    private int Product_id;
    private String Product_name;
    private int Team_id;
    private double price;
    private String Category;
    private int Quantity;
    public product(String n,double p,int t,String c,int q)
    {
        
        this.Product_name=n;
        this.Team_id=t;
        this.price=p;
        this.Category=c;
        this.Quantity=q;
    }

   
    public int getid()
    {
        return this.Product_id;
    }
    public String getname()
    {
        return this.Product_name;
    }
    public int getteamid()
    {
        return this.Team_id;
    }
    public double get$()
    {
        return this.price;
    }
    public String getcatg()
    {
        return this.Category;
    }
    public int getquantity()
    {
        return this.Quantity;
    }
   
    public void setname(String n)
    {
        this.Product_name=n;
    }
    public void setteamid(int tm)
    {
        this.Team_id=tm;
    }
    public void set$(double $)
    {
        this.price=$;
    }
    public void setcatg(String c)
    {
        this.Category=c;
    }
    public void setquantity(int q)
    {
         this.Quantity=q;
    }
    public String toString()
    {
        return this.Product_name+'-'+this.Quantity+'-'+this.Team_id+'-'+this.price+'-'+this.Category+'\n';
    }
}
