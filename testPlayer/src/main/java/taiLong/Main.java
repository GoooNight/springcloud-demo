package taiLong;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static class Thing{
        public String name;
        public Integer strength;
        public boolean isAlive;

        public Thing(String name, Integer strength) {
            this.name = name;
            this.strength = strength;
            this.isAlive = true;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        List<Thing> things = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            things.add(new Thing(in.next(), in.nextInt()));
        }
        // 处理输入
        for (int i = 0; i < m; i++) {
            int a = in.nextInt()-1;
            int b = in.nextInt()-1;
            String a1 = in.next();
            String b1 = in.next();
            if (!things.get(a).isAlive || !things.get(b).isAlive){
                in.nextLine();
                continue;
            }
            if ("human".equals(things.get(a).name) && "monster".equals(things.get(b).name)){
                if("N".equals(a1) && "Y".equals(b1)){
                    if(things.get(a).strength > things.get(b).strength){
                        things.get(b).isAlive = false;
                    }
                }else if("Y".equals(a1)){
                    if(things.get(a).strength > things.get(b).strength){
                        things.get(b).isAlive = false;
                    }
                    else if(things.get(a).strength.equals(things.get(b).strength)){
                        things.get(b).isAlive = false;
                        things.get(a).isAlive = false;
                    }else {
                        things.get(a).isAlive = false;
                    }
                }
            }
            if ("monster".equals(things.get(a).name) && "human".equals(things.get(b).name)){
                if("Y".equals(a1) && "N".equals(b1)){
                    if(things.get(b).strength > things.get(a).strength){
                        things.get(a).isAlive = false;
                    }
                }else if("Y".equals(b1)){
                    if(things.get(b).strength > things.get(a).strength){
                        things.get(a).isAlive = false;
                    }
                    else if(things.get(a).strength.equals(things.get(b).strength)){
                        things.get(b).isAlive = false;
                        things.get(a).isAlive = false;
                    }else {
                        things.get(b).isAlive = false;
                    }
                }
            }
        }
        for (Thing thing : things) {
            System.out.print(thing.isAlive? "Y" : "N");
        }
        in.close();
    }
}
