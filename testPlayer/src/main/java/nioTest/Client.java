package nioTest;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;

public class Client {

    private Selector selector;
    private final ByteBuffer sendBuffer = ByteBuffer.allocate(1024);
    private final ByteBuffer receiveBuffer = ByteBuffer.allocate(1024);
    private SocketChannel socketChannel;
    private Boolean serverFlag = true;
    private String username = "0HZH-02";
    public Client() throws IOException {
        this.selector = Selector.open();
        socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        socketChannel.register(this.selector, SelectionKey.OP_CONNECT);
        socketChannel.connect(new InetSocketAddress("localhost", 8080));
    }

    public void clientListen() throws IOException {
        while (this.serverFlag) {
            this.selector.select();
            Iterator<SelectionKey> iterator = this.selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                iterator.remove();
                if (key.isConnectable()) {
                    SocketChannel channel = (SocketChannel) key.channel();
                    if (channel.isConnectionPending()) {
                        channel.finishConnect();
                        System.out.println("完成连接");
                        this.serverFlag = true;
                    }
                    channel.configureBlocking(false);
                    channel.register(selector, SelectionKey.OP_READ);
                }if (key.isReadable()) {
                    SocketChannel channel = (SocketChannel) key.channel();
                    int length = 0;
                    try {
                        length = channel.read(this.receiveBuffer);
                    } catch (IOException e) {
                        System.out.println("服务器关闭");
                        this.serverFlag = false;
                        channel.close();
                        key.cancel();
                    }
                    if (length > 0) {
                        System.out.println(new String(this.receiveBuffer.array(),0,length));
                    }
                    this.receiveBuffer.clear();
                }

            }
        }
    }

    public void sendMessage() {
        Scanner scanner = new Scanner(System.in);
        while (this.serverFlag) {
            String message = scanner.nextLine();
            message = username +":" + message;
            this.sendBuffer.clear();
            this.sendBuffer.put(message.getBytes());
            this.sendBuffer.limit(message.getBytes().length);
            this.sendBuffer.flip();
            try {
                this.socketChannel.write(sendBuffer);
            } catch (IOException e) {
                System.out.println("服务器已关闭");
            }
            this.sendBuffer.clear();

        }


    }


    public static void main(String[] args) throws IOException {
        Client client = new Client();
        new Thread(client::sendMessage).start();
        client.clientListen();

    }
}
