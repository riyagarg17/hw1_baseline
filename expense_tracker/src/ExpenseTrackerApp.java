import javax.swing.table.DefaultTableModel;

/**
 * The ExpenseTrackerApp class allows users to add/remove daily transactions.
 */
public class ExpenseTrackerApp {

  public static void main(String[] args) {
    
    // Create MVC components
    DefaultTableModel tableModel = new DefaultTableModel();
    tableModel.addColumn("Serial");
    tableModel.addColumn("Amount");
    tableModel.addColumn("Category");
    tableModel.addColumn("Date");
    

    
    ExpenseTrackerView view = new ExpenseTrackerView(tableModel);

    // Initialize view
    view.setVisible(true);

    // Handle add transaction button clicks
    view.getAddTransactionBtn().addActionListener(e -> {
      
      // Get transaction data from view
      double amount = view.getAmountField(); 
      String category = view.getCategoryField();

      // Validate input
      if (!InputValidation.validateAmount(amount)) {
          view.showErrorPopup("Error! Amount must be greater than 0 and less than 1000.");
          return;
      }
      if (!InputValidation.validateCategory(category)) {
          view.showErrorPopup("Invalid category! Must be one of: food, travel, bills, entertainment, other.");
          return;
      }
      // If validation passes, create and add transaction
      Transaction t = new Transaction(amount, category);
      view.addTransaction(t);
    });

  }

}