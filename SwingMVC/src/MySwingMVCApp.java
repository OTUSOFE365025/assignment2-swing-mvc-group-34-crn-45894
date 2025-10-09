
public class MySwingMVCApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  // Assemble all the pieces of the MVC
		 Model m = new Model("Sylvain", "Saurel", "productData.txt");
		  View v = new View("MVC with Cash Register");
		// create scanner
		  Scanner s = new Scanner();
		  Controller c = new Controller(m, v, s);
		
		  
		  c.initController();
	}

}
