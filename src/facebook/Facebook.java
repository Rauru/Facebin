/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package facebook;

/**
 *
 * @author Rauru
 */
import java.util.StringTokenizer;
import java.io.RandomAccessFile;
import java.io.File;
import java.util.Date;
public class Facebook {

    /**
     * @param args the command line arguments
     */
    
    
//    File profile = new File("profile.fbn");
    static File fb= new File("Facebook.java");
    
    public boolean seekEmail(String c){
       try{
           //File gerencia= new File();
           RandomAccessFile rafc = new RandomAccessFile("gerencia.fbn","rw");
           
           rafc.seek(0);
           while(rafc.getFilePointer()<rafc.length()){
               String cc=rafc.readUTF();
               rafc.readUTF();
               rafc.readBoolean();
               rafc.readLong();
               if(cc.equals(c)){
                   System.out.println("huy");
                   return false;
               }
           }
           
       }catch(Exception e){
           System.out.println(e);
           return false;
       }
       return true;
    }
    private String path(){
        StringTokenizer st= new StringTokenizer(fb.getAbsolutePath(),"\\");
        String path="";
        while(st.hasMoreTokens()){
            String temp=st.nextToken();
            if(!"Facebook.java".equals(temp)){
                path+=temp+"\\";
            }
        }
        return path;
    }
    
    public boolean addUser(String n, String p,char g,long d,String c,int t){
        try{
            RandomAccessFile rafau= new RandomAccessFile("gerencia.fbn","rw");
            File carpeta = new File(c);
            RandomAccessFile rafaud= new RandomAccessFile(path()+c+"\\"+"profile.fbn","rw");
            RandomAccessFile rafaf= new RandomAccessFile(path()+c+"\\"+"manageFriends.fbn","rw");
            if(carpeta.mkdir()){
            
            if(seekEmail(c)){
                rafau.seek(rafau.length());
                rafau.writeUTF(c);
                rafau.writeUTF(p);
                rafau.writeBoolean(true);
                rafau.writeLong(rafaud.length());
                
                    
                    //File userData = new File(c);
                   // File userDatas = new File(path+c,"profile.fbn");
//                    System.out.println(userDatas.getAbsolutePath());
//                    System.out.println(path+c);
//                    if(userDatas.createNewFile()){
//                        System.out.println("cheers");
//                    }
//                    System.out.println(path()+c);
//                    
//                    System.out.println(path()+c);
                    rafaud.writeUTF(n);
                    rafaud.writeChar(g);
                    rafaud.writeLong(d);
                    rafaud.writeInt(t);
                    Date dc= new Date();
                    rafaud.writeLong(dc.getTime());
                    return true;
                }
                
            }
        }catch(Exception e){
            System.out.println(e);
            return false;
        }
        return false;
    }
    
    public boolean addFriends(String cpropip,String camigo ){
        try{
            
            if(seekEmail(camigo)){
                RandomAccessFile rafa = new RandomAccessFile(path()+camigo+"\\"+"manageFriends.fbn","rw");
            RandomAccessFile rafp = new RandomAccessFile(path()+cpropip+"\\"+"manageFriends.fbn","rw");
            rafa.seek(rafa.length());
            rafa.writeUTF(cpropip);
            rafa.writeBoolean(false);
            rafa.writeBoolean(false);
            rafp.seek(rafp.length());
            rafp.writeUTF(camigo);
            rafp.writeBoolean(false);
            rafp.writeBoolean(false);
            }
            
                    }catch(Exception e){
                        return false;
                    }
        return false;
    }
    
    public boolean addComment(String e,String c){
        try{
            RandomAccessFile rafc = new RandomAccessFile(path()+c+"profile.fbn","rw");
            rafc.seek(rafc.length());
            rafc.writeUTF(c);
        }catch(Exception ex){
            return false;
        }
        return false;
    }
//    
//   // public static void main(String[] args) {
//        // TODO code application logic here
//      
//      addUser();
//    }
}
