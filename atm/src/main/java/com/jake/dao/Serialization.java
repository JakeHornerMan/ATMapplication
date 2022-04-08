package com.jake.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.List;

import com.jake.models.Account;

public class Serialization {
	
	List<Account> accounts;
	
	public Serialization(List<Account> accounts) {
		this.accounts = accounts;
	}

	public void serializeAccounts(List<Account> accounts) {
		try {
            OutputStream out = new FileOutputStream("AccountObjects");

            ObjectOutputStream obs = new ObjectOutputStream(out);

            obs.writeObject(accounts);
            
            System.out.println("Objects has been serialized");
            
            out.close();
            obs.close();
        }
        catch(FileNotFoundException e) {
            System.out.println("Object has not been serialized: " + e);
        }
        catch(IOException e){
            System.out.println("Object has not been serialized: " + e);
        }
	}
	
	public List<Account> deserializeAccounts(){
		
		try {
            InputStream in = new FileInputStream("AccountObjects");

            ObjectInputStream ois = new ObjectInputStream(in);

            accounts = (List) ois.readObject();

            for(Account account : accounts) {
            	account.toString();
            }
            System.out.println("Object has been deserialized!");
            
            in.close();
            ois.close();
        }
        catch(FileNotFoundException e) {
            System.out.println("Object has not been deserialized: " + e);
        }
        catch(IOException e){
            System.out.println("Object has not been deserialized: " + e);
        }
        catch(ClassNotFoundException e){
            System.out.println("Object has not been deserialized: " + e);
        }
		return accounts;
	}
}
