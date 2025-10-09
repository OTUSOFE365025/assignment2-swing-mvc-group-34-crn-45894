import javax.swing.JOptionPane;
 
public class Controller {
	 private Model model;
	 private View view;
	 private Scanner scanner;
	
	 public Controller(Model m, View v, Scanner s) {
	   this.model = m;
        this.view = v;
        this.scanner = s;
        initView();
	 }
	 
	 public void initView() {
	  view.getFirstnameTextfield().setText(model.getFirstname());
	  view.getLastnameTextfield().setText(model.getLastname());
	 }
	 
	 public void initController() {
	  view.getFirstnameSaveButton().addActionListener(e -> saveFirstname());
	  view.getLastnameSaveButton().addActionListener(e -> saveLastname());
	  view.getHello().addActionListener(e -> sayHello());
	  view.getBye().addActionListener(e -> sayBye());
		view.getScanButton().addActionListener(e -> scanItem());
	 }
	 
	 private void saveFirstname() {
	  model.setFirstname(view.getFirstnameTextfield().getText());
	  JOptionPane.showMessageDialog(null, "Firstname saved : " + model.getFirstname(), "Info", JOptionPane.INFORMATION_MESSAGE);
	 }
	 
	 private void saveLastname() {
	  model.setLastname(view.getLastnameTextfield().getText());
	  JOptionPane.showMessageDialog(null, "Lastname saved : " + model.getLastname(), "Info", JOptionPane.INFORMATION_MESSAGE);
	 }
	 
	 private void sayHello() {
	  JOptionPane.showMessageDialog(null, "Hello " + model.getFirstname() + " " + model.getLastname(), "Info", JOptionPane.INFORMATION_MESSAGE);
	 }
	 
	 private void sayBye() {
	  System.exit(0);
	 }

	 private void scanItem() {
        String upc = scanner.getRandomUPC();
        if (upc != null) {
            model.addItem(upc);
            // Update the view so items and subtotal are shown
            view.updateDisplay(model.getScannedItems(), model.getSubtotal());
        } else {
            JOptionPane.showMessageDialog(null, "No products available.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
	 
}
