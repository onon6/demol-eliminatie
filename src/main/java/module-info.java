module com.dpeeters.molelim2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.dpeeters.molelim2 to javafx.fxml;
    exports com.dpeeters.molelim2;
}