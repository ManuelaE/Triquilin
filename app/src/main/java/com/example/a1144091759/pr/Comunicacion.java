package com.example.a1144091759.pr;

import android.util.Log;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

class Comunicacion extends Thread{

    private DatagramSocket socket;
    OnMessage observer;

    public Comunicacion(){
        try {
            socket = new DatagramSocket(6000);
            Log.e("lsdkflds", String.valueOf(socket));

        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while(true){
            recibir();
        }
    }

    public void recibir(){
        try {
            byte[] buf =  new byte[56];
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            Log.e("lsdkflds", String.valueOf(socket));
            socket.receive(packet);

            String mensaje = packet.getData().toString().trim();

            observer.recibido(mensaje);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void enviar (String dato) {

        try {

            byte[] buf = dato.getBytes();
            InetAddress a = InetAddress.getByName("10.0.2.2");
            int port = 5000;
            DatagramPacket p = new DatagramPacket(buf, buf.length, a, port);
            socket.send(p);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public interface OnMessage {

        public void recibido(String j);
    }

    public void setObserver(OnMessage mensajito) {

        this.observer = mensajito;
    }


}
