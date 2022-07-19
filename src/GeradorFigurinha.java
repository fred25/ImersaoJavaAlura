import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.awt.Color;
import java.awt.Font;

import javax.imageio.ImageIO;

public class GeradorFigurinha {
    

    public void cria(InputStream inputStream, String nomeDoArquivo) throws Exception{

        //leitura da imagem

        //InputStream inputStream = new URL("https://m.media-amazon.com/images/M/MV5BMzE5MDM1NDktY2I0OC00YWI5LTk2NzUtYjczNDczOWQxYjM0XkEyXkFqcGdeQXVyMTQxNzMzNDI@.jpg").openStream();

        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        //cria em memória com transparencia e tamanho novo

        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        //copiar a imagem original pra nova

        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        //definir fonte

        var font = new Font("Comic Sans MS", Font.BOLD, 100);
        graphics.setColor(Color.CYAN);
        graphics.setFont(font);

        //escrever frase na nova imagem

        graphics.drawString("DE CRIA", 100, altura+100);

        //escrever a nova imagem em um arquivo

        ImageIO.write(novaImagem, "png", new File("saida/" + nomeDoArquivo));

    }

}
