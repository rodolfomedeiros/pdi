package com.devroods.processamentodeimagem.module.main;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;
import javax.imageio.ImageTypeSpecifier;

import com.devroods.processamentodeimagem.model.Pixel;
import com.devroods.processamentodeimagem.util.AppUtils;
import com.devroods.processamentodeimagem.util.ConstApp;
import com.devroods.processamentodeimagem.util.FiltersType;
import com.devroods.processamentodeimagem.util.UtilsColor;

import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.transform.Shear;
import javafx.stage.FileChooser;
import javafx.util.Pair;
import jfxtras.labs.scene.control.window.CloseIcon;
import jfxtras.labs.scene.control.window.Window;

public class MainController implements Initializable{
	
	private List<ImageView> imageViews;
	private ImageView imgTransform;
	private List<Window> windows;
	private int tamX;
	private int tamY;
	
	@FXML private Pane paneContent;
	@FXML private StackPane paneTransform;
	
	public void initialize(URL location, ResourceBundle resources) {
		imageViews = new ArrayList<>();
		windows = new ArrayList<>();
		tamX = 512;
		tamY = 512;
	}
	
	@FXML private void notImplement(ActionEvent event) {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Null");
		alert.setHeaderText(null);
		alert.setContentText("Desculpa... Não está implementado! Agradeço a compreensão! :)");

		alert.showAndWait();
	}
	
	@FXML private void sum(ActionEvent event) {

		if(imageViews.size() == 0) return;
		
		WritableImage wImage = new WritableImage(tamX, tamY);
		PixelWriter pixelWriter = wImage.getPixelWriter();
		
		Color matrizColor[][] = new Color[tamX][tamY];
		
		Image image = null;
		Color color = null;
		
		image = imageViews.get(0).getImage();
		for(int readX = 0; readX < tamX; readX++){
	        for(int readY = 0; readY < tamY; readY++){
	        	matrizColor[readX][readY] = image.getPixelReader().getColor(readX, readY);
	        }
	    }
		
		image = imageViews.get(1).getImage();
		for(int readX = 0; readX < tamX; readX++){
	        for(int readY = 0; readY < tamY; readY++){
				
				color = image.getPixelReader().getColor(readX, readY);
				
				matrizColor[readX][readY] = UtilsColor.sumColor(matrizColor[readX][readY], color);
				
	        	pixelWriter.setColor(readX, readY, matrizColor[readX][readY]);
	        }
	    }
	    
	    paneContent.getChildren().add(createWindowViewImage(new ImageView(wImage), ConstApp.IMAGE_RESULT));
	}
	
	@FXML private void sub(ActionEvent event) {
		if(imageViews.size() == 0) return;
				
		WritableImage wImage = new WritableImage(tamX, tamY);
		PixelWriter pixelWriter = wImage.getPixelWriter();
		
		Color matrizColor[][] = new Color[tamX][tamY];
		
		Image image = null;
		Color color = null;
		
		image = imageViews.get(0).getImage();
		for(int readX = 0; readX < tamX; readX++){
	        for(int readY = 0; readY < tamY; readY++){
	        	matrizColor[readX][readY] = image.getPixelReader().getColor(readX, readY);
	        }
	    }
		
		image = imageViews.get(1).getImage();
		for(int readX = 0; readX < tamX; readX++){
	        for(int readY = 0; readY < tamY; readY++){
				
				color = image.getPixelReader().getColor(readX, readY);
				
				matrizColor[readX][readY] = UtilsColor.subColor(matrizColor[readX][readY], color);
				
	        	pixelWriter.setColor(readX, readY, matrizColor[readX][readY]);
	        }
	    }
	    
	    paneContent.getChildren().add(createWindowViewImage(new ImageView(wImage), ConstApp.IMAGE_RESULT));
	}
	
	@FXML private void mult(ActionEvent event) {
		if(imageViews.size() == 0) return;
				
		WritableImage wImage = new WritableImage(tamX, tamY);
		PixelWriter pixelWriter = wImage.getPixelWriter();
		
		Color matrizColor[][] = new Color[tamX][tamY];
		
		Image image = null;
		Color color = null;
		
		image = imageViews.get(0).getImage();
		for(int readX = 0; readX < tamX; readX++){
	        for(int readY = 0; readY < tamY; readY++){
	        	matrizColor[readX][readY] = image.getPixelReader().getColor(readX, readY);
	        }
	    }
		
		image = imageViews.get(1).getImage();
		for(int readX = 0; readX < tamX; readX++){
	        for(int readY = 0; readY < tamY; readY++){
				
				color = image.getPixelReader().getColor(readX, readY);
				
				matrizColor[readX][readY] = UtilsColor.multColor(matrizColor[readX][readY], color);
				
	        	pixelWriter.setColor(readX, readY, matrizColor[readX][readY]);
	        }
	    }
	    
	    paneContent.getChildren().add(createWindowViewImage(new ImageView(wImage), ConstApp.IMAGE_RESULT));
	}
	
	@FXML private void div(ActionEvent event) {
		if(imageViews.size() == 0) return;
				
		WritableImage wImage = new WritableImage(tamX, tamY);
		PixelWriter pixelWriter = wImage.getPixelWriter();
		
		Color matrizColor[][] = new Color[tamX][tamY];
		
		Image image = null;
		Color color = null;
		
		image = imageViews.get(0).getImage();
		for(int readX = 0; readX < tamX; readX++){
	        for(int readY = 0; readY < tamY; readY++){
	        	matrizColor[readX][readY] = image.getPixelReader().getColor(readX, readY);
	        }
	    }
		
		image = imageViews.get(1).getImage();
		for(int readX = 0; readX < tamX; readX++){
	        for(int readY = 0; readY < tamY; readY++){
				
				color = image.getPixelReader().getColor(readX, readY);
				
				matrizColor[readX][readY] = UtilsColor.divColor(matrizColor[readX][readY], color);
				
	        	pixelWriter.setColor(readX, readY, matrizColor[readX][readY]);
	        }
	    }
	    
	    paneContent.getChildren().add(createWindowViewImage(new ImageView(wImage), ConstApp.IMAGE_RESULT));
	}
	
	@FXML private void and(ActionEvent event) {
		if(imageViews.size() == 0) return;
				
		WritableImage wImage = new WritableImage(tamX, tamY);
		PixelWriter pixelWriter = wImage.getPixelWriter();
		
		Color matrizColor[][] = new Color[tamX][tamY];
		
		Image image = null;
		Color color = null;
		
		image = imageViews.get(0).getImage();
		for(int readX = 0; readX < tamX; readX++){
	        for(int readY = 0; readY < tamY; readY++){
	        	matrizColor[readX][readY] = image.getPixelReader().getColor(readX, readY);
	        }
	    }
		
		image = imageViews.get(1).getImage();
		for(int readX = 0; readX < tamX; readX++){
	        for(int readY = 0; readY < tamY; readY++){
				
				color = image.getPixelReader().getColor(readX, readY);
				
				matrizColor[readX][readY] = UtilsColor.andColor(matrizColor[readX][readY], color);
				
	        	pixelWriter.setColor(readX, readY, matrizColor[readX][readY]);
	        }
	    }
	    
	    paneContent.getChildren().add(createWindowViewImage(new ImageView(wImage), ConstApp.IMAGE_RESULT));
	}
	
	@FXML private void or(ActionEvent event) {
		if(imageViews.size() == 0) return;
				
		WritableImage wImage = new WritableImage(tamX, tamY);
		PixelWriter pixelWriter = wImage.getPixelWriter();
		
		Color matrizColor[][] = new Color[tamX][tamY];
		
		Image image = null;
		Color color = null;
		
		image = imageViews.get(0).getImage();
		for(int readX = 0; readX < tamX; readX++){
	        for(int readY = 0; readY < tamY; readY++){
	        	matrizColor[readX][readY] = image.getPixelReader().getColor(readX, readY);
	        }
	    }
		
		image = imageViews.get(1).getImage();
		for(int readX = 0; readX < tamX; readX++){
	        for(int readY = 0; readY < tamY; readY++){
				
				color = image.getPixelReader().getColor(readX, readY);
				
				matrizColor[readX][readY] = UtilsColor.orColor(matrizColor[readX][readY], color);
				
	        	pixelWriter.setColor(readX, readY, matrizColor[readX][readY]);
	        }
	    }
	    
	    paneContent.getChildren().add(createWindowViewImage(new ImageView(wImage), ConstApp.IMAGE_RESULT));
	}
	
