package projectRecruiterPlus.Util.Table;

import java.time.LocalDate;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import projectRecruiterPlus.App;
import projectRecruiterPlus.Entities.User;

public class TableOfUsers {

	private TableView<UserTable> table = new TableView<UserTable>();
	private ArrayList<UserTable> listOfUsersTable = new ArrayList<UserTable>();
	private ArrayList<User> listOfUsers = (ArrayList<User>) App.resources.getDaoUser().getAll();
	private ObservableList<UserTable> data= FXCollections.observableArrayList(listOfUsersTable);
	
	private TableColumn<UserTable, String> usernameCol = new TableColumn<UserTable, String>("Username");
	private TableColumn<UserTable, String> firstNameCol = new TableColumn<UserTable, String>("First Name");
	private TableColumn<UserTable, String> lastNameCol = new TableColumn<UserTable, String>("Last Name");
	private TableColumn<UserTable, String> emailCol = new TableColumn<UserTable, String>("Email");
	private TableColumn<UserTable, String> adressCol = new TableColumn<UserTable, String>("Adress");
	private TableColumn<UserTable, LocalDate> birthdayCol = new TableColumn<UserTable, LocalDate>("Birthday");
	private TableColumn<UserTable, LocalDate> firstDayOfWorkCol = new TableColumn<UserTable, LocalDate>("Start date");
	private TableColumn<UserTable, LocalDate> lastDayOfWorkCol = new TableColumn<UserTable, LocalDate>("Last day");
	private TableColumn<UserTable, Double> grossSalaryCol = new TableColumn<UserTable, Double>("Gross Salary");
	private TableColumn<UserTable, Double> netSalaryCol = new TableColumn<UserTable, Double>("Net Salary");
	private TableColumn<UserTable, Integer> vacationCol = new TableColumn<UserTable, Integer>("Vacation Days");
	private TableColumn<UserTable, String> rolCol = new TableColumn<UserTable, String>("Company Role");
	private TableColumn<UserTable, String> teamCol = new TableColumn<UserTable, String>("Team");
	private Button refresh = new Button("Refresh");
	private final VBox vbox = new VBox();

	public VBox addVBoxTable() {
		for (User user : listOfUsers) {
			listOfUsersTable.add(new UserTable(user));
		}
		
		
		usernameCol.setMinWidth(150);
		usernameCol.setCellValueFactory(new PropertyValueFactory<UserTable, String>("username"));
	
		firstNameCol.setMinWidth(120);
		firstNameCol.setCellValueFactory(new PropertyValueFactory<UserTable, String>("firstName"));
		
		lastNameCol.setMinWidth(120);
		lastNameCol.setCellValueFactory(new PropertyValueFactory<UserTable, String>("lastName"));

		emailCol.setMinWidth(200);
		emailCol.setCellValueFactory(new PropertyValueFactory<UserTable, String>("email"));

		adressCol.setMinWidth(150);
		adressCol.setCellValueFactory(new PropertyValueFactory<UserTable, String>("adress"));

		birthdayCol.setMinWidth(100);
		birthdayCol.setCellValueFactory(new PropertyValueFactory<UserTable, LocalDate>("birthday"));

		firstDayOfWorkCol.setMinWidth(100);
		firstDayOfWorkCol.setCellValueFactory(new PropertyValueFactory<UserTable, LocalDate>("firstDayWork"));

		lastDayOfWorkCol.setMinWidth(100);
		lastDayOfWorkCol.setCellValueFactory(new PropertyValueFactory<UserTable, LocalDate>("lastDayWork"));
		
		grossSalaryCol.setMinWidth(120);
		grossSalaryCol.setCellValueFactory(new PropertyValueFactory<UserTable, Double>("grossSalary"));
		
		netSalaryCol.setMinWidth(120);
		netSalaryCol.setCellValueFactory(new PropertyValueFactory<UserTable, Double>("netSalary"));
		
		vacationCol.setMinWidth(100);
		vacationCol.setCellValueFactory(new PropertyValueFactory<UserTable, Integer>("vacationDays"));
		
		rolCol.setMinWidth(120);
		rolCol.setCellValueFactory(new PropertyValueFactory<UserTable, String>("roleName"));
		
		teamCol.setMinWidth(120);
		teamCol.setCellValueFactory(new PropertyValueFactory<UserTable, String>("team"));

		table.getColumns().addAll(usernameCol, firstNameCol, lastNameCol, emailCol, adressCol, birthdayCol,
				firstDayOfWorkCol, lastDayOfWorkCol, grossSalaryCol, netSalaryCol, vacationCol, rolCol, teamCol);
		table.setEditable(true);
		table.setItems(data);

		refresh.getStyleClass().add("fancy-button");
		refresh.setOnAction(e -> {
			ArrayList<UserTable> listOfUsersTable2 = new ArrayList<UserTable>();
			ArrayList<User> listOfUsers2 = (ArrayList<User>) App.resources.getDaoUser().getAll();
			for (User user : listOfUsers2) {
				listOfUsersTable2.add(new UserTable(user));
			}
			ObservableList<UserTable> data2 = FXCollections.observableArrayList(listOfUsersTable2);
			table.setItems(data2);
		});

		vbox.setSpacing(5);
		vbox.setPadding(new Insets(10, 0, 0, 10));
		vbox.getChildren().addAll(table, refresh);

		return vbox;
	}

	
}
