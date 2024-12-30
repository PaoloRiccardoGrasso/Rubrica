package io.github.PaoloRiccardoGrasso;

import io.github.PaoloRiccardoGrasso.Model.*;
import io.github.PaoloRiccardoGrasso.View.Menu;


public class App {
    public static void main(String[] args) {
        App app = new App();
        
        app.Run();
    }
    
    public void Run(){
        Menu menu = new Menu();
        
        
        menu.apriMenu();
        
    }
}
