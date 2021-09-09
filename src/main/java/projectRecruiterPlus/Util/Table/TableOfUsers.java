package projectRecruiterPlus.Util.Table;

import java.time.LocalDate;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import projectRecruiterPlus.App;
import projectRecruiterPlus.Entities.User;

public class TableOfUsers {

	private TableView<UserInTable> table = new TableView<UserInTable>();
	private ArrayList<UserInTable> listOfUsersTable = new ArrayList<UserInTable>();
	private ArrayList<User> listOfUsers = (ArrayList<User>) App.resources.getDaoUser().getAll();
	private Label shadow = new Label(" ");
	private ObservableList<UserInTable> data;
	
	private TableColumn<UserInTable, String> usernameCol = new TableColumn<UserInTable, String>("Username");
	private TableColumn<UserInTable, String> firstNameCol = new TableColumn<UserInTable, String>("First Name");
	private TableColumn<UserInTable, String> lastNameCol = new TableColumn<UserInTable, String>("Last Name");
	private TableColumn<UserInTable, String> emailCol = new TableColumn<UserInTable, String>("Email");
	private TableColumn<UserInTable, String> adressCol = new TableColumn<UserInTable, String>("Adress");
	private TableColumn<UserInTable, LocalDate> birthdayCol = new TableColumn<UserInTable, LocalDate>("Birthday");
	private TableColumn<UserInTable, LocalDate> firstDayOfWorkCol = new TableColumn<UserInTable, LocalDate>("Start date");
	private TableColumn<UserInTable, LocalDate> lastDayOfWorkCol = new TableColumn<UserInTable, LocalDate>("Last day");
	private TableColumn<UserInTable, Double> grossSalaryCol = new TableColumn<UserInTable, Double>("Gross Salary");
	private TableColumn<UserInTable, Double> netSalaryCol = new TableColumn<UserInTable, Double>("Net Salary");
	private TableColumn<UserInTable, Integer> vacationCol = new TableColumn<UserInTable, Integer>("Vacation Days");
	private TableColumn<UserInTable, String> rolCol = new TableColumn<UserInTable, String>("Company Role");
	private TableColumn<UserInTable, String> teamCol = new TableColumn<UserInTable, String>("Team");
	private Button refresh = new Button("Refresh");
	private final VBox vbox = new VBox();

	public VBox addVBoxTable() {

		editColumns();
		editRefreshButton();
		editTable();

		vbox.getStylesheets().add("projectRecruiterPlus/graphicsInterface/CSS/styleTable.css");
		vbox.setSpacing(5);
		vbox.setPadding(new Insets(10, 0, 0, 10));
		vbox.getChildren().addAll(table, refresh, shadow);

		return vbox;
	}
	
	private void editColumns() {
		usernameCol.setMinWidth(150);
		usernameCol.setMaxWidth(300);
		usernameCol.setCellValueFactory(new PropertyValueFactory<UserInTable, String>("username"));
	
		firstNameCol.setMinWidth(120);
		firstNameCol.setMaxWidth(300);
		firstNameCol.setCellValueFactory(new PropertyValueFactory<UserInTable, String>("firstName"));
		
		lastNameCol.setMinWidth(120);
		lastNameCol.setMaxWidth(300);
		lastNameCol.setCellValueFactory(new PropertyValueFactory<UserInTable, String>("lastName"));

		emailCol.setMinWidth(200);
		emailCol.setMaxWidth(300);
		emailCol.setCellValueFactory(new PropertyValueFactory<UserInTable, String>("email"));

		adressCol.setMinWidth(150);
		adressCol.setMaxWidth(300);
		adressCol.setCellValueFactory(new PropertyValueFactory<UserInTable, String>("adress"));

		birthdayCol.setMinWidth(100);
		birthdayCol.setMaxWidth(300);
		birthdayCol.setCellValueFactory(new PropertyValueFactory<UserInTable, LocalDate>("birthday"));

		firstDayOfWorkCol.setMinWidth(100);
		firstDayOfWorkCol.setMaxWidth(300);
		firstDayOfWorkCol.setCellValueFactory(new PropertyValueFactory<UserInTable, LocalDate>("firstDayWork"));

		lastDayOfWorkCol.setMinWidth(100);
		lastDayOfWorkCol.setMaxWidth(300);
		lastDayOfWorkCol.setCellValueFactory(new PropertyValueFactory<UserInTable, LocalDate>("lastDayWork"));
		
		grossSalaryCol.setMinWidth(115);
		grossSalaryCol.setMaxWidth(300);
		grossSalaryCol.setCellValueFactory(new PropertyValueFactory<UserInTable, Double>("grossSalary"));
		
		netSalaryCol.setMinWidth(115);
		netSalaryCol.setMaxWidth(300);
		netSalaryCol.setCellValueFactory(new PropertyValueFactory<UserInTable, Double>("netSalary"));
		
		vacationCol.setMinWidth(100);
		vacationCol.setMaxWidth(300);
		vacationCol.setCellValueFactory(new PropertyValueFactory<UserInTable, Integer>("vacationDays"));
		
		rolCol.setMinWidth(120);
		rolCol.setMaxWidth(300);
		rolCol.setCellValueFactory(new PropertyValueFactory<UserInTable, String>("roleName"));
		
		teamCol.setMinWidth(120);
		teamCol.setMaxWidth(300);
		teamCol.setCellValueFactory(new PropertyValueFactory<UserInTable, String>("team"));
	}
	
	private void editRefreshButton() {
		refresh.getStyleClass().add("fancy-button");
		refresh.setOnAction(e -> {
			ArrayList<UserInTable> listOfUsersTable2 = new ArrayList<UserInTable>();
			ArrayList<User> listOfUsers2 = (ArrayList<User>) App.resources.getDaoUser().getAll();
			for (User user : listOfUsers2) {
				listOfUsersTable2.add(new UserInTable(user));
			}
			ObservableList<UserInTable> data2 = FXCollections.observableArrayList(listOfUsersTable2);
			table.setItems(data2);
		});
	}
	
	private void editTable() {
		for (User user : listOfUsers) 
			listOfUsersTable.add(new UserInTable(user));
		data = FXCollections.observableArrayList(listOfUsersTable);
		table.getColumns().addAll(usernameCol, firstNameCol, lastNameCol, emailCol, adressCol, birthdayCol,
				firstDayOfWorkCol, lastDayOfWorkCol, grossSalaryCol, netSalaryCol, vacationCol, rolCol, teamCol);
		table.setEditable(true);
		table.setItems(data);
		table.prefHeightProperty().bind(vbox.heightProperty());
        table.prefWidthProperty().bind(vbox.widthProperty());
	}
}
