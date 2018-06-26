package application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.shape.*;

public class NewQrCode extends Application{
	public void start(Stage primaryStage) {  
		Group root = new Group();
		Scene scene = new Scene(root, 512, 512, Color.WHITE);
		 primaryStage.setTitle("Random QR Code");
		primaryStage.setScene(scene);
        primaryStage.show();
       for(int i=0; i<=150000;i++) 
        {
      
    	   int a = (int)(Math.random()*503)*10;//making random # multiple of 10 so that it depicts real QR code
           int b = (int)(Math.random()*503)*10;
           int c = 	(int) (Math.random()*2);
           Rectangle rect = new Rectangle(a,b,10,10);
           root.getChildren().add(rect);
        // we can as well remove this condition and mention and have it loop less times
        // but going by one of the points to use 0 for black and 1 for white
           if (c==0)
        	  rect.setFill(Color.BLACK);
       //Excluded the else function if included in the program is only going to increase the run time
       //  r.setFill(Color.WHITE);
       //  else
        	 
        }
       
       //The following piece of code is basically to insert boxes
       //to depict the real QR code
      
        int[] printBoxXaxis=new int[] {0,440};
        int[] printBoxYaxis=new int[] {0,440};
        for(int j=0;j<printBoxYaxis.length;j++)
        {
        	for (int k=0;k<printBoxYaxis.length;k++)
        	{
        int p=printBoxXaxis[j];
        int z=printBoxYaxis[k];
        int q=80;
        Rectangle topLeftOne = new Rectangle(p,z,q,q);
        root.getChildren().add(topLeftOne);
        topLeftOne.setFill(Color.WHITE);
        int s=p+10;
        int l=z+10; 
        float t=q-20;
        Rectangle topLeftTwo = new Rectangle(s,l,t,t);
        root.getChildren().add(topLeftTwo);
        topLeftTwo.setFill(Color.BLACK);
        int u=s+10;
        int m=l+10;
        float v=t-20;
        Rectangle topLeftThree = new Rectangle(u,m,v,v);
        root.getChildren().add(topLeftThree);
        topLeftThree.setFill(Color.WHITE);
        int w=u+10;
        int n=m+10;
        float x=v-20;
        Rectangle topLeftFour = new Rectangle(w,n,x,x);
        root.getChildren().add(topLeftFour);
        topLeftFour.setFill(Color.BLACK);
        }
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }        
}