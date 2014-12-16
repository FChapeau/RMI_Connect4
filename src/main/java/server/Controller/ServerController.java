package server.Controller;

import client.Controller.IClientObserver;
import server.Model.Board;
import server.Model.Game;
import client.Controller.IClientObserver;
import net.sf.lipermi.exception.LipeRMIException;
import net.sf.lipermi.net.IServerListener;
import net.sf.lipermi.handler.CallHandler;
import net.sf.lipermi.net.Server;

import java.io.IOException;
import java.util.LinkedList;
import java.net.Socket;

public class ServerController extends Server implements IServerObserver{
    private LinkedList<IClientObserver> observers;
    private Game game;

    public ServerController()
    {
        this.observers = new LinkedList<IClientObserver>();
        game = new Game();
        CallHandler callHandler = new CallHandler();
        try
        {
            callHandler.registerGlobal(IServerObserver.class, this);
            this.addServerListener(new MyServerListener());
            this.bind(ServerPort, callHandler);
            System.out.println("Server listening...");

            while (true)
            {
                try
                {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }
        catch (LipeRMIException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }


    public void RegisterObserver(IClientObserver observer) {
            // TODO Auto-generated method stub
            this.observers.add(observer);
            observer.SetObserverID(this.observers.size());
            System.out.println("Client : " + Integer.toString(this.observers.size()) + " has connected");
    }

    public void Disconnect(int clientID)
        {
            int idToDelete = 0;
            boolean delete = false;
            for(IClientObserver observer : this.observers)
            {
                if(observer.GetObserverID() == clientID)
                {
                    System.out.println("Client : " + Integer.toString(observer.GetObserverID()) + " has disconnected");
                    delete = true;
                    idToDelete = clientID;

                }
            }
            if(delete == true)
            {
                this.observers.remove(idToDelete - 1);
                System.out.println("Client : " + Integer.toString(clientID) + " has disconnected");
            }

        }

    public void Play(int stack) {
        game.Play(stack);
        Update();
    }

    private void Update() {
        //foreach observer in observers
        //update visual info
        //...
        //...
        //...
        //.........
        //...
        //BITCHES!
    }

    public void GetCurrentGameState() {

    }

    private class MyServerListener implements IServerListener
    {

        public void clientConnected(Socket socket)
        {
            System.out.println("Client connected: " + socket.getInetAddress());
        }

        public void clientDisconnected(Socket socket)
        {
            System.out.println("Client disconnected: " + socket.getInetAddress());
            //FindTheDisconnectUser();

        }
    }
}
