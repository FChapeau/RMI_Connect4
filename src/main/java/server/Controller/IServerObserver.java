package server.Controller;

import client.Controller.IClientObserver;

/**
 * Created by boivi_000 on 2014-12-13.
 */
public interface IServerObserver {
    int ServerPort = 12398;

    void RegisterObserver(IClientObserver observer);

    void Disconnect(int clientId);

    void Play(int stack);

    void GetCurrentGameState();


}
