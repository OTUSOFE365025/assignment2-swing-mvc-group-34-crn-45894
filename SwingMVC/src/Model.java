
public class Model {
	 private String firstname;
	 private String lastname;

	// Cash Register fields
    private Map<String, String[]> productCatalog;  
    private List<String[]> scannedItems;
	 
	 public Model(String firstname, String lastname, String productFile) {
	  this.firstname = firstname;
	  this.lastname = lastname;
	scannedItems = new ArrayList<>();
        productCatalog = new HashMap<>();
        loadProducts(productFile);
	 }
	 
	 public String getFirstname() {
	  return firstname;
	 }
	 
	 public void setFirstname(String firstname) {
	  this.firstname = firstname;
	 }
	 
	 public String getLastname() {
	  return lastname;
	 }
	 
	 public void setLastname(String lastname) {
	  this.lastname = lastname;
	 }

	  // Load product data from file
    private void loadProducts(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            boolean firstLine = true;
            while ((line = br.readLine()) != null) {
                if (firstLine) { firstLine = false; continue; }
                String[] parts = line.trim().split("\\s+");
                if (parts.length == 3) {
                    productCatalog.put(parts[0], parts);  // UPC -> [UPC, name, price]
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Cash Register methods
    public void addItem(String upc) {
        String[] p = productCatalog.get(upc);
        if (p != null) scannedItems.add(p);
    }

    public double getSubtotal() {
        double subtotal = 0;
        for (String[] p : scannedItems) {
            subtotal += Double.parseDouble(p[2]);
        }
        return subtotal;
    }

    public List<String[]> getScannedItems() { return scannedItems; }
    public Map<String, String[]> getProductCatalog() { return productCatalog; }
}
