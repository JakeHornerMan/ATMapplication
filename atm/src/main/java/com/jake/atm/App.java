package com.jake.atm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jake.factory.AtmFactory;
import com.jake.views.AtmView;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);
        AtmView view = AtmFactory.getAtmView();
        view.startMenu();
    }
}
