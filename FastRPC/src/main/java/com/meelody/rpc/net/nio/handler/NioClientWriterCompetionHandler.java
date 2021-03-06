package main.java.com.meelody.rpc.net.nio.handler;

import main.java.com.meelody.rpc.net.nio.selector.NetSelector;

import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;


public class NioClientWriterCompetionHandler implements NioWriterCompletionHandler {
    NetSelector selector;

    public NetSelector getSelector() {
        return selector;
    }

    public void setSelector(NetSelector selector) {
        this.selector = selector;
    }

    public NioClientWriterCompetionHandler() {
    }

    public NioClientWriterCompetionHandler(NetSelector selector) {
        this.selector = selector;
    }

    @Override
    public void handle(SocketChannel socketChannel) throws ClosedChannelException, InterruptedException {
        selector.regist(socketChannel, SelectionKey.OP_READ,null);
    }
}
