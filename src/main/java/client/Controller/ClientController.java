package client.Controller;

import net.sf.lipermi.handler.CallHandler;
import net.sf.lipermi.net.Client;

import java.io.IOException;

/**
 * Created by boivi_000 on 2014-12-13.
 */
public class ClientController extends Client implements IClientObserver {
    public ClientController(String address, int port, CallHandler callHandler) throws IOException {
        super(address, port, callHandler);
    }

    public void SetObserverID(int size) {

    }

    public int GetObserverID() {
        return 0;
    }
}
