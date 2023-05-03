module com.dpeeters.molelim {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires javafx.swing;
    requires java.desktop;

    requires org.controlsfx.controls;

    opens com.dpeeters.molelim to javafx.fxml;
    exports com.dpeeters.molelim;
    exports com.dpeeters.molelim.io;
    opens com.dpeeters.molelim.io to javafx.fxml;
    exports com.dpeeters.molelim.media;
    opens com.dpeeters.molelim.media to javafx.fxml;
    exports com.dpeeters.molelim.media.components;
    opens com.dpeeters.molelim.media.components to javafx.fxml;
    exports com.dpeeters.molelim.eliminationmodels;
    opens com.dpeeters.molelim.eliminationmodels to javafx.fxml;
}