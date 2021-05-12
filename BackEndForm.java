/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BoxLayout;
import com.services.PrdServices;

/**
 *
 * @author LENOVO
 */
public class BackEndForm  extends Form{
    Form Current;
    public BackEndForm()
    {
        Current=this;
        setTitle("<<-Welcome->>");
        setLayout(BoxLayout.y());
        Button b=new Button("Add Merchendise");
        add(b);
        Button b1=new Button("Delete Merchendise");
        add(b1);
        Button b2=new Button("Update Merchendise");
        add(b2);
        Button b3=new Button("view Merch");
        add(b3);
        PrdServices P=new PrdServices();
        b3.addActionListener(e -> new ListForm(Current));
        b.addActionListener(e -> new AddForm(Current).show());
        b1.addActionListener(e->new DeleteForm(Current).show() );
        b2.addActionListener(e->new EditForm(Current).show() );
    }
    
}
