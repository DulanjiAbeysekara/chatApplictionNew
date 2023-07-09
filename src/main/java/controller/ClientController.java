package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

import java.io.*;
import java.net.Socket;

public class ClientController extends  Thread{

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
        String userName=LoginController.User_name;
        lblName.setText(userName);

        try {
            Socket socket=new Socket("localhost",4500);
            System.out.println("socket connect server");
            reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer=new PrintWriter(socket.getOutputStream(),true);

            this.start();
        }catch (IOException e){
            e.printStackTrace();

        }
        emojiPane.setVisible(false);


    }
        @Override
        public void run() {

            try {
                while (true) {

                    String msg=reader.readLine();
                    String[] token=msg.split("");
                    String cmd=token[0];

                    StringBuilder fullMsg=new StringBuilder();

                    for(int i=0; i<token.length; i++){
                        fullMsg.append(token[i]+"");

                    }

                    String[] msgToAr=msg.split("");
                    String st="";

                    for (int i=0; i< msgToAr.length; i++){
                         st+=msgToAr[i+1]+ "";


                }


                }
            } catch (IOException e) {
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
    void bigSmile(MouseEvent event) {

    }

    @FXML
    void btnCloseOnAction(MouseEvent event) {

    }

    @FXML
    void btnEmojiOnAction(MouseEvent event) {

    }

    @FXML
    void btnGalleryOnAction(MouseEvent event) {

    }

    @FXML
    void btnSendMsgOnAction(MouseEvent event) {

    }

    @FXML
    void emojiPaneOnAction(MouseEvent event) {

    }

    @FXML
    void heart(MouseEvent event) {

    }

    @FXML
    void love(MouseEvent event) {

    }

    @FXML
    void money(MouseEvent event) {

    }

    @FXML
    void mouseOnClickHideEmoji(MouseEvent event) {

    }

    @FXML
    void oneEye(MouseEvent event) {

    }

    @FXML
    void sad(MouseEvent event) {

    }

    @FXML
    void smalleSmile(MouseEvent event) {

    }

    @FXML
    void teethSmile(MouseEvent event) {

    }

    @FXML
    void tongSmile(MouseEvent event) {

    }

    @FXML
    void tuin(MouseEvent event) {

    }

    @FXML
    void txtChtOnAction(ActionEvent event) {

    }

    @FXML
    void verySad(MouseEvent event) {

    }

}
