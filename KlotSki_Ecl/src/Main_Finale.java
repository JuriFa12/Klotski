
import view.*;
import javafx.stage.*;


public class Main_Finale
{
	
	public static void main(String [] args)
	{
		Prova a = new Prova();
		Stage stage = new Stage();
		try
		{
		a.start(stage);
		}
		catch (Exception e)
		{
			return;
		}
	}
	
}
