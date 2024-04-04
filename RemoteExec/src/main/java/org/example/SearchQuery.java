package org.example;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class SearchQuery extends UnicastRemoteObject implements  Search {
    SearchQuery() throws RemoteException {
        super();
    }

    public String query(String search)
            throws RemoteException
    {
        String result;
        if (search.equals("Reflection in Java"))
            result = "Found Bitches";
        else
            result = "Not Found";

        return result;
    }
}
