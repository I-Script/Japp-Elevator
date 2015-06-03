###Japp-Elevator
####What is it

Is a small library which allow you to elevate your application as admin rights.
You will be able to write/copy and other actions without SecurityException.

####How to use

Simply, call the method `Japp#elevateApplication` and stop the app is the value `true` is returned.
Example:

    public class Main {
        public static void main(String[] args) {
            if(Japp.elevateApplication()) return;

            System.out.println("Application is now running as administrator.");
        }
    }

Your application is now running as administrator.