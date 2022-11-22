package nioTest;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Server {

    private Selector selector;
    private final ByteBuffer sendBuffer = ByteBuffer.allocate(1024);
    private final ByteBuffer receiveBuffer = ByteBuffer.allocate(1024);
    private SelectionKey selectionKey;
    private ConcurrentMap<SocketChannel, Boolean> map = new ConcurrentHashMap<>(10);
    public Server(int port) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(port));
        serverSocketChannel.configureBlocking(false);
        selector = Selector.open();
        selectionKey = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
    }

    public void listen() throws IOException {
        while (true) {
            this.selector.select();
            Set<SelectionKey> selectionKeys = this.selector.selectedKeys();
            Iterator<SelectionKey> iteratorKeys = selectionKeys.iterator();
            while (iteratorKeys.hasNext()) {
                SelectionKey key = iteratorKeys.next();
                iteratorKeys.remove();
                if (key.isAcceptable()) {
                    ServerSocketChannel channel = (ServerSocketChannel) key.channel();
                    SocketChannel accept = channel.accept();
                    accept.configureBlocking(false);
                    accept.register(this.selector, SelectionKey.OP_READ);
                    System.out.println("客户端连接");
                    this.map.put(accept, true);
                }else if (key.isReadable()) {
                    SocketChannel channel = (SocketChannel) key.channel();
                    int length = 0;
                    try {
                        length = channel.read(this.receiveBuffer);
                    } catch (IOException e) {
                        System.out.println("断开连接");
                        this.map.remove(channel);
                        channel.close();
                        key.cancel();
                    }
                    if (length > 0) {
                        System.out.println(new String(this.receiveBuffer.array(),0,length));
                    }
                    this.sendMessage(new String(this.receiveBuffer.array(),0,length));
                    this.receiveBuffer.clear();
                }
            }
        }
    }

    public void sendMessage(String message){
        this.map.forEach((key,value)->{
                this.sendBuffer.put(message.getBytes());
                this.sendBuffer.limit(message.getBytes().length);
                this.sendBuffer.flip();
                try {
                    key.write(this.sendBuffer);
                } catch (IOException e) {

                    e.printStackTrace();
                }
                this.sendBuffer.clear();
        });
    }

    public void activeSendMessage() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("等待写入");
            String message = scanner.nextLine();
            this.sendMessage(message);
        }
    }


    public static void main(String[] args) {
        try {
            Server server = new Server(8080);
            new Thread(server::activeSendMessage).start();
            server.listen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
