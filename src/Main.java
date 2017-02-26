import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String k;
		int unghi;
		long startTime, stopTime, elapsedTime=0;
		Imagine img = new Imagine();
		Scanner scan = new Scanner(System.in);
		do{
			System.out.println("Introduceti calea spre imaginea sursa");
			img.setPath(scan.nextLine());
			img.openPath();
			if(img.getImg()==null)
				System.out.println("Adresa invalida! Incercati in nou");
		}
		while(img.getImg()==null);
		do{
			System.out.println("Introduceti unghiul de rotire (90/180/270)");
			k=scan.nextLine();
			if(!k.equals("90") && !k.equals("180") && !k.equals("270"))
				System.out.println("Unghi invalid! Incercati din nou");
			else{
				
				img.rotate(k);
				
			}
			
			 
		}
		while(!k.equals("90") && !k.equals("180") && !k.equals("270"));
		scan.close();
		
	}

}
