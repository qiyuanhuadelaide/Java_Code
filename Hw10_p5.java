package main.im.qiyuanhu.homework;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName : CS526
 * @Description : Hw10 problem5
 * @Author : Qiyuan Hu
 * @Date : Dec 04 2021
 **/
/*
problem 5：
save and use following relationship in the graph. In social network, people follows others, the relationship could be shown as directed graph.
Note：
     1. Distinguish between direct adjacency and indirect adjacency, and store them in a set respectively (when a node belongs to direct adjacency and indirect adjacency, it is placed in the set of direct adjacency)
     2. read follows relationship from follows_input.txt
     3. store follows relationships in adjacency list， which must be implemented as an ArrayList of nodes
     4. create a method named allFollows
     5. create a main method to test allFollows
* */
public class Hw10_p5 {
    public static class Node {
        public String value;//data
        public ArrayList<String> nexts;//show which vertices could be reached from this vertex
        public Node(String value) {
            this.value = value;
            nexts = new ArrayList<>();
        }

    }
    public static ArrayList adjList(){//read the txt file and return the adjacency list
        ArrayList<Node> list=new ArrayList<>();
        try{
            InputStreamReader reader = new InputStreamReader(new FileInputStream("/Users/qiyuanhu/IdeaProjects/Hw2_p1/src/main/im/qiyuanhu/homework/follows_input.txt"),"gbk");
            BufferedReader br = new BufferedReader(reader);
            String s = null;
           while((s=br.readLine())!=null){ // read txt file row by row
               String[] str=s.split(",");// split them by comma
               Node node=new Node(str[0]);
               if(str.length>1){//shows there has the adjacency list has the ArrayList of nodes
                   ArrayList<String> list1=new ArrayList<>();
                   for (int i=1;i< str.length;i++) {
                       list1.add(str[i].trim());
                   }
                   node.nexts=list1;
               }else {
                   node.nexts=null;
               }
               list.add(node);//store it into ArrayList
           }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public static void allFollows(String X,ArrayList<Node> list){
        ArrayList<String> direct=new ArrayList<>();//record found direct neighbor elements
        Set<String> set=new HashSet<>();//use set to record but it stops duplicates counted in the indirect collection
        Boolean flag = false;
        //output direct =
        String direct_out="";//record the info of direct neighbor node
        for (Node o: list) {//traverse list
            if (X.equals(o.value)) {
                if (o.nexts == null) {
                    System.out.println(X +" does not follow any person");//output cannot find any direct neighbor node
                    break;
                }
                direct_out=X + " directly follows {";
                for (String next : o.nexts) {//when not empty, record the direct neighbor node info
                    set.add(next);//add it into set in case repeatedly traverse
                    direct.add(next);//record the direct neighbor node then based on this to find indirect neighbor node
                    direct_out += next+",";
                }
                direct_out = direct_out.substring(0, direct_out.length()-1);
                direct_out+="}";
            }
        }
        System.out.println(direct_out);
        //find neighbor elements
        String indirect_out=X + " indirectly follows {";;
        for(int i=0;i<direct.size();i++){//根find indirect neighbor node based on direct neighbor node
            for (Node o: list) {
                if(direct.get(i).equals(o.value)){
                    if(o.nexts==null){
                        break;
                    }else{
                        for (String next : o.nexts){
                            if(!set.contains(next))//when it is not in the set
                            {
                                flag=true;
                                indirect_out+=next+",";
                                set.add(next);//avoid repeatedly traverse so need to add traversed node into the set
                            }
                        }
                    }
                }

            }
        }
        if(flag==true){
        indirect_out= indirect_out.substring(0, indirect_out.length()-1);
        indirect_out+="}";
        System.out.println(indirect_out);
        }


}





    public static void main(String[] args) {
        ArrayList<Node> list=adjList();
//        for (Node o:
//                list) {
//            System.out.println("ArrayList_main:"+o.value+" nexts:"+o.nexts);
//        }//test code
        String[] str={"A","B","C","D","E","F","G"};
        for (String s: str) {
            allFollows(s,list);
        }


    }

}
