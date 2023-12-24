package org.fbs.jcu;

import org.fbs.jcu.data.*;
import org.fbs.jcu.exception.ArgsException;

import java.io.IOException;

public class Main extends App {

    private static final Option[] options = new Option[]{
            new Option("-mainName", "-mn", "Main", "Set file name for file with main() method"){
                @Override
                public void onSetting(){
                    callArg(keys[0]);
                }
            },
            new Option("-opt", "-o", false)
    };
    private static final Key[] keys = new Key[]{
            new Key("--createMain", "--cm"),
            new Key("--upperCase", "--uc")
    };
    private static final Function[] functions = new Function[]{
            new Function("hello-world", new Option[]{}, new Key[]{}) {
                @Override
                public void call() {
                    String string = "hello world";
                    if (keys[1].isValue()){
                        string = string.toUpperCase();
                    }
                    System.out.println(string);
                }
            },
            new Function("good-bye",new Option[]{}, new Key[]{}) {
                @Override
                public void call() {
                    String string = "good bye";
                    if (keys[1].isValue()){
                        string = string.toUpperCase();
                    }
                    System.out.println(string);
                }
            },
            new Function("oh", new Option[]{}, new Key[]{}) {
                @Override
                public void call() {
                    String string = "oh, no";
                    if (keys[1].isValue()){
                        string = string.toUpperCase();
                    }
                    System.out.println(string);
                }
            }
    };

    public Main(String[] args, AppArguments appArguments, boolean mustContainsArgs) throws ArgsException, IOException, InterruptedException {
        super(args, appArguments, mustContainsArgs, true, "main", "org/fbs/");
        run();
    }

    public static void main(String[] args) throws ArgsException, IOException, InterruptedException {
        AppArguments appArguments = new AppArguments(options, keys, functions);
        new Main(args, appArguments, false);
    }

    @Override
    public void run() throws IOException, InterruptedException {
        //getArgsParser().getFunctions().get(0).call();

    }

}