	@FXML private void xor(ActionEvent event) {
		if(imageViews.size() == 0) return;
				
		WritableImage wImage = new WritableImage(tamX, tamY);
		PixelWriter pixelWriter = wImage.getPixelWriter();
		
		Color matrizColor[][] = new Color[tamX][tamY];
		
		Image image = null;
		Color color = null;
		
		image = imageViews.get(0).getImage();
		for(int readX = 0; readX < tamX; readX++){
	        for(int readY = 0; readY < tamY; readY++){
	        	matrizColor[readX][readY] = image.getPixelReader().getColor(readX, readY);
	        }
	    }
		
		image = imageViews.get(1).getImage();
		for(int readX = 0; readX < tamX; readX++){
	        for(int readY = 0; readY < tamY; readY++){
				
				color = image.getPixelReader().getColor(readX, readY);
				
				matrizColor[readX][readY] = UtilsColor.xorColor(matrizColor[readX][readY], color);
				
	        	pixelWriter.setColor(readX, readY, matrizColor[readX][readY]);
	        }
	    }
	    
	    paneContent.getChildren().add(createWindowViewImage(new ImageView(wImage), ConstApp.IMAGE_RESULT));
	}
	
	@FXML private void openFile(ActionEvent event) {
		FileChooser fileChooser = new FileChooser();
		File file = fileChooser.showOpenDialog(null);
		BufferedImage bufferedImage = null;
		try {
			bufferedImage = ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
        Image image = SwingFXUtils.toFXImage(bufferedImage, null);
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(tamX);
        imageView.setFitHeight(tamY);
        image = imageView.snapshot(null, null);
        imageView.setImage(image);
        imageViews.add(imageView);
        paneContent.getChildren().add(createWindowViewImage(imageView, ConstApp.IMAGE_OPEN));
	}
	
	private void saveFile(Image img) {
		BufferedImage bufferImg = new BufferedImage((int)img.getWidth(), (int)img.getHeight(), BufferedImage.TYPE_INT_ARGB);
		
		PixelReader pixelReader = img.getPixelReader();
		
		for(int readX = 0; readX < tamX; readX++){
	        for(int readY = 0; readY < tamY; readY++){
	        	bufferImg.setRGB(readX, readY, pixelReader.getArgb(readX, readY));
	        }
	    }
		
		File file = new File("F:\\out.png");
		try {
			ImageIO.write(bufferImg, "png", file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private Window createWindowViewImage(ImageView imageView, int result) {
		Window w = new Window(imageView.getId());
	 	w.getLeftIcons().add(new CloseIcon(w));
	 	
	 	w.setOnCloseAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				ImageView img = (ImageView) w.getContentPane().getChildren().get(0);
				imageViews.remove(img);
				windows.remove(w);
			}
		});;
   
	 	w.setLayoutX(10);
	 	w.setLayoutY(10);
         
	 	w.setPrefSize(imageViews.get(0).getImage().getWidth(), imageViews.get(0).getImage().getHeight());

	 	w.getContentPane().getChildren().add(imageView);
	 	
	 	windows.add(w);
		return w;  
	}
	
	private Optional<String> showDialogAndReturn(String title, String header, String body){
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle(title);
		dialog.setHeaderText(header);
		dialog.setContentText(body);
	
		// Traditional way to get the response value.
		Optional<String> result = dialog.showAndWait();
		
		if(result.isPresent())
			return result;
		else
			return null;
	}
	
	private Pair<String, String> showDialogAndReturnTranslate(String title, String f, String t){
		// Create the custom dialog.
	    Dialog<Pair<String, String>> dialog = new Dialog<>();
	    dialog.setTitle(title);

	    // Set the button types.
	    ButtonType loginButtonType = new ButtonType("OK", ButtonData.OK_DONE);
	    dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

        GridPane gridPane = new GridPane();
	    gridPane.setHgap(10);
	    gridPane.setVgap(10);
	    gridPane.setPadding(new Insets(20, 150, 10, 10));

	    TextField from = new TextField();
	    from.setPromptText(f);
	    TextField to = new TextField();
	    to.setPromptText(t);

	    gridPane.add(from, 0, 0);
	    //gridPane.add(new Label("To:"), 1, 0);
	    gridPane.add(to, 2, 0);

	    dialog.getDialogPane().setContent(gridPane);

	    Platform.runLater(() -> from.requestFocus());

	    dialog.setResultConverter(dialogButton -> {
	        if (dialogButton == loginButtonType) {
	            return new Pair<>(from.getText(), to.getText());
	        }
	        return null;
	    });

	    Optional<Pair<String, String>> result = dialog.showAndWait();
	    
	    return result.get();
	}
	
	@FXML private void openTransform(ActionEvent event) {
		FileChooser fileChooser = new FileChooser();
		File file = fileChooser.showOpenDialog(null);
		BufferedImage bufferedImage = null;
		try {
			bufferedImage = ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
        Image image = SwingFXUtils.toFXImage(bufferedImage, null);
        imgTransform = new ImageView(image);
        paneTransform.getChildren().add(imgTransform);
	}
	
	@FXML private void rotate(ActionEvent event) {
		Optional<String> op = showDialogAndReturn("Rotação", "Informe o grau de rotação(0-360)", "Valor:");
		imgTransform.setRotate(-1*(Integer.parseInt(op.get()))+imgTransform.getRotate());
	}
	
	@FXML private void scale(ActionEvent event) {
		Optional<String> op = showDialogAndReturn("Escala", "Informe a escala...", "Valor:");
		double s = Double.parseDouble(op.get());
		imgTransform.setScaleX(s);
		imgTransform.setScaleY(s);
		imgTransform.setScaleZ(s);
	}
	
	@FXML private void reflect(ActionEvent event) {
		//Optional<String> op = showDialogAndReturn("Reflexão", "Informe o valor", "Valor:");
		//double s = Double.parseDouble(op.get());
		imgTransform.setEffect(new Reflection());
	}
	
	@FXML private void shear(ActionEvent event) {
		Pair<String, String> pair = showDialogAndReturnTranslate("Cisalhamento", "X", "Y");
		
		if(pair != null) {
			imgTransform.getTransforms().add(new Shear(
					Double.parseDouble(pair.getKey()), 
					Double.parseDouble(pair.getValue())));
		}
	}
	
	@FXML private void translate(ActionEvent event) {
		Pair<String, String> pair = showDialogAndReturnTranslate("Translação", "X", "Y");
		
		if(pair != null) {
			imgTransform.setTranslateX(Double.parseDouble(pair.getKey()));
			imgTransform.setTranslateY(Double.parseDouble(pair.getValue()));
		}
	}
	
	@FXML private void reset(ActionEvent event) {
		paneContent.getChildren().clear();
		paneTransform.getChildren().clear();
	}
	
	@FXML private void pseudocolor1(ActionEvent event) {
		if(imageViews.size() == 0) return;
		
		WritableImage wImage = new WritableImage(tamX, tamY);
		PixelWriter pixelWriter = wImage.getPixelWriter();
		PixelReader pixelReader = imageViews.get(0).getImage().getPixelReader();
		
		int value;
		
		for(int readX = 0; readX < tamX; readX++){
	        for(int readY = 0; readY < tamY; readY++){
	        	value = (int) (pixelReader.getColor(readX, readY).getBlue() * 255);
	        	if(value >= 0 && value <= 60) {
	        		pixelWriter.setColor(readX, readY, Color.rgb(51, 255, 51));
	        	}else if(value >= 61 && value <= 120) {
	        		pixelWriter.setColor(readX, readY, Color.rgb(255, 51, 255));
	        	}else if(value >= 121 && value <= 180) {
	        		pixelWriter.setColor(readX, readY, Color.rgb(51, 255, 255));
	        	}else if(value >= 181 && value <= 255) {
	        		pixelWriter.setColor(readX, readY, Color.rgb(255, 102, 51));
	        	}
	        }
	    }
		
	    paneContent.getChildren().add(createWindowViewImage(new ImageView(wImage), ConstApp.IMAGE_RESULT));
	}
	
	@FXML private void pseudocolor2(ActionEvent event) {
		if(imageViews.size() == 0) return;
		
		WritableImage wImage = new WritableImage(tamX, tamY);
		PixelWriter pixelWriter = wImage.getPixelWriter();
		PixelReader pixelReader = imageViews.get(0).getImage().getPixelReader();
		
		int value;
		
		for(int readX = 0; readX < tamX; readX++){
	        for(int readY = 0; readY < tamY; readY++){
	        	value = (int) (pixelReader.getColor(readX, readY).getBlue() * 255);
	        	if(value >= 0 && value <= 30) {
	        		pixelWriter.setColor(readX, readY, Color.rgb(0,255,255));
	        	}else if(value >= 31 && value <= 60) {
	        		pixelWriter.setColor(readX, readY, Color.rgb(0,206,209));
	        	}else if(value >= 61 && value <= 90) {
	        		pixelWriter.setColor(readX, readY, Color.rgb(64,224,208));
	        	}else if(value >= 91 && value <= 120) {
	        		pixelWriter.setColor(readX, readY, Color.rgb(72,209,204));
	        	}else if(value >= 121 && value <= 150) {
	        		pixelWriter.setColor(readX, readY, Color.rgb(32,178,170));
	        	}else if(value >= 151 && value <= 180) {
	        		pixelWriter.setColor(readX, readY, Color.rgb(0,139,139));
	        	}else if(value >= 181 && value <= 210) {
	        		pixelWriter.setColor(readX, readY, Color.rgb(0,128,128));
	        	}else if(value >= 211 && value <= 255) {
	        		pixelWriter.setColor(readX, readY, Color.rgb(127,255,212));
	        	}
	        }
	    }
		
	    paneContent.getChildren().add(createWindowViewImage(new ImageView(wImage), ConstApp.IMAGE_RESULT));
	}
	
	@FXML private void pseudocolor3(ActionEvent event) {
		if(imageViews.size() == 0) return;
		
		WritableImage wImage = new WritableImage(tamX, tamY);
		PixelWriter pixelWriter = wImage.getPixelWriter();
		PixelReader pixelReader = imageViews.get(0).getImage().getPixelReader();
		
		int value;
		
		for(int readX = 0; readX < tamX; readX++){
	        for(int readY = 0; readY < tamY; readY++){
	        	value = (int) (pixelReader.getColor(readX, readY).getBlue() * 255);
	        	if(value >= 0 && value <= 30) {
	        		pixelWriter.setColor(readX, readY, Color.rgb(0,0,255));
	        	}else if(value >= 31 && value <= 60) {
	        		pixelWriter.setColor(readX, readY, Color.rgb(0,0,139));
	        	}else if(value >= 61 && value <= 90) {
	        		pixelWriter.setColor(readX, readY, Color.rgb(0,191,255));
	        	}else if(value >= 91 && value <= 120) {
	        		pixelWriter.setColor(readX, readY, Color.rgb(30,144,255));
	        	}else if(value >= 121 && value <= 150) {
	        		pixelWriter.setColor(readX, readY, Color.rgb(72,209,204));
	        	}else if(value >= 151 && value <= 180) {
	        		pixelWriter.setColor(readX, readY, Color.rgb(32,178,170));
	        	}else if(value >= 181 && value <= 210) {
	        		pixelWriter.setColor(readX, readY, Color.rgb(0,250,154));
	        	}else if(value >= 211 && value <= 255) {
	        		pixelWriter.setColor(readX, readY, Color.rgb(218,165,32));
	        	}
	        }
	    }
		
	    paneContent.getChildren().add(createWindowViewImage(new ImageView(wImage), ConstApp.IMAGE_RESULT));
	}
	
	@FXML private void espacoRGB(ActionEvent event) {
		if(imageViews.size() == 0) return;
		
		WritableImage wImageR = new WritableImage(tamX, tamY);
		WritableImage wImageG = new WritableImage(tamX, tamY);
		WritableImage wImageB = new WritableImage(tamX, tamY);
		PixelWriter pixelWriterR = wImageR.getPixelWriter();
		PixelWriter pixelWriterG = wImageG.getPixelWriter();
		PixelWriter pixelWriterB = wImageB.getPixelWriter();
		PixelReader pixelReader = imageViews.get(0).getImage().getPixelReader();
		
		Color color = null;
		for(int readX = 0; readX < tamX; readX++){
	        for(int readY = 0; readY < tamY; readY++){
	        	color = pixelReader.getColor(readX, readY);
	        	pixelWriterR.setColor(readX, readY, new Color(color.getRed(), 0, 0, color.getOpacity()));
	        	pixelWriterG.setColor(readX, readY, new Color(0, color.getGreen(), 0, color.getOpacity()));
	        	pixelWriterB.setColor(readX, readY, new Color(0, 0, color.getBlue(), color.getOpacity()));
	        }
	    }
	    
	    paneContent.getChildren().add(createWindowViewImage(new ImageView(wImageR), ConstApp.IMAGE_RESULT));
	    paneContent.getChildren().add(createWindowViewImage(new ImageView(wImageG), ConstApp.IMAGE_RESULT));
	    paneContent.getChildren().add(createWindowViewImage(new ImageView(wImageB), ConstApp.IMAGE_RESULT));
	}
	
	@FXML private void espacoHSB(ActionEvent event) {
		if(imageViews.size() == 0) return;
		
		WritableImage wImageR = new WritableImage(tamX, tamY);
		WritableImage wImageG = new WritableImage(tamX, tamY);
		WritableImage wImageB = new WritableImage(tamX, tamY);
		PixelWriter pixelWriterR = wImageR.getPixelWriter();
		PixelWriter pixelWriterG = wImageG.getPixelWriter();
		PixelWriter pixelWriterB = wImageB.getPixelWriter();
		PixelReader pixelReader = imageViews.get(0).getImage().getPixelReader();
		
		Color color = null;
		for(int readX = 0; readX < tamX; readX++){
	        for(int readY = 0; readY < tamY; readY++){
	        	color = pixelReader.getColor(readX, readY);
	        	pixelWriterR.setColor(readX, readY, Color.hsb(color.getHue(), 0, color.getBrightness(), color.getOpacity()));
	        	pixelWriterG.setColor(readX, readY, Color.hsb(0, color.getSaturation(), color.getBrightness(), color.getOpacity()));
	        	pixelWriterB.setColor(readX, readY, Color.hsb(0, 0, color.getBrightness(), color.getOpacity()));
	        }
	    }
	    
	    paneContent.getChildren().add(createWindowViewImage(new ImageView(wImageR), ConstApp.IMAGE_RESULT));
	    paneContent.getChildren().add(createWindowViewImage(new ImageView(wImageG), ConstApp.IMAGE_RESULT));
	    paneContent.getChildren().add(createWindowViewImage(new ImageView(wImageB), ConstApp.IMAGE_RESULT));
	}
	
	@FXML private void espacoYUV(ActionEvent event) {
		if(imageViews.size() == 0) return;
		
		WritableImage wImageY = new WritableImage(tamX, tamY);
		WritableImage wImageU = new WritableImage(tamX, tamY);
		WritableImage wImageV = new WritableImage(tamX, tamY);
		PixelWriter pixelWriterY = wImageY.getPixelWriter();
		PixelWriter pixelWriterU = wImageU.getPixelWriter();
		PixelWriter pixelWriterV = wImageV.getPixelWriter();
		PixelReader pixelReader = imageViews.get(0).getImage().getPixelReader();
		
		Color color = null;
		double y;
		double r, g, b;
		for(int readX = 0; readX < tamX; readX++){
	        for(int readY = 0; readY < tamY; readY++){
	        	color = pixelReader.getColor(readX, readY);
	        	r = color.getRed();
	        	g =  color.getGreen();
	        	b = color.getBlue();
	        	y = (0.299*r)+(0.587*g)+(0.114*b);
	        	//u = 0.492*(b - y);
	        	//v = 0.877*(r - y);
	        	pixelWriterY.setColor(readX, readY, new Color(y, y, y, color.getOpacity()));
	        	pixelWriterU.setColor(readX, readY, new Color(0, y, y, color.getOpacity()));
	        	pixelWriterV.setColor(readX, readY, new Color(y, y, 0, color.getOpacity()));
	        }
	    }
	    
	    paneContent.getChildren().add(createWindowViewImage(new ImageView(wImageY), ConstApp.IMAGE_RESULT));
	    paneContent.getChildren().add(createWindowViewImage(new ImageView(wImageU), ConstApp.IMAGE_RESULT));
	    paneContent.getChildren().add(createWindowViewImage(new ImageView(wImageV), ConstApp.IMAGE_RESULT));
	}
	
	@FXML private void espacoCMYK(ActionEvent event) {
		if(imageViews.size() == 0) return;
		
		WritableImage wImageC = new WritableImage(tamX, tamY);
		WritableImage wImageM = new WritableImage(tamX, tamY);
		WritableImage wImageY = new WritableImage(tamX, tamY);
		WritableImage wImageK = new WritableImage(tamX, tamY);
		PixelWriter pixelWriterC = wImageC.getPixelWriter();
		PixelWriter pixelWriterM = wImageM.getPixelWriter();
		PixelWriter pixelWriterY = wImageY.getPixelWriter();
		PixelWriter pixelWriterK = wImageK.getPixelWriter();
		PixelReader pixelReader = imageViews.get(0).getImage().getPixelReader();
		
		Color color = null;
		double c, m, y, k;
		for(int readX = 0; readX < tamX; readX++){
	        for(int readY = 0; readY < tamY; readY++){
	        	color = pixelReader.getColor(readX, readY);
	        	
	        	k = 1 - Double.max(Double.max(color.getRed(), color.getGreen()), color.getBlue());
	        	c = (1-color.getRed()-k)/(1-k);
	        	m = (1-color.getGreen()-k)/(1-k);
	        	y = (1-color.getBlue()-k)/(1-k);
	        	
	        	pixelWriterC.setColor(readX, readY, new Color(0, c, c, color.getOpacity()));
	        	pixelWriterM.setColor(readX, readY, new Color(m, 0, m, color.getOpacity()));
	        	pixelWriterY.setColor(readX, readY, new Color(y, y, 0, color.getOpacity()));
	        	pixelWriterK.setColor(readX, readY, new Color(k, k, k, color.getOpacity()));
	        }
	    }
	    
	    paneContent.getChildren().add(createWindowViewImage(new ImageView(wImageC), ConstApp.IMAGE_RESULT));
	    paneContent.getChildren().add(createWindowViewImage(new ImageView(wImageM), ConstApp.IMAGE_RESULT));
	    paneContent.getChildren().add(createWindowViewImage(new ImageView(wImageY), ConstApp.IMAGE_RESULT));
	    paneContent.getChildren().add(createWindowViewImage(new ImageView(wImageK), ConstApp.IMAGE_RESULT));
	}
	
	// REALCE
	
	@FXML private void realceNegativa(ActionEvent event) {
		if(imageViews.size() == 0) return;
		
		WritableImage wImage = new WritableImage(tamX, tamY);
		
		PixelWriter pixelWriter = wImage.getPixelWriter();
		
		PixelReader pixelReader = imageViews.get(0).getImage().getPixelReader();
		
		Color color = null;
		for(int readX = 0; readX < tamX; readX++){
	        for(int readY = 0; readY < tamY; readY++){
	        	color = pixelReader.getColor(readX, readY);
	        	pixelWriter.setColor(readX, readY, UtilsColor.getNegativa(color));
	        }
	    }
	    
	    paneContent.getChildren().add(createWindowViewImage(new ImageView(wImage), ConstApp.IMAGE_RESULT));
	}
	
	@FXML private void realceEscalaDeCinza(ActionEvent event) {
		if(imageViews.size() == 0) return;
		
		Pair<String, String> pair = showDialogAndReturnTranslate("Escala de Cinza", "Min", "Max");
		int gmin = Integer.parseInt(pair.getKey());
		int gmax = Integer.parseInt(pair.getValue());
		
		WritableImage wImage = new WritableImage(tamX, tamY);
		
		PixelWriter pixelWriter = wImage.getPixelWriter();
		
		PixelReader pixelReader = imageViews.get(0).getImage().getPixelReader();
		
		Color color = null;
		int fmin = 255;
		int fmax = 0;
		int aux = 0;
		for(int readX = 0; readX < tamX; readX++){
	        for(int readY = 0; readY < tamY; readY++){
	        	color = pixelReader.getColor(readX, readY).grayscale();
	        	aux = (int) (color.getRed() * 255);
	        	if(fmax < aux) fmax = aux;
	        	if(fmin > aux) fmin = aux;
	        }
	    }
		
		fmin = 50;
		fmax = 150;
		
		double a = (gmax - gmin) / (fmax - fmin) * 1.0;
		System.out.println("Escala de Cinza - Realce");
		System.out.println("Fmin: " + fmin);
		System.out.println("Fmax: " + fmax);
		System.out.println("Gmin: " + gmin);
		System.out.println("Gmax: " + gmax);
		System.out.println("Valor de a: " + a);
		
		for(int readX = 0; readX < tamX; readX++){
	        for(int readY = 0; readY < tamY; readY++){
	        	color = pixelReader.getColor(readX, readY).grayscale();
	        	aux = (int) (color.getRed() * 255);
	        	
	        	aux = ((int) (a * (aux - fmin))) + gmin;
	        	
	        	if(aux > 255) aux = 255;
	        	if(aux < 0) aux = 0;
	        	
	        	pixelWriter.setColor(readX, readY, Color.grayRgb(aux));
	        }
	    }
	    
	    paneContent.getChildren().add(createWindowViewImage(new ImageView(wImage), ConstApp.IMAGE_RESULT));
	}
	
	@FXML private void realceLogaritmo(ActionEvent event) {
		if(imageViews.size() == 0) return;
		
		WritableImage wImage = new WritableImage(tamX, tamY);
		
		PixelWriter pixelWriter = wImage.getPixelWriter();
		
		PixelReader pixelReader = imageViews.get(0).getImage().getPixelReader();
		
		Color color = null;
		int fmax = AppUtils.max(pixelReader, tamX, tamY);
		int f = 0;
		int a = (int)( 255 / Math.log(1 + fmax));
		System.out.println("Logaritmo - Realce");
		System.out.println("Fmax: " + fmax);
		System.out.println("Valor de a: " + a);
		
		for(int readX = 0; readX < tamX; readX++){
	        for(int readY = 0; readY < tamY; readY++){
	        	color = pixelReader.getColor(readX, readY).grayscale();
	        	f = (int) (color.getRed() * 255);
	        	
	        	f = (int) (a * Math.log(f + 1));
	        	
	        	if(f > 255) f = 255;
	        	if(f < 0) f = 0;
	        	
	        	pixelWriter.setColor(readX, readY, Color.grayRgb(f));
	        }
	    }
	    
	    paneContent.getChildren().add(createWindowViewImage(new ImageView(wImage), ConstApp.IMAGE_RESULT));
	}
	
	@FXML private void realceRaizQuadrada(ActionEvent event) {
		if(imageViews.size() == 0) return;
		
		WritableImage wImage = new WritableImage(tamX, tamY);
		
		PixelWriter pixelWriter = wImage.getPixelWriter();
		
		PixelReader pixelReader = imageViews.get(0).getImage().getPixelReader();
		
		Color color = null;
		int fmax = AppUtils.max(pixelReader, tamX, tamY);
		int f = 0;
		int a = (int)( 255 / Math.sqrt(1 + fmax));
		System.out.println("Raiz Quadrada - Realce");
		System.out.println("Fmax: " + fmax);
		System.out.println("Valor de a: " + a);
		
		for(int readX = 0; readX < tamX; readX++){
	        for(int readY = 0; readY < tamY; readY++){
	        	color = pixelReader.getColor(readX, readY).grayscale();
	        	f = (int) (color.getRed() * 255);
	        	
	        	f = (int) (a * Math.sqrt(f));
	        	
	        	if(f > 255) f = 255;
	        	if(f < 0) f = 0;
	        	
	        	pixelWriter.setColor(readX, readY, Color.grayRgb(f));
	        }
	    }
	    
	    paneContent.getChildren().add(createWindowViewImage(new ImageView(wImage), ConstApp.IMAGE_RESULT));
	}
	
	@FXML private void realceExponencial(ActionEvent event) {
		if(imageViews.size() == 0) return;
		
		WritableImage wImage = new WritableImage(tamX, tamY);
		
		PixelWriter pixelWriter = wImage.getPixelWriter();
		
		PixelReader pixelReader = imageViews.get(0).getImage().getPixelReader();
		
		Color color = null;
		int fmax = AppUtils.max(pixelReader, tamX, tamY);
		int f = 0;
		double a =  255 / (Math.exp(fmax+1)+1);
		System.out.println("Exponencial - Realce");
		System.out.println("Fmax: " + fmax);
		System.out.println("Valor de a: " + a);
		
		for(int readX = 0; readX < tamX; readX++){
	        for(int readY = 0; readY < tamY; readY++){
	        	color = pixelReader.getColor(readX, readY).grayscale();
	        	f = (int) (color.getRed() * 255);
	        	
	        	f = (int)  (a*(Math.exp(f) + 1));
	        	
	        	if(f > 255) f = 255;
	        	if(f < 0) f = 0;
	        	
	        	pixelWriter.setColor(readX, readY, Color.grayRgb(f));
	        }
	    }
	    
	    paneContent.getChildren().add(createWindowViewImage(new ImageView(wImage), ConstApp.IMAGE_RESULT));
	}
	
	@FXML private void realceQuadrado(ActionEvent event) {
		if(imageViews.size() == 0) return;
		
		WritableImage wImage = new WritableImage(tamX, tamY);
		
		PixelWriter pixelWriter = wImage.getPixelWriter();
		
		PixelReader pixelReader = imageViews.get(0).getImage().getPixelReader();
		
		Color color = null;
		int fmax = AppUtils.max(pixelReader, tamX, tamY);
		int f = 0;
		double a =  255 / (Math.pow(fmax + 1, 2));
		System.out.println("Quadrado - Realce");
		System.out.println("Fmax: " + fmax);
		System.out.println("Valor de a: " + a);
		
		for(int readX = 0; readX < tamX; readX++){
	        for(int readY = 0; readY < tamY; readY++){
	        	color = pixelReader.getColor(readX, readY).grayscale();
	        	f = (int) (color.getRed() * 255);
	        	
	        	f = (int) (a * f * f);
	        	
	        	if(f > 255) f = 255;
	        	if(f < 0) f = 0;
	        	
	        	pixelWriter.setColor(readX, readY, Color.grayRgb(f));
	        }
	    }
	    
	    paneContent.getChildren().add(createWindowViewImage(new ImageView(wImage), ConstApp.IMAGE_RESULT));
	}
	
	@FXML private void realceHistograma(ActionEvent event) {
		if(imageViews.size() == 0) return;
		
		WritableImage wImage = new WritableImage(tamX, tamY);
		
		PixelWriter pixelWriter = wImage.getPixelWriter();
		
		PixelReader pixelReader = imageViews.get(0).getImage().getPixelReader();
		
		double h[] = new double[256];
		for(int i = 0; i < 256; i++) {
			h[i] = 0.0;
		}
		Color color = null;
		int f = 0, Lmaior = 0;
		double n = tamX*tamY;
		for(int readX = 0; readX < tamX; readX++){
	        for(int readY = 0; readY < tamY; readY++){
	        	color = pixelReader.getColor(readX, readY).grayscale();
	        	f = (int) (color.getRed() * 255);
	        	
	        	h[f]++;
	        	if(Lmaior < f) Lmaior = f;
	        }
	    }
		
		histogramaView(h);
		
		h[0] = h[0]/n;
		for(int i = 1; i < 256; i++) {
			h[i] = (h[i]/n) + h[i-1];
 		}
		
		System.out.println("Valor do limiar 1: "+ h[Lmaior]);
		
		
		for(int i = 0; i < 256; i++) {
			h[i] = Math.round(h[i] * Lmaior);
 		}
		
		for(int readX = 0; readX < tamX; readX++){
	        for(int readY = 0; readY < tamY; readY++){
	        	color = pixelReader.getColor(readX, readY).grayscale();
	        	f = (int) (color.getRed() * 255);
	        	
	        	pixelWriter.setColor(readX, readY, Color.grayRgb((int) h[f]));
	        }
	    }
		
		paneContent.getChildren().add(createWindowViewImage(new ImageView(wImage), ConstApp.IMAGE_RESULT));
	
		for(int readX = 0; readX < tamX; readX++){
	        for(int readY = 0; readY < tamY; readY++){
	        	color = pixelReader.getColor(readX, readY).grayscale();
	        	f = (int) (color.getRed() * 255);
	        	
	        	h[f]++;
	        }
	    }
		
		histogramaView(h);
	}
	
	@FXML private void realceCorrecaoGama(ActionEvent event) {
		if(imageViews.size() == 0) return;
		
		Optional<String> op = showDialogAndReturn("Correção Gama", "Informe o valor de correção Y", "Valor:");
		
		WritableImage wImage = new WritableImage(tamX, tamY);
		
		PixelWriter pixelWriter = wImage.getPixelWriter();
		
		PixelReader pixelReader = imageViews.get(0).getImage().getPixelReader();
		
		double h[] = new double[256];
		for(int i = 0; i < 256; i++) {
			h[i] = 0.0;
		}
		Color color = null;
		int p = 0, value;
		for(int readX = 0; readX < tamX; readX++){
	        for(int readY = 0; readY < tamY; readY++){
	        	color = pixelReader.getColor(readX, readY).grayscale();
	        	p = (int) (color.getRed() * 255);
	        	
	        	value = (int) (p * Double.valueOf(op.get()));
	        	
	        	if(value > 255) value = 255;
	        	if(value < 0) value = 0; 
	        	
	        	pixelWriter.setColor(readX, readY, Color.grayRgb(value));
	        }
	    }
		
		paneContent.getChildren().add(createWindowViewImage(new ImageView(wImage), ConstApp.IMAGE_RESULT));
	}
	
	private void histogramaView(double h[]) {
		CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        BarChart<String, Number> bc = 
            new BarChart<String, Number>(xAxis, yAxis);
        xAxis.setLabel("Escala de Cinza");  
        yAxis.setLabel("Pixels");
        
        XYChart.Series series1 = new XYChart.Series();
        for(int i = 0; i < 256; i++) {
        	series1.getData().add(new XYChart.Data(i+"", h[i]));
		}
        
        bc.getData().add(series1);
        bc.setMaxSize(600, 600);
        
        Window w = new Window("Histograma");
	 	w.getLeftIcons().add(new CloseIcon(w));
   
	 	w.setLayoutX(10);
	 	w.setLayoutY(10);
	 	
	 	w.setPrefSize(600, 600);

	 	w.getContentPane().getChildren().add(bc);
	 	
	 	windows.add(w);
	 	
	 	paneContent.getChildren().add(w);
        
	}
	
	//FILTRAGEM
	private void filtroCalculoMedia(int [][] m, int tam) {
		if(imageViews.size() == 0) return;
		
		WritableImage wImage = new WritableImage(tamX, tamY);
		
		PixelWriter pixelWriter = wImage.getPixelWriter();
		
		PixelReader pixelReader = imageViews.get(0).getImage().getPixelReader();
		
		int n = 0;
		for(int i = 0; i < tam; i++) {
			for(int j = 0; j < tam; j++) {
				n += m[i][j];
			}
		}

		Color color = null;
		int p[] = new int[3], value[];
		for(int readX = 0; readX < tamY; readX++){
	        for(int readY = 0; readY < tamX; readY++){
	        	value = new int[3];
	        	for(int i = readX-(tam/2), ii = 0; i <= readX+(tam/2); i++, ii++) {
	        		if(i < 0 || i >= tamY) continue;
	        		for(int j = readY-(tam/2), jj = 0; j <= readY+(tam/2); j++, jj++) {
	        			if(j < 0 || j >= tamX) continue;
	        			color = pixelReader.getColor(j, i);
	        			
	        			p[0] = (int) (color.getRed() * 255);
	        			p[1] = (int) (color.getGreen() * 255);
	        			p[2] = (int) (color.getBlue() * 255);
	        			
	        			value[0] += p[0] * m[ii][jj]/n;
	        			value[1] += p[1] * m[ii][jj]/n;
	        			value[2] += p[2] * m[ii][jj]/n;
	        		}
	        	}
	        	
	        	pixelWriter.setColor(readY, readX, Color.rgb(value[0], value[1], value[2]));
	        }
	    }
		
		saveFile(wImage);
		paneContent.getChildren().add(createWindowViewImage(new ImageView(wImage), ConstApp.IMAGE_RESULT));
	}
	
	private void filtroCalculoVariado(int tam, FiltersType type) {
		if(imageViews.size() == 0) return;
		
		WritableImage wImage = new WritableImage(tamX, tamY);
		
		PixelWriter pixelWriter = wImage.getPixelWriter();
		
		PixelReader pixelReader = imageViews.get(0).getImage().getPixelReader();

		int value;
		List<Integer> array;
		for(int readX = 0; readX < tamY; readX++){
	        for(int readY = 0; readY < tamX; readY++){
	        	value = 0;
	        	array = AppUtils.filterGetArrayOrdened(
	        			pixelReader, 
	        			readX-(tam/2),
	        			readY-(tam/2),
	        			readX+(tam/2),
	        			readY+(tam/2),
	        			tamX,
	        			tamY
	        		);
	        	
	        	switch (type) {
				case MEDIANA:
					value = array.get(array.size()/2);
					break;
				case MODA:
					
					int [] v = new int[256];
					
					for(int i : array) {
						v[i]++;
						if(v[i] > v[value]) {
							value = i;
						}
					}
					
					break;		
				case MINIMO:
					value = array.get(0);
					break;
				case MAXIMO:
					value = array.get(array.size()-1);
					break;
				default:
					break;
				}
	        	pixelWriter.setColor(readX, readY, Color.grayRgb(value));
	        }
	    }
		
		paneContent.getChildren().add(createWindowViewImage(new ImageView(wImage), ConstApp.IMAGE_RESULT));
	}
	
	@FXML private void filtragemMedia3x3(ActionEvent event) {
		int [][] m = {	{1,1,1},
						{1,1,1},
						{1,1,1}};
		
		filtroCalculoMedia(m, 3);
	}
	
	@FXML private void filtragemMedia5x5(ActionEvent event) {
		int [][] m = {	{1,1,1,1,1},
						{1,1,1,1,1},
						{1,1,1,1,1},
						{1,1,1,1,1},
						{1,1,1,1,1}};
		
		filtroCalculoMedia(m, 5);
	}
	
	@FXML private void filtragemMediana3x3(ActionEvent event) {
		filtroCalculoVariado(3, FiltersType.MEDIANA);
	}
	
	@FXML private void filtragemMediana5x5(ActionEvent event) {
		filtroCalculoVariado(5, FiltersType.MEDIANA);
	}
	
	@FXML private void filtragemMax3x3(ActionEvent event) {
		filtroCalculoVariado(3, FiltersType.MAXIMO);
	}
	
	@FXML private void filtragemMin3x3(ActionEvent event) {
		filtroCalculoVariado(3, FiltersType.MINIMO);
	}
	
	@FXML private void filtragemModa(ActionEvent event) {
		filtroCalculoVariado(3, FiltersType.MODA);
	}
	
	//filtros passa alta
	private void calculoKuwahara(int tam) {
		if(imageViews.size() == 0) return;
		
		WritableImage wImage = new WritableImage(tamX, tamY);
		
		PixelWriter pixelWriter = wImage.getPixelWriter();
		
		PixelReader pixelReader = imageViews.get(0).getImage().getPixelReader();

		Color color = null;
		int p = 0, value;
		int [] m = new int[4];
		int [] a = new int[4];
		for(int readX = 0; readX < tamY; readX++){
	        for(int readY = 0; readY < tamX; readY++){
	        	value = 0;
	        	
	        	a[0] = 0; a[1] = 0; a[2] = 0; a[3] = 0;
	        	
	        	m[0] = AppUtils.intensidadeMedia(pixelReader, readX-tam, readY-tam, readX, readY, tamX, tamY);
	        	m[1] = AppUtils.intensidadeMedia(pixelReader, readX-tam, readY, readX, readY+tam, tamX, tamY);
	        	m[2] = AppUtils.intensidadeMedia(pixelReader, readX, readY-tam, readX+tam, readY, tamX, tamY);
	        	m[3] = AppUtils.intensidadeMedia(pixelReader, readX, readY, readX+tam, readY+tam, tamX, tamY);
	        	
	        	for(int i = readX-tam; i <= readX; i++) {
	        		if(i < 0 || i >= tamY) continue;
	        		for(int j = readY-tam; j <= readY; j++) {
	        			if(j < 0 || j >= tamX) continue;
	        			color = pixelReader.getColor(i, j).grayscale();
	        			p = (int) (color.getRed() * 255);
	        			
	        			a[0] += Math.pow(p - m[0], 2);
	        			a[1] += Math.pow(p - m[1], 2);
	        			a[2] += Math.pow(p - m[2], 2);
	        			a[3] += Math.pow(p - m[3], 2);
	        		}
	        	}
	        	
	        	for(int i = 0; i < 4; i++) {
	        		if(a[i] > a[value]) value = i;  
	        	}

	        	pixelWriter.setColor(readX, readY, Color.grayRgb(m[value]));
	        }
	    }
		
		paneContent.getChildren().add(createWindowViewImage(new ImageView(wImage), ConstApp.IMAGE_RESULT));
	}
	
	@FXML private void filtragemKuwahara(ActionEvent event) {
		calculoKuwahara(2);
	}
	
	//filtros passa alta
	private void calculoPassaAlta(int [][] m, int tam) {
		if(imageViews.size() == 0) return;
		
		WritableImage wImage = new WritableImage(tamX, tamY);
		
		PixelWriter pixelWriter = wImage.getPixelWriter();
		
		PixelReader pixelReader = imageViews.get(0).getImage().getPixelReader();

		Color color = null;
		int p = 0, value;
		for(int readX = 0; readX < tamY; readX++){
	        for(int readY = 0; readY < tamX; readY++){
	        	value = 0;
	        	for(int i = readX-(tam/2), ii = 0; i <= readX+(tam/2); i++, ii++) {
	        		if(i < 0 || i >= tamY) continue;
	        		for(int j = readY-(tam/2), jj = 0; j <= readY+(tam/2); j++, jj++) {
	        			if(j < 0 || j >= tamX) continue;
	        			color = pixelReader.getColor(i, j).grayscale();
	        			p = (int) (color.getRed() * 255);
	        			
	        			value += p * m[ii][jj];
	        		}
	        	}
	        	
	        	if(value < 0) value = 0;
	        	if(value > 255) value = 255;
	        	
	        	pixelWriter.setColor(readX, readY, Color.grayRgb(value));
	        }
	    }
		
		paneContent.getChildren().add(createWindowViewImage(new ImageView(wImage), ConstApp.IMAGE_RESULT));
	}
	
	
	@FXML private void filtragemPassaAltaH1(ActionEvent event) {
		int [][] m = {	{0,-1,0},
						{-1,4,-1},
						{0,-1,0},
					};
		
		calculoPassaAlta(m, 3);
	}
	
	@FXML private void filtragemPassaAltaH2(ActionEvent event) {
		int [][] m = {	{-1,-1,-1},
						{-1,8,-1},
						{-1,-1,-1},
					};
		
		calculoPassaAlta(m, 3);
	}
	
	@FXML private void filtragemPassaAltaM1(ActionEvent event) {
		int [][] m = {	{-1,-1,-1},
						{-1, 9,-1},
						{-1,-1,-1},
					};
		
		calculoPassaAlta(m, 3);
	}
	
	@FXML private void filtragemPassaAltaM2(ActionEvent event) {
		int [][] m = {	{1,-2,1},
						{-2,5,-2},
						{1,-2,1},
					};
		
		calculoPassaAlta(m, 3);
	}
	
	@FXML private void filtragemPassaAltaM3(ActionEvent event) {
		int [][] m = {	{0,-1,0},
						{-1,5,-1},
						{0,-1,0},
					};
		
		calculoPassaAlta(m, 3);
	}
	
	@FXML private void filtragemPassaAltaHighBoost(ActionEvent event) {
		int [][] m = {	{-1,-1,-1},
						{-1,0,-1},
						{-1,-1,-1},
					};
		
		Optional<String> op = showDialogAndReturn("Passa-Altas", "Informe o Fator de Amplificação", "Valor:");
		
		m[1][1] = (int) (9*Double.valueOf(op.get()) - 1);
		
		calculoPassaAlta(m, 3);
	}
	
	private void calculoMeiosTonsOrdenado(int [][] m, int width, int height) {
		if(imageViews.size() == 0) return;
		
		WritableImage wImage = new WritableImage(tamX, tamY);
		
		PixelWriter pixelWriter = wImage.getPixelWriter();
		
		PixelReader pixelReader = imageViews.get(0).getImage().getPixelReader();

		Color color = null;
		int value;
		double valueM, valueP;
		for(int readX = 0; readX < tamY; readX++){
	        for(int readY = 0; readY < tamX; readY++){
	        	color = pixelReader.getColor(readX, readY).grayscale();
	        	valueP = color.getRed();
	        	valueM = ((m[readX % height][readY % width] * 1.0) / (height*width));
	        	
	        	value = valueP < valueM ? 0 : 255;
	        			
	        	pixelWriter.setColor(readX, readY, Color.grayRgb(value));
	        }
	    }
		
		paneContent.getChildren().add(createWindowViewImage(new ImageView(wImage), ConstApp.IMAGE_RESULT));
	}
	
	@FXML private void filtragemMeiosTons2x2(ActionEvent event) {
		int [][] m = {	{0, 2},
						{3, 1}
					};
		
		calculoMeiosTonsOrdenado(m, 2, 2);
	}
	
	@FXML private void filtragemMeiosTons3x3(ActionEvent event) {
		int [][] m = {	{6, 8, 4},
						{1, 0, 3},
						{5, 2, 7}
					};
		
		calculoMeiosTonsOrdenado(m, 3, 3);
	}
	
	@FXML private void filtragemMeiosTons2x3(ActionEvent event) {
		int [][] m = {	{3, 0, 4},
						{5, 2, 1}
					};
		
		calculoMeiosTonsOrdenado(m, 3, 2);
	}
	
	private void getTablePixelsGray(PixelReader pixels, int [][] m, int tX, int tY) {
		Color color;
		for(int readX = 0; readX < tX; readX++){
	        for(int readY = 0; readY < tY; readY++){
	        	color = pixels.getColor(readX, readY).grayscale();
	        	m[readX][readY] = (int) (color.getRed() * 255);
	        }
		}
	}
	
	@FXML private void filtragemMeiosTonsFloydSteinberg(ActionEvent event) {
		if(imageViews.size() == 0) return;
		
		WritableImage wImage = new WritableImage(tamX, tamY);
		
		PixelWriter pixelWriter = wImage.getPixelWriter();
		
		PixelReader pixelReader = imageViews.get(0).getImage().getPixelReader();
		
		int [][] m = new int[tamX][tamY];
		
		getTablePixelsGray(pixelReader, m, tamX, tamY);
		
		int value, erro;
		for(int i = 0 ; i < tamX; i++) {
			for(int j = 0; j < tamY; j++) {
				value = m[i][j] < 128 ? 0 : 1; 
				pixelWriter.setColor(i, j, Color.gray(value));
				
				erro = m[i][j] - value * 255;
				
				if(i+1 < tamX) m[i+1][j] += (7/16) * erro;
				
				if(i-1 >= 0 && j+1 < tamY) m[i-1][j+1] += (3/16) * erro;
				
				if(j+1 < tamY) m[i][j+1] += (5/16) * erro;
				
				if(i+1 < tamX && j+1 < tamY) m[i+1][j+1] += (1/16)*erro;
			}
		}
		
		paneContent.getChildren().add(createWindowViewImage(new ImageView(wImage), ConstApp.IMAGE_RESULT));
	}
	
	//SEGMENTAÇÃO
	
	private void calculoDetectacaoDePontosERetas(int [][] m, int tam, int limiar) {
		if(imageViews.size() == 0) return;
		
		WritableImage wImage = new WritableImage(tamX, tamY);
		
		PixelWriter pixelWriter = wImage.getPixelWriter();
		
		PixelReader pixelReader = imageViews.get(0).getImage().getPixelReader();

		Color color = null;
		int p = 0, value;
		for(int readX = 0; readX < tamY; readX++){
	        for(int readY = 0; readY < tamX; readY++){
	        	value = 0;
	        	for(int i = readX-(tam/2), ii = 0; i <= readX+(tam/2); i++, ii++) {
	        		if(i < 0 || i >= tamY) continue;
	        		for(int j = readY-(tam/2), jj = 0; j <= readY+(tam/2); j++, jj++) {
	        			if(j < 0 || j >= tamX) continue;
	        			color = pixelReader.getColor(i, j).grayscale();
	        			p = (int) (color.getRed() * 255);
	        			
	        			value += p * m[ii][jj];
	        		}
	        	}
	        	
	        	if(value >= limiar)
	        		value = 255;
	        	else 
	        		value = 0;
	        	
	        	
	        	pixelWriter.setColor(readX, readY, Color.grayRgb(value));
	        }
	    }
		
		paneContent.getChildren().add(createWindowViewImage(new ImageView(wImage), ConstApp.IMAGE_RESULT));
	}
	
	@FXML private void segmentacaoDetectacaoDePontos(ActionEvent event) {
		int [][] m = {	{-1,-1,-1},
						{-1,8,-1},
						{-1,-1,-1},
					};
		
		Optional<String> op = showDialogAndReturn("Detectação de Pontos", "Informe o T", "Valor:");
		
		calculoDetectacaoDePontosERetas(m, 3, Integer.valueOf(op.get()));
	}
	
	@FXML private void segmentacaoDetectacaoDeRetasHorizontal(ActionEvent event) {
		int [][] m = {	{-1,-1,-1},
						{2, 2, 2},
						{-1,-1,-1},
					};
		
		Optional<String> op = showDialogAndReturn("Detectação de Retas", "Informe o T", "Valor:");
		
		calculoDetectacaoDePontosERetas(m, 3, Integer.valueOf(op.get()));
	}
	
	@FXML private void segmentacaoDetectacaoDeRetas45(ActionEvent event) {
		int [][] m = {	{-1,-1, 2},
						{-1, 2,-1},
						{2, -1,-1},
					};
		
		Optional<String> op = showDialogAndReturn("Detectação de Retas", "Informe o T", "Valor:");
		
		calculoDetectacaoDePontosERetas(m, 3, Integer.valueOf(op.get()));
	}
	
	@FXML private void segmentacaoDetectacaoDeRetasVertical(ActionEvent event) {
		int [][] m = {	{-1,2,-1},
						{-1,2,-1},
						{-1,2,-1},
					};
		
		Optional<String> op = showDialogAndReturn("Detectação de Retas", "Informe o T", "Valor:");
		
		calculoDetectacaoDePontosERetas(m, 3, Integer.valueOf(op.get()));
	}
	
	@FXML private void segmentacaoDetectacaoDeRetas135(ActionEvent event) {
		int [][] m = {	{2,-1,-1},
						{-1,2,-1},
						{-1,-1,2},
					};
		
		Optional<String> op = showDialogAndReturn("Detectação de Retas", "Informe o T", "Valor:");
		
		calculoDetectacaoDePontosERetas(m, 3, Integer.valueOf(op.get()));
	}
	
	private void calculoDetectacaoDeBordas2x2(int [][] mGx, int [][] mGy) {
		if(imageViews.size() == 0) return;
		
		WritableImage wImage = new WritableImage(tamX, tamY);
		
		PixelWriter pixelWriter = wImage.getPixelWriter();
		
		PixelReader pixelReader = imageViews.get(0).getImage().getPixelReader();

		Color color = null;
		int p = 0, value;
		int vGx, vGy;
		for(int readX = 0; readX < tamY; readX++){
	        for(int readY = 0; readY < tamX; readY++){
	        	value = 0; vGx = 0; vGy = 0;
	        	for(int i = readX, ii = 0; i <= readX+1; i++, ii++) {
	        		if(i >= tamY) continue;
	        		for(int j = readY, jj = 0; j <= readY+1; j++, jj++) {
	        			if(j >= tamX) continue;
	        			color = pixelReader.getColor(i, j).grayscale();
	        			p = (int) (color.getRed() * 255);
	        			
	        			vGx += p * mGx[ii][jj];
	        			vGy += p * mGy[ii][jj];
	        		}
	        	}
	        	
	        	value = Math.abs(vGx) + Math.abs(vGy);
	        	
	        	if(value > 255) value = 255;
	        	if(value < 0) value = 0;
	        	
	        	pixelWriter.setColor(readX, readY, Color.grayRgb(value));
	        }
	    }
		
		paneContent.getChildren().add(createWindowViewImage(new ImageView(wImage), ConstApp.IMAGE_RESULT));
	}
	
	@FXML private void segmentacaoDetectacaoDeBordasRobertsCruzado(ActionEvent event) {
		int [][] mGx = {{1, 0},
						{0, -1}
					};
		
		int [][] mGy = {{0, 1},
				{-1, 0}
			};
		
		calculoDetectacaoDeBordas2x2(mGx, mGy);
	}
	
	@FXML private void segmentacaoDetectacaoDeBordasRoberts(ActionEvent event) {
		int [][] mGx = {{1, 0},
						{-1, 0}
					};
		
		int [][] mGy = {{1, -1},
				{0, 0}
			};
		
		calculoDetectacaoDeBordas2x2(mGx, mGy);
	}
	
	private void calculoDetectacaoDeBordas3x3(int [][] mGx, int [][] mGy) {
		if(imageViews.size() == 0) return;
		
		WritableImage wImage = new WritableImage(tamX, tamY);
		
		PixelWriter pixelWriter = wImage.getPixelWriter();
		
		PixelReader pixelReader = imageViews.get(0).getImage().getPixelReader();

		Color color = null;
		int p = 0, value;
		int vGx, vGy;
		for(int readX = 0; readX < tamY; readX++){
	        for(int readY = 0; readY < tamX; readY++){
	        	value = 0; vGx = 0; vGy = 0;
	        	for(int i = readX-1, ii = 0; i <= readX+1; i++, ii++) {
	        		if(i < 0 || i >= tamY) continue;
	        		for(int j = readY-1, jj = 0; j <= readY+1; j++, jj++) {
	        			if(j < 0 || j >= tamX) continue;
	        			color = pixelReader.getColor(i, j).grayscale();
	        			p = (int) (color.getRed() * 255);
	        			
	        			vGx += p * mGx[ii][jj];
	        			vGy += p * mGy[ii][jj];
	        		}
	        	}
	        	
	        	value = Math.abs(vGx) + Math.abs(vGy);
	        	
	        	if(value > 255) value = 255;
	        	if(value < 0) value = 0;
	        	
	        	pixelWriter.setColor(readX, readY, Color.grayRgb(value));
	        }
	    }
		
		paneContent.getChildren().add(createWindowViewImage(new ImageView(wImage), ConstApp.IMAGE_RESULT));
	}
	
	@FXML private void segmentacaoDetectacaoDeBordasPrewiitGx(ActionEvent event) {
		int [][] mGx = {	{-1, 0, 1},
							{-1, 0, 1},
							{-1, 0, 1}
						};
		
		int [][] mGy = {	{0, 0, 0},
							{0, 0, 0},
							{0, 0, 0}
						};
		
		calculoDetectacaoDeBordas3x3(mGx, mGy);
	}
	
	@FXML private void segmentacaoDetectacaoDeBordasPrewiitGy(ActionEvent event) {
		int [][] mGx = {	{0, 0, 0},
							{0, 0, 0},
							{0, 0, 0}
						};

		int [][] mGy = {	{-1, -1, -1},
							{0, 0, 0},
							{1, 1, 1}
						};
		
		calculoDetectacaoDeBordas3x3(mGx, mGy);
	}
	
	@FXML private void segmentacaoDetectacaoDeBordasPrewiitGxGy(ActionEvent event) {
		int [][] mGx = {	{-1, 0, 1},
							{-1, 0, 1},
							{-1, 0, 1}
						};
		
		int [][] mGy = {	{-1, -1, -1},
							{0, 0, 0},
							{1, 1, 1}
						};
		
		calculoDetectacaoDeBordas3x3(mGx, mGy);
	}
	
	@FXML private void segmentacaoDetectacaoDeBordasSobelGx(ActionEvent event) {
		int [][] mGx = {	{-1, 0, 1},
							{-2, 0, 2},
							{-1, 0, 1}
						};
		
		int [][] mGy = {	{0, 0, 0},
							{0, 0, 0},
							{0, 0, 0}
						};
		
		calculoDetectacaoDeBordas3x3(mGx, mGy);
	}
	
	@FXML private void segmentacaoDetectacaoDeBordasSobelGy(ActionEvent event) {
		int [][] mGx = {	{0, 0, 0},
							{0, 0, 0},
							{0, 0, 0}
						};

		int [][] mGy = {	{-1, -2, -1},
							{0, 0, 0},
							{1, 2, 1}
						};
		
		calculoDetectacaoDeBordas3x3(mGx, mGy);
	}
	
	@FXML private void segmentacaoDetectacaoDeBordasSobelGxGy(ActionEvent event) {
		int [][] mGx = {	{-1, 0, 1},
							{-2, 0, 2},
							{-1, 0, 1}
						};
		
		int [][] mGy = {	{-1, -2, -1},
							{0, 0, 0},
							{1, 2, 1}
						};
		
		calculoDetectacaoDeBordas3x3(mGx, mGy);
	}
	
	@FXML private void segmentacaoDetectacaoDeBordasLapracianoH1(ActionEvent event) {
		int [][] mGx = {	{0, -1, 0},
							{-1, 4, -1},
							{0, -1, 0}
						};
		
		int [][] mGy = {	{0, 0, 0},
							{0, 0, 0},
							{0, 0, 0}
						};
		
		calculoDetectacaoDeBordas3x3(mGx, mGy);
	}
	
	@FXML private void segmentacaoDetectacaoDeBordasLapracianoH2(ActionEvent event) {
		int [][] mGx = {	{-1, -4, -1},
							{-4, 20, -4},
							{-1, -4, -1}
						};
		
		int [][] mGy = {	{0, 0, 0},
							{0, 0, 0},
							{0, 0, 0}
						};
		
		calculoDetectacaoDeBordas3x3(mGx, mGy);
	}
	
	@FXML private void limiarizarGlobal(){
		if(imageViews.size() == 0) return;
		
		WritableImage wImage = new WritableImage(tamX, tamY);
		
		PixelWriter pixelWriter = wImage.getPixelWriter();
		
		PixelReader pixelReader = imageViews.get(0).getImage().getPixelReader();
		
		List<Pixel> array = AppUtils.getPixels(pixelReader, tamX, tamY);
		
        List<Pixel> r1 = new ArrayList<>();
        List<Pixel> r2 = new ArrayList<>();
        
        int m1, m2;
        
        int T = AppUtils.intensidadeMedia(pixelReader, tamX, tamY), Ti = T;
        
        do {
        	T = Ti;
		   
			r1.clear();
			r2.clear();
		    
			//Passo 2 - separar pixels
			for (Pixel p : array){
			   if (p.getValueGray() < T)
				   r1.add(p);
			   else 
				   r2.add(p);
		   }
		    
		   //Paasso 3 - media
		   m1 = AppUtils.intensidadeMedia(r1);
		   m2 = AppUtils.intensidadeMedia(r2);
		   
		   //Passo 4 - novo limiar
		   Ti = (m1 + m2) / 2;
		    
		} while (T != Ti);
        
        System.out.println("Valor de T: "+ T + " Valor de Ti: "+ Ti);
		
		for (Pixel p : r1){
			pixelWriter.setColor(p.getX(), p.getY(), Color.grayRgb(0));
		}
		
		for (Pixel p : r2){
			pixelWriter.setColor(p.getX(), p.getY(), Color.grayRgb(255));
		}
		
		paneContent.getChildren().add(createWindowViewImage(new ImageView(wImage), ConstApp.IMAGE_RESULT));
    }
	
}
