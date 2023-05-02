module com.dpeeters.molelim {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires java.desktop;

    requires org.controlsfx.controls;

    opens com.dpeeters.molelim to javafx.fxml;
    exports com.dpeeters.molelim;
}