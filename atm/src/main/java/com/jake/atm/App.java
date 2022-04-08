package com.jake.atm;

import com.jake.factory.AtmFactory;
import com.jake.views.AtmView;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AtmView view = AtmFactory.getAtmView();
        view.startMenu();
    }
}
