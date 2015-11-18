package controllers;


import play.mvc.*;


public class Application extends Controller {

    public static void index() {
        render();
    }
    public static void smoke(){
        render();
    }

    public static void save() {
        render();
    }

    public static void sayHello(String userId) {
        render(userId);
    }


}