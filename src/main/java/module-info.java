module com.mherifaniry.Wview{
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires com.mherifaniry.wcontroller;
    requires  com.herifaniry.Wmodal;
    exports com.mherifaniry.view;
    opens com.mherifaniry.view to javafx.fxml;
}