package controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.text.Element;
import java.awt.*;
import java.io.*;
import java.net.Socket;

public class ClientController extends  Thread {

   /*public ScrollPane txtMsgShow;
    public javafx.scene.layout.VBox vBox;
    public TextField txtCht;
    public AnchorPane emojiPane;
    public Label lblName;*/

    BufferedReader reader;
    PrintWriter writer;
    Socket socket;
    private FileChooser fileChooser;
    private File filePath;

    public void initialize() throws IOException {
        String userName = LoginController.User_name;
        lblName.setText(userName);

        try {
            Socket socket = new Socket("localhost", 4500);
            System.out.println("socket connect server");
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);

            this.start();
        } catch (IOException e) {
            e.printStackTrace();

        }
        emojiPane.setVisible(false);


    }

    @Override
    public void run() {

        try {
            while (true) {

                String msg = reader.readLine();
                String[] token = msg.split("");
                String cmd = token[0];

                StringBuilder fullMsg = new StringBuilder();

                for (int i = 0; i < token.length; i++) {
                    fullMsg.append(token[i] + "");

                }

                String[] msgToAr = msg.split("");
                String st = "";

                for (int i = 0; i < msgToAr.length; i++) {
                    st += msgToAr[i + 1] + "";


                }
                javafx.scene.text.Text text = new Text(st);
                String firstChars = "";
                if (st.length() > 3) {
                    firstChars = st.substring(0, 3);


                }

                if (firstChars.equalsIgnoreCase("img")) {


                    st = st.substring(3, st.length() - 1);


                    File file = new File(st);
                    javafx.scene.image.Image image = new Image(file.toURI().toString());

                    ImageView imageView = new ImageView(image);


                    imageView.setFitHeight(150);
                    imageView.setFitWidth(200);

                    HBox hBox = new HBox(10);
                    hBox.setAlignment(Pos.BOTTOM_RIGHT);

                    if (!cmd.equalsIgnoreCase(lblName.getText())) {

                        vBox.setAlignment(Pos.TOP_LEFT);
                        hBox.setAlignment(Pos.CENTER_LEFT);

                        Text text1 = new Text("" + cmd + " : ");
                        hBox.getChildren().add(text1);
                        hBox.getChildren().add(imageView);

                    } else {
                        hBox.setAlignment(Pos.BOTTOM_RIGHT);
                        hBox.getChildren().add(imageView);
                        Text text1 = new Text("");
                        hBox.getChildren().add(text1);

                    }

                    Platform.runLater(() -> vBox.getChildren().addAll(hBox));

                } else {

                    TextFlow tempFlow = new TextFlow();

                    if(!cmd.equalsIgnoreCase((lblName.getText()+" : "))){
                        Text txtName=new Text(cmd+"");
                            txtName.getStyleClass().add("txtName");
                            tempFlow.getChildren().add(txtName);

                        tempFlow.setStyle("-fx-color: rgb(239,242,255);" +
                                "-fx-background-color: rgb(48,224,224);" +
                                " -fx-background-radius: 10px");
                        tempFlow.setPadding(new Insets(3,10,3,10));

                    }
                        tempFlow.getChildren().add(text);
                        tempFlow.setMaxWidth(200);

                        TextFlow flow=new TextFlow(tempFlow);


                        HBox hBox=new HBox(12);


                        if(!cmd.equalsIgnoreCase(lblName.getText()+":")){

                            vBox.setAlignment(Pos.TOP_LEFT);
                            hBox.setAlignment(Pos.CENTER_LEFT);
                            hBox.getChildren().add(flow);

                        }else {

                            Text text2 = new Text(fullMsg + "");
                            TextFlow flow2 = new TextFlow(text2);

                            hBox.setAlignment(Pos.BOTTOM_RIGHT);
                            hBox.getChildren().add(flow2);
                            hBox.setPadding(new Insets(2, 5, 2, 10));


                            flow2.setStyle("-fx-color: rgb(239,242,255);" +
                                    "-fx-background-color: rgb(9,241,148);" +
                                    "-fx-background-radius: 10px");
                            flow2.setPadding(new Insets(3,10,3,10));

                        }

                    Platform.runLater(() -> vBox.getChildren().addAll(hBox));


                }
            }


            } catch (Exception e) {
                e.printStackTrace();
            }
    }



        @FXML
        private AnchorPane emojiPane;

        @FXML
        private Label lblName;

        @FXML
        private TextField txtCht;

        @FXML
        private ScrollPane txtMsgShow;

        @FXML
        private VBox vBox;

        @FXML
        void bigSmile (MouseEvent event){

        }

        @FXML
        void btnCloseOnAction (MouseEvent event){
            System.exit(0);

        }

        @FXML
        void btnEmojiOnAction (MouseEvent event){
            emojiPane.setVisible(true);

        }

        @FXML
        void btnGalleryOnAction (MouseEvent event){
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            fileChooser=new FileChooser();
            fileChooser.setTitle("Open Image");
            this.filePath=fileChooser.showOpenDialog(stage);
            writer.println(lblName.getText()+""+"img"+filePath.getPath());

        }

        @FXML
        void btnSendMsgOnAction (MouseEvent event){

        }

        @FXML
        void emojiPaneOnAction (MouseEvent event){

        }

        @FXML
        void heart (MouseEvent event){

        }

        @FXML
        void love (MouseEvent event){

        }

        @FXML
        void money (MouseEvent event){

        }

        @FXML
        void mouseOnClickHideEmoji (MouseEvent event){
            emojiPane.setVisible(false);

        }

        @FXML
        void oneEye (MouseEvent event){

        }

        @FXML
        void sad (MouseEvent event){

        }

        @FXML
        void smalleSmile (MouseEvent event){

        }

        @FXML
        void teethSmile (MouseEvent event){

        }

        @FXML
        void tongSmile (MouseEvent event){

        }

        @FXML
        void tuin (MouseEvent event){

        }

        @FXML
        void txtChtOnAction (ActionEvent event){

            String msg=txtCht.getText();
            writer.println(lblName.getText()+" : "+msg);

            txtCht.clear();

            if (msg.equalsIgnoreCase("BYE") ||(msg.equalsIgnoreCase("logout"))){
                System.exit(0);

            }

        }

        @FXML
        void verySad (MouseEvent event){

        }

    }

