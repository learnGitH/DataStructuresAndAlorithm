package com.haibin.thinking.io;

import com.haibin.thinking.util.OSExecuteException;
import com.haibin.thinking.util.Print;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class OSExecute {
    public static void command(String command){
        boolean err = false;
        try{
            Process process = new ProcessBuilder(command.split(" ")).start();
            BufferedReader results = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String s;
            while((s=results.readLine()) != null){
                Print.print(s);
            }
            BufferedReader errors = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            while((s=errors.readLine()) != null){
                Print.print(s);
                err = true;
            }
        } catch (Exception e){
            if (!command.startsWith("CMD /C")){
                command("CMD /C" + command);
            }else{
                throw new RuntimeException(e);
            }
        }
        if (err){
            throw new OSExecuteException("Errors executing " + command);
        }
    }
    public static void main(String[] args){
        OSExecute.command("javap OSExecute");
    }
}
