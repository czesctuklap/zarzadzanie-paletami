module com.example.zarzadzaniepaletami {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;

    opens com.example.zarzadzaniepaletami to javafx.fxml;
    exports com.example.zarzadzaniepaletami;
